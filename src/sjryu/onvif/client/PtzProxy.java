package sjryu.onvif.client;

import java.util.List;
import org.onvif.ver10.schema.FloatRange;
import org.onvif.ver10.schema.PTZConfiguration;
import org.onvif.ver10.schema.PTZNode;
import org.onvif.ver10.schema.PTZPreset;
import org.onvif.ver10.schema.PTZSpaces;
import org.onvif.ver10.schema.PTZSpeed;
import org.onvif.ver10.schema.PTZStatus;
import org.onvif.ver10.schema.PTZVector;
import org.onvif.ver10.schema.Profile;
import org.onvif.ver10.schema.Vector1D;
import org.onvif.ver10.schema.Vector2D;
import org.onvif.ver20.ptz.wsdl.AbsoluteMove;
import org.onvif.ver20.ptz.wsdl.AbsoluteMoveResponse;
import org.onvif.ver20.ptz.wsdl.ContinuousMove;
import org.onvif.ver20.ptz.wsdl.ContinuousMoveResponse;
import org.onvif.ver20.ptz.wsdl.GetNode;
import org.onvif.ver20.ptz.wsdl.GetNodeResponse;
import org.onvif.ver20.ptz.wsdl.GetNodes;
import org.onvif.ver20.ptz.wsdl.GetNodesResponse;
import org.onvif.ver20.ptz.wsdl.GetPresets;
import org.onvif.ver20.ptz.wsdl.GetPresetsResponse;
import org.onvif.ver20.ptz.wsdl.GetStatus;
import org.onvif.ver20.ptz.wsdl.GetStatusResponse;
import org.onvif.ver20.ptz.wsdl.GotoPreset;
import org.onvif.ver20.ptz.wsdl.GotoPresetResponse;
import org.onvif.ver20.ptz.wsdl.RelativeMove;
import org.onvif.ver20.ptz.wsdl.RelativeMoveResponse;
import org.onvif.ver20.ptz.wsdl.RemovePreset;
import org.onvif.ver20.ptz.wsdl.RemovePresetResponse;
import org.onvif.ver20.ptz.wsdl.SetHomePosition;
import org.onvif.ver20.ptz.wsdl.SetHomePositionResponse;
import org.onvif.ver20.ptz.wsdl.SetPreset;
import org.onvif.ver20.ptz.wsdl.SetPresetResponse;
import org.onvif.ver20.ptz.wsdl.Stop;
import org.onvif.ver20.ptz.wsdl.StopResponse;

public class PtzProxy extends OnvifProxy
{
	protected PtzProxy(String xAddr, SoapClientSecurity security)
	{
		super("http://www.onvif.org/ver20/ptz/wsdl", xAddr, security);
	}

	public boolean isPtzOperationsSupported(Profile profile)
	{
		if (profile.getPTZConfiguration() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public List<PTZNode> GetNodes() throws Exception
	{
		GetNodes request = new GetNodes();
		GetNodesResponse response = null;

		response = request(request, GetNodesResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getPTZNode();
	}

	public PTZNode GetNode(PTZConfiguration ptzConfiguration) throws Exception
	{
		if (ptzConfiguration == null)
		{
			return null; // no PTZ support
		}

		GetNode request = new GetNode();
		GetNodeResponse response = null;

		request.setNodeToken(ptzConfiguration.getNodeToken());

		response = request(request, GetNodeResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getPTZNode();
	}

	public FloatRange getPanSpaces(PTZNode node) throws Exception
	{
		PTZSpaces ptzSpaces = node.getSupportedPTZSpaces();
		return ptzSpaces.getAbsolutePanTiltPositionSpace().get(0).getXRange();
	}

	public FloatRange getTiltSpaces(PTZNode node) throws Exception
	{
		PTZSpaces ptzSpaces = node.getSupportedPTZSpaces();
		return ptzSpaces.getAbsolutePanTiltPositionSpace().get(0).getYRange();
	}

	public FloatRange getZoomSpaces(PTZNode node) throws Exception
	{
		PTZSpaces ptzSpaces = node.getSupportedPTZSpaces();
		return ptzSpaces.getAbsoluteZoomPositionSpace().get(0).getXRange();
	}

	public boolean isAbsoluteMoveSupported(Profile profile)
	{
		try
		{
			if (profile.getPTZConfiguration().getDefaultAbsolutePantTiltPositionSpace() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (NullPointerException e)
		{
			return false;
		}
	}

	public boolean AbsoluteMove(String profileToken, PTZNode node, float x, float y, float zoom) throws Exception
	{
		if (node != null)
		{
			FloatRange xRange = node.getSupportedPTZSpaces().getAbsolutePanTiltPositionSpace().get(0).getXRange();
			FloatRange yRange = node.getSupportedPTZSpaces().getAbsolutePanTiltPositionSpace().get(0).getYRange();
			FloatRange zRange = node.getSupportedPTZSpaces().getAbsoluteZoomPositionSpace().get(0).getXRange();

			if (zoom < zRange.getMin() || zoom > zRange.getMax())
			{
				throw new IllegalArgumentException("Bad value for zoom: " + zoom);
			}
			if (x < xRange.getMin() || x > xRange.getMax())
			{
				throw new IllegalArgumentException("Bad value for pan:/x " + x);
			}
			if (y < yRange.getMin() || y > yRange.getMax())
			{
				throw new IllegalArgumentException("Bad value for tilt/y: " + y);
			}
		}

		AbsoluteMove request = new AbsoluteMove();
		AbsoluteMoveResponse response = null;

		Vector2D panTiltVector = new Vector2D();
		panTiltVector.setX(x);
		panTiltVector.setY(y);
		Vector1D zoomVector = new Vector1D();
		zoomVector.setX(zoom);

		PTZVector ptzVector = new PTZVector();
		ptzVector.setPanTilt(panTiltVector);
		ptzVector.setZoom(zoomVector);
		request.setPosition(ptzVector);

		request.setProfileToken(profileToken);

		response = request(request, AbsoluteMoveResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public boolean isRelativeMoveSupported(Profile profile)
	{
		try
		{
			if (profile.getPTZConfiguration().getDefaultRelativePanTiltTranslationSpace() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (NullPointerException e)
		{
			return false;
		}
	}

	public boolean RelativeMove(String profileToken, float x, float y, float zoom) throws Exception
	{
		RelativeMove request = new RelativeMove();
		RelativeMoveResponse response = null;

		Vector2D panTiltVector = new Vector2D();
		panTiltVector.setX(x);
		panTiltVector.setY(y);
		Vector1D zoomVector = new Vector1D();
		zoomVector.setX(zoom);

		PTZVector translation = new PTZVector();
		translation.setPanTilt(panTiltVector);
		translation.setZoom(zoomVector);

		request.setProfileToken(profileToken);
		request.setTranslation(translation);

		response = request(request, RelativeMoveResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public boolean isContinuosMoveSupported(Profile profile)
	{
		try
		{
			if (profile.getPTZConfiguration().getDefaultContinuousPanTiltVelocitySpace() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (NullPointerException e)
		{
			return false;
		}
	}

	public boolean ContinuousMove(String profileToken, float x, float y, float zoom) throws Exception
	{
		ContinuousMove request = new ContinuousMove();
		ContinuousMoveResponse response = null;

		Vector2D panTiltVector = new Vector2D();
		panTiltVector.setX(x);
		panTiltVector.setY(y);
		Vector1D zoomVector = new Vector1D();
		zoomVector.setX(zoom);

		PTZSpeed ptzSpeed = new PTZSpeed();
		ptzSpeed.setPanTilt(panTiltVector);
		ptzSpeed.setZoom(zoomVector);
		request.setVelocity(ptzSpeed);

		request.setProfileToken(profileToken);

		response = request(request, ContinuousMoveResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public boolean Stop(String profileToken) throws Exception
	{
		Stop request = new Stop();
		request.setPanTilt(true);
		request.setZoom(true);
		StopResponse response = null;

		request.setProfileToken(profileToken);

		response = request(request, StopResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public PTZStatus GetStatus(String profileToken) throws Exception
	{
		GetStatus request = new GetStatus();
		GetStatusResponse response = null;

		request.setProfileToken(profileToken);

		response = request(request, GetStatusResponse.class, false);
		if (response == null)
		{
			return null;
		}

		return response.getPTZStatus();
	}

	public boolean SetHomePosition(String profileToken) throws Exception
	{
		SetHomePosition request = new SetHomePosition();
		SetHomePositionResponse response = null;

		request.setProfileToken(profileToken);

		response = request(request, SetHomePositionResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public List<PTZPreset> GetPresets(String profileToken) throws Exception
	{
		GetPresets request = new GetPresets();
		GetPresetsResponse response = null;

		request.setProfileToken(profileToken);

		response = request(request, GetPresetsResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getPreset();
	}

	public String SetPreset(String presetName, String presetToken, String profileToken) throws Exception
	{
		SetPreset request = new SetPreset();
		SetPresetResponse response = null;

		request.setProfileToken(profileToken);
		request.setPresetName(presetName);
		request.setPresetToken(presetToken);

		response = request(request, SetPresetResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getPresetToken();
	}

	public boolean RemovePreset(String presetToken, String profileToken) throws Exception
	{
		RemovePreset request = new RemovePreset();
		RemovePresetResponse response = null;

		request.setProfileToken(profileToken);
		request.setPresetToken(presetToken);

		response = request(request, RemovePresetResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public boolean GotoPreset(String presetToken, String profileToken) throws Exception
	{
		GotoPreset request = new GotoPreset();
		GotoPresetResponse response = null;

		request.setProfileToken(profileToken);
		request.setPresetToken(presetToken);

		response = request(request, GotoPresetResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}
}

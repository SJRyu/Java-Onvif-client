package sjryu.onvif.client;

import org.onvif.ver10.schema.AbsoluteFocus;
import org.onvif.ver10.schema.FocusMove;
import org.onvif.ver10.schema.ImagingSettings20;
import org.onvif.ver20.imaging.wsdl.GetImagingSettings;
import org.onvif.ver20.imaging.wsdl.GetImagingSettingsResponse;
import org.onvif.ver20.imaging.wsdl.Move;
import org.onvif.ver20.imaging.wsdl.MoveResponse;
import org.onvif.ver20.imaging.wsdl.SetImagingSettings;
import org.onvif.ver20.imaging.wsdl.SetImagingSettingsResponse;

public class ImagingProxy extends OnvifProxy
{
	protected ImagingProxy(String xAddr, SoapClientSecurity security)
	{
		super("http://www.onvif.org/ver20/imaging/wsdl", xAddr, security);
	}

	public boolean Move(String videoSourceToken, float absoluteFocusValue) throws Exception
	{
		if (videoSourceToken == null)
		{
			return false;
		}

		Move request = new Move();
		MoveResponse response = null;

		AbsoluteFocus absoluteFocus = new AbsoluteFocus();
		absoluteFocus.setPosition(absoluteFocusValue);

		FocusMove focusMove = new FocusMove();
		focusMove.setAbsolute(absoluteFocus);

		request.setVideoSourceToken(videoSourceToken);
		request.setFocus(focusMove);

		response = request(request, MoveResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public ImagingSettings20 GetImagingSettings(String videoSourceToken) throws Exception
	{
		if (videoSourceToken == null)
		{
			return null;
		}

		GetImagingSettings request = new GetImagingSettings();
		GetImagingSettingsResponse response = null;

		request.setVideoSourceToken(videoSourceToken);

		response = request(request, GetImagingSettingsResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getImagingSettings();
	}

	public boolean SetImagingSettings(String videoSourceToken, ImagingSettings20 imagingSettings) throws Exception
	{
		if (videoSourceToken == null)
		{
			return false;
		}

		SetImagingSettings request = new SetImagingSettings();
		SetImagingSettingsResponse response = null;

		request.setVideoSourceToken(videoSourceToken);
		request.setImagingSettings(imagingSettings);

		response = request(request, SetImagingSettingsResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}
}

package sjryu.onvif.client;

import java.util.List;

import org.onvif.ver10.media.wsdl.CreateProfile;
import org.onvif.ver10.media.wsdl.CreateProfileResponse;
import org.onvif.ver10.media.wsdl.GetProfile;
import org.onvif.ver10.media.wsdl.GetProfileResponse;
import org.onvif.ver10.media.wsdl.GetProfiles;
import org.onvif.ver10.media.wsdl.GetProfilesResponse;
import org.onvif.ver10.media.wsdl.GetSnapshotUri;
import org.onvif.ver10.media.wsdl.GetSnapshotUriResponse;
import org.onvif.ver10.media.wsdl.GetStreamUri;
import org.onvif.ver10.media.wsdl.GetStreamUriResponse;
import org.onvif.ver10.media.wsdl.GetVideoEncoderConfigurationOptions;
import org.onvif.ver10.media.wsdl.GetVideoEncoderConfigurationOptionsResponse;
import org.onvif.ver10.media.wsdl.GetVideoSources;
import org.onvif.ver10.media.wsdl.GetVideoSourcesResponse;
import org.onvif.ver10.media.wsdl.SetVideoEncoderConfiguration;
import org.onvif.ver10.media.wsdl.SetVideoEncoderConfigurationResponse;
import org.onvif.ver10.schema.Profile;
import org.onvif.ver10.schema.StreamSetup;
import org.onvif.ver10.schema.StreamType;
import org.onvif.ver10.schema.Transport;
import org.onvif.ver10.schema.TransportProtocol;
import org.onvif.ver10.schema.VideoEncoderConfiguration;
import org.onvif.ver10.schema.VideoEncoderConfigurationOptions;
import org.onvif.ver10.schema.VideoSource;

public class MediaProxy extends OnvifProxy
{
	protected MediaProxy(String xAddr, SoapClientSecurity security)
	{
		super("http://www.onvif.org/ver10/media/wsdl", xAddr, security);
	}

	public List<Profile> GetProfiles() throws Exception
	{
		GetProfiles request = new GetProfiles();
		GetProfilesResponse response = null;

		response = request(request, GetProfilesResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getProfiles();
	}

	public Profile GetProfile(String profileToken) throws Exception
	{
		GetProfile request = new GetProfile();
		GetProfileResponse response = null;

		request.setProfileToken(profileToken);

		response = request(request, GetProfileResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getProfile();
	}

	public Profile CreateProfile(String name) throws Exception
	{
		CreateProfile request = new CreateProfile();
		CreateProfileResponse response = null;

		request.setName(name);

		response = request(request, CreateProfileResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getProfile();
	}

	public String getHTTPStreamUri(String profileToken) throws Exception
	{
		StreamSetup setup = new StreamSetup();
		setup.setStream(StreamType.RTP_UNICAST);
		Transport transport = new Transport();
		transport.setProtocol(TransportProtocol.HTTP);
		setup.setTransport(transport);
		return GetStreamUri(profileToken, setup);
	}

	public String getUDPStreamUri(String profileToken) throws Exception
	{
		StreamSetup setup = new StreamSetup();
		setup.setStream(StreamType.RTP_UNICAST);
		Transport transport = new Transport();
		transport.setProtocol(TransportProtocol.UDP);
		setup.setTransport(transport);
		return GetStreamUri(profileToken, setup);
	}

	public String getTCPStreamUri(String profileToken) throws Exception
	{
		StreamSetup setup = new StreamSetup();
		setup.setStream(StreamType.RTP_UNICAST);
		Transport transport = new Transport();
		transport.setProtocol(TransportProtocol.TCP);
		setup.setTransport(transport);
		return GetStreamUri(profileToken, setup);
	}

	public String getRTSPStreamUri(String profileToken) throws Exception
	{
		return getUDPStreamUri(profileToken);
	}

	public String GetStreamUri(String profileToken, StreamSetup streamSetup) throws Exception
	{
		GetStreamUri request = new GetStreamUri();
		GetStreamUriResponse response = null;

		request.setProfileToken(profileToken);
		request.setStreamSetup(streamSetup);

		response = request(request, GetStreamUriResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getMediaUri().getUri();

	}

	public VideoEncoderConfigurationOptions GetVideoEncoderConfigurationOptions(String profileToken) throws Exception
	{
		GetVideoEncoderConfigurationOptions request = new GetVideoEncoderConfigurationOptions();
		GetVideoEncoderConfigurationOptionsResponse response = null;

		request.setProfileToken(profileToken);

		response = request(request, GetVideoEncoderConfigurationOptionsResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getOptions();
	}

	public boolean SetVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration) throws Exception
	{
		SetVideoEncoderConfiguration request = new SetVideoEncoderConfiguration();
		SetVideoEncoderConfigurationResponse response = null;

		request.setConfiguration(videoEncoderConfiguration);
		request.setForcePersistence(true);

		response = request(request, SetVideoEncoderConfigurationResponse.class, true);
		if (response == null)
		{
			return false;
		}

		return true;
	}

	public String GetSnapshotUri(String profileToken) throws Exception
	{
		GetSnapshotUri request = new GetSnapshotUri();
		GetSnapshotUriResponse response = null;

		request.setProfileToken(profileToken);

		response = request(request, GetSnapshotUriResponse.class, true);
		if (response == null)
		{
			return null;
		}

		if (response.getMediaUri() == null)
		{
			return null;
		}

		return response.getMediaUri().getUri();
	}

	public List<VideoSource> GetVideoSources() throws Exception
	{
		GetVideoSources request = new GetVideoSources();
		GetVideoSourcesResponse response = null;

		response = request(request, GetVideoSourcesResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getVideoSources();
	}
}

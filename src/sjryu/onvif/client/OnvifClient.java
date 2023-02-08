package sjryu.onvif.client;

import java.util.Date;

import org.onvif.ver10.schema.Capabilities;
import org.onvif.ver10.schema.EventCapabilities;
import org.onvif.ver10.schema.ImagingCapabilities;
import org.onvif.ver10.schema.MediaCapabilities;
import org.onvif.ver10.schema.PTZCapabilities;

public class OnvifClient
{
	private final String address_, ip_;
	private String user_, passwd_;

	private DeviceProxy device_;
	private MediaProxy media_;
	private EventProxy event_;
	private ImagingProxy imaging_;
	private PtzProxy ptz_;

	public OnvifClient(String address, String user, String password) throws Exception
	{
		address_ = address;
		if (address_.contains(":"))
		{
			ip_ = address_.substring(0, address_.indexOf(':'));
		}
		else
		{
			ip_ = address_;
		}

		user_ = user;
		passwd_ = password;

		String XAddr = "http://" + address_ + "/onvif/device_service";
		device_ = new DeviceProxy(XAddr, null);

		Date serverDate = device_.GetSystemDateAndTime();
		SoapClientSecurity security = new SoapClientSecurity(user_, passwd_, serverDate);
		device_.setSecurity(security);

		Capabilities caps = device_.GetCapabilities();

		MediaCapabilities mediaCap = caps.getMedia();
		if (mediaCap != null)
		{
			XAddr = mediaCap.getXAddr();
			XAddr = appendPortNumber(XAddr);
			media_ = new MediaProxy(XAddr, security);
		}

		EventCapabilities eventCap = caps.getEvents();
		if (eventCap != null)
		{
			XAddr = eventCap.getXAddr();
			XAddr = appendPortNumber(XAddr);
			event_ = new EventProxy(XAddr, security);
		}

		ImagingCapabilities imagingCap = caps.getImaging();
		if (imagingCap != null)
		{
			XAddr = imagingCap.getXAddr();
			XAddr = appendPortNumber(XAddr);
			imaging_ = new ImagingProxy(XAddr, security);
		}

		PTZCapabilities ptzCap = caps.getPTZ();
		if (ptzCap != null)
		{
			XAddr = ptzCap.getXAddr();
			XAddr = appendPortNumber(XAddr);
			ptz_ = new PtzProxy(XAddr, security);
		}

	}

	private String appendPortNumber(String XAddr)
	{
		int idx = XAddr.indexOf(address_);
		if (idx < 0)
		{
			return XAddr.replace(ip_, address_);
		}
		else
		{
			return XAddr;
		}
	}

	public String getUser()
	{
		return user_;
	}

	public String getPasswd()
	{
		return passwd_;
	}

	public DeviceProxy getDevice()
	{
		return device_;
	}

	public MediaProxy getMedia()
	{
		return media_;
	}

	public EventProxy getEvent()
	{
		return event_;
	}

	public ImagingProxy getImaging()
	{
		return imaging_;
	}

	public PtzProxy getPtz()
	{
		return ptz_;
	}
}

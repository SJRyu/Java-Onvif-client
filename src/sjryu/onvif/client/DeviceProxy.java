package sjryu.onvif.client;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.onvif.ver10.device.wsdl.GetCapabilities;
import org.onvif.ver10.device.wsdl.GetCapabilitiesResponse;
import org.onvif.ver10.device.wsdl.GetDeviceInformation;
import org.onvif.ver10.device.wsdl.GetDeviceInformationResponse;
import org.onvif.ver10.device.wsdl.GetHostname;
import org.onvif.ver10.device.wsdl.GetHostnameResponse;
import org.onvif.ver10.device.wsdl.GetScopes;
import org.onvif.ver10.device.wsdl.GetScopesResponse;
import org.onvif.ver10.device.wsdl.GetServices;
import org.onvif.ver10.device.wsdl.GetServicesResponse;
import org.onvif.ver10.device.wsdl.GetSystemDateAndTime;
import org.onvif.ver10.device.wsdl.GetSystemDateAndTimeResponse;
import org.onvif.ver10.device.wsdl.GetUsers;
import org.onvif.ver10.device.wsdl.GetUsersResponse;
import org.onvif.ver10.device.wsdl.Service;
import org.onvif.ver10.device.wsdl.SetHostname;
import org.onvif.ver10.device.wsdl.SetHostnameResponse;
import org.onvif.ver10.device.wsdl.SystemReboot;
import org.onvif.ver10.device.wsdl.SystemRebootResponse;
import org.onvif.ver10.schema.Capabilities;
import org.onvif.ver10.schema.Date;
import org.onvif.ver10.schema.Scope;
import org.onvif.ver10.schema.Time;
import org.onvif.ver10.schema.User;

public class DeviceProxy extends OnvifProxy
{
	protected DeviceProxy(String xAddr, SoapClientSecurity security) 
	{
		super("http://www.onvif.org/ver10/device/wsdl", xAddr, security);
	}

	public java.util.Date GetSystemDateAndTime() throws Exception 
	{
		Calendar cal = null;

		GetSystemDateAndTimeResponse response = null;

		try
		{
			response = request(new GetSystemDateAndTime(), GetSystemDateAndTimeResponse.class, false);
			
			// nullpoint exception could be happened
			Date date = response.getSystemDateAndTime().getUTCDateTime().getDate();
			Time time = response.getSystemDateAndTime().getUTCDateTime().getTime();
			//Date date = response.getSystemDateAndTime().getLocalDateTime().getDate();
			//Time time = response.getSystemDateAndTime().getLocalDateTime().getTime();
			cal = new GregorianCalendar(
					date.getYear(), date.getMonth() - 1, date.getDay(), 
					time.getHour(), time.getMinute(), time.getSecond());
			cal.setTimeZone(TimeZone.getTimeZone("UTC"));
			return cal.getTime();
		}
		catch (Exception e) // expect null exception
		{
			throw e;
		}
	}

	public GetDeviceInformationResponse GetDeviceInformation() throws Exception 
	{
		GetDeviceInformation getDeviceInform = new GetDeviceInformation();
		GetDeviceInformationResponse response = null;

		response = request(getDeviceInform, GetDeviceInformationResponse.class, true);

		return response;
	}

	public String GetHostname() throws Exception
	{
		GetHostname getHostname = new GetHostname();
		GetHostnameResponse response = request(getHostname, GetHostnameResponse.class, false);
		
		try
		{
			String name = response.getHostnameInformation().getName();
			return name;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public boolean SetHostname(String hostname) throws Exception 
	{
		SetHostname setHostname = new SetHostname();
		setHostname.setName(hostname);
		
		request(setHostname, SetHostnameResponse.class, true);
		
		return true;
	}

	public List<User> GetUsers() throws Exception 
	{
		GetUsers getUsers = new GetUsers();
		GetUsersResponse response = null;
		
		response = request(getUsers, GetUsersResponse.class, true);
		if (response == null) 
		{
			return null;
		}

		return response.getUser();
	}

	public Capabilities GetCapabilities() throws Exception 
	{
		GetCapabilities getCapabilities = new GetCapabilities();
		GetCapabilitiesResponse response = null;

		response = request(getCapabilities, GetCapabilitiesResponse.class, true);
		if (response == null) 
		{
			return null;
		}

		return response.getCapabilities();
	}

	public List<Service> GetServices(boolean includeCapability) throws Exception 
	{
		GetServices request = new GetServices();
		GetServicesResponse response = null;

		request.setIncludeCapability(includeCapability);

		response = request(request, GetServicesResponse.class, true);
		if (response == null) 
		{
			return null;
		}

		return response.getService();
	}
	
	public List<Scope> GetScopes() throws Exception
	{
		GetScopes request = new GetScopes();
		GetScopesResponse response = null;

		response = request(request, GetScopesResponse.class, true);
		if (response == null) 
		{
			return null;
		}

		return response.getScopes();
	}

	public String SystemReboot() throws Exception 
	{
		SystemReboot request = new SystemReboot();
		SystemRebootResponse response = null;

		response = request(request, SystemRebootResponse.class, true);
		if (response == null)
		{
			return null;
		}

		return response.getMessage();
	}
}

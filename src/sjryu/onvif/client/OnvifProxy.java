package sjryu.onvif.client;

public class OnvifProxy
{
	protected String namespace_;
	protected String xAddr_;
	protected SoapClientSecurity security_;
	//protected Dispatch<SOAPMessage> dispatch_;

	protected OnvifProxy(String nameSpace, String xAddr, SoapClientSecurity security)
	{
		namespace_ = nameSpace;
		xAddr_ = xAddr;
		security_ = security;
		//dispatch_ = null;
	}

	protected boolean setSecurity(SoapClientSecurity security)
	{
		boolean bRet = true;

		if (security == null)
		{
			return bRet;
		}

		try
		{
			security_ = (SoapClientSecurity)security.clone();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
			bRet = false;
		}

		return bRet;
	}

	public SoapClientSecurity getSecurity(SoapClientSecurity security)
	{
		return security_;
	}

	public String getXAddr()
	{
		return xAddr_;
	}

	public String getNameSpace()
	{
		return namespace_;
	}

	protected <T> T request(Object request, Class<T> responseType, boolean bSecure) throws Exception
	{
		T response = null;

		if (bSecure)
		{
			security_.updateEncryption();
			response = SoapClient.request(namespace_, xAddr_, request, responseType, security_);
		}
		else
		{
			response = SoapClient.request(namespace_, xAddr_, request, responseType, null);
		}

		return response;
	}
	
	/*
	protected void createDispatch() throws Exception
	{
		if (dispatch_ == null)
		{
			dispatch_ = SoapClient.createDispatch(namespace_, xAddr_);
		}
	}
	
	protected Response<SOAPMessage> requestAsync(Object request, boolean bSecure) throws Exception
	{
		Response<SOAPMessage> response = null;

		if (bSecure)
		{
			security_.updateEncryption();
			response = SoapClient.requestAsync(dispatch_, request, security_);
		}
		else
		{
			response = SoapClient.requestAsync(dispatch_, request, null);
		}

		return response;
	}
	*/
}

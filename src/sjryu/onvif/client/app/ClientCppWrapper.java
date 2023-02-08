package sjryu.onvif.client.app;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Response;

import org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType;
import org.onvif.ver10.events.wsdl.Capabilities;
import org.onvif.ver10.events.wsdl.GetEventPropertiesResponse;
import org.onvif.ver10.events.wsdl.PullMessagesResponse;
import org.onvif.ver10.schema.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sjryu.onvif.client.OnvifClient;

public class ClientCppWrapper
{
	private String addr_, user_, passwd_;
	private OnvifClient client_;

	private boolean bConnected_ = false;

	private boolean bMediaUpdated_ = false;
	private List<Profile> mediaProfiles_;

	private boolean bEncOptionUpdated_ = false;;
	private List<VideoEncoderConfigurationOptions> encoderOptions_;

	private String motionTopic_;
	private String motionItem_;
	private String motionDataName_;

	private boolean bPullpointCreated_ = false;

	Response<SOAPMessage> pullMessageResponse_ = null;
	
	public static class EVStatus
	{
		public final static int EV_MOTION = 0, EV_NOMOTION = 1, EV_TIMEOUT = 2, EV_NOTYET = 3, EV_CANCELED = 4, EV_FAULT = -1, EV_NOTCREATED = -1;
	}

	public static void setSystemProperties()
	{
		// messaging api
		System.setProperty("javax.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");
		   
		// https://javaee.github.io/metro/doc/user-guide/ch05.html#http-persistent-connections-keep-alive.
		System.setProperty("http.keepAlive", "false");
	}
	
	public ClientCppWrapper(String addr, String user, String passwd)
	{
		java.lang.Thread.currentThread().setContextClassLoader(java.lang.ClassLoader.getSystemClassLoader());
		
		addr_ = addr;
		user_ = user;
		passwd_ = passwd;

		encoderOptions_ = new LinkedList<>();
	}

	public int connect()
	{
		int ret = 0;

		try
		{
			client_ = new OnvifClient(addr_, user_, passwd_);

			//mediaProfiles_ = client_.getMedia().GetProfiles();
			bConnected_ = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			bConnected_ = false;
			ret = -1;
		}

		return ret;
	}
	
	public int updateMediaProfiles()
	{
		int ret = 0;
		
		try
		{
			mediaProfiles_ = client_.getMedia().GetProfiles();
			bMediaUpdated_ = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ret = -1;
		}
		
		return ret;
	}

	public String getStreamUri(int idx)
	{
		String uri;

		if (bMediaUpdated_ == false) return null;

		if (mediaProfiles_.size() < idx + 1) return null;

		try
		{
			Profile p = mediaProfiles_.get(idx);
			uri = client_.getMedia().getRTSPStreamUri(p.getToken());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return uri;
	}

	public int updateEncoderOptions()
	{
		int ret = 0;

		if (bMediaUpdated_ == false) return -1;

		for (Profile p : mediaProfiles_)
		{
			try
			{
				encoderOptions_.add(client_.getMedia().GetVideoEncoderConfigurationOptions(p.getToken()));
			}
			catch (Exception e)
			{
				e.printStackTrace();
				ret = -1;
				break;
			}
		}

		if (ret == 0) bEncOptionUpdated_ = true;

		return ret;
	}

	public int[] getAvailableResols(int idx)
	{
		if ((bEncOptionUpdated_ == false) || ((idx + 1) > encoderOptions_.size())) return null;

		VideoEncoderConfigurationOptions options = encoderOptions_.get(idx);

		List<VideoResolution> resol = options.getH264().getResolutionsAvailable();
		int size = resol.size();
		int[] fps = new int[size * 2];

		for (int i = 0; i < size; i++)
		{
			fps[i * 2] = resol.get(i).getWidth();
			fps[i * 2 + 1] = resol.get(i).getHeight();
		}

		return fps;
	}

	public int[] getAvailableFps(int idx)
	{
		if ((bEncOptionUpdated_ == false) || ((idx + 1) > encoderOptions_.size())) return null;

		VideoEncoderConfigurationOptions options = encoderOptions_.get(idx);

		IntRange frameRate = options.getH264().getFrameRateRange();
		int[] Range = new int[2];

		Range[0] = frameRate.getMin();
		Range[1] = frameRate.getMax();

		return Range;
	}

	public int[] getAvailableGov(int idx)
	{
		if ((bEncOptionUpdated_ == false) || ((idx + 1) > encoderOptions_.size())) return null;

		VideoEncoderConfigurationOptions options = encoderOptions_.get(idx);

		IntRange Gov = options.getH264().getGovLengthRange();
		int[] Range = new int[2];

		Range[0] = Gov.getMin();
		Range[1] = Gov.getMax();

		return Range;
	}

	public int[] getAvailableBitrate(int idx)
	{
		if ((bEncOptionUpdated_ == false) || ((idx + 1) > encoderOptions_.size())) return null;

		VideoEncoderConfigurationOptions options = encoderOptions_.get(idx);

		int[] Range = new int[2];
		IntRange Bitrate = options.getExtension().getH264().getBitrateRange();

		Range[0] = Bitrate.getMin();
		Range[1] = Bitrate.getMax();

		return Range;
	}

	public int[] getResolution(int idx)
	{
		if (bMediaUpdated_ == false) return null;

		int ret[] = new int[2];

		Profile p = mediaProfiles_.get(idx);
		VideoEncoderConfiguration config = p.getVideoEncoderConfiguration();

		ret[0] = config.getResolution().getWidth();
		ret[1] = config.getResolution().getHeight();

		return ret;
	}

	public int getFps(int idx)
	{
		if (bMediaUpdated_ == false) return -1;

		int ret;

		Profile p = mediaProfiles_.get(idx);
		VideoEncoderConfiguration config = p.getVideoEncoderConfiguration();

		ret = config.getRateControl().getFrameRateLimit();

		return ret;
	}

	public int getGov(int idx)
	{
		if (bMediaUpdated_ == false) return -1;

		int ret;

		Profile p = mediaProfiles_.get(idx);
		VideoEncoderConfiguration config = p.getVideoEncoderConfiguration();

		ret = config.getH264().getGovLength();

		return ret;
	}

	public int getBitrate(int idx)
	{
		if (bMediaUpdated_ == false) return -1;

		int ret;

		Profile p = mediaProfiles_.get(idx);
		VideoEncoderConfiguration config = p.getVideoEncoderConfiguration();

		ret = config.getRateControl().getBitrateLimit();

		return ret;
	}

	public int setEncConfig(int idx, int width, int height, int fps, int gov, int bitrate)
	{
		if (bMediaUpdated_ == false) return -1;

		if (idx + 1 > mediaProfiles_.size()) return -1;

		int ret = 0;

		VideoResolution Resol;
		VideoRateControl RateControl;
		H264Configuration H264;

		Profile p = mediaProfiles_.get(idx);
		VideoEncoderConfiguration config = p.getVideoEncoderConfiguration();

		VideoResolution Resol_old = config.getResolution();
		VideoRateControl RateControl_old = config.getRateControl();
		H264Configuration H264_old = config.getH264();

		if (width != 0 && height != 0)
		{
			Resol = new VideoResolution();
			Resol.setWidth(width);
			Resol.setHeight(height);
			config.setResolution(Resol);
		}

		if (fps != 0 || bitrate != 0)
		{
			try
			{
				RateControl = (VideoRateControl)RateControl_old.clone();
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
				return -1;
			}

			if (fps != 0) RateControl.setFrameRateLimit(fps);
			if (bitrate != 0) RateControl.setBitrateLimit(bitrate);
			config.setRateControl(RateControl);
		}

		if (gov != 0)
		{
			try
			{
				H264 = (H264Configuration)H264_old.clone();
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
				return -1;
			}
			H264.setGovLength(gov);
			config.setH264(H264);
		}

		try
		{
			Boolean bRet = client_.getMedia().SetVideoEncoderConfiguration(config);
			if (bRet == false)
			{
				config.setResolution(Resol_old);
				config.setRateControl(RateControl_old);
				config.setH264(H264_old);
				ret = -1;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			config.setResolution(Resol_old);
			config.setRateControl(RateControl_old);
			config.setH264(H264_old);
		}

		return ret;
	}
	
	public int isEventSupported()
	{
		if (bConnected_ == false) return -1;
		
		int ret = 0;
		
		try
		{
			Capabilities caps = client_.getEvent().GetServiceCapabilities();
			if (caps.isWSPullPointSupport())
			{
				ret = 1;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}

	private static Node findMotionItem(NodeList nodes)
	{
		Node find = null;
		
		try
		{
			for (int i = 0; i < nodes.getLength(); i++)
			{
				Node node = nodes.item(i);
				String name = node.getNodeName();
				if (name.contains("Motion"))
				{
					find = node;
					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return find;
	}
	
	public int findMotionTopic()
	{
		if (bConnected_ == false) return -1;
		
		int ret = -1;

		try
		{
			GetEventPropertiesResponse response = client_.getEvent().GetEventProperties();

			List<Object> topicSet = response.getTopicSet().getAny();
			
			Node find = null;
			for (Object topic : topicSet)
			{
				NodeList nodes = ((Element)topic).getChildNodes();
				find = findMotionItem(nodes);
			
				if (find != null) break;
			}

			if (find != null)
			{
				Node descNode = find.getFirstChild();

				// QName qName = new QName("http://www.onvif.org/ver10/schema", "MessageDescription");
				Unmarshaller unmarshaller = JAXBContext.newInstance(MessageDescription.class).createUnmarshaller();

				// MessageDescription desc = (MessageDescription)
				// unmarshaller.unmarshal(descNode);
				MessageDescription desc = ((JAXBElement<MessageDescription>)unmarshaller.unmarshal(descNode,
						MessageDescription.class)).getValue();

				if (desc.getData().getSimpleItemDescription().get(0).getType().getLocalPart().matches("boolean"))
				{
					motionTopic_ = find.getParentNode().getNodeName();
					motionItem_ = find.getNodeName();
					motionDataName_ = desc.getData().getSimpleItemDescription().get(0).getName();
					ret = 0;
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return ret;
	}

	public int createPullpoint()
	{
		if (bConnected_ == false) return -1;
		
		int ret = -1;
		
		try
		{
			if (client_.getEvent().CreatePullPointSubscription(motionTopic_ + "/" + motionItem_))
			{
				bPullpointCreated_ = true;
				ret = 0;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			bPullpointCreated_ = false;
		}

		return ret;
	}
	
	public String getPullpoint()
	{
		return client_.getEvent().getPullpoint();
	}

	public int pullMotionEvent()
	{
		if (bPullpointCreated_ == false) return EVStatus.EV_NOTCREATED;
		
		int status = EVStatus.EV_NOMOTION;

		try
		{
			PullMessagesResponse response = client_.getEvent().PullMessages();
			
			List<NotificationMessageHolderType> notifications = response.getNotificationMessage();
			NotificationMessageHolderType noti = notifications.get(0);
			
			Object message = noti.getMessage().getAny();
			Unmarshaller unmarshaller = JAXBContext.newInstance(Message.class).createUnmarshaller();
			Message tMsg = ((JAXBElement<Message>)unmarshaller.unmarshal((Node)message,
					Message.class)).getValue();
			
			ItemList.SimpleItem item = tMsg.getData().getSimpleItem().get(0);
			
			if (item.getName().matches(motionDataName_))
			{
				if (item.getValue().matches("true"))
				{
					status = EVStatus.EV_MOTION;
				}
			}
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			// possible reasons for exceptions => 
			// 1. incoming message without changed topic
			// 2. connection/request timeout
		}
		
		return status;
	}
	
	public int pullMotionEventAsync()
	{
		if (bPullpointCreated_ == false) return -1;

		int ret = -1;

		if (pullMessageResponse_ == null)
		{
			try
			{
				pullMessageResponse_ = client_.getEvent().PullMessagesAsync();
				ret= 0;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				pullMessageResponse_ = null;
			}
		}

		return ret;
	}
	
	public void cancelPullMotionEventAsync()
	{
		if (pullMessageResponse_ != null)
		{
			pullMessageResponse_.cancel(true);
			
			pullMessageResponse_ = null;
		}
	}

	public int checkMotionEventAsync()
	{
		if (pullMessageResponse_ == null) return EVStatus.EV_NOTCREATED;

		int status = EVStatus.EV_NOMOTION;

		if (pullMessageResponse_.isCancelled())
		{
			status = EVStatus.EV_CANCELED;
			pullMessageResponse_ = null;
		}
		else if (pullMessageResponse_.isDone())
		{
			try
			{
				PullMessagesResponse response = client_.getEvent().getPullMessagesResponseAsync(pullMessageResponse_);
				
				List<NotificationMessageHolderType> notifications = response.getNotificationMessage();
				NotificationMessageHolderType noti = notifications.get(0);
				
				Object message = noti.getMessage().getAny();
				Unmarshaller unmarshaller = JAXBContext.newInstance(Message.class).createUnmarshaller();
				Message tMsg = ((JAXBElement<Message>)unmarshaller.unmarshal((Node)message,
						Message.class)).getValue();
				
				ItemList.SimpleItem item = tMsg.getData().getSimpleItem().get(0);
				
				if (item.getName().matches(motionDataName_))
				{
					if (item.getValue().matches("true"))
					{
						status = EVStatus.EV_MOTION;
					}
				}
			}
			catch (NullPointerException | IndexOutOfBoundsException e)
			{
				// incoming message without changed topic
				status = EVStatus.EV_TIMEOUT;
			}
			catch (Exception f)
			{
				// UnmarshalException (fault response) and unknown exception
				status = EVStatus.EV_FAULT;
			}
			finally
			{
				pullMessageResponse_ = null;	
			}
		}
		else
		{
			status = EVStatus.EV_NOTYET;
		}

		return status;
	}
	
	public int renewPullpoint()
	{
		if (bPullpointCreated_ == false) return -1;
		
		int ret = -1;
		
		try
		{
			client_.getEvent().Renew();
			ret = 0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public void closePullpoint()
	{
		if (bPullpointCreated_)
		{
			try
			{
				client_.getEvent().Unsubscribe();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			bPullpointCreated_ = false;
		}
	}
}

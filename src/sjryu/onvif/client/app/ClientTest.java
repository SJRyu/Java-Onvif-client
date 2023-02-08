package sjryu.onvif.client.app;

import java.util.Arrays;

public class ClientTest implements Runnable
{
	@Override
	public void run()
	{
		ClientCppWrapper.setSystemProperties();
		
		ClientCppWrapper client = new ClientCppWrapper("192.168.0.3:80", "admin", "password");

		int ret = client.connect();
		if (ret != 0)
		{
			System.out.println("failed to connect");
			return;
		}
		else
		{
			System.out.println("success to connect");
		}

		client.updateMediaProfiles();
		System.out.println(client.getStreamUri(0));

		ret = client.updateEncoderOptions();
		if (ret != 0)
		{
			System.out.println("failed to update enc options");
			return;
		}

		int[] Aresol = client.getAvailableResols(0);
		int[] Afps = client.getAvailableFps(0);
		int[] Agov = client.getAvailableGov(0);
		int[] Abitrate = client.getAvailableBitrate(0);

		System.out.println("options");
		System.out.println(Arrays.toString(Aresol));
		System.out.println(Arrays.toString(Afps));
		System.out.println(Arrays.toString(Agov));
		System.out.println(Arrays.toString(Abitrate));

		int fps, gov, bitrate;

		Aresol = client.getResolution(0);
		fps = client.getFps(0);
		gov = client.getGov(0);
		bitrate = client.getBitrate(0);

		System.out.println("present");
		System.out.println(Arrays.toString(Aresol));
		System.out.println(fps);
		System.out.println(gov);
		System.out.println(bitrate);

		ret = client.setEncConfig(0, 1920, 1080, 25, 25, 8192);
		Aresol = client.getResolution(0);
		System.out.println(Arrays.toString(Aresol));

		ret = client.isEventSupported();
		if (ret == 0)
		{
			return;
		}
		
		ret = client.findMotionTopic();
		if (ret != 0)
		{
			return;
		}
		
		client.createPullpoint();
		
		/*
		for (int i = 0; i < 100; i++)
		{
			int status = onvif.pullMotionEvent();
			if (status == ClientCppWrapper.EVStatus.EV_MOTION)
			{
				System.out.println("Motion detected !");
			}
			else
			{
				System.out.println("NO motion detected !");	
			}
			
			onvif.renewPullpoint();
		}
		*/
		
		for (int i = 0; i < 100; i++)
		{
			ret = client.pullMotionEventAsync();
			if (ret == 0)
			{
				int status;

				do
				{
					status = client.checkMotionEventAsync();
				} while (status == ClientCppWrapper.EVStatus.EV_NOTYET);

				if (status == ClientCppWrapper.EVStatus.EV_MOTION)
				{
					System.out.println("Motion detected asynchronously!");
				}

				client.renewPullpoint();
			}
			else
			{
				System.out.println("failed to pullMessages");
				break;
			}
		}
		
		client.closePullpoint();
	}
	
	public static void main(String args[])
	{
		ClientTest test = new ClientTest();
		
		Thread ttest1 = new Thread(test, "1");
		Thread ttest2 = new Thread(test, "2");
		
		ttest1.start();
		ttest2.start();
	}
}

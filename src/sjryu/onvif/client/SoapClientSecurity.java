package sjryu.onvif.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.apache.commons.codec.binary.Base64;

/*
 * wse and wsu in soap-header
 */

public class SoapClientSecurity implements Cloneable
{
	private String timeStamp_;
	private long diffMs_;

	private final String user_;
	private final String passwd_;
	private String encryptedPasswd_;
	private String nonce_;
	private String encodedNonce_;

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	protected SoapClientSecurity(String user, String passwd, Date serverDate)
	{
		user_ = user;
		passwd_ = passwd;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ss'Z'");
		sdf.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		Date localDate = cal.getTime();

		if (serverDate != null)
		{
			diffMs_ = serverDate.getTime() - localDate.getTime();
			timeStamp_ = sdf.format(serverDate);
		}
		else
		{
			// use localtime
			diffMs_ = 0;
			timeStamp_ = sdf.format(localDate);
		}

		createNonce();
		encryptedPasswd_ = encryptPassword(passwd_, timeStamp_, nonce_);
	}

	protected void updateEncryption()
	{
		syncTimeStamp();
		createNonce();
		encryptedPasswd_ = encryptPassword(passwd_, timeStamp_, nonce_);
	}

	private void syncTimeStamp()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ss'Z'");
		sdf.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));

		Date localDate = cal.getTime();
		long serverTime = localDate.getTime() + diffMs_;

		Date serverDate = new Date(serverTime);

		timeStamp_ = sdf.format(serverDate);
	}

	protected String getUser()
	{
		return user_;
	}

	protected String getPasswd()
	{
		return passwd_;
	}

	protected String getEncryptedPasswd()
	{
		return encryptedPasswd_;
	}

	protected String getTimeStamp()
	{
		return timeStamp_;
	}

	protected String getNonce()
	{
		return nonce_;
	}

	protected String getEncodedNonce()
	{
		return encodedNonce_;
	}

	protected static String encryptPassword(String passwd, String timeStamp, String nonce)
	{
		String plainText = nonce + timeStamp + passwd;

		byte[] cryptedBytes;
		try
		{
			cryptedBytes = sha1(plainText);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
		String cryptedText = Base64.encodeBase64String(cryptedBytes);
		return cryptedText;
	}

	private void createNonce()
	{
		Random generator = new Random();
		nonce_ = "" + generator.nextInt();
		encodedNonce_ = Base64.encodeBase64String(nonce_.getBytes());
	}

	private static byte[] sha1(String s) throws NoSuchAlgorithmException
	{
		MessageDigest SHA1 = null;
		SHA1 = MessageDigest.getInstance("SHA1");

		SHA1.reset();
		SHA1.update(s.getBytes());

		byte[] encryptedRaw = SHA1.digest();
		return encryptedRaw;
	}
}

package api.com.util;

import java.security.SecureRandom;

public class RandomUtils {
	public static SecureRandom random= new SecureRandom();
	
	
	public static String generateRandomString(int length) {
		
		String text ="AaBbCc12345";
		StringBuilder sb = new StringBuilder(length);
		for(int i=0;i<length;i++) 
			sb.append(text.charAt(random.nextInt(text.length())));
			return sb.toString();
		
		}
		
		public static String generateRandomNumericString(int length) {
			String textnumber ="01234567889";
			StringBuilder sb = new StringBuilder(length);
			for(int i=0;i<length;i++) 
				sb.append(textnumber.charAt(random.nextInt(textnumber.length())));
				return sb.toString();
		}
		
}



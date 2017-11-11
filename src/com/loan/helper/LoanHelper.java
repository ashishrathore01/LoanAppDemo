/**
 * 
 */
package com.loan.helper;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @author rathoras
 *
 */
public class LoanHelper {
	public String generateRandom(String prefixCode) {
		Random random = new Random();
		char[] digits = new char[12];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < 12; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		StringBuilder sb = new StringBuilder(prefixCode);
		sb.append(digits);
		return sb.toString();
	}
	
	public String getEncryptedPassword(String password)
    {
        StringBuffer sb = new StringBuffer();
    	try {	    			    
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        //convert the byte to hex format method 1
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
    	}catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	return sb.toString();
    }
}
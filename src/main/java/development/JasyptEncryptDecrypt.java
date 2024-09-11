package development;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptEncryptDecrypt {

	private static String getDecryptedText(String string) {
		
		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		  standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		  standardPBEStringEncryptor.setPassword("7d2de858c787ddd5468b99b6dcb27466");
		  System.out.println("standardPBEStringEncryptor.decrypt :: " + standardPBEStringEncryptor.decrypt("778wulUP0MN92oPR7hpxzc9CX2+yqoPRhraFPYHGBkU="));
		  
		  
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("veritasMongoPwd");
		String encrypted_string = textEncryptor.decrypt(string);
		return encrypted_string;
	}
	
	public static void main(String[] args) {
		getDecryptedText("");
	}
	
//	# JASYPT encryption properties
//	jasypt.encryptor.password=7d2de858c787ddd5468b99b6dcb27466
//	jasypt.encryptor.algorithm=PBEWithMD5AndTripleDES

}

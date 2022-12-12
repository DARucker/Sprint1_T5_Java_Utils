package n3_exercici1;

/*	
 
	https://github.com/Anass-ABEA/Java-Encryption
	
*/


import static org.apache.commons.codec.binary.Base64.decodeBase64;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class App_3_1_COPIA {

	private final static String ALGORITHM = "AES"; // Algoritmo (AES, DES, RSA)
	private final static String CIPHER = "AES/CBC/PKCS5Padding"; 	// Tipo de cifrado, por bloques, padding etc.
	private String key;
	private String iv; 
	private String encriptedText;
	Properties properties= new Properties();
	public PrivateKey privateKey;
	static PublicKey publicKey;
	
	public static void main(String[] args) {

		App_3_1_COPIA app_3_1 = new App_3_1_COPIA();
		app_3_1.methods();		
	}

	public App_3_1_COPIA(){
		try {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(1024);
		KeyPair pair = generator.generateKeyPair();
		privateKey = pair.getPrivate();
		publicKey = pair.getPublic();
		}catch(Exception ignored) {}
	}
	
	
	public void methods() {
		ReaderAndWriter raw = new ReaderAndWriter();
		//System.out.println(privateKey);
		//System.out.println(publicKey);
		
		try {
	        properties.load(new FileInputStream(new File("src\\main\\java\\n3_exercici1\\configuration.properties")));
	        
	        //key = (String) properties.get("key");
	        iv = (String) properties.get("iv");
	        
			String fileRead = raw.readFile("exercici3.txt"); // leemos archivo original
			System.out.println("Archivo plano leido");

			encriptedText = encrypt(key, iv, fileRead); // encriptamos archivo original
			System.out.println("Archivo encriptado");

			raw.saveFile(encriptedText, "exercici3_encripted.txt"); // guardamos archivo encriptado
			System.out.println("Archivo encriptado guardado");
			
			String encryptedFileRead = raw.readFile("exercici3_encripted.txt"); // leemos archivo encriptado
			System.out.println("Archivo encriptado leído");

			String decryptedText = decrypt(key, iv, encryptedFileRead); //desencriptamos archivo
			System.out.println("Archivo desencriptado");
			
			raw.saveFile(decryptedText, "exercici3_Decripted.txt"); // guardamos archivo encriptado
			System.out.println("Archivo desencriptado guardado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String llave, String iv, String texto) throws Exception {
		Cipher cipher = Cipher.getInstance(CIPHER);
		//SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey, ivParameterSpec);
		byte[] encrypted = cipher.doFinal(texto.getBytes());
		String encriptedText1 = Base64.getEncoder().encodeToString(encrypted);
		return encriptedText1;
	}

	public static String decrypt(String llave, String iv, String encrypted) throws Exception {
		Cipher cipher = Cipher.getInstance(CIPHER);
		SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		byte[] enc = decodeBase64(encrypted);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] decrypted = cipher.doFinal(enc);
		String stringDecrypted = new String(decrypted);
		return stringDecrypted;
	}

}

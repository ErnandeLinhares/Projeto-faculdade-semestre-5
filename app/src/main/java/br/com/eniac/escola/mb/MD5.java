package br.com.eniac.escola.mb;

import java.security.MessageDigest;
/**
 * @author Ernande Linhares -> http://htmlcode.com.br/
 * */

public class MD5 {
	
	public static String gerarMD5(String senha){
		if(senha == null || senha.length() == 0){
			throw new IllegalArgumentException("A senha não pode ser nula ou de tamanho 0");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
				}else{
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(""+e);
		}
		return hexString.toString();
	}
	
}
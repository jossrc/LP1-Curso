package semana04;

import javax.swing.JOptionPane;

public class EjemploEncriptado {

	public static void main(String[] args) {
		
		
		String clave = JOptionPane.showInputDialog("Ingrese su contrase\u00f1a");		
		String encriptado = encriptar(clave);
		
		System.out.println(">>> CiberEncriptador <<<");
		System.out.println("Clave original    : " + clave);
		System.out.println("Clave encriptada  : " + encriptado);
		
		String desencriptado = desencriptar(encriptado);
		
		System.out.println("\n>>> CiberDesEncriptador <<<");
		System.out.println("Clave encriptado    : " + encriptado);
		System.out.println("Clave desencriptada : " + desencriptado);
	
	}
	
	static String encriptar(String clave) {
		StringBuilder cifrado = new StringBuilder();
		cifrado.append(clave);
		
		for (int i = 0; i < cifrado.length(); i++) {
			switch (cifrado.charAt(i)) {
			case 'a':
				cifrado.setCharAt(i, 'e');
				break;
			case 'e':
				cifrado.setCharAt(i, 'i');
				break;
			case 'i':
				cifrado.setCharAt(i, 'o');
				break;
			case 'o':
				cifrado.setCharAt(i, 'u');
				break;
			case 'u':
				cifrado.setCharAt(i, 'a');
				break;
			}
		}
		
		return cifrado.reverse().toString();
	}
	
	static String desencriptar(String encriptado) {
		StringBuilder desencriptado = new StringBuilder();
		desencriptado.append(encriptado);
		
		for (int i = 0; i < desencriptado.length(); i++) {
			switch (desencriptado.charAt(i)) {
			case 'a':
				desencriptado.setCharAt(i, 'u');
				break;
			case 'e':
				desencriptado.setCharAt(i, 'a');
				break;
			case 'i':
				desencriptado.setCharAt(i, 'e');
				break;
			case 'o':
				desencriptado.setCharAt(i, 'i');
				break;
			case 'u':
				desencriptado.setCharAt(i, 'o');
				break;
			}
		}
		
		return desencriptado.reverse().toString();
	}

}

package semana04;

import javax.swing.JOptionPane;

public class ComparandoCadenas {

	public static void main(String[] args) {
		String texto1 = "maria";
		String texto2 = JOptionPane.showInputDialog("Ingresa un nombre");

		// No recomendado
		if (texto1 == texto2) { // Compara direcciones
			System.out.println("Las cadenas son iguales");
		} else {
			System.out.println("Las cadenas son diferentes");
		}

		// Recomendado
		if (texto1.equals(texto2)) { // Compara contenido?
			System.out.println("Las cadenas son equals");
		} else {
			System.out.println("Las cadenas son equals");
		}

		long REPETICIONES = 60000; // veces a evaluar
		String s = "";
		System.out.println(s);
		long tiempo = System.currentTimeMillis(); // tiempo inicial
		for (int i = 0; i < REPETICIONES; i++) {
			s += "a";
		}
		tiempo = System.currentTimeMillis() - tiempo;
		System.out.println("String ha tardado: " + tiempo + " milisegundos");
		StringBuffer s2 = new StringBuffer();
		tiempo = System.currentTimeMillis();
		for (int i = 0; i < REPETICIONES; i++) {
			s2.append("a");
		}
		tiempo = System.currentTimeMillis() - tiempo;
		System.out.println("StringBuffer ha tardado: " + tiempo + " milisegundos");

	}

}

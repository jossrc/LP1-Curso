package ejercicios;

public class Ejercicio2_1 {

	public static void main(String[] args) {
		System.out.println(1);
		try {
		System.out.println(2);
		int x = 5 / 0;
		System.out.println(x);
		System.out.println(3);
		} catch (Exception e) {
		System.out.println(4);
		}
		System.out.println(5);
	}

}

package ejercicios;

public class Ejercicio2_2 {

	public static void main(String[] args) {
		System.out.println(1);
		try {
			System.out.println(2);
			int x = 5 / 2;
			System.out.println(x);
			System.out.println(3);
		} catch (Exception e) {
			System.out.println(4);
		} finally {
			System.out.println(5);
		}
		System.out.println(6);
	}

}

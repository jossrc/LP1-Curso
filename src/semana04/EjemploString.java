package semana04;

public class EjemploString {

	public static void main(String[] args) {
		String texto = "a001;  Juancito ;  Pando  ;12;05;LP1";

		// Separar los textos en código, nombre, apellido, nota1, nota2 y curso

		String aDatos[] = texto.split(";");

		System.out.println("===== DATOS INICIALES =====");
		for (String dato : aDatos) {
			System.out.println(dato);
		}

		// Guardar en campos
		String codigo = aDatos[0];
		String nombre = aDatos[1].trim();
		String apellido = aDatos[2].trim();
		int nota01 = Integer.parseInt(aDatos[3]);
		int nota02 = Integer.parseInt(aDatos[4]);
		String curso = aDatos[5];

		System.out.println("\n===== DATOS OBTENIDOS =====");
		System.out.println("Código   : " + codigo);
		System.out.println("Nombre   : " + nombre);
		System.out.println("Apellido : " + apellido);
		System.out.println("Nota 01  : " + nota01);
		System.out.println("Nota 02  : " + nota02);
		System.out.println("Curso    : " + curso);

		// Convertir el apellido a mayúscula y el nombre el minúscula

		System.out.println("\n===== VALIDACIONES Y TRANSFORMACIONES =====");
		System.out.println("Apellido en Mayuscula : " + apellido.toUpperCase());
		System.out.println("Nombre en Minuscula : " + nombre.toLowerCase());

		// Validar que el curso sea LP1

		String mensaje = curso.equals("LP1") ? "El curso es LP1" : "El curso no es LP1";
		System.out.println(mensaje);

		// Validar que el código empiece con la letras “a” o “p”

		String sonIniciales = codigo.startsWith("a") || codigo.startsWith("p") ? "El caracter si inicia con a o p"
				: "El caracter es diferente de a y p";
		System.out.println(sonIniciales);

		// validar que el tamaño del código sea 4

		String longitud = codigo.length() >= 4 ? "Longitud del cod es 4" : "Longitud del codigo es diferente a 4 ";
		System.out.println(longitud);

		// Generar un correo con el siguiente formato: 1° letra del nombre + parte numérica del código + @cibertec.pe. Ej. j001@cibertec.pe

		String correo = aDatos[1].trim().toLowerCase().charAt(0) + aDatos[0].trim().substring(1) + "cibertec.pe";
		System.out.println("Correo   : " + correo);

	}

}

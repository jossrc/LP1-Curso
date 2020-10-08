package interfaces;

import java.util.ArrayList;

import model.Usuario;

public interface UsuarioInterface {
	// Para registrar o agregar usuarios
	public int registrar(Usuario u);

	// Para eliminar usuarios:
	public int eliminar(int codigo);

	// Para actualizar usuarios:
	public int actualizar(Usuario u);

	// Para listado de usuarios
	public ArrayList<Usuario> listado();
}

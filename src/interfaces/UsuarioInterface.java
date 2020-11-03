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
	
	// Para buscar un usuario por código
	public Usuario buscar(int codigo);

	// Para listado de usuarios
	public ArrayList<Usuario> listado();
	
	// Para que un usuario tenga acceso
	public Usuario validarAcceso(String usuario, String clave);
	
}

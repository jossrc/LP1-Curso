package interfaces;

import java.util.ArrayList;

import model.RepUsuarioTipo;
import model.Usuario;

public interface UsuarioXTipoInterface {

	public ArrayList<Usuario> listadoUsuariosxTipo(int tipo);
	
	public ArrayList<RepUsuarioTipo> listadoUsuariosYTipo(int tipo);
	
}

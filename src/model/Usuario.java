package model;

public class Usuario {

	private int codigo;
	private String nombre;
	private String apellido;
	private String usuario;
	private String clave;
	private String fnacim;
	private int id_tipo;
	private int estado;

	public Usuario(int codigo, String nombre, String apellido, String usuario, String clave, String fnacim, int id_tipo,
			int estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.fnacim = fnacim;
		this.id_tipo = id_tipo;
		this.estado = estado;
	}
	
	public Usuario() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFnacim() {
		return fnacim;
	}

	public void setFnacim(String fnacim) {
		this.fnacim = fnacim;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}

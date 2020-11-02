package model;

public class RepUsuarioTipo {

	private int codigo;
	private String nombre;
	private String apellido;
	private String fech_nac;
	private String desc_tipo;
	
	public RepUsuarioTipo(int codigo, String nombre, String apellido, String fech_nac, String desc_tipo) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fech_nac = fech_nac;
		this.desc_tipo = desc_tipo;
	}
	
	public RepUsuarioTipo() {
		
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

	public String getFech_nac() {
		return fech_nac;
	}

	public void setFech_nac(String fech_nac) {
		this.fech_nac = fech_nac;
	}

	public String getDesc_tipo() {
		return desc_tipo;
	}

	public void setDesc_tipo(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}
	
}

package model;

public class Producto {
	private String codigo;
	private String producto;
	private int cantidad;
	private double precio;
	private int tipo;

	public Producto(String codigo, String producto, int cantidad, double precio, int tipo) {
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}

package model;

public class CabeceraBoleta {

	private String num_bol;
	private String fch_bol;
	private int cod_cliente;
	private int cod_vendedor;
	private double total_bol;

	public CabeceraBoleta(String num_bol, String fch_bol, int cod_cliente, int cod_vendedor, double total_bol) {
		this.num_bol = num_bol;
		this.fch_bol = fch_bol;
		this.cod_cliente = cod_cliente;
		this.cod_vendedor = cod_vendedor;
		this.total_bol = total_bol;
	}

	public String getNum_bol() {
		return num_bol;
	}

	public void setNum_bol(String num_bol) {
		this.num_bol = num_bol;
	}

	public String getFch_bol() {
		return fch_bol;
	}

	public void setFch_bol(String fch_bol) {
		this.fch_bol = fch_bol;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getCod_vendedor() {
		return cod_vendedor;
	}

	public void setCod_vendedor(int cod_vendedor) {
		this.cod_vendedor = cod_vendedor;
	}

	public double getTotal_bol() {
		return total_bol;
	}

	public void setTotal_bol(double total_bol) {
		this.total_bol = total_bol;
	}
	
	

}

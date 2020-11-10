package interfaces;

import java.util.ArrayList;

import model.CabeceraBoleta;
import model.DetalleBoleta;

public interface VentaInferface {
	
	public String generaNumBoleta();
	
	public int realizarVenta(CabeceraBoleta cabeBol, ArrayList<DetalleBoleta> detBol);

}

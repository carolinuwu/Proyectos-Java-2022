package electroDomesticoYDerivadas;
 
public class Lavarropa extends ElectroDomestico  {
	private final double cargaMaxima;
	private final boolean esAutomatico;

public Lavarropa(String marca, String modelo, float precio, double cargaMaxima, boolean esAutomatico) {
		super(marca, modelo, precio);
		this.cargaMaxima = cargaMaxima;
		this.esAutomatico = esAutomatico;
	
	}
 
@Override
public void mostrarDetalleCompleto() {
	System.out.println( " Lavarropas  " + super.marca +  ((this.esAutomatico)? "  semi automatico  " : " no semi automatico")  +
			"  carga maxima : " + this.cargaMaxima +
			" ,  modelo  " + super.modelo+ " precio : " + super.getPrecio());
	
}

 
 
 

}

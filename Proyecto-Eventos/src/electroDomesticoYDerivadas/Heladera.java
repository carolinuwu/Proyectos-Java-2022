package electroDomesticoYDerivadas;

public class Heladera extends ElectroDomestico  {
private final double capacidadEnLitros;
private final boolean esFrost;

public Heladera(String marca, String modelo, float precio, boolean esFrost, double capacidadEnLitros ) {
	super(marca, modelo, precio);
	this.esFrost = esFrost;
	this.capacidadEnLitros = capacidadEnLitros;
}

@Override
public void mostrarDetalleCompleto() {
	 System.out.println("Heladera  " + super.marca+ " ,  modelo  " + super.modelo + ((this.esFrost)? " frost " : " no frost")  + "  litros : " + this.capacidadEnLitros +  " precio : " + super.getPrecio());
	
}
 

}

package electroDomesticoYDerivadas;

public class Televisor extends ElectroDomestico  {
private final int dimension;
private final boolean esSmart;

public Televisor(String marca, String modelo, float precio, int dimension, boolean esSmart) {
	super(marca, modelo, precio);
	this.dimension = dimension;
	this.esSmart = esSmart;
}

 

@Override
public void mostrarDetalleCompleto() {
 System.out.println("Televisor  " + ((this.esSmart? " smart " : " no smart")  + " " +super.marca + " " +  this.dimension + " pulgadas "  + "" + " modelo : " + " " +super.modelo + "  precio  " + "" + super.getPrecio());
}

 

 

}

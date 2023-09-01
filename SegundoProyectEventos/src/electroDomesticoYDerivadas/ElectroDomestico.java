package electroDomesticoYDerivadas;

import CasaElectroSinEventos.Imprimible;

public abstract class ElectroDomestico  implements Imprimible  {
  
protected final String marca;
protected final String modelo;
private  final float precio;
 
public ElectroDomestico(String marca, String modelo,float precio) {
	this.marca = marca;
	this.modelo = modelo;
	this.precio = precio;
}

@Override
public String toString() {
	return this.getClass().getSimpleName() + "  marca " + this.marca + " modelo " + this.modelo +  " precio : $  " + this.precio;
}

@Override
public void imprimir() {
	System.out.println(this);
	
}

 

@Override
public boolean equals(Object obj) {
	if (obj == this) {
		return true;
	}
	if (obj instanceof ElectroDomestico otro) {
		return otro.modelo.equals(this.modelo) && otro.precio==this.precio && otro.marca.equals(this.marca);
	}
	
  return false;
}


public float getPrecio() {
 
	return this.precio;
}

public abstract void mostrarDetalleCompleto();


public String getMarca() {
	// TODO Auto-generated method stub
	return this.marca;
}


public String getModelo() {
	// TODO Auto-generated method stub
	return this.modelo;
}
 
}
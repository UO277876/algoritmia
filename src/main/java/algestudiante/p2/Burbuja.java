package algestudiante.p2 ;

import algestudiante.p2.Vector;


public class Burbuja extends Vector
{
	public Burbuja(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por el método de Burbuja
	 */
	@Override
	public void ordenar() {
		for(int i=0; i <= this.elements.length - 2; i++) {
			for(int j = this.elements.length; j > i; j--) {
				if(this.elements[j-1] > this.elements[j]) {
					intercambiar(j-1,j);
				}
			}
		}
	}  

	@Override
	public String getNombre() {
		return "Burbuja";
	}  
} 
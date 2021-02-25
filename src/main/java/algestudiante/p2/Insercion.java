package algestudiante.p2 ;

import algestudiante.p2.Vector;

/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrático)· 
	Es la INSERCIÓN DIRECTA
 */
public class Insercion extends Vector
{
	
	public Insercion(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por inserción directa
	 */
	@Override
	public void ordenar() {
		
		for(int i = 1; i < this.elements.length; i++) {
			int x = this.elements[i];
			int j = i - 1;
			while(j >= 0 && x < this.elements[j]) {
				this.elements[j+1] = this.elements[j];
				j -= 1;
			}
			this.elements[j+1] = x;
		}
	} 

	@Override
	public String getNombre() {
		return "Inserción directa";
	} 
} 

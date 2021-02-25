package algestudiante.p2;

/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrático)·
	es la SELECCION
 */
public class Seleccion extends Vector
{
	public Seleccion(int nElementos) {
		super(nElementos);
	}
	

	/**
	 * Ordenación por selección
	 */
	@Override
	public void ordenar() {
		int posMenor = 0;
		for(int i=0; i < this.elements.length - 1; i++) {
			posMenor = i;
			for(int j= i+1; j < this.elements.length; j++) {
				if(this.elements[j] < this.elements[posMenor]) {
					posMenor = j;
				}
			}
			intercambiar(i,posMenor);
		}
	}  

	@Override
	public String getNombre() {		
		return "Selección";
	}  
} 

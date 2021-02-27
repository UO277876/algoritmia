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
		int tam = this.elements.length;
		int[] vector = this.elements;
		
		for(int i=0; i < tam - 1; i++) {
			posMenor = i;
			for(int j=i+1; j < tam; j++) {
				if(vector[j] < vector[posMenor]) {
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

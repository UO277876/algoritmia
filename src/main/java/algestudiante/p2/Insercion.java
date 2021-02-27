package algestudiante.p2 ;

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
		int tam = this.elements.length;
		int[] vector = this.elements;
		
		for(int i = 1; i < tam; i++) {
			int x = vector[i];
			int j = i - 1;
			while(j >= 0 && x < vector[j]) {
				vector[j+1] = vector[j];
				j -= 1;
			}
			vector[j+1] = x;
		}
	} 

	@Override
	public String getNombre() {
		return "Inserción directa";
	} 
} 

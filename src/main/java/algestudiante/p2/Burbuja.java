package algestudiante.p2 ;

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
		int tam = this.elements.length;
		int[] vector = this.elements;
		
		for(int i=0; i <= tam - 2; i++) {
			for(int j = tam - 1; j > i; j--) {
				if(vector[j-1] > vector[j]) {
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
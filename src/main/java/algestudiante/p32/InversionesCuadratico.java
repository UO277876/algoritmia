package algestudiante.p32;

import java.util.List;

public class InversionesCuadratico {
	
	private Integer[] array;

	/**
	 * Constructor con un parámetro de la clase Inversiones
	 * 
	 * @param ranking, la lista de elementos a analizar
	 */
	public InversionesCuadratico(List<Integer> ranking) {
		this.array = new Integer[ranking.size()];
		ranking.toArray(this.array);
	}

	/**
	 * Cuenta las inversiones y devuelve su número en forma de String
	 * 
	 * @return Una cadena de caracteres con el núm de inversiones
	 */
	public String start() {
		long cont = 0; // Tiene que ser long porque se necesita más memoria
		int n = array.length;
		
		for (int i=0; i < n-1; i++) {
			for (int j= i+1; j < n-1; j++){
				if (array[j] < array[i]) {
					cont++;
				}
			}
		}
		return String.valueOf(cont);
	}
	

}

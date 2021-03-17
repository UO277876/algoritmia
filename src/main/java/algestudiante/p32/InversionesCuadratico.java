package algestudiante.p32;

import java.util.List;

public class InversionesCuadratico {
	
	private int[] array;

	/**
	 * Constructor con un parámetro de la clase Inversiones
	 * 
	 * @param ranking, la lista de elementos a analizar
	 */
	public InversionesCuadratico(List<Integer> ranking) {
		int pos = 0;
		for(Integer num : ranking) {
			array[pos] = num;
			pos++;
		}
	}

	/**
	 * Cuenta las inversiones y devuelve su número en forma de String
	 * 
	 * @return Una cadena de caracteres con el núm de inversiones
	 */
	public String start() {
		int cont = 0;
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

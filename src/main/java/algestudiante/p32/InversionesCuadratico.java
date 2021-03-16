package algestudiante.p32;

import java.util.List;

public class InversionesCuadratico {
	
	private int[] array;

	public InversionesCuadratico(List<Integer> ranking) {
		int pos = 0;
		for(Integer num : ranking) {
			array[pos] = num;
			pos++;
		}
	}

	public String start() {

	}
	
	private int contInv1() {
		int cont = 0;
		int n = array.length;
		
		for (int i=0; i < n-1; i++) {
			for (int j= i+1; j < n-1; j++){
				if (array[j] < array[i]) {
					cont++;
				}
			}
		}
		return cont;
	}

}

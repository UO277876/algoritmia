package algestudiante.p32;

import java.util.List;

public class Inversiones {
	
	private int[] array;

	/**
	 * Constructor con un parámetro de la clase Inversiones
	 * 
	 * @param ranking, la lista de elementos a analizar
	 */
	public Inversiones(List<Integer> ranking) {
		int pos = 0;
		for(Integer num : ranking) {
			array[pos] = num;
			pos++;
		}
	}

	/**
	 * Método externo para contar las inversiones que llama al método recursivo que lo hace
	 * 
	 * @return el número de inversiones
	 */
	public String start() {
		return String.valueOf(contInvRec(0,array.length-1));
	}
	
	/**
	 * Método recursivo para el divide y vencerás con a=2, b=2, k=1
	 por división
	  
	 * @param iz, la parte izquierda del vector
	 * @param de, la parte derecha del vector
	 * @return el número de inversiones total 
	 */
	private int contInvRec(int iz, int de) {
		if(iz==de) {
			return 0;
		} else {
			int m=(iz+de);//2
			int x = contInvRec(iz,m);
			int y = contInvRec(m+1,de);
			int c = ordenarMezclarMitades(iz,m,m+1,de);
			return x + y + c;
		}
	}
	
	private int ordenarMezclarMitades(int iz, int med, int med1, int de) {
		// Creamos los dos vectores sobre los que iteramos
		int tam1 =  iz-med+1;
		int tam2 = med1-de+1;
		int [] m1 = new int[tam1];
		int [] m2 = new int[tam2];
		for(int i=0; i < tam1; i++) m1[i] = array[iz+1];
		for(int i=0; i < tam2; i++) m2[i] = array[med1+1];
		
		// Los ordenamos
		Rapido.rapido(m1);
		Rapido.rapido(m2);
		
		// Mezcla 
		int c = 0;
		int aux1=0;
		int aux2=0;

		for(int i=0; i < tam1 + tam2; i++) {
			if(m1[aux1] > m2[aux2]) {
				c += tam1 - i;
				aux2 = i;
			} else {
				aux1 = i;
			}
			
		}
		
		return c; 
	}

}

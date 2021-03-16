package algestudiante.p32;

import java.util.List;

public class Inversiones {
	
	private int[] array;

	public Inversiones(List<Integer> ranking) {
		int pos = 0;
		for(Integer num : ranking) {
			array[pos] = num;
			pos++;
		}
	}

	public String start() {
	}
	
		
	private int contInvRec(int iz, int de) {
		if(iz==de) {
			return 0;
		} else {
			int m=(iz+de);//2
			int x=contInvRec(iz,m,…);
			int y=contInvRec(m+1,de,…);
			int c=ordenarMezclarMitades(…);
			return (x+y+c) ;
		}
	}
	
	private int ordenarMezclarMitades() {
		
	}

}

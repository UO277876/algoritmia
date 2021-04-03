package algestudiante.p5;

import java.util.Random;

public class MSCRec {
	
	/**
	 * Genera una secuencia aleatoria 
	 * @param n tama�o de la secuencia
	 * @return secuencia aleatoria, una cadena con caracters A, C, G and T.
	 */
	public String genSecuenciaAleatoria(int n){
		char[] dna_elements = {'A', 'C', 'G', 'T'};
		String result = "";
		Random r = new Random();
		for (int i=0; i<n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}
	
	/**
	 * Encuentra un MSC directamente a trav�s de una aproximaci�n recursiva 
	 */
	public String encontrarMSC(String s1, String s2){
		// TODO: encuentra un MSC de dos secuencias directamente (sin usar una tabla) mediante recursion
		String comb = "";
		
		if(s1.equals("") || s2.equals("")) {
			return "";
		} else {
			String L1 = encontrarMSC(s1.substring(0, s1.length()-1),s2);
			String L2 = encontrarMSC(s1,s2.substring(0, s2.length()-1));
			String L3 = encontrarMSC(s1.substring(0, s1.length()-1),s2.substring(0, s2.length()-1));
			int can = maxima(L1,L2,L3);
			
			if(can == 1) {
				comb += L1;
			} else if(can == 2) {
				comb += L2;
			} else {
				if(s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
					comb += L3 + s1.charAt(s1.length() - 1);
				} else{
					comb += L3;
				}
			}
		}
		
		return comb;
	}
	
	/**
	 * Devuelva el indice de la cadena m�s larga introducida
	 * @param l1 e.g. input L1=MSC(S1�, S2). S1� S1 without its last char
	 * @param l2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param l3 e.g. input L3=MSC(S1�, S2�) or L3+1 when both current chars are equal
	 * @return �ndice de la cadena m�s larga
	 */
	private int maxima(String l1, String l2, String l3) {
		if(l1.length() > l2.length() && l1.length() > l3.length()) {
			return 1;
		} else if(l2.length() > l1.length() && l2.length() > l3.length()) {
			return 2;
		} else {
			return 3;
		}
	}

}

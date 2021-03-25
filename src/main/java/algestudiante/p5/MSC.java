package algestudiante.p5;

import java.util.Random;

public class MSC {
	
	CellTable[][] table; // tabla con los valores intermedios
	String str1; // primera cadena
	String str2; // segunda cadena
	String result; // candena con el resultado
	int size1; // tamaño de la cadena 1
	int size2; // tamaño de la cadena 2
	
	/**
	 * Constructor
	 * @param s1 primera cadena a comparar
	 * @param s2 segunda cadena a comparar
	 */
	public MSC(String s1, String s2) {
		str1 = "*" + s1; //str1. La primera columna se encabeza con asterisco
		str2 = "*" + s2; //str2. La segunda columna se encabeza con asterisco
		System.out.println("String1: " + str1);
		System.out.println("String2: " + str2);
		size1 = str1.length();
		size2 = str2.length();
		result = "";
		table = new CellTable[size1][size2]; // tabla empleada en programación dinámica 
	}
	
	/**
	 * Constructor empleado para medir tiempos
	 * @param n tamaño de las cadena generadas aleatoriamente 
	 */
	public MSC(int n) {
		str1 = "*" + this.genSecuenciaAleatoria(n);
		str2 = "*" + this.genSecuenciaAleatoria(n);
		size1 = str1.length();
		size2 = str2.length();
		result = "";
		table = new CellTable[size1][size2];  
	}
	
	/**
	 * Genera una secuencia aleatoria 
	 * @param n tamaño de la secuencia
	 * @return secuencia aleatoria, una cadena con caracters A, C, G and T.
	 */
	private String genSecuenciaAleatoria(int n){
		char[] dna_elements = {'A', 'C', 'G', 'T'};
		String result = "";
		Random r = new Random();
		for (int i=0; i<n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}
	
	/**
	 * Inicialización de los valores de la tabla
	 */
	public void iniTabla() {
		for (int j=0; j<size2; j++)
			for(int i=0; i<size1; i++)
				table[i][j] = new CellTable();
	}
	
	
	/**
	 * Impresión de los valores de la tabla
	 */
	public void imprimirTabla() {
		System.out.printf("%11s", "*");
		for (int i=0; i<size1; i++) 
			System.out.printf("%11s", str1.substring(i, i+1)); // caracter de la cadena 1 (horizontal)
		System.out.println();
		
		for (int j=0; j<size2; j++) {
			System.out.printf("%11s", str2.substring(j, j+1)); // carecter de la cadena 2 (vertical)
			for(int i=0; i<size1; i++)
				System.out.printf("%4d(%2d,%2d)", table[i][j].value, table[i][j].iPrev, 
						table[i][j].jPrev); // valores de la tabla
			System.out.println();
		}
	}
	
	
	/**
	 * Imprime la MSC encontrada
	 */
	public void imprimeMCS(){
		System.out.println(result);
	} 

	public class CellTable{
		public int value; // valor para programación dinámica
		public int iPrev; //"índice" a caracter de la cadena 1 empleada para calcular el valor 
		public int jPrev; //"índice" a caracter de la cadena 2 empleada para calcular el valor
	}
	
	/**
	 * Rellena la tabla para la programación dinámica
	 */
	public void rellenaTabla(){
		// TODO: completa la tabla de programación dinámica con una celda (value, iPrev and jPrev) para cada entrada
	}
	
	/**
	 * Encuentra el índice del máxmimo de tres valores diferentes
	 * @param num1 e.g. input L1=MSC(S1’, S2). S1’ S1 without its last char
	 * @param num2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param num3 e.g. input L3=MSC(S1’, S2’) or L3+1 when both current chars are equal
	 * @return índice del máximo
	 */
	private int maximo(int num1, int num2, int num3) {
		// TODO (optional): a partir de tres valores diferentes (p. e. longitud de una secuencia) devuelve el índice del máximo
		return -1;
	}
	
	/**
	 * Enentra la MSC a partir de los valores de la tabla
	 * @param v si verdadero se propocionan mensajas que muestran los pasos seguidos
	 */
	public void encontarMSC(boolean v){
		// TODO: después de rellenas la tabla, reconstruye la MSC empezando por el último elemento
	}

}

package algestudiante.p5;

import java.util.Random;

public class MSC {
	
	CellTable[][] table; // tabla con los valores intermedios
	String str1; // primera cadena
	String str2; // segunda cadena
	String result; // candena con el resultado
	int size1; // tama�o de la cadena 1
	int size2; // tama�o de la cadena 2
	
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
		table = new CellTable[size1][size2]; // tabla empleada en programaci�n din�mica 
	}
	
	/**
	 * Constructor empleado para medir tiempos
	 * @param n tama�o de las cadena generadas aleatoriamente 
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
	 * @param n tama�o de la secuencia
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
	 * Inicializaci�n de los valores de la tabla
	 */
	public void iniTabla() {
		for (int j=0; j<size2; j++)
			for(int i=0; i<size1; i++)
				table[i][j] = new CellTable();
	}
	
	
	/**
	 * Impresi�n de los valores de la tabla
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
		public int value; // valor para programaci�n din�mica
		public int iPrev; //"�ndice" a caracter de la cadena 1 empleada para calcular el valor 
		public int jPrev; //"�ndice" a caracter de la cadena 2 empleada para calcular el valor
	}
	
	/**
	 * Rellena la tabla para la programaci�n din�mica
	 */
	public void rellenaTabla(){
		// TODO: completa la tabla de programaci�n din�mica con una celda (value, iPrev and jPrev) para cada entrada
		int cad1 = 0;
		int cad2 = 0;
		
		for (int i=0; i < size1; i++) {
            for (int j=0; j < size2; j++) {
                if (i == 0 || j == 0) { // Caso básico
                    table[i][j].value = 0;
                    table[i][j].iPrev = 0;
                    table[i][j].jPrev = 0;
                } else {
                    int L1 = table[i][j-1].value; // IZQ
                    int L2 = table[i-1][j].value; // ARRIBA
                    int L3 = table[i-1][j-1].value; // DIAGONAL
                    
    				int index = maximo(L1,L2,L3);
    				
                    if(index == 1) { 
                    	table[i][j].value = table[i][j-1].value;
                    	table[i][j].iPrev = i;
                        table[i][j].jPrev = j-1;
                        
                        cad1 = j-1;
                        cad2 = i;
                        
                    } else if(index == 2) {
                    	table[i][j].value = table[i-1][j].value;
                    	table[i][j].iPrev = i-1;
                        table[i][j].jPrev = j;
                        
                        cad1 = j;
                        cad2 = i-1;                        
                    } else {
                    	table[i][j].value = table[i-1][j-1].value;
                    	table[i][j].iPrev = i-1;
                        table[i][j].jPrev = j-1;
                        
                        cad1 = j-1;
                        cad2 = i-1;
                        
                     // Para que cambie a uno porque coinciden los caracteres
        				if(str1.charAt(cad1) == str2.charAt(cad2)) {
        					table[i][j].value++;
        				}
                    
    				}
                    
                }
            }
        }
		System.out.println(result);
	}
	
	/**
	 * Encuentra el �ndice del m�xmimo de tres valores diferentes
	 * @param num1 e.g. input L1=MSC(S1�, S2). S1� S1 without its last char
	 * @param num2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param num3 e.g. input L3=MSC(S1�, S2�) or L3+1 when both current chars are equal
	 * @return �ndice del m�ximo
	 */
	private int maximo(int L1, int L2, int L3) {
		// TODO (optional): a partir de tres valores diferentes (p. e. longitud de una secuencia) devuelve el �ndice del m�ximo
		
		if(L1 > L2 && L1 > L3) {
			return 1;
		} else if(L2 > L1 && L2 > L3) {
			return 2;
		} else {
			return 3;
		}
	}
	
	/**
	 * Enentra la MSC a partir de los valores de la tabla
	 * @param v si verdadero se propocionan mensajas que muestran los pasos seguidos
	 */
	public void encontarMSC(boolean v){
		// TODO: despu�s de rellenas la tabla, reconstruye la MSC empezando por el �ltimo elemento
		CellTable ct = table[size1 - 1][size2 - 1];
		int i = size1 - 1;
		
		while (i != 0) {			
			if(table[ct.iPrev][ct.jPrev].value < ct.value) {				
				result = str1.charAt(i) + result;
				i = ct.iPrev;
			}
			
			if(v) {
				System.out.println("Fila: " + ct.iPrev);
				System.out.println("Columna: " + ct.jPrev);
				System.out.println("Puntero al valor: " + ct.value);
				System.out.println("MSC actual: " + result);
				System.out.println("-------------------------------");
			}
			
			ct = table[ct.iPrev][ct.jPrev];
		}
	}

}

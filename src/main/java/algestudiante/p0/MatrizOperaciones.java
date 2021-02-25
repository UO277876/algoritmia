package algestudiante.p0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

public class MatrizOperaciones {
	
	private int tam;
	private int[][] matriz;
	
	/**
	 * Constructor con 1 parámetro para las pruebas
	 * 
	 * @param matriz, la matriz a analizar
	 */
	public MatrizOperaciones(int[][] matriz) {
		this.tam = matriz.length;
		this.matriz = matriz;
	}
	
	/**
	 * Constructor con 3 par�metros de la clase MatrizOperaciones
	 * @param n, las dimensiones de la matriz
	 * @param min, el valor m�nimo de los valores que la contienen
	 * @param max, el valor m�ximo de los valores que la contienen
	 */
	public MatrizOperaciones(int n, int min, int max) {
		this.tam = n;
		this.matriz = new int[tam][tam];
	
		rellenarMatriz(min, max);
	}
	
	/**
	 * Rellena la matriz con valores aleatorios dentro de un rango pasado como par�metro
	 * 
	 * @param min el valor m�nimo de los valores que la contienen
	 * @param max, el valor m�ximo de los valores que la contienen
	 */
	private void rellenarMatriz(int min, int max) {
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				int num = (int) (Math.random() * ((max + 1) - min) + min);
				matriz[i][j] = num;
			}
		}
	}
	
	/**
	 * Constructor con un par�metro de la clase MatrizOperaciones
	 * 
	 * @param nomFich, el nombre del fichero que contiene la matriz
	 */
	public MatrizOperaciones(String nomFich) {
		
		String linea = "";
		
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("files/" + nomFich + ".txt"));
			int pos = 0;
			
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] texto = linea.split("\t");
				
				inicializarMatriz(pos, texto);
				pos++;
			}			

			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	/**
	 * Crea la matriz a partir de los datos del fichero de texto
	 * 
	 * @param lineas, las lineas que componen el fichero de texto
	 */
	private void inicializarMatriz(int pos, String[] texto) {
		if(pos == 0) {
			int tam = Integer.parseInt(texto[0]);
			this.tam = tam;
			this.matriz = new int[tam][tam];
		} else {
			for(int i=0; i < texto.length; i++) {
				matriz[pos - 1][i] = Integer.parseInt(texto[i]);
			}
		}
	}
	
	/**
	 * Devuelve el tama�o de la matriz
	 * 
	 * @return el tama�o
	 */
	public int getTam() {
		return tam;
	}
	
	/**
	 * Imprime la matriz por pantalla
	 */
	public void escribir() {
		for(int i=0; i<matriz.length; i++) {
			System.out.print("\n");
			for(int j=0; j<matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
		}
	}
	
	/**
	 * Calcula de forma iterativa la suma de la diagonal.
	 * Recorre toda la matriz, pero solo suma los elementos de la diagonal.
	 * 
	 * @return la suma de la diagonal de la matriz
	 */
	public int sumarDiagonal1() {
		int sum = 0;
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				if(i == j) {
					sum += matriz[i][j];
				}
			}
		}
		return sum;
	}
	
	/**
	 * Calcula de forma iterativa la suma de la diagonal.
	 * Recorre la diagonal solo.
	 * 
	 * @return la suma de la diagonal de la matriz
	 */
	public int sumarDiagonal2() {
		int sum = 0;
		for(int i=0; i < matriz.length; i++) {
			sum += matriz[i][i];
		}
		return sum;
	}
	
	/**
	 * Hace el recorrido de la matriz dependiendo de los valores de la casilla. Se 
	 * inicia en la casilla pasada como parámetro.
	 * 1: arriba
	 * 2: derecha
	 * 3: izquierda
	 * 4: abajo
	 * 
	 * @param i, fila de la que se parte
	 * @param j, columna de la que se parte
	 */
	public void recorrerCamino(int i, int j) {
		int row = i;
		int column = j;
		
		while(row < getTam() && column < getTam() && row >= 0 && column >= 0 && matriz[row][column] != -1) {
			if (matriz[row][column] == 1) {
				matriz[row][column] = -1;
				row = row - 1;
			} else if (matriz[row][column] == 2) {
				matriz[row][column] = -1;
				column = column + 1;
			} else if (matriz[row][column] == 3) {
				matriz[row][column] = -1;
				row = row + 1;
			} else {
				matriz[row][column] = -1;
				column = column - 1;
			}
		}
	}
}

package algestudiante.p11;

import algestudiante.p0.MatrizOperaciones;

public class MatrizOperacionesTiempos {
	
	static MatrizOperaciones mo;
	
	public static void main(String[] args) {
		long t1, t2;
		int nVeces = 100000;
		
		for (int n = 3; n < 100000000; n*=2) {

			mo = new MatrizOperaciones(n,1,4);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				mo.sumarDiagonal2();
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio);
		}
	}

}

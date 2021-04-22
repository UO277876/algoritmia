package algestudiante.p6;

public class MejorListaTiempos {
	
	static MejorLista mjt,mj;
	
	public static void main(String[] args) {
		// Corrección
		// NOTA: Del fichero SOLO el nombre, no la terminación ".txt"
		String fichero = args[0];
		int tam = Integer.valueOf(args[1]);
		mj = new MejorLista(fichero,tam);
		mj.backtracking(0);
		mj.print();
		
		long t1, t2;
		int nVeces = 1;
		int index = 1;
		for (int n = 5; n < 31; n*=index) {
			mjt = new MejorLista(n);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				mjt.backtracking(0);
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(index);
			System.out.println(n + "\t" + tMedio);
			index++;
		}
	}
}

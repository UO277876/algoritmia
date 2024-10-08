package algestudiante.p5;

public class MscPrueba {
	
	public static void main(String arg []) {
		
		String str1 = "GCCCTAGCG"; // primera secuencia
		String str2 = "GCGCAATG"; // segunda secuencia
		
		System.out.println("PROGRAMACI�N DIN�MICA:");
		MSC msc = new MSC(str1, str2);
		System.out.println("Inicializando la table...");
		msc.iniTabla();
		System.out.println("Rellenando la tabla...");
		msc.rellenaTabla();
		System.out.println("Imprimiendo la tabla...");
		msc.imprimirTabla();
		System.out.println("Buscando la MSC...");
		msc.encontarMSC(true);
		System.out.println("Imprimiendo la MSC...");
		msc.imprimeMCS();
		
		System.out.println("\n/****************/\n");
		
		System.out.println("RECURSIVO:");
		MSCRec lcsrec = new MSCRec();
		System.out.println("Buscando la MSC...");
		String seq_rec = lcsrec.encontrarMSC(str1, str2);
		System.out.println(seq_rec);
		
		System.out.println("Program terminated.");
	} 

}

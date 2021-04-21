package algestudiante.p6;


public class TiemposMejorLista {
	
	//static ColocacionSegmentos co;
	
	public static void main(String[] args) {
		int tam = 1;
		
		MejorLista mj = new MejorLista("Lista01",5);
		mj.backtracking(tam);
		mj.print();
		
	}
	

}

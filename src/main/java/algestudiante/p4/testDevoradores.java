package algestudiante.p4;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDevoradores {

	@Test
	public void testDevorador1() {
		ColocacionSegmentos v1 = new ColocacionSegmentos("juego1");
		
		v1.devorador1();
		System.out.println("\n");
		v1.devorador2();
		System.out.println("\n");
		v1.devorador3();
	}

}

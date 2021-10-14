package imc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TratarImcDadosTest {
	TratarImcDados IMC;
	@BeforeEach
	void setUp() throws Exception {
		IMC = new TratarImcDados();
	}

	@Test
	void testCalcularIMC() {
		Assertions.assertEquals(17.8,IMC.CalcularIMC(45.5, 160));
		Assertions.assertEquals(22.0,(IMC.CalcularIMC(60, 165)));
		Assertions.assertEquals(26.1,(IMC.CalcularIMC(80, 175)));
		Assertions.assertEquals(33.2,(IMC.CalcularIMC(120, 190)));
		Assertions.assertEquals(41.5,(IMC.CalcularIMC(120, 170)));
	}

	 @Test
		void testCompararIMC() {
		Assertions.assertEquals("Abaixo do peso",IMC.CompararIMC(17.8));
		Assertions.assertEquals("Peso Normal",(IMC.CompararIMC(22.0)));
		Assertions.assertEquals("Sobrepeso",(IMC.CompararIMC(26.1)));
		Assertions.assertEquals("Obeso",(IMC.CompararIMC(33.2)));
		Assertions.assertEquals("Obeso Mórbido",(IMC.CompararIMC(41.5)));
	}

	@Test
	void testPesoIdeal() {
		Assertions.assertEquals(60.4,IMC.PesoIdeal(17,false,160));
		Assertions.assertEquals(79.4,IMC.PesoIdeal(35,true,190));
		Assertions.assertEquals(65.3,IMC.PesoIdeal(66,false,157));
	}
	
	
	@Test
	void testEnergiaNecessaria() {
		Assertions.assertEquals(1301.1,IMC.energiaNecessaria(17,45.5,160,false));
		Assertions.assertEquals(1923.0,IMC.energiaNecessaria(35,120,190,true));
		Assertions.assertEquals(1436,IMC.energiaNecessaria(66,80,157,false));
		Assertions.assertEquals(1429.3,IMC.energiaNecessaria(35,69,168,false));
	}

	@Test
	void testDiariaEnergia() {
		Assertions.assertEquals(1886.59,IMC.diariaEnergia(3,1301.1,false));
		Assertions.assertEquals(2307.6,IMC.diariaEnergia(1,1923.0,true));
		Assertions.assertEquals(1866.8,IMC.diariaEnergia(2,1436,false));
		Assertions.assertEquals(1715.16,IMC.diariaEnergia(1,1429.3,false));
	} 


}

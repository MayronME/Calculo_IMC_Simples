package imc;
import java.util.Scanner;

public class ImcMain {
	
	public static void main(String[] args) {	
		
		Scanner sc1 = new Scanner(System.in);
		TratarImcDados IMC = new TratarImcDados();
		
		// Input do User
		System.out.println("seu sexo � masculino? true/false");
		boolean user_sexo = sc1.nextBoolean();
		System.out.println("Idade");
		int user_idade = sc1.nextInt();
		System.out.println("Altura");
		double user_altura = sc1.nextDouble();
		System.out.println("Peso");
		double user_peso = sc1.nextDouble();
		System.out.println("Selecione uma op��o: ");
		System.out.println("1: Sentado sem pratica de atividades");
		System.out.println("2: Dia-a-dia movimentado");
		System.out.println("3: Dia a dia  movimentado  e  atividades f�sicas");
		System.out.println("4: De  uma a  duas horas  e  meia  de  atividades  f�sicas");
		System.out.println("5: Atividade  f�sica di�ria  por  mais de  tr�s  horas");
		int user_FA = sc1.nextInt();
		
		//Chamada de Fun��o
		double Result_imc = IMC.CalcularIMC(user_peso,user_altura);
		String result_condicao = IMC.CompararIMC(Result_imc);
		double result_peso_ideal = IMC.PesoIdeal(user_idade,user_sexo,user_altura);
		double result_energia = IMC.energiaNecessaria(user_idade, user_peso, user_altura, user_sexo);
		double result_diaria_energia = IMC.diariaEnergia(user_FA,result_energia,user_sexo);
		
		System.out.println("======================================");
		System.out.println("== IMC: "+Result_imc);
		System.out.println("== Considerado: "+result_condicao);
		System.out.println("== Peso m�dio ideal: "+result_peso_ideal);
		System.out.println("== Necessidade energia: "+result_diaria_energia+" calorias");
		System.out.println("======================================");
		sc1.close();
	}
}
package imc;

public class TratarImcDados {
	public double CalcularIMC(double peso_usuario, double altura_usuario) {
		
		//Caso o usuario digite valores sem o ponto
		altura_usuario =  altura_usuario >= 10? altura_usuario/100 : altura_usuario;
						
		//Calculo do IMC
		double IMC = peso_usuario/(altura_usuario*altura_usuario);
		IMC = Math.round(IMC*10.0)/10.0;
		
		return  IMC;
	}
	
	public String CompararIMC(double IMC) {
		String condicao;
		
		//Comparar IMC
		if(IMC < 18 ) {
			 condicao = "Abaixo do peso";
		} else if (IMC >= 18 && IMC < 25) {
			 condicao = "Peso Normal";
		} else if (IMC >= 25 && IMC < 30) {
			 condicao ="Sobrepeso";
		} else if (IMC >= 30 && IMC < 40) {
			 condicao ="Obeso";
		} else {
			 condicao ="Obeso Mórbido";
		}
		
		return condicao;	
	}

	public double PesoIdeal(int user_idade, boolean sexo_usuario, double user_altura) {
		double imc_desejado;
		double peso_ideal;
		
		//Caso o usuario digite valores sem o ponto
		user_altura =  user_altura >= 10? user_altura/100 : user_altura;		
		
		if(user_idade >= 3 && user_idade <= 10){
			peso_ideal = user_idade*2+9;
		
		}else if (user_idade >= 18 && user_idade <= 64){
			imc_desejado = sexo_usuario ? 22 : 21;
			peso_ideal = imc_desejado*Math.pow(user_altura,2);
			
		}else{
			if(user_idade >= 65 && user_idade <= 69){
					imc_desejado = sexo_usuario  ? 24.3 : 26.5;
					
			}else if(user_idade >= 70 && user_idade <= 74){
					imc_desejado = sexo_usuario  ? 25.1 : 26.3;
					
			}else if(user_idade >= 75 && user_idade <= 79) {
				imc_desejado = sexo_usuario ? 23.9 : 26.1;
				
			}else if(user_idade >= 80 && user_idade <= 84){
				imc_desejado = sexo_usuario ? 23.7 : 25.5;
				
			}else {
				imc_desejado = sexo_usuario ? 23.1 : 23.6;
			}
		
			peso_ideal = imc_desejado * Math.pow(user_altura,2);
		}
		
		return Math.round(peso_ideal*10.0)/10.0;
	}
	
	public double energiaNecessaria(int user_idade, double peso_usuario,double user_altura, boolean user_sexo) {
		double TMB;
		if(user_idade >= 10 && user_idade < 18) {
			 TMB = user_sexo  ? 17.5*peso_usuario+651 : 12.2*peso_usuario+746 ;
		}
		else if (user_idade >= 18 && user_idade <= 30) {
			TMB = user_sexo  ? 15.3*peso_usuario+675 : 14.7*peso_usuario+496;
		} 
		else if (user_idade > 30 && user_idade <= 60) {
			TMB = user_sexo  ? 8.7*peso_usuario+879 : 8.7*peso_usuario+829;
		} 
		else if (user_idade >= 60) {
			TMB = user_sexo  ? 13.5*peso_usuario+487 : 10.5*peso_usuario+596 ;
		} 
		else {
			TMB = 10 ;
		}
		return TMB;
	}
	
	public double diariaEnergia(int user_FA,double result_energia, boolean user_sexo) {
		double FA = 0;
		
		switch(user_FA) {
		case 1:
			FA = 1.2;
			break;
		case 2:
			FA = user_sexo ? 1.4 : 1.3;
			break;
		case 3:
			FA = user_sexo ? 1.5 : 1.45;
			break;
		case 4:
			FA = user_sexo ? 1.6 : 1.5;
			break;
		case 5:
			FA = user_sexo ? 1.8 : 1.7;
			break;
		}
		return Math.round((result_energia*FA)*100.0)/100.0;
	}
}

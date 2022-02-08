package a;
import java.util.Scanner;

public class Prova {

		public static void main(String[] args) {
			Scanner entrada=new Scanner(System.in);
			int opcao=0;
			double salario,porcentagem = 0,desconto,INSS=0,FGTS = 0,IRRF=0;
			
			System.out.print("Digite o seu nome: ");
			String nome=entrada.nextLine();
			System.out.print("Digite o seu salário: ");
			salario = entrada.nextDouble();
			while(opcao != 4) {
			
			System.out.print("1-INSS\t3-FGTS\n");
			System.out.print("2-IRRF\t4-Sair\n");
			System.out.print("Escolha: ");
			
			opcao=entrada.nextInt();
			switch(opcao) {
				case 1:
					//INSS
					if(salario > 7087.22) {
						porcentagem = 0;
					}else if(salario > 3641.03) {
						porcentagem = 0.14;
					}else if(salario > 2427.35){
						porcentagem = 0.12;
					}else if(salario > 1212.01){
						porcentagem = 0.09;
					} else {
						porcentagem = (7.5/100);		
					} 
					if(porcentagem == 0) {
						desconto = 992.21;
					}else {
						desconto = salario * porcentagem;	
					}
					desconto=salario*porcentagem;
					INSS=salario-desconto;
					
					System.out.println("Nome: " + nome);
					System.out.println("Porcentagem: " + porcentagem);
					System.out.println("Salário: " + salario);
					System.out.println("INSS: " +INSS);
					System.out.println(" ");
					break;
				case 2:
					//IRRF
					if(salario > 1903.99){
						porcentagem = 7.5;
					}else if(salario > 2826.66){
						porcentagem = 15;
					}else if(salario > 3751.06) {
						porcentagem = 27.50;
					}else if(salario < 4664.68) {
						porcentagem = 0.0;
			
					} else {
						System.out.println("É isento");		
					}
					
					desconto = salario * porcentagem / 100;
					System.out.println("Nome: " + nome);
					System.out.println("Porcentagem: " + porcentagem);
					System.out.println("Salário: " + salario);
					System.out.println("IRRF: " + IRRF);
					System.out.println(" ");
					break;
				case 3:
					//FGTS
					FGTS=salario*0.08;
					salario=salario+FGTS;
					System.out.println("Nome: " + nome);
					System.out.println("Porcentagem: " + porcentagem);
					System.out.println("Salário: " + salario);
					System.out.println("FGTS: " + FGTS);
					System.out.println(" ");
					break;
				case 4:
					System.out.println("Nome: " + nome);
					System.out.println("Salário bruto: " + salario);
					System.out.println("Salário com desconto do INSS: "+(salario-INSS));
					System.out.println("Salário com desconto do IRRF: " + (salario-IRRF));
					System.out.println("Salário com FGTS: " + FGTS);
					System.out.println("Salário liquido: " + (salario+FGTS-INSS-IRRF));
				}
			}
		}
	}


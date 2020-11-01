package app;

import java.util.Arrays;
import java.util.Scanner;

public class NotasAlunos {
	
	private static String[] alunos;
	private static float[] notaA;
	private static float[] notaB;
	
	private static final int VET = 100;
	private static final Integer[] OPCOES = {1,2,3,4};
	
	
	private static String situacaoAluno(float media) {
		if(media < 4) {
			return "Reprovado!";
		}else if(media >= 4 && media < 7) {
			return "Prova final!";
		}else {
			return "Aprovado!";
		}
	}
	
	private static float calcularMedia(int id) {
		return(notaA[id] + notaB[id]) / 2;
	}
	
	private static void imprimir(int id) {
		
		float media = calcularMedia(id);
		String situacao = situacaoAluno(media);
		
		System.out.printf("Id: %d \n Nome do Aluno: %s\n Nota 1: %.2f\n Nota 2: %.2f\n Média final: %.2f\n Situação: %s\n",
				id, alunos[id], notaA[id], notaB[id], media, situacao);

	}
	
	private static void imprimir() {
		for (int i = 0; i < VET; i++) {
			if (alunos[i] != null) {
				imprimir(i);
			}			
		}
	}
	
	
	public static void main(String[] args){
		
		alunos = new String[VET];
		notaA = new float[VET];
		notaB = new float[VET];
		
		Scanner in = new Scanner(System.in);
		
		int i = 0;
		int opcao;
		
		do {
			System.out.println("[1] Registrar as notas de um novo aluno.");
			System.out.println("[2] Consultar boletim de um aluno.");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair.");
			System.out.print("Informe a opcao desejada: ");
			opcao = in.nextInt(); 	
			
		
			if(Arrays.asList(OPCOES).contains(opcao)) {		
				
				switch (opcao) {
				case 1: 
					if(i < VET) {
						System.out.println("Informe o nome do aluno: ");
						alunos[i] = in.next();
						
						System.out.println("Informe a nota A: ");
						notaA[i] = in.nextFloat();
						
						System.out.println("Informe a nota B: ");
						notaB[i] = in.nextFloat();	
						
						System.out.println("... Cadastro realizado com sucesso! ...");						
						System.out.printf("Registro código: %d\n", i);
						System.out.println("........................................");
						
						i++;
					}else {
						System.out.println("Impossivel cadastrar novo aluno!");
					}
					break;
				
				case 2:
					System.out.print("Informe a identificação do aluno: ");
					int id = in.nextInt();
					
					if(id >= 0 && id < i) {
						System.out.println("... Aluno ...");
						imprimir(id);
						
						System.out.println(".............");
					}else {
						System.out.println("Inpossível encontrar aluno!");
					}
					break;
				
				case 3:
					System.out.println("... Lista de Alunos ...");
					imprimir();
					System.out.println("........................");
					break;
				}
			}else {
				System.out.println("Opção Inválida!");
			}
			
		} while (opcao != 4);
		
		System.out.println("Cadastramento finalizado com sucesso!");
		
		in.close();
		
	}
}

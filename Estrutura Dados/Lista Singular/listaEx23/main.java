package listaEx23;

import java.util.Scanner;	

public class main
{	
	public	static	NoMetodos lista = new	NoMetodos();

	public static void main(String Args[]) {			
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite uma opcao");
		int opcao = -1;
		
		do {
			System.out.println("1- Inserir elemento");
			System.out.println("2- Remover elemento");
			System.out.println("3- Mostrar toda a lista");
			System.out.println("4- Sair");
			opcao = ler.nextInt();
			
			if(opcao == 1) {
				System.out.println("Digite o elemento a ser inserido: ");
				int elemento = ler.nextInt();
				lista.inserirNoFinal(elemento);
			}
			else if(opcao == 2) {
				System.out.println("O elemento: " + lista.removerDoFinal() + " Foi removido do final");
			}
			else if(opcao == 3) {
				System.out.println("Os elemento na lista são: ");
				lista.mostrarTodos();
				opcao = 4;
			}
			else if(opcao == 4){
				System.out.println("Saindo...");
			}
			else {
				System.out.println("Opcao invalida tente novamente");
			}
		}while(opcao != 4);
		
	}
		
}
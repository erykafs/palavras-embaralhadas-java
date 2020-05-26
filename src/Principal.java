import java.util.Scanner;


public class Principal {
	
	private static FabricaMecanicaDoJogo fabrica = new FabricaMecanicaDoJogo();
	private static MecanicaDoJogo jogo = null;
	private static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean continua = true;
		while(continua) {
			try {
				System.out.println("&&&&&&&& MENU &&&&&&&&");
				System.out.println("1 - Iniciar Jogo");
				System.out.println("2 - Regras do Jogo");
				System.out.println("3 - Jogar");
				System.out.println("0 - Sair");
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
				System.out.print("Comando:");
				int op = ler.nextInt();
				switch (op) {
				case 0:
					System.out.println("Sair");
					jogo = null;
					fabrica = null;
					continua = false;
					break;
				case 1:
					System.out.println("Novo Jogo");
					jogo = fabrica.novoJogo();
					break;
				case 2:
					if (jogo != null) {
						System.out.println("Regras do Jogo");
						System.out.println(jogo.regras());
					} else {
						System.out.println("Nenhum jogo foi iniciado");
					}
					break;
				case 3:
					if (jogo != null) {
						boolean cont = true;
						while(!jogo.jogoAcabou()) {
							String p = jogo.jogar();
							while(cont) {
								System.out.println("Que palavra é essa:" + p);
								if (jogo.verificar(ler.next())) {
									System.out.println("\n >>>PARABÉNS: Você acertou a palavra");
									System.out.println("Total de Pontos:" + jogo.pontos() + "\n\n");
									break;
								} else {
									System.out.println("\n >>>OPA: palavra errada, pontos: " + jogo.pontos());
									cont = !jogo.jogoAcabou();
								}
							}
						}
						System.out.println("\n\nResultado:\n" + jogo.resultado());
						jogo = null;
						fabrica = null;
					} else {
						System.out.println("Nenhum jogo foi iniciado");
					}
					break;
				default:
					System.out.println("Opção inválida");
				}
			} catch(Exception e) {
				System.out.println(">> OPA: Opção inválida - Você não digitou um número.\n\n");
				ler = new Scanner(System.in);
			} 
		}		
	}
}
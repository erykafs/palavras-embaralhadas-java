
public class Jogo1 implements MecanicaDoJogo {
	
	private int pontosJogo;
	private int palavrasAcertadas;
	private int errosPorPalavra;
	private String palavraO;
	private String palavraE;
	private int porc;
	
	public Jogo1() {
		System.out.println("Jogo 1 escolhido");
		pontosJogo = 0;
		palavrasAcertadas = 0;
		errosPorPalavra = 0;
		palavraO = "";
		palavraE = "";
	}
	
	@Override
	public String jogar() {
		FabricaEmbaralhadores fabrica = new FabricaEmbaralhadores();
		Embaralhador emb = fabrica.novaPalavra();
		errosPorPalavra = 0;
		palavraO = emb.getPalavraOriginal();
		System.out.println("Original:" + palavraO);
		palavraE = emb.embaralhar();
		porc += palavraO.length();
		return palavraE;
	}

	@Override
	public int pontos() {
		return pontosJogo;
	}

	@Override
	public String regras() {
		String regras = "1. Jogo composto por 4 palavras.\n";
		regras += "2. O jogo acaba se acertar as 4 palavras ou se errar 3 vezes uma palavra.\n";
		regras += "3. Pontos:\n";
		regras += "- Se acertar de 1ª - ganha 2x(tamanho da palavra).\n";
		regras += "- Se errar 1 vez - ganha (tamanho da palavra)/2.\n";
		regras += "- Se errar 2 vezes - ganha 0.\n";
		regras += "4. Vence o jogo: Acertar as 4 palavras e tiver pontos > 70% do total de pontos.\n";
		return regras;
	}

	@Override
	public boolean jogoAcabou() {
		if (errosPorPalavra == 3 || palavrasAcertadas == 4)
			return true;
		return false;
	}

	@Override
	public boolean verificar(String palavra) {
		if (palavraO.equalsIgnoreCase(palavra)) {
			palavrasAcertadas++;
			if (errosPorPalavra==0) {
				// Acertou de 1ª dobro
				pontosJogo += 2*palavraO.length();
			} else if(errosPorPalavra==1) {
				// Acertou de 1ª dobro
				pontosJogo += palavraO.length()/2;
			}
			return true;
		} else {
			errosPorPalavra++;
			return false;
		}	
	}
	
	@Override
	public String resultado() {
		porc = pontosJogo/porc;
		String r = "";
		if (palavrasAcertadas < 4 || porc < 70) {
			r += "\n\n>> Que Pena você perdeu o jogo.\n";
		} else {
			r += "\n\n>> PARABÉNS você ganhou o jogo.\n";
		}
		r += "Palavras Acertadas:" + palavrasAcertadas;
		r += "\nPontos:" + pontosJogo;
		return r;
	}

}

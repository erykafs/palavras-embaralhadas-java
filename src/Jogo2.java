
public class Jogo2 implements MecanicaDoJogo {
	
	private int pontosJogo;
	private int palavrasAcertadas;
	private int erros;
	private String palavraO;
	private String palavraE;
	
	public Jogo2() {
		System.out.println("Jogo 2 escolhido");
		pontosJogo = 0;
		palavrasAcertadas = 0;
		erros = 0;
		palavraO = "";
		palavraE = "";
	}

	@Override
	public String jogar() {
		
		FabricaEmbaralhadores fabrica = new FabricaEmbaralhadores();
		Embaralhador emb = fabrica.novaPalavra();
		palavraO = emb.getPalavraOriginal();
		System.out.println("Original:" + palavraO);
		palavraE = emb.embaralhar();
		return palavraE;
	}

	@Override
	public int pontos() {
		return pontosJogo;
	}

	@Override
	public String regras() {
		String regras = "\nRegras:";
		regras += "1. Jogo composto por 5 palavras.\n";
		regras += "2. Você pode errar somente 2 vezes.\n";
		regras += "3. Pontos:\n";
		regras += "- Se acertar ganha o dobro do tamanho da palavra.\n";
		regras += "- Se errar perde metade dos pontos totais.\n";
		return regras;
	}

	@Override
	public boolean jogoAcabou() {
		if (erros > 2 || palavrasAcertadas == 5)
			return true;
		return false;
	}

	@Override
	public boolean verificar(String palavra) {
		if (palavraO.equalsIgnoreCase(palavra)) {
			palavrasAcertadas++;
			pontosJogo += 2*palavraO.length();
			return true;
		} else {
			erros++;
			pontosJogo /= 2;
			return false;
		}
	}

	@Override
	public String resultado() {
		String r = "";
		if (erros > 2) {
			r += "\n\n>> Que Pena você perdeu o jogo.\n";
		} else {
			r += "\n\n>> PARABÉNS você ganhou o jogo.\n";
		}
		r += "Palavras Acertadas:" + palavrasAcertadas;
		r += "\nPontos:" + pontosJogo;
		return r;
	}

}

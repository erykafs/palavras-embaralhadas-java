import java.util.Random;

public class FabricaMecanicaDoJogo {
	private MecanicaDoJogo jogo = null;

	public MecanicaDoJogo novoJogo() {
		Random r = new Random();
		int escolha = r.nextInt(2);
		if (escolha == 0) {
			jogo = new Jogo1();
		} else {
			jogo = new Jogo2();
		}
		return jogo;
	}

}

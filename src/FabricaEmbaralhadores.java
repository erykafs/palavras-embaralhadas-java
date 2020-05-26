import java.util.Random;


public class FabricaEmbaralhadores {
	
	private Embaralhador e = null;
	
	public Embaralhador novaPalavra() {
		Random r = new Random();
		int escolha = r.nextInt(2);
		if (escolha == 0) {
			e = new Embaralhador1();
		} else {
			e = new Embaralhador2();
		}
		return e;
	}

}

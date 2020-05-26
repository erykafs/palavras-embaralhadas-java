import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TesteEmbaralhar {

	Embaralhador1 emb1;
	Embaralhador2 emb2;


	@Before
	public void inicializar() {
		emb1 = new Embaralhador1();
		emb2 = new Embaralhador2();
	}

	@Test
	public void testeEmbaralhamento1() {
		// Deixei public apenas para fazer os testes
//		emb1.palavraOriginal = "paralelepipedo";
		String nova = emb1.embaralhar();
		assertEquals("aparelelipepod", nova);
	}

	@Test
	public void testeEmbaralhamento2() {
		// Deixei public apenas para fazer os testes
//		emb2.palavraOriginal = "paralelepipedo";
		String nova = emb2.embaralhar();
		assertEquals("aadeeeillopppr", nova);
	}

}

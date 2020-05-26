import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Embaralhador2 implements Embaralhador {

	private BancoDePalavras banco= null;
	private String palavraOriginal="";
	private String palavraEmbaralhada="";

	public Embaralhador2() {
		banco = new BancoDePalavras();
		palavraOriginal = banco.lerPalavra();
	}

	@Override
	// Embaralhando palavra: Retornar a palavra com as letras ordenadas
	public String embaralhar() {
		String[] c = palavraOriginal.split("");
		List<String> listaPalavras = new ArrayList<String>(Arrays.asList(c));
		Collections.sort(listaPalavras);
		for (String a: listaPalavras) {
			palavraEmbaralhada +=a;
		}
		return palavraEmbaralhada;
	}

	@Override
	public int dificuldade() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return palavraOriginal.length();
	}

	@Override
	public String getPalavraOriginal() {
		// TODO Auto-generated method stub
		return palavraOriginal;
	}

}

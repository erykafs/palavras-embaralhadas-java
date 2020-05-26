
public class Embaralhador1 implements Embaralhador {

	private BancoDePalavras banco= null;
	private String palavraOriginal="";
	private String palavraEmbaralhada="";
	
	public Embaralhador1() {
		banco = new BancoDePalavras();
		palavraOriginal = banco.lerPalavra();
	}
	
	@Override
	// Embaralhando palavra: Trocar letras impares por pares
	public String embaralhar() {
		String[] c = palavraOriginal.split("");
		for (int i = 1; i < c.length-1; i+=2) {
			String a = c[i];
			c[i] = c[i+1];
			c[i+1] = a;
			palavraEmbaralhada += c[i] + c[i+1];
		}
		if (!(palavraOriginal.length() % 2 == 0)) {
			palavraEmbaralhada += c[c.length-1];
		}
		return palavraEmbaralhada;
	}

	@Override
	public int dificuldade() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return palavraOriginal.length();
	}
	
	public String getPalavraOriginal() {
		return palavraOriginal;
	}
}

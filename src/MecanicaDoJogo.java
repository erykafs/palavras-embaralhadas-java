
public interface MecanicaDoJogo {
	
	// Continuar jogo
	String jogar();
	
	// Pontos do jogo
	int pontos();
	
	// Regras do Jogo
	String regras();
	
	// Verifica se o jogo acabou
	boolean jogoAcabou();
	
	// Verificar se acertou
	boolean verificar(String palavra);
	
	// Resultado do jogo
	String resultado();
	

}

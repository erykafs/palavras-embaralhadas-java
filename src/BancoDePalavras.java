import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class BancoDePalavras {

	public String lerPalavra() {
		List<String> palavras = null;
		int p = 0;
		try {
			palavras = new ArrayList<String>();
			Random gerador = new Random();
			File arq = new File("C:/Users/Eryka/Documents/Particular/Conclusao_Projeto_AGS/Projeto_Latex/Sem6_JogoPalavrasEmbaralhadas/src/palavras.txt");
			//			File arq = new File("palavras.txt");
			Scanner sc = new Scanner(arq);
			while(sc.hasNextLine()) {
				palavras.add(sc.nextLine());
			}
			p = gerador.nextInt(20);
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao ler arquivo"+e);
		}
		return palavras.get(p);
	}

}

import modelo.Tabuleiro;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro (6,6,6);
		
		tabuleiro.abrir(3,3);
		tabuleiro.altenarMarcacao(4, 4);
		tabuleiro.altenarMarcacao(0, 0);
		tabuleiro.abrir(1,2);
		
		System.out.println(tabuleiro);
		
	}
 
}

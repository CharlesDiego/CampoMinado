package visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;



import excecao.ExplosaoException;
import excecao.SairException;
import modelo.Tabuleiro;

public class TabuleiroConsole {
	
		private Tabuleiro tabuleiro;
		Scanner entrada = new Scanner(System.in);

		public TabuleiroConsole(Tabuleiro tabuleiro) {
			
			this.tabuleiro = tabuleiro;
			executarJogo();
		}

		private void executarJogo() {
		 try {
			 
			 boolean continuar = true;
			 
			 while(continuar) {
				 cicloDoJogo();
				 
				 System.out.println("Outra partida? (S/n) ");
				 String resposta = entrada.nextLine();
				 if("n".equalsIgnoreCase(resposta)) {
					 continuar = false;
					 
				 }else {
					 tabuleiro.reiniciar();
				 }
			 }
			 
		 }catch (SairException e) {
			
			 System.out.println("Volte sempre!!!");
		 } finally {
			 entrada.close();
		 }
			
		}

		private void cicloDoJogo() {
			try {
				
				while(!tabuleiro.objetivoAlcancado() ) {
					System.out.println(tabuleiro);
					
					String digitado = capturarValorDigitado("Digite numeros de 1 a 6(x,y) ou sair");
		Iterator<Integer>xy =Arrays.stream(digitado.split(","))
					.map(e-> Integer.parseInt(e.trim())).iterator();
		// trim tira os espaços em branco e evita erros.
				
				digitado = capturarValorDigitado("1- abrir ou 2(des)marcar");
				
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else if ("2".equals(digitado)) {
					tabuleiro.altenarMarcacao(xy.next(), xy.next());
				}
				
					
				}
				System.out.println(tabuleiro);
				System.out.println("Voce ganhou!!");
			}catch (ExplosaoException e) {
				System.out.println(tabuleiro);
				System.out.println("Voce perdeu, Fraco!");
				
			}
			
		}
		private String capturarValorDigitado (String texto) {
			System.out.println(texto);
			String digitado = entrada.nextLine();
			
			if("sair".equalsIgnoreCase(digitado)) {
				throw new SairException();
			}
			return digitado;
		}
		
		
}

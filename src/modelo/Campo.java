package modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private boolean minado;
	private boolean aberto;
	private boolean marcado;
	
	private final int linha;
	private final int coluna;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	
	  public Campo (int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha-vizinho.linha);
		int deltaColuna = Math.abs(coluna-vizinho.coluna);
		int detalGeral = deltaColuna +  deltaLinha;
		
		if (detalGeral ==1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
			
		} else if (detalGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else {
		return false;
		}
	}
	
}

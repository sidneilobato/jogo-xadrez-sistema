package xadrez;

import mesatabuleiro.Mesa;
import mesatabuleiro.Posicao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Mesa mesa;
	
	public PartidaXadrez() {
		mesa = new Mesa(8, 8);
		inicialSetup();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[mesa.getLinhas()][mesa.getColunas()];
		for(int i=0; i<mesa.getLinhas(); i++) {
			for(int j=0; j<mesa.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) mesa.peca(i, j);
			}
		}
		return mat;
	}
	
	private void inicialSetup() {
		mesa.localPeca(new Torre(mesa, Cor.BRANCO), new Posicao(2, 1));
		mesa.localPeca(new Rei(mesa, Cor.PRETO), new Posicao(0, 4));
		mesa.localPeca(new Rei(mesa, Cor.BRANCO), new Posicao(7, 4));
	}
}

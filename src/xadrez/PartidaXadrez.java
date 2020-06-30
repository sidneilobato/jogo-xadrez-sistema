package xadrez;

import mesatabuleiro.Mesa;

public class PartidaXadrez {

	private Mesa mesa;
	
	public PartidaXadrez() {
		mesa = new Mesa(8, 8);
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
}

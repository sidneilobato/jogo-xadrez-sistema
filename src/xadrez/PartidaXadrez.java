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
	
	private void localNovaPeca(char coluna, int linha, PecaXadrez peca) {
		mesa.localPeca(peca, new XadrezPosicao(coluna, linha).toPosicao());
	}
	
	private void inicialSetup() {
		localNovaPeca('b',6,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('e',8,new Rei(mesa, Cor.PRETO));
		localNovaPeca('e',1,new Rei(mesa, Cor.BRANCO));
	}
}

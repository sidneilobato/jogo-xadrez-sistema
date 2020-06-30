package xadrez;

import mesatabuleiro.Mesa;
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
		localNovaPeca('c',1,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('c',2,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('d',2,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('e',2,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('e',1,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('d',1,new Rei(mesa, Cor.BRANCO));
		
		localNovaPeca('c',7,new Torre(mesa, Cor.PRETO));
		localNovaPeca('c',8,new Torre(mesa, Cor.PRETO));
		localNovaPeca('d',7,new Torre(mesa, Cor.PRETO));
		localNovaPeca('e',7,new Torre(mesa, Cor.PRETO));
		localNovaPeca('e',8,new Torre(mesa, Cor.PRETO));
		localNovaPeca('d',8,new Rei(mesa, Cor.PRETO));
		
	}
}

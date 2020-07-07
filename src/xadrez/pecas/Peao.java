package xadrez.pecas;

import mesatabuleiro.Mesa;
import mesatabuleiro.Posicao;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez{
	
	private PartidaXadrez partidaXadrez;

	public Peao(Mesa mesa, Cor cor, PartidaXadrez partidaXadrez) {
		super(mesa, cor);
		this.partidaXadrez = partidaXadrez;
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getMesa().getLinhas()][getMesa().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		if(getCor() == Cor.BRANCO) {
			p.setValores(posicao.getLinha() - 1, posicao.getColuna());
			if(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p) && getMesa().posicaoExistente(p2) && !getMesa().eUmaPeca(p2) && getContaMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			//# movimento especial en passant branco
			if(posicao.getLinha() == 3) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if(getMesa().posicaoExistente(esquerda) && haPecaAdversaria(esquerda) && getMesa().peca(esquerda) == partidaXadrez.getEnPassantVulneravel()) {
					mat [esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if(getMesa().posicaoExistente(direita) && haPecaAdversaria(direita) && getMesa().peca(direita) == partidaXadrez.getEnPassantVulneravel()) {
					mat [direita.getLinha() - 1][direita.getColuna()] = true;
				}
			}
			
		}else {
			p.setValores(posicao.getLinha() + 1, posicao.getColuna());
			if(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p) && getMesa().posicaoExistente(p2) && !getMesa().eUmaPeca(p2) && getContaMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			//# movimento especial en passant preto
			if(posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if(getMesa().posicaoExistente(esquerda) && haPecaAdversaria(esquerda) && getMesa().peca(esquerda) == partidaXadrez.getEnPassantVulneravel()) {
					mat [esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if(getMesa().posicaoExistente(direita) && haPecaAdversaria(direita) && getMesa().peca(direita) == partidaXadrez.getEnPassantVulneravel()) {
					mat [direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}
		
		return mat;
	}


	@Override
	public String toString() {
		return "P";
	}
}

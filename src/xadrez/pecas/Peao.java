package xadrez.pecas;

import mesatabuleiro.Mesa;
import mesatabuleiro.Posicao;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez{

	public Peao(Mesa mesa, Cor cor) {
		super(mesa, cor);
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
		}
		
		return mat;
	}


	@Override
	public String toString() {
		return "P";
	}
}

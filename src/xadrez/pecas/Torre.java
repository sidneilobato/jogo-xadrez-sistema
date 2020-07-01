package xadrez.pecas;

import mesatabuleiro.Mesa;
import mesatabuleiro.Posicao;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez{

	public Torre(Mesa mesa, Cor cor) {
		super(mesa, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getMesa().getLinhas()][getMesa().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//acima
		p.setValores(posicao.getLinha() - 1, posicao.getColuna());
		while(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna() -1);
		while(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p)) {
		mat[p.getLinha()][p.getColuna()] = true;
		p.setColuna(p.getColuna() -1);
		}
		if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//direita
		p.setValores(posicao.getLinha(), posicao.getColuna() +1);
		while(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p)) {
		mat[p.getLinha()][p.getColuna()] = true;
		p.setColuna(p.getColuna() +1);
		}
		if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//abaixo
		p.setValores(posicao.getLinha() + 1, posicao.getColuna());
		while(getMesa().posicaoExistente(p) && !getMesa().eUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if(getMesa().posicaoExistente(p) && haPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
}

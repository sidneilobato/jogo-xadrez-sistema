package xadrez.pecas;

import mesatabuleiro.Mesa;
import mesatabuleiro.Posicao;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez{

	public Cavalo(Mesa mesa, Cor cor) {
		super(mesa, cor);
	}

	@Override
	public String toString() {
		return "C";
	}
	
	private boolean podeMover(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getMesa().peca(posicao);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean [][] mat = new boolean[getMesa().getLinhas()][getMesa().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//ok
		p.setValores(posicao.getLinha() -1, posicao.getColuna() -2);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//ok
		p.setValores(posicao.getLinha() - 2 , posicao.getColuna() - 1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//ok
		p.setValores(posicao.getLinha() - 2, posicao.getColuna() +1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//ok
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 2);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//ok
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 2);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//ok
		p.setValores(posicao.getLinha() + 2, posicao.getColuna() +1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//ok
		p.setValores(posicao.getLinha() + 2, posicao.getColuna() -1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//ok
		p.setValores(posicao.getLinha() +1, posicao.getColuna() - 2);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}
}

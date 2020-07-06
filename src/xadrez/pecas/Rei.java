package xadrez.pecas;

import mesatabuleiro.Mesa;
import mesatabuleiro.Posicao;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez{
	
	private PartidaXadrez partidaXadrez;

	public Rei(Mesa mesa, Cor cor, PartidaXadrez partidaXadrez) {
		super(mesa, cor);
		this.partidaXadrez = partidaXadrez;
	}

	@Override
	public String toString() {
		return "R";
	}
	
	private boolean podeMover(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getMesa().peca(posicao);
		return p == null || p.getCor() != getCor();
	}
	
	private boolean testeTorreRoque(Posicao posicao) {
		PecaXadrez p = (PecaXadrez)getMesa().peca(posicao);
		return p !=null && p instanceof Torre && p.getCor() == getCor() && p.getContaMovimento() == 0;
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean [][] mat = new boolean[getMesa().getLinhas()][getMesa().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//acima
		p.setValores(posicao.getLinha() -1, posicao.getColuna());
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//abaixo
		p.setValores(posicao.getLinha() +1, posicao.getColuna());
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna() -1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//direita
		p.setValores(posicao.getLinha(), posicao.getColuna() +1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//noroeste
		p.setValores(posicao.getLinha() -1, posicao.getColuna() -1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//nordeste
		p.setValores(posicao.getLinha() -1, posicao.getColuna() +1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudoeste
		p.setValores(posicao.getLinha() +1, posicao.getColuna() -1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudeste
		p.setValores(posicao.getLinha() +1, posicao.getColuna() +1);
		if(getMesa().posicaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//#movimentoespecial Roque
		if(getContaMovimento() == 0 && !partidaXadrez.getCheck()) {
			//#Roque pequeno ou do lado do rei
			Posicao posT1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
			if(testeTorreRoque(posT1)) {
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
				if(getMesa().peca(p1) == null && getMesa().peca(p2) == null) {
					mat[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
			}
			//#Roque grande ou do lado do rainha
			Posicao posT2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);
			if(testeTorreRoque(posT2)) {
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
				Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
				if(getMesa().peca(p1) == null && getMesa().peca(p2) == null && getMesa().peca(p3) == null) {
					mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}
			}
		}
			
		
		return mat;
	}
}

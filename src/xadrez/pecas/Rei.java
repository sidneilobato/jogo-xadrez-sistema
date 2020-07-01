package xadrez.pecas;

import mesatabuleiro.Mesa;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez{

	public Rei(Mesa mesa, Cor cor) {
		super(mesa, cor);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean [][] mat = new boolean[getMesa().getLinhas()][getMesa().getColunas()];
		return mat;
	}
}

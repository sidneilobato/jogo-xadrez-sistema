package xadrez.pecas;

import mesatabuleiro.Mesa;
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
		return mat;
	}
}

package xadrez;

import mesatabuleiro.Mesa;
import mesatabuleiro.Peca;

public abstract class PecaXadrez extends Peca{

	private Cor cor;

	public PecaXadrez(Mesa mesa, Cor cor) {
		super(mesa);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}	
}

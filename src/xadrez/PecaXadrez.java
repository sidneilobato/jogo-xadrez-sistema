package xadrez;

import mesatabuleiro.Mesa;
import mesatabuleiro.Peca;
import mesatabuleiro.Posicao;

public abstract class PecaXadrez extends Peca{

	private Cor cor;

	public PecaXadrez(Mesa mesa, Cor cor) {
		super(mesa);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}	
	
	public XadrezPosicao getXadrezPosicao() {
		return XadrezPosicao.fromPosicao(posicao);
	}
	
	protected boolean haPecaAdversaria(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getMesa().peca(posicao);
		return p != null && p.getCor() != cor;
	}
}

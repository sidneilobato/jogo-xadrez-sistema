package mesatabuleiro;

public class Peca {

	protected Posicao posicao;
	private Mesa mesa;
	
	public Peca(Mesa mesa) {
		this.mesa = mesa;
		posicao = null;
	}

	protected Mesa getMesa() {
		return mesa;
	}
	
}

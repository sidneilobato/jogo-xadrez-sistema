package mesatabuleiro;

public class MesaExcecao extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public MesaExcecao(String msg) {
		super(msg);
	}
}

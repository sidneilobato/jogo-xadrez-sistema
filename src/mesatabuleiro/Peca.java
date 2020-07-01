package mesatabuleiro;

public abstract class Peca {

	protected Posicao posicao;
	private Mesa mesa;
	
	public Peca(Mesa mesa) {
		this.mesa = mesa;
		posicao = null;
	}

	protected Mesa getMesa() {
		return mesa;
	}
	
	public abstract boolean[][] possiveisMovimentos();
	
	public boolean possivelMovimento(Posicao posicao) {
		return possiveisMovimentos()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean haPeloMenosUmMovimento() {
		boolean [][] mat =  possiveisMovimentos();
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}

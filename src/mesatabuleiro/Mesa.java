package mesatabuleiro;

public class Mesa {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Mesa(int linhas, int colunas) {
		if(linhas<1  || colunas<1) {
			throw new MesaExcecao("Erro na criação do tabuleiro: Precisa palo menos 1 linha e uma coluna1");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if(!posicaoExistente(linha, coluna)) {
			throw new MesaExcecao("Posição não existe no tabuleiro.");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new MesaExcecao("Posição não existe no tabuleiro.");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void localPeca(Peca peca, Posicao posicao) {
		if(eUmaPeca(posicao)) {
			throw new MesaExcecao("Já existe uma peça nessa posição "+posicao);
		}
		 pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		 peca.posicao = posicao;
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new MesaExcecao("Posição não existe no tabuleiro.");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	
	private boolean posicaoExistente(int linha, int coluna) {
		return linha >=0 && linha < linhas && coluna >=0 && coluna < colunas;
	}
	
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean eUmaPeca (Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new MesaExcecao("Posição não existe no tabuleiro.");
		}
		return peca(posicao) != null;
	}
}

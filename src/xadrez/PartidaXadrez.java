package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mesatabuleiro.Mesa;
import mesatabuleiro.Peca;
import mesatabuleiro.Posicao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private int turno;
	private Cor jogadorAtual;
	private Mesa mesa;
	private boolean check;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	
	public PartidaXadrez() {
		mesa = new Mesa(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		inicialSetup();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Cor getJogadorAtual() {
		return jogadorAtual;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[mesa.getLinhas()][mesa.getColunas()];
		for(int i=0; i<mesa.getLinhas(); i++) {
			for(int j=0; j<mesa.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) mesa.peca(i, j);
			}
		}
		return mat;
	}
	
	public boolean [][] possivelMovimento(XadrezPosicao posicaoOrigem){
		Posicao posicao = posicaoOrigem.toPosicao();
		validarPosicaoOrigem(posicao);
		return mesa.peca(posicao).possiveisMovimentos();
	}
	
	public PecaXadrez performXadrezMovimento(XadrezPosicao posicaoOrigem, XadrezPosicao posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peca pecaCapturada = fazMovimento(origem, destino);
		
		if(testeCheck(jogadorAtual)) {
			desfazMovimento(origem, destino, pecaCapturada);
			throw new XadrezExcecao("Voce nao pode se colocar em xeque.");
		}
		
		check = (testeCheck(oponente(jogadorAtual))) ? true : false;
		
		proximoTurno();
		return (PecaXadrez) pecaCapturada;
	}
	
	private Peca fazMovimento(Posicao origem, Posicao destino) {
		Peca p = mesa.removePeca(origem);
		Peca pecaCapturada = mesa.removePeca(destino);
		mesa.localPeca(p, destino);
		
		if(pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return pecaCapturada;
	}
	
	private void desfazMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
		Peca p = mesa.removePeca(destino);
		mesa.localPeca(p, origem);
		
		if(pecaCapturada != null) {
			mesa.localPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if(!mesa.eUmaPeca(posicao)) {
			throw new XadrezExcecao("n�o existe pe�a na posi��o de origem.");
		}
		if(jogadorAtual != ((PecaXadrez)mesa.peca(posicao)).getCor()) {
			throw new XadrezExcecao("A peca escolhida nao e sua.");
		}
		if(!mesa.peca(posicao).haPeloMenosUmMovimento()) {
			throw new XadrezExcecao("Nao existe movimentos possiveis para a peca escolhida.");
		}
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if(!mesa.peca(origem).possivelMovimento(destino)) {
			throw new XadrezExcecao("A peca escolhida nao pode ser movia para a posicao de destino.");
		}
	}
	
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private PecaXadrez rei(Cor cor) {
		List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for(Peca p : list) {
			if(p instanceof Rei) {
				return (PecaXadrez) p;
			}
		}
		throw new IllegalStateException("Nao existe o Rei da cor "+cor+" no tabuleiro.");
	}
	
	private boolean testeCheck(Cor cor) {
		Posicao posicaoRei = rei(cor).getXadrezPosicao().toPosicao();
		List<Peca> pecasOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList()); 
		for(Peca p : pecasOponente) {
			boolean[][] mat = p.possiveisMovimentos();
			if(mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}
	
	private void localNovaPeca(char coluna, int linha, PecaXadrez peca) {
		mesa.localPeca(peca, new XadrezPosicao(coluna, linha).toPosicao());
		pecasNoTabuleiro.add(peca);
	}
	
	private void inicialSetup() {
		localNovaPeca('c',1,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('c',2,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('d',2,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('e',2,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('e',1,new Torre(mesa, Cor.BRANCO));
		localNovaPeca('d',1,new Rei(mesa, Cor.BRANCO));
		
		localNovaPeca('c',7,new Torre(mesa, Cor.PRETO));
		localNovaPeca('c',8,new Torre(mesa, Cor.PRETO));
		localNovaPeca('d',7,new Torre(mesa, Cor.PRETO));
		localNovaPeca('e',7,new Torre(mesa, Cor.PRETO));
		localNovaPeca('e',8,new Torre(mesa, Cor.PRETO));
		localNovaPeca('d',8,new Rei(mesa, Cor.PRETO));
		
	}
}

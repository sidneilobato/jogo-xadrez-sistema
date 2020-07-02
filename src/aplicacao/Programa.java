package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezExcecao;
import xadrez.XadrezPosicao;

public class Programa {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> capturado = new ArrayList<>();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.imprimePartida(partidaXadrez, capturado);
				System.out.println();
				System.out.print("Origem: ");
				XadrezPosicao origem = UI.lerXadrezPosicao(sc);
				
				boolean[][] possivelMovimentos = partidaXadrez.possivelMovimento(origem);
				UI.clearScreen();
				UI.imprimeMesa(partidaXadrez.getPecas(), possivelMovimentos);
				
				System.out.println();
				System.out.print("Destino: ");
				XadrezPosicao destino = UI.lerXadrezPosicao(sc);
				
				PecaXadrez pecaCapturada = partidaXadrez.performXadrezMovimento(origem, destino);
				
				if(pecaCapturada != null) {
					capturado.add(pecaCapturada);
				}
			}
			catch(XadrezExcecao e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}

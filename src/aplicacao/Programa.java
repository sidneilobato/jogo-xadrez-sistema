package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezPosicao;

public class Programa {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaxadrez = new PartidaXadrez();
		
		while(true) {
			UI.imprimeMesa(partidaxadrez.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			XadrezPosicao origem = UI.lerXadrezPosicao(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			XadrezPosicao destino = UI.lerXadrezPosicao(sc);
			
			PecaXadrez pecaCapturada = partidaxadrez.performXadrezMovimento(origem, destino);
		}
	}

}

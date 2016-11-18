package controle;

import visao.TelaGame;
import java.util.ArrayList;
import modelo.DAOJogador;
import modelo.Jogador;
import visao.TelaMenu;
import visao.TelaGame;
import visao.TelaPrincipal;
import game.Fase;
import game.Musica;
import javax.swing.Timer;


public class Controle {
	TelaPrincipal tlPrincipal;
	Jogador jogo;
	DAOJogador dao;

	public Controle() {
		dao = new DAOJogador();
		tlPrincipal = new TelaPrincipal(this);
		tlPrincipal.setPainel(new TelaMenu(this));
		tlPrincipal.trocaTamanho(780,380);
		tlPrincipal.setVisible(true);
                tlPrincipal.setLocationRelativeTo(null);
                tlPrincipal.setResizable(false);
                }

	public void iniciarJogo(String jogador) {
		tlPrincipal.dispose();
                Fase f = new Fase();
                f.setNomeJogador(jogador);
                new TelaGame(f);
                
	}


	public String getNomeJogador() {

		return this.jogo.getJogador().getNome();
	}

	public ArrayList getRecordes() {

		return this.dao.getRecordes();
	}

	public void concluiu() {
		if (this.dao.salvaJogador(this.jogo.getJogador())) {
			this.tlPrincipal.trocaTamanho(780,400);
			this.tlPrincipal.setPainel(new TelaMenu(this));
		}
	}
	
	public void cancelaJogo(){
		this.tlPrincipal.trocaTamanho(780,400);
		this.tlPrincipal.setPainel(new TelaMenu(this));
	}

}

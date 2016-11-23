package Game_Mario.modelo;

import java.util.Calendar;

public class Jogador {
	String nome;
	int pontuacao;
        Jogador jogador;
	
	public Jogador() {
		this.nome="";
		this.pontuacao=0;		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao){
		this.pontuacao = pontuacao;
	}
	
	public void setSomaPontuacao(int pontuacao){
		this.pontuacao += pontuacao;
	}
        
        public void setPenalidadePontuacao(int pontuacao){
		this.pontuacao -= pontuacao;
	}
        
        public Jogador getJogador() {
		return this.jogador;
        }
}

package Game_Mario.game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {
	
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisible;
	
	private static final int LARGURA_TELA = 1180;
	private static final int VELOCIDADE = 1;
	
	private static int contador = 0;
	
	public Inimigo(int x, int y){
		
		this.x = x;
		this.y = y;
		
		ImageIcon referencia;
		if(contador++ % 3 == 0){
			referencia = new ImageIcon("src/Game_Mario/imagem/laranja.png");
			
		}else{
			
			referencia = new ImageIcon("src/Game_Mario/imagem/banana.png");
		}
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
		
		isVisible = true;	
	}
	public void mexer(){
		
		if(this.x < 0){
			this.x = LARGURA_TELA;
		}else{
			this.x -= VELOCIDADE;
		}
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Image getImagem() {
		return imagem;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}

}

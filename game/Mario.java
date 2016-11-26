package Game_Mario.game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Mario {
	
	private int x, y;
	private int dx, dy;
	private int largura, altura;
	private boolean isVisible;

	private Image imagem;
	private List<Missel> misseis;
	
	public Mario(){
		ImageIcon referencia = new ImageIcon("src/Game_Mario/imagem/mario.gif");
		imagem = referencia.getImage();
               
                
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		misseis = new ArrayList<Missel>();

		this.x = 0;
		this.y = 600;
	}
	
	public void mexer(){
		x += dx;  //
		y += dy;  //
		
		if(this.x < 1){
			x=1;
		}
		if(this.x > 1120){
			x = 1120;
		}
		if(this.y < 200){
			y=200;
		}
		if(this.y > 455){
			y = 455;
		}
	}
	
	public List<Missel> getMisseis() {
		return misseis;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImagem() {
		return imagem;
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void atira(){
		this.misseis.add(new Missel(x + largura, y + altura/2));
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}

	public void keyPressed(KeyEvent tecla){
		
		int codigo = tecla.getKeyCode();

                
		if(codigo == KeyEvent.VK_SPACE){
			atira();
		}

		if(codigo == KeyEvent.VK_UP){
                    for(int i = 1; i <=200; i++ ){
		     dy = -2;
			}
		}	
		
		if(codigo == KeyEvent.VK_DOWN){
			dy = +1;
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			dx = -2;
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = +2;
		}
		System.out.println("X "+x + "Y "+y);
	}
	
       public void keyReleased(KeyEvent tecla){
    	 
    	   int codigo = tecla.getKeyCode();
   		
   		if(codigo == KeyEvent.VK_UP){
   			for(int i = 1; i <=200; i++ )
   			dy = +3;
   		}
   		
   		if(codigo == KeyEvent.VK_DOWN){
   			dy = 0;
   		}
   		
   		if(codigo == KeyEvent.VK_LEFT){
   			dx = 0;
   		}
   		
   		if(codigo == KeyEvent.VK_RIGHT){
   			dx = 0;
   		}
    	   
       }
	
}
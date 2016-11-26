package Game_Mario.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import Game_Mario.modelo.Jogador;
import Game_Mario.controle.Controle;

import java.awt.image.BufferedImage;
import Game_Mario.visao.TelaGame;
import Game_Mario.visao.TelaPrincipal;
import javax.swing.JOptionPane;

public class Fase extends JPanel implements ActionListener {

	private Image fundo;
	private Mario sonic;
	private Timer timer;
	private boolean emJogo;
	private List<Inimigo> inimigos;
        private int fundox = 0;
	private int fundoy = 00;
	private int fundo1x = 1250;
	private int fundo1y = 00;
	private int FPS = 2;
        public Jogador jogo;
        public String nome ;
        boolean run;
        public int pontos; 
        private int vidas;    
        
        
        String musica = "src/Game_Mario/imagem/overworld.mid";
        String gameover = "src/Game_Mario/imagem/gameover.wav";
                   
        public void setNomeJogador(String jogador){
            this.nome = jogador;
        }
        
        public String getNomeJogador() {
            return this.nome;
	}
        
        public void setPontuacao(int pontos){
            this.pontos = pontos;
        }
        
        public int getPontuacao() {
            return this.pontos;
	}
        
        public void setVidas(int vidas){
            this.vidas = vidas;
        }

	public void moveFundo() {
                if (run == true){
		fundox -= 1;
		if (fundox <= (-1250)) {
			fundox = 0;
		}
	}
        }

	public void moveFundo1() {
            if (run == true){
		fundo1x -= 1;
		if (fundo1x == 0) {
			fundo1x = 1250;
                }
            }
                
	}

	private int[][] coordenadas = { {400, 480}, {600, 480}, { 700, 400},{800, 300},{900, 225},{1000, 225},
                                        {1100, 300}, {1200, 400}, {1300, 480},{1500, 480}, {1600, 400},{1700,300},  
                                        {1800, 225}, {1900, 225}, {2000, 225}, {1800, 400}, {1900, 480}, {2000, 480},
                                        {2100, 225},{2100, 480}, {2200, 400}, {2200, 300},{2300, 350}, {2400, 350},
                                        {2500, 300}, {2600, 250}, {2700, 225}, {2800, 250}, {2800,300},{2750, 370}, 
                                        {2650, 350},{3000, 480},{3100, 400},{3200, 350},{3300,300}, {3400, 250},{3000, 250},
                                        {3400, 480},{3100, 300},{3300,400},{3700, 480}, {3800, 450},{3900, 400},{4000,350},{4100,300},{4200,250},{4300,225},
                                        {4400,250},{4500,300},{4600,350},{4700,400},{4800,450},{4900,480},{3700, 225},
                                        {3800,250},{3900,300},{4100,400},{4200,450},{4300,480},{4900,225},{4800, 250},
                                        {4700,300},{4600,400},{4500,450},{4400,480},{5000,480},{5000,450},{5000,400},{5000,350},{5000,300},{5000,250},{5000,225},
                                        {5200,225},{5300,300},{5400,400},{5200,400},{5400,225},{5600,480},{5700, 400},{5800,300},{5600,300},
                                       {5800,480}, {6000, 225},{6100,300},{6200,400},{6000,400},{6200,225},{6300,300},{6400,400},{6500,480},
                                       {6300,480},{6500,300},{6800,300},{6900,250},{7000,225},{6800,350},{6900,400},{7000,450},{7100,450},
                                        {7200,400},{7300,350},{7100,225},{7200,250},{7300,300},{6900,300},{6900,350},
                                        {7000,300},{7000,350},{7100,300},{7100,350},{7200,300},{7200,350},{7800,300},{7900,250},{7000,225},{7800,350},{7900,400},{7000,750},{7100,450},
                                        {8200,400},{8300,350},{8100,225},{8200,250},{8300,300},{7900,300},{7900,350},
                                        {8000,300},{8000,350},{8100,300},{8100,350},{8200,300},{8200,350},{8500,225},{8500,250},{8500,300},{8500,350},{8500,400},{8500,450},{8500,480},
                                        {8600,225},{8600,250},{8600,300},{8600,350},{8600,400},{8600,450},{8600,480},
                                        {8700,225},{8700,250},{8700,300},{8700,350},{8700,400},{8700,450},{8700,480},
                                        {8800,225},{8800,250},{8900,225},{8900,250},{9000,450},{9000,480},{9100,450},
                                        {9100,480},{9300,225},{9300,250},{9300,300},{9300,350},{9300,400},{9300,450},
                                        {9300,480},{9400,225},{9400,250},{9400,300},{9400,350},{9400,400},{9400,450},
                                        {9400,480},{9500,225},{9500,250},{9600,225},{9600,250},{9700,400,},{9700,480},
                                        {9800,400},{9800,480},{9900,225},{9900,250},{9900,300},{9900,350},{9900,400},
                                        {9900,450},{9900,480},{10000,225},{10000,250},{10000,300},{10000,350},{10000,400},
                                        {10000,450},{10000,480},
                
	};

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());
		ImageIcon referencia = new ImageIcon("src/Game_Mario/imagem/fundoprincipal.png");
                nome = new String();    
		fundo = referencia.getImage();
                vidas = 3;
              
		sonic = new Mario();
                Musica a = new Musica();

		emJogo = true;

		inicializaInimigos();

		timer = new Timer(10 / FPS, this);
		timer.start();
                
                if(emJogo == true){
                a.tocarMusica(musica, 999);
                }
                 else
                a.tocarMusica(gameover, 1);
                
        }    

	public void inicializaInimigos() {
		inimigos = new ArrayList<Inimigo>();
		for (int i = 0; i < coordenadas.length; i++) {
			inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));
		}
	}

	public void paint(Graphics g) {

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, fundox, fundoy, null);
		graficos.drawImage(fundo, fundo1x, fundo1y, null);
                

		if (emJogo) {                        
                        run = true;
			graficos.drawImage(sonic.getImagem(), sonic.getX(), sonic.getY(),this);

			List<Missel> misseis = sonic.getMisseis();

			for (int i = 0; i < misseis.size(); i++) {

				Missel m = (Missel) misseis.get(i);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}

			for (int i = 0; i < inimigos.size(); i++) {
				Inimigo in = inimigos.get(i);
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}
                        
                        
                        ImageIcon vida= new ImageIcon("src/Game_Mario/imagem/vida1.png");
                        if(vidas == 3){  
                        graficos.drawImage(vida.getImage(), 95, 60,null);
                        graficos.drawImage(vida.getImage(), 120, 60,null);
                        graficos.drawImage(vida.getImage(), 145, 60,null);
                        }
                        
                        if(vidas == 2){                      
			graficos.drawImage(vida.getImage(), 95, 60,null);
                        graficos.drawImage(vida.getImage(), 120, 60,null);
                        }
                                                
                        if(vidas == 1){                      
			graficos.drawImage(vida.getImage(), 95, 60,null);
                        }
                        
			graficos.setFont(new Font("helvica",Font.BOLD,20));
			graficos.setColor(Color.BLACK);
                        
                        
                        ImageIcon icon= new ImageIcon("src/Game_Mario/imagem/icon.png");
			graficos.drawImage(icon.getImage(), 1, 1,null);
                        
                        graficos.drawString(getNomeJogador() , 95, 30);
			graficos.drawString(pontos+"p", 95, 50);
			
		}
                else{	
                        graficos.setFont(new Font("helvica",Font.BOLD,20));
                        
                        ImageIcon vida= new ImageIcon("src/Game_Mario/imagem/vida1.png");
                        if(vidas == 3){                      
			graficos.drawImage(vida.getImage(), 770, 340,null);
                        graficos.drawImage(vida.getImage(), 795, 340,null);
                        }
                                                
                        if(vidas == 2){                      
			graficos.drawImage(vida.getImage(), 770, 340,null);
                        }

                        
                        if(vidas >= 2){
                        graficos.drawString("Pontuação: "+ pontos, 350, 360);
                        graficos.drawString("Vidas: ", 700, 360);
                        graficos.drawString("C - Continuar", 1045, 560);
                        
                        }
                        
                        if(vidas == 1)
                        {
                           graficos.drawString("S - Salvar", 560, 560);
                           graficos.drawString("Salve a sua pontuação de " + pontos + " pontos!" , 400, 400);  
                        }

                        graficos.drawString("ESC - Sair", 5, 560);
                        graficos.drawString("R - Recomeçar", 860, 560);

                    
			ImageIcon fimJogo= new ImageIcon("src/Game_Mario/imagem/game1.png");
			graficos.drawImage(fimJogo.getImage(), 280, 150,null);
                        
                        run = false;
                       }
		g.dispose();
	}
        
  

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (inimigos.size() == 0) {
			emJogo = false;
		}
                

		List<Missel> misseis = sonic.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missel m = (Missel) misseis.get(i);

			if (m.isVisible()) {
				m.mexer();
			} else {
                                
				misseis.remove(i);;
                                if(run == true){
                                pontos -= 10;
                                 }
			}
		}

		for (int i = 0; i < inimigos.size(); i++) {

			Inimigo in = inimigos.get(i);

			if (in.isVisible()) {
				in.mexer();
			} else {
				inimigos.remove(i);
                                if(run == true){
                                pontos += 50;
                                }
			}
		}

		sonic.mexer();
		checarColisoes();
		moveFundo();
		moveFundo1();
		repaint();
	}

	public void checarColisoes() {

		Rectangle formaNave = sonic.getBounds();
		Rectangle formaInimigo;
		Rectangle formaMissel;

		for (int i = 0; i < inimigos.size(); i++) {

			Inimigo tempInimigo = inimigos.get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaNave.intersects(formaInimigo)) {

				sonic.setVisible(false);
				tempInimigo.setVisible(false);
                                
				emJogo = false;
			}
		}

		List<Missel> misseis = sonic.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missel tempMissel = misseis.get(i);
			formaMissel = tempMissel.getBounds();

			for (int j = 0; j < inimigos.size(); j++) {

				Inimigo tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaMissel.intersects(formaInimigo)) {
					tempInimigo.setVisible(false);
					tempMissel.setVisible(false);
				}
			}
		}

	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
                    
			if((e.getKeyCode() == KeyEvent.VK_C) && emJogo == false){
				emJogo = true;
				sonic = new Mario();
				inicializaInimigos();
                                vidas = vidas - 1;
                                
                                if(vidas == 0)
                                {
                                run = false;
                                pontos = 0;
                                vidas += 3;
                                }
                       }
                        if((e.getKeyCode() == KeyEvent.VK_R) && emJogo == false){
				emJogo = true;
				sonic = new Mario();
				inicializaInimigos();
                                vidas = 3;
 
                       }
                       if((e.getKeyCode() == KeyEvent.VK_S) && vidas == 1){                                                
                                JOptionPane.showMessageDialog(null, "Salvado com sucesso!");
                                setVidas(4);
                                sonic.setVisible(false);                                
				emJogo = false;
                                pontos = 0; 
                                run = false;
                                emJogo = false;
                           
                       }
                       if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                                sonic.setVisible(false);                                
				emJogo = false;
                                pontos = 0; 
                                run = false;
                           JOptionPane.showMessageDialog(null, "Obrigado! :)");
                              System.exit(0);
                           
                       }
			sonic.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
                    sonic.keyReleased(e);
		}
	}
}

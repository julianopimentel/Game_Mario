package visao;

import game.Fase;
import javax.swing.JFrame;

public class TelaGame extends JFrame { 
	
	public  TelaGame(){
	}

    public TelaGame(Fase f) {
        add(f);
        setTitle("SUPER MARIO - BETA");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1200,600);
	setLocationRelativeTo(null);
	setResizable(false);
	setVisible(true);
    }
        public void run( String teste){
            
        }
}

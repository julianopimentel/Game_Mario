/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Mario.game;

import Game_Mario.visao.TelaGame;

/**
 *
 * @author julianop
 */
public class Abrir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Abrir rapido
       Fase f = new Fase();
       f.setNomeJogador("Teste");
       new TelaGame(f);
    }
    
}

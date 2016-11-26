/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Mario.game;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author Juliano Pimentel
 */
public class Musica {
    
    Sequencer player; 
        
        public void tocarMusica(String nome, int repetir){
        try {
            player = MidiSystem.getSequencer();		
            Sequence musica = MidiSystem.getSequence(new File(nome));
            player.open();	
            player.setSequence(musica);	
            player.setLoopCount(repetir); 
            player.start();	
        } catch(Exception e){
            System.out.println("Erro ao tocar: "+nome);
        }
        }
        }
    


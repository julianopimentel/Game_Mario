/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Mario.controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Game_Mario.factory.Conexao;
import java.sql.Connection;

/**
 *
 * @author Juliano Pimentel
 */
public class Insert{
    
        //Metodo para validar login.
        public boolean Cadastro (String nome, int pontos) {
            
            try{  
             
            
                Connection con = Conexao.getConexao();
                
                String sql = "INSERT INTO recordes(jogador, pontuacao) VALUES(?,?)";
                
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, nome);  
                pst.setInt(2, pontos);
                pst.execute();  
                pst.close();
                return true;

                } 
            catch (SQLException u) 
            {   System.out.println("Erro de SQL: " + u);
			u.printStackTrace();
			return false;
            }
           
        }
}

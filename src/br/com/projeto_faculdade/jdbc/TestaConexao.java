/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_faculdade.jdbc;

import javax.swing.JOptionPane;


/**
 *
 * @author user
 */
public class TestaConexao{
     
    public static void main(String[]args){
    
        try {
            new ConnectionFactory().getConnetion();
            JOptionPane.showMessageDialog(null,"Conectado com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"aconteceu um erro em conectar o servidor:" + e);
        }
        
        
    
    }
    
}
   

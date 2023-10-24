/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_faculdade.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author user
 */
public class ConnectionFactory {
    
    public Connection getConnetion(){
    
        try {
            return  DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas","cliente","123");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

  
    
}

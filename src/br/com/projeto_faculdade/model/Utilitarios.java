/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_faculdade.model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;





/**
 *
 * @author user
 */
public class Utilitarios {
    //metodo Limpar Campos
    public void limparTela(JPanel Container){
        Component Components []= Container.getComponents();
        for (Component component:Components){
            if (component instanceof JTextField){
                ((JTextField) component).setText(null);
            }
        }
    }
    
}

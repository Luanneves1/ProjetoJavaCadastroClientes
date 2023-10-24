/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_faculdade.dao;

import br.com.projeto_faculdade.jdbc.ConnectionFactory;
import br.com.projeto_faculdade.model.Clientes;
import br.com.projeto_faculdade.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author luan
 */


public class ClientesDAO {
    
    private  Connection con;
    
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnetion();

};
    
    //Metodo CadastrarCliente
    public void cadastrarCliente(Clientes obj){
        try {
            //1 Comando Sql para inserir ao banco de dados 
            String sql="insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //2 conectar ao banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getEstado());
            
            
            // Executar o comando SQL
            stmt.execute();
            stmt.close();
            
            
            JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO EM :cadastrarCliente" + e);
            
        }
    }
    
    
    //Metedo Alterar Cliente
    public void alterarCliente(Clientes obj){
        try {
            //1 Comando Sql para inserir ao banco de dados 
            String sql="update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
            
            //2 conectar ao banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getEstado());
            stmt.setInt(14,obj.getId());
            
            
            // Executar o comando SQL
            stmt.execute();
            stmt.close();
            
            
            JOptionPane.showMessageDialog(null, "Editado Com Sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: EM alterarCliente" + e);
            
        }
    
    }
    
    
    //metodo ExcluirCliente
    public void excluirCliente(Clientes obj){
    
        try {
            //1 Comando Sql para inserir ao banco de dados 
            String sql= "delete from tb_clientes where id = ?";
            
            //2 conectar ao banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,obj.getId());
            
            
            // Executar o comando SQL
            stmt.execute();
            stmt.close();
            
            
            JOptionPane.showMessageDialog(null, "Excluido Com Sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO EM:excluirCliente:" + e);
            
        }
        
        
        
    }
    
    //Metodo Listar Clientes por CPF
    public Clientes consultaClientePorNome(String nome){
        try {
            //1 passo criar comando sql, oraganizar e executar 
            String sql = "Select*from tb_clientes where nome =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();
            
            Clientes obj = new Clientes();
            if(rs.next()){
            
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setCelular(rs.getString("celular"));
            obj.setCep(rs.getString("cep"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setNumero(rs.getInt("numero"));
            obj.setComplemento(rs.getString("complemento"));
            obj.setBairro(rs.getString("bairro"));
            obj.setCidade(rs.getString("cidade"));
            obj.setEstado(rs.getString("estado"));
            
            }
            
            return obj;
            
        } catch (SQLException e) {
            JOptionPane.showInternalMessageDialog(null,"ERRO EM :consultaClientePorNome"+ e);
            return null; }
    }
    
    
    
    //Metodo Listar Todos os Clientes
    public List<Clientes>listarClientes(){
        try {
            //1passo criar lista
            List<Clientes> lista = new ArrayList<>();
            
            //2 passo criar comando sql, oraganizar e executar 
            String sql = "Select*from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            Clientes obj = new Clientes();
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setCelular(rs.getString("celular"));
            obj.setCep(rs.getString("cep"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setNumero(rs.getInt("numero"));
            obj.setComplemento(rs.getString("complemento"));
            obj.setBairro(rs.getString("bairro"));
            obj.setCidade(rs.getString("cidade"));
            obj.setEstado(rs.getString("estado"));
            
            lista.add(obj);
            
            } 
            return lista;
            
             } 
        catch (SQLException e) {
            JOptionPane.showInternalMessageDialog(null, " ERRO EM :listarClientes" + e);
            return null;
        }
   }
    
    public List<Clientes>buscarClientePorNome(String nome){
        try {
            //1passo criar lista
            List<Clientes> lista = new ArrayList<>();
            
            //2 passo criar comando sql, oraganizar e executar 
            String sql = "Select*from tb_clientes where nome like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            Clientes obj = new Clientes();
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setCelular(rs.getString("celular"));
            obj.setCep(rs.getString("cep"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setNumero(rs.getInt("numero"));
            obj.setComplemento(rs.getString("complemento"));
            obj.setBairro(rs.getString("bairro"));
            obj.setCidade(rs.getString("cidade"));
            obj.setEstado(rs.getString("estado"));
            
            lista.add(obj);
            
            } 
            return lista;
            
             } 
        catch (SQLException e) {
            JOptionPane.showInternalMessageDialog(null, "ERRO EM : buscarClientePorNome" + e);
            return null;
        }
   }
    
    //Buscar Clientes por WEBSERVICES
	
	  public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
	
	
    
    
    
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelos.Cliente;

/**
 *
 * @author gilson
 */
public class ClienteDao {

    public Cliente retornaClientePorId(int id) throws Exception {
        String sql = "SELECT * FROM tabela_anduino where id=?";
        Connection conexao = Conexao.criarConexao();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet resultSet = pstm.executeQuery();
        Cliente cliente = new Cliente();
        while (resultSet.next()) {
            cliente.setId(resultSet.getInt("id"));
            cliente.setNome(resultSet.getString("nome"));
              cliente.setVentilador(resultSet.getString("ventilador"));
           cliente.setLuzsala(resultSet.getString("luzsala"));
            cliente.setTv(resultSet.getString("tv"));
             cliente.setLuzquato(resultSet.getString("luzquato"));
        }
        return cliente;
    }

    public List<Cliente> retornaClientes() throws Exception {
        String sql = "SELECT * FROM tabela_anduino order by nome";
        Connection conexao = Conexao.criarConexao();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<Cliente> clientes = new LinkedList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(resultSet.getInt("id"));
            cliente.setNome(resultSet.getString("nome"));
              cliente.setVentilador(resultSet.getString("ventilador"));
               cliente.setLuzsala(resultSet.getString("luzsala"));
                cliente.setTv(resultSet.getString("tv"));
             cliente.setLuzquato(resultSet.getString("luzquato"));
        
            clientes.add(cliente);
        }
        return clientes;
    }

    public String insereCliente(Cliente cliente) throws Exception {
        String sql = "INSERT INTO tabela_anduino(nome,ventilador,luzsala,tv,luzquato) VALUES(?,?,?,?,?)";
        Connection conexao = Conexao.criarConexao();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getVentilador());
          pstm.setString(3, cliente.getLuzsala());
            pstm.setString(4, cliente.getTv());
             pstm.setString(5, cliente.getLuzquato());
        pstm.executeUpdate();
        return "Adicionado com sucesso.";
    }

    public String atualizaCliente(Cliente cliente) throws Exception {
        String sql = "UPDATE tabela_anduino SET nome = ?,ventilador = ?,luzsala = ?,tv = ?,luzquato = ? WHERE id = ?";
        Connection conexao = Conexao.criarConexao();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setString(1, cliente.getNome());
          pstm.setString(2, cliente.getVentilador());
            pstm.setString(3, cliente.getLuzsala());
             pstm.setString(4, cliente.getTv());
              pstm.setString(5, cliente.getLuzquato());
        pstm.setInt(6, cliente.getId());
        pstm.executeUpdate();
        return "Atualizado com sucesso.";
    }
    
    public String removeCliente(int id) throws Exception {
        String sql = "delete from tabela_anduino WHERE id = ?";
        Connection conexao = Conexao.criarConexao();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        return "Removido com sucesso.";
    }

}
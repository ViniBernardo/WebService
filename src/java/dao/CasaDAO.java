/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
//import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import recursos.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelos.CasaCliente;

/**
 *
 * @author Rodrigo
 */
public class CasaDAO {

    private CasaCliente casa;
    private Connection conexao;
    private ConnectionFactory manager;

    public CasaDAO() throws SQLException, ClassNotFoundException {
        this.manager = ConnectionFactory.getInstance();
        this.conexao = manager.getConn();
        this.conexao.setAutoCommit(false);
    }
    
    public void inserir(CasaCliente casa) throws SQLException {
        
        String sql = "INSERT INTO casa (ventilador,luz_sala,tv,luz_quarto,data,hora) values (?,?,?,?,?,?)";
        java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setBoolean(1, casa.getVentilador());
        ps.setBoolean(2, casa.getLuz_sala());
        ps.setBoolean(3, casa.getTv());
        ps.setBoolean(4, casa.getLuz_quarto());
        ps.setTimestamp(5, casa.getData());      
        ps.setTime(6, casa.getHora());
        ps.execute();
        conexao.commit();
    }
    
    public void deletar (CasaCliente casa) throws SQLException {
       String sql = "UPDATE casa SET status = '0' WHERE casa.id_cadastro = ?";
       PreparedStatement ps = conexao.prepareStatement(sql);
       ps.setInt(1, casa.getId_cadastro());
       ps.execute();
       conexao.commit();
        System.out.println("deletado com sucesso"); 
    }
    
    public void atualizar (CasaCliente casa) throws SQLException {
       String sql = "UPDATE casa SET ventilador = ?, luz_sala = ?, tv = ?, luz_quarto = ?, data = ?, hora = ? WHERE casa.id_cadastro = ?";
       PreparedStatement ps = conexao.prepareStatement(sql);
       ps.setBoolean(1, casa.getVentilador());
       ps.setBoolean(2, casa.getLuz_sala());
       ps.setBoolean(3, casa.getTv());
       ps.setBoolean(4, casa.getLuz_quarto());
       ps.setTimestamp(5, casa.getData());
       ps.setTime(6, casa.getHora());
       ps.setInt(7, casa.getId_cadastro());
       ps.executeUpdate();
       conexao.commit();
    }
    
    public CasaCliente buscarAgendamento (Integer id) throws SQLException {
        String sql = "SELECT * FROM casa WHERE casa.id_cadastro = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            casa = new CasaCliente();
            casa.setId_cadastro(rs.getInt("id_cadastro"));
            casa.setVentilador(rs.getBoolean("ventilador"));
            casa.setLuz_sala(rs.getBoolean("luz_sala"));
            casa.setTv(rs.getBoolean("tv"));
            casa.setLuz_quarto(rs.getBoolean("luz_quarto"));
            casa.setData(rs.getTimestamp("data"));
            casa.setHora(rs.getTime("hora"));
            casa.setStatus(rs.getBoolean("status"));
        }
        conexao.commit();
        return casa;
    }
    
    public List <CasaCliente> listarAgendamentos () throws SQLException {
        List listaDeAgendamentos = new LinkedList<>();
        //String sql = "SELECT * FROM casa ORDER BY casa.hora DESC and casa.data DESC and WHERE casa.status = true";
        String sql = "SELECT * FROM casa WHERE casa.status = true";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            casa = new CasaCliente();            
            casa.setId_cadastro(rs.getInt("id_cadastro"));
            casa.setVentilador(rs.getBoolean("ventilador"));
            casa.setLuz_sala(rs.getBoolean("luz_sala"));
            casa.setTv(rs.getBoolean("tv"));
            casa.setLuz_quarto(rs.getBoolean("luz_quarto"));
            casa.setData(rs.getTimestamp("data"));
            casa.setHora(rs.getTime("hora"));
            casa.setStatus(rs.getBoolean("status"));
            
            listaDeAgendamentos.add(casa);
        }
        conexao.commit();
        return listaDeAgendamentos;
        
    }
    
    public List <CasaCliente> paginar (Integer pag, Integer quant) throws SQLException {
        List listaDeAgendamentos = new LinkedList<>();
        String sql = "SELECT * FROM casa WHERE casa.status = true LIMIT ? OFFSET ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, quant);
        ps.setInt(2, pag);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            casa = new CasaCliente();            
            casa.setId_cadastro(rs.getInt("id_cadastro"));
            casa.setVentilador(rs.getBoolean("ventilador"));
            casa.setLuz_sala(rs.getBoolean("luz_sala"));
            casa.setTv(rs.getBoolean("tv"));
            casa.setLuz_quarto(rs.getBoolean("luz_quarto"));
            casa.setData(rs.getTimestamp("data"));
            casa.setHora(rs.getTime("hora"));
            casa.setStatus(rs.getBoolean("status"));
            
            listaDeAgendamentos.add(casa);
        }
        conexao.commit();
        return listaDeAgendamentos;
        
    }
    
    public CasaCliente tempoCerto (String data, String hora) throws SQLException {
        //List<Casa> agendamentos = new LinkedList<>();
        String sql = "SELECT * FROM casa WHERE casa.data = ? and casa.hora = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, data);
        ps.setString(2, hora+"%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            casa = new CasaCliente();
            casa.setId_cadastro(rs.getInt("id_cadastro"));
            casa.setVentilador(rs.getBoolean("ventilador"));
            casa.setLuz_sala(rs.getBoolean("luz_sala"));
            casa.setTv(rs.getBoolean("tv"));
            casa.setLuz_quarto(rs.getBoolean("luz_quarto"));
            casa.setData(rs.getTimestamp("data"));
            casa.setHora(rs.getTime("hora"));
            casa.setStatus(rs.getBoolean("status"));          
            
            //agendamentos.add(casa);
        }
        
        return casa;
    }
    
    public CasaCliente tempoCertoLong (Long data, String hora) throws SQLException {
        //List<Casa> agendamentos = new LinkedList<>();
        String sql = "SELECT * FROM casa WHERE casa.data = ? and casa.hora = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setLong(1, data);
        ps.setString(2, hora);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            casa = new CasaCliente();
            casa.setId_cadastro(rs.getInt("id_cadastro"));
            casa.setVentilador(rs.getBoolean("ventilador"));
            casa.setLuz_sala(rs.getBoolean("luz_sala"));
            casa.setTv(rs.getBoolean("tv"));
            casa.setLuz_quarto(rs.getBoolean("luz_quarto"));
            casa.setData(rs.getTimestamp("data"));
            casa.setHora(rs.getTime("hora"));
            casa.setStatus(rs.getBoolean("status"));          
            
            //agendamentos.add(casa);
        }
        
        return casa;
    }
    
}

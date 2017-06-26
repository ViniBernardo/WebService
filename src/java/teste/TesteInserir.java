/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.CasaDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import modelos.CasaCliente;

/**
 *
 * @author Rodrigo
 */
public class TesteInserir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CasaDAO cdao = new CasaDAO();
            CasaCliente c1 = new CasaCliente();
            Time hora = new Time(System.currentTimeMillis());
            Timestamp data = new Timestamp(System.currentTimeMillis());
            c1.setData(data);
            c1.setHora(hora);
            c1.setLuz_quarto(true);
            c1.setTv(true);
            c1.setVentilador(true);
            c1.setLuz_sala(true);
            cdao.inserir(c1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}

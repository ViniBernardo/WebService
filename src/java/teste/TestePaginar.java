/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import bo.CasaBO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.CasaCliente;

/**
 *
 * @author Rodrigo
 */
public class TestePaginar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CasaBO cbo = new CasaBO();
            List <CasaCliente> agendamentos = new LinkedList<>();
            agendamentos = cbo.paginar(1, 6);
            
            for (CasaCliente c : agendamentos) {
                System.out.println(c.getId_cadastro());
            }
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
            
    }
    
}

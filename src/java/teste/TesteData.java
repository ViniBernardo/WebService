/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import bo.CasaBO;
import dao.CasaDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelos.CasaCliente;

/**
 *
 * @author Vinicius
 */
public class TesteData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            CasaBO cbo = new CasaBO();
            List <CasaCliente> agendamentos = new LinkedList<>();
            CasaCliente c1 = new CasaCliente();
            //agendamentos = cbo.verificarAgendamentos(n);
            /*
            String hora = "22:37:15";
            String vetString [] = new String[4];
            vetString = hora.split(":");
            String hInicial = vetString[0]+":"+vetString[1]+":00";
            String hFinal = vetString[0]+":"+vetString[1]+":59";
            System.out.println("Hora inicial "+hInicial);
            System.out.println("Hora final "+hFinal);
            */
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

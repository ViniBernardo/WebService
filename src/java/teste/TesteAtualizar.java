/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.CasaDAO;
import java.sql.SQLException;
import modelos.CasaCliente;

/**
 *
 * @author Vinicius
 */
public class TesteAtualizar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CasaDAO cdao = new CasaDAO();
            //Casa casa = new Casa(true, true, true, false,"2017-05-18", "18:30:20");
            CasaCliente c1 = new CasaCliente();
            //cdao.inserir(casa);
            c1 = cdao.buscarAgendamento(5);
            //c1.setData(data);
            cdao.atualizar(c1);
            System.out.println("Deu certo");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

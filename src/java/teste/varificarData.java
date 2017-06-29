/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import bo.CasaBO;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.CasaCliente;

/**
 *
 * @author Vinicius
 */
public class varificarData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Long d = new Long("1497233556869");
            Long sis = new Long("1497153600000");
            Long h = new Long("83223000");
            Time tempo = new Time(20,43,23);
            Timestamp data = new Timestamp(d);
            Timestamp dataSis = new Timestamp(sis);
            Time hora = new Time(h);
            CasaCliente c = new CasaCliente();
            CasaCliente casa = new CasaCliente(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, data, hora, Boolean.TRUE);
            casa.setData(data);
            casa.setHora(tempo);
            
            CasaBO cbo = new CasaBO();
           
            String str = data.toString();
            String vetor[] = str.split(" ");
            System.out.println(vetor[0]);
            //c = cbo.verificarAgendamentos("2017-6-11","22:25:36");
            System.out.println("Buscou");
            System.out.println(c.getId_cadastro());
        } catch (SQLException ex) {
            Logger.getLogger(varificarData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(varificarData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

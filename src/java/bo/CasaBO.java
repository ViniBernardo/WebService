/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.CasaDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import modelos.CasaCliente;

/**
 *
 * @author Rodrigo
 */
public class CasaBO {

    private CasaCliente casa;
    private CasaDAO cdao;

    public CasaBO() throws SQLException, ClassNotFoundException {
        cdao = new CasaDAO();
    }

    public void agendar(CasaCliente casa) throws SQLException {
        cdao.inserir(casa);
    }

    public void deletar(CasaCliente casa) throws SQLException {
        cdao.deletar(casa);
    }

    public void atualizar(CasaCliente casa) throws SQLException {
        cdao.atualizar(casa);
    }

    public CasaCliente buscarAgendamento(Integer id) throws SQLException {
        return cdao.buscarAgendamento(id);
    }

    public CasaCliente verificarAgendamentos(String data, String hora) throws SQLException {
        return cdao.tempoCerto(data,hora);
    }
    
    public CasaCliente verificarAgendamentos(Long data, String hora) throws SQLException {
        return cdao.tempoCertoLong(data,hora);
    }

    public List<CasaCliente> listarAgendamentos() throws SQLException {
        return cdao.listarAgendamentos();
    }

    public List<CasaCliente> paginar(Integer pag, Integer quant) throws SQLException, ClassNotFoundException {
        int inicio = pag;
        if (pag == 1) {
            inicio = 0;
        } else {
            inicio = (pag * quant)-quant;
        }
        return cdao.paginar(inicio, quant);
    }

}

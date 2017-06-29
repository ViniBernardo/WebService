/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelos.CasaCliente;
import bo.CasaBO;
import com.google.gson.Gson;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author Vinicius
 */
@Path("casa_service")
public class CasaService {

    @Context
    private UriInfo context;
    private CasaBO csaBo;

    /**
     * Creates a new instance of CasaServise
     */
    public CasaService() {
    }

    /**
     * Retrieves representation of an instance of recursos.CasaServise
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "entrou";
    }

    // buscar por id
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAgendamento/{id}")
    public String buscarAgendamento(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
        CasaCliente casa = new CasaCliente();
        csaBo = new CasaBO();
        casa = csaBo.buscarAgendamento(id);
        // Biblioteca do google para transformar meu objeto casa em JSON
        Gson casaJSON = new Gson();
        return casaJSON.toJson(casa);
    }

    // selecionar todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarAgendamentos")
    public String listarAgendamentos() throws SQLException, ClassNotFoundException {
        List<CasaCliente> listar = new LinkedList<>();
        csaBo = new CasaBO();
        listar = csaBo.listarAgendamentos();
        // convertendo para JSON
        Gson listaAgendamentoJSON = new Gson();
        // retornando lista de agendamentos
        return listaAgendamentoJSON.toJson(listar);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscarAgendamentos/{data}/{hora}")
    public String buscarAgendamentos(@PathParam("data") Long data,@PathParam ("hora") String hora) throws SQLException, ClassNotFoundException {
        Timestamp d = new Timestamp(data);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        CasaCliente casa = new CasaCliente();
        csaBo = new CasaBO();
        casa = csaBo.verificarAgendamentos(format.format(d),hora);
        // convertendo para JSON
        Gson casaJSON = new Gson();
        return casaJSON.toJson(casa);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("tempoCerto/{data}/{hora}")
    public String buscarPorData(@PathParam("data") Long data,@PathParam ("hora") String hora) throws SQLException, ClassNotFoundException {
        Timestamp d = new Timestamp(data);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        CasaCliente casa = new CasaCliente();
        csaBo = new CasaBO();
        casa = csaBo.verificarAgendamentos(format.format(d),hora);
        // convertendo para JSON
        Gson casaJSON = new Gson();
        return casaJSON.toJson(casa);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarPorPagina/{pag}/{quant}")
    public String paginar(@PathParam("pag") Integer pag, @PathParam("quant") Integer quant) throws SQLException, ClassNotFoundException {
        List<CasaCliente> listaPaginada = new LinkedList<>();
        csaBo = new CasaBO();
        listaPaginada = csaBo.paginar(pag, quant);
        // convertendo para JSON
        Gson paginarJSON = new Gson();
        // retornando lista de agendamentos por data e hora
        return paginarJSON.toJson(listaPaginada);
    }

    /**
     * POST method for updating or creating an instance of CasaServise
     *
     * @param content representation for the resource
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("marcarAgendamento")
    public void marcarAgendamento(String content) throws SQLException, ClassNotFoundException {

        CasaCliente casa = new CasaCliente();
        Gson casaJson = new Gson();
        csaBo = new CasaBO();

        // converter objeto json para java
        casa = (CasaCliente) casaJson.fromJson(content, CasaCliente.class);

        //inserindo casa
        csaBo.agendar(casa);
    }
    

    /**
     * PUT method for updating or creating an instance of CasaServise
     *
     * @param content representation for the resource
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)    
    @Path("deletarAgendamento")
    public void deletar(String content) 
            throws SQLException, ClassNotFoundException 
    {   
        CasaCliente casa = new CasaCliente();
        Gson casaJson = new Gson();
        csaBo = new CasaBO();

        // converter objeto json para java
        casa = (CasaCliente) casaJson.fromJson(content, CasaCliente.class);

        //delete casa
        
        csaBo.deletar(casa);        
       
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("atualizarAgendamento")
    public void atualizar (String content) 
            throws SQLException, ClassNotFoundException 
    {   
        CasaCliente casa = new CasaCliente();
        Gson casaJson = new Gson();
        csaBo = new CasaBO();

        // converter objeto json para java
        casa = (CasaCliente) casaJson.fromJson(content, CasaCliente.class);

        //atualiza cadastro
        csaBo.atualizar(casa);
       
    }
}

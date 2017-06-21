/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import dao.ClienteDao;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import modelos.Cliente;

/**
 * REST Web Service
 *
 * @author gilson
 */
@Path("cliente")
public class ClienteRecurso {
    
    private ClienteDao clienteDao = new ClienteDao();
   
    //Exemplo de url: http://localhost:8080/CrudRest/cliente/1
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Cliente getClientePorId(@PathParam(value="id") int id) throws Exception {
        return clienteDao.retornaClientePorId(id);
    }
    
    //Exemplo de url: http://localhost:8080/CrudRest/cliente
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes() throws Exception {
        return clienteDao.retornaClientes();
    }
    
    //Exemplo de url: http://localhost:8080/CrudRest/cliente
    @POST
    @Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String inserir(Cliente cliente) throws Exception {
        return clienteDao.insereCliente(cliente);
    }
    
    //Exemplo de url: http://localhost:8080/CrudRest/cliente
    @PUT
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String updateCliente(Cliente cliente) throws Exception {
        return clienteDao.atualizaCliente(cliente);
    }
    
    //Exemplo de url: http://localhost:8080/CrudRest/cliente/1
    @DELETE
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String deleteClientePorId(@PathParam(value="id") int id) throws Exception {
        return clienteDao.removeCliente(id);
    }
    
    
}
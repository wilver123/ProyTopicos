/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import entidad.Cliente;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.ClienteDao;

/**
 *
 * @author Wilver
 */
@WebService(serviceName = "webservice")
public class webservice {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IngresarCliente")
    public String IngresarCliente(@WebParam(name = "nombre") String nombre, @WebParam(name = "ci") String ci, @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion, @WebParam(name = "sexo") String sexo) {
        Cliente clie=new Cliente(nombre, ci, correo, direccion, sexo);
        ClienteDao clienteDao=new ClienteDao();
        clienteDao.insertar(clie);
        return  "cliente ingresado";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarCliente")
    public String BuscarCliente(@WebParam(name = "id") int id) {
        ClienteDao clienteDao=new ClienteDao();
        return clienteDao.consultarCliente(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarClientes")
    public List<Cliente> ConsultarClientes() {
 ClienteDao clienteDao=new ClienteDao();
 List<Cliente>listaclientes=clienteDao.verClientes();
 return listaclientes;
    }


}

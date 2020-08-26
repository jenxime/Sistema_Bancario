/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entitys.Cliente;
import Sessions.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Xime
 */
@ManagedBean(name = "JSFManagedBean_Sistema_Bancario")
//@RequestScoped
@SessionScoped
public class JSFManagedBean_Sistema_Bancario implements Serializable {
    //las variables 
    @EJB
    private ClienteFacadeLocal manejadorCliente;
    private List<Cliente> ListarCliente;
    private Cliente cliente;

    public JSFManagedBean_Sistema_Bancario() {
    }
    //CODIGO PARA AGREGAR A UN CLIENTE
  
    public void grabarCliente() {
        manejadorCliente.create(cliente);
        this.ListarCliente();
        //this.recuperarCliente();
    }
    
    public void ListarCliente() {
        setListarCliente(manejadorCliente.findAll());
    }

    
    @PostConstruct
    private void inicio() {
        cliente = new Cliente();
        ListarCliente();
    }

    public ClienteFacadeLocal getManejadorCliente() {
        return manejadorCliente;
    }

    public void setManejadorCliente(ClienteFacadeLocal manejadorCliente) {
        this.manejadorCliente = manejadorCliente;
    }

    public List<Cliente> getListarCliente() {
        return ListarCliente;
    }

    public void setListarCliente(List<Cliente> ListarCliente) {
        this.ListarCliente = ListarCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}

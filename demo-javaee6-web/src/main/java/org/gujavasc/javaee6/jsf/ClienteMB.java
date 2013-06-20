/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gujavasc.javaee6.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.gujavasc.javaee6.ejb.ClienteFacadeLocal;
import org.gujavasc.javaee6.jpa.Cliente;

/**
 *
 * @author rodrigo
 */
@Named(value = "clienteMB")
@SessionScoped
public class ClienteMB implements Serializable {

    private Cliente cliente = new Cliente();
    
    @Inject
    private ClienteFacadeLocal ejb;
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String salvar() {
        ejb.create(cliente);
        return "list";
    }
    
    @Produces @Named("listaClientes") @SessionScoped
    public List<Cliente> getClientes() {
        return ejb.findAll();
    }
    
}

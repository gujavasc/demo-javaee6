/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gujavasc.javaee6.ejb;

import java.util.List;
import javax.ejb.Local;
import org.gujavasc.javaee6.jpa.Cliente;

/**
 *
 * @author rodrigo
 */
@Local
public interface ClienteFacadeLocal {

    void create(Cliente cliente);

    void edit(Cliente cliente);

    void remove(Cliente cliente);

    Cliente find(Object id);

    List<Cliente> findAll();

    List<Cliente> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gujavasc.javaee6.ejb;

import java.util.List;
import javax.ejb.Local;
import org.gujavasc.javaee6.jpa.Produto;

/**
 *
 * @author rodrigo
 */
@Local
public interface ProdutoFacadeLocal {

    void create(Produto produto);

    void edit(Produto produto);

    void remove(Produto produto);

    Produto find(Object id);

    List<Produto> findAll();

    List<Produto> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gujavasc.javaee6.ejb;

import java.util.List;
import javax.ejb.Local;
import org.gujavasc.javaee6.jpa.Pagamento;

/**
 *
 * @author rodrigo
 */
@Local
public interface PagamentoFacadeLocal {

    void create(Pagamento pagamento);

    void edit(Pagamento pagamento);

    void remove(Pagamento pagamento);

    Pagamento find(Object id);

    List<Pagamento> findAll();

    List<Pagamento> findRange(int[] range);

    int count();
    
    void processaPagamento(Pagamento pagamento);
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gujavasc.javaee6.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author rodrigo
 */
@MessageDriven(mappedName = "jms/queue/pagamento", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ProcessaPagamentoMDB implements MessageListener {
    
    public ProcessaPagamentoMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("Processando o pagamento do pedido");
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessaPagamentoMDB.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        System.out.println("Fim -> Processando o pagamento do pedido");
        
    }
}

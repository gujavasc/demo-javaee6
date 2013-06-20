/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gujavasc.javaee6.ejb;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.gujavasc.javaee6.jpa.Pagamento;

/**
 *
 * @author rodrigo
 */
@Stateless
public class PagamentoFacade extends AbstractFacade<Pagamento> implements PagamentoFacadeLocal {
    
    @Resource(mappedName = "jms/queue/pagamento")
    private Queue queuePagamento;
    @Resource(mappedName = "jms/queue/pagamentoFactory")
    private ConnectionFactory queuePagamentoFactory;
    @PersistenceContext(unitName = "org.gujavasc_demo-javaee6-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagamentoFacade() {
        super(Pagamento.class);
    }
    
    @Override
    public void processaPagamento(Pagamento pagamento) {
        try {
            sendJMSMessageToPagamento(pagamento);
        } catch (JMSException ex) {
            Logger.getLogger(PagamentoFacade.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    private Message createJMSMessageForjmsQueuePagamento(Session session, 
            Object messageData) throws JMSException {
        // TODO create and populate message to send
        ObjectMessage om = session.createObjectMessage();
        om.setObject((Serializable) messageData);
        return om;
    }

    private void sendJMSMessageToPagamento(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = queuePagamentoFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queuePagamento);
            messageProducer.send(
                    createJMSMessageForjmsQueuePagamento(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(
                            Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    
    
}

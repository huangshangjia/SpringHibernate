package com.manage.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author geloin
 * @date 2012-9-10 下午6:22:43
 */
public class MyMessageProducer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = null;
        Connection conn = null;
        Session session = null;
        Destination dest = null;
        MessageProducer producer = null;
        Message message = null;
        boolean useTransaction = false;
        try {
            Context ctx = new InitialContext();
            factory = (ConnectionFactory)ctx.lookup("ConnectionFactoryName");
            conn = factory.createConnection();
            conn.start();
            session = conn.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
            dest = session.createQueue("TEST.QUEUE");
            producer = session.createProducer(dest);
            message = session.createTextMessage("This is a test");
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
            session.close();
            conn.close();
        }
    }
}

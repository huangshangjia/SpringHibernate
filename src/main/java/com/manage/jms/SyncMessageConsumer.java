package com.manage.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SyncMessageConsumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = null;
        Connection conn = null;
        Session session = null;
        Destination dest = null;
        MessageConsumer consumer = null;
        Message message = null;
        boolean useTransaction = false;
        try {
            Context ctx = new InitialContext();
            factory = (ConnectionFactory) ctx.lookup("ConnectionFactoryName");
            conn = factory.createConnection();
            conn.start();
            session = conn.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
            dest = session.createQueue("TEST.QUEUE");
            consumer = session.createConsumer(dest);
            message = (TextMessage)consumer.receive(1000);
            System.out.println("Received message: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
            session.close();
            conn.close();
        }
    }
}

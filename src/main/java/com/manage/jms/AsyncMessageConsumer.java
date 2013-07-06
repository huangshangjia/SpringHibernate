package com.manage.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class AsyncMessageConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            System.out.println("Received message:" + message);
        }
    }

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = null;
        Connection conn = null;
        Session session = null;
        Destination dest = null;
        MessageConsumer consumer = null;
        boolean useTransaction = false;
        try {
            Context ctx = new InitialContext();
            factory = (ConnectionFactory) ctx.lookup("ConnectionFactoryName");
            conn = factory.createConnection();
            conn.start();
            session = conn.createSession(useTransaction,
                    Session.AUTO_ACKNOWLEDGE);
            dest = session.createQueue("TEST.QUEUE");
            consumer = session.createConsumer(dest);
            consumer.setMessageListener(new AsyncMessageConsumer());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
            session.close();
            conn.close();
        }
    }
}

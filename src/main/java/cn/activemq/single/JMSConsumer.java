/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.activemq.single;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zhangjinci
 * @version 2016/8/6 11:28
 * @function
 */
public class JMSConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址

    public static void main(String[] args){
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;

        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME,JMSConsumer.PASSWORD,JMSConsumer.BROKEURL);

        try{
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue("HelloWorld");
            messageConsumer = session.createConsumer(destination);

            while (true){
                TextMessage message = (TextMessage) messageConsumer.receive(100000);
                if (message != null){
                    System.out.println("接收到的消息为-->" + message.getText());
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

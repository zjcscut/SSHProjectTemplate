/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.activemq.spring.consumer.queue;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author zhangjinci
 * @version 2016/8/6 14:44
 * @function 队列消息监听器2
 */
@Component("queueReceiver1")
public class QueueReceiver1 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try{
            System.out.println("QueueReceiver1接收到的消息为--> " + ((TextMessage)message).getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

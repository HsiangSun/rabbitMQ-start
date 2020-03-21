package cn.hsiangsun.mq.controller;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Start implements InitializingBean{
	
	@Autowired
	AmqpAdmin admin;

	@Override
	public void afterPropertiesSet() throws Exception {
		//创建exchange
		admin.declareExchange(new DirectExchange("amqp.direct",true,false));
		//创建queue
		admin.declareQueue(new Queue("amqp.queue", true));
		
		//binding
		admin.declareBinding(new Binding("amqp.queue", DestinationType.QUEUE,"amqp.direct" , "amqp.routing",null));
		
		System.out.println("----------RabbitMQ初始化完成------------");
	}

}

package cn.hsiangsun.mq.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
public class AdminController {
	
	@RabbitListener(queues = "email_queue")
	public void listener(Message msg) {//这里接受的类型需要和covertAndSend时候的类型一致如果不知道可以使用Message接收
		System.out.println(msg.toString());
	}
	
}

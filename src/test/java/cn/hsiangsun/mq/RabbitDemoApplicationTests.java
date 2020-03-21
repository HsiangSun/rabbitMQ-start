package cn.hsiangsun.mq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RabbitDemoApplicationTests {

	@Autowired
	RabbitTemplate template;

	/**
	 * 测试发送消息
	 */
	@Test
	public void sendMsg() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "jimmy");
		map.put("list", Arrays.asList("哈哈", 123, true));
		//convertAndSend(exchange,routingKey,message)
		template.convertAndSend("exchange_direct", "email", map);
	}
	 
	/**
	 *测试接受消息
	 */
	@Test
	public void receiveMsg() {
		Object received = template.receiveAndConvert("email_queue");
		System.out.println(received.getClass());
		System.out.println(received);
	}
	
	/**
	 * 测试广播消息
	 */
	@Test
	public void tetsFanOut() {
		//exchange type = fanout 时不需要routingKey
		template.convertAndSend("exchange_fanout","","{\"message\":\"hello rabbit\"}");
	}
	

}

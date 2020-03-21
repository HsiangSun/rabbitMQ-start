package cn.hsiangsun.mq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyRabbitConfig {
	
	
	/**
	 * 不使用默认的消息序列化方案采用json的序列化建议不要修改效率低
	 */
	@Bean
	public MessageConverter myMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
}

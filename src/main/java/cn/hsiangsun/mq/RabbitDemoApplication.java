package cn.hsiangsun.mq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit //开启rabbitMQ注解监听
public class RabbitDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitDemoApplication.class, args);
	}

}

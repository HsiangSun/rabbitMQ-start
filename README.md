# RabbitMq学习总结

### 1.发送消息

```java

	template.convertAndSend("exchange_direct", "email", map);
	
```

### 2.手动切换covert格式

```java

		@Bean
		public MessageConverter myMessageConverter() {
			return new Jackson2JsonMessageConverter();
		}
	
```

### 3.在springBoot启动完成后自动设置RabbitMq配置

```java

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

```
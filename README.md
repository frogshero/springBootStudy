用spring-boot-maven-plugin打包
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_101
mvnw package

覆盖spring-boot-starter-parent的组件版本
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-dependencies</artifactId>
https://github.com/spring-projects/spring-boot/blob/v2.0.3.RELEASE/spring-boot-project/spring-boot-dependencies/pom.xml
<properties>
	<spring-data-releasetrain.version>Fowler-SR2</spring-data-releasetrain.version>
</properties>

禁止某些自动配置
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

定义某个logger的日志级别
logging.level.<logger-name>=<level>

获取定义在spring.factries里的context创建之前的bean:
SpringApplication.setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));
SpringApplication.setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));

If you want those listeners to be registered automatically, regardless of the way the application is created, you can add a META-INF/spring.factories file to your project and reference your listener(s) by using the org.springframework.context.ApplicationListener key, as shown in the following example:
org.springframework.context.ApplicationListener=com.example.project.MyListener

注入：
ApplicationContextAware
EnvironmentAware
BeanFactoryAware
MessageSourceAware

The ApplicationArguments interface provides access to both the raw String[] arguments as well as parsed option and non-option arguments
@Autowired
public MyBean(ApplicationArguments args)

profile配置：
application-{profile}.properties
@ActiveProfiles("test")
spring.profiles.active=test

my:
servers:
	- dev.example.com
	- another.example.com
The preceding example would be transformed into these properties:
my.servers[0]=dev.example.com
my.servers[1]=another.example.com
@ConfigurationProperties(prefix="my")
public class Config {
	private List<String> servers = new ArrayList<String>();

property对象
@ConfigurationProperties(prefix="aaa")
@EnableConfigurationProperties(MyProperties.class)
-------------------
二 Spring全家桶
1.Spring
Beanfactory 基础的spring ioc容器 默认提供ioc所有基础功能 默认情况下 采用懒加载的形式注入对象
在beanfactory中 每一个对象都有一个对应的beandefinition 这个对象包含这个对象的一些基础信息 对象类是否是抽象类 构造方法属性 class类型 当其他对象需要这个对象时 ioc 会根据这些必要信息 为其他对象构建出一个完备的对象实例
Beandefinition来源 Beandefinitionreder读取spring规定格式的xml配置文件 把对象加载到ioc容器 并构建出Beandefinition信息
把容器创造对象的过程称之为 bean的创建 Beandefinitionregistry 注册到ioc容器
把所有的可能遍历到map中 然后根据可能的标识去get 符合开闭原则
BeanFactory和ApplicationContext是Spring的两大核心接口都可以当做spring的容器 其中applicationcontext是beanfactory的子接口
Beanfactory 是spring中最底层的接口 包含了各种bean的定义 读取bean配置文档 管理bean的加载 实例化 控制bean的生命周期 维护bean的依赖关系 applicationcontext接口作为beanfactory的派生 除了提供beanfactory所具有的功能外 还提供了更完整的框架功能
继承messagesource 因此支持国际化 
统一的资源文件访问方式
提供在监听器中注册bean的事件
同时加载多个配置文件
载入多个有继承关系的上下文 使得每一个上下文都专注于一个特定的层次 比如web层
Beanfactory采用的是延迟加载形式来注入bean的 即只有在使用到某个bean时 调用getbean() 才对该bean进行加载实例化 这样我们就不能发现一些存在的spring的配置问题 如果bean 的某一个属性没有注入 beanfacotry加载后 直至第一次使用调用getbean方法才会抛出异常
Applicationcontext 它是在容器启动时 一次性创建了所有的bean 这样 在容器启动时 我们就可以发现spring中存在的配置错误 这样有利于检查所依赖属性是否注入 applicationcontext启动后预载入所有的单实例bean 确保在你需要的时候 不需要等待 英文已经创建好了
相对于基本的beanfactory applicationcontext唯一的不足就是占用内存空间 当应用程序配置bean较多时 程序启动较慢

SpringIoc
IOC控制反转 简单来说就是把复杂系统分解成相互合作的对象 这些对象类通过封装以后 内部实现对外部是透明的 从而降低了解决问题的复杂度 而且可以灵活地被重用和扩展





没有IOC之前 如图一所示 对象a依赖对象b 那么对象a在初始化或者运行到某一点的时候 自己必须自主去创建对象b或者使用已经创建的对象b 无论是创建还是使用对象b控制权都在自己手上 软件系统在引入IOC容器之后 这种情形就完全改变了 如图3所示 由于IOC容器的加入 对象a与对象b之间失去了直接联系 所以 当对象a运行到需要对象b的时候IOC容器会主动创建一个对象b注入到对象a需要的地方
对象a获取的依赖对象b的过程 由主动行为变成了被动行为 控制权颠倒过来了 这就是控制反转


传统情况下 一个容器中有两个类 a和b 要想把a类作为b类的属性需要先创建一个a类的对象 然后创建一个b类的对象 通过对象的setter方法将这个属性赋值给b类 而使用IOC容器 则是容器就把这个注入的关系完成了 我们只需要通过b类的getter方法获取到对象的属性就可以了 达到了在代码上的解耦合
哪些方面的控制被反转了呢 
获取依赖对象的过程被反转了 控制反转之后 获得依赖对象的过程由自身管理变成了由IOC容器主动注入 于是IOC也叫依赖注入  所谓依赖注入 就是由IOC容器在运行期间 动态地将某种依赖关系注入到对象之中
所以 依赖注入di和控制反转IOC是从不同的角度的描述的同一件事情 就是指通过引入IOC容器利用依赖关系注入的方式 实现对象之间的解耦合
依赖注入 组件之间依赖关系由容器在运行期决定 形象的说 即由容器动态的将某个依赖关系注入到组建之中
如果一个对象只通过接口(而不是具体实现或初始化过程)来表明依赖关系 那么这种依赖就能够在对象本身毫不知情的情况下 用不同的具体实现进行替换


SpringBean生命周期
Spring启动 查找并加载需要被spring管理的bean 进行bean的实例化
Bean实例化后 对将bean的引入和值注入到bean的属性中
如果bean实现了beannameAware接口的话 spring将bean的id传递给setbeanName()方法
如果bean实现了beanFactoryAware接口的话 spring将调用setbeanFactory()方法 将beanfactory容器实例传入
如果bean实现了applicationContextAware接口的话 spring将调用bean的setApplicationContext()方法 将bean所在应用上下文引用传入进来
如果bean实现了beanPostProcessor接口 spring就将调用他们的postProcessBeforeInitialization()方法
如果bean实现了InitalizingBean接口spring将调用他们的afterPropertiesSet()方法 类似的 如果bean使用init-method声明了初始化方法 该方法也会被调用
如果bean实现了 beanPostProvessor接口 spring就将调用他们的 postProcessAfterInitialization()方法
此时 bean已经准备就绪 可以被应用程序使用了 他们将一直驻留在应用上下文中 直到上下文被销毁
如果bean实现了disposableBean接口 spring将调用它的destory()接口方法 同样 如果bean使用了 destory-method声明销毁方法 该方法也会被调用


ServiceLoader.load(server.class) 使用
从META-INF/services目录下的配置文件加载给定的接口或基类实现 从而获得 实现类


注解 
@component 标注在一个类上 这个类就会变成一个springbean 如果被扫描到(@componentscan) 就会注入到IOC中


2.SpringBoot

Springboot run方法总结
获取spring应用执行监听器 SpringApplicationrunListeners
利用spring应用执行监听器广播启动事件

3.准备运行的环境(dev，test)，根据环境解析不同的配置文件
         3.1 检查webEnvironment属性，如果是web程序，那么创建一个StandardServletEnvironment对象，否则创建StandardEnvironment对象
         3.2 准备运行环境配置，根据环境(dev，test)，加载相关配置文件
         3.3 利用spring应用执行监听器广播运行环境加载完毕的事件
    4.创建spring应用上下文，如果是web程序，创建web应用上下文实例
    5.准备spring应用上下文
        5.1 利用spring初始化器，对上下文做初始化操作
        5.2 利用spring应用执行监听器广播上下文准备好的事件
        5.3 向beanFactory注册springApplicationArguments和springBootBanner单例bean
        5.4 向上下文注册启动类的bean，也就是调用SpringApplication.run(Application.class, args);的类
        5.5 利用spring应用执行监听器广播上下文加载完毕事件
    6.刷新spring应用上下文
        6.1 为刷新上下文信息做准备。例如清空缓存，初始化属性信息，验证必要的属性等
        6.2 获取应用上下文的beanFactory
        6.3 对beanFactory设置相关参数
        6.4 为beanFactory添加后置处理器WebApplicationContextServletContextAwareProcessor，并忽略ServletContextAware
        6.5 调用beanFactory的后置处理器
        6.6 注册bean的后置处理器，这些后置处理器将在bean的创建过程中被调用
        6.7 初始化事件广播器(EventMulticaster)，看是否有自定义的事件广播bean(applicationEventMulticaster)，如果有则使用自定义的，否则就用默认的。
        6.8 初始化其他特殊的bean，比如创建serverlet容器相关的bean
        6.9 向事件广播器EventMulticaster中添加各种事件监听器
        6.10 实例化所有单例bean
        6.11 结束刷新，利用EventMulticaster广播上下文刷新完成事件
    7.执行应用runner(或命令行runner)
8.利用spring应用执行监听器广播启动完成事件

@springbootApplication注解包含
@configuration:用于定义一个配置类 它就是javaconfig形式的Spring IOC容器的配置类使用的那个@configuration springBoot社区推荐使用基于javaconfig的配置形式 所以这里启动类标注了@configuration注解之后 本身其实也是一个IOC容器的配置类 任何一个标注了@configuration的Java类定义都是一个javaconfig配置类

任何一个标注了@bean的方法 其返回值将作为一个bean定义注册到spring的IOC容器 方法名将默认成该bean定义的id

注解优势
不需要配置繁杂的xml文件
在配置中也可以享受面向对象带来的好处
类型安全对重构可以提供良好的支持
减少复杂配置文件的同时亦能享受springIOC提供的功能
@conditional spring4.0添加的新注解 用来标识一个spring bean或者configuration配置文件 当满足指定条件才开启配置 
如果一个bean的定义依赖其他bean 则直接调用对应的javaconfig类中依赖的bean的创建方法就可以了
@enableAutoConfiguration: springboot会根据你jar包的依赖来自动配置项目
@componentScan: 其功能就是自动扫描并加载符合条件的组件(比如@component和@repository等)或者bean定义 最终将这些bean定义加载到IOC容器中
我们可以通过basepackages等属性来细颗粒度的定制@componentScan自动扫描范围 如果不指定则默认spring框架实现会从声明@componentScan所在的类的package进行扫描
所以springboot的启动类最好是放在ROOT package下 因此默认不指定basepackages

@Target(ElementType.TYPE)// 注解的适用范围，其中TYPE用于描述类、接口（包括包注解类型）或enum声明
@Retention(RetentionPolicy.RUNTIME)  // 注解的生命周期，保留到class文件中（三个生命周期）
@Documented// 表明这个注解应该被javadoc记录
@Inherited                           // 子类可以继承该注解	@SpringBootConfiguration             // 继承了Configuration，表示当前是注解类	@EnableAutoConfiguration             // 开启springboot的注解功能，springboot的四大神器之一，其借助@import的帮助@ComponentScan(excludeFilters = {    // 扫描路径设置 将所有符合条件的@configuration配置都加载到当前springboot创建并使用IOC容器

        @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
        @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })

Springbootapplication 申明让springboot自动给程序进行必要的配置 等同于
@configuration @enableautoconfiguration @componentScan三个配置
Responsebody 表示该方法的返回结果直接写入http response body中 一般用于异步获取数据时使用 用于构建restful的api 在使用@requestMapping后 返回值通常解析为跳转路径 加上此注解后会直接以json数据返回
@RequestMapping 用于提供路由信息 负责url到controller中的具体函数的映射
@enableautoconfiguration :springboot自动配置尝试根据你添加的jar依赖自动配置你的spring应用 例如 如果你的classpath下存在hsqldb 并且你没有手动配置任何数据库连接beans那么我们将自动配置一个内存型数据库 你可以将此注解添加到一个@configuration 类上来选择自动配置 如果发现应用了你不想要的特定自动配置类 你可以使用此注解的排除属性来禁用它们
@componentScan 表示将该类自动发现扫描组件 如果扫描到有@component @controller @service 等这些注解的类 并注册为bean 可以自动收集所有的spring组件 包括@configuration类 我们经常使用@componentscan注解搜索beans 并结合@autowired注解导入 如果没有配置的话 springboot 会扫描启动类下使用了@service ...的类
@configuration 相当于传统的xml配置文件 如果有些第三方库需要用到xml文件 建议仍然通过@configuration 类作为项目的配置主类 可以使用@importResource 注解加载xml配置文件
@import 用来导入其他configuration修饰的配置类
@importResource 用来导入spring配置文件 兼容老项目常用 
@autowired 自动导入依赖的bean
@service 一般用于修饰service层的组件
@repository 使用@repository注解可以确保dao或者repositories提供异常转译 这个注解修饰的dao或者repositories类会被componentscan发现并配置 同时也不需要为它们提供xml配置项
@bean 用@bean标注方法等价于xml中配置的bean 放在一个方法上 表示将该方法注册为bean放到IOC容器中
@value 用于获取application.properties中的配置项
@component 泛指组件 用于指定不好归类的component
@resource 与autowired 类似默认byname
JPA注解
@entity 表明该类为实体类
@table()对应数据库中表名
@mappedsuperclass 用于确实在父类的entity中 父类属性子类可以继承
@norepositorybean一般用作父类的repository 有这个注解 spring不会去实例化该repository
@column 用于属性与列名匹配 如果一致 可以省略
@id 主键
@generatedvalue 主键生成策略
@sequencegeneretor 序列
@transient 表示该属性并非一个到数据库表的字段的映射 orm框架将忽略该属性 如果属性并非数据库表的字段映射 就务必将其标识为@transient 否则orm框架默认将其注解为@basic @basic(fetch=fetchType.lazy)标记可以指定实体属性的加载方式
@jsonignore 作用是json序列化时将 javabean中的一些属性忽略掉 序列化与反序列化都受影响
@joinColumn (name=”loginId”) 一对一 本表中指向另一个表的外键 一对多另一个表指向本表的外键
@onetoone @onetomany @manytoone 对应hibernate配置文件中的一对一一对多多对一	





如果我们使用的是SpringApplication的静态run方法 那么这个方法里边首先要创建一个springapplication对象实例 然后调用这个创建好的SpringApplication的实例方法
根据classpath里边是否存在某个特征类来决定是否应该创建一个为web应用使用的applicationcontext类型
使用springfactoriesloader 在应用的classpath中查找并加载所有可用的ApplicationContextInitializer
使用springfactoriesloader在应用的classpath中查找并加载所有可用的applicationlistener
推断并设置main方法的定义类

创建配置类
@Configuration//=@Component + @ConponetScan("") + @xxx
public class MyConfig {

	@Bean（name=“nihao”）
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}
}

Main方法获取 bean
AnnotationConfigApplicationContext context=new ...(MyConfig.class); 
RestTemplate rt=（强转）Context.getbean（“你好”）
执行rt


<!-- devtools 在生产环境下可去掉 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>
Ctrl +f9 热部署自动刷新

新建yml配置文件
Application.yaml
创建读取yml配置文件类 加@configurationProperties（prefix=“person”）
然后就可以在yml文件中赋值了

加载不同配置文件
@propertysource（value={“classpath：xxx.properties”}）
Springboot 中导入自己的spring配置文件方法
@importReBean definitions can have zero or more properties. Property elements correspond to JavaBean setter 
 methods exposed by the bean classes. Spring supports primitives, references to other beans in the 
 same or related factories, lists, maps and properties.
s={“classpath:springmvc-servlet.xml”})

指定配置文件 从application.properties中
Spring.profiles.active=xxx
Enableconfigurationproperties（{HttpEncodingProperties。Class}）
启用配置属性表示此类中可以使用HttpEncodingProperties中属性
@conditionalonwebapplication //表示是否为web程序
Type=type。Servlet 

@@conditionalonclass（{xxx。Class}）是否有这个类

@@conditionalonproperty（
Xx=xx
）是否有这些属性
静态资源存放在 resource的static与templates中

@autoconfigureAfter(xxx.class) 表示必须在这个类之后才能生效

Template中的资源是受保护的 不允许直接访问 需在controller中跳转

关于读取配置文件



从resource中注入对象调用方法


ApplicationListener调用过程详解
实现接口applicationlistener 并重写public void onApplicationEvent(ApplicationEvent event){}可以在容器初始化的时候执行这个方法
ApplicationContextEvent
是spring内置事件的父抽象类 构造方法传入spring的context容器 同时也获取spring的context容器的方法
ContextRefreshedEvent
当spring容器初始化或刷新时 会触发此事件 此事件在开发中常用 用于在spring容器启动时 导入自定义的bean实例到spring容器中
ContextStaredEvent
当spring启动时 或者说是在context调用start()方法时 会触发此事件
ContextStoppedEvent
当spring停止时 或者说context调用stop()方法时 会触发此事件
ContextClosedEvent
当spring关闭时或者说context调用close()方法时 会触发此事件

可以在ApplicationStartup中添加类注解@component让spring容器管理起来
或者在springboot启动类中手动添加listener


自动配置原理
在启动类添加@springbootapplication或@enableautoconfiguration 注解
会自动去maven中读取每个starter中的spring.factories文件 该文件里配置了所有需要被创建spring容器中的bean

springboot 
application.properties
	日志 debug=true 更改日志级别
	spring.output.ansi.enabled=always
	设置控制台日志颜色
	logging.file =指定名字
	logging.path=指定路径
	

3.SpringSecurity
SpringSecurity是一个能够基于spring的企业应用系统提供声明式的安全访问控制解决方案的安全框架 它提供了一组可以在spring应用上下文中配置的bean 为应用系统提供声明式的安全访问控制功能 减少了为企业系统安全控制编写大量重复代码的工作

核心组件之securityContextHolder 
作用 保留系统当前的安全上下文细节 其中就包括当前使用系统的用户的信息
上下文细节怎么表示 
用securityContext对象来表示
每个用户都会有它的上下文 那么这个securityContext保存在哪里呢
存储在一个securityContextHolder中整个应用就是一个securityContextHolder
SecurityContextholder存储securityContext的方式
结合应用场景 
单机系统 及应用从开启到关闭的整个生命周期只有一个用户在使用 由于整个应用只需要保存一个securityContext(安全上下文即可)
多用户系统 整个生命周期有可能同时多个用户在使用这时候应用需要保存多个securityContext 需要利用threadLocal进行保存 每个线程都可以利用threadlocal获取其自己的securityContext 及安全上下文
SecurityContextHolder利用一个securityContextHolderStrategy的接口进行上下文的存储 其有三个实现类


在securityContextHolder中存储了当前与系统交互的用户的信息 springSecurity使用一个Authentication对象来表示这些信息

上下文信息一般指Authentication信息 

主要包含其中内容
用户权限集合 =>可用于访问受保护资源时的权限验证
用户证书 =>初次认证的时候 进行填充 认证成功后将被清空
细节=>记录哪些保护资源已经验证授权 下次不用再验证 
Pirncipal =>账号
是否已认证成功


Spring security默认是禁用主节点 想要开启注解 需要继承websecurityconfigurerAdapter 的类上加@enableGlobalMethodSecurity注解 来判断用户对某个控制层的方法是否具有访问权限

@enableGlobalMethodSecurity(securedEnabled=true)开启@secured注解过滤权限
@enableGlobalMethodSecurity(jsr250enabled=true)开启@RolesAllowed注解过滤权限
@enableGlobalMethodSecurity(prepostEnabled=true)使用表达式时间方法级别的安全性

@preAuthorize 在方法调用之前 基于表达式的计算结果来限制对方法的访问
@postAuthorize 允许方法调用 但是如果表达式计算结果为false 将抛出一个安全性异常
@PostFilter 允许方法调用 但必须按照表达式来过滤方法结果
@preFilter 允许方法调用 但必须在进入方法之前过滤输入值

4.SpringCloud
Cap
Ap

有可能存在脏数据 保证了可用性
Cp
响应失败 保证了数据的一致性







Eureka：实际上在整个过程中维护者每个服务的生命周期。每一个服务都要被注册到Eureka服务器上，这里被注册到Eureka的服务又称为Client。Eureka通过心跳来确定服务是否正常。Eureka只做请求转发。同时Eureka支持集群 
Zuul：类似于网关，反向代理。为外部请求提供统一入口。 
Ribbon/Feign：可以理解为调用服务的客户端。 
Hystrix：断路器，服务调用通常是深层的，一个底层服务通常为多个上层服务提供服务，那么如果底层服务失败则会造成大面积失败，Hystrix就是就调用失败后触发定义好的处理方法，从而更友好的解决出错。也是微服务的容错机制。


1、请求统一通过API网关（Zuul）来访问内部服务. 
2、网关接收到请求后，从注册中心（Eureka）获取可用服务 
3、由Ribbon进行均衡负载后，分发到后端具体实例 
4、微服务之间通过Feign进行通信处理业务 
5、Hystrix负责处理服务超时熔断 
6、Turbine监控服务间的调用和熔断相关指标


服务提供方eurekaclient注册服务到eureka 
调用方通过唯一标示找到注册方服务并获取实际url
然后从本地通过httpclient实现远程调用



Springcloud application.properties配置
 
#================================普通配置==============================
#应用名称
spring.application.name=eureka-server-v1
#应用端口
server.port=7000
#================================eureka中心配置=========================
#主机名
eureka.instance.hostname=localhost
# 注册时显示ip
#eureka.instance.prefer-ip-address=true
#是否注册为服务
eureka.client.register-with-eureka=false
#是否检索服务
eureka.client.fetch-registry=false
#eureka默认空间的地址
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
#关闭自我保护(生产时打开该选项)
eureka.server.enable-self-preservation=false
#扫描失效服务的间隔时间（缺省为60*1000ms）
eureka.server.eviction-interval-timer-in-ms=5000

#================================基础配置==============================
#端口号
server.port=8081
#服务名
spring.application.name=produce-service-v1
#================================eureka配置==============================
#注册到eureka中心，获取到配置服务
eureka.client.service-url.defaultZone=http://localhost:7000/eureka/
#设置实例的ID为ip:port
eureka.instance.instance-id=${spring.cloud.client.ipAddress}:${server.port}
#================================续约配置============================
# 心跳时间，即服务续约间隔时间（缺省为30s）
eureka.instance.lease-renewal-interval-in-seconds=5
# 发呆时间，即服务续约到期时间（缺省为90s）
eureka.instance.lease-expiration-duration-in-seconds=10
# 开启健康检查（依赖spring-boot-starter-actuator）
eureka.client.healthcheck.enabled=true

当消费者需要调用提供者服务时 先会以提供者服务别名去注册中心上获取实际的接口地址然后缓存到本地 从本地实现rpc远程调用
Ping  服务ip 测试通不通

springcloud整体流程 
服务提供者启动类上加注解  在配置文件中配置eureka地址及ribbon超时时间及端口号和服务名  在服务器中此端口号是交于eureka标识的端口号与实际Tomcat启动的端口号无关


编写resource类

服务调用者 
在启动类中加@enablefeignclients注解 若引用的SDK则需要在basepackages中加入sdk中远程调用服务类的地址

在远程调用服务类中加|@feignClient注解 并配置服务名及configuration类
及服务调用需要与服务提供者一致的接口 

Fegin


Hystrix
服务降级 熔断
在微服务架构中 我们将系统拆成很多服务 个单元之间通过服务注册 订阅的方式相互依赖 每个单元都在不同的进程中执行 依赖通过远程调用的方式执行 这样就有可能 因为网络原因 或服务本身的依赖原因而出现调用的延迟或故障 而这些问题会导致 调用方对外的服务也出现延迟 若此时调用方的请求不断增加 那么就会因为等待服务提供方的依赖响应而形成任务的堆积 从而导致自身服务瘫痪


springMVC 

dispatcherServlet 前端控制器 对所有数据进行 转发 匹配 数据处理结束后 转由页面进行结果展示
1. 提供多种handlermapping映射策略的实现 beanNameUrlHandlerMapping   映射策略的默认实现
2.定制了多种controller实现 controller需要实现handlerRequest接口 并返回modeAndView对象
3.提供多种视图
4.提供拦截器 允许对web程序请求进行拦截 前置或后置处理
5.提供localResolver实现 应用可以定制自己的区域解析器


























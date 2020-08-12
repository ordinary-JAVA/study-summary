我叫李宗仁 17年 毕业于邢台学院 计算机科学与技术系 来北京工作已经大约有两年半的时间了 
目前从事Java开发工程师的职位  在此期间也参与过大大小小的两三个项目 从中也学到了一些项目开发过程中的经验 
在工作之余 也在看一下技术方面的资料来提升自己 从而使得自己在技术和业务方面能有所进步 大概就是这些 谢谢


公司整体架构
技术架构 Jersey hibernate spring springboot springcloud AngularJS 
工具 Tomcat MySQL NGINX负载 git Jenkins
项目描述
因为我们公司与移动常年有合作 所以接的项目也大多数是移动那边的项目 就像我第一个项目 咪咕音乐分发平台
 这个项目主要是为咪咕音乐app的部分推荐模块做实时 离线数据计算的 我们改变了他们原有的那种推荐模式 
 把他们原有的那种是基于接口的 我们采用微服务架构 把他们其中部分的推荐接口 转换成了通用服务形式 
 同时 通过我们平台可以规范管理 监控  这些提出来的服务 以保证服务的高可用 同时我们还可以为他的推荐服务提供 
 AB测试 认证 限流 以及异常日志块的页面访问 

通用服务模块 提供了十几种通用组件 比如 补白 截断 逻辑 填充 获取组件 混合 并发 返回 排除 去重  


Jersey 有个servletcontioner 他会去扫描 ResourceConfig中注册的类 项目中需要把 resource类的全限定名 
注册到继承ResourceConfig的类中



ArrayList 动态数组  类别
    创建默认长度为10的数组 当时数据超过长度值是 进行扩容 1.5倍 新建数组 copy数据
    
Jersey 与mvc区别
    Jersey中有一个servletContainer 类 当请求到达servlet容器后 servletContainer

Spring ioc依赖注入类与自己new的类的类型是否一致
数据库调优
Inoodb与myisam区别
Redis 缓存存储数据类型
Mq oracle使用
常用Linux命令
Jdbc操作数据库
    加载数据库驱动 （三选一）
        class.forname（driverName）
        DriverManager.registerDriver(driver)
        properties.setproperty("驱动名"，"驱动");
    获取数据库连接 
        DriverManager.getConnection(主机用户名密码);
    获取preparstatement对象
        connection.createStatement()
    执行sql 获取结果
       Resultset re = statement.execute(sql);
    关闭连接 先开后关
反射
Class.forName



Redis 存储类型  
   string set list sortset hash
持久化操作

    aof 基于对redis的写操作添加对应的日志 
    rdb 以快照的形式持久化 
场景 两个线程去获取两个表中数据  汇总

    countdownLatch
hashMap 实现原理

    数组加链表加红黑树 链表转红黑树的临界值为8 反转临界值为6 添加一条数据 则用key的hash值对hashmap的数组长度取模
    然后判断应放到数组的哪一位置 然后判断当前数组位置是否已经有数据 如果没有直接插入 如果存在 则以链表的形式追加在
    此数组位置的后边 
    put方法传递键和值 先对键做hashcode的计算（与key.hashcode的高16位做异或运算）获取在数组中存储entry对象的位置 
    put过程中 没有发生碰撞 直接添加到元素的散列表中去 发生碰撞（计算后在数组中位置相同） 则判断（若key地址相同 或equals后内容相同 替换
    红黑树结构 调用树插入方法 。 连表结构 便利循环连表到最后 判断长度是否大于8 若在遍历过程中发生情况1 则按1方式处理）
一个http请求到方法及响应的过程

    浏览器根据输入的域名解析成对应的IP地址
    浏览器会与服务器建立一个tcp连接
    浏览器给服务器发送一个http请求  比如localhost 8080
    然后Tomcat会监听对应的8080端口 然后会被Tomcat的connector获取 
    connector会把对应请求发送给 engine-host-context-servlet
    servlet构建httpservletrequest和response对象 执行对应的doget dopost方法 执行业务逻辑处理或数据存储
    执行完毕后会把httpservletresponse对象返回
微服务 组件的使用

    eureka ribbon feign hystrix zuul gateway
索引失效 

    检查对应的sql语句 不要在索引列上做任何函数操作 会导致索引失效从而全表扫描
    组合索引看是否满足最左匹配原则 就是左侧索引不符合索引规则会同时导致右侧索引同时失效
    尽量使用覆盖索引 即不要用select * 尽量使用与索引列一致的名称
    mysql 中不等于 is null is not null 会导致索引失效  
    like通配符应放到sql语句右侧 否则会导致索引失效从而全表扫描
    字符串匹配未加单引号 以及 使用or连接索引 同样会导致索引失效









Spring ioc

    在传统项目中 当一个对象对另一个对象有依赖时 通常是采用new的形式来创建被调用者的实例 
    而在spring中 获取被调用者实例的方式不再是由调用者 主动创建 而是由spring在合适的时间 自动注入到调用者的使用中
    因此称 控制反转 创建被调用者实例的任务由spring完成 然后注入给调用者
spring aop

    spring中 aop使用:
        面向切面编程 提供声明式事务管理 
        支持用户自定义切面
    aop是在程序运行角度 提取业务进行切面编程 aop是动态的抽象 是对应用执行过程中的步骤进行抽象 从而获取步骤之间的逻辑划分
    各个步骤之间良好的隔离性 源代码的无关性
    spring事务管理机制 通过动态代理将所有要进行事务管理的bean加载起来 并根据配置的invoke方法对当前调用的方法名进行判定
    在method.invoke 方法前后 加上合适的事务管理代码 这样就实现了spring式的事务管理 与aop基本原理一致
Springmvc 工作流程

    用户发起请求 首先会到达dispatcherservlet 前端控制器 
    前端控制器收到请求会调用 handlemapping 由此得知由哪个controller 处理
    前端控制器调用handleradapter 去处理对应的controller 
    执行完毕返回一个 viewreslover 视图解析器  
Mybatis 工作流程
   
   
   
spring bean生命周期

    实例化 读取一些配置信息 构建bean的基础信息
    set属性 为对象的属性赋值
    初始化  init-method 方法进行初始化
    销毁  destroy-method 方法进行销毁
    
分布式事务
    cap
    
    c 一致性 一致性是指在分布式的各个节点中数据能否保持一致的特性 如果能做到针对一个数据的更新操作成功
    后所有的节点及请求都可以读到最新的值 那么被称为强一致性
    a 可用性 可用性是指系统提供的服务必须一直处于可用的状态 对于用户的每一个操作请求总是能在有限的时间内返回
    p 分区容错性 大多数分布式系统都分布在多个子网络中 每个子网络叫一个区 分区容错约束了分布式系统具有
    分布式系统在遇到任何网络分区故障的时候 仍然需要能够保证对外提供满足一致性或可用性的服务 除非整个网络
    都发生故障 对于分布式而言 p是基础
    
    base
    base理论
    
    
   
    
    
共享锁 读锁 s锁 共享锁是多个事务对于同一数据可以共享一把锁 都能访问到数据 但是不能修改数据
排它锁 写锁 x锁 排它锁不能与其他锁同时存在 一个事务获取了一条数据的排它锁 其他事务就不能
再获取该行的其他锁  包括共享锁和排它锁 但是获取该行数据排它锁的事务可以对数据改行修改和查询

意向锁协议

    事务要获取表a的s锁 必须要获取表a的is锁
    事务要获取表a的x锁 必须要获取表a的ix锁

mysql innodb select默认不加锁 insert delete update 默认加上排它锁  
select ... for update 加排它锁 select ... lock in share mode 加共享锁 
    
    
    
innodb与myisam区别

    innodb支持事务 myisam不支持
    innodb最小锁粒度行级锁 myisam表级锁
    innodb不会保存表的总行数 因此select count会很慢 myisam 相反
    innodb是聚集索引 myisam是非聚集索引 聚集索引的文件存放在主键索引的叶子节点上 因此
    innodb需要有主键 通过主键索引的效率会很高 但是辅助索引需要两次查询 先查询到主键
    然后通过主键查询到数据  因此 innodb主键不应该过大 否则会导致其他索引也会很大 而
    myisam是非聚集索引 主键索引和辅助索引是独立的
    如果读操作多 可以选择myisam索引 读写频繁 选innodb myisam 数据恢复较为困难
    
    
    
    
    
springboot比spring的优势
    springboot可以建立独立的spring应用
    内嵌Tomcat这种servlet容器
    无需繁杂的配置文件 以配置类以及bean的形式注入到ioc容器
    使用@EnableAutoConfiguration实现自动配置
    提供一些start 整合好的一些版本
    
    
组合索引
    
    优势:mysql使用索引的时候 只会选择一个索引 单个索引的限制能力肯定不如组合
    索引
    加快检索效率 降低数据的排序成本
    索引是数据的一部分 对数据更新 有影响 存储空间内存消耗

缓存穿透


mq


事务传播机制   
    
默认没有事务时 新建一个事务 有事务后其他事务加入这个事务    
    
    
    
    
    

分布式锁
    基于mysql实现的分布式锁 创建一个锁表 每次操作去获取新增锁数据 每次解锁 删除锁数据
    



arraylist linkedlist 双向链表 扩容1.5倍
hashmap长度小于64不会转红黑树 而是扩容   currentlist
 
hashmap 为何线程不安全  2n次幂 取余与取模一致     cas aqs  syn公平锁  currentHashMap 1.7 分段锁 1.8 syn cas

线程池四种实现  底层实现细节参数 四种区别

jvm 运行介绍 垃圾回收机制 算法 垃圾回收器  
springaop 实现 动态代理 两种动态代理区别

redis 持久化 淘汰策略  最少使用 基于linkedlist 去记录

聚集索引 非聚集索引 

事务 四大特性 隔离级别 间隙锁 组合索引

springcloud eureka 可用性 分区容错性
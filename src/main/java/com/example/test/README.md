我叫李宗仁 今年25岁 毕业于邢台学院 计算机科学与技术系 来北京工作已经大约有两年半的时间了 
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
Jersey 与mvc区别
Spring ioc依赖注入类与自己new的类的类型是否一致
数据库调优
Inoodb与myisam区别
Redis 缓存存储数据类型
Mq oracle使用
常用Linux命令
Jdbc操作数据库
反射
Class.forName


Redis 存储类型 
持久化操作
场景 两个线程去获取两个表中数据  汇总
hashMap 实现原理
一个http请求到方法及响应的过程
微服务 组件的使用

索引失效 









Spring aop 及原理 
Springmvc 工作流程
Mybatis 工作流程
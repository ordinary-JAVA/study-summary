一 JAVA基础
1.java基础
接口中属性默认 public static final 
方法默认public abstract

是否可以从一个static方法内部发出对非static方法的调用
不可以 因为非static方法是要与对象关联在一起的 必须创建一个对象后 才可以在该对象上进行方法调用 而static方法的调用时不需要创建对象 可以直接调用 也就是说 当一个static方法被调用时 可能还没创建任何实例对象 如果从一个static方法中对一个非static方法的调用 那个非static方法时关联到哪个对象上的呢 逻辑不成立 所以一个static


Integer与int区别
Int是java提供的8种原始数据类型之一 java为每个原始类型提供了封装类 integer是java为int提供的封装类 int默认值为0 而integer默认值为null 即integer可以区分出未赋值和0的区别 int则无法表达出来未赋值的情况 

	String url = System.getProperty("user.dir") //获取用户当前工作目录	
		+ File.separator//表示 /或\  根据系统而定
		 + "usergroup" + File.separator + groupId;


与系统有关的默认名称分隔符。此字段被初始化为包含系统属性 file.separator 值的第一个字符。在 UNIX 系统上，此字段的值为 '/'；在 Microsoft Windows 系统上，它为 '\'。

与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。此字符串只包含一个字符，即 separatorChar。

java中的isDirectory()是检查一个对象是否是文件夹。

list()方法是返回某个目录下的所有文件和目录的文件名，返回的是String数组
ctrl shift o 导包
equalsIgnoreCase与equals区别为 前者不区分大小写


System.setProperty("Property2","def");
//这样就把第一个参数设置成为系统的全局变量！可以在项目的任何一个地方 通过System.getProperty("变量");来获得，
//System.setProperty 相当于一个静态变量  ，存在内存里面！


接口支持继承
Jdk8自带编码解码使用

枚举类.valueOf(“name”) 会转换成枚举类.NAME

list.addAll(list1,123) 表示将list1及123加入到list中
 Collections.addAll(list2, 34, 67, 78);  表示将34,67,78加入到list2 中

java8 新特性
允许接口中存在方法实现 但是必须是default修饰
lambda表达式 map提取 filter过滤 collect 收集器
@functionalinterface  可以将lambda表达式当做任意只包含一个抽象方法的接口类型

2.设计模式

什么是设计模式
设计模式是一套被反复使用 多数人知晓 经过分类编目的 代码设计经验总结 使用设计模式是为了可重用代码 让代码更容易被他人理解 保证代码可靠性 毫无疑问 设计模式已于他人于系统都是多赢的 设计模式使代码编程真正工程化 设计模式是软件工程的基石 如同大厦的一块块砖石一样 项目中合理的运用设计模式可以完美的解决很多问题 每种模式在现在中都有相应的原理来与之对应 每一个模式描述了一个在我们周围不断重复发生的问题 以及该问题的核心解决方案 这也是他能被广泛应用的原因
模式 在某些场景下 针对某类问题的某种通用解决方案
场景 项目所在环境 
问题 约束条件 项目目标 
解决方案 通用 可复用的设计 解决约束达到目标

设计模式六大原则
单一职责 实现类职责要单一
里氏替换原则 不要破坏继承体系
依赖倒转原则 面向接口编程
接口隔离原则 在设计接口时要精简单一
迪米特原则 降低耦合
开闭原则 对扩展开放 对修改关闭

单一职责
就一个类来说 应该只有一个引擎他变化的原因
类t负责两个不同的职责 职责1 职责2 当由于职责1需要发生改变而需要修改类t时 有可能会导致原本运行正常的职责2功能发生故障
解决 遵循单一职责原则 分别建立两个类t1 t2 使T1完成职责1的功能 T2完成职责2的功能这样 当修改T1时 则不会影响职责2发生故障风险 反之亦然
隐患 职责扩散
因为某种原因 职责1被分化成粒度更细的职责3和职责4

开闭原则
是指软件实体(类 模块 函数等)应该是可扩展的 但是不可修改
这个原则其实有两个特征 对扩展开放 对更改关闭
在软件的生命周期内 因为变化 升级 维护 等原因需要对软件原有代码进行修改时 可能会给旧代码中引入错误 也可能会使我们不得不对整个功能进行重构 并且需要原有代码进行重新测试
解决方案 开闭原则是面向对象设计中最基础的设计原则 它指导我们如何建立稳定灵活的系统 开闭原则可能是设计模式中定义最模糊的一项 用抽象构建框架 用实现扩展细节 抽象灵活性好 适应性广 只要抽象的合理 可以基本保持软件架构的稳定 而软件中易变的细节 我们用从抽象派生的实现类来进行扩展 当软件需要发生变化时 我们只需要根据需求重新派生一个实现类来扩展就可以了当然前提是我们的抽象要合理 
开闭原则是面向对象设计的核心所在遵循这个原则可以带来面向对象技术所声称的巨大好处 也就是可维护性 可扩展 可复用 灵活性 开发人员应该仅对程序中呈现出来频繁变化的部分做抽象 然而 对于应用程序中的每个部分都刻意进行抽象同样不是一个好的主意 拒绝不成熟的抽象 和抽象本身一样重要
里氏替换原则
一个软件实体如果使用的是一个父类的话 那么一定适用于子类 而且他察觉不出父类对象和子类对象的区别 也就是说 在软件里 吧父类替换成他的子类 程序的行为没有变化
里氏替换原则 子类必须能够替换掉他们的父类
继承包含这样一层含义 父类中凡是已经实现好的方法(相对于抽象方法而言) 实际上是在设定一系列的规范和契约 但是如果子类对这些非抽象方法任意修改 就会对整个继承体系造成破坏 而里氏替换原则就是表达了这一层含义
弊端 
继承作为面向对象三大特性之一 再给程序设计带来巨大便利的同时 也带来了弊端 比如使用继承会给程序带来侵入性 程序的可移植性降低 增加了对象间的耦合性 如果一个类被其他的类所继承 则当这个类需要修改时 必须考虑到所有的子类 并且父类修改后 所有涉及到子类的功能都有可能会产生故障 例如在实际编程中 我们常常会通过重写父类的方法来完成新的功能 这样写起来虽然简单 但是整个继承体系的可复用性会比较差 特别是运用多态比较频繁时 程序运行出错的几率非常大 如果非要重写父类的方法 比较通用的做法是 原来的父类和子类都继承一个更通俗的基类 原有的继承关系去掉 采用依赖 聚合 组合等关系代替 
里氏替换原则通俗来讲就是 子类可以扩展父类的功能 但不能修改父类原有的功能
子类可以实现父类的抽象方法 但不能覆盖父类的非抽象方法
子类中可以增加自己特有的方法
当子类的方法重载父类的方法时 方法的前置条件(即方法的形参) 要比父类方法的输入参数更加宽松
当子类的方法实现父类的抽象方法时 方法的后置条件(即方法的返回值)要比父类更严格

依赖倒转
高层模块不应该依赖低层模块 两个都应该依赖抽象 抽象不应该依赖细节 细节应该依赖抽象
类a直接依赖类b 加入腰间类a改为类c 则必须通过修改类a的代码来达成 这种场景下 类a一般是高层模块 负责复杂的业务逻辑 类b和类c是底层模块 负责基本的原子操作 假如修改类a 会给程序带来不必要的风险
解决 将类a修改为依赖接口I类b和类c都各自实现接口I类a通过接口I间接与类b或者类c发生联系 则会大大降低修改类a的几率
依赖倒置原则基于这样一个事实 相对于细节的多变性 抽象的东西要稳定的多 以抽象为基础搭建起来的架构比细节为基础搭建起来的架构要稳定的多 在java中 抽象指的是接口或者抽象类 细节就是具体的实现类 使用接口或者抽象类的目的是制定好的规范和契约 而不去设计任何具体的操作 吧展示细节的任务交给他们的实现类去完成
依赖倒置原则的核心思想是面向接口编程
依赖倒置其实可以说是面向对象设计的标志 用哪种语言来编写程序不重要 如果编写时考虑的都是如何这对抽象编程而不是细节编程 即程序中所有的依赖关系都是终止于抽象类或接口 那就是面向对象的设计 反之就是面向过程了

接口隔离原则
客户端不应该依赖它不需要的接口 一个类对另一个类的依赖应该建立在最小的接口上
类A通过接口Q依赖类B类C通过接口Q依赖类D如果接口Q对于类A和类B来说 都不是最小接口 则类B和类D必须去实现他们不需要的方法
将臃肿的接口Q拆分成为独立的几个接口 类A和类C分别与他们需要的接口建立依赖关系 这就是接口隔离原则
接口隔离原则的含义是 建立单一接口 不要建立庞大臃肿的接口 尽量细化接口 接口中的方法尽量少 也就是说 我们要为个各类建立专用的接口 而不要试图去建立一个很庞大的接口供所有依赖它的类去调用
接口隔离原则约束 
接口尽量小 但是要有限度 对接口进行细化可以提高程序设计灵活性是不争的事实 但是如果过小 则会造成接口数量过多 使设计复杂化 所以一定要适度
为依赖接口的类指定服务 只暴露给调用的类它需要的方法 它不需要的方法则隐藏起来 只有专注地为一个模块提供定制服务 才能建立最小的依赖关系
提高内聚 减少对外交互 使接口用最少的方法去完成最多的事情
运用接口隔离原则 一定要适度 接口设计的过大或过小都不好 设计接口的时候 只有多花些时间去思考和筹划 才能准确地实践这一原则

迪米特法则 
最少知道原则 如果两个类不必彼此直接通信 那么这两个类就不应当发生直接的相互作用 如果其中一个类需要调用另一个类的某一个方法的话 可以通过第三者转发这个调用
通俗的来讲 就是一个类对自己依赖的类知道的越少越好 也就是说 对于被依赖的类来说 无论逻辑多么复杂 都尽量地将逻辑封装在类的内部 对外除了提供public方法 不对外泄漏任何消息 迪米特法则还有一个更简单的定义 只与直接的朋友通信 首先来解释一下什么是直接的朋友 每个对象都会与其他对象有耦合关系 只要两个对象之间有耦合关系 我们就说这两个对象之间是朋友关系 耦合的方式很多 依赖 关联 组合 聚合等 其中 我们称出现成员变量 方法参数 方法返回值中的类为直接的朋友 而出现在局部变量中的类则不是直接的朋友 也就是说 陌生的类最好不要作为局部变量的行驶时出现在类的内部
迪米特法则其根本思想是强调了类之间的松耦合 类之间的耦合越弱 越利于复用 一个处在弱耦合的类被修改 不会对有关系的类造成波及
但是凡事都有度 虽然可以避免与非直接的类通信 但是要通信 必然会通过一个中介来发生联系 但过分使用迪米特法则 会产生大量这样的中介和传递类 导致系统复杂度变大 所以在采用迪米特法则时 要反复权衡 既做到结构清晰 又要高内聚低耦合
逻辑不复杂 在业务进行扩展 可以有悖于六大原则 


设计模式分类
创建型模式 对象实例化的模式 创建型模式用于解耦对象的实例化过程
结构型模式 把类或对象结合在一起形成一个更大的结构
行为型模式 类和对象如何交互 及划分责任和算法

设计模式关键点
单例模式 某个类只能有一个实例 提供一个全局访问点
简单工厂 一个工厂类根据传入的参量决定创建哪一种产品类实例
工厂方法 定义一个创建对象的接口 让子类决定实例化哪个类
抽象工厂 创建相关或依赖对象的家族 而无需明确指定具体类
建造者模式 封装一个复杂对象的构建过程 并可以按步骤构造
原型模式 通过复制现有的实例来创建新的实例  原型模式分为深克隆 浅克隆 前者是基于io流对对象进行克隆
            后者基于set值的方式进行克隆 前者创建一个新的对象 后者只是clone对象的引用

适配器模式 将一个类的方法接口转换成客户希望的另一个接口
组合模式 将对象组合成树形结构以表示 部分整体 的层次结构
装饰模式 动态的给对象添加新的功能
代理模式 为其他对象提供一个代理以便控制这个对象的访问 主要功能 保护目标对象 增强对象功能

亨元模式 通过共享技术来有效的支持大量细粒度对象
外观模式 对外提供一个统一的方法 来访问子系统中的一群接口
桥接模式 将抽象部分和他的实现部分分离 使它们都可以独立变化

模板模式 定义一个算法结构 将一些步骤延迟到子类实现
解释器模式 给定一个语言 定义它的文法的一种表示并定义一个解释器
策略模式 定义一系列算法 把他们封装起来 并且使它们可以相互替换
状态模式 允许一个对象在其对象内部状态改变时改变它的行为
观察者模式 对象间的一对多的依赖关系
备忘录模式 在不破坏封装的前提下 保持对象的内部状态
中介者模式 用一个中介对象来封装一系列的对象交互
命令模式 将命令请求封装为一个对象 使得可以用不同的请求来进行参数化
访问者模式 再不改变数据结构的前提下 增加作用于一组对象元素的新功能
责任链模式 将请求的发送者和接受者解耦 使的多个对象都有处理这个请求的机会
迭代器模式 一种遍历访问聚合对象中各个元素的方法 不暴露该对象的内部结构

工厂模式
工厂模式是一种创建模式 因为此模式提供了更好的方法来创建对象
在工厂模式中 我们创建对象而不将创建逻辑暴露给客户端

原型模式
原型模式是创建模式之一 原型模式有助于创建具有更好性能的重复对象
在原型模式中 将返回一个现有对象的克隆 而不是创建新的对象
我们使用原型设计模式 如果创建一个新对象的成本是昂贵和资源密集型

观察者模式
观察者模式是在对象之间定义一对多的依赖关系 基于这样的关系 如果对象发生状态变化 与之依赖的多个对象(监听的对象)能够收到状态的变化通知 并进行更新 是一个以松耦合的方式 让一个对象与一系列对象进行协作沟通的方式
角色划分 
Subject 主题或中心对象 一对多中的一 接口或者抽象类 定义了如何添加观察者 移除观察者 通知观察者更新的基本行为
Subimpl1 subimpl2 是对主题的具体实现 可以通过实现subject的接口实现不同种类的主题和中心对象
Observer 观察者接口定义 定义观察者更新行为
Obs1 obs2观察者实现类 可以通过实现observer接口实现不同的观察者 监听不同的主题
观察者模式核心要点:在主题发生改变的时候 会在改变的方法中同时改变观察者实现类的数据
应该 、也许 、大概 、可能 、或者、 估计、似乎、好像、或许、貌似
也许可能大概是，然而未必不见得；估计基本有可能，但是好像没必要

觉得、好像、似乎、应该、可能、大概、也许、近似、不确定、如果、兴许、未必、估计、八成、或许、约摸、不一定、大约、貌似、宛如、仿佛、莫非、近乎、犹是、没准、总之说不准、结果不知道

代理对象可以控制被代理对象的访问 例如访问权限 日志记录 服务监控 底层网络接口沟通等等 代理对象会屏蔽很多细节 让客户端使用者无需过多关心底层的逻辑实现 易于使用和发挥功效
代理模式 为另一个对象提供一个替身以控制对这个对象的访问
代理模式就是创建一个代理对象 外部客户端会直接调用代理对象的方法 然后代理对象会进行某些程度上的控制 例如到底要不要把调用转给真实的对象等等 所有的事宜由代理对象负责处理

jdk动态代理与cglib动态代理
 jdk动态代理针对接口  通过反射 实现接口的方式代理
 cglib针对类   通过字节码的fastclass 继承的方式动态生成类（不能代理final类）

RealSubject和Proxy都实现了subject接口 这样就允许任何客户端利用代理对象proxy像处理Realsubject一样处理任何事宜 所以任何用到realsubject的地方 都可用proxy来代替和客户端进行交互
在proxy对象中维持了subject的引用对象 用组合依赖的方式实现对请求调用的转发处理 在某些情况下 proxy 还会负责realsubject的创建和销毁 例如rpc远程调用时远程对象的创建 redis缓存代理对象对jedis对象的创建等
代理对象也可以在真实对象方法调用的前后增加一些业务逻辑 来完成一些功能且并不改变原有代码的实现
1动态代理实现
在java的动态代理机制中 有两个重要的类或接口 一个是InvocationHandler接口 另一个是proxy 类  这个类和接口是实现动态代理所必须用到的 

每一个动态代理类都必须要实现InvocationHandler这个接口 并且每个代理类的实例都关联到了一个Handler 当我们通过代理对象调用一个方法的时候 这个方法的调用就会被转发为Invocationhandler 这个接口的invoke方法进行调用 

Proxy 指代我们所代理的真实对象
Method 指代的是我们所要调用真实对象的某个方法的method对象
Args 指代的是调用真实对象某个方法时接受的参数


Loader: 一个classloader对象 定义了由哪个classloader对象对生成的代理对象进行加载
Interfaces 一个interface对象的数组 表示的是我将要给我需要代理的对象提供一组什么接口 如果我提供一组接口给它 那么这个代理对象就宣称实现了该接口 多态 这样我就能调用这组接口中的方法了
H 一个invocationHandler对象 表示的是当我这个动态代理对象在调用方法的时候会关联到哪一个invocationHandler对象上

要代理的接口

实现类

动态代理类:

Test类:

控制台输出:

首先来看看 $Proxy0 这东西，这个东西是由 System.out.println(subject.getClass().getName()); 这条语句打印出来的，那么为什么我们返回的这个代理对象的类名是这样的呢？

可能我以为返回的这个代理对象会是Subject类型的对象，或者是InvocationHandler的对象，结果却不是，首先我们解释一下为什么我们这里可以将其转化为Subject类型的对象？原因就是在newProxyInstance这个方法的第二个参数上，我们给这个代理对象提供了一组什么接口，那么我这个代理对象就会实现了这组接口，这个时候我们当然可以将这个代理对象强制类型转化为这组接口中的任意一个，因为这里的接口是Subject类型，所以就可以将其转化为Subject类型了。
同时我们一定要记住，通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。

这里是通过代理对象来调用实现的那种接口中的方法，这个时候程序就会跳转到由这个代理对象关联到的 handler 中的invoke方法去执行，而我们的这个 handler 对象又接受了一个 RealSubject类型的参数，表示我要代理的就是这个真实对象，所以此时就会调用 handler 中的invoke方法去执行：





3.JAVA反射
Java反射机制是在运行状态中 对于任意一个类 都能够知道这个类的所有属性和方法 对于任意一个对象 都能够调用它的任意一个方法和属性 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制
要想解刨一个类 必须先要获取这各类的字节码文件对象而解刨使用的就是class类中的方法 所以先要获取每一个字节码文件对应的class类型的对象
原理:
反射就是把Java类中的各个成分映射成一个个的java对象
Class对象的由来是将class文件读入内存 并为之创建一个class对象



概念 :
主要是指程序可以访问 检测和修改它本身状态或行为的一种能力,并能根据自身行为和状态和结果 调整或修改应用所描述行为的状态和相关的语义
反射是java中一种强大的工具 能够使我们很方便的创建灵活的代码 这些代码可以再运行时装配 无需再组件之间进行源代码的链接 但是反射使用不当会成本很高
在运行状态中 对于任意一个类 都能知道这个类的所有属性和方法 对于任意一个对象 都能勾调用它的任意一个方法和属性 这种动态获取的信息及动态调用对象的方法的功能称为反射
作用
反编译 .class->.java
通过反射机制访问java对象的属性 方法 构造方法等
把java类中的各个成分映射成一个个java对象
Class对象的由来是将class文件读入内存 并为之创建一个class对象


具体实现
Class c1=class.forName(“name”);
Class c2=Employee.class
Employee e=new Employee();
Class c3=e.getClass();
创建对象 获取类之后我们来创建它的对象 利用newInstance
Object o=c.newInstance();

这样我们就可以获得类的各种内容 进行了反编译对于java这种先编译在运行的语言来说 反射机制可以使代码更加灵活 更加容易实现面向对象

4.JAVA虚拟机
运行时数据区 堆 方法区 虚拟机栈 本地方法栈 程序计数器
程序计数器
 线程私有 当前线程执行的行号指示器 由于java虚拟机的多线程是通过线程轮流切换并分配处理器执行时间的方式来实现的 所以说 在一个时刻 一个
 处理器内核 只会执行一个线程中的指令 为了线程切换后能回到正确的执行位置 需要一个行号指示器
java虚拟机栈
 线程私有 生命周期与线程一致 虚拟机栈是描述**java方法执行的内存模型** 每个方法执行时 都会创建一个栈帧 栈帧中国存储 局部变量表 操作数栈
 动态连表 和方法出口信息 每个方法的执行完成在虚拟机中都对应着一个栈帧从入栈到出栈的过程 
 局部变量表
    存放编译时期可知的各种基本数据类型 对象引用(reference类型 不等同与对象本身 只是引用到对象的一个指令 或指针) returnaddress（指向一个地址的指令）
    long double 数据在变量表中占用两个变量空间 其余数据类型都是一个 局部变量表所需内存空间在编译期分配完成 运行时期不会改变
java堆
 java堆是所有线程内存共享的一块内存空间 在虚拟机启动时创建 用于**存放对象实例**  java堆可以分为 新生代和老年代 存放对象可以是物理上不连续的内存
 空间 逻辑上连续即可
方法区(jdk 1.8后更名 元空间 metaspace)
 线程共享的一个区域 用于**存储已被虚拟机加载的类信息 常量 静态变量 即时编译器编译后的代码**
运行时常量池 
 方法区的一部分(jdk1.7后 运行时常量池由方法区 迁移至 堆 ) class文件中除了有类的版本、字段、方法、接口等描述信息外 还有一项就是常量池
 用于**存放编译期生成的各种字面量和符号引用** 这部分数据由类加载后存入常量池
 常量 字符串 final修饰的字段 
 符号引用 类和接口的全限定名 字段的名称和描述符 方法的名称和描述符
直接内存
 直接内存并不是运行时数据区的一部分 但是这部分内存却被频繁的使用 jdk1.4引入nio 引入了一种基于通道与缓冲区的io方式 他可以使用Native函数库
 直接分配堆外内存 存储在java堆中的 directByteBuffer对象 对这块内存进行操作

对象的创建 
 虚拟机遇到一条new指令时 首先判断这个指令参数在常量池中能否定位到一个类的符号引用 并检查这个符号是否被 加载 解析 初始化过 如果没有 执行类加载过程
 类加载检查通过后 虚拟机为新生对象在java堆中分配内存 对象所需内存大小 类加载时期就可确认 为了解决并发对象创建导致内存冲突问题 对分配空间
 的动作进行同步处理 采用cas配上失败重试的方式保证更新操作的原子性 也可以把内存提前按照线程划分 称为本地线程分配缓冲 当这部分内存使用完成后
 再使用同步处理 内存分配完成后 虚拟机将分配到的内存空间都初始化为零值 保证了对象的实例字段在java代码中不赋初值能直接使用 接下来 虚拟机要对
 对象进行必要设置 例如 对象是哪个类的实例 如何能找到对象的元数据信息 对象的哈希码 对象gc分带年龄 这些信息存放在对象的对象头之中
 上边步骤执行完成后 一个对象就产生了但init方法还未执行 所有字段值都为0 所以一般new指令后会跟随init方法 按照程序员的意愿初始化对象
对象的内存分布
 对象头 实例数据 对齐填充
 对象头
  包括两部分信息 存储对象自身运行时数据 如哈希码 gc分带年龄 锁状态标志 线程持有锁 偏向线程id 偏向时间戳 另一部分是类型指针 即对象指向它
  的类元数据指针 虚拟机通过这个指针来判断对象是哪个类的实例 
 实例数据
  是程序代码中所定义的各种类型的字段内容 无论是父类继承 或子类定义的 都需要记录起来 
 对象的访问定位
  两种定位方式 句柄和直接指针 
  句柄
    堆中会划分出一块内存来作为句柄池 reference中存储的就是对象的句柄地址 而句柄中包含了对象实例数据与类型数据各自的具体地址信息（对象移动时，无需改变栈指向句柄）
   直接指针
    堆中需要考虑如果放置访问类型数据的相关信息 reference中存储的直接就是对象地址（省时）
 java class文件 
  任何一个class文件都对应这一个唯一的一个类或接口的定义信息
  

内存泄漏是指无用对象持续占有内存或无用对象的内存得不到即使释放 
从而造成的内存空间的浪费称为内存泄漏
内存溢出 是指程序在申请内存时 没有足够的内存空间供其使用 出现out of memory 比如申请一个integer 但给它存了long才能存下的数 就是内存溢出

内存溢出的解决方案 
修改jvm启动参数 直接增加内存(-xms 起始内存 -xmx 最大内存)
检查错误日志 查看outofmemory 错误前是否有其他异常或错误
对代码进行走查和分析 找出可能发生溢出的位置

1.检查对数据库查询中 是否有一次获取全部数据的查询 一般来说如果一次取十万条记录到内存 就可能引起内存溢出 这个问题比较隐蔽 因此对于数据库查询尽量采用分页的方式查询
2.检查代码中是否有死循环或递归调用
3.检查是否有大循环重复产生新的对象实体
4.检查List map 等集合对象是否有使用完后未清除的问题 List map等集合对象会始终存有对象的引用 使得这些对象不能被Gc回收

 in()适合B表比A表数据小的情况

2. exists()适合B表比A表数据大的情况

当A表数据与B表数据一样大时,in与exists效率差不多,可任选一个使用.

select * from A
where id in(select id from B)



pgsql数据库由连接管理系统 编译执行系统 存储管理系统 事务系统 系统表 五大部分组成

	连接管理系统接受外部操作对系统的请求 对操作请求进行预处理和分发 起系统逻辑控制的作用
	编译执行系统由查询编译器 查询执行器组成 完成操作请求在数据库中的分析处理和转化工作 最终实现物理存储介质数据的操作
	存储管理系统由索引管理器 内存管理器 外存管理器组成 负责存储和管理物理数据 提供对编译查询系统的支持
	事务系统由事务管理器 日志管理器 并发控制 锁管理器组成 日志管理器和事务管理器完成对操作请求处理的事务
		一致性支持 锁管理器和并发控制提供对并发访问数据的一致性支持
	系统表是pg数据库的元信息管理中心 包括数据库对象信息和数据库管理控制信息 系统表管理元数据信息 
	
	将pg数据库的各个模块连接在一起 形成一个高效的数据管理系统




如何判断对象是否可以回收
可达性算法 通过一系列称为Gc Root的对象作为起点 从这些节点往下搜索 搜索所走过的路程称为引用链 当一个对象到Gc Root没有任何引用链相连的话 证明这个对象是不可用的
Java中GcRoot的对象包括下面几种 
虚拟机栈 栈帧中本地变量表中引用的对象
方法区中类静态属性引用的对象 
方法区中常量引用的对象
本地方法栈中native引用的对象
Java内存模型
1 java内存模型分为主内存和工作内存两个部分 其中主内存存放变量 工作内存由每个线程创建和管理 保存被该线程使用到的变量的主内存的副本拷贝 变量从主内存复制到工作内存 顺序执行read和load操作 变量从工作内存同步到主内存的时候 顺序执行的store和write操作
对于volatile变量在各个线程的一致性 在各个线程的工作内存中 volatile存在不一致的情况 但在每次使用前都会刷新 执行引擎看不到不一致的情况 因策可以认为不一致性问题
原子性 可见性 和有序性 先行发生原则

垃圾回收机制
Java的垃圾回收机制是java虚拟机提供的能力 用于在空闲时间以不定时的方式动态回收无任何引用的对象占据的内存空间
System.gc() 
上边的方法调用时用于显式通知jvm可以进行一次垃圾回收 但真正垃圾回收机制具体在什么时间点开始发生动作这同样是不可预料的 这和抢占式的线程在发生作用时的原理一样
类加载器 类加载时机
类初始化的时机 有且仅有四个
 遇到new getstatic putstatic invokestatic这四条字节码指令的时候
使用java.lang.reflect进行反射调用的时候
当初始化一个类的时候 发现其父类还没有初始化 那么先去初始化它的父类
当虚拟机启动的时候 需要初始化main函数所在的类
1 类加载器
.Java文件经过javac编译后生产.class文件 然后经过类加载器的加载类加载至内存 生成.class类实例 这个实例就是程序访问这个类的入口 通过这个实例的newInstance方法即可得到这个类的实例对象
类加载器有三种 启动类加载器 拓展类加载器 应用类加载器
启动类加载器(bootstrap classloader) 又称引导类加载器 由c++编写 无法通过程序得到 主要负责加载jAVA中的一些核心类库 主要位于<JAVA_HOME>/lib/rt.jar中

拓展类加载器(extension classloader): 主要加载java中的一些拓展类 位于<JAVA_HOME>/lib/ext中 是启动类加载器的子类
应用类加载器(system classLoader): 又称为系统类加载器 主要用于加载classpath路径下我们自己写的类 是拓展类加载器的子类


   比如我们自己写了一个类Student类，经过编译后会得到Student.class文件，然后经过类加载器得到Class实例，例如通过

Class.forName("com.***.Student"),通过全路径加载进来。然后我们用Student.class.getClassLoader()得到它的类加载器，得到的是AppClassLoader(即系统类加载器),如果用Student.class.getClassLoader().getParent()得到的是它的父加载器ExtClassLoader（即拓展类加载器）,然后用Student.class.getClassLoader().getParent().getParent()得到将会是Null，因为启动类加载器是用C++写的，我们无法通过程序直接得到.


Object类是由bootstrap classloader加载的
我们自己写的类有system classloader加载
Bootstrap classloader不是 classloader的子类 因为他由c++编写

类加载器的三大特性 委托性 可见性 单一性
委托性 每个类都有自己的类加载器属性 这也就是为什么可以通过.getClassloader来获取自己的类加载器 当一个类加载器要加载一个类时 他会先委托自己的父类加载器来加载 只有当父类加载器无法加载类时 才会自己去加载 比如自己写的Student类 类加载器systemclassloader会先委托父类extension Classloader加载 然后extension classloader又会委托bootstrap classloader加载 启动类加载器无法加载这个类 交给拓展类加载器 拓展类加载器也无法加载 然后才有系统类加载器进行加载
可见性 可见性是指父类加载器无法利用子类加载器加载的类 而子类加载器可以利用福类加载器加载的类
单一性 一个类只会被类加载器加载一次 不会被重复加载
自己可以自定义类加载器 需实现classloader这个类 也要满足上边所说类加载器的三种特性


六种加载时机
创建类的实例 
访问某个类或接口的静态变量 或者对该静态变量赋值
调用类的静态方法
反射 (如class.forName(“xx”))
初始化一个类的子类
Java虚拟机启动时被标明为启动类的类
2 垃圾回收算法
标记-清除算法
标记阶段的任务是标记处所有需要被回收的对象 清除阶段就是回收标记的对象所占用的空间 标记-清除算法比较容易实现 但是回收后会产生内存碎片 碎片太多可能会导致后续过程中需要为大对象分配空间时无法找到足够的空间而不得不触发一次GC
标记-清除算法采用从根集合进行扫描 对存活对象进行标记 标记完成后 再扫描整个空间中未被标记的对象 进行回收 标记-清除算法不需要进行对象的移动 只需对不存活的对象进行处理 在存活对象比较多的情况下极为高效 但由于标记-清除算法直接回收不存活的对象 因此会造成内存碎片 

一次标记:进行可达性算法后 当对象与gcroot没有关联 进行标记  并筛选 当对象有必要执行	finalize()方法时 则把对象放到f-queue队列中 
二次标记 对f-queue队列中的对象进行标记 在执行finalize方法时 看对象有没有与gcroot关联上 若没有 标记  若有 移出队列  第一次和第二次都被标记的对象 进行回收 		

复制算法
它将可用内存按容量划分成大小相等的两块 每次只使用其中的一块 当这一块的内存用完了 就将还存活着的对象复制到另一块上面 然后再把已使用的内存空间一次清理掉 这样一来 就不会产生大量的内存碎片了
算法简单 运行高效 不容易产生内存碎片 但是对内存空间的使用做出了高昂的代价 因为能够使用的内存缩减到原来的一半 
复制算法的效率跟存活对象的数目多少很有关系 如果存活对象较多 那效率会大大降低
复制算法的提出是为了克服句柄的开销和解决内存碎片的问题 它开始吧堆分成一个对象面和多个空闲面 程序从对象面为对象分配空间 当对象满了 基于复制算法的垃圾收集就从根集合中扫描活动对象 并将每个活动对象复制到空闲面  这样空闲面就变成了对象面 原来的对象面就变成了空闲面 程序会在新的对象面分配内存
标记-整理
为了充分利用内存空间 提出标记整理算法 该算法标记阶段和标记-清除一样 但是在完成标记之后 它不是直接清理可回收对象 而是将存活对象都想一端移动 然后清理掉边界以外的内存
标记-整理算法采用标记-清除算法一样的方式进行对象的标记 但在清除时不同 在回收不存活的对象占用的空间后 会将所有的存活对象往左端空闲空间移动 并更新对应的指针 在标记-清除的基础上 又进行了对象的移动 成本更高 但却解决了内存碎片问题

3 垃圾收集器
Serial 串行收集器是最基本的垃圾回收器 单线程回收器 垃圾回收时 会暂停其他所有工作线程 直到收集结束 新生代采用复制算法 老年代采用标记整理算法
简单高效 没有线程切换所产生的上下文切换
Parallel Scavenge
相较于parnew收集器 他有一个gc自适应调节策略 无需指定默认的初始内存 最大内存 对象年龄等信息 eden区survivor区的比例 会根据系统运行状况的监控信息自适应调节以提供最优停顿时间和最高的吞吐量

Cms收集器
基于标记-清除算法 并发收集 低停顿
注重服务响应速度 但仍然存在stop-world问题


类加载机制
Java中类加载是由classLoader和他的子类来实现的 
加载 验证  准备 解析 初始化


5.JAVA 8lambda
Stream
Stream是元素的集合 这点让stream看起来类似iterator
可以支持顺序合并行的对原stream进行汇聚的操作

Menu.filter(d -> d.getCalories()>300).map(Dish::getName).limit(3).collect(Collectors.toList()) 返回一个list<string>
Filter 接收lambda 从流中排除某些元素 
Map 接受一个lambda 将元素转换成其他形式或提取信息
Limit 截断流 使其元素不超过给定数量
Collect 将流转换成其他形式
前三中中间操作类型都为stream类型 第四种为终端操作 返回其他类型
流是从支持数据处理操作的源生成的一系列元素
流利用内部迭代 迭代通过filter map sorted等操作被抽象掉了
流操作有两类 中间操作和终端操作 
Filter和map等中间操作会返回一个流 并可以连接在一起 可以用它们来设置一条流水线 但并不会生成任何结果 
Foreach和count等终端操作会返回一个非流的值 并处理流水线以返回结果
流中的元素是按需计算的

6.JAVA HashMap

Hashmap是基于哈希表的map接口的实现 存储的是键值对 并允许使用null值null建 hashmap是非 synchronized 即使线程不安全的 hashmap根据建的hashcode值存储数据 大多数情况下可以直接定位到它的值 因而具有很快的访问速度 但是遍历的顺序不是确定的
Hashmap的容量必须是2的倍数 初始大小16`
扩容因子0.75
Hashmap的原理 内部数据结构 
底层使用哈希表(数组加链表)当链表长度大于8将会转换成红黑树

Hashmap中的put方法过程
对key求hash值 然后计算下标 
如果没有碰撞 直接放到索引中 也就是数组中
如果发生碰撞 以链表的方式链接到后边
如果链表长度超过阈值就会把链表转换成红黑树 如果扩容后红黑树长度小于6 将再次转换为链表
如果节点已经存在就替换成旧值
如果数据量到达了数组长度的0.75倍 则扩容 扩容机制数组长度是翻倍 默认长度16 


1.Map.Entry说明
Map是java中的接口，Map.Entry是Map的一个内部接口。
Map提供了一些常用方法，如keySet()、entrySet()等方法，keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。


Currenthashmap 1.8
分段锁 相较于hashTable使用synchronized锁住整个put方法不同 我们知道 hashmap 容器是基于数组+链表 红黑树的形式存储数据的 而 hashmap中的数据 相当于currenthashmap中的segments 而它对每个segment加了锁 相当于 put数据时 根据hashcode对map长度取模 只要不是一个segment的数据 操作就不影响 而且它使用的是reentrantLock锁 可重入锁 
Synchronize是同步锁 锁住一个代码段 其他线程访问时只能 阻塞
Reentrantlock

7.JAVA String


字符串常量池存在运行时常量池中(在jdk7之前存在运行时常量池中  在jdk7已经将其转移到堆中)
字符串常量池的存在使得jvm提高了性能和减少了内存开销

使用字符串常量池 每当我们使用字面量(String s=”1”)创建字符串常量时 jvm会首先检查字符串常量池 如果该字符串已经存在常量池中 那么就将此字符串对象的地址赋值于引用的s(引用s在java栈中)如果字符串不存在常量池中 就会实例化该字符串且将其放到常量池中 并将此字符串对象的地址赋值给引用s(引用s在java栈中)

使用字符串常量池 每当我们使用关键字new (String s=new String(“1”))创建字符串常量时 jvm会首先检查字符串常量池 如果该字符串已经存在常量池中 那么不再在字符串常量池创建该字符串对象 而直接堆中复制该对象的副本 然后将堆中对象的地址赋值给引用s 如果字符串不再常量池中 就会实例化该字符串并且将其放到常量池中 然后在堆中复制该对象的副本 然后将堆中对象的地址赋值给引用s


8.JAVA fastJson

public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray 
public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject 
public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean t类型 
public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray
public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合 
public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本 
public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本 
public static final Object toJSON(Object javaObject); //将JavaBean转换为JSONObject或者JSONArray。


从前端接收的字符串 
类型a=JSONObject.parseObject(字符串,类型(可加可不加 不加为JSONObject类型 也就是map类型))
返回给前端jsonobject类型
String parseObject = JSONObject.toJSONString(a);


注:从前端接收的字符串(若知道String实际类型)转换成javabean 
类型a=JSONObject.parseObject(jsonObject字符串,类型)


Maven 自配置
Spring 各种概念
Aop 切面编程 oop的完善 相当于可以在不改变业务逻辑的情况下 横向切入加入一些自己的逻辑 常用于 日志 事务
将涉及多流程业务的通用逻辑提取封装出来 形成一个切面

Ioc 在传统的java程序中当一个对象需要依赖另一个对象是  通常是创建该对象的实例
而在spring中 这种关系通常会倒过来 当一个对象依赖另一个对象时 spring容器会自动注入你所需要的对象 前提是 该对象已经注入到了IOC容器
把原来代码里需要实现的对象创建 依赖 交给容器来做 需要创建一个容器 然后用配置文件来描述 对象与对象之间的依赖关系
di 依赖注入 就是指对象被动接受依赖类 而不是自己主动去找 而是在容器实例化对象时主动将依赖的对象注入给它
中间件
微服务
ioc容器的初始化包括 beandefinition 的resource的定位 加载 注册 三个过程
9.JAVA Nio
Java io和nio的区别
Nio操作直接缓存区 直接与os交互 selector io复用机制

Channel 通道  buffer缓冲区 selector 选择区 传统io基于字节流和字符流进行操作 而nio基于channel和buffer进行操作 数据总是在通道读取到缓冲区 或者从缓冲区写入通道中 selector 选择区 用于注册 监听多个通道的事件 比如 连接打开 数据到达 因此 单个线程可以监听多个数据通道
区别 io是面向流的 nio是面向缓冲区的 javaio 面向流意味着每次从流中读取一个或多个字节 直至读取所有字节 它们没有被缓存在任何地方 此外 他不能前后移动流中的数据 如果需要前后移动从流中读取的数据 需要先将他缓存在一个缓冲区 nio的缓冲导向方法略有不同 数据读取到一个它稍候处理的缓冲区 需要时可在缓冲区中前后移动 折旧增加了处理过程中的灵活性 但是 还需要检查是否该缓冲区中包含所有你需要处理的数据 而且 需要确保当更多的数据读入缓冲区时 不要覆盖缓冲区中尚未处理的数据
Io的各种流是阻塞的 这意味着 当一个线程调用read或write时 该线程被阻塞 直到有一些数据被读取 或者数据完全写入 该线程在此期间不能再干任何事情 nio的非阻塞模式 使一个线程从某通道发送请求读取数据 但是它仅能得到目前的可用数据 如果目前没有数据可用时 就什么都不会获取 而不是保持线程阻塞 所以直至数据变得可以读取之前 该线程可以继续做其他事情 非阻塞也是如此 一个线程请求写入一些数据到某通道 但不需要等待他完全写入 这个线程同时可以去做别的事情 
线程通常将非阻塞io的空闲时间用于在其它通道上执行io操作 所以一个单独线程 现在可以管理多个输入和输出通道
Selector 运行单线程处理多个channel 如果你的应用打开了多个通道 但每个连接的流量都很低 使用selector就会很方便 例如在一个聊天服务器中 要使用selector 得向selector注册channel 然后调用它的select方法这个方法会一直阻塞到某个注册的通道有事件就绪 一旦这个方法返回 县城就可以处理这些事件 时间的例子有如新的连接进来 数据接收等
Buffer实际上是一个容器 一个连续的数组 channel提供从文件网络读取数据的渠道 但是读写的数据都必须buffer

通过索引来保存数据当前的位置状态





Nio 异步
何为异步 一段代码 异步执行 分成多个线程可以节约线程时间 
单线程异步 io操作时(访问关系型数据库时)线程可以去做其他事情 减少创建线程的开销

9.JAVA 多线程
1四种线程池
ThreadPoolExecutor 四种线程池的底层实现
主要参数:
corePoolSize 核心池的大小
MaximumpoolSize 线程池最大线程数 表示当前线程池最多能创建多少线程
keepAliveTime 表示线程在多长时间没有任务断开连接
workQueue 一个阻塞队列 用来存储等待执行的任务 一般有三种选择:ArrayBlockingQueue LinkedBlockingQueue SynchronousQueue
threadFactory:线程工厂 主要用来创建线程
Handler :表示当拒绝处理任务时的策略 主要有四种取值:
ThreadPoolExecutor.AbortPolicy:	丢弃任务并抛出RejectedExecutionException异常。 
ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务 


线程池创建线程顺序:
创建核心线程->创建队列线程->创建非核心线程->超出大小根据拒绝策略执行 默认抛出异常(注:队列线程数不在最大线程数中)

1.newCachedThreadPool
创建一个可以缓存的线程池 如果线程池的大小超过了处理任务所需要的线程 那么就会回收部分空闲(60秒不执行任务)的线程  当任务数增加时 此线程池又可以智能的添加线程来处理任务 此线程池不会对线程池大小做限制 线程池大小完全依赖于操作系统(或者说jvm)能够创建的最大线程大小
ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
2.newFixedThreadPool
创建一个定长线程池 可控制线程最大并发数 超过的线程会在队列中等待
ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
3.NewScheduleThreadPool
创建一个定长线程池 支持定时及周期性任务执行
ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
4.NewSingleThreadExecutor
创建一个单线程化的线程池 他只会用唯一的工作线程来执行任务 保证所有任务按照执行顺序(FIFO LIFO 优先级)执行
ExecutorService singleThreadPool = Executors.newSingleThreadExecutor()


注:所有线程executorService.shutdown();

2线程中断

 Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
Interrupt() 在一个线程中调用另一个线程的interrupt()方法 即会向那个线程发出信号 线程中断状态已被设置 至于那个线程何去何从 有具体代码实现决定
Isinterrupted() 用来判断当前线程的中断状态true or false
Interrupted()是个Thread的static方法 用来恢复中断状态 


线程被称为轻量级进程 它是CPU执行的最小单元 而进程是操作系统执行的基本单元 一个进程可以包含多个线程 在任务管理器我们看到的则是进程 每个进程之间相互独立 各自为政 这个稍微想象一下就能明白 若有影响那就乱套了 究其根本原因则是 每个进程都被赋予了一块虚拟的地址空间 这样就确保了在一个进程中使用的代码和数据是无法由另一个线程访问 但线程与线程之间可以共享内存 这个理解也不难 当我们一个线程在获取数据时 此时另一个线程则可以显示去获取数据进程内存中存放的数据 那么问题来了 线程到底是怎么工作的呢 就像一个活动 总有主办方来安排这一切 
来的客人一进门都会被工作人员安排座位并好生招待 如此一切才能井然有序的进行 此时的客户就像一个线程 所以同理 在线程内部有一个线程调度器来安排线程的几个状态 比如活动主办方请客户过来观看 此时就有一个帖子上面写好啦要请的人 就像线程中的状态之一 新建 当主办方一切安排妥当后 此时会邀请客户到上边去演讲 上一个快要讲完就会通知下一位 此时就像线程状态之二(就绪) 最后轮到客户上去演讲 很自然就过渡到了线程状态之三(运行) 在客户演讲时中途可能还有问答环节才能继续进行下一环节 此时就像线程状态知四(阻塞)最终客户演讲完毕 主办方会送客户离场 
此时客户的任务算是结束 这就像线程最终状态(死亡) 如此就完成了一个线程的整个生命周期
 线程调度器会确保当前所有线程都能够分配到合适的时间 如果一个线程在等待一个用户的操作 在一个时间的长度内用户没有完全用完 
也就是说用户没有进行持续输入 那么此时线程将进入等待状态 剩余的时间片将自动进行放弃 使得在任何CPU上都不会执行该线程 直到发生下一次输入事件
 所以在整体上增强了系统的性能 因为其线程可自动终止其时间片 所以调用线程的线程调度器在一定程度上 保证那些被阻塞的线程不会消耗CPU时间

线程的组成部分 一个标准的线程由线程id 当前指令指针 寄存器组合和堆栈 那么再下次获取上一次线程用户输入的值需要经过以下三个阶段
 将CPU寄存器中的值保存到当前正在运行的线程的内核对象内部的一个上下文结构中
 从现有线程集合中选出一个线程供调度 如果该线程由另外一个进程拥有 Windows在开始执行任何代码或者接触任何数据之前 还必须切换CPU能够看见的虚拟地址空间
将所有上下文结构中的值加载到CPU的寄存器中
3 ThreadLocal

Threadlocal 是一个本地线程副本变量工具类 主要用于将私有线程和该线程存放的副本对象做一个映射 各个线程之间的变量互不干扰 在高并发场景下 可以实现无状态的调用 特别适用于各个线程依赖不通的变量值完成操作的场景
Threadlocal结构内部 
每个thread线程内部都有一个map 
Map里边存储线程本地对象key 线程的变量副本value
但是 thread内部的map是由threadlocal维护的 由threadlocal负责向map获取和设置线程的变量值
Start与run方法区别
只有调用了start()方法 才会表现出多线程的特性 不同线程的run()方法里边的代码交替执行 如果只是调用run()方法 那么代码还是同步执行的 必须等待一个线程的run()方法里边的全部执行完毕之后 另外一个线程才可以执行run()方法里边的代码
Runnable与callable接口的区别
Runnable里边run方法是没有返回值的 而callable接口中的call()方法是有返回值的 是一个泛型 
cyclicBarrier和countDownLatch区别
两个看上去有点像的类 都在java.util.concurrent下 都可以用来表示代码运行到某个点上区别在于  cyclicBarrier的某个线程运行到某个点上之后该线程立即停止运行 直到所有的线程都达到了这个点 所有线程才重新运行 countDownLatch则不是 某线程运行到某个点上之后 只是给某数值-1 而已 该线程继续运行 前者只能唤起一个任务 后者针对多个任务 前者可以重用 后者当计数为0时则失去作用
Volatile关键字
多线程主要围绕可见性和原子性两个特征展开 使用volatile关键字修饰的变量 保证了其在多线程之间的可见性 及每次读取到volatile变量 一定是最新的数据
Sleep与wait方法的区别
Sleep不会释放对象锁 wait线程会释放对象锁
Sleep属于Thread类 wait属于object类
Sleep表示睡眠 但 不会让出CPU执行权 wait会让出CPU执行权
Sleep有睡眠时间 wait需要notify notifyall
ThreadLocal作用
简单说是一种以空间换时间的做法 在每个thread里边维护了一个以开地址法实现的threadLocal.threadLocalMap 把数据进行隔离 数据不共享 自然没有线程安全方面的问题了

死锁 两个锁以上 两个线程 一个持有锁a 一个持有锁b 持有后 互相sleep一段时间sleep结束后 互相等待对方释放锁 造成死锁
唤醒一个阻塞线程
如果线程是因为调用了 wait() sleep()或者join()方法而导致阻塞 可以中断线程 并且通过抛出interruptedException来唤醒 但线程如果是遇到io阻塞 java代码无法唤醒
多线程的上下文切换是指CPU控制权由一个已经正在运行的线程切换到另一个就绪并等待获取CPU执行权的线程的过程
3 阻塞 同步
阻塞 是指调用方一直等待而且别的事情什么都不做 
非阻塞 是指调用方先去做别的事情
同步处理与异步处理 同步处理是指被调用方得到最终结果之后才返回给调用方 
异步处理是指被调用方先返回应答 然后在计算调用结果 计算完成最终结果再通知并返回给调用方
4 线程控制
countDownLatch 线程倒计数器  c.countDown()  计数器减1  c.await()当计数器数值为0时 执行await后的代码
CyclicBarrier  循环栏杆 c.awit()当c.awit()的数量达到创建时传入的长度时 开始运行awit后的代码
Semaphore 信号量 可以控制同时访问线程个数
countDownLatch 与cyclicBarrier区别
Count不可重置 所以不可以重用 cyclic无限制
CountDownLatch 目的是让一个线程等待其他 N 个线程达到某个条件后，自己再去做某个事（通过 CyclicBarrier 的第二个构造方法 public CyclicBarrier(int parties, Runnable barrierAction)，在新线程里做事可以达到同样的效果）。而 CyclicBarrier 的目的是让 N 多线程互相等待直到所有的都达到某个状态，然后这 N 个线程再继续执行各自后续（通过 CountDownLatch 在某些场合也能完成类似的效果）。

线程池 参数
corePoolSize 线程池的核心线程数
maximumPoolSize 线程池允许的最大线程数
keepAliveTime 超过核心线程数时闲置线程的存活时间
WorkQueue 任务执行前保存任务的队列 保存由execute方法提交的runnable任务

线程池调用execute时
如果正在运行的线程数量小于corepoolSize 那么马上创建线程运行这个任务
如果正在运行的线程数量大于或者等于corePoolSize 那么僵任务放进队列
如果队列已满 而且正在运行的线程数量小于maximumPoolSize 那么还是要创建非核心线程立即运行这个任务
如果队列满了 而且正在运行的线程数量大于或等于maximumPoolSize 那么线程池会抛出RejectExecutionRxception
当一个线程完成任务时 它会从队列中取出下一个任务来执行 当一个线程无事可做 超过一定时间 keepAliveTime 线程池会判断
如果当前运行的线程数大约corePoolSize 那么这个线程会被停掉 所以线程池的所有任务完成后 他最终会收缩到corePoolSize的大小

基于volatile变量的运算在并发下不一定是安全的 volatile变量在各个线程的工作内存 不存在一致性问题 各个线程工作内存中volatile变量 每次使用前都要刷新到主内存
由于java本身并非原子性操作 所以即使被volatile修饰 一样是线程不安全的

Synchronized 既能保证可见性 又能保证原子性 而volatile只能保证可见性
threadLocal与synchronized 都是为了解决多线程中共享变量不一致的问题
Synchronized 用于实现同步机制 类似于多线程串行 时间换空间
threadLocal 为每一个线程提供了变量副本 使得每个线程在对共享变量进行操作的时候 并不是同一个对象 底层基于threadLocalmap 

10.JAVA dao
 
@JsonIgnore
在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口。
@JsonProperty("conn_id")
private String connId;
将java属性与数据库属性相对应



队列
queue 先进先出 继承collection接口 
PriorityQueue 实现类 按照元素大小进行重新排序 不允许插入null 
排序方式 自然排序 集合中元素都实现comparable 否则类型转换异常 
定制排序 传入一个comparable对象 为排序类型 
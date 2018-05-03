# JavaBase
Java基础

- 面向对象的特征

> 封装：将客观的事物封装成类
> 继承：可以使用现有类的所有功能，并在无需重新编写原来的类的情况下对这些功能进行扩展。
> 多态：允许将子类类型的指针赋值给父类类型的指针
参考：[面向对象的三个基本特征 和 五种设计原则](http://blog.csdn.net/cancan8538/article/details/8057095)

<br/>

- final, finally, finalize 的区别

> final 用于标识类或者属性 ，表示类不能被继承，表示属性为常量不可改变
> finally 是异常捕捉后的处理代码块，一般用于关闭资源，释放资源
> finalize 是一个方法，在基类里面的一个方法，在发生垃圾回收的时候回被调用

<br/>

- int 和 Integer 有什么区别

> int 是基础类型默认初始化值是0
> Integer是int的包装类是对象类型，默认初始化值是null
> 参考：[java int与integer的区别](http://www.cnblogs.com/shenliang123/archive/2011/10/27/2226903.html)

<br/>

- String ， StringBuffer ，StringBuilder的区别

> String 字符串类，效率低，每次操作都会新建对象
> StringBuffer 是线程安全的
> StringBuilder不是线程安全的
> 参考：[探秘Java中的String、StringBuilder以及StringBuffer](http://www.cnblogs.com/dolphin0520/p/3778589.html)

<br/>

- 重载和重写的区别

> 覆盖，是指子类重新定义父类的虚函数的做法。
> 重载，是指允许存在多个同名函数，而这些函数的参数表不同（或许参数个数不同，或许参数类型不同，或许两者都不同）。

<br/>

- 抽象类和接口有什么区别

> 抽象类：
> 1. 抽象类不能被实例化,子类可以实例化
> 2. 抽象方法必须由子类来重写，如果不重写，则子类的这个方法也必须是抽象的
> 3. 抽象类可以包含具体的方法，也可以不包含抽象方法
> 4. 子类的抽象方法不能和父类的抽象方法名字一样
> 5. abstract不能和final一起修饰同一个类
> 6. abstract不能和private、static、final一起修饰同一个方法

> 接口:
> 1. 接口的方法和属性都默认并且只能是public的
> 2. 接口不能有具体的方法
> 3. 实现接口的非抽象类必须要实现该接口的所有方法。抽象类可以不用实现
> 4. 接口不能被实例化，但是可以用instance检测某个类是否实现了某个接口

> 抽象类是对整个类的抽象，而接口是对类的某些行为的抽象是局部的抽象

<br/>

- 说说反射的用途及实现？？？？
- 说说自定义注解的场景及实现？？？？

<br/>

- HTTP 请求的 GET 与 POST 方式的区别

> GET - 从指定的资源请求数据(取数据)
> 1. 请求可被缓存
> 2. 请求保留在浏览器历史记录中
> 3. 请求可被收藏为书签
> 4. 请求不应在处理敏感数据时使用
> 5. 请求有长度限制
> 6. 请求只应当用于取回数据

> POST - 向指定的资源提交要被处理的数据(提交数据)
> 1. 请求不会被缓存
> 2. 请求不会保留在浏览器历史记录中
> 3. 不能被收藏为书签
> 4. 请求对数据长度没有要求

 <br/>

- session 与 cookie 区别

> Session是在服务端保存的一个数据结构，用来跟踪用户的状态，这个数据可以保存在集群、数据库、文件中；
> Cookie是客户端保存用户信息的一种机制，用来记录用户的一些信息，也是实现Session的一种方式
> 参考：[看完就彻底懂了session和cookie](https://www.jianshu.com/p/25802021be63)

- session 分布式处理

> 1. 粘性session
> 2. 服务器session复制
> 3. session共享机制(最常用)
> 4. session持久化到数据库
> 5. terracotta实现session复制
> 参考：[集群/分布式环境下5种session处理策略](http://blog.csdn.net/u010028869/article/details/50773174)
> [微服务架构下分布式SESSION管理](http://www.primeton.com/read.php?id=2244&his=1)

- JDBC 流程
- MVC 设计思想
- 文件流
- 输入输出流
- 序列化
- & 与 &&


- equals 与 == 的区别
> ==对比的是引用 equals对比的是实际的内容，是根据类自己实现的

- equals() 与 hashcode()
- 异常的原理和机制


#### 集合
- List 和 Set 区别
- List 和 Map 区别

<br/>

- 数据结构类的实现 LinkedList，ArrayList，HashMap，TreeMap等

> TreeMap 是一个有序的key-value集合，它是通过红黑树实现的。
> 参考：[TreeMap详细介绍-源码解析和使用示例](https://www.cnblogs.com/skywang12345/p/3310928.html#a1)


- Arraylist 与 LinkedList 区别
- ArrayList 与 Vector 区别

<br/>

- HashMap 和 Hashtable 的区别

> 这两个类几乎相等，但还是有一些区别
> 1. HashMap非synchronized的  HashTable是synchronized的
> 2. HashMap可以接受null作为key，HashTable不行

> Java5以后使用ConcurrentHashMap
> 参考： [HashMap和HashTable到底哪不同](http://zhaox.github.io/2016/07/05/hashmap-vs-hashtable)


- HashSet 和 HashMap 区别

- HashMap 和 ConcurrentHashMap 的区别
- HashMap 的工作原理及代码实现

<br/>

- ConcurrentHashMap 的工作原理及代码实现

> 参考：[彻头彻尾理解 ConcurrentHashMap](http://blog.csdn.net/justloveyou_/article/details/72783008)


- Java并发包当中的类，它们都有哪些作用，以及它们的实现原理，这些类就是java.concurrent包。重中之重，一定要仔细看看
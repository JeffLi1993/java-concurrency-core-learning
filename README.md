# java-concurrency-core-learning
关于 Java 并发编程核心技术学习积累的例子，是 Java 并发编程初学者及核心技术巩固的最佳实践。

代码目录：

```java
org.concurrent.MyThread                 // 继承 Thread 类创建线程对象
org.concurrent.MyThreadBrother          // 实现 Runnable 接口类创建线程对象
org.concurrent.MyThreadInfo             // 线程实例对象的属性值
org.concurrent.InterruptedException     // 抛出 InterruptedException 的线程，中断状态被重置为默认状态 false
org.concurrent.InterruptedThread        // 一直运行的线程，中断状态为 true
org.concurrent.ThreadSafeStop           // 安全终止线程
```

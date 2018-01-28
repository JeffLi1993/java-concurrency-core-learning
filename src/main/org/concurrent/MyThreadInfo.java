package org.concurrent;

/*
 * Copyright [2018] [Jeff Lee @ bysocket.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 线程实例对象的属性值
 * @author Jeff Lee @ bysocket.com
 * @since 2018年01月27日21:24:40
 */
public class MyThreadInfo extends Thread {

    @Override // 可以省略
    public void run() {
        System.out.println("MyThreadInfo 的线程实例正在执行任务");
//        System.exit(1);
    }

    public static void main(String[] args) {
        MyThreadInfo thread = new MyThreadInfo();
        thread.run();

        System.out.print("MyThreadInfo 的线程对象 \n"
                + "线程唯一标识符：" + thread.getId() + "\n"
                + "线程名称：" + thread.getName() + "\n"
                + "线程状态：" + thread.getState() + "\n"
                + "线程优先级：" + thread.getPriority());
    }
}

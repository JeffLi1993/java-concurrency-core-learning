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
 * 实现 Runnable 接口类创建线程对象
 * @author Jeff Lee @ bysocket.com
 * @since 2018年01月27日21:22:57
 */
public class MyThreadBrother implements Runnable {

    @Override // 可以省略
    public void run() {
        System.out.println("MyThreadBrother 的线程对象正在执行任务");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyThreadBrother());
            thread.start();

            System.out.println("MyThreadBrother 的线程对象 " + thread.getId());
        }
    }
}

package org.concurrent;

import java.util.concurrent.TimeUnit;

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
 * 抛出 InterruptedException 的线程，中断状态被重置为默认状态 false
 *
 * @author Jeff Lee @ bysocket.com
 * @since 2018年02月23日19:03:02
 */
public class InterruptedException implements Runnable {

    @Override // 可以省略
    public void run() {
        // 一直 sleep
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Thread interruptedThread = new Thread(new InterruptedException(), "InterruptedThread");
        interruptedThread.start();

        TimeUnit.SECONDS.sleep(2);

        // 中断被阻塞状态（sleep、wait、join 等状态）的线程，会抛出异常 InterruptedException
        // 在抛出异常 InterruptedException 前，JVM 会先将中断状态重置为默认状态 false
        interruptedThread.interrupt();
        System.out.println("InterruptedThread interrupted is " + interruptedThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }
}

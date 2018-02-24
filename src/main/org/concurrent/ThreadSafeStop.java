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
 * 安全终止线程
 *
 * @author Jeff Lee @ bysocket.com
 * @since 2018年02月23日19:03:02
 */
public class ThreadSafeStop {

    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 睡眠 1 秒，通知 CountThread 中断，并终止线程
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"CountThread");
        countThread.start();
        // 睡眠 1 秒，然后设置线程停止状态，并终止线程
        TimeUnit.SECONDS.sleep(1);
        two.stopSafely();
    }

    private static class Runner implements Runnable {

        private long i;

        // 终止状态
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                // 线程执行具体逻辑
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void stopSafely() {
            on = false;
        }
    }
}

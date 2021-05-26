package pers.li.test.singleton;

import pers.li.singleton.Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试单例模式
 */
public class TestSingleton {

    static class CallDemo implements Callable<Demo> {
        @Override
        public Demo call() {
            return Demo.getInstance();
        }
    }

    public static void main(String[] args) {
        CallDemo callDemo = new CallDemo();
        FutureTask<Demo> task = new FutureTask<Demo>(callDemo);

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        Thread t5 = new Thread(task);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");
        t5.setName("t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            Demo demo1 = task.get();
            Demo demo2 = task.get();
            Demo demo3 = task.get();
            Demo demo4 = task.get();
            Demo demo5 = task.get();

            System.out.println(demo1 == demo2);
            System.out.println(demo2 == demo3);
            System.out.println(demo3 == demo4);
            System.out.println(demo4 == demo5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}

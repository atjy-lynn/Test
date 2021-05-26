package pers.li.test.singleton;

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
        
    }


}

package pers.li.singleton;

public class Demo{
    private static volatile Demo demo = null;
    private final static byte[] bytes = new byte[0];

    private Demo() {}

    public static Demo getInstance() {
        if (demo == null) {
            synchronized (bytes) {
                if (demo == null) {
                    demo = new Demo();
                }
            }
        }
        return demo;
    }
}
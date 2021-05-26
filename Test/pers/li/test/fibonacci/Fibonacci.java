package pers.li.test.fibonacci;

import java.io.File;

public class Fibonacci {
    private static final String PATH = "E:/Demo/Test";
    private static final String FIBONACCI_TITLE =
            "---------------- Fibonacci ----------------";
    private static final String LISTALLFILE_TITLE =
            "---------------- ListAllFile ----------------";

    public static void main(String[] args) {
        System.out.printf("%s\n", FIBONACCI_TITLE);
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + ": " + getFib(i));
        }
        System.out.printf("%s\n", LISTALLFILE_TITLE);
        listAllFile(new File(PATH));
    }

    public static int getFib(int n) {
        if (n < 0) {
            return -1;
        } else if (0 == n) {
            return 0;
        } else if (1 == n || 2 == n) {
            return 1;
        } else {
            return getFib(n - 1) + getFib(n - 2);
        }
    }

    public static void listAllFile (File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("directory: " + f.getName());
                listAllFile(f);
            } else {
                System.out.println("file: " + f.getName());
            }
        }
    }


}

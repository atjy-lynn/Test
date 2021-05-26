package pers.li.test;

public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        int[][] sparseArr = chessArrToSparseArr(chessArr);
        int[][] chessArrBack = sparceArrToChessArr(sparseArr);
        // 展示还原后的二维数组
        dyadicToString(chessArrBack);
    }

    private static int[][] chessArrToSparseArr(int[][] chessArr) {
        int count = 0;
        // 初始化数据
        chessArr[2][1] = 1;
        chessArr[3][2] = 2;
        // 展示原数组
        System.out.println("原始的二维数组：");
        dyadicToString(chessArr);

        // 获取总数据量
        for(int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (0 != chessArr[i][j]) {
                    count++;
                }
            }
            System.out.println();
        }
        int[][] sparseArr = new int[count + 1][3];
        int index = 0;
        // 第一列数据存入压缩目标的行列数及总共存放了多少个数值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = count;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (0 != chessArr[i][j]) {
                    index++;
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("转换后的稀疏数组：");
        // 展示稀疏数组
        dyadicToString(sparseArr);
        return sparseArr;
    }

    private static int[][] sparceArrToChessArr(int[][] sparceArr) {
        int chessArr[][] = new int[sparceArr[0][0]][sparceArr[0][1]];

        for (int i = 1; i < sparceArr.length; i++) {
            int row = sparceArr[i][0];
            int col = sparceArr[i][1];
            int val = sparceArr[i][2];
            chessArr[row][col] = val;
        }
        System.out.println("还原后的二维数组：");
        return chessArr;
    }

    public static void dyadicToString(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}

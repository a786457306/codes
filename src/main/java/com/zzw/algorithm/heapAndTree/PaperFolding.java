package com.zzw.algorithm.heapAndTree;

/**
 * PaperFolding
 *
 * @author Daydreamer
 * @date 2018/4/7 10:39
 */
public class PaperFolding {
    public static void printAllFolds(int N){
        printProcess(1, N, true);
    }

    //i：当前层数，N：折叠次数，down：是否是向下的折痕
    public static void printProcess(int i, int N, boolean down){
        if (i > N){
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "down" : "up");
        printProcess(i + 1, N, false);
    }
}

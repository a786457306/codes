package com.zzw.algorithm.university.Fenzhi03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Gambler
 * 赌徒
 *
 * 游戏刚开始的时候，每个赌徒把赌注放在桌上并遮住，侍者要查看每个人的赌注并确保每个人的赌注
 * 都不一样。如果一个赌徒没钱了，则他要借一些筹码，因此他的赌注为负数。假定赌注都是整数。
 * 最后赌徒们揭开盖子，出示他们的赌注。如果谁下的赌注是其他赌徒中某3个人下的赌注之和，
 * 则他是胜利者。如果有多于一个胜利者，则下的赌注最大的赌徒才是最终的胜利者。
 * 例如，假定赌徒为：Tom、Bill、John、Roger和Bush，他们下的赌注分别为：
 * ￥2、￥3、￥5、￥7和￥12 。因此最终获胜的是Bush（并且没有其他人是胜利者），
 * 因为他下的赌注为￥12，而其他的人下的赌注之和也等于12：￥2+￥3+￥7=￥12。
 * 输出胜利者下的赌注
 *
 * 层层遍历，先以最大的为获胜，二分查找找到三个赌注值。
 *
 * @author Daydreamer
 * @date 2017/10/7 11:11
 */
public class Gambler {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            //输入数值个数不合法
            if (num == 0)
                break;
            if (num <= 3){
                System.out.println("no solution");
                continue;
            }
            //赌注存入数组
            int[] stake = new int[num];
            for (int i = 0; i < num; i++){
                stake[i] = sc.nextInt();
            }
            //给数组排序，以用于二分查找
            Arrays.sort(stake);
            boolean isFind = false;
            int result = 0;
            for (int i = num - 1; i >= 0; i--){
                for (int j = 0; j < i; j++){
                    for (int k = j+1; k < i; k++){
                        int temp = stake[i] - stake[j] - stake[k];
                        int res = binarySearch(stake, k+1, i-1, temp);
                        if (res != -1){
                            isFind = true;
                            result = stake[i];
                            break;
                        }
                    }
                    if (isFind){
                        break;
                    }
                }
                if (isFind){
                    break;
                }
            }
            if (isFind){
                System.out.println(result);
            }else {
                System.out.println("no solution");
            }
        }
    }

    public static int binarySearch(int[] stake, int low, int high, int target){
        while(low <= high) {
            int mid = (low + high) / 2;
            if (target == stake[mid]){
                return mid;
            }
            if (target > stake[mid]){
                low = mid + 1;
            }
            if (target < stake[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }
}

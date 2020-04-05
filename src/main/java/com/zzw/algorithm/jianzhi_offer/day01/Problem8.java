package com.zzw.algorithm.jianzhi_offer.day01;

/**
 * Problem8
 * 旋转数组的最小数字
 *
 * 题目描述：
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}
 * 的一个旋转，该数组的最小值为1.
 *
 * 思路：
 * 二分查找，中间元素比左边元素大则一定在左边的递增序列，
 * 中间元素比左边元素小则一定在右边的递增序列
 *
 * @author Daydreamer
 * @date 2018/8/21 11:06
 */
public class Problem8 {

    public static void main(String[] args) {
        Problem8 p8=new Problem8();
//        int[] array={1,1,1,2,0};
//        int[] array={3,4,5,1,2};
        int[] array={1,0,1,1,1};
        System.out.println(p8.findMinNum(array));
    }

    private Integer findMinNum(int[] array) {
        if (array == null){
            return null;
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int mid = 0;
        //旋转数组是把递增数组前面的数字搬到后面，所以数组的左边第一个元素一定大于右边最后一个元素
        while (array[leftIndex] >= array[rightIndex]){
            //找到中间元素
            if (rightIndex - leftIndex <= 1){
                mid = rightIndex;
                break;
            }
            mid = (leftIndex + rightIndex) / 2;

            if(array[leftIndex]==array[rightIndex]&&array[leftIndex]==array[mid]){
                if(array[leftIndex+1]!=array[rightIndex-1]){
                    mid=array[leftIndex+1]<array[rightIndex-1]?(leftIndex+1):(rightIndex-1);
                    break;
                }else{
                    leftIndex++;
                    rightIndex--;
                }
            }else{
                if(array[mid]>=array[leftIndex])
                    leftIndex=mid;
                else {
                    if(array[mid]<=array[rightIndex])
                        rightIndex=mid;
                }
            }
        }
        return array[mid];

    }
}

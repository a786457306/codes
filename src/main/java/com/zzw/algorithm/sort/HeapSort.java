package com.zzw.algorithm.sort;

/**
 * HeapSort
 * 堆排序，满二叉树
 * 用给二叉树节点排序的方法给数组排序。
 * 排成大根堆，第一个元素与最后一个元素换位置，此时最大值排好了，size--
 * 然后从0元素开始看当前元素的左右孩子，哪个大就跟当前元素换位置。
 * 直至堆大小为0
 *
 * 步骤：将元素加入堆，heapInsert，组成大根堆
 * 交换堆顶元素和较大的元素，heapify
 *
 * @author Daydreamer
 * @date 2018/3/27 22:03
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            heapInsert(arr, i);//把所有元素插入合适位置建立大根堆
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);//首先将大根堆第一个元素跟最后一个元素交换
        while (heapSize > 0){//heapSize大于0的话就总是把父元素与最后一个元素交换
            heapify(arr, 0, heapSize);//将最大的元素换到根位置
            swap(arr, 0, --heapSize );//根（最大元素）与树的最后一个元素交换
        }
    }

    public static void heapInsert(int[] arr, int index){//建立大根堆，把当前元素移到合适位置
        while (arr[index] > arr[(index - 1) / 2]){//当前位置与父节点位置值比较
            swap(arr, index, (index - 1) / 2);//换成父节点后继续比较。
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size){//将剩下元素中最大的换到堆顶
        int left = index * 2 + 1;//当前元素的左孩子节点
        while (left < size){//未越界时
            //右孩子节点未越界时，比较左右俩孩子哪个大，大的赋给largest
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //俩孩子大的那个跟当前节点比较，孩子大就换位置。
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){//还是父节点大的话就不用换了，while可以退出了，直接将父节点与最后一个节点交换就行了
                break;
            }
            swap(arr, largest, index);//父节点小，换位置
            index = largest;
            left = index * 2 + 1;//从largest的位置继续往下看，继续换位置
        }
    }

    public static void swap(int[] arr, int i, int j) {
        //是值传递，但把数组指针传过来以后就直接改数组了。内部实际上改变的是arr所指的对象的成员数据。
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

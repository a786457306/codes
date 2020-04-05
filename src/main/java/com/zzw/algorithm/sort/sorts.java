package com.zzw.algorithm.sort;

/**
 * sorts
 *
 * @author Daydreamer
 * @date 2018/9/3 11:15
 */
public class sorts {

//    --------------quickSort------------------

    public static void quickSort(int[] arr, int l, int r){
        if (l < r){
            swap(arr, r, l + (int)(Math.random() * (r - l + 1)));
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r){
        int less = l - 1;
        int more = r;
        while(l < r){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]){
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, r, more);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    ------------insertSort----------------

    public static int[] insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && temp > arr[j]; j--){
                arr[j+1] = arr[j];
            }
            arr[j + 1] = temp;
        }

        return arr;
    }

//    ---------------selectSort---------------

    public static int[] selectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = i + 1; j < len; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            if (min != i){
                swap(arr, min, i);
            }
        }
        return arr;
    }

//    -----------------bubbleSort-----------------

    public static int[] bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        for (int i = len - 1; i > 0; i--){
            int max = i;
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[max]){
                    max = j;
                }
            }
            if (max != i){
                swap(arr, max, i);
            }
        }
        return arr;
    }

//      ------------------mergeSort-------------------

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int l, int r){
        if (l == r){
            return;
        }
        int mid = l + ((r - l) / 2);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r){
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r){
            temp[i++] = arr[p1] < arr[p2] ? arr[p1] : arr[p2];
        }
        while (p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while (p2 <= r){
            temp[i++] = arr[p2++];
        }
        for (i = 0; i < temp.length; i++){
            arr[l + i] = temp[i];
        }
    }


//    --------------heapSort---------------

//    public static int[] heapSort(int[] arr){
//
//    }
}


package com.personal.eureka01;

public class Sort {


    public static int[] swap(int []arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
        return arr;
    }

    /**
     * 冒泡排序算法，每一位与后一位比较，像冒泡一样，最大的数排到最后
     * @param arr
     * @return
     */
    public static int[] maopao(int[] arr) {
        int len= arr.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }


        return arr;
    }

    public static int[]kuaipai(int []arr){

        kuai(arr,0,arr.length-1);
        return  arr;
    }

    /**
     * 快速排序，左侧总比右侧小
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int[]kuai(int []arr,int low,int high){
        int i=low;
        int j=high;
        int povit=arr[low];
        while(i<j){
            while(i<j&&arr[j]>povit){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while(i<j&&arr[i]<povit) {
                i++;
            }
            if(i<j){
                arr[j]=arr[i];
                j--;
            }

        }
        arr[i]=povit;
        if(i-1>low){
            kuai(arr,low,i-1);
        }
        if(j+1<high){
            kuai(arr,j+1,high);
        }

        return arr;
    }



    /**
     * 插入排序算法，以第0位作为有序位，找到位置，将数据插入到位置中
     * @param arr
     * @return
     */
    public static int[] charu(int[] arr){
        //第0位作为有序位置
        for(int i=1;i<arr.length;i++){
            //
            if(arr[i]<arr[i-1]){
                int tmp=arr[i];
                for(  int j=i-1;j>-1;j--){
                    if(tmp>arr[j]){
                        arr[j+1]=tmp;
                        break;
                    }else{
                        //挪动位置
                        arr[j+1]=arr[j];
                    }
                }

            }
        }

         return arr;
    }

    public static int binarySearch(int []arr,int n,int target){
        int low=1;
        int high=n;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(arr[middle]==target) {
                return middle;
            }
            else if(arr[middle]>target){
                high=middle-1;
            }else{
                low=middle+1;
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,9, 22, 2, 44, 64, 20, 15, 77, 45, 133};

        //排序
        int[] retArr = kuaipai(arr);
//        for (int i = 0; i < retArr.length; i++) {
//            System.out.println(retArr[i]);
//        }
        //查找
        int target= binarySearch(arr,arr.length,22);

        System.out.println(target);
    }



}

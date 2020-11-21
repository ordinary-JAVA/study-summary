package com.example.test.test;

/*冒泡排序*/
public class MPSort {
    public static void main(String[] t) {
        int [] arr=new int[]{33,23,43,36,83,58};
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    int temporary=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temporary;
                }
            }
        }

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.company.mergesort;

/**
 *
 * @author kamau
 */
public class MergeSort {

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int medium = (left + right) / 2;
            mergeSort(arr, left, medium);    //first array after dividing 
            mergeSort(arr, medium + 1, right);  //second array

            // merge the two arrays above
            merge(arr, left, medium, right);
        }

    }

    private static void merge(int[] arr, int left, int medium, int right) {
        //lets define the sizes of the two arrays to merge
        int n1 = medium - left + 1;
        int n2 = right - medium;

        int[] lArray = new int[n1];
        int[] rArray = new int[n2];

        //the two for loops to copy the values to the main array
        for (int x = 0; x < n1; x++) {
            lArray[x] = arr[left + x];
        }
        for (int x = 0; x < n2; x++) {
            rArray[x] = arr[medium + 1 + x];   //adding the values of small array into the main array
        }

        //
        int i = 0;
        int j = 0;
        int key = left;

        while (i < n1 && j < n2) {
            if (lArray[i] <= rArray[j]) {
                arr[key] = lArray[i];
                i++;
            }
            else{
                 arr[key] = rArray[j];
                j++;  
            }
            
            key++;   //this is our main array increasing in size
        }
        
        //now copy all the values remaining from the left array and right array
        while(i<n1){
            arr[key] = lArray[i];
            i++;
            key++;
        }
         while(j<n2){
            arr[key] = lArray[j];
            j++;
            key++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 5};
        mergeSort(arr, 0, arr.length - 1);

        for (int n : arr) {
            System.out.print(n + " ");
        }

    }

}

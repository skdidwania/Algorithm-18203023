

import java.util.Random;

public class mergesort //start of the class
{

    public static void main(String[] args) {

        int n=10;
        while(n<=10000) {  //testing framework for 10,100,1000,10000
            Random rd = new Random(); // creating Random object
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rd.nextInt(); // storing random integers
                // printing each array element
            }
            /*time calculation of various sorting techniques*/
            long startTime = System.nanoTime();
            int[] sortedArray = InsertionSort(arr);
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Using Insertion Sort");
            PrintArray(sortedArray);
            System.out.println("Time taken: " + estimatedTime + "\n");


            startTime = System.nanoTime();
            sortedArray = MergeSort(arr);
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Using Merge Sort");
            PrintArray(sortedArray);
            System.out.println("Time taken: " + estimatedTime + "\n");

            startTime = System.nanoTime();
            sortedArray = enhanced_MergeSort(arr);
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Using Improved Merge Sort");
            PrintArray(sortedArray);
            System.out.println("Time taken: " + estimatedTime + "\n");
           n=n*10;
        }


    }//end of main
    //function prints the array
    public static void PrintArray(int[] Array){
            for (int i=0; i<Array.length;i++)
            {
            System.out.print(Array[i] + " ");//prints the array
             }
            System.out.println();
    }//en of the function



    //insertion sort
    static   int[] InsertionSort(int[] arr)
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)//loop
        {
            int k = arr[i]; //key
            int j = i-1;

            while (j>=0 && arr[j] > k)//sorting
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = k;
        }
        return arr;
    }//end of the function


     /*merge sort method to sort the array and return it
      referred the internet for some portion of the code*/
    public static int[] MergeSort(int[] arr) {
        if (arr.length==1)
        {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);//copies the array
        System.arraycopy(arr, mid, right, mid - mid, arr.length - mid);//copies the array
        MergeSort(left);//recursive call
        MergeSort(right);//recursive call
        merge(arr, left, right, mid, arr.length - mid);
        return arr;//returns the array
    }
    /*enhanced merge sort method to sort the array and return it
     used insertion sort for sub_arrays*/
    public static int[] enhanced_MergeSort(int[] arr) {
        //for sub_arrays
        int CUTOFF=5;//cutoff added
        if(arr.length + CUTOFF<=15){
            return InsertionSort(arr);//insertion sort
        }

        int mid = arr.length / 2; //calculating the middle value
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        if(arr[mid] >= arr[mid-1])
        {
            return arr;
        }

        System.arraycopy(arr, 0, left, 0, mid);//copies the array
        System.arraycopy(arr, mid, right, mid - mid, arr.length - mid);//copies the array
        enhanced_MergeSort(left);//recursive call
        enhanced_MergeSort(right);//recursive call
        merge(arr, left, right, mid, arr.length - mid);//merges the sorted array
        return arr;//returns the sorted array
    }

    /*merge the sorted arrays
    referred the internet for some portion of the code*/
      public static void merge(int[] arr, int[] left_Array, int[] right_Array, int left, int right) {

        int i = 0,j =0,k = 0;

        while (i < left && j < right)
        {
            if (left_Array[i] <= right_Array[j])
            {
                arr[k++] = left_Array[i++];
            }
            else
           {
                arr[k++] = right_Array[j++];
            }
        }
        while (i < left)
        {
            arr[k++] = left_Array[i++];
        }
        while (j < right)
        {
            arr[k++] = right_Array[j++];
        }
    }


}//END OF THE CODE

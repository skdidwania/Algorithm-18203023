

import java.util.Random;

public class QuickSort
{
    //testing
    public static void main(String[] args) {

        int n=10;
        while(n<=10000) {  //testing framework for 10,100,1000,10000
            Random rd = new Random(); // creating Random object
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rd.nextInt(); // storing random integers
                // printing each array element
            }


            long startTime = System.nanoTime();
            Quicksort(arr,0,arr.length-1);
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Using Quick Sort");
            PrintArray(arr);
            System.out.println("Time taken: " + estimatedTime + "\n");


            startTime = System.nanoTime();
            int[] sortedArray = MergeSort(arr);
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Using Merge Sort");
            PrintArray(sortedArray);
            System.out.println("Time taken: " + estimatedTime + "\n");

            startTime = System.nanoTime();
             Enhanced_Quicksort(arr,0,arr.length-1);
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Using Improved Quick Sort");
            PrintArray(arr);
            System.out.println("Time taken: " + estimatedTime + "\n");
            n=n*10;
        }


    }
    //prints the array
    public static void PrintArray(int[] Array){
        for (int i=0; i<Array.length;i++)
        {
            System.out.print(Array[i] + " ");
        }
        System.out.println();
    }

    //insertion sort
    //reference taken form geeksforgeeks
    private static void insertionSort( int [ ] a, int l, int r )
    {
        for(int p = l + 1;p <= r;p++ )  //looping
        {
            int temp = a[p];
            int j;
            for(j = p;j > l && temp < a[ j - 1 ]; j-- )
                a[j] = a[j-1];
               a[j] = temp;//swapping
        }
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

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, mid - mid, arr.length - mid);
        MergeSort(left);
        MergeSort(right);
        merge(arr, left, right, mid, arr.length - mid);
        return arr;
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
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

      //quicksort code using partition
      //used recursion
     static  void Quicksort(int arr[], int low, int high)
    {
        if (low<high)
        {   int pi = partition(arr, low, high);
            Quicksort(arr, low, pi-1);//recursive calls quicksort
            Quicksort(arr, pi+1, high);
        }
    }
    private static void Enhanced_Quicksort( int [ ] a, int left, int right )
    {
        //made the cutoff 9
        int CUTOFF=9;
              if( left + CUTOFF <= right ){
                int pivot = median(a,left,right );
               int i = left, j = right - 1;
               //had to refer to internet as there were some bugs for this part
              for( ; ; )
              {
                  while( a[ ++i ] < pivot ) { }
                   while( a[ --j ] > pivot ) { }
                   if( i < j )
                       swap( a, i, j );
                 else
                          break;
    }

               swap( a, i, right - 1 );
              //recursively calling Enhanced quick sort function
               Enhanced_Quicksort(a, left, i - 1 );
               Enhanced_Quicksort(a, i + 1, right );
    }
    else  // Do an insertion sort on the subarray
                insertionSort(a,left,right );
    }
    //Swapping the values oat 2 positions i1,i2
    public static final void swap( int [ ] a,int i1,int i2)
    {
        /*swapping*/
        int temp=a[i1];
        a[i1]=a[i2];
        a[i2]=temp;
    }//end of the function
    //function to get the median for the enhanced quick sort function instructed by the professor
    //referred the internet
    private static int median( int [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if(a[center]<a[left] )
            swap(a,left,center);//swapping
        if( a[right] < a[left] )
            swap( a,left,right );//swapping
        if( a[right]<a[center] )
            swap(a,center,right);//swapping
        swap(a, center, right - 1 );
        return a[right - 1];//returning the median
    }
}//end of the code






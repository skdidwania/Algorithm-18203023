import java.util.Random;
public class Sorting
{
    static void Selection_sort(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)//loop
        {

            int min = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;//minimum element finding

           //swapping
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    //insertion sort
     static   void Insertion_sort(int[] arr)
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
    }//end of the function
    static void bogoSort(int[] a)
    {
        // if array is not sorted then shuffle the
        // array again
        while (isSorted(a) == false)
            shuffle(a);
    }

    // To generate permuatation of the array
    static void shuffle(int[] a)
    {
        // Math.random() returns a double positive
        // value, greater than or equal to 0.0 and
        // less than 1.0.
        for (int i=1; i <= a.length; i++)
            swap(a, i, (int)(Math.random()*i));
    }

    // Swapping 2 elements
    static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // To check if array is sorted or not
    static boolean isSorted(int[] a)
    {
        for (int i=1; i<a.length; i++)
            if (a[i] < a[i-1])
                return false;
        return true;
    }

    // Prints the array
    static  void printArray(int[] arr)
    {
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


        public static void main(String[] args)
        {
            int n=10;
           while(n<=10000)
        {  //testing framework for 10,100,1000,10000
            Random rd = new Random(); // creating Random object
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rd.nextInt(); // storing random integers
                 // printing each array element
            }
            long startTime = System.nanoTime();
            Selection_sort(arr);
            long elapsedTime = System.nanoTime() - startTime;
            printArray(arr);
            System.out.println("the time taken for selection sort for array of length " + " " + Integer.toString(n)+ " is " + elapsedTime);//printing the time
            startTime = System.nanoTime();
            Selection_sort(arr);

            elapsedTime = System.nanoTime() - startTime;
            printArray(arr);
            System.out.println("the time taken for selection sort for array of length " + " " + Integer.toString(n)+ " is " + elapsedTime);//printing the time
            startTime = System.nanoTime();
            Insertion_sort(arr);
            elapsedTime = System.nanoTime() - startTime;
            printArray(arr);
            System.out.println("the time taken for insertion sort for array of length " + " " + Integer.toString(n)+ " is " + elapsedTime);//printing the time
            startTime = System.nanoTime();
            bogoSort(arr);
            elapsedTime = System.nanoTime() - startTime;
            printArray(arr);
            System.out.println("the time taken for bogo sort for array of length " + " " + Integer.toString(n)+ " is " + elapsedTime);//printing the time
            n=n*10;



        }
    }}



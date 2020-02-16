class fibonacci //start of the class
{
    static int fib(int n) //function calculates the fibonacci sum upto n using recursion
    {
        if (n <= 1) //base case
            return n;//returns  n

        return fib(n-1) + fib(n-2); //recursive case
    }
    //function calculates the fibonacci sum upto n using iteration
    static int fibonacciIterative(int n){
        if (n<=1)
            return 1;

        int fib = 1;
        int prevFib =  1;
        //runs a loop less than n
        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;//adds the result
            prevFib = temp;//swaps
        }
        return fib;//returns the result
    }

    //main method
    public static void main (String args[])
    {
        long startTime = System.nanoTime();
        System.out.println("answer for fiborecursive " +fib(29));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for fiborecursive " +fib(29));//recursive fibonacci for 29
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for fiboiterative " +fibonacciIterative(29));//iterative fibonacci for 29
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for fiboiterative " +fibonacciIterative(6));//iterative fibonacci for 6
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for fiborecursive " +fib(6));//recursive fibonacci for 29
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
    }
} //end of the code

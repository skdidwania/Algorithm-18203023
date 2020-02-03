public class RussianPeasant{
    static int RussianMultiply(int num1, int num2)//the function to calculate the multiplication
    {

        int result = 0;//stores the output
        /*algorithm is followed as mentioned in the google doc*/
        while (num2 > 0)
        {
            if (num2 % 2 !=0)
                result = result + num1;//adds to the result

            num1 = num1*2;//doubles itself
            num2= num2/2 ;//divided by 2
        }
        return result;//returns the result
    }
    //main function
    public static void main(String[] args) {
        /*timing code*/
        long startTime = System.nanoTime();
        System.out.println("answer for 1x1 " +RussianMultiply(1,1));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for 1x1 " +RussianMultiply(1,1));//1*1 time record
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for 4x5 " +RussianMultiply(4,5));//4*5 time record
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for 23 x 34 " +RussianMultiply(23,34));//23*34 time record
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for 300 x 384 " +RussianMultiply(300,384));//300*384 time record
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);
        startTime = System.nanoTime();
        System.out.println("answer for 1833x 1333 " +RussianMultiply(1833,1333));//1833*1333 time record
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + elapsedTime);

    }
}//end of the code
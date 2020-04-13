//did this question at a google interview
public class RLE //class starts
{
    public static void RunLE(String text)
    {
        int l=text.length();
        for (int i = 0; i<l;i++)//runs the loop
        {
            int count = 1;//initializes count to 1
            //loop to traverse through the string and and count the same number of occurences
            while (i<text.length()-1 && text.charAt(i)==text.charAt(i+1))
            {
             i+=1;//increments by 1
             count+=1;//increments by 1
            }
            System.out.print(text.charAt(i));//prints the character
            System.out.print(count);//prints it count
        }
    }
    //main method
    public static void main(String[] args)
    {
        String str = "aaaksksxxxxywww";
        RunLE(str);//passes the string to the function and prints the output
    }
}//end of the code

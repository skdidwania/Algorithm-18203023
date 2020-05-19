import java.nio.file.Files;
import java.util.ArrayList;
import java.nio.file.Paths;
//references taken from geeksforgeeks and the algorithm provided by the professor
public class Stringsearch  //start of the class
{

    public static ArrayList<Integer> search(String txt, String pat) //brute force search function
    {

        ArrayList<Integer> gfg = new ArrayList<>();//arraylist is declared
        int M = pat.length();
        int N = txt.length();
        //looping
        for (int i=0;i <= N-M;i++)
        {
           int j;

            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))   //verifies the equality
                    break;//breaks if its not the same

            if (j == M)
            {
                gfg.add(i);//adds the position to the arraylist gfg
                }


        }
        return gfg;//returns the array list
    }
    static  ArrayList<Integer>  KMPSearch(String pat, String txt)  //Knuthh search
    {
        ArrayList<Integer> gfg = new ArrayList<>();//arraylist is declared

        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;
        computeLPSArray(pat, M, lps);
        int i = 0;
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                gfg.add(i-j);//adds the position to the arraylist gfg
                j = lps[j - 1];
            }


            else if (i < N && pat.charAt(j) != txt.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;//increments i
            }
        }
        return gfg;//returns the arraylist
    }
   //reference from geeksforgeeks and the algorithm provided by the professor
    static void computeLPSArray(String pat, int M, int lps[])
    {

        int length = 0;
        int i = 1;
        lps[0] = 0;
        while (i<M)
        {
            if (pat.charAt(i) == pat.charAt(length))//if it matches
            {
                length++;
                lps[i] = length;
                i++;// i is incremented
            }
            else
            {
                if (length != 0)
                {
                    length = lps[length - 1];


                }
                else
                {
                    lps[i] = length;
                    i++; // i is incremented
                }
            }
        }
    }
    public static void PrintArray( ArrayList<Integer> arr) { //prints the arraylist
        for (int i = 0; i < arr.size();i++)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception
    {
        //testing framework consisting of 3 test files and substring search through them
        //reading all the 3 test files: test1,test2,test3
        String txt = readFile("C:\\Users\\Krishna\\Desktop\\test1.txt");
        String txt1=readFile("C:\\Users\\Krishna\\Desktop\\test2.txt");
        String txt2=readFile("C:\\Users\\Krishna\\Desktop\\test3.txt");
        String pat = "ABA";
        long startTime = System.nanoTime();
        search(txt.toUpperCase(),pat);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Using bruteforce");       //bruteforce

        System.out.println("Time taken: " + estimatedTime + "\n");
        PrintArray(  search(txt.toUpperCase(),pat));

        startTime = System.nanoTime();

        KMPSearch(pat,txt.toUpperCase());
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Using Knutt");    //using knuth algorithm

        System.out.println("Time taken: " + estimatedTime + "\n");
        PrintArray( KMPSearch(pat,txt.toUpperCase()));
        startTime = System.nanoTime();

        search(txt1.toUpperCase(),pat);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Using bruteforce");

        System.out.println("Time taken: " + estimatedTime + "\n");
        PrintArray( search(txt1.toUpperCase(),pat));
        startTime = System.nanoTime();

        KMPSearch(pat,txt1.toUpperCase());
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Using Knutt");

        System.out.println("Time taken: " + estimatedTime + "\n");
        PrintArray( KMPSearch(pat,txt1.toUpperCase()));
        startTime = System.nanoTime();

        search(txt2.toUpperCase(),pat);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Using bruteforce");

        System.out.println("Time taken: " + estimatedTime + "\n");
        PrintArray( search(txt2.toUpperCase(),pat));
        startTime = System.nanoTime();

        KMPSearch(pat,txt2.toUpperCase());
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Using Knutt");

        System.out.println("Time taken: " + estimatedTime + "\n");
        PrintArray( KMPSearch(pat,txt2.toUpperCase()));

    }
     //function for returning the data from the file
    public static String readFile(String fileName)throws Exception {
        String data = "";//data storage variable
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;//returns the data
    }



    }



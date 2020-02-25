public class ToweofHanoi// code starts
{
      static void towerOfHanoi(int n, char source, char destination, char auxillary)
        {
            //recursion is used
            if (n == 1)
            {
                /*base case if the number of rods are 1*/
                System.out.println("Move disk 1 from rod " +  source + " to rod " + destination);//prints the instruction
                return;//returns
            }
            //when it is not the base case
            towerOfHanoi(n-1,source, auxillary ,destination);
            System.out.println("Move disk " + n + " from rod " +  source + " to rod " + destination);
            towerOfHanoi(n-1, auxillary,destination,source);
        }
          //main method
        public static void main(String args[])
        {  //number of discs is provided and the function is called to display the output
            int n = 4;
            towerOfHanoi(n, 'A', 'C', 'B');//A B C are name of the rods given
        }
    }
    //end of the code

public class Trie {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    static TrieNode root;
   //inserts the key in the tree
    //kind of the concept used in the linkedlist
    //some concept referred to geeksforgeeks
    static void insert(String key)
    {
        int l;
        TrieNode p = root;
        for (l= 0;l<key.length();l++)
        {
            if (p.children[key.charAt(l) - 'a'] == null)
            {
                p.children[key.charAt(l) - 'a'] = new TrieNode();//creating a new node
            }
            p = p.children[key.charAt(l) - 'a'];
        }
       p.isEndOfWord = true;//marking the leaf node
    }

   //searches for the key
    static boolean search(String key)
    {
        int l;
        TrieNode p = root;
        for (l = 0;l<key.length(); l++)
        {
            if (p.children[key.charAt(l) - 'a'] == null)
            {
                return false;
            }

            p = p.children[key.charAt(l) - 'a'];
        }

        if(p != null && p.isEndOfWord)
        {
            return true;//returns true if the key is found
         }
        else
        {
            return false;//returns false if the key is not found
        }
    }
    //end of the code

   //Driver code
    public static void main(String args[])
    {
        //keys array
        String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt",
                "silver"};
        //output array
        String output[] = {"not present in trie", "present in trie"};
        root = new TrieNode();

        int i;
        for (i = 0; i < keys.length ; i++) {
            insert(keys[i]);//creation of the tree
        }
        // Search for different keys in the trie
        if(search("bank")) { //search for bank
            System.out.println("bank is " + output[1]);
        }
        else
        {
            System.out.println("bank is " + output[0]);
        }

        if(search("jog")) {//search for jog
            System.out.println("jog is " + output[1]);
        }
        else
        {
            System.out.println("jog is " + output[0]);
        }

        if(search("bar")) { //search for bar
            System.out.println("bar is " + output[1]);
        }
        else
        {
            System.out.println("bar is " + output[0]);
        }

        if(search("thing")) { //search for thing
            System.out.println("thing is " + output[1]);
        }
        else
        {
            System.out.println("thing is " + output[0]);
        }

    }
}
//end of the code
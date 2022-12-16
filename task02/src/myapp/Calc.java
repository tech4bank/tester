package myapp;

import java.util.Scanner;

public class Calc {

    // Sir, pls give me a break, already tried so hard...

    public static void main(String[] args) throws Exception{

        // say Hi
        System.out.println("Welcome.");
        
        // previous calc value ("double" for decimal & accuracy)
        double $last = 0.00;


        Scanner scanRead = new Scanner(System.in);
        

        while (true) {

                                    
            System.out.print("> "); // the prompt

            String input = scanRead.nextLine(); // user line-of-input

            if (input.equals("exit")) {
                System.out.println("Bye bye");
                break;
            } // check if exit 

            // line => string array (space in-between)
            String[] manyAtom = input.split(" ");

            // check each element-AKA-atom to see what it is 
            for (int i = 0; i < manyAtom.length; i+=1) {
                String atom = manyAtom[i];

                                   
                if (atom.equals("+")) {
                    $last += Double.parseDouble(manyAtom[i + 1]); // add on to ($last) the atom after +
                } else if (atom.equals("-")) {
                    $last -= Double.parseDouble(manyAtom[i + 1]); // minus from ($last) the atom after -
                } else if (atom.equals("*")) {
                    $last *= Double.parseDouble(manyAtom[i + 1]); // multiply last ($last) the atom after *
                } else if (atom.equals("/")) {
                    $last /= Double.parseDouble(manyAtom[i + 1]); // divide previous ($last) the atom after /
                } else if (atom.equals("$last")) {
                    $last = $last;
                // i == 0; used to keep $last from reseting itself -_-
                } else if (i == 0) {
                    $last = Double.parseDouble(atom);
                }  // if the element isn't <<+-*/>> or $last, then it is number or $last

            }


        // prints-AKA-returns last value of ($last)
        System.out.println($last);  


    }
}
}



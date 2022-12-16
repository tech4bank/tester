package myapp;

import java.io.*;
import java.util.regex.*;

public class Prog {

    // Sir, pls give me a break, already tried so hard...
    // sample run command on next line (copy & paste)
    // java -cp classes myapp.Prog C:\Users\bios4uart\exam\task01\src\myapp\thankyou.csv C:\Users\bios4uart\exam\task01\src\myapp\thankyou.txt C:\Users\bios4uart\exam\task01\src\myapp\thankoutput.txt

    public static void main(String[] args) throws Exception {
        // read CSV-file
        BufferedReader csvRead = new BufferedReader(new FileReader(args[0]));

        // read template-file
        BufferedReader tempRead = new BufferedReader(new FileReader(args[1]));

        // prep output-file
        PrintWriter writeOut = new PrintWriter(args[2]);

        // input line-by-line
        String csvLine;
        while ((csvLine = csvRead.readLine()) != null) {
            // split-line => string-array (split by both , and \n)
            String[] csvWords = csvLine.split("[, ]|\\n");

            // analyze template-file line-by-line (end of file = null)
            String tempLine;
            while ((tempLine = tempRead.readLine()) != null) {

                // replace <<ABC>> with elements of string-array 
                String outputLine = tempLine;
                Pattern patternA = Pattern.compile("<<(\\w+)>>");
                Matcher matcherA = patternA.matcher(tempLine);
                // find the Pattern, then Match upon, while true
                while (matcherA.find()) {
                    String replaceMents = matcherA.group(1);

                    //System.out.printf("\n %s \n", replaceMents);
                    //int position = outputLine.indexOf(replaceMents);
                    // int indexReplace =  Integer.valueOf(replaceMents);

                    int i = 0;
                    outputLine = outputLine.replaceAll("<<" + replaceMents + ">>", csvWords[i]);
                    i+=1;

                } // I think there is an issue with getting an Integer from "replaceMents" cos it is a string
                


                // write modded line to output-file
                writeOut.println(outputLine);
            }

            // reopen template-file to cancel any changes
            tempRead.close();
            tempRead = new BufferedReader(new FileReader(args[1]));
        }

        // close all
        csvRead.close();
        tempRead.close();
        writeOut.close();
    }
    
}

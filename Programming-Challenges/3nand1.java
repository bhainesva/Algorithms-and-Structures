/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
                                          // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{
    public void run(){
        	// Your program here
        String line;
        line = Main.ReadLn(50);
        while (!line.equals("")) {
            String[] split = line.trim().split("\\s+");
            int max = 0;
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);

            int lower = Math.min(i, j);
            int upper = Math.max(i, j);
            for (int n = lower; n <= upper; n++) {
                int collatzNum = collatz(n);
                if (collatzNum > max) {
                    max = collatzNum;
                }
            }
            System.out.println(i + " " + j + " " + max);
            line = Main.ReadLn(50);
        }
    }
    
    public int collatz(int x) {
        int count = 1;
        if (x == 1) {
            return count;
        }
        while (x != 1) {
            count++;
            if (x%2 == 0) {
                x = x/2;
            }
            else {
                x = 3*x + 1;
            }
        }
        return count;
    }
    // You can insert more classes here if you want.
}

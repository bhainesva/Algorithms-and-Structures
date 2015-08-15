/*
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
        line = Main.ReadLn(200);
        String[] split = line.trim().split("\\s+");
        boolean firsttime = true;
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int field = 1;
        while (!(n==0 && m==0)) {
            String board[][] = new String[n][m];

            for (int y = 0; y < n; y++) {
                line = Main.ReadLn(2*m).trim();
                String linesplit[] = line.split("(?!^)");
                for (int i = 0; i< m; i++) {
                        board[y][i] = linesplit[i];
                }
            }

            int hints[][] = check(board);
            if (!firsttime) {
                System.out.print("\n");
            }
            else {
                firsttime = false;
            }
            System.out.println("Field #" + field + ":");
            for(int[] x: hints) {
                for (int y: x) {
                    if (y==-1) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(y);
                    }
                }
                System.out.print("\n");
            }
            field++;
            line = Main.ReadLn(200);
            split = line.trim().split("\\s+");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);
        }
    }

    public int[][] check(String[][] board) {
        int hints[][] = new int[board.length][board[0].length];
        int ylen = board.length;
        int xlen = board[0].length;
        for (int x=0; x<xlen; x++) {
            for (int y=0; y<ylen; y++) {
                int count = 0;
                if (board[y][x].equals("*")) {
                    count = -1;
                }
                else {
                    for(int xd=-1;xd<=1;xd++) {
                        for(int yd=-1;yd<=1;yd++) {
                            if (x + xd >= 0 && x + xd < xlen && y + yd >= 0 && y + yd < ylen) {
                                if (board[y+yd][x+xd].equals("*")) {
                                    count++;
                                }
                            }
                        }
                    }
                }
                hints[y][x] = count;
            }
        }

        return hints;
    }

    
    // You can insert more classes here if you want.
}


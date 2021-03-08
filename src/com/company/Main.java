package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
     * Click `Run` to execute the snippet below!

    Smart TV Virtual keyboard
    Remote: directional keys (up, down, left, right), centre select button

    Layout of our on-screen keyboard:
    a  b  c  d  e  f  g  h  i
    j  k  l  m  n  o  p  q  r
    s  t  u  v  w  x  y  z  DONE

    Rules:
    Our cursor is controlled by 5 input buttons: left, right, up, down, and select.
    The keyboard loads with the cursor at the ‘a’ character.
    The cursor can only move horizontally or vertically, not diagonally.
    To finalize the input text and dismiss the keyboard, we must select the DONE key at the end.

    Objective: how many button presses does it take to input a given word?

    "cat"
    a->c: right, right, select, 3 presses
    c->a: left, left, select, 3 presses
    a->t: down, down, right, select, 4 presses
    t->DONE: right x7, select, 8 presses
    f("cat") = 18 = 3+3+4+8

    a -> c => (0,0) -> (0,2) 0 vertical, 2 horizontal => 2
    a -> a => (0,0) -> (0,0) 0 vertical, 0 horizontal => 0
    a -> t => (0,0) -> (2,1) 2 vertical, 1 horizontal => 3

    distance between (x1, y1) -> (x2, y2):
    = abs(x2 - x1) + abs(y2 - y1)

    calculate distance between 'a' and 't'
    knowing a = (0,0), t = (2,1)
    */

    private static String[][] letterCoordinates = new String[3][9];

    public static void createCollection(String alphabet) {

        // parse alphabet string to store each letter and its coordinate
        String[] letters = alphabet.split(",");

        int index = 0;

        for (int y = 0; y <= 2; y++) {
            for (int x = 0; x <= 8; x++) {
                letterCoordinates[y][x] = letters[index];
                index++;
            }
        }
    }

    public static int getCoordinates(String word) {
        String[] phrase = word.split("");
        List<Integer> coordinates = new ArrayList<>();

        for (String letter : phrase) {
            for (int y = 0; y <= 2; y++) {
                for (int x = 0; x <= 8; x++) {
                    if (letter.equals(letterCoordinates[y][x])) {
                        coordinates.add(x);
                        coordinates.add(y);
                    }
                }
            }
        }

        return distance_between_two_points(coordinates);
    }

    public static int distance_between_two_points(List coordinates) {

        int sum = 0;

        for(int value = 0;  value <= coordinates.size()-1; value++){
            sum = sum + (int) coordinates.get(value);
        }

        return sum;
    }

    public static void main(String[] args) {
        String alphabet = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,DONE";
        createCollection(alphabet);

       System.out.println(getCoordinates("miriam"));
    }
}
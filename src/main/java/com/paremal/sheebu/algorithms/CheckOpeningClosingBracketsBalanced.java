package com.paremal.sheebu.algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * This class provides functionality to check if the opening and closing brackets in a string are balanced.
 */
public class CheckOpeningClosingBracketsBalanced {
    private static final Set<Character> OPENING_SET = Set.of('(', '{', '[');
    private static final Set<Character> CLOSING_SET = Set.of(')', '}', ']');
    private static final Map<Character, Character> OPENING_CLOSING = Map.of('(', ')', '{', '}', '[', ']');



    /**
     * Main method to read input from the user and check if brackets are balanced for each input line.
     */
    public static void main(String[] argh) {

        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int nolines,readcout=0;
        try {
            nolines=Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(readcout<nolines){


            try {
                boolean result=checkBalancedWithStack(reader.readLine().trim());
                System.out.println(result);
                readcout++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    /**
     * Method for checking if brackets are balanced in a string.
     *
     * Iterates through the string for each character.
     * When a closing bracket is encountered, pops the previous opening bracket from the stack
     * and checks if the opening and closing brackets match.
     *
     * @param line the input string containing brackets
     * @return true if the brackets are balanced, false otherwise
     */
    static boolean checkBalancedWithStack(String line) {




        Stack<Character> openingValueStack = new Stack<>(line.length());
        for (char ch : line.toCharArray()) {
            // If the character is an opening bracket '([{', push it to the stack
            if (OPENING_SET.contains(ch)) {
                openingValueStack.push(ch);
            }
            // If the character is a closing bracket ')]}', get the previous opening bracket from the stack
            // and check if it matches the expected closing bracket from the map
            else if (CLOSING_SET.contains(ch)) {
               if(openingValueStack.isEmpty()|| !OPENING_CLOSING.get(openingValueStack.pop()).equals(ch)) return false;
            }
        }
        /* After processing the entire string, if all values in the openingValueStack have been processed,
        then the string's brackets are balanced. */
        return openingValueStack.isEmpty();
    }
    

    /**
     * Custom stack implementation.
     *
     * @param <E> the type of elements in the stack
     */
    static class Stack<E> {
        E[] arr;
        int top = -1;

        public Stack(int capacity) {
            arr = (E[]) new Object[capacity];
        }

        /**
         * Returns the size of the stack array.
         *
         * @return the capacity of the stack
         */
        int size() {
            return arr.length;
        }

        /**
         * Pushes an element onto the stack.
         *
         * @param str the element to push
         */
        void push(E str) {
            arr[++top] = str;
        }

        /**
         * Pops an element from the stack.
         *
         * @return the popped element
         */
        E pop() {
            return arr[top--];
        }

        /**
         * Checks if the stack is empty.
         *
         * @return true if the stack is empty, false otherwise
         */
        boolean isEmpty() {
            return top == -1;
        }
    }
}

package com.paremal.sheebu.algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckOpeningClosingBracketsBalanced {


    public static void main(String[] argh) {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nolines = 0, readcout = 0;
        try {
            System.out.println("Enter No of inputs:");
            nolines = Integer.valueOf(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (readcout < nolines) {


            try {
                boolean result = checkBalancedWithStack(reader.readLine().trim());
                System.out.println(result);
                readcout++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    /*
    Method for checking parenthesis are balanced in a String

    Iterate through String for each letter
    when closing encountered then pop previous opening braces from stack
    then check opening and closing belong to same type

     */
    static boolean checkBalancedWithStack(String line) {
        List<String> inputs = Stream.of(line.trim().split("")).collect(Collectors.toList());
        List<String> openingList = List.of("(", "{", "[");
        List<String> closingList = List.of(")", "}", "]");

        // map for getting closing parenthesis using opening parenthesis
        Map<String, String> openingClosing = new HashMap<>();
        openingClosing.put("(", ")");
        openingClosing.put("{", "}");
        openingClosing.put("[", "]");

        Stack<String> openingValueStack = new Stack<>(inputs.size());
        for (String ch : inputs) {
            // if letter is opening ([{ pushed to stack
            if (openingList.contains(ch)) {
                openingValueStack.push(ch);
            }
            //if letter is closing ")]}" get previous opening parenthesis from stack
            // and get the matching closing parenthesis from map check it is correct
            else if (closingList.contains(ch)) {
                if (!openingValueStack.isEmpty()) {
                    String Closing = openingClosing.get(openingValueStack.pop());
                    if (!ch.equals(Closing)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }


        }
        if (!openingValueStack.isEmpty()) return false;
         /*
        loop for processing string completed and all the values in openingvaluestack is processed
        then the string parenthesis are balanced
         */
        return true;
    }


    static class Stack<E> {
        E[] arr;
        int top = -1;

        public Stack(int capacity) {
            arr = (E[]) new Object[capacity];
        }

        int size() {
            return arr.length;
        }

        void push(E str) {
            arr[++top] = str;
        }

        E pop() {
            return arr[top--];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }
}




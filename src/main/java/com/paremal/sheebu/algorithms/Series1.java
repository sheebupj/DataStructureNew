package com.paremal.sheebu.algorithms;

import java.util.Scanner;

/**
 * 
 * @author Sheebu
 * 
 * We use the integers a, b,n and to create the following series:
 *( a+2 raise 2*b)( a+  2 raise 0 2*b+ 2 raise 1 2*b) up n
You are given queries in the form of , , and . For each query, print the series corresponding to the
given , , and values as a single line of space-separated integers.
Input Format
The first line contains an integer, , denoting the number of queries.
Each line of the subsequent lines contains three space-separated integers describing the respective
, , and values for that query.
Constraints
Output Format
For each query, print the corresponding series on a new line. Each series must be printed in order as a
single line of space-separated integers.
Sample Input
2
0 2 10
5 3 5
Sample Output
2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98
Explanation
We have two queries:
1. We use , , and to produce some series :
... and so on.
Once we hit , we print the first ten terms as a single line of space-separated integers.
2. We use , , and to produce
 *
 */

public class Series1 {
	

	
	    public void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        int t=in.nextInt();
	        int [] a= new int[t];
	        int [] b= new int[t];
	        int [] n= new int[t];
	         int[][] result= new int[t][];
	        for(int i=0;i<t;i++){
	             a [i]= in.nextInt();
	             b [i]= in.nextInt();
	             n [i]= in.nextInt();
	             result[i]=getSeries(a[i],b[i],n[i]);
	        }
	        printResult(result);
	       
	        in.close();
	    }
	    static int[] getSeries(int a, int b, int n){
	        int []rslt= new int[n];
	        
	        int t=1;
	        int num=a+t*b;
	        rslt[0]=num;
	        for(int i=1;i<n;i++){
	         t*=2;
	        num+=t*b;
	        rslt[i]=num;
	        }
	         return rslt;
	    }
	    static void printResult(int[][] re){
	        for(int i=0;i<re.length;i++){
	            for(int j=0;j<re[i].length;j++){
	                System.out.printf("%d ",re[i][j]);
	            }
	            System.out.println();
	        }
	    }
	   
	}




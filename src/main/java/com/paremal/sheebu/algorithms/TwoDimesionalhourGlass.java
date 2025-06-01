package com.paremal.sheebu.algorithms;

import java.util.Scanner;

/*
 * iterate through two dimensional array for possible 3x3 arrays for max valued hour glass
 * from 6X6 2 D Array
 * 
 * 	in following 2 dimensional array
 * 1 2 3							1 2 3
 * 4 5 6   hour glass will become 	  5       sum is 35 
 * 7 8 9							7 8 9 
 * 1
 */


public class TwoDimesionalhourGlass {
	
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        String[] s1= new String[3];
        int[] x= new int[3];
        for(int i=0;i<1;i++)
        {
             s1[i]=sc.next();
             x[i]=sc.nextInt();
            //Complete this line
        }
        System.out.println(s1[0]+" "+x[0]);
        // Write your code here.

       
		/*
		 * initializing 6x6 two dimensional array
		 */
		int[][] arrNos= {
				{9,9,9,5,9,4},
				{9,5,9,7,9,3},
				{7,8,9,2,9,1},
				{1,2,3,5,9,6},
				{7,8,9,2,9,5},
				{7,8,9,2,9,5}
				};
		int sum=calculateMaxHourGlass(arrNos);
		System.out.println(" max of sum:"+sum);
	}
	
/*
 * iterate through two dimensional array for possible 3x3 arrays for max valued hour glass
 * 
 * 	in following 2 dimensional array
 * 1 2 3							1 2 3
 * 4 5 6   hour glass will become 	  5       sum is 35
 * 7 8 9							7 8 9
 * 
 * 1
 */
public static int calculateMaxHourGlass(int[][] sample) {
		
		
		int max=0;
		for(int x=0;x<sample[0].length-2;x++) {
			for(int y=0;y<sample.length-2;y++) {
				int[] leftTop= {x,y};
				int tmax=getHourglassMaxValue(leftTop, sample);
				if(tmax>max){
					max= tmax;
				}
			}
		}
		return max;
		
	}

	/*
	 * get value of hour glass inputting left top location index
	 */
	static int getHourglassMaxValue(int[] leftTop, int[][] arr) {
		
		int x= leftTop[0];
		int y=leftTop[1];
		int sum=0;
		for(int i=y;i<y+3;i++) {
			for(int j=x;j<x+3;j++) {
				//System.out.println(j+" "+i);
				System.out.printf("%d ",arr[i][j]);
				if (i==y+1 && j==x) continue;
				if (i==y+1 && j==x+2) continue;
				sum+=arr[i][j];
			}
		}
		System.out.println("sum:"+sum);
		return sum;
	}

}

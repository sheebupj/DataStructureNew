package com.paremal.sheebu.algorithms;

public class BubbleSort {
	
	int[] bubblesort(int[] arrNumber) {
		int l=arrNumber.length;
		for(int i=0;i< l-1;i++) {
			
			for(int j=0;j<l-i-1;j++) {
				
				if(arrNumber[j]>arrNumber[j+1]) {
					int temp=arrNumber[j];
					arrNumber[j]=arrNumber[j+1];
					arrNumber[j+1]=temp;
				
				}
				
			}
		}
		return arrNumber;
		
	}
	
	public static void main(String[] args) {
		int[] arrNumber= {10,9,8,7,6,5,4,3,2,1,0};
		int[] sortedNums=new BubbleSort().bubblesort(arrNumber);
		for(int n:sortedNums) {
			System.out.printf("%d  ",n);
		}
	}

}

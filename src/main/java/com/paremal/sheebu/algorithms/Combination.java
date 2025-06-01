package com.paremal.sheebu.algorithms;

class Combination { 
	  
    
    static void combiUtl(int arr[], int data[], int start, 
                                int end, int index, int r,int k) 
    { 
        // Current combination is ready to be printed, print it 
        if (index == r) 
        { 
         
        	if(sum(data)<k)
        	     display(data,r);
            return; 
        } 
        
  
        
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            combiUtl(arr, data, i+1, end, index+1, r,k); 
        } 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombi(int arr[], int n, int r,int k) 
    { 
        // A temporary array to store all combination one by one 
        int data[]=new int[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combiUtl(arr, data, 0, n-1, 0, r, k); 
    } 
    
    static int sum(int n[]) {
    	int sum=0;
    	for (int i=0;i<n.length;i++) {
    		sum+=n[i];
    	}
    	return sum;
    }
    static void display(int[] data,int r) {
    	for (int j=0; j<r; j++) 
            System.out.print(data[j]+" "); 
        System.out.println(""); 
    }
  
    /* function to check for above function*/
    public static void main (String[] args) { 
        int arr[] = {2, 4, 1, 5, 6,3,7,8}; 
        int k=100;
        int r = 7; 
        int n = arr.length; 
        printCombi(arr, n, r,k); 
    } 
    
}
  

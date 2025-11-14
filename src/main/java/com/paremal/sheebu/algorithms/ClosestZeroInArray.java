package com.paremal.sheebu.algorithms;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

public class ClosestZeroInArray {
    public static void main(String[] args) {
        int[] data = {2, 3, -2, 4, -5,-1,1};
        int[] result=findClosestToZero(data);
        System.out.println("Closest number to zero: " +result[0]+ " :" +result[1]);
    }
    /*
    An Array of integers is given, both +ve and -ve.
    To find the two elements such that their
     sum is closest to zero.
     */
    public static int[] findClosestToZero(int[] numbers) {
        int[] cz= new int[2];
        cz[0]=abs(numbers[0]);
        cz[1]=abs(numbers[1]);
        int cn=cz[0]+cz[1];

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                //math.abs() is used to get closest to 0 since we are checking lowest no  which include negetives
                if(cn>abs(numbers[i])+abs(numbers[j])){
                    cz[0]=numbers[i];
                    cz[1]=numbers[j];
                    cn=abs(cz[0])+abs(cz[1]);
                }
            }

        }


        return cz;
    }
    /*
  An Array of integers is given, both +ve and -ve.
  To find the two elements such that their
   sum is closest to zero Using Stream api.
   */
    public static int[] findClosestToZeroUsingStreamApi(int[] numbers) {
        int[] cz= new int[2];
        cz[0]=abs(numbers[0]);
        cz[1]=abs(numbers[1]);
        AtomicInteger cn= new AtomicInteger(cz[0] + cz[1]);
        int size=numbers.length;
        IntStream.iterate(0, i->i<size, i->i=i+1)
                .forEach(i->{
                    IntStream.iterate( i+1,j-> j<size,j-> j=j+1)
                            .forEach(j-> {
                                if(cn.get() >abs(numbers[i])+abs(numbers[j])){
                                    cz[0]=numbers[i];
                                    cz[1]=numbers[j];
                                    cn.set(abs(cz[0]) + abs(cz[1]));
                                }
                            });
                });
        return cz;
    }

}

package com.paremal.sheebu.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Rotating and flipping image
rows and columns must be equal
image inputs are in  List of List Integers

1 2 3
4 5 6
7 8 9
after rotating clockwise 90 degree
7 4 1
8 5 2
9 6 3

1 2 3
4 5 6
7 8 9
After rotating anti-clockwise 90 degree
3 6 9
2 5 8
1 4 7

1 2 3
4 5 6
7 8 9
after flipping horizontally
3 2 1
6 5 4
9 8 7


1 2 3
4 5 6
7 8 9
after flipping  vertically
7 8 9
4 5 6
1 2 3





/*
functional interface for doing rotating operations and flip operations using array
 */
@FunctionalInterface
interface Operation {
    Integer[][] doOp(Integer[][] doOp);
}
//functional interface of flip rotate operations without intermediate array object
@FunctionalInterface
interface OperationList {
    List<List<Integer>> doOp(List<List<Integer>> doOp);
}

public class FlipRotate {

    public static void main(String[] args) {




        /* clock wise rotating  operation using 2d Array */
        Operation clockwise = twoD -> {
            int size = twoD.length;
            int indexSize = size - 1;
            Integer[][] resultArr2d = new Integer[size][size];
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++) {
                    resultArr2d[j][indexSize - i] = twoD[i][j];

                }
            }
            return resultArr2d;
        };
        /* anti-clock wise rotating  operation using 2d Array */
        Operation antClockwise = twoD -> {
            int size = twoD.length;
            int indexSize = size - 1;
            Integer[][] resultArr2d = new Integer[size][size];
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++) {
                    resultArr2d[indexSize - j][i] = twoD[i][j];

                }
            }
            return resultArr2d;
        };

        /* flip horizontal  operation using 2d Array */
        Operation flipHorzontal = twoD -> {
            int size = twoD.length;
            int indexSize = size - 1;
            Integer[][] resultArr2d = new Integer[size][size];
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++) {
                    resultArr2d[i][indexSize - j] = twoD[i][j];

                }
            }
            return resultArr2d;
        };

        /* flip vertical  operation using 2d Array */
        Operation flipVertical = twoD -> {
            int size = twoD.length;
            int indexSize = size - 1;
            Integer[][] resultArr2d = new Integer[size][size];
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                System.arraycopy(twoD[i], 0, resultArr2d[indexSize - i], 0, size);
            }
            return resultArr2d;
        };
        //clock wise rotating  operation using 2d list
        OperationList clockwiseNew = twoD -> {
            int size = twoD.size();
            int indexSize = size - 1;
            List<List<Integer>> result2dList = new ArrayList<>();
            fill2dList(result2dList, size);
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++)
                    result2dList.get(j).set(indexSize - i, twoD.get(i).get(j));
            }
            return result2dList;
        };
        // anti-clock wise rotating  operation using 2d list
        OperationList antClockwiseNew = twoD -> {
            int size = twoD.size();
            int indexSize = size - 1;
            List<List<Integer>> result2dList = new ArrayList<>();
            fill2dList(result2dList, size);
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++) {
                    result2dList.get(indexSize - j).set(i, twoD.get(i).get(j));
                }
            }
            return result2dList;
        };


        /*  flip horizontal operation using 2d list*/
            OperationList flipHorzontalnew = twoD -> {
            int size = twoD.size();
            int indexSize = size - 1;
            List<List<Integer>> result2dList = new ArrayList<>();
            fill2dList(result2dList, size);
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++)
                    result2dList.get(i).set(indexSize - j, twoD.get(i).get(j));
            }
            return result2dList;
        };

        /*  flip vertical operation using 2d list*/
        OperationList flipVerticalNew = twoD -> {
            int size = twoD.size();
            int indexSize = size - 1;
            List<List<Integer>> result2dList = new ArrayList<>();
            fill2dList(result2dList, size);
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++)
                    result2dList.get(indexSize - i).set(j, twoD.get(i).get(j));
            }
            return result2dList;
        };

        List<Integer> a = List.of(20, 21, 22, 23, 11);
        List<Integer> b = List.of(24, 25, 26, 27, 12);
        List<Integer> c = List.of(28, 29, 30, 31, 13);
        List<Integer> d = List.of(32, 33, 34, 35, 14);
        List<Integer> e = List.of(36, 37, 38, 39, 16);


        List<List<Integer>> llist = new ArrayList<>();
        llist.add(a);
        llist.add(b);
        llist.add(c);
        llist.add(d);
        llist.add(e);
        llist.forEach(System.out::println);


        Integer[][] IntArr2d = llist.stream().map(l -> l.toArray(Integer[]::new)).toArray(Integer[][]::new);

        displayArray(IntArr2d);


        List<List<Integer>> rlist = flipRotate(llist, clockwise);
        System.out.println("after rotating clockwise 90 degree");
        display(rlist);
        List<List<Integer>> rlist2 = flipRotate(rlist, clockwise);
        System.out.println("after rotating clockwise 90 degree");
        display(rlist2);
        List<List<Integer>> rlist3 = flipRotate(rlist2, clockwise);
        System.out.println("after rotating clockwise 90 degree");
        display(rlist3);
        List<List<Integer>> rlist4 = flipRotate(rlist3, clockwise);
        System.out.println("after rotating clockwise 90 degree");
        display(rlist4);
        List<List<Integer>> rlist5 = flipRotate(rlist4, antClockwise);
        System.out.println("After rotating anti-clockwise 90 degree");
        display(rlist5);
        List<List<Integer>> rlist5a = flipRotate(rlist5, clockwise);
        System.out.println("after rotating clockwise 90 degree");
        display(rlist5a);
        List<List<Integer>> rlist6 = flipRotate(rlist5a, flipHorzontal);
        System.out.println("after flipping horizontally");
        display(rlist6);
        List<List<Integer>> rlist6a = flipRotate(rlist6, flipHorzontal);
        System.out.println("after flipping horizontally");
        display(rlist6a);
        List<List<Integer>> rlist7 = flipRotate(rlist6a, flipVertical);
        System.out.println("after flipping  vertically");
        display(rlist7);
        List<List<Integer>> rlist7a = flipRotate(rlist7, flipVertical);
        System.out.println("after flipping  vertically");
        display(rlist7a);
        List<List<Integer>> rlist7b = clockwiseNew.doOp(rlist7a);
        System.out.println("after rotating clockwise new ");
        display(rlist7b);
        List<List<Integer>> rlist7c = antClockwiseNew.doOp(rlist7b);
        System.out.println("after rotating Anti-clockwise new ");
        display(rlist7c);
        List<List<Integer>> rlist7d = flipHorzontalnew.doOp(rlist7c);
        System.out.println("after flipping horizontal new ");
        display(rlist7d);
        List<List<Integer>> rlist7e = flipVerticalNew.doOp(rlist7d);
        System.out.println("after flipping vertical new ");
        display(rlist7e);


        List<List<Integer>> rlist7f =rotateClockWise(rlist7e);
        System.out.println("after rotating clockwise using intermediate array ");
        display(rlist7f);
        List<List<Integer>> rlist7g = rotateAntiClockWise(rlist7f);
        System.out.println("after rotating Anti-clockwise using intermediate array ");
        display(rlist7g);
        List<List<Integer>> rlist7h = horizondalFlip(rlist7g);
        System.out.println("after flipping horizontal using intermediate array ");
        display(rlist7h);
        List<List<Integer>> rlist7i = verticalFlip(rlist7h);
        System.out.println("after flipping vertical using intermediate array  ");
        display(rlist7i);
    }
    /*
1 2 3
4 5 6
7 8 9
after flipping vertical it becomes
7 8 9
4 5 6
1 2 3
 */
    static List<List<Integer>> verticalFlip(List<List<Integer>> inputList) {
        int size = inputList.size();
        Integer[][] arr2d = inputList.stream().map(l-> l.toArray(Integer[]::new)).toArray(Integer [][]::new);
        Integer[][] resultArr2d = new Integer[size][size];
        int indexsize = size - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resultArr2d[indexsize - i][j] = arr2d[i][j];
            }
        }

        return Arrays.stream(resultArr2d).map(Arrays::asList).collect(Collectors.toList());

    }


    /*
  1 2 3
  4 5 6
  7 8 9
  after flipping horizontal
  3 2 1
  6 5 4
  9 8 7
   */
    static List<List<Integer>> horizondalFlip(List<List<Integer>> inputList) {
        int size = inputList.size();
        Integer[][] arr2d = inputList.stream().map(l -> l.toArray(Integer[]::new)).toArray(Integer[][]::new);
        Integer[][] resultArr2d = new Integer[size][size];
        int indexsize = size - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resultArr2d[i][indexsize - j] = arr2d[i][j];
            }
        }

        return Arrays.stream(resultArr2d).map(Arrays::asList).collect(Collectors.toList());

    }

    /*
   1 2 3
   4 5 6
   7 8 9
   After rotating clockwise  it become
   7 4 1
   8 5 2
   9 6 3
  */
    static List<List<Integer>> rotateClockWise(List<List<Integer>> inputList) {
        int size = inputList.size();
        Integer[][] arr2d = inputList.stream().map(l -> l.toArray(Integer[]::new)).toArray(Integer[][]::new);
        Integer[][] resultArr2d = new Integer[size][size];
        int indexsize = size - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resultArr2d[j][indexsize - i] = arr2d[i][j];

            }
        }

        return Arrays.stream(resultArr2d).map(Arrays::asList).collect(Collectors.toList());

    }


    /*
   1 2 3
   4 5 6
   7 8 9
   After rotating anti-clockwise  it become
   3 6 9
   2 5 8
   1 4 7
    */
    static List<List<Integer>> rotateAntiClockWise(List<List<Integer>> inputList) {
        int size = inputList.size();
        Integer[][] arr2d = inputList.stream().map(l -> l.toArray(Integer[]::new)).toArray(Integer[][]::new);
        Integer[][] resultArr2d = new Integer[size][size];
        int indexsize = size - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                resultArr2d[indexsize - j][i] = arr2d[i][j];

            }
        }

        return Arrays.stream(resultArr2d).map(Arrays::asList).collect(Collectors.toList());

    }



    /*
        generic method that do all flip and rotating operations (rotate clockwise and anti-clockwise
        and flipping vertical and horizontal accepting functional interface 'operation' as parameter
     */
    static List<List<Integer>> flipRotate(List<List<Integer>> inputList, Operation operation) {
        //converting two-dimensional list to two-dimensional array
        Integer[][] arr2d = inputList.stream().map(l -> l.toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        Integer[][] resultArr2d = operation.doOp(arr2d);
        //convert two-dimensional array to two-dimensional list and return
        return Arrays.stream(resultArr2d).map(Arrays::asList).collect(Collectors.toList());
    }


    static void display(List<List<Integer>> inputList) {
        for (List<Integer> olist : inputList) {
            for (Integer igr : olist) {
                System.out.print(igr + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void displayArray(Integer[][] ar2d) {
        List<List<Integer>> inputList = Arrays.stream(ar2d).map(Arrays::asList).collect(Collectors.toList());
        display(inputList);
    }

    /*
    pre-fill two-dimensional arraylist with null
     */
    static void fill2dList(List<List<Integer>> arList, int size) {
        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) list.add(null);
            arList.add(list);
        }
    }
}





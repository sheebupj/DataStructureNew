package com.paremal.sheebu.algorithms;





import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.paremal.sheebu.algorithms.FlipRotate.fill2dList;

public class AlogorithmTest {


    @Test
    public void ReverseStringTesst() {
        ReverseString reverseString = new ReverseString();
        String numberString = "0123456789";
        String numberString1 = "012 345 6789";
        String reversed1 = reverseString.reverseWithoutInbuiltIn(numberString);
        Assertions.assertEquals("9876543210", reversed1);
        String reversed2 = reverseString.reverseWithoutInbuiltInUsingStreamApi(numberString);
        Assertions.assertEquals("9876543210", reversed2);
        String reversed3 = reverseString.reverseEachWords(numberString1);
        Assertions.assertEquals("210 543 9876 ", reversed3);
        String reversed4 = reverseString.reverseEachWordsInALine(numberString1);
        Assertions.assertEquals("210 543 9876 ", reversed4);

    }

    /*
    Given the array of strings. Each string contains two parts - Word and its count separated by comma(,):

    - Filter by word(1st part) length > 4

    - Sort by word count(2nd part) desc

    - Find 2nd highest word based on above sorted result

    Solve using Java Streams API

    String[] strArray = {"POINT,2342342", "POINTS,2341345", "OF,34534345", "VIEWS,2342342223423", "IS,432234", "QWERTY,234234222"};

    Output: QWERTY
     */

    @Test
    public void FilterSortTest() {
        FilterSort filterSort = new FilterSort();
        String[] strArray = {"POINT,2342342", "POINTS,2341345", "OF,34534345", "VIEWS,2342342223423", "IS,432234", "QWERTY,234234222"};
        String[] strArray1 = {"POINT,23423422234231", "POINTS,2341345", "OF,34534345", "VIEWS,2342342223423", "IS,432234", "QWERTY,234234222"};
        String actual = filterSort.filterBasedOn1partSortBased2part(strArray);
        String actual1 = filterSort.filterBasedOn1partSortBased2part(strArray1);
        Assertions.assertEquals("QWERTY", actual);
        Assertions.assertEquals("VIEWS", actual1);


        String[] strArray2 = {"POINT,2342342", "POINTS,2341345", "OF,34534345", "VIEWS,2342342223423", "IS,432234", "QWERTY,234234222"};
        String[] strArray3 = {"POINT,23423422234231", "POINTS,2341345", "OF,34534345", "VIEWS,2342342223423", "IS,432234", "QWERTY,234234222"};
        String actual2 = filterSort.filterBasedOn1partSortBased2part(strArray2);
        String actual3 = filterSort.filterBasedOn1partSortBased2part(strArray3);
        Assertions.assertEquals("QWERTY", actual2);
        Assertions.assertEquals("VIEWS", actual3);



    }

    @Test
    public void findClosestToZeroTest() {

        int[] data = {2, 3, -2, 4, -5, -1, 1};
        int[] result1 = ClosestZeroInArray.findClosestToZero(data);
        Assertions.assertArrayEquals(new int[]{-1, 1}, result1);
        int[] result2 = ClosestZeroInArray.findClosestToZeroUsingStreamApi(data);
        Assertions.assertArrayEquals(new int[]{-1, 1}, result2);
        int[] data1 = {2, 3, -2, 4, -5, -1, 1, 0};
        int[] result3 = ClosestZeroInArray.findClosestToZero(data1);
        Assertions.assertArrayEquals(new int[]{-1, 0}, result3);
        int[] result4 = ClosestZeroInArray.findClosestToZeroUsingStreamApi(data1);
        Assertions.assertArrayEquals(new int[]{-1, 0}, result4);
    }

    @Test
    public void testFindCharPosistions() {
        String str = "The graphic and.";
        List<Integer> expected = Arrays.asList(12);
        FindStringPositionsInSentence fInstance = new FindStringPositionsInSentence();
        List<Integer> actual = fInstance.findWordPositions(str, "and");
        String str1 = "The graphic and and andand";
        List<Integer> expected1 = Arrays.asList(12, 16, 20, 23);
        List<Integer> actual1 = fInstance.findWordPositions(str1, "and");


        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    public void findIndexesTest() {
        String str = "sheebu";
        Optional<List<Integer>> optIndexes = FindSubStringIndexesInA_String.findIndexes(str, "e");
        List<Integer> indexes = List.of(2, 3);

        Assertions.assertEquals(indexes, optIndexes.get());
        Optional<List<Integer>> optIndexes1 = FindSubStringIndexesInA_String.findIndexes(str, "z");
        Assertions.assertEquals(Optional.empty(), optIndexes1);

    }

    @Test
    public void NumberOfNotesFromAmtTest() {
        Map<Integer, Integer> notesMap2888 = NumberOfNotesFromAmt.getNumberOfNotesFrAmt(2888);
        Assertions.assertArrayEquals(getepectedNotesMap2888().entrySet().toArray(), notesMap2888.entrySet().toArray());
        Map<Integer, Integer> notesMapWithStream = NumberOfNotesFromAmt.getNumberOfNotesFrAmtStream(2888);
        Assertions.assertArrayEquals(getepectedNotesMap2888().entrySet().toArray(), notesMapWithStream.entrySet().toArray());
        Map<Integer, Integer> notesMap5888 = NumberOfNotesFromAmt.getNumberOfNotesFrAmt(5888);
        Assertions.assertArrayEquals(getepectedNotesMap5888().entrySet().toArray(), notesMap5888.entrySet().toArray());
        Map<Integer, Integer> notesMap1Stream = NumberOfNotesFromAmt.getNumberOfNotesFrAmtStream(5888);
        Assertions.assertArrayEquals(getepectedNotesMap5888().entrySet().toArray(), notesMap1Stream.entrySet().toArray());

    }

    @Test
    public void checkBalancedWithStackTest() {
        String line = "()";//true
        String line_ = ")(";//false
        String line2 = "([])";//true
        String line2_ = "([)]";//false
        String line4 = "()([])";//true
        String line3 = "({([])})";//true
        String line3_ = "({([])))";//false
        String line5 = "()([]){([])}";//true
        String line4_ = "))([])";//false
        String line5_ = "()([])}([])}";//false
        String line6 = "()([])([{}])()(){}[]{[]}[][][]{}{}{}{}()()(){{{}}}";//true
        String line6_ = ")()([])([{}])()(){}[]{[]}[][][]{}{}{}{}()()(){{{}}}";//false
        String line7_ = "(()()([])([{}])()(){}[]{[]}[][][]{}{}{}{}()()(){{{}}}";//false

        boolean actual = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line);
        Assertions.assertTrue(actual);
            boolean actual1 = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line_);
            Assertions.assertFalse(actual1);
            boolean actual2 = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line2);
            Assertions.assertTrue(actual2);
            boolean actual2_ = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line2_);
            Assertions.assertFalse(actual2_);
            boolean actual4 = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line4);
            Assertions.assertTrue(actual4);
            boolean actual4_ = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line4_);
            Assertions.assertFalse(actual4_);
            boolean actual5 = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line5);
            Assertions.assertTrue(actual5);
            boolean actual3 = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line3);
            Assertions.assertTrue(actual3);
            boolean actual3_ = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line3_);
            Assertions.assertFalse(actual3_);
            boolean actual5_ = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line5_);
            Assertions.assertFalse(actual5_);
            boolean actual6 = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line6);
            Assertions.assertTrue(actual6);
            boolean actual6_ = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line6_);
            Assertions.assertFalse(actual6_);
            boolean actual7_ = CheckOpeningClosingBracketsBalanced.checkBalancedWithStack(line7_);
            Assertions.assertFalse(actual7_);
    }

    private static Map<Integer, Integer> getepectedNotesMap2888() {
        Map<Integer, Integer> expected = new LinkedHashMap<>();
        expected.put(2000, 1);
        expected.put(500, 1);
        expected.put(200, 1);
        expected.put(100, 1);
        expected.put(50, 1);
        expected.put(20, 1);
        expected.put(10, 1);
        expected.put(5, 1);
        expected.put(2, 1);
        expected.put(1, 1);
        return expected;
    }

    private static Map<Integer, Integer> getepectedNotesMap5888() {
        Map<Integer, Integer> expected = new LinkedHashMap<>();
        expected.put(2000, 2);
        expected.put(500, 3);
        expected.put(200, 1);
        expected.put(100, 1);
        expected.put(50, 1);
        expected.put(20, 1);
        expected.put(10, 1);
        expected.put(5, 1);
        expected.put(2, 1);
        expected.put(1, 1);
        return expected;
    }

    @Test
    public void testFirstNonRepeatableChars() {
        List<String> wordList = List.of("absolute", "definite", "accomodate", "sofistication");
        String expected = "admf";
        CombinedFirstNonRepeatableCharsFromWords cfnc = new CombinedFirstNonRepeatableCharsFromWords();
        String actual = cfnc.combinedNonRepeatable(wordList);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testLongestStringWithoutVowels() {
        String[] words = {"ada",
                "xyz",
                "absolute",
                "arithmetic1",
                "bcdfghjklm",
                "aithmatic-expression"};
        String[] words1 = {
                "ada",
                "xyz",
                "absolute",
                "arithmetic1",
                "bcdfghjklm",
                "aithmatic-expression",
                "bcdfghjklmww"
        };

        String expected = "bcdfghjklm";
        LongestWithoutVowel longestWithoutVowel = new LongestWithoutVowel();
        String actual = longestWithoutVowel.findLongestStringWithoutvowels(words);
        Assertions.assertEquals(expected,actual);
        String expected1 = "bcdfghjklmww";
        String actual1 = longestWithoutVowel.findLongestStringWithoutvowels(words1);
        Assertions.assertEquals(expected1,actual1);

    }
    @Test
    public void testFrequencyRankingFromTo1(){
        Integer[] ints={1,3,6,4,2,1,9,3,5,1,8,3,8,5,6,3,2,0,6,4,2,7,9,3,2,1};
        FrequencyRanking ranking= new FrequencyRanking();
        Map<Integer,Integer> expected=new LinkedHashMap<>();
        expected.put(1,4);
        expected.put(2,4);
        expected.put(6,3);
        Map<Integer,Integer> actual=ranking.frequencyRankingFromTo(ints,2,3);
        Assertions.assertEquals(expected,actual);
        Integer[] ints1={0,1,2,3,4,5,6,0,1,0,2,0,1,0,5,1,0,2,4};
        Map<Integer,Integer> expected1=new LinkedHashMap<>();
        expected1.put(0,6);
        expected1.put(1,4);
        expected1.put(2,3);
        //expected1.put(5,2);
        expected1.put(4,2);
        Map<Integer,Integer> actual1=ranking.frequencyRankingFromTo(ints1,1,4);
        Assertions.assertEquals(expected1,actual1);

    }
    @Test
    public void testFlipRotateTest(){

        Operation cloakWise= (twoD->{
            int size=twoD.length;
            int indexSize=size-1;
            //iterate values for rows
            Integer[][] resultArr2d= new Integer[size][size];
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++) {
                    resultArr2d[j][indexSize - i] = twoD[i][j];

                }
            }
            return resultArr2d;
        } );
        Operation antiCloakWise= (twoD->{
            int size=twoD.length;
            int indexSize=size-1;
            Integer[][] resultArr2d= new Integer[size][size];
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++) {
                    resultArr2d[indexSize-j][ i] = twoD[i][j];

                }
            }
            return resultArr2d;
        } );

        Operation flipHorizontal= (twoD->{
            int size=twoD.length;
            int indexSize=size-1;
            Integer[][] resultArr2d= new Integer[size][size];
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                for (int j = 0; j < size; j++) {
                    resultArr2d[i][ indexSize-j] = twoD[i][j];

                }
            }
            return resultArr2d;
        } );

        Operation flipVertical= (twoD->{
            int size=twoD.length;
            int indexSize=size-1;
            Integer[][] resultArr2d= new Integer[size][size];
            //iterate values for rows
            for (int i = 0; i < size; i++) {
                //iterate values for columns
                System.arraycopy(twoD[i], 0, resultArr2d[indexSize - i], 0, size);
            }
            return resultArr2d;
        } );
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

        /*
        1 2 3
        4 5 6
        7 8 9
        after rotating clockwise 90 degree
        7 4 1
        8 5 2
        9 6 3
         */
        List<List<Integer>> inputLList= new ArrayList<>();
        inputLList.add(Arrays.asList(1,2,3));
        inputLList.add(Arrays.asList(4,5,6));
        inputLList.add(Arrays.asList(7,8,9));

        List<List<Integer>> expected= new ArrayList<>();
        expected.add(Arrays.asList(7,4,1));
        expected.add(Arrays.asList(8,5,2));
        expected.add(Arrays.asList(9,6,3));

        List<List<Integer>> actual= FlipRotate.flipRotate(inputLList,cloakWise);
        Assertions.assertEquals(expected,actual);
        List<List<Integer>> actual1= clockwiseNew.doOp(inputLList);
        Assertions.assertEquals(expected,actual1);


        /*
        1 2 3
        4 5 6
        7 8 9
        After rotating anti-clockwise 90 degree
        3 6 9
        2 5 8
        1 4 7
         */
        List<List<Integer>> expectedAntiCwise= new ArrayList<>();
        expectedAntiCwise.add(Arrays.asList(3,6,9));
        expectedAntiCwise.add(Arrays.asList(2,5,8));
        expectedAntiCwise.add(Arrays.asList(1,4,7));

        List<List<Integer>> actualAntiClwise= FlipRotate.flipRotate(inputLList,antiCloakWise);
        Assertions.assertEquals(expectedAntiCwise,actualAntiClwise);

        List<List<Integer>> actualAntiClwise1= antClockwiseNew.doOp(inputLList);
        Assertions.assertEquals(expectedAntiCwise,actualAntiClwise1);

        /*
        1 2 3
        4 5 6
        7 8 9
        after flipping horizontally
        3 2 1
        6 5 4
        9 8 7
         */
        List<List<Integer>> expectedHrzdFlip= new ArrayList<>();
        expectedHrzdFlip.add(Arrays.asList(3,2,1));
        expectedHrzdFlip.add(Arrays.asList(6,5,4));
        expectedHrzdFlip.add(Arrays.asList(9,8,7));
        List<List<Integer>> actualHrzdFlip= FlipRotate.flipRotate(inputLList,flipHorizontal);
        Assertions.assertEquals(expectedHrzdFlip,actualHrzdFlip);

        List<List<Integer>> actualHrzdFlip1= flipHorzontalnew.doOp(inputLList);
        Assertions.assertEquals(expectedHrzdFlip,actualHrzdFlip1);

        /*
        1 2 3
        4 5 6
        7 8 9
        after flipping  vertically
        7 8 9
        4 5 6
        1 2 3
         */
        List<List<Integer>> expectedVerticalFlip= new ArrayList<>();
        expectedVerticalFlip.add(Arrays.asList(7,8,9));
        expectedVerticalFlip.add(Arrays.asList(4,5,6));
        expectedVerticalFlip.add(Arrays.asList(1,2,3));

        List<List<Integer>> actualVerticalFlip= FlipRotate.flipRotate(inputLList,flipVertical);
        Assertions.assertEquals(expectedVerticalFlip,actualVerticalFlip);

        List<List<Integer>> actualVerticalFlip1= flipVerticalNew.doOp(inputLList);
        Assertions.assertEquals(expectedVerticalFlip,actualVerticalFlip1);
    }
    @Test
    public void combinedSortedListTest(){

        Integer[][] input= {{1,4,5},{1,3,4},{2,6}};
        Integer[][] input2= {{11,214,-5},{-31,443,24},{42,-96},{1,4,5},{1,3,4},{2,6}};

        List<Integer> expected=List.of(1, 1, 2, 3, 4, 4, 5, 6);
        List<Integer> expected2=List.of(-96, -31, -5, 1, 1, 2, 3, 4, 4, 5, 6, 11, 24, 42, 214, 443);
        Assertions.assertEquals(expected, CobineListAndSort.getCombinedSortedList(input));
        Assertions.assertEquals(expected2, CobineListAndSort.getCombinedSortedList(input2));

    }

}

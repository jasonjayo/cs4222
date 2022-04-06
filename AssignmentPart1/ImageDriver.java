/*

    Name:   Jason Gill
    ID:     21304092

    CS4222 Assignment Part 1

*/

public class ImageDriver {
    public static void main(String[] args) {

        /*
            Testing with predefined arrays
        */

        // Testing with same number of columns and rows
        System.out.println(" == Test 1: Array with same number of rows and cols == \n");

        // horizontal flip
        System.out.println("Test 1-a: HORIZONTAL FLIP");
        int[][] pixels = {  {1, 5, 10, 333, 245},
                            {33, 212, 14, 2, 235},
                            {235, 536, 34, 35, 789},
                            {2, 342, 678, 458, 453},
                            {24, 456, 764, 456, 235}    
                        };
        Image myImage = new Image(pixels);
        
        // save original
        String original = arrayFormatter(pixels);

        int[][] expectedResult = {
            {245, 333, 10, 5, 1},
            {235, 2, 14, 212, 33},
            {789, 35, 34, 536, 235},
            {453, 458, 678, 342, 2},
            {235, 456, 764, 456, 24}
        };

        myImage.flip(true);
        checkOperation(original, expectedResult, myImage.toString());

        // Vertical flip
        System.out.println("Test 1-b: VERTICAL FLIP");
        pixels = new int[][]{   {1, 5, 10, 333, 245},
                                {33, 212, 14, 2, 235},
                                {235, 536, 34, 35, 789},
                                {2, 342, 678, 458, 453},
                                {24, 456, 764, 456, 235}    
        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {24, 456, 764, 456, 235},
            {2, 342, 678, 458, 453},
            {235, 536, 34, 35, 789},
            {33, 212, 14, 2, 235},
            {1, 5, 10, 333, 245}
        };

        myImage.flip(false);
        checkOperation(original, expectedResult, myImage.toString());

        // Clockwise rotation
        System.out.println("Test 1-c: CLOCKWISE ROTATION");
        pixels = new int[][]{  {1, 5, 10, 333, 245},
                            {33, 212, 14, 2, 235},
                            {235, 536, 34, 35, 789},
                            {2, 342, 678, 458, 453},
                            {24, 456, 764, 456, 235}    
                        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {24, 2, 235, 33, 1},
            {456, 342, 536, 212, 5},
            {764, 678, 34, 14, 10},
            {456, 458, 35, 2, 333},
            {235, 453, 789, 235, 245}
        };

        myImage.rotate(true);
        checkOperation(original, expectedResult, myImage.toString());

        // Anticlockwise rotation
        System.out.println("Test 1-d: ANTICLOCKWISE ROTATION");
        pixels = new int[][]{  {1, 5, 10, 333, 245},
                            {33, 212, 14, 2, 235},
                            {235, 536, 34, 35, 789},
                            {2, 342, 678, 458, 453},
                            {24, 456, 764, 456, 235}    
                        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {245, 235, 789, 453, 235},
            {333, 2, 35, 458, 456},
            {10, 14, 34, 678, 764},
            {5, 212, 536, 342, 456},
            {1, 33, 235, 2, 24}
        };

        myImage.rotate(false);
        checkOperation(original, expectedResult, myImage.toString());

        // Testing with more rows than cols
        System.out.println(" == Test 2: Array with more rows than cols == \n");
        
        // horizontal flip
        System.out.println("Test 2-a: HORIZONTAL FLIP");
        pixels = new int[][]{  { 2, 24, 45, 345 },
                                { 234, 265, 465, 4},
                                { 431, 4, 234, 452},
                                { 342, 524, 867, 4},
                                { 754, 356, 345, 63}  
                        };
        myImage = new Image(pixels);
        
        // save original
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {345, 45, 24, 2},
            {4, 465, 265, 234},
            {452, 234, 4, 431},
            {4, 867, 524, 342},
            {63, 345, 356, 754}
        };

        myImage.flip(true);
        checkOperation(original, expectedResult, myImage.toString());

        // Vertical flip
        System.out.println("Test 2-b: VERTICAL FLIP");
        pixels = new int[][]{   { 2, 24, 45, 345 },
                                { 234, 265, 465, 4},
                                { 431, 4, 234, 452},
                                { 342, 524, 867, 4},
                                { 754, 356, 345, 63}     
        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            { 754, 356, 345, 63},
            { 342, 524, 867, 4},
            { 431, 4, 234, 452},
            { 234, 265, 465, 4},
            { 2, 24, 45, 345 }
        };

        myImage.flip(false);
        checkOperation(original, expectedResult, myImage.toString());

        // Clockwise rotation
        System.out.println("Test 2-c: CLOCKWISE ROTATION");
        pixels = new int[][]{   { 2, 24, 45, 345 },
                                { 234, 265, 465, 4},
                                { 431, 4, 234, 452},
                                { 342, 524, 867, 4},
                                { 754, 356, 345, 63}      
                        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {754, 342, 431, 234, 2},
            {356, 524, 4, 265, 24},
            {345, 867, 234, 465, 45},
            {63, 4, 452, 4, 345}
        };

        myImage.rotate(true);
        checkOperation(original, expectedResult, myImage.toString());

        // Anticlockwise rotation
        System.out.println("Test 2-d: ANTICLOCKWISE ROTATION");
        pixels = new int[][]{   { 2, 24, 45, 345 },
                                { 234, 265, 465, 4},
                                { 431, 4, 234, 452},
                                { 342, 524, 867, 4},
                                { 754, 356, 345, 63}     
                        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {345, 4, 452, 4, 63},
            {45, 465, 234, 867, 345},
            {24, 265, 4, 524, 356},
            {2, 234, 431, 342, 754}
        };

        myImage.rotate(false);
        checkOperation(original, expectedResult, myImage.toString());

        // Testing with more cols than rows
        System.out.println(" == Test 3: Array with more cols than rows == \n");
        
        // horizontal flip
        System.out.println("Test 3-a: HORIZONTAL FLIP");
        pixels = new int[][]{ {54, 345, 373, 351, 598, 545, 234, 143, 34, 5},
                              {435, 9, 2, 908, 18, 134, 135, 523, 235, 97},
                              {949, 846, 6, 5, 684, 25, 687, 19, 366, 37},
                              {84, 654, 35, 9, 132, 654, 612, 413, 452, 789},
                              {45, 67, 677, 654, 516, 897, 6, 65, 14, 365}
                        };
        myImage = new Image(pixels);
        
        // save original
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {5,34,143,234,545,598,351,373,345,54},
            {97,235,523,135,134,18,908,2,9,435},
            {37,366,19,687,25,684,5,6,846,949},
            {789,452,413,612,654,132,9,35,654,84},
            {365,14,65,6,897,516,654,677,67,45}
        };

        myImage.flip(true);
        checkOperation(original, expectedResult, myImage.toString());

        // Vertical flip
        System.out.println("Test 3-b: VERTICAL FLIP");
        pixels = new int[][]{   {54, 345, 373, 351, 598, 545, 234, 143, 34, 5},
                                {435, 9, 2, 908, 18, 134, 135, 523, 235, 97},
                                {949, 846, 6, 5, 684, 25, 687, 19, 366, 37},
                                {84, 654, 35, 9, 132, 654, 612, 413, 452, 789},
                                {45, 67, 677, 654, 516, 897, 6, 65, 14, 365}
        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {45, 67, 677, 654, 516, 897, 6, 65, 14, 365},
            {84, 654, 35, 9, 132, 654, 612, 413, 452, 789},
            {949, 846, 6, 5, 684, 25, 687, 19, 366, 37},
            {435, 9, 2, 908, 18, 134, 135, 523, 235, 97},
            {54, 345, 373, 351, 598, 545, 234, 143, 34, 5}
        };

        myImage.flip(false);
        checkOperation(original, expectedResult, myImage.toString());

        // Clockwise rotation
        System.out.println("Test 3-c: CLOCKWISE ROTATION");
        pixels = new int[][]{   {54, 345, 373, 351, 598, 545, 234, 143, 34, 5},
                                {435, 9, 2, 908, 18, 134, 135, 523, 235, 97},
                                {949, 846, 6, 5, 684, 25, 687, 19, 366, 37},
                                {84, 654, 35, 9, 132, 654, 612, 413, 452, 789},
                                {45, 67, 677, 654, 516, 897, 6, 65, 14, 365} 
                        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {45, 84, 949, 435, 54},
            {67, 654, 846, 9, 345},
            {677, 35, 6, 2, 373},
            {654, 9, 5, 908, 351},
            {516, 132, 684, 18, 598},
            {897, 654, 25, 134, 545},
            {6, 612, 687, 135, 234},
            {65, 413, 19, 523, 143},
            {14, 452, 366, 235, 34},
            {365, 789, 37, 97, 5},
        };

        myImage.rotate(true);
        checkOperation(original, expectedResult, myImage.toString());

        // Anticlockwise rotation
        System.out.println("Test 3-d: ANTICLOCKWISE ROTATION");
        pixels = new int[][]{   {54, 345, 373, 351, 598, 545, 234, 143, 34, 5},
                                {435, 9, 2, 908, 18, 134, 135, 523, 235, 97},
                                {949, 846, 6, 5, 684, 25, 687, 19, 366, 37},
                                {84, 654, 35, 9, 132, 654, 612, 413, 452, 789},
                                {45, 67, 677, 654, 516, 897, 6, 65, 14, 365} 
                        };
        myImage = new Image(pixels);
        original = arrayFormatter(pixels);

        expectedResult = new int[][] {
            {5, 97, 37, 789, 365},
            {34, 235, 366, 452, 14},
            {143, 523, 19, 413, 65},
            {234, 135, 687, 612, 6},
            {545, 134, 25, 654, 897},
            {598, 18, 684, 132, 516},
            {351, 908, 5, 9, 654},
            {373, 2, 6, 35, 677},
            {345, 9, 846, 654, 67},
            {54, 435, 949, 84, 45}
        };

        myImage.rotate(false);
        checkOperation(original, expectedResult, myImage.toString());

        /*
            Test 4: with a randomly generated array
        */

        System.out.println(" == Test 4: Array of random width & random height filled with random numbers (results here are cumulative as I have not reset array after each operation) == \n");
        // generate random width & height between 1 and 10 
        int width = (int) (Math.random() * 10 + 1);
        int height = (int) (Math.random() * 10 + 1);
        pixels = new int[height][width];
        
        // fill array with random numbers between 0 and 1000
        for (int i = 0; i < height; i++) {
            for (int a = 0; a < width; a++) {
                pixels[i][a] = (int) (Math.random() * 1001);
            }
        }

        // create new instance of Image class
        myImage = new Image(pixels);

        // carry out various transformations on the image and output results
        System.out.println("Unaltered array:");
        System.out.println(myImage.toString());
        System.out.println("Test 4-a: HORIZONTAL FLIP");
        myImage.flip(true);
        System.out.println(myImage.toString());
        System.out.println("Test 4-b: VERTICAL FLIP");
        myImage.flip(false);
        System.out.println(myImage.toString());
        System.out.println("Test 4-c: ROTATED CLOCKWISE");
        myImage.rotate(true);
        System.out.println(myImage.toString());
        System.out.println("Test 4-c-i: ROTATED COUNTER CLOCKWISE (back to before clockwise rotation)");
        myImage.rotate(false);
        System.out.println(myImage.toString());
        System.out.println("Test 4-c-ii: ROTATED COUNTER CLOCKWISE AGAIN:");
        myImage.rotate(false);
        System.out.println(myImage.toString());
        myImage.rotate(true);
        myImage.rotate(true);
        myImage.rotate(true);
        myImage.rotate(true);
        System.out.println("Test 4-d: ROTATED CLOCKWISE 4 TIMES (should remain unchanged):");
        System.out.println(myImage.toString());

    }

    // used to format original & expected result arrays in the same way as the Image driver outputs the real results
    public static String arrayFormatter(int[][] arr) {
        String str = "";

        for (int[] row : arr) {
            for(int pixel: row) {
                // using String.format to ensure possibility of 1-, 2-, 3- & 4-digit numbers in array doesn't
                // cause alignment issues when visible on screen.
                str += String.format("  %4d  ", pixel);
            }
            // line break after each row
            str += "\n";
        }

        return str;
    }

    // method to avoid repeating same code for each test
    public static void checkOperation(String original, int[][] expectedResult, String actualResult) {
        
        String expectedResultString = arrayFormatter(expectedResult);

        System.out.println("Original array:");
        System.out.println(original);

        System.out.println("Expected result:");
        System.out.println(expectedResultString);

        System.out.println("Actual result:");
        System.out.println(actualResult);

        System.out.println("Equal? " + (expectedResultString.compareTo(actualResult) == 0 ? "yes" : "no") + "\n");
    }
}

import java.util.*;

public class ImageDriverDermot {
    public static void main(String[] args) {
        Image selfie;
        String originalImage;
        String imageAfterOperation;
        String expectedResult;
        
        double potentialScore = 0.0;

        // Test 1.
        // Test the flip horizontal feature.
        // Original Image
        int[][] theSelfie = { {0, 10, 20, 30, 40, 50},
                              {1, 11, 21, 31, 41, 51},
                              {2, 12, 22, 32, 42, 52},
                              {3, 13, 23, 33, 43, 53},
                              {4, 14, 24, 34, 44, 54},
                              {5, 15, 25, 35, 45, 55}    };
        // Create the image instance for the test
        selfie = new Image(theSelfie);
        originalImage = selfie.toString();
        // Use the flip horizontal operation method
        selfie.flip(true);
        imageAfterOperation = selfie.toString();

        // What the image should look like AFTER Flip Horizontal operation
        int[][] theResult =  { {50, 40, 30, 20, 10, 0},
                               {51, 41, 31, 21, 11, 1},
                               {52, 42, 32, 22, 12, 2},
                               {53, 43, 33, 23, 13, 3},
                               {54, 44, 34, 24, 14, 4},
                               {55, 45, 35, 25, 15, 5}    }; 
        expectedResult = Arrays.deepToString(theResult);

        // Report the results
        System.out.println("'flip Horizontal'") ;
        System.out.println("'==============='") ;
        System.out.println("Original Image        : " + originalImage);
        System.out.println("Image After Operation : " + imageAfterOperation);
        System.out.println("Expected Result       : " + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("4.5 marks -> 'flip Horizontal' works.\n") ;
            potentialScore = potentialScore + 4.5;
        }

        // Test 2.
        // Test the flip vertical feature.
        // Original Image
        // Create image instance for test
        theSelfie = new int[][] { { 0,  1,  2,  3,  4,  5,  6},
                                  {10, 11, 12, 13, 14, 15, 16},
                                  {20, 21, 22, 23, 24, 25, 26},
                                  {30, 31, 32, 33, 34, 35, 36},
                                  {40, 41, 42, 43, 44, 45, 46},
                                  {50, 51, 52, 53, 54, 55, 56}    };
        selfie = new Image(theSelfie);
        originalImage = selfie.toString();

        // Use the flip vertical operation method
        selfie.flip(false);
        imageAfterOperation = selfie.toString();

        // What the image should look like AFTER Flip Vertical operation
        theResult = new int[][] { {50, 51, 52, 53, 54, 55, 56},
                                  {40, 41, 42, 43, 44, 45, 46},
                                  {30, 31, 32, 33, 34, 35, 36},
                                  {20, 21, 22, 23, 24, 25, 26},
                                  {10, 11, 12, 13, 14, 15, 16},
                                  { 0,  1,  2,  3,  4,  5,  6}    }; 
        expectedResult = Arrays.deepToString(theResult);

        // Report the results
        System.out.println("'flip Vertical'") ;
        System.out.println("'============='") ;
        System.out.println("Original Image        : " + originalImage);
        System.out.println("Image After Operation : " + imageAfterOperation);
        System.out.println("Expected Result       : " + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("4.5 marks -> 'flip Vertical' works.\n") ;
            potentialScore = potentialScore + 4.5;
        }
        
        
        // Test 3.
        // Test the Rotate Clockwise feature.
        // Original Image
        theSelfie  = new int[][] { { 0,  1,  2,  3,  4,  5,  6,  7,  8,  9},
                                   {10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
                                   {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                                   {30, 31, 32, 33, 34, 35, 36, 37, 38, 39},
                                   {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                                   {50, 51, 52, 53, 54, 55, 56, 57, 58, 59}    };
        // Create image instance for test
        selfie = new Image(theSelfie);
        originalImage = selfie.toString();
        
        // Use the Rotate Clockwise operation
        selfie.rotate(true);
        imageAfterOperation  = selfie.toString();
        
        // What the image should look like AFTER Rotate Clockwise operation
        theResult = new int[][] { {50, 40, 30, 20, 10, 0},
                                  {51, 41, 31, 21, 11, 1},
                                  {52, 42, 32, 22, 12, 2},
                                  {53, 43, 33, 23, 13, 3},
                                  {54, 44, 34, 24, 14, 4},
                                  {55, 45, 35, 25, 15, 5},
                                  {56, 46, 36, 26, 16, 6},
                                  {57, 47, 37, 27, 17, 7},
                                  {58, 48, 38, 28, 18, 8},
                                  {59, 49, 39, 29, 19, 9}    };
        expectedResult = Arrays.deepToString(theResult);
        
        System.out.println("'rotate Clockwise'") ;
        System.out.println("'================'") ;
        System.out.println("Original Image        : " + originalImage);
        System.out.println("Image After Operation : " + imageAfterOperation);
        System.out.println("Expected Result       : " + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("6.5 marks -> 'rotate Clockwise' works.\n") ;
            potentialScore = potentialScore + 6.5;
        }
        
        // Test 4.
        // Test the rotate Anti-Clockwise feature.
        // Original Image
        theSelfie  = new int[][] { { 0,  1,  2,  3,  4,  5,  6,  7,  8,  9},
                                   {10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
                                   {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                                   {30, 31, 32, 33, 34, 35, 36, 37, 38, 39},
                                   {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                                   {50, 51, 52, 53, 54, 55, 56, 57, 58, 59}    };

        // Create image instance for test
        selfie = new Image(theSelfie);
        
        // Use the Rotate Anti-Clockwise operation
        selfie.rotate(false);
        imageAfterOperation  = selfie.toString();
        
        // What the image should look like AFTER Rotate Anti-Clockwise operation
        theResult = new int[][] { {9, 19, 29, 39, 49, 59},
                                  {8, 18, 28, 38, 48, 58},
                                  {7, 17, 27, 37, 47, 57},
                                  {6, 16, 26, 36, 46, 56},
                                  {5, 15, 25, 35, 45, 55},
                                  {4, 14, 24, 34, 44, 54},
                                  {3, 13, 23, 33, 43, 53},
                                  {2, 12, 22, 32, 42, 52},
                                  {1, 11, 21, 31, 41, 51},
                                  {0, 10, 20, 30, 40, 50}    };  
        expectedResult = Arrays.deepToString(theResult);
        
        System.out.println("'rotate Anti-Clockwise'") ;
        System.out.println("'====================='") ;
        System.out.println("Original Image        : " + originalImage);
        System.out.println("Image After Operation : " + imageAfterOperation);
        System.out.println("Expected Result       : " + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("6.5 marks -> 'rotate Anti-Clockwise' works.\n") ;
            potentialScore = potentialScore + 6.5;
        }
        
        System.out.printf("Potential Score (not including marks for testing ) is %4.1f out of 22.0\n", potentialScore); 
    }
}

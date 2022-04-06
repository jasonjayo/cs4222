/*

    Name:   Jason Gill
    ID:     21304092

    CS4222 Assignment Part 1

*/

public class Image {

    private int[][] pixels;
    private int width;
    private int height;

    public Image(int[][] pixels) {

        this.pixels = pixels;
        this.height = pixels.length;
        this.width = pixels[0].length;

    }

    public String toString() {

        String str = "";

        for (int[] row : pixels) {
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

    public void flip(boolean horizontal) {

        if (horizontal) {
            
            // swap cols
            int left = 0;
            int right = this.width - 1;
            int temp = 0;
            // go through each row
            for(int i = 0; i < this.height; i++) {
                // reset variables for new row
                left = temp = 0;
                right = this.width - 1;
                // go left to right and swap cols for current row
                while (left < right) {
                    temp = this.pixels[i][left];
                    this.pixels[i][left++] = this.pixels[i][right];
                    this.pixels[i][right--] = temp;
                }
            }

        } else {
            
            // swap rows
            int top = 0;
            int bottom = this.height - 1;
            int[] temp;

            // go top to bottom and swap rows
            while (top < bottom) {
                temp = this.pixels[top];
                this.pixels[top++] = this.pixels[bottom];
                this.pixels[bottom--] = temp;
            }

        }
        
    }

    public void rotate(boolean clockwise) {

        // create temporary second array to facilitate rotation
        int[][] modifiedArray = new int[this.width][this.height];

        if (clockwise) {
            // go through each row in original array
            for (int i = 0; i < this.height; i++) {
                // go through column in current row in original row
                for (int a = 0; a < this.width; a++) {
                    modifiedArray[a][this.height - 1 - i] = this.pixels[i][a];
                }
            }
        } else {
            // go through each row in original array
            for (int i = 0; i < this.height; i++) {
                // go through column in current row in original row
                for (int a = 0; a < this.width; a++) {
                    modifiedArray[this.width - 1 - a][i] = this.pixels[i][a];
                }
            }
        }

        // adjust original array
        this.pixels = modifiedArray;
        int temp = this.width;
        this.width = this.height;
        this.height = temp;

    }

}
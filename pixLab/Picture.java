
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /*
         * not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName()
                + " height " + getHeight()
                + " width " + getWidth();
        return output;

    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * Method to set the all but blue to 0
     */
    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(0);
                pixelObj.setRed(0);
            }
        }
    }

    /**
     * Method to set the all but green to 0
     */
    public void keepOnlyGreen() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
                pixelObj.setRed(0);
            }
        }
    }

    /**
     * Method to set the all but red to 0
     */
    public void keepOnlyRed() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(0);
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * Method to avg all color values
     */
    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int avg = (int) ((pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()) / 3.0);
                pixelObj.setGreen(avg);
                pixelObj.setRed(avg);
                pixelObj.setBlue(avg);
            }
        }
    }

    /**
     * Method to negate all color values
     */
    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    public void processImage() {
        grayscale();
        Pixel[][] pixels = this.getPixels2D();
        int[][] grays = new int[pixels.length][pixels[0].length];
        int r1 = 0;
        for (Pixel[] pL : pixels) {
            int c1 = 0;
            for (Pixel p : pL) {
                grays[r1][c1] = p.getRed();
                c1++;
            }
            r1++;
        }
        for (int r = 0; r < grays.length - 2; r++) {
            for (int c = 0; c < grays[r].length - 2; c++) {
                grays[r][c] = Math.max(0, grays[r][c] - grays[r + 2][c + 2]);
                pixels[r][c].setRed(grays[r][c]);
                pixels[r][c].setGreen(grays[r][c]);
                pixels[r][c].setBlue(grays[r][c]);
            }
        }
    }

    /**
     * Method to highlight underwater fish in water.jpg
     */
    public void fixUnderwater() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int r = pixelObj.getRed();
                int g = pixelObj.getGreen();
                int b = pixelObj.getBlue();
                if ((r <= 20 && g >= 150 && g <= 170 && b > 150) || ((Math.abs(148 - b) <= 2) && ((r >= 23 && r <= 27 || r < 20) && r != 24) && Math.abs(160 - g) < 5)) {
                    g -= 75;
                    r += 75;
                    pixelObj.setRed(r);
                    pixelObj.setGreen(g);
                    pixelObj.setBlue(b);
                }
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center
     * of the picture from top to bottom
     */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel top = null;
        Pixel bot = null;
        int length = pixels.length;
        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                top = pixels[row][col];
                bot = pixels[length - 1 - row][col];
                bot.setColor(top.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center
     * of the picture from bottom to top
     */
    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel top = null;
        Pixel bot = null;
        int length = pixels.length;
        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                top = pixels[row][col];
                bot = pixels[length - 1 - row][col];
                top.setColor(bot.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a diagonal mirror in the top left
     * corner of the picture from bottom left to top right
     */
    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topR = null;
        Pixel botL = null;
        int length = pixels.length;
        int width = pixels[0].length;
        int x = Math.min(length, width);
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < x; col++) {
                topR = pixels[row][col];
                botL = pixels[col][row];
                topR.setColor(botL.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a diagonal mirror in the top left
     * corner to the bottom right corner of the picture from bottom left to top
     * right
     */
    public void trueMirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topR = null;
        Pixel botL = null;
        int length = pixels.length;
        int width = pixels[0].length;
        double x = Math.max(length, width);
        for (int row = 0; row < x; row++) {
            for (int col = row; col < x; col++) {
                topR = pixels[(int) (row / x * length)][(int) (col / x * width)];
                botL = pixels[(int) (col / x * length)][(int) (row / x * width)];
                topR.setColor(botL.getColor());
                if ((int) (row / x * length) == (int) (col / x * length) && (int) (col / x * width) == (int) (row / x * width)) {
                    topR.setColor(Color.BLACK);
                }
            }
        }
    }

    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                count++;
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        System.out.println("Count = " + count);
    }

    /**
     * Mirror the arms of a snowman to provide an outlet for our species' primal
     * need for death, destruction, gore, and the twisted side of life
     */
    public void mirrorArms() {
        int mPointY = 194;
        int fromX = 102;
        int toX = 296;
        int fromY = 163;
        Pixel top = null;
        Pixel bot = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = fromY; row < mPointY; row++) {
            for (int col = fromX; col < toX; col++) {
                count++;
                top = pixels[row][col];
                bot = pixels[mPointY + Math.abs(mPointY - row)][col];
                bot.setColor(top.getColor());
            }
        }
        System.out.println("Count = " + count);
    }

    /**
     * Mirror the seagull
     */
    public void mirrorGull() {
        int mPointX = 350;
        int downY = 10;
        int fromX = 235;
        int toX = 344;
        int fromY = 234;
        int toY = 323;
        Pixel left = null;
        Pixel right = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = fromY; row < toY; row++) {
            for (int col = fromX; col < toX; col++) {
                count++;
                left = pixels[row][col];
                right = pixels[row + downY][mPointX + mPointX - col];
                right.setColor(left.getColor());
            }
        }
        System.out.println("Count = " + count);
    }

    /**
     * copy from the passed fromPic to the specified startRow and startCol in
     * the current picture
     *
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic,
            int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
                fromRow < fromPixels.length
                && toRow < toPixels.length;
                fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
                    fromCol < fromPixels[0].length
                    && toCol < toPixels[0].length;
                    fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * Method to create a collage of several pictures
     */
    public void createCollage() {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0;
                    col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist) {
                    leftPixel.setColor(Color.BLACK);
                } else {
                    leftPixel.setColor(Color.WHITE);
                }
            }
        }
    }

    /*
     * Main method for testing - each class in Java can have a main
     * method
     */
    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this

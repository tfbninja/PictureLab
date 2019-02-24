
/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {

    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture oil = new Picture("Oil.jpg");
        oil.explore();
        oil.zeroBlue();
        oil.explore();
    }

    public static void testProcess() {
        Picture beach = new Picture("Oil.jpg");
        beach.explore();
        beach.processImage();
        beach.explore();
    }

    public static void testKeepOnlyBlue() {
        Picture oil = new Picture("Oil.jpg");
        oil.keepOnlyBlue();
        oil.explore();
    }

    public static void testKeepOnlyRed() {
        Picture oil = new Picture("Oil.jpg");
        oil.keepOnlyRed();
        oil.explore();
    }

    public static void testKeepOnlyGreen() {
        Picture oil = new Picture("Oil.jpg");
        oil.keepOnlyGreen();
        oil.explore();
    }

    public static void testGrayscale() {
        Picture oil = new Picture("Oil.jpg");
        oil.explore();
        oil.grayscale();
        oil.explore();
    }

    public static void testNegate() {
        Picture oil = new Picture("Oil.jpg");
        oil.explore();
        oil.negate();
        oil.explore();
    }

    public static void testFixUnderwater() {
        Picture water = new Picture("water.jpg");
        water.explore();
        water.fixUnderwater();
        water.explore();
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVerticalRightToLeft() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }

    /**
     * Method to test mirrorTemple
     */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /**
     * Method to test mirrorArms
     */
    public static void testMirrorArms() {
        Picture snowman = new Picture("snowman.jpg");
        snowman.explore();
        snowman.mirrorArms();
        snowman.explore();
    }

    /**
     * Method to test mirrorGull
     */
    public static void testMirrorGull() {
        Picture seagull = new Picture("seagull.jpg");
        seagull.explore();
        seagull.mirrorGull();
        seagull.explore();
    }

    /**
     * Method to test mirrorHorizontal
     */
    public static void testMirrorHorizontal() {
        Picture red = new Picture("redMotorcycle.jpg");
        red.explore();
        red.mirrorHorizontal();
        red.explore();
    }

    /**
     * Method to test mirrorHorizontalBotToTop
     */
    public static void testMirrorHorizontalBotToTop() {
        Picture red = new Picture("redMotorcycle.jpg");
        red.explore();
        red.mirrorHorizontalBotToTop();
        red.explore();
    }

    /**
     * Method to test mirrorDiagonal
     */
    public static void testMirrorDiagonal() {
        Picture blue = new Picture("blueMotorcycle.jpg");
        blue.explore();
        blue.mirrorDiagonal();
        blue.explore();
    }

    /**
     * Method to test trueMirrorDiagonal
     */
    public static void testTrueMirrorDiagonal() {
        Picture blue = new Picture("blueMotorcycle.jpg");
        blue.explore();
        blue.trueMirrorDiagonal();
        blue.explore();
    }

    /**
     * Method to test the collage method
     */
    public static void testCollage() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testProcess();
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorHorizontal();
        //testMirrorHorizontalBotToTop();
        //testMirrorTemple();
        //testMirrorArms();
        testMirrorGull();
        //testMirrorDiagonal();
        //testTrueMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}

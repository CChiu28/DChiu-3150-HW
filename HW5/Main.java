public class Main {
    public static void main(String[] args) {
        int r = 5;
        int sqArea = r*r;
        double cirArea = (Math.PI*Math.pow(r, 2))/4;
        double areaRatio = cirArea/sqArea;
        System.out.println("Sq: "+sqArea);
        System.out.println("Circle: "+cirArea);
        System.out.println("Ratio: "+areaRatio);
    }
}
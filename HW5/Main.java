import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int r = 5;
        int x = 0;
        int y = 0;
        int sqArea = r*r;
        long circHit = 0;
        long sqHit = 0;
        double cirArea = (Math.PI*Math.pow(r, 2))/4;
        double areaRatio = cirArea/sqArea;
        System.out.println("Sq: "+sqArea);
        System.out.println("Circle: "+cirArea);
        System.out.println("Ratio: "+areaRatio);
        for (long i=0; i<10; i++) {
            x = rand.nextInt(6);
            y = rand.nextInt(6);
            if ((x*x)+(y*y)<(r*r)) {
                circHit++;
            } else sqHit++;
        }
        System.out.println(circHit);
        System.out.println(sqHit);
    }
}
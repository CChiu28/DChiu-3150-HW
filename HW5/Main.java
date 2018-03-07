import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        //Random rand = new Random();
        int r = 1;
        double x = 0;
        double y = 0;
        int sqArea = r*r;
        long circHit = 0;
        long Hit = 0;
        double ratio = 0;
        double cirArea = (Math.PI*Math.pow(r, 2))/4;
        double areaRatio = cirArea/sqArea;
        System.out.println("Sq: "+sqArea);
        System.out.println("Circle: "+cirArea);
        System.out.println("Ratio: "+areaRatio);
        for (long i=0; i<4000000000L; i++) {
            x = Math.random();
            y = Math.random();
            if (((x*x)+(y*y))<=(r*r)) {
                circHit++;
            }
            Hit++;
        }
        System.out.println(circHit);
        System.out.println(Hit);
        ratio = circHit/Hit;
        System.out.println("Ratio: "+(double)circHit/(double)Hit);
        System.out.println("PI: "+(circHit/Hit)*4);
        System.out.println(System.currentTimeMillis()-before);
    }
}
// public class Main {
//     public static void main(String[] args) {
//         long before = System.currentTimeMillis();
//         int r = 1;
//         double x = 0;
//         double y = 0;
//         int sqArea = r*r;
//         long circHit = 0;
//         long Hit = 0;
//         double cirArea = (Math.PI*(r*r)/4);
//         double areaRatio = cirArea/sqArea;
//         System.out.println("Sq: "+sqArea);
//         System.out.println("Circle: "+cirArea);
//         System.out.println("Ratio: "+areaRatio);
//         for (long i=0; i<4000000000L; i++) {
//             x = Math.random();
//             y = Math.random();
//             if (((x*x)+(y*y))<=(r*r))
//                 circHit++;
//             Hit++;
//         }
//         System.out.println(circHit);
//         System.out.println(Hit);
//         System.out.println("PI: "+((double)circHit/Hit)*4);
//         System.out.println(System.currentTimeMillis()-before);
//     }
// }
public class Main {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int r = 1;
        long circHitTotal = 0;
        long hitTotal = 0;
        ThreadRun t1 = new ThreadRun(r);
        ThreadRun t2 = new ThreadRun(r);
        ThreadRun t3 = new ThreadRun(r);
        ThreadRun t4 = new ThreadRun(r);
        // int sqArea = r*r;
        // double cirArea = (Math.PI*(r*r)/4);
        // double areaRatio = cirArea/sqArea;
        // System.out.println("Sq: "+sqArea);
        // System.out.println("Circle: "+cirArea);
        // System.out.println("Ratio: "+areaRatio);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {}
        circHitTotal = t1.circHit+t2.circHit+t3.circHit+t4.circHit;
        hitTotal = t1.Hit+t2.Hit+t3.Hit+t4.Hit;
        System.out.println(circHitTotal);
        System.out.println(hitTotal);
        System.out.println("PI: "+((double)circHitTotal/hitTotal)*4);
        System.out.println(System.currentTimeMillis()-before);
    }
}

class ThreadRun extends Thread {
    int r = 0;
    double x = 0;
    double y = 0;
    long circHit = 0;
    long Hit = 0;
    ThreadRun(int r) {
        this.r = r;
    }
    public void run() {
        for (long i=0; i<1000000000L; i++) {
            x = Math.random();
            y = Math.random();
            if (((x*x)+(y*y))<=(r*r))
                circHit++;
            Hit++;
        }
        // System.out.println(circHit);
        // System.out.println(Hit);
        // System.out.println("PI: "+((double)circHit/Hit)*4);
    }
}
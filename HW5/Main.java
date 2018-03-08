import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int r = 3;
        double x = 0;
        double y = 0;
        int sqArea = r*r;
        long circHit = 0;
        long Hit = 0;
        double cirArea = (Math.PI*(r*r)/4);
        double areaRatio = cirArea/sqArea;
        System.out.println("Radius: "+r);
        System.out.println("Area of Sq: "+sqArea);
        System.out.println("Area of Circle: "+cirArea);
        System.out.println("Ratio: "+areaRatio);
        for (long i=0; i<4000000000L; i++) {
            x = Math.random()*r;
            y = Math.random()*r;
            if (((x*x)+(y*y))<=(r*r))
                circHit++;
            Hit++;
        }
        System.out.println("Hits in circle: "+circHit);
        System.out.println("Total hits: "+Hit);
        System.out.println("Hits in circle/Total hits: "+(double)circHit/Hit);
        System.out.println("PI: "+((double)circHit/Hit)*4);
        System.out.println(System.currentTimeMillis()-before);
    }
}
// Attempted to use threads for optimization. Using only one thread still resulted in similar runtimes.
// Tried using multiple threads but program would slow down and hang.
// Tried using ExecutorService to utilize threadgrouping but program would also hang.
// https://www.particleincell.com/2011/java-multithreading/
// https://www.ntu.edu.sg/home/ehchua/programming/java/J5e_multithreading.html
// https://www.javaworld.com/article/2074217/java-concurrency/java-101--understanding-java-threads--part-1--introducing-threads-and-runnables.html

// public class Main {
//     public static void main(String[] args) {
//         long before = System.currentTimeMillis();
//         int r = 1;
//         long circHitTotal = 0;
//         long hitTotal = 0;
//         ExecutorService group = Executors.newFixedThreadPool(40);
//         ThreadRun[] tGroup = new ThreadRun[2];
//         for (int i=0; i<2; i++) {
//             tGroup[i] = new ThreadRun(r);
//             group.execute(tGroup[i]);
//         }
//         // int sqArea = r*r;
//         // double cirArea = (Math.PI*(r*r)/4);
//         // double areaRatio = cirArea/sqArea;
//         // System.out.println("Sq: "+sqArea);
//         // System.out.println("Circle: "+cirArea);
//         // System.out.println("Ratio: "+areaRatio);

//         System.out.println(circHitTotal);
//         System.out.println(hitTotal);
//         System.out.println("PI: "+((double)circHitTotal/hitTotal)*4);
//         group.shutdown();
//         System.out.println(System.currentTimeMillis()-before);
//     }
// }

// class ThreadRun extends Thread {
//     int r = 0;
//     double x = 0;
//     double y = 0;
//     long circHit = 0;
//     long Hit = 0;
//     ThreadRun(int r) {
//         this.r = r;
//     }
//     public void run() {
//         for (long i=0; i<2000000000L; i++) {
//             x = Math.random();
//             y = Math.random();
//             if (((x*x)+(y*y))<=(r*r))
//                 circHit++;
//             Hit++;
//         }
//         System.out.println(circHit);
//         System.out.println(Hit);
//         // System.out.println("PI: "+((double)circHit/Hit)*4);
//     }
//     public long getCircHit() {
//         return circHit;
//     }
//     public long getHit() {
//         return Hit;
//     }
// }
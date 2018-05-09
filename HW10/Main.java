public class Main {
    public static void main(String[] args) {
        AlphabetizeMeCaptain ABC = new AlphabetizeMeCaptain(); // New object that does the abc printing
        Thread t1 = new Thread(new Abc(ABC,0),"T1"); // 0 signifies first thread with name 'T1'
        Thread t2 = new Thread(new Abc(ABC,1),"T2");
        Thread t3 = new Thread(new Abc(ABC,2),"T3");
        Thread t4 = new Thread(new Abc(ABC,3),"T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

// The threading class
class Abc implements Runnable {
    AlphabetizeMeCaptain abcMe; // class that prints the abcs
    int threadNum = 0; // Which thread
    // Abc constructor takes a AlphabetizeMeCaptain class and the int denoting which thread
    Abc(AlphabetizeMeCaptain x, int n) {
        this.abcMe = x;
        this.threadNum = n;
    }
    @Override
    public synchronized void run() {
        abcMe.printMeAbcs(threadNum); // Run da printing things
    }
}

// The alphabet stuff
class AlphabetizeMeCaptain {
    char c = 'a'; // Start at the beginning
    int n = 0; // value to determine which thread calls wait()
    public void printMeAbcs(int threadNum) {
        synchronized(this) { // Keeps this code block locked to current thread
            while (c<'z') { // While alphabet is not finished
                //System.out.println((n%4)+" "+n+" "+threadNum);
                while (n%4!=threadNum) { // run this if nmod4 is not the thread number
                    try {
                        this.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+": "+c); // Print character
                c++; // increment character
                n++; // Increment the value to determine next thread wait() call
                this.notifyAll(); // Party time for the other threads
            }
        }
    }
}
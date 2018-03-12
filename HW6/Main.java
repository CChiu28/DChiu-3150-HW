import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        int n = scan.nextInt(); //number of queens
        int[] queens = new int[n]; //Array holds column position of queen
        //int[][] queenPos = new int[n][n]; //Position of queens
        findValidPos(queens, 0);
        // for (int i=0; i<queens.length; i++) {
        //     for (int j=0; j<queens.length; j++) {
        //         if (queens[i]==j)
        //             System.out.printf("%2c",'*');
        //         else System.out.printf("%2c",'-');
        //     }
        //     System.out.println();
        // }
        System.out.println();
    }

    public static boolean safetyCheck(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if ((q[i]==q[n])||((q[i]-q[n])==(n-i))||((q[n]-q[i])==(n-i)))
                return false;
        }
        return true;
    }

    public static void findValidPos(int[] queens, int currQueens) {
        int n = queens.length;
        int sol = 0;
        if (currQueens==n) {
            sol++;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (queens[i]==j)
                        System.out.printf("%-2c",'*');
                    else System.out.printf("%-2c",'-');
                }
                System.out.println();
            }  
            //System.out.println();
            printTemp(queens);
        } else {
            for (int i=0; i<n; i++) {
                queens[currQueens] = i;
                //printTemp(queens);
                if (safetyCheck(queens, currQueens)) {
                    int j = currQueens + 1;
                    findValidPos(queens, j);
                }
            }
        }
    }

    public static void printTemp(int[] q) {
        for (int i=0; i<q.length; i++)
            System.out.print(q[i]+" ");
        System.out.println("\n");
    }
}
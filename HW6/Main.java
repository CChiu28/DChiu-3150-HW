import java.util.*;

public class Main {
    static int sol = 0; //# of solutions found
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        int n = scan.nextInt(); //number of queens
        if (n==2||n==3) //2 and 3 results in no solutions
            System.out.print("There are no solutions to be found");
        else {
            int[] queens = new int[n]; //Array elements holds col position of queen; indices indicate row pos
            findValidPos(queens, 0); //Begin backtracking starting at 0 queens
            System.out.print(sol+" unique solutions found"); //Print # of solutions found
        }
        scan.close();
        System.exit(0);
    }

    public static void findValidPos(int[] queens, int currQueen) {
        if (currQueen==queens.length) { //If # of queens equals max queens, print solution
            sol++;
            for (int i=0; i<queens.length; i++) {
                for (int j=0; j<queens.length; j++) {
                    if (queens[j]==i)
                        System.out.printf("%-2c",'Q');
                    else System.out.printf("%-2c",'-');
                }
                System.out.println();
            }
            System.out.println();
        } else {
            for (int col=0; col<queens.length; col++) { //Begin iterating through columns
                queens[currQueen] = col; //Attempt to place queen at {row:'currQueen', col}
                if (safetyCheck(queens, currQueen)) { //Check if valid
                    int j = currQueen + 1; //Increment to next queen if valid spot
                    findValidPos(queens, j); //Find spot for next queen
                }
            }
        }
    }

    public static boolean safetyCheck(int[] queens, int currQueen) {
        for (int posQueen=0; posQueen<currQueen; posQueen++) { //Iterate to check for possible queens
            if (queens[posQueen]==queens[currQueen]) //Checks if queens are in same columns
                return false;
            else if ((queens[posQueen]-queens[currQueen])==(currQueen-posQueen)) //Check if queens are in upper diagonals
                return false;
            else if ((queens[currQueen]-queens[posQueen])==(currQueen-posQueen)) //Check if queens are in lower diagonals
                return false;
        }
        return true; //Okay if no queens are in the way
    }
}
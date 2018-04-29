import java.io.*;

public class Main {
    public static void main(String[] args) {
        File root = new File(args[0]); // Create new File obj with inputted filepath
        StringBuffer tree = new StringBuffer(); // Stringbuffer for creating tree
        if (!root.exists()) { // If invalid filepath
            throw new IllegalArgumentException("No dir here");
        } else {
            tree.append(root.getPath() + ":\n"); // Start with inputted filepath
            getDir(root, tree, 0); // Call method to construct tree
            try {
                BufferedWriter write = new BufferedWriter(new FileWriter("dir_tree.txt")); // Create new txt file for output
                write.append(tree); // Write stringbuffer to txt file
                write.close(); // Close
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        // System.out.println(tree);
    }

    // This method takes 3 variables: the File obj, the StringBuffer obj, and an int that designates 
    // the level of the directory
    public static void getDir(File root, StringBuffer write, int level) {
        for (File file : root.listFiles()) { // Get list of dir/file in current File obj and assign temp File to each per loop
            for (int i=0; i<level; i++) // For each dir sublevel, output an indentation
                write.append("   ");
            if (file.isDirectory()) { // If current File is a directory path...
                write.append("|--"); // output branch
                write.append(file.getName()+"/\n"); // Get directory name
                getDir(file, write, level+1); // And call getDir method recursively with sublevel+1 to get dir/files in this dir
            } else if (file.isFile()) { // If File is a file...
                write.append("|--"); // output branch
                write.append(file.getName()+"\n"); // and filename
            }
        }
    }
}
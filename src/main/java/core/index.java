package core;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.util.Scanner;

public class index {


    static void dataset_creater(int number,int max,int min){
        try {
            String pathname = "dataset.txt";
            File myObj = new File(pathname);
            myObj.createNewFile();
            PrintWriter writer = new PrintWriter(pathname, "UTF-8");

            for (int i = 0; i < number; i++) {
                int data=(int) ((Math.random() * (max+ 1 - min)) + min);
                writer.println(data);
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println(
                    "1 Create a random list of integers\n" +
                    "2 Display the random list (for debugging purposes only)\n" +
                    "3 Run 2PMMS\n" +
                    "4 Exit"
            );
            int input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.println("Dataset Size:");
                    int n = sc.nextInt();
                    System.out.println("Maximum Number:");
                    int max = sc.nextInt();
                    System.out.println("Minimum Number:");
                    int min = sc.nextInt();
                    dataset_creater(n,max,min);
                    System.out.println("Dataset Created!!");
                    break;
                case 2:
                    System.out.println("need to be done");
                    break;
                case 3:
                    System.out.println("need to be done");
                    break;
                default:
                    exit = true;
            }

        }

    }
}

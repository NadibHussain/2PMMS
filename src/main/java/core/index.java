package core;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    static void read_dataset(){
        try {
            File myObj = new File("dataset.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static int[] sorter(String data){
        String[] str_data = data.split("\\s+");
        StringBuilder str_out = new StringBuilder();
        int[] int_data = new int[str_data.length];
        for (int i = 0; i < str_data.length; i++) {
            int_data[i] = Integer.parseInt(str_data[i]);
        }
        Arrays.sort(int_data);
        for (int i = 0; i < int_data.length; i++) {
            str_out.append(int_data[i]).append(" ");
        }
        System.out.print(str_out);
        System.out.println();
        System.out.println("---------------");
        return int_data;
    }

    static void sorted_dataset_creator(int memory_size){
        try {
            String input_pathname = "dataset.txt";
            File inputfile = new File(input_pathname);
            Scanner input_reader = new Scanner(inputfile);
            String data_line = "";
            ArrayList<int[]> input_matrix = new ArrayList<>();
            ArrayList<int[]> output_matrix = new ArrayList<>();

            System.out.println("Phase 1 Start");
            while (input_reader.hasNextLine()){
                for (int i = 0; i < memory_size; i++) {
                    if(input_reader.hasNextLine()){
                        String data = input_reader.nextLine();
                        data_line = data_line.concat(data+" ");
                    }
                    else {
                        break;
                    }
                }
//                TimeUnit.SECONDS.sleep(1);
                System.out.println(data_line);
                input_matrix.add(sorter(data_line));
                data_line="";
            }

            input_reader.close();
            System.out.println("Phase 1 end");
            int pass_counter = 1;
            boolean first_time = true;
            while (output_matrix.size()!=1){

                while (!input_matrix.isEmpty()){

                    ArrayList<int[]> merge_list = new ArrayList<>();
                    for (int i = 0; i < memory_size; i++) {
                        if (!input_matrix.isEmpty()){
                            merge_list.add(input_matrix.remove(0));
                        }
                        else {
                            break;
                        }
                    }
//                merge sort here and save it into output matrix
                }

            }


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
                    read_dataset();
                    break;
                case 3:
                    System.out.println("Memory Size:");
                    n = sc.nextInt();
                    sorted_dataset_creator(n);
                    break;
                default:
                    exit = true;
            }

        }

    }
}

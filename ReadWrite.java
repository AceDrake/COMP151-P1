import java.io.*;
import java.util.Scanner;
public class ReadWrite {

        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                //start user input
                System.out.println("\t\t\t\tFile Cleanup Tool\nOperation Tips:\n"
                                + "File should only contain"+
                                "ints seperated by commas and be sorted in ascending order. Be careful when spelling and include extensions.\n"
                + "Application will create a new file with new data. To overwrite existing file, write the old file name when prompted.");
                	//collect filenames
                System.out.println("Enter file name.");
                String filename = scan.nextLine();
                System.out.println("Enter name of new file.");
                String nuFilename = scan.nextLine();
                boolean gate = false;
                //reevaluate if filenotfound
                while(!gate) {
                        try {
                             	Scanner scan2 = new Scanner(new FileInputStream(filename));
                                scan2.useDelimiter(",");
                                PrintWriter printerer = new PrintWriter(new FileOutputStream(nuFilename));
                                int a = (scan2.nextInt()); //set initial condition 
                                printerer.print(a+ ",");
                                while(scan2.hasNextInt()) { //parse input and select unique numbers for selection 
                                int b = scan2.nextInt();
                                if (a != b){
                                System.out.println(b);
                                printerer.print(b + ",");
                                a = b;
                                }
                                }
                                gate = true; //breakout
                                scan2.close();
                                printerer.close();
                        }
                        catch(FileNotFoundException e) {
                                System.out.println("File Not Found. Please try again.");
                                System.out.println("Enter file name.");
                            filename = scan.nextLine();
                            if (filename.equals("break")) {
                                        gate = true;   //relief valve in case of infinite loop
                                }
                        }//system success
                }
                System.out.println("New File " + nuFilename + " created. Thank you for using File Cleanup Tool.");
        }

}//end file

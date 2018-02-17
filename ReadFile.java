import java.io.*;
import java.util.*;
public class ReadFile {
	public static int[] txtRead(){

		Scanner scan = new Scanner(System.in);
		BufferedReader readerer;
		int[] fileArray; 
		int a;
		boolean b = false;
		while(b == false)
		System.out.println("Enter file name.");
	    string filename = scan.nextLine(); //input file name
		try{
		readerer = new BufferedReader(new FileReader(fileName));
		if (filename == "break") {
			b = true;
			//relief valve in case of infinite loop
		}
		//transfer int to array
			try{
			while(read.){
			a++; 
			} 
			fileArray = new int[a - 1];
			for(int i = 0;i < a; i++){
			fileArray[i] = read.nextInt();
			}
			}
			//clean break, file read properly 
			finally {
				b = true;
			}
		}
		//FNF error, loop back to start
		catch(FileNotFoundException e) {
			System.out.println("File Not Found. Please try again.");
		}//break out of loop if EOF found
		catch(EOFException e) {
			b = true;
		}
		//other error,  
		catch(IOException e) {
			System.out.print("Unknown Input Error. Restart application.");
			System.exit(1);
		}
		return fileArray;	
		}
	public static void txtWrite(int[] fileArray, String newFile) {
		PrintWriter printerer = new PrintWriter(new FileWriter(newFile + ".txt"));
		//write sorted values to new document
		try {
		for(int i:fileArray) {
			printerer.print(fileArray[i] + ", ");
		}
	}
		//basic emergency catch
		catch(IOException e){
			System.out.println("Unknown Input Error. Restart application.");
			System.exit(1);
		}
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan2 = new Scanner(System.in);
boolean flag = false;
int[] shuttle;
System.out.println("\t\tFile Cleanup Tool\nOperation Tips:\nFile must contain int values in sequential order.\n"
		+ "File name should be written without extensions and should refrence a real file.\n"
		+ "Application will create a new file with new data. To overwrite existing file, write the old file name when prompted.");
do {
System.out.print("Enter \"Binary\" for .bin files and \"Text\" for .txt files");
String whichFile = scan2.nextLine().toLowerCase();
if(whichFile.equals("binary")){
	//direct to binRead, in development
	flag = true;
}
if(whichFile.equals("text")) {
	shuttle = ReadFile.txtRead();
	flag = true;
	System.out.println("Enter new file name. To overwrite old file, enter old file name");
	String nuFileTxt = scan2.nextLine();
	ReadFile.txtWrite(shuttle, nuFileTxt);
	System.out.println("New file"+ nuFileTxt + ".txt has been created.");
}
if(flag == false) {
	System.out.println("Unrecognized file type. Please enter \"Binary\" for .bin files and \"Text\" for .txt files");
}
	}
while(flag == false);
System.out.println("Thank you for using File Cleanup Tool.");
}
}

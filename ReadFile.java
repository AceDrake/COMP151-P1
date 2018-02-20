import java.io.*;
import java.util.*;
public class ReadFile {
	
	public static int[] txtRead(int x, String filename){
		Scanner scan;
		int a = 0;
		boolean b = false;
		int[] fileArray = {0};
	    Scanner scan4 = new Scanner(System.in);
		while(!b) {
	    		fileArray = new int[x];
	    		try{
	    			scan = new Scanner(new FileInputStream("C:\\Users\\Deab Lockwood\\eclipse-workspace\\Project 1\\test2.txt"));
	    			scan.useDelimiter(",");
	    			//for(int i = 0; i < 12; i++){
	    			while(scan.hasNextInt()) {
	    			       // System.out.println(scan.nextInt());
	    			        fileArray[a] = scan.nextInt();
	    			       // System.out.println(fileArray[a]);
	    			        a++;

	    			}
	    			b = true;
	    	//	scan4.close();
	    	}
	    		
		//FNF error, loop back to start
	    	  catch(FileNotFoundException e) {
			System.out.println("File Not Found. Please try again.");
			System.out.println("Enter file name.");
		    filename = scan4.nextLine();
		    if (filename.equals("break")) {
				b = true;
				//relief valve in case of infinite loop
			}
	    	  }
	    	catch(NoSuchElementException e){
	    		b = true;
	    		}
	 
		//}//break out of loop if EOF found
		
		//other error,  
	/*	catch(IOException e) {
			System.out.print("Unknown Input Error. Restart application.");
			System.exit(1);
		}*/
		
		}
//		scan.close();
		return fileArray;
		}
	public static int[] compSort(int[] prev){
        //sort array
		for (int l = 0; l < prev.length; l++) {
			for(int e = (l + 1); e < prev.length; e++){
			                while(prev[l] > prev[e]){
			                                int r = prev[l];
			                                prev[l] = prev[e];
			                                prev[e] = r;
			                        }
			}
			                        }
		//delete extra numbers and copy to new array mod
		int[] mod = new int[prev.length];
        int d = 0;//count mod location
        int e = 0;//count numbers skipped
        for(int i = 0; i < prev.length - 1; i++){
       if(prev[i] != prev[(i + 1)]) {
    	   mod[d] = prev[i];
    	   d++;//move to fill next location
                }
       else {
    	   e++;//remain at location and note skipped number
    	   
       }
      mod[d] = prev[prev.length - 1];
        }
        
        	if(e > 0) { //truncate extra unfilled cells in mod
        int[] concat = new int[prev.length - e];
        for(int k = 0; k < concat.length; k++){  //copy old array to properly sized array
        concat[k] = mod[k];
        }
        return concat;
        }
        return mod; //return array if no skipped numbers
}
	
	
	public static void txtWrite(int[] fileArray, String newFile) {
		PrintWriter printerer; 
		String fileCont = ("" + fileArray[1]);
		for(int y = 1; y < fileArray.length - 1; y++) {
			fileCont = (fileCont + "," + fileArray[y]);
		}
		fileCont = (fileCont + fileArray[fileArray.length - 1]); 
		//write sorted values to new document
		try {
		printerer = new PrintWriter(new FileWriter(newFile + ".txt"));	
	printerer.write(fileCont);
		
		printerer.close();	
	}
		//basic emergency catch
		catch(IOException e){
			System.out.println("Unknown Input Error. Restart application.");
			System.exit(1);
		}
		}
	
	public static int[] binRead() {
		Scanner scan = new Scanner(System.in);
		//Scanner scan4 = new Scanner(System.in, ) 
		int a = 0;
		boolean b = false;
		int[] fileArray;
		System.out.println("Enter file name.");
	    String fileName = scan.nextLine(); //input file name
		while(!b) {
	    try{
	    	InputStream stream = new FileInputStream(fileName);
		//transfer int to array
			
				 while(stream.read() > -1) {
				        a++;
				    }
					fileArray = new int[a - 1];	 
			for(int i = 0;i < a; i++){
			int c = stream.read();
				c =	fileArray[i];
			}
			stream.close();
			return fileArray;
			//clean break, file read properly 
		}
		//FNF error, loop back to start
		catch(FileNotFoundException e) {
			System.out.println("File Not Found. Please try again.");
			System.out.println("Enter file name.");
		    fileName = scan.nextLine();
		    if (fileName.equals("break")) {
				b = true;
				//relief valve in case of infinite loop
			}
		}//break out of loop if EOF found
		catch(EOFException e) {
			b = true;
		}
		//other error,  
		catch(IOException e) {
			System.out.print("Unknown Input Error. Restart application.");
			System.exit(1);
		}
		
		}
		int[] fail = {0};
		System.out.println("fail");
		return fail;
		}
		
	public static void binWrite(int[] fileArray, String fileName) {
		try {
			OutputStream out = new FileOutputStream(fileName);
			for(int i : fileArray) {
				out.write(fileArray[i]);
			}
			}
		//basic emergency catch
				catch(IOException e){
					System.out.println("Unknown Input Error. Restart application.");
					System.exit(1);
				}
		}
	
	
	
	public static void main(String[] args) {
Scanner scan2 = new Scanner(System.in);
boolean flag = false;
int[] shuttle;
//user instructions
System.out.println("\t\t\t\t\t\tFile Cleanup Tool\nOperation Tips:\n"
		+ "File name should be written without extensions and should refrence a real file. Be careful when spelling.\n"
		+ "Application will create a new file with new data. To overwrite existing file, write the old file name when prompted.");
//loop breaks when filename is correct
do {
System.out.print("Enter \"Binary\" for .bin files and \"Text\" for .txt files. Press E to exit.");
String whichFile = scan2.nextLine().toLowerCase();//user chooses file type
if(whichFile.equals("binary")){
	shuttle = ReadFile.binRead();
	ReadFile.compSort(shuttle);
	flag = true;
	System.out.println("Enter new file name. To overwrite old file, enter old file name");
	String nuFileBin = scan2.nextLine();
	System.out.println("Create binary or text file?");
	String resp = scan2.nextLine();
	int w = 0;
	while(w == 0) {
	if(resp.equals("binary")){
	ReadFile.binWrite(shuttle, nuFileBin);
	System.out.println("New file "+ nuFileBin + ".bin has been created.");
	w++;
	}
	if(resp.equals("text")) {
		ReadFile.binWrite(shuttle, nuFileBin);
		System.out.println("New file "+ nuFileBin + ".txt has been created.");	
		w++;
	}
	else {
		System.out.println("Unrecognized submission. Try again.");
	}
}
}
if(whichFile.equals("text")) {//direct to txtRead/Write
	System.out.println("Enter file name.");
    String filename = scan2.nextLine(); //input file name
    System.out.println("Enter number of values.");
    int f = scan2.nextInt(); 
	shuttle = ReadFile.txtRead(f, filename);
	ReadFile.compSort(shuttle);
    for (int q = 0; q < shuttle.length; q++) {
		System.out.println(shuttle[q]);
	}
	flag = true;
	System.out.println("Enter new file name. To overwrite old file, enter old file name");
	String nuFileTxt = scan2.nextLine();
	System.out.println("Create binary or text file?");
	String resp = scan2.nextLine();
	int w = 0;
	while(w == 0) {
	if(resp.equals("binary")){
	ReadFile.binWrite(shuttle, nuFileTxt);
	System.out.println("New file "+ nuFileTxt + ".bin has been created.");
	w++;
	}
	if(resp.equals("text")) {
		ReadFile.binWrite(shuttle, nuFileTxt);
		System.out.println("New file "+ nuFileTxt + ".txt has been created.");	
		w++;
	}
	else {
		System.out.println("Unrecognized submission. Try again.");
	}
	}
}
if(whichFile.equals("e")) {//breakout valve
	flag = true;
}
if(flag == false) {
	System.out.println("Unrecognized file type. Please resubmit");
}
	}
while(flag == false);//end application
scan2.close();
System.out.println("Thank you for using File Cleanup Tool.");
}
}//end file

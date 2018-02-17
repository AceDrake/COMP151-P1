
public class Compress2 {
	
	public static int[] compSort(int[] prev){
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

	public static void main(String[] args) {

		//in full program, test will be the written from the document user specifies. test2 will be written to the final document.
			int[] test = {1, 1, 2, 3, 3, 3, 4, 5, 5, 6, 23};

			int[] test2 = Compress2.compSort(test);

			for(int i1 = 0; i1 < test2.length; i1++){
			System.out.print(test2[i1] + " ");
			}
			}

			}

	



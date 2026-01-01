package MovieStoreSystem;
import java.util.ArrayList;
import java.util.Scanner;
public class MovieStoreSystemBeforeRefactoring {
	public static void main(String[] args) {
		
		//This code is to add movie titles to the movie store and sort them
		ArrayList<String> MST = new ArrayList<String>(); // an array list of movie titles
		String nmt; //A variable to add a new movie title
		String elementToSearch = null;
		Boolean Found;
		System.out.println("Create the movies list by entering the movie titles one by one");		
		System.out.println("Enter a movie title to be added to the movie store");
		Scanner input = new Scanner(System.in);		
		nmt = input.next();		
		while (!(nmt.equals("end"))) {		
			MST.add(nmt);
			System.out.print("Enter a movie title to be added to the movie store");
			nmt = input.next();			
			}
		System.out.println("The movie titles in the movie store before sorting are: ");
		   for(String counter: MST){
				System.out.println(counter);
			}
		 //bubble sort--------------------------------------------------
		   boolean sorted = false;
		    String temp = null;
		    while(!sorted) {
		        sorted = true;
		        for (int i = 0; i < MST.size() - 1; i++) {		           
		        	if((MST.get(i)).compareToIgnoreCase(MST.get(i+1))>0) {
		                temp = MST.get(i);
		                MST.set(i,MST.get(i+1));
		                MST.set(i+1,temp);
		                sorted = false;
		            }
		        }
		    }
		 //-------------------------------------------------------
		 System.out.println("The movie titles in the movie store after sorting are: ");
		   for(String counter: MST){
				System.out.println(counter);
			}  	   
		 //This code is to add members to the movie store and sort them
			ArrayList<String> MSM = new ArrayList<String>();// an array list of movie store members
			String nMn;//A variable to add a new member name
			System.out.println("Create the members list by entering the member names one by one");		
			System.out.println("Enter a member name to be added to the movie store system");
			input = new Scanner(System.in);		
			nMn = input.next();		
			while (!(nMn.equals("end"))) {		
				MSM.add(nMn);
				System.out.print("Enter a member name to be added to the movie store");
				nMn = input.next();			
				}
			System.out.println("The members in the movie store before sorting are: ");
			   for(String counter: MSM){
					System.out.println(counter);
				}
			 //bubble sort--------------------------------------------------
			   sorted = false;
			   temp = null;
			    while(!sorted) {
			        sorted = true;
			        for (int i = 0; i < MSM.size() - 1; i++) {		           
			        	if((MSM.get(i)).compareToIgnoreCase(MSM.get(i+1))>0) {
			                temp = MSM.get(i);
			                MSM.set(i,MSM.get(i+1));
			                MSM.set(i+1,temp);
			                sorted = false;
			            }
			        }
			    }
			 //-------------------------------------------------------
			 System.out.println("The members in the movie store after sorting are: ");
			   for(String counter: MSM){
					System.out.println(counter);
				}		   
			  			   
			 //This code is to search for a specific movie title
		     System.out.println("Enter a movie title to search for:");
			   elementToSearch = input.next();	
			   Found = false;	
			   
		   //Linear Search----------------------------------------------
		   for (int index = 0; index < MST.size(); index++) {
		        if (MST.get(index).equals(elementToSearch)) 
		        	Found = true;     
		    }
		   //------------------------------------------------------------
		   if (Found == true)
		       System.out.println("The movie title is found");
		   else if (Found == false)
				   System.out.println("The movie title is not found");
		   //--------------------------------------------------------------
		   
		 //This code is to search for a specific member
		     System.out.println("Enter a member name to search for:");
			   elementToSearch = input.next();	
			   Found = false;	
			   
		   //Linear Search----------------------------------------------
		   for (int index = 0; index < MSM.size(); index++) {
		        if (MSM.get(index).equals(elementToSearch)) 
		        	Found = true;     
		    }
		   //------------------------------------------------------------
		   if (Found == true)
		       System.out.println("The member is found");
		   else if (Found == false)
				   System.out.println("The member is not found");
		   //--------------------------------------------------------------
	}
}

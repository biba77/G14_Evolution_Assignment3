package MovieStoreSystem;
import java.util.ArrayList;
import java.util.Scanner;
public class Phase1_R1R2 {
    public static void main(String[] args) {
        
        //This code is to add movie titles to the movie store and sort them
        ArrayList<String> movieTitles = new ArrayList<String>(); // an array list of movie titles
        String newMovieTitle; //A variable to add a new movie title
        String movieToSearch = null;
        String memberToSearch = null;
        Boolean isMovieFound;
        Boolean isMemberFound;
        System.out.println("Create the movies list by entering the movie titles one by one");		
        System.out.println("Enter a movie title to be added to the movie store");
        Scanner input = new Scanner(System.in);		
        newMovieTitle = input.next();		
        while (!(newMovieTitle.equals("end"))) {		
            movieTitles.add(newMovieTitle);
            System.out.print("Enter a movie title to be added to the movie store");
            newMovieTitle = input.next();			
        }
        System.out.println("The movie titles in the movie store before sorting are: ");
        for(String counter: movieTitles){
            System.out.println(counter);
        }
        //bubble sort--------------------------------------------------
        boolean moviesSorted = false;
        String movieTemp = null;
        while(!moviesSorted) {
            moviesSorted = true;
            for (int i = 0; i < movieTitles.size() - 1; i++) {		           
                if((movieTitles.get(i)).compareToIgnoreCase(movieTitles.get(i+1))>0) {
                    movieTemp = movieTitles.get(i);
                    movieTitles.set(i,movieTitles.get(i+1));
                    movieTitles.set(i+1,movieTemp);
                    moviesSorted = false;
                }
            }
        }
        //-------------------------------------------------------
        System.out.println("The movie titles in the movie store after sorting are: ");
        for(String counter: movieTitles){
            System.out.println(counter);
        }  	   
        //This code is to add members to the movie store and sort them
        ArrayList<String> members = new ArrayList<String>();// an array list of movie store members
        String newMemberName;//A variable to add a new member name
        System.out.println("Create the members list by entering the member names one by one");		
        System.out.println("Enter a member name to be added to the movie store system");
        input = new Scanner(System.in);		
        newMemberName = input.next();		
        while (!(newMemberName.equals("end"))) {		
            members.add(newMemberName);
            System.out.print("Enter a member name to be added to the movie store");
            newMemberName = input.next();			
        }
        System.out.println("The members in the movie store before sorting are: ");
        for(String counter: members){
            System.out.println(counter);
        }
        //bubble sort--------------------------------------------------
        boolean membersSorted = false;
        String memberTemp = null;
        while(!membersSorted) {
            membersSorted = true;
            for (int i = 0; i < members.size() - 1; i++) {		           
                if((members.get(i)).compareToIgnoreCase(members.get(i+1))>0) {
                    memberTemp = members.get(i);
                    members.set(i,members.get(i+1));
                    members.set(i+1,memberTemp);
                    membersSorted = false;
                }
            }
        }
        //-------------------------------------------------------
        System.out.println("The members in the movie store after sorting are: ");
        for(String counter: members){
            System.out.println(counter);
        }		   
        
        //This code is to search for a specific movie title
        System.out.println("Enter a movie title to search for:");
        movieToSearch = input.next();	
        isMovieFound = false;	
        
        //Linear Search----------------------------------------------
        for (int index = 0; index < movieTitles.size(); index++) {
            if (movieTitles.get(index).equals(movieToSearch)) 
                isMovieFound = true;     
        }
        //------------------------------------------------------------
        if (isMovieFound == true)
            System.out.println("The movie title is found");
        else if (isMovieFound == false)
            System.out.println("The movie title is not found");
        //--------------------------------------------------------------
        
        //This code is to search for a specific member
        System.out.println("Enter a member name to search for:");
        memberToSearch = input.next();	
        isMemberFound = false;	
        
        //Linear Search----------------------------------------------
        for (int index = 0; index < members.size(); index++) {
            if (members.get(index).equals(memberToSearch)) 
                isMemberFound = true;     
        }
        //------------------------------------------------------------
        if (isMemberFound == true)
            System.out.println("The member is found");
        else if (isMemberFound == false)
            System.out.println("The member is not found");
        //--------------------------------------------------------------
    }
}
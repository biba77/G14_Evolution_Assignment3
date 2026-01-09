package com.example.MovieStoreSystem; 
import java.util.ArrayList; 
import java.util.Scanner; 
public class Phase2_R3 {     
    // -----------------------Sorting Method For Movies------------------------- 
    //Movie Sort Method: Takes movie list and returns sorted version 
    public static ArrayList<String> sortMovieTitles(ArrayList<String> movies) { 
        ArrayList<String> sortedMovies = new ArrayList<>(movies); //Create new list so that original list is not modified 
        boolean moviesSorted = false; //Control variable for outer loop 

        //Keep looping until no swaps needed 
        while (!moviesSorted) { 
            moviesSorted = true; 
            //Check each element with its neighbour 
            for (int i = 0; i < sortedMovies.size() - 1; i++) { 
                if (sortedMovies.get(i).compareToIgnoreCase(sortedMovies.get(i + 1)) > 0) { 
                    String movieTemp = sortedMovies.get(i); 
                    sortedMovies.set(i, sortedMovies.get(i + 1)); 
                    sortedMovies.set(i + 1, movieTemp); 
                    moviesSorted = false; 
                } 
            } 
        } 
        return sortedMovies; 
    } 
     
    // ------------------------Sorting Method for Members------------------------ 
    //Member Sort Method: Takes member list and returns sorted version 
    public static ArrayList<String> sortMembers(ArrayList<String> members) { 
        ArrayList<String> sortedMembers = new ArrayList<>(members); // Create a copy 
        boolean membersSorted = false;          
        while (!membersSorted) { 
            membersSorted = true; 
            for (int i = 0; i < sortedMembers.size() - 1; i++) { 
                if (sortedMembers.get(i).compareToIgnoreCase(sortedMembers.get(i + 1)) > 0) { 
                    // Swap 
                    String memberTemp = sortedMembers.get(i); 
                    sortedMembers.set(i, sortedMembers.get(i + 1)); 
                    sortedMembers.set(i + 1, memberTemp); 
                    membersSorted = false; 
                } 
            } 
        } 
        return sortedMembers; 
    } 
     
    // --------------------------------Search Method For Movies--------------------------- 
    //Movie Search Method: Checks if movie exists in list 
    public static boolean searchMovieTitle(ArrayList<String> movies, String movieToSearch) { 
        //Linear Search: Check every element from start to end 
        for (int index = 0; index < movies.size(); index++) { 
            if (movies.get(index).equalsIgnoreCase(movieToSearch)) { 
                return true; // Found 
            } 
        } 
        return false; // Not found 
    } 
     
    // ------------------------------------Search Method for Members---------------------------- 
    //Member Search Method: Checks if member exists in list 
    public static boolean searchMember(ArrayList<String> members, String memberToSearch) { 
        for (int index = 0; index < members.size(); index++) { 
            if (members.get(index).equalsIgnoreCase(memberToSearch)) { 
                return true; // Found 
            } 
        } 
        return false; // Not found 
    } 
     
    // --------------------------Main Method----------------------------------- 
    public static void main(String[] args) { 
        // This code is to add movie titles to the movie store 
        ArrayList<String> movieTitles = new ArrayList<String>(); 
        String newMovieTitle; 
        String movieToSearch = null; 
        String memberToSearch = null; 
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
        for (String title : movieTitles) { 
            System.out.println(title); 
        } 

        // ---------------Using Movies Sorting Method---------------------------- 
        ArrayList<String> sortedMovies = sortMovieTitles(movieTitles); 
        System.out.println("The movie titles in the movie store after sorting are: "); 
        for (String title : sortedMovies) { 
            System.out.println(title); 
        } 
        // This code is to add members to the movie store 
        ArrayList<String> members = new ArrayList<String>(); 
        String newMemberName; 
        System.out.println("Create the members list by entering the member names one by one");       
        System.out.println("Enter a member name to be added to the movie store system"); 
        newMemberName = input.next();       
        while (!(newMemberName.equals("end"))) {        
            members.add(newMemberName); 
            System.out.print("Enter a member name to be added to the movie store"); 
            newMemberName = input.next();           
        }
        System.out.println("The members in the movie store before sorting are: "); 
        for (String member : members) { 
            System.out.println(member); 
        } 

        // -----------------------------Using Members Sorting Method-------------------------------- 
        ArrayList<String> sortedMembers = sortMembers(members); 
        System.out.println("The members in the movie store after sorting are: "); 
        for (String member : sortedMembers) { 
            System.out.println(member); 
        } 

        // -----------------------------Using Movies Search Method-------------------------------- 
        System.out.println("Enter a movie title to search for:"); 
        movieToSearch = input.next(); 
        boolean isMovieFound = searchMovieTitle(sortedMovies, movieToSearch); 
        if (isMovieFound) { 
            System.out.println("The movie title is found"); 
        } else { 
            System.out.println("The movie title is not found"); 
        } 

        // -------------------------------Using Members Search Method------------------------------------ 
        System.out.println("Enter a member name to search for:"); 
        memberToSearch = input.next(); 
        boolean isMemberFound = searchMember(sortedMembers, memberToSearch); 
        if (isMemberFound) { 
            System.out.println("The member is found"); 
        } else { 
            System.out.println("The member is not found"); 
        } 
        input.close(); 
    } 
}

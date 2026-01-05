package MovieStoreSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Phase4_R5 {
    // -----------------------Sorting Method For Movies and Members-------------------------
    // Bubble Sort Method: Takes list of nameKey objects and returns sorted version
    public static <T extends nameKey> ArrayList<T> bubbleSort(ArrayList<T> objectToSort) { // <T> allows any class type
        ArrayList<T> sortedList = new ArrayList<T>(objectToSort); // Create new list so that original list is not modified
                                                                  
        boolean isSorted = false; // Control variable for outer loop
        while (!isSorted) {
            isSorted = true;
            // Check each element with its neighbour
            for (int i = 0; i < sortedList.size() - 1; i++) {
                if (sortedList.get(i).getNameValue().compareToIgnoreCase(sortedList.get(i + 1).getNameValue()) > 0) { // getNameValue retrieves the name key from the Class
                    T temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(i + 1));
                    sortedList.set(i + 1, temp);
                    isSorted = false;
                }

            }
        }
        return sortedList;
    }
    // --------------------------------Search Method For Movie and Members--------------------------- 
    // Search Method: Checks if movie or member exists in list 
    public static <T extends nameKey> boolean linearSearch(ArrayList<T> objectToSearch, String valueToSearch) {
        for (T item : objectToSearch) {
            if (item.getNameValue().equalsIgnoreCase(valueToSearch)) { // getNameValue retrieves the name key from the Class
                return true;
            }
        }
        return false;
    }
    // --------------------------Main Method----------------------------------- 
    public static void main(String[] args) { 
        // This code is to add movie titles to the movie store 
        Scanner input = new Scanner(System.in); 
        ArrayList<Movie> movies = new ArrayList<>();
        System.out.println("Create the movies list by entering the movie titles one by one"); 
        System.out.println("Enter a movie title to be added to the movie store (type 'end' to finish):"); 
        String movieInput = input.next();
        while (!movieInput.equals("end")) { 
            movies.add(new Movie(movieInput)); 
            System.out.print("Enter a movie title to be added to the movie store (type 'end' to finish): "); 
            movieInput = input.next(); 
        } 
        System.out.println("The movie titles in the movie store before sorting are: "); 
        for (Movie movie : movies) { 
            System.out.println(movie.getTitle()); //**** 
        } 
        // ---------------Using bubbleSort for Movies ---------------------------- 
        ArrayList<Movie> sortedMovies = bubbleSort(movies); 
        System.out.println("The movie titles in the movie store after sorting are: "); 
        for (Movie movie : sortedMovies) { 
            System.out.println(movie.getTitle()); 
        } 

        // This code is to add members to the movie store 
        ArrayList<Member> members = new ArrayList<>();  
        System.out.println("Create the members list by entering the member names one by one"); 
        System.out.println("Enter a member name to be added to the movie store system (type 'end' to finish):"); 
        String memberInput = input.next(); 
        while (!memberInput.equals("end")) { 
            members.add(new Member(memberInput)); 
            System.out.print("Enter a member name to be added to the movie store (type 'end' to finish): "); 
            memberInput = input.next(); 
        }
        System.out.println("The members in the movie store before sorting are: "); 
        for (Member member : members) { 
            System.out.println(member.getName()); 
        } 
        // -----------------------------Using bubbleSort for Members -------------------------------- 
        ArrayList<Member> sortedMembers = bubbleSort(members); 
        System.out.println("The members in the movie store after sorting are: "); 
        for (Member member: sortedMembers) { 
            System.out.println(member.getName()); 
        } 

        // -----------------------------Using linear Search For Movies -------------------------------- 
        System.out.println("Enter a movie title to search for: "); 
        String movieToSearch = input.next(); 
        boolean isMovieFound = linearSearch(sortedMovies, movieToSearch); 
        if (isMovieFound) { 
            System.out.println("The movie title is found"); 
        } else { 
            System.out.println("The movie title is not found"); 
        } 

        // -------------------------------Using linear Search For Members------------------------------------ 
        System.out.println("Enter a member name to search for: "); 
        String memberToSearch = input.next(); 
        boolean isMemberFound = linearSearch(sortedMembers, memberToSearch); 
        if (isMemberFound) { 
            System.out.println("The member is found"); 
        } else { 
            System.out.println("The member is not found"); 
        } 
        input.close(); 
    } 
    
}
// -----------------------nameKey Class-------------------------
    // Allows the bubbleSort and linearSearch methods to work with different object types with different sort keys getters
abstract class nameKey {
        public abstract String getNameValue();
}
    // -----------------------Movie Class-------------------------
class Movie extends nameKey {
        private String title;

        public Movie(String title) {
            this.title = title;
        }

        // getter
        public String getTitle() {
            return title;
        }

        @Override
        public String getNameValue() {
            return title;
        }
    }

    // --------------------Member Class--------------------
class Member extends nameKey {
        private String name;

        public Member(String name) {
            this.name = name;
        }

        // getter
        public String getName() {
            return name;
        }

        @Override
        public String getNameValue() {
            return name;
        }
    }
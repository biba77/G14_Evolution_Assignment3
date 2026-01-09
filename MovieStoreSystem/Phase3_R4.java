package MovieStoreSystem; 
import java.util.ArrayList; 
import java.util.Scanner; 
public class Phase3_R4 {     
    // -----------------------Sorting Method For Movies------------------------- 
    //Movie Sort Method: Takes movie list and returns sorted version 
    public static ArrayList<Movie> sortMovies(ArrayList<Movie> movies) { 
        ArrayList<Movie> sortedMovies = new ArrayList<>(movies); //Create new list so that original list is not modified 
        boolean moviesSorted = false; //Control variable for outer loop 

        //Keep looping until no swaps needed 
        while (!moviesSorted) { 
            moviesSorted = true; 
            //Check each element with its neighbour 
            for (int i = 0; i < sortedMovies.size() - 1; i++) { 
                if (sortedMovies.get(i).getTitle().compareToIgnoreCase(sortedMovies.get(i + 1).getTitle()) > 0) { 
                    Movie temp = sortedMovies.get(i); 
                    sortedMovies.set(i, sortedMovies.get(i + 1)); 
                    sortedMovies.set(i + 1, temp);
                    moviesSorted = false; 
                } 
            } 
        } 
        return sortedMovies; 
    } 
     
    // ------------------------Sorting Method for Members------------------------ 
    //Member Sort Method: Takes member list and returns sorted version 
    public static ArrayList<Member> sortMembers(ArrayList<Member> members) { 
        ArrayList<Member> sortedMembers = new ArrayList<>(members); // Create a copy 
        boolean membersSorted = false;          
        while (!membersSorted) { 
            membersSorted = true; 
            for (int i = 0; i < sortedMembers.size() - 1; i++) { 
                if (sortedMembers.get(i).getName().compareToIgnoreCase(sortedMembers.get(i + 1).getName()) > 0) { 
                    // Swap 
                    Member temp = sortedMembers.get(i); 
                    sortedMembers.set(i, sortedMembers.get(i + 1)); 
                    sortedMembers.set(i + 1, temp); 
                    membersSorted = false; 
                } 
            } 
        } 
        return sortedMembers; 
    } 
     
    // --------------------------------Search Method For Movies--------------------------- 
    //Movie Search Method: Checks if movie exists in list 
    public static boolean searchMovieTitle(ArrayList<Movie> movies, String movieToSearch) { 
        //Linear Search: Check every element from start to end 
        for (Movie movie : movies) { 
            if (movie.getTitle().equalsIgnoreCase(movieToSearch)) { 
                return true; // Found 
            } 
        } 
        return false; // Not found 
    } 
     
    // ------------------------------------Search Method for Members---------------------------- 
    //Member Search Method: Checks if member exists in list 
    public static boolean searchMember(ArrayList<Member> members, String memberToSearch) { 
        for (Member member : members) { 
            if (member.getName().equalsIgnoreCase(memberToSearch)) { 
                return true; // Found 
            } 
        } 
        return false; // Not found 
    } 
     
    // --------------------------Main Method----------------------------------- 
    public static void main(String[] args) { 
        // This code is to add movie titles to the movie store 
        Scanner input = new Scanner(System.in); 
        ArrayList<Movie> movies = new ArrayList<>();
        System.out.println("Create the movies list by entering the movie titles one by one"); 
        System.out.println("Enter a movie title to be added to the movie store "); 
        String movieInput = input.next();
        while (!movieInput.equals("end")) { 
            movies.add(new Movie(movieInput)); 
            System.out.print("Enter a movie title to be added to the movie store "); 
            movieInput = input.next(); 
        } 
        System.out.println("The movie titles in the movie store before sorting are:"); 
        for (Movie movie : movies) { 
            System.out.println(movie.getTitle()); //**** 
        } 
        // ---------------Using Movies Sorting Method---------------------------- 
        ArrayList<Movie> sortedMovies = sortMovies(movies); 
        System.out.println("The movie titles in the movie store after sorting are:"); 
        for (Movie movie : sortedMovies) { 
            System.out.println(movie.getTitle()); 
        } 

        // This code is to add members to the movie store 
        ArrayList<Member> members = new ArrayList<>();  
        System.out.println("Create the members list by entering the member names one by one"); 
        System.out.println("Enter a member name to be added to the movie store system "); 
        String memberInput = input.next(); 
        while (!memberInput.equals("end")) { 
            members.add(new Member(memberInput)); 
            System.out.print("Enter a member name to be added to the movie store "); 
            memberInput = input.next(); 
        }
        System.out.println("The members in the movie store before sorting are: "); 
        for (Member member : members) { 
            System.out.println(member.getName()); 
        } 
        // -----------------------------Using Members Sorting Method-------------------------------- 
        ArrayList<Member> sortedMembers = sortMembers(members); 
        System.out.println("The members in the movie store after sorting are: "); 
        for (Member member: sortedMembers) { 
            System.out.println(member.getName()); 
        } 

        // -----------------------------Using Movies Search Method-------------------------------- 
        System.out.println("Enter a movie title to search for: "); 
        String movieToSearch = input.next(); 
        boolean isMovieFound = searchMovieTitle(sortedMovies, movieToSearch); 
        if (isMovieFound) { 
            System.out.println("The movie title is found"); 
        } else { 
            System.out.println("The movie title is not found"); 
        } 

        // -------------------------------Using Members Search Method------------------------------------ 
        System.out.println("Enter a member name to search for: "); 
        String memberToSearch = input.next(); 
        boolean isMemberFound = searchMember(sortedMembers, memberToSearch); 
        if (isMemberFound) { 
            System.out.println("The member is found"); 
        } else { 
            System.out.println("The member is not found"); 
        } 
        input.close(); 
    } 
} 

//--------------------Movie Class--------------------
class Movie{
    private String title;
    public Movie(String title){
        this.title = title;
    }
    //getter
    public String getTitle(){
        return title;
    }
}

//--------------------Member Class--------------------
class Member{
    private String name;
    public Member(String name){
        this.name = name;
    }
    //getter
    public String getName(){
        return name;
    }
}
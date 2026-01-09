package MovieStoreSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Phase5_R6 {
    // -----------------------Improved Sorting Method-------------------------
    // Merge Sort Implementation (O(n log n) - much faster than Bubble Sort)
    public static <T extends nameKey> ArrayList<T> mergeSort(ArrayList<T> objectToSort) {
        if (objectToSort.size() <= 1) {
            return new ArrayList<>(objectToSort);
        }
        
        ArrayList<T> sortedList = new ArrayList<>(objectToSort);
        mergeSortHelper(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }
    
    private static <T extends nameKey> void mergeSortHelper(ArrayList<T> list, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            
            mergeSortHelper(list, left, middle);
            mergeSortHelper(list, middle + 1, right);
            
            merge(list, left, middle, right);
        }
    }
    
    private static <T extends nameKey> void merge(ArrayList<T> list, int left, int middle, int right) {
        ArrayList<T> leftList = new ArrayList<>(list.subList(left, middle + 1));
        ArrayList<T> rightList = new ArrayList<>(list.subList(middle + 1, right + 1));
        
        int i = 0, j = 0, k = left;
        
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).getNameValue().compareToIgnoreCase(rightList.get(j).getNameValue()) <= 0) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }
    
    // -----------------------Improved Search Method-------------------------
    // Binary Search Implementation (O(log n) - much faster than Linear Search)
    // IMPORTANT: Requires list to be sorted first!
    public static <T extends nameKey> boolean binarySearch(ArrayList<T> objectToSearch, String valueToSearch) {
        int left = 0;
        int right = objectToSearch.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midValue = objectToSearch.get(mid).getNameValue();
            int comparison = midValue.compareToIgnoreCase(valueToSearch);
            
            if (comparison == 0) {
                return true; // Found
            } else if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return false; // Not found
    }
    
    // --------------------------Main Method-----------------------------------
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // This code is to add movie titles to the movie store
        ArrayList<Movie> movies = new ArrayList<>();
        System.out.println("Create the movies list by entering the movie titles one by one");
        System.out.println("Enter a movie title to be added to the movie store (type 'end' to finish):");
        String movieInput = input.nextLine().trim();
        
        while (!movieInput.equalsIgnoreCase("end")) {
            if (!movieInput.isEmpty()) {
                movies.add(new Movie(movieInput));
            }
            System.out.print("Enter a movie title to be added to the movie store (type 'end' to finish): ");
            movieInput = input.nextLine().trim();
        }
        
        System.out.println("\nThe movie titles in the movie store before sorting are: ");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
        
        // ---------------Using merge sort for Movies ----------------------------
        ArrayList<Movie> sortedMovies = mergeSort(movies);
        
        System.out.println("\nThe movie titles in the movie store after sorting are: ");
        for (Movie movie : sortedMovies) {
            System.out.println(movie.getTitle());
        }
        
        // This code is to add members to the movie store
        ArrayList<Member> members = new ArrayList<>();
        System.out.println("\nCreate the members list by entering the member names one by one");
        System.out.println("Enter a member name to be added to the movie store system (type 'end' to finish):");
        String memberInput = input.nextLine().trim();
        
        while (!memberInput.equalsIgnoreCase("end")) {
            if (!memberInput.isEmpty()) {
                members.add(new Member(memberInput));
            }
            System.out.print("Enter a member name to be added to the movie store (type 'end' to finish): ");
            memberInput = input.nextLine().trim();
        }
        
        System.out.println("\nThe members in the movie store before sorting are: ");
        for (Member member : members) {
            System.out.println(member.getName());
        }
        
        // ---------------Using merge sort for Members ----------------------------
        ArrayList<Member> sortedMembers = mergeSort(members);
        
        System.out.println("\nThe members in the movie store after sorting are: ");
        for (Member member : sortedMembers) {
            System.out.println(member.getName());
        }
        
        // ---------------Using binary search for Movies ----------------------------
        System.out.print("\nEnter a movie title to search for: ");
        String movieToSearch = input.nextLine().trim();
        boolean isMovieFound = binarySearch(sortedMovies, movieToSearch);
        
        if (isMovieFound) {
            System.out.println("The movie title is found");
        } else {
            System.out.println("The movie title is not found");
        }
        
        // ---------------Using binary search for Members ----------------------------
        System.out.print("\nEnter a member name to search for: ");
        String memberToSearch = input.nextLine().trim();
        boolean isMemberFound = binarySearch(sortedMembers, memberToSearch);
        
        if (isMemberFound) {
            System.out.println("The member is found");
        } else {
            System.out.println("The member is not found");
        }
        
        input.close();
    }
}

// -----------------------nameKey Class-------------------------
abstract class nameKey {
    public abstract String getNameValue();
}

// -----------------------Movie Class-------------------------
class Movie extends nameKey {
    private String title;
    
    public Movie(String title) {
        this.title = title;
    }
    
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
    
    public String getName() {
        return name;
    }
    
    @Override
    public String getNameValue() {
        return name;
    }
}
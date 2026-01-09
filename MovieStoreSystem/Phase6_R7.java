package MovieStoreSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Phase6_R7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create and populate movies list
        MovieInputHandler movieInputHandler = new MovieInputHandler(input);
        ArrayList<Movie> movies = movieInputHandler.collectMovies();

        System.out.println("\nThe movie titles in the movie store before sorting are: ");
        DisplayUtility.displayMovies(movies);

        // Sort movies using utility class
        ArrayList<Movie> sortedMovies = SortingUtility.mergeSort(movies);

        System.out.println("\nThe movie titles in the movie store after sorting are: ");
        DisplayUtility.displayMovies(sortedMovies);

        // Create and populate members list
        MemberInputHandler memberInputHandler = new MemberInputHandler(input);
        ArrayList<Member> members = memberInputHandler.collectMembers();

        System.out.println("\nThe members in the movie store before sorting are: ");
        DisplayUtility.displayMembers(members);

        // Sort members using utility class
        ArrayList<Member> sortedMembers = SortingUtility.mergeSort(members);

        System.out.println("\nThe members in the movie store after sorting are: ");
        DisplayUtility.displayMembers(sortedMembers);

        // Search for movie using Method Object
        MovieSearcher movieSearcher = new MovieSearcher(sortedMovies, input);
        movieSearcher.performSearch();

        // Search for member using Method Object
        MemberSearcher memberSearcher = new MemberSearcher(sortedMembers, input);
        memberSearcher.performSearch();

        input.close();
    }
}

// Sorting utilities
class SortingUtility {

    // Merge Sort Implementation (O(n log n) - It is much faster than Bubble Sort)
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

    // Using Java's built-in TimSort which is a hybrid of merge sort and insertion sort
    public static <T extends nameKey> ArrayList<T> quickSort(ArrayList<T> objectToSort) {
        ArrayList<T> sortedList = new ArrayList<>(objectToSort);
        sortedList.sort(Comparator.comparing(nameKey::getNameValue, String.CASE_INSENSITIVE_ORDER));
        return sortedList;
    }
}

// Search stuff
class SearchUtility {

    // Binary Search Implementation (O(log n) - much faster than Linear Search)
    // it requires list to be sorted first!
    public static <T extends nameKey> boolean binarySearch(ArrayList<T> objectToSearch, String valueToSearch) {
        int left = 0;
        int right = objectToSearch.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midValue = objectToSearch.get(mid).getNameValue();
            int comparison = midValue.compareToIgnoreCase(valueToSearch);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // Alternative: Using Java's built-in binary search with a custom comparator
    public static <T extends nameKey> boolean binarySearchBuiltIn(ArrayList<T> sortedList, String valueToSearch) {
        // Create a comparator that compares getNameValue() case-insensitively
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getNameValue().compareToIgnoreCase(o2.getNameValue());
            }
        };

        // We can't create a generic T instance, so we'll need to search manually
        // using the comparator
        return binarySearch(sortedList, valueToSearch);
    }
}

// Display helper
class DisplayUtility {

    public static void displayMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
    }

    public static void displayMembers(ArrayList<Member> members) {
        for (Member member : members) {
            System.out.println(member.getName());
        }
    }
}

// Handles movie input
class MovieInputHandler {
    private Scanner input;
    private ArrayList<Movie> movies;

    public MovieInputHandler(Scanner input) {
        this.input = input;
        this.movies = new ArrayList<>();
    }

    public ArrayList<Movie> collectMovies() {
        System.out.println("Create the movies list by entering the movie titles one by one");
        System.out.println("Enter a movie title to be added to the movie store");
        String movieInput = input.nextLine().trim();

        while (!movieInput.equalsIgnoreCase("end")) {
            if (!movieInput.isEmpty()) {
                movies.add(new Movie(movieInput));
            }
            System.out.print("Enter a movie title to be added to the movie store");
            movieInput = input.nextLine().trim();
        }

        return movies;
    }
}

// Handles member input
class MemberInputHandler {
    private Scanner input;
    private ArrayList<Member> members;

    public MemberInputHandler(Scanner input) {
        this.input = input;
        this.members = new ArrayList<>();
    }

    public ArrayList<Member> collectMembers() {
        System.out.println("\nCreate the members list by entering the member names one by one");
        System.out.println("Enter a member name to be added to the movie store system");
        String memberInput = input.nextLine().trim();

        while (!memberInput.equalsIgnoreCase("end")) {
            if (!memberInput.isEmpty()) {
                members.add(new Member(memberInput));
            }
            System.out.print("Enter a member name to be added to the movie store");
            memberInput = input.nextLine().trim();
        }

        return members;
    }
}

// Movie search
class MovieSearcher {
    private ArrayList<Movie> sortedMovies;
    private Scanner input;
    private String movieToSearch;
    private boolean isFound;

    public MovieSearcher(ArrayList<Movie> sortedMovies, Scanner input) {
        this.sortedMovies = sortedMovies;
        this.input = input;
    }

    public void performSearch() {
        promptForInput();
        executeSearch();
        displayResult();
    }

    private void promptForInput() {
        System.out.print("\nEnter a movie title to search for: ");
        movieToSearch = input.nextLine().trim();
    }

    private void executeSearch() {
        isFound = SearchUtility.binarySearch(sortedMovies, movieToSearch);
    }

    private void displayResult() {
        if (isFound) {
            System.out.println("The movie title is found");
        } else {
            System.out.println("The movie title is not found");
        }
    }
}

// Member search
class MemberSearcher {
    private ArrayList<Member> sortedMembers;
    private Scanner input;
    private String memberToSearch;
    private boolean isFound;

    public MemberSearcher(ArrayList<Member> sortedMembers, Scanner input) {
        this.sortedMembers = sortedMembers;
        this.input = input;
    }

    public void performSearch() {
        promptForInput();
        executeSearch();
        displayResult();
    }

    private void promptForInput() {
        System.out.print("\nEnter a member name to search for: ");
        memberToSearch = input.nextLine().trim();
    }

    private void executeSearch() {
        isFound = SearchUtility.binarySearch(sortedMembers, memberToSearch);
    }

    private void displayResult() {
        if (isFound) {
            System.out.println("The member is found");
        } else {
            System.out.println("The member is not found");
        }
    }
}

// nameKey class
abstract class nameKey {
    public abstract String getNameValue();
}

// Movie class
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

// Member class
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


class Movie{
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    public Movie(String movieTitle,String director,int yearOfRelease,double rating){
        this.movieTitle=movieTitle;
        this.director=director;
        this.yearOfRelease=yearOfRelease;
        this.rating=rating;
    }
}
class MovieNode{
    Movie movie;
    MovieNode prev;
    MovieNode next;
    public MovieNode(Movie movie){
        this.movie = movie;
        this.next = null;
        this.prev = null;
    }
}
class MovieManagement{
    private MovieNode head;
    private MovieNode tail;
    public MovieManagement(){
        head=null;
        tail=null;
    }
    public void addMovieAtBeginning(Movie movie){
        MovieNode newMovieNode=new MovieNode(movie);
        if(head==null){
            head=tail=newMovieNode;
        }
        else{
            newMovieNode.next=head;
            head.prev=newMovieNode;
            head=newMovieNode;
        }
    }
    public void addMovieAtEnd(Movie movie){
        MovieNode newMovieNode=new MovieNode(movie);
        if(tail==null){
            head=tail=newMovieNode;
        }
        else{
            newMovieNode.prev=tail;
            tail.next=newMovieNode;
            tail=newMovieNode;
        }
    }
    public void addMovieAtPosition(Movie movie,int pos){
        MovieNode newMovieNode=new MovieNode(movie);
        if(pos<0){
            System.out.println("Position not valid");
            return;
        }
        if(pos==0){
            addMovieAtBeginning(movie);
            return;
        }
        MovieNode cur=head;
        int currentPos=0;
        while(cur!=null && currentPos<pos-1){
            cur=cur.next;
            currentPos++;
        }
        if(cur==null || cur.next==null){
            addMovieAtEnd(movie);
            return;
        }
        newMovieNode.prev=cur;
        newMovieNode.next=cur.next;
        if (cur.next != null) {
            cur.next.prev = newMovieNode;
        }
        cur.next=newMovieNode;
    }
    public void removeMovieByTitle(String title){
        MovieNode currNode=head;
        while(currNode!=null){
            if(currNode.movie.movieTitle.equals(title)){
                if(currNode.prev!=null){
                    currNode.prev.next=currNode.next;
                }
                else{
                    head=currNode.next;
                }
                if(currNode.next!=null){
                    currNode.next.prev=currNode.prev;
                }
                else{
                    tail=currNode.prev;
                }
                return;
            }
            currNode=currNode.next;
        }
    }
    public void searchByDirector(String director) {
        MovieNode current = head;
        while (current != null) {
            if (current.movie.director.equals(director)) {
                System.out.println("Found: " + current.movie.movieTitle + ", " + current.movie.yearOfRelease + ", Rating: " + current.movie.rating);
            }
            current = current.next;
        }
    }

    public void searchByRating(double rating) {
        MovieNode current = head;
        while (current != null) {
            if (current.movie.rating == rating) {
                System.out.println("Found: " + current.movie.movieTitle + ", " + current.movie.director + ", " + current.movie.yearOfRelease);
            }
            current = current.next;
        }
    }

    public void updateRatingByTitle(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.movie.movieTitle.equals(title)) {
                current.movie.rating = newRating;
                return;
            }
            current = current.next;
        }
    }
    public void displayForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.movie.movieTitle + ", Director: " + current.movie.director + ", Year: " + current.movie.yearOfRelease + ", Rating: " + current.movie.rating);
            current = current.next;
        }
    }

    
    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.movie.movieTitle + ", Director: " + current.movie.director + ", Year: " + current.movie.yearOfRelease + ", Rating: " + current.movie.rating);
            current = current.prev;
        }
    }
}
public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieManagement system = new MovieManagement();

        Movie movie1 = new Movie("Inception", "Christopher Nolan", 2010, 8.8);
        Movie movie2 = new Movie("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        Movie movie3 = new Movie("The Matrix", "Wachowski", 1999, 8.7);
        Movie movie4 = new Movie("Interstellar", "Christopher Nolan", 2014, 8.6);

        system.addMovieAtEnd(movie1);
        system.addMovieAtEnd(movie2);
        system.addMovieAtBeginning(movie3);
        system.addMovieAtPosition(movie4, 2);

        System.out.println("Display movies in forward order:");
        system.displayForward();

        System.out.println("\nDisplay movies in reverse order:");
        system.displayReverse();

        System.out.println("\nSearch by director 'Christopher Nolan':");
        system.searchByDirector("Christopher Nolan");

        System.out.println("\nSearch by rating 8.7:");
        system.searchByRating(8.7);

        System.out.println("\nUpdate rating for 'The Matrix' to 9.0");
        system.updateRatingByTitle("The Matrix", 9.0);

        System.out.println("\nDisplay movies after update:");
        system.displayForward();

        System.out.println("\nRemove movie 'Inception':");
        system.removeMovieByTitle("Inception");

        System.out.println("\nDisplay movies after removal:");
        system.displayForward();
    }
}

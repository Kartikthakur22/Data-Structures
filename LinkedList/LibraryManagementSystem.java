public class LibraryManagementSystem {
    class Node {
        String bookTitle;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        Node next;
        Node prev;

        public Node(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
            this.bookTitle = bookTitle;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public LibraryManagementSystem() {
        head = null;
        tail = null;
    }

    public void addBookAtBeginning(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addBookAtEnd(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addBookAtPosition(int position, String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (position == 0) {
            addBookAtBeginning(bookTitle, author, genre, bookId, isAvailable);
            return;
        }

        Node current = head;
        int currentPos = 0;
        while (current != null && currentPos < position - 1) {
            current = current.next;
            currentPos++;
        }

        if (current != null) {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    public void removeBookById(int bookId) {
        Node current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    public Node searchBookByTitle(String bookTitle) {
        Node current = head;
        while (current != null) {
            if (current.bookTitle.equals(bookTitle)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Node searchBookByAuthor(String author) {
        Node current = head;
        while (current != null) {
            if (current.author.equals(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateAvailabilityStatus(int bookId, boolean isAvailable) {
        Node current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    public void displayBooksForward() {
        Node current = head;
        while (current != null) {
            System.out.println("Book Title: " + current.bookTitle + ", Author: " + current.author +
                    ", Genre: " + current.genre + ", Book ID: " + current.bookId +
                    ", Availability: " + (current.isAvailable ? "Available" : "Checked out"));
            current = current.next;
        }
    }

    public void displayBooksReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println("Book Title: " + current.bookTitle + ", Author: " + current.author +
                    ", Genre: " + current.genre + ", Book ID: " + current.bookId +
                    ", Availability: " + (current.isAvailable ? "Available" : "Checked out"));
            current = current.prev;
        }
    }

    public int countTotalBooks() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        lms.addBookAtBeginning("Book One", "Author A", "Fiction", 101, true);
        lms.addBookAtEnd("Book Two", "Author B", "Non-Fiction", 102, false);
        lms.addBookAtEnd("Book Three", "Author A", "Fantasy", 103, true);

        lms.displayBooksForward();

        System.out.println("\nSearch for a book by title 'Book One':");
        Node book = lms.searchBookByTitle("Book One");
        if (book != null) {
            System.out.println("Found: " + book.bookTitle + " by " + book.author);
        }

        System.out.println("\nSearch for a book by author 'Author A':");
        book = lms.searchBookByAuthor("Author A");
        if (book != null) {
            System.out.println("Found: " + book.bookTitle + " by " + book.author);
        }

        lms.updateAvailabilityStatus(102, true);

        System.out.println("\nBooks after updating availability status of Book ID 102:");
        lms.displayBooksForward();

        lms.removeBookById(101);

        System.out.println("\nBooks after removing Book ID 101:");
        lms.displayBooksForward();

        System.out.println("\nTotal number of books: " + lms.countTotalBooks());
    }
}

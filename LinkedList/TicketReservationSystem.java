class TicketReservationSystem {

    class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private Ticket head;

    public TicketReservationSystem() {
        this.head = null;
    }

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;  // Circular linkage
        } else {
            Ticket current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTicket;
            newTicket.next = head;  // Circular linkage
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        Ticket previous = null;
        do {
            if (current.ticketId == ticketId) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    if (current.next == head) {
                        head = null;
                    } else {
                        Ticket last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = current.next;
                        last.next = head;
                    }
                }
                System.out.println("Ticket ID " + ticketId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName +
                    ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicketByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName +
                        ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("No ticket found for customer: " + customerName);
    }

    public void searchTicketByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        do {
            if (current.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName +
                        ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            }
            current = current.next;
        } while (current != head);
    }

    public void countBookedTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        System.out.println("Total booked tickets: " + count);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "John Doe", "Avatar 2", "A1", "2025-03-15 18:00");
        system.addTicket(2, "Jane Smith", "Avatar 2", "A2", "2025-03-15 18:00");
        system.addTicket(3, "Mark Johnson", "Titanic", "B1", "2025-03-16 20:00");

        system.displayTickets();

        system.removeTicket(2);
        system.displayTickets();

        system.searchTicketByCustomerName("John Doe");

        system.searchTicketByMovieName("Titanic");

        system.countBookedTickets();
    }
}

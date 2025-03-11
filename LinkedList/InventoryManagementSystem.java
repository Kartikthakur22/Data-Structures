public class InventoryManagementSystem {
    class Node{
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;
        public Node(String itemName,int itemId,int quantity,double price){
            this.itemName=itemName;
            this.itemId=itemId;
            this.quantity=quantity;
            this.price=price;
            this.next=null;
        }
    }
    private Node head;
    public InventoryManagementSystem(){
        head=null;
    }
    public void addItemAtBeginning(String itemName,int itemId,int quantity,double price){
        Node newNode=new Node(itemName,itemId,quantity,price);
        newNode.next=head;
        head=newNode;
    }
    public void addItemAtEnd(String itemName,int itemId,int quantity,double price){
        Node newNode=new Node(itemName,itemId,quantity,price);
        if(head==null){
            head=newNode;
        }
        else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }
    }
    public void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
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
            current.next = newNode;
        } else {
            System.out.println("Position out of bounds.");
        }
    }
    public void removeItemById(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Item not found.");
        }
    }
    public void updateQuantity(int itemId, int newQuantity) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found.");
    }
    public Node searchItemById(int itemId) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public Node searchItemByName(String itemName) {
        Node current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void sortInventory(String sortBy, boolean ascending) {
        if (head == null || head.next == null) return;

        if (sortBy.equals("name")) {
            head = mergeSortByName(head, ascending);
        } else if (sortBy.equals("price")) {
            head = mergeSortByPrice(head, ascending);
        }
    }

    // Merge Sort for sorting by Item Name
    private Node mergeSortByName(Node node, boolean ascending) {
        if (node == null || node.next == null) {
            return node;
        }

        // Split the list into two halves
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort the sublists
        Node left = mergeSortByName(node, ascending);
        Node right = mergeSortByName(nextOfMiddle, ascending);

        // Merge the sorted halves
        return mergeByName(left, right, ascending);
    }

    // Merge two sorted lists based on Item Name
    private Node mergeByName(Node left, Node right, boolean ascending) {
        Node result = null;

        // Base cases
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if ((ascending && left.itemName.compareTo(right.itemName) <= 0) || 
            (!ascending && left.itemName.compareTo(right.itemName) >= 0)) {
            result = left;
            result.next = mergeByName(left.next, right, ascending);
        } else {
            result = right;
            result.next = mergeByName(left, right.next, ascending);
        }
        return result;
    }

    // Merge Sort for sorting by Price
    private Node mergeSortByPrice(Node node, boolean ascending) {
        if (node == null || node.next == null) {
            return node;
        }

        // Split the list into two halves
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort the sublists
        Node left = mergeSortByPrice(node, ascending);
        Node right = mergeSortByPrice(nextOfMiddle, ascending);

        // Merge the sorted halves
        return mergeByPrice(left, right, ascending);
    }

    // Merge two sorted lists based on Price
    private Node mergeByPrice(Node left, Node right, boolean ascending) {
        Node result = null;

        // Base cases
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if ((ascending && left.price <= right.price) || 
            (!ascending && left.price >= right.price)) {
            result = left;
            result.next = mergeByPrice(left.next, right, ascending);
        } else {
            result = right;
            result.next = mergeByPrice(left, right.next, ascending);
        }
        return result;
    }

    // Method to get the middle of the list (for splitting)
    private Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }
        
        Node slow = node;
        Node fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        Node current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    public static void main(String[] args) {
        
    }
}

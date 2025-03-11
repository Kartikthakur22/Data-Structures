class Task {
    int taskID;
    String taskName;
    int priority;
    String dueDate;

    Task(int taskID, String taskName, int priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskID + ", Task Name: " + taskName + ", Priority: " + priority + ", Due Date: " + dueDate;
    }
}
class CircularLinkedListNode {
    Task task;
    CircularLinkedListNode next;

    CircularLinkedListNode(Task task) {
        this.task = task;
        this.next = null;
    }
}
class CircularLinkedList {
    private CircularLinkedListNode head;

    public CircularLinkedList() {
        head = null;
    }

    public void addTaskAtBeginning(Task task) {
        CircularLinkedListNode newNode = new CircularLinkedListNode(task);
        if (head == null) {
            head = newNode;
            head.next = head; 
        } else {
            CircularLinkedListNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode; 
        }
    }

    public void addTaskAtEnd(Task task) {
        CircularLinkedListNode newNode = new CircularLinkedListNode(task);
        if (head == null) {
            head = newNode;
            head.next = head;  // Circular reference
        } else {
            CircularLinkedListNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    
    public void addTaskAtPosition(Task task, int position) {
        CircularLinkedListNode newNode = new CircularLinkedListNode(task);
        if (position == 0) {
            addTaskAtBeginning(task);
            return;
        }

        CircularLinkedListNode current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            addTaskAtEnd(task);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void removeTaskByID(int taskID) {
        if (head == null) return;  

        CircularLinkedListNode current = head;
        CircularLinkedListNode previous = null;

        do {
            if (current.task.taskID == taskID) {
                if (previous == null) {
                    if (current.next == head) {
                        head = null;  
                    } else {
                        head = current.next;
                        previous = head;
                        while (previous.next != current) {
                            previous = previous.next;
                        }
                        previous.next = head;
                    }
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    
    public Task viewCurrentTask() {
        if (head == null) return null; 
        return head.task;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        CircularLinkedListNode temp = head;
        do {
            System.out.println(temp.task);
            temp = temp.next;
        } while (temp != head);
    }

    
    public void searchByPriority(int priority) {
        if (head == null) return; 

        CircularLinkedListNode current = head;
        boolean found = false;
        do {
            if (current.task.priority == priority) {
                System.out.println(current.task);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }

    
    public void moveToNextTask() {
        if (head != null) {
            head = head.next;  
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList();

        // Adding tasks
        taskList.addTaskAtEnd(new Task(1, "Task1", 1, "2025-03-10"));
        taskList.addTaskAtEnd(new Task(2, "Task2", 2, "2025-03-11"));
        taskList.addTaskAtBeginning(new Task(3, "Task3", 1, "2025-03-12"));
        taskList.addTaskAtPosition(new Task(4, "Task4", 3, "2025-03-13"), 2);

        System.out.println("Displaying all tasks:");
        taskList.displayAllTasks();

        System.out.println("\nView current task:");
        System.out.println(taskList.viewCurrentTask());

        System.out.println("\nMove to next task:");
        taskList.moveToNextTask();
        System.out.println(taskList.viewCurrentTask());

        System.out.println("\nSearch for tasks with priority 1:");
        taskList.searchByPriority(1);

        System.out.println("\nRemoving task with ID 2:");
        taskList.removeTaskByID(2);
        taskList.displayAllTasks();
    }
}

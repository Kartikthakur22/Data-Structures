class Student{
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber,String name,int age,char grade){
    this.rollNumber=rollNumber;
    this.name=name;
    this.age=age;
    this.grade=grade;
    this.next=null;
    }
}
class StudentList{
    private Student head;
    public StudentList(){
        this.head=null;
    }
    public void insertAtBeginning(int rollNumber,String name,int age,char grade){
        Student newStudent=new Student(rollNumber, name, age, grade);
        newStudent.next=head;
        head=newStudent;
    }
    public void insertAtEnd(int rollNumber,String name,int age,char grade){
        Student newStudent=new Student(rollNumber, name, age, grade);
        if(head==null){
            head=newStudent;
        }
        else{
            Student current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newStudent;
        }
    }
    public void insertAtPosition(int rollNumber,String name,int age,char grade,int position){
        Student newStudent=new Student(rollNumber, name, age, grade);
        if(position==0){
            newStudent.next=head;
            head=newStudent;
        }
        else{
            Student current=head;
            int currentPosition=0;
            while(current!=null && currentPosition<position-1){
                current=current.next;
                currentPosition++;
            }
            if(current==null){
                System.out.println("Position is out of range");
            }
            else{
                Student next=current.next;
                current.next=newStudent;
                newStudent.next=next;
            }
        }
    }
    public void deleteByRollNumber(int rollNumber){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        if(head.rollNumber==rollNumber){
            head=head.next;
            return;
        }
        Student current=head;
        while(current.next!=null && current.next.rollNumber!=rollNumber){
            current=current.next;
        }
        if(current.next==null){
            System.out.println("No student with roll number "+rollNumber+" is present");
        }
        else{
            current.next=current.next.next;
        }
    }
    public Student searchByRollNumber(int rollNumber){
        Student current=head;
        while(current!=null){
            if(current.rollNumber==rollNumber){
                return current;
            }
            current=current.next;
        }
        return null;
    }
    public void updateGrade(int rollNumber,char newGrade){
        Student student=searchByRollNumber(rollNumber);
        if(student!=null){
            student.grade=newGrade;
        }
        else{
            System.out.println("No student with roll number "+rollNumber+" is present");
        }
    }
    public void displayAll(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Student current=head;
        while(current!=null){
            System.out.println("Roll Number: " + current.rollNumber);
            System.out.println("Name: " + current.name);
            System.out.println("Age: " + current.age);
            System.out.println("Grade: " + current.grade);
            System.out.println("---------------------------");
            current = current.next;
        }
    }
}
public class StudentRecordManagement{
    public static void main(String args[]){
        StudentList studentList = new StudentList();

        studentList.insertAtEnd(1, "John Doe", 20, 'A');
        studentList.insertAtEnd(2, "Jane Smith", 22, 'B');
        studentList.insertAtBeginning(3, "Alice Brown", 21, 'C');

        System.out.println("All Students:");
        studentList.displayAll();

        Student student = studentList.searchByRollNumber(2);
        if (student != null) {
            System.out.println("Student found: " + student.name);
        } else {
            System.out.println("Student not found.");
        }

        studentList.updateGrade(2, 'A');
        System.out.println("After updating grade:");
        studentList.displayAll();

        studentList.deleteByRollNumber(1);
        System.out.println("After deleting student with roll number 1:");
        studentList.displayAll();

        studentList.insertAtPosition(6,"Bob White", 23, 'B',1);
        System.out.println("After adding student at position 2:");
        studentList.displayAll();
    }
}
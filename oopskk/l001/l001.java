import java.util.* ;
import java.io.* ;

// create a class 
// for every single student
 class Student {
    int rno ; 
    String name ; 
    float marks=90 ;

    // we need a way to add the values of the above
    // properties object by object

    // we need one word to access every object

    void greeting() {
        System.out.println("Hello" + this.name) ;
    }

    void changeName(String name) {
        this.name=name ;
    }

    Student(Student other) {
        this.name = other.name;
        this.rno = other.rno;
        this.marks = other.marks;
    }

    Student() {
        // this is how you call a constructor from another constructor
        // internally: new Student (13, "default person", 100.0f);
        this(13, "default person", 100.0f);
    }

    // Student arpit = new Student(17, "Arpit", 89.7f);
    // here, this will be replaced with arpit
    Student(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

}
public class l001 {
    public static void main(String[] args){
        Student s1=new Student() ;
        System.out.println(s1) ;
    }
}

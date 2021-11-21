// package polymorphism ;

public class Circle extends Shapes {

    @Override // this is called annotation
    void area() {
        System.out.println("Area is pi*r*r") ;
    }

    // @Override 
    // static void greeting() {
    //     System.out.println("I am inside circle class") ;
    // }

    @Override  
    public String toString() {
        return "I am an object" ;
    }   
} 

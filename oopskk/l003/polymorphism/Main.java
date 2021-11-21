// package polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes obj = new Shapes() ;
        Square sq = new Square() ;
        Circle cr = new Circle() ;

        // method overriding-preference will be given to that whose object is created
        // Shapes cr = new Circle() ;
        // cr.area() ;
        // overriding depends on objects but static methods does not depend on objects
        cr.greeting();
    }
}

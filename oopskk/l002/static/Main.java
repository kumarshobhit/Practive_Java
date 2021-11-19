public class Main {
    // static variables are shared by the objects of the class.
    // common property that all the objects have
    // we can use it even before creating object of class
    // static methods-main is static to allow creation of objects 
    public static void main(String[] args){
        Human shobhit = new Human(21,"Shobhit",10000,false) ;
        Human john = new Human(29, "John", 20000, true);
        System.out.println(Human.population) ;
        fun() ;
    }

    // static methods cannot contain non static methods becuase static methods does not 
    // depend on the instance of a class  wherease non static method needs an instance of some class
    static void fun() {
        // greeting() ;
        // you cannot access non static methods without referencing thier instances in a static context
        Main obj = new Main();
        obj.greeting() ;
        System.out.println("I am inside fun function") ;
    }

    void fun2() {
        // non static inside non static
        greeting() ;
    }

    // we can have a static method inside an non static method
    void greeting() {
        // fun() ;
        System.out.println("hello world") ;
    }
}

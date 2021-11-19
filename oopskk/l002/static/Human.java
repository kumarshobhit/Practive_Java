public class Human {
    int age;
    String name;
    int salary; 
    boolean married ;
    static long population ;

    // you cannot refer static methods using this
    // this can't be use inside a static Methods
    static void message() {
        System.out.println("hello world") ;
        // System.out.println(this.age) ; cannot use this over here
    }

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population += 1;
        // Human.message() ;
        // this.message() ;
    }
}

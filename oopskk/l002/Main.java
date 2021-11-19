public class Main {
    public static void main(String[] args) {
        Singleton obj1 = new Singleton() ;
        Singleton obj2 = new Singleton();
        Singleton obj3 = new Singleton() ;
        // all 3 ref variables are pointing to one object
    }
}

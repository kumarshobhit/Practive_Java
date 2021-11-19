public class InnerClasses {

    static class Test {
         String name;

        public Test(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name ;
        }
    }

    public static void main(String []args) {
        Test a=new Test("Shobhit") ;
        Test b=new Test("Mohit") ;

        // System.out.println(a.name) ;
        // System.out.println(b.name) ;

        System.out.println(a) ;
    }
}


// we cannot declare static methods just be itself
// static void fun() {
//     System.out.println("hello world") ;
// }

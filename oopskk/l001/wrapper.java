public class wrapper {

    static class Student {
        String name;
        int rollNo ;

        Student() {
            System.out.println("Object is created") ;
            this.name="Shobhit" ;
            this.rollNo=3 ;
        }

        Student(String name,int rollNo) {
            this.name=name ;
            this.rollNo=rollNo ;
        }

        @Override
        // similar to destructor in c++ ;
        // we cannot call this function on an object!
        protected void finalize() throws Throwable {
            System.out.println("Object is destroyed") ;
        }
    }

  static void swap(Integer a,Integer b) {
        Integer temp=a ;
        a=b ;
        b=temp ;

        // cannot change values 
        // also final variables have to be initialized with some value
        // Note this fact is only valid for primitive data types
        final int increase=2 ;
        // increase = 3 ;

        final Student Shobhit=new Student() ;
        Shobhit.name="Shobhit Kumar" ;
        // Shobhit=new Student("Kunal",35) ; not allowed

    }
    public static void main(String []args) throws Exception {
        Integer a=10 ;
        Integer b=20 ;
        // will not change the values as the values in Integer object are final
        swap(a,b) ;
        System.out.println(a) ;
        System.out.println(b) ;
    }
}

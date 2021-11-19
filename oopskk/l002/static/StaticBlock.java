public class StaticBlock {

    static int a=4 ;
    static int b ;

    // will only run once, when the first object is create i.e when the class is loaded for the first time 
    static {
        System.out.println("I am a static block") ;
        b=a*5 ;
    }  
    public static void main(String[] args){
        StaticBlock block = new StaticBlock() ;
        System.out.println(StaticBlock.a+" "+StaticBlock.b+" ") ;
        StaticBlock.b+=3 ;

        
        StaticBlock block2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b + " ");
    }
}

public class stack {
    private int []arr ;
    private int tos ;
    private int NoOfElements ;
    private int MaxCapacity ;

    stack(int size) {
        initialize(size) ;
    }

    stack() {
        this(10) ;
    }

    protected void initialize(int size) {
        thisNoOfelements = 0 ;
        this.MaxCapacity=size ;
        this.arr=new int [this.MaxCapacity] ;
        this.tos=-1 ;
    }

    private void overflowException() throws Exception {
        throw new Exception("StackIsOverflow") ;
    }

    public void push() {
        overflowException() ;
    }

    public int peek() {
        
    }

    public int pop() {

    }
}

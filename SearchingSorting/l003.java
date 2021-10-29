import java.util.* ;
import java.io.* ;
public class l003{
    // https://www.geeksforgeeks.org/count-distinct-pairs-with-given-sum/
    public List<List<Integer>> allPairs(int[] nums,int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>() ;
         int n=nums.length ;
        int si=0 ; int ei=n-1 ;
        while(si<ei) {
            int csum=nums[si]+nums[ei] ;
            if(csum==target) {
                ans.add(Arrays.asList(nums[si],nums[ei])) ;

                si++ ; 
                ei-- ;

                // 3 options
                while(si<ei && nums[si]==nums[si-1]) si++ ;
                while (si < ei && nums[ei] == nums[ei + 1]) ei-- ;

            }
            else if(csum<target) {
                si++ ;
            }
            else {
                ei-- ;
            }
        }
        return ans ;
    }
    public static void main(String[] args) {

    }
}
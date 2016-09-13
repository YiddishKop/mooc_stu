import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * BinarySearch: ÓÃÀ´Á·Ï°Recursive Method
 * @author yiddi
 *
 */
public class BinarySearch {
	/**
	 * Searches the array A for the integer N.
	 * Precondition:  A must be sorted into increasing order.
	 * Postcondition: If N is in the array, then the return value, i,
	 *    satisfies A[i] == N.  If N is not in the array, then the
	 *    return value is -1.
	 */
	public static int bsIter(int[] A, int N) {
	      
	    int lowestPossibleLoc = 0;
	    int highestPossibleLoc = A.length - 1;
	    
	    while (highestPossibleLoc >= lowestPossibleLoc) {
	       int middle = (lowestPossibleLoc + highestPossibleLoc) / 2;
	       if (A[middle] == N) {
	                 // N has been found at this index!
	          return middle;
	       }
	       else if (A[middle] > N) {
	                 // eliminate locations >= middle
	          highestPossibleLoc = middle - 1;
	       }
	       else {
	                 // eliminate locations <= middle
	          lowestPossibleLoc = middle + 1;   
	       }
	    }
	    
	    // At this point, highestPossibleLoc < LowestPossibleLoc,
	    // which means that N is known to be not in the array.  Return
	    // a -1 to indicate that N could not be found in the array.
	 
	    return -1;
	  
	}// end bsIter()
	
	public static int bsRecur(int[] nums, int targ, int head, int tail) {
		
		if(head > tail) {
			return -1;
		}
		else {
			int mid =(head + tail)/2;
			if (nums[mid] == targ) {
				return mid;
			}else if(targ < nums[mid]) {
				return bsRecur(nums, targ, head, mid-1);
			}else{
				return bsRecur(nums, targ, mid+1, tail);
			}
		}
	}// end bsRecur()
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,5,8,12,23,24,25,34,35,47,58};
		
		// display array of numb
		System.out.println("Array: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		
		// input the target numb
		System.out.println("you want to search: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int targ = 0;
		try {
			targ = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// binary search by Iteration
		if (bsIter(nums, targ) != -1) {
			System.out.println("Iter: target numb is in: "+bsIter(nums, targ));
		} else {
			System.out.println("Not Find!");
		}
		
		// binary search by Recursion
		if (bsRecur(nums, targ, 0, nums.length-1) != -1) {
			System.out.println("Recur: target numb is in: "+bsRecur(nums, targ, 0, nums.length-1));
		} else {
			System.out.println("Not Find!");
		}
	}
}

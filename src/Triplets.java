import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triplets {

	public static void main(String[] args) {
		
		int[] arr = {-1,0,1,2,-1,4};
		System.out.println(new Triplets().findTriplets(arr));

	}
	
	List<int[]> res;
	
	public List<int[]> findTriplets(int[] arr) {
		
		res  = new ArrayList<>();
		
		int n = arr.length;
		Arrays.sort(arr);
		
		for (int i=0; i<n; i++) {
			
			// avoid repetition
			if (i>0 && (arr[i] == arr[i-1])) {
				continue;
			}
						
			if (arr[i] > 0) {
				break; // all forward elements are positive
			}
			
			Set<Integer> set = new HashSet<>();
			for (int j=i+1; j<n; j++) {
				
				if (set.contains(arr[j])) {
					continue;
				}
				
				int rem = 0 - arr[i] - arr[j];
				if (set.contains(rem)) {
					
					res.add(new int[] {arr[i], arr[j], rem});
					System.out.println(arr[i] + " " + arr[j] + " " + rem);
					
				} else {
					set.add(arr[j]);
				}
				
			}
			
			
		}
		
		return res;
		
	}

}

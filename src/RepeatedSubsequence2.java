import java.util.HashSet;
import java.util.Set;

public class RepeatedSubsequence2 {

	public static void main(String[] args) {
		
		String str = "XYBYAXBY";
//		String str = "XBXAXB";
//		String str = "abab";
		System.out.println(new RepeatedSubsequence2().numberOfRepeatedSubsequence(str));
		
	}
	
	Set<String> res;
	String comb1 = "";
	String comb2 = "";
	
	public int numberOfRepeatedSubsequence(String str) {
		
		res = new HashSet<>();
		
		generateSubsequence(str, 0);
		
		System.out.println(res);
		return res.size();
		
	}	
	
	private void generateSubsequence(String str, int index) {
	// generate all possible subsequence of given string
			
		if (comb1.length() > 1) {
			containsSequence(comb1, str.substring(index-1));
		}
				
		for (int i=index; i<str.length(); i++) {
			
			comb1 += str.charAt(i);			
			generateSubsequence(str, i+1);
			comb1 = comb1.substring(0,comb1.length()-1);
			
		}
		
	}
	
	private boolean containsSequence(String a, String str) {
		// generate all possible subsequences of given substring str and match it to staring a

		int len = a.length();
				
		if (comb2.length() == len) {
			if(a.equals(comb2)) {
				res.add(a);
			}
			return true;
		}
		
		for (int i=0; i<str.length(); i++) {
			
			comb2 += str.charAt(i);
			containsSequence(a, str.substring(i+1));
			comb2 = comb2.substring(0,comb2.length()-1);
			
		}
		
		return false;
		
	}

}

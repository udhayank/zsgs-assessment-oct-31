import java.util.HashSet;
import java.util.Set;

public class RepeatedSubsequence3 {

	public static void main(String[] args) {
		
		String str = "XYBYAXBY";
//		String str = "XBXAXB";
//		String str = "abab";
		System.out.println(new RepeatedSubsequence3().numberOfRepeatedSubsequence(str));
		
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
		// search character by character in str to match sequence of a

		int len = a.length();
		int index = -1;
		boolean isMatch = true;
				
		for (int i=0; i<len; i++) {
			str = str.substring(index+1);
//			System.out.println(i + " - " + str);
			index = str.indexOf(a.charAt(i));
			if (index == -1) {
				isMatch = false;
				break;
			}
		}
		
		if (isMatch) {
//			System.out.println(a);
			res.add(a);
			return true;
		}
		
		return false;
		
	}

}

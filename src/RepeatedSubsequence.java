import java.util.HashSet;
import java.util.Set;

public class RepeatedSubsequence {

	public static void main(String[] args) {
		
		String str = "XBXAXB";
//		String str = "abab";
		System.out.println(new RepeatedSubsequence().numberOfRepeatedSubsequence(str));
		
	}
	
	int count = 0;
	Set<String> res;
//	Set<String> set = new HashSet<>();
	String comb1 = "";
	String comb2 = "";
	
	public int numberOfRepeatedSubsequence(String str) {
		
		count = 0;
		res = new HashSet<>();
		
		int n = str.length();
		
		for (int len=2; len<n-1; len++) {
			
			comb1 = "";
			generateSubsequence(str, len, 0);
			
		}
		
		System.out.println(res);
		return res.size();
		
	}	
	
	private void generateSubsequence(String str, int len, int index) {
	// generate all possible subsequence of given length
		
		
//		System.out.println(comb + "  " + set);
		
		if (comb1.length() == len) {
//			System.out.println("Str  " + comb1);
			containsSequence(comb1, str.substring(index-1));
			return;
		}
				
		for (int i=index; i<str.length(); i++) {
			
			comb1 += str.charAt(i);			
			generateSubsequence(str, len, i+1);
			comb1 = comb1.substring(0,comb1.length()-1);
//			comb = "";
			
		}
		
	}
	
	private boolean containsSequence(String a, String str) {
		
//		System.out.println(a);
		int len = a.length();
				
		if (comb2.length() == len) {
			if(a.equals(comb2)) {
//				System.out.println(comb2 + "  " + str);
				res.add(a);
			}
			return true;
		}
		
		for (int i=0; i<str.length(); i++) {
			
			comb2 += str.charAt(i);
			containsSequence(a, str.substring(i+1));
			comb2 = comb2.substring(0,comb2.length()-1);
//			comb = "";
			
		}
		
		return false;
		
	}

}

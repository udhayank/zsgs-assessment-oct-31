import java.util.Arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {
		
		int[] arr = {5,6,3,4};
		System.out.println(Arrays.toString(new ProductExceptSelf().product(arr)));

	}
		
	public int[] product(int[] arr) {
		
		int n = arr.length;
		
		int[] leftProd = new int[n];
		int[] rightProd = new int[n];
		
		leftProd[0] = arr[0];
		for (int i=1; i<n; i++) {
			leftProd[i] = arr[i] * leftProd[i-1];
		}
		
		rightProd[n-1] = arr[n-1];
		for (int i=n-2; i>=0; i--) {
			rightProd[i] = arr[i] * rightProd[i+1];
		}
		
		int[] prod = new int[n];
		prod[0] = rightProd[1];
		prod[n-1] = leftProd[n-2];
		
		for (int i=1; i<n-1; i++) {
			prod[i] = leftProd[i-1] * rightProd[i+1];
		}
		
		
		return prod;
		
	}

}

import java.util.List;

public interface Functions {
	
	boolean isOdd(int num);
	
	boolean isPrime(int num);
	
	int min(int[] arr);
	
	int oddOccurnces(int[] arr);

	int kthElem(int[] arr, int k);
	
	double avrgOfAll(int[] arr);
	
	float power(int num, int power);
	
	int smallestMultipleOfNum(int[] arr);
	
	int  doubleFactorial(int num);
	
	int kthFactorial(int num);
	
	long maximumScalarProduct(List<Integer> a, List<Integer> b);
	
	int maxSpan(int...ints);
	
	boolean equalSumSides(int...ints);
	
	String reverse(String argument);
	
	/////////////////////////
	
	boolean isPalindrome(String argument);
	
	String reverseEveryWord(String arg);
	
	boolean isPalindrome(int[] ints);
	

	
}

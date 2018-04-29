import java.util.Comparator;
import java.util.List;

public class Main implements Functions{
	
	@Override
	public boolean isOdd(int num) {
		return (num%2 != 0);
	}

	@Override
	public boolean isPrime(int num) {
		if(num <= 1) {
			return false;
		}
		for(int i = 2; i*i 	<= num; ++i) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int min(int[] arr) {
		int min = arr[0];
		
		for(int i : arr) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}
	
	@Override
	public int oddOccurnces(int[] arr) {
		int[] occurnces = new int[Integer.MAX_VALUE];
		
		for(int i = 1;i < arr.length;++i) {
			++occurnces[arr[i]];
		}
		int odd = -1;
		for(int i = 1; i < occurnces.length;++i) {
			if(isOdd(occurnces[i])) {
				odd = i;
				return odd;
			}
		}
		return odd;
	}

	/*******************************************************************************************/
			
	private int binarySearch(int[] arr, int inf, int sup, int x) throws ElementNotFoundExcepton {
		if(inf >= sup) {
			throw new ElementNotFoundExcepton();
		}
		
		int medium = (inf+sup)-1/2;
		if(arr[medium] == x) {
			return x;
		}
		else if(arr[medium] < x) {
			return binarySearch(arr, inf+1, sup, x);
		}
		else {
			return binarySearch(arr, inf, sup+1, x);
		}
	}

	@Override
	public int kthElem(int[] arr, int k) {
		return arr[k+1];
	}
	
	/*******************************************************************************************/
	@Override
	public double avrgOfAll(int[] arr) {
		int avr = 0;
		for(int i : arr) {
			avr += i;
		}
		return avr/(double) arr.length;
	}

	@Override
	public float power(int num, int power) {
		float temp;
        if(power == 0)
            return 1;
        temp = power(num, power/2); 
         
        if (power %2 == 0) {
            return temp*temp;
        }
        else {
            if(power > 0)
                return num * temp * temp;
            else
                return (temp * temp) / num;
        }
	}

	/*******************************************************************************************/	
	private boolean isDivisorOfAll(int[] arr, int num) {
		for(int i: arr) {
			if(i != 0 && num % i != 0) {
				return false;
			}
		}
		return true;
	}
	
	private int max(int[] arr) {
		int max = arr[0];
		for(int i : arr) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}

	@Override
	public int smallestMultipleOfNum(int[] arr) {
		int smallestMultiple = max(arr);
	
		while(true) {
			if(isDivisorOfAll(arr, smallestMultiple)) {
				return smallestMultiple;
			}
			++smallestMultiple;
		}
	}
	
	/*******************************************************************************************/
	@Override
	public int doubleFactorial(int num) {
		if(num <= 0) {
			return 1;
		}
		return num * doubleFactorial(num - 2);
	}

	private int factorial(int num) {
		if(num == 0) {
			return 1;
		}
		return num * factorial(num-1);
	}

	@Override
	public int kthFactorial(int num) {
		return factorial(factorial(num));
	}
	
	/*******************************************************************************************/
	public long maximumScalarProduct(List<Integer> a, List<Integer> b) {
		long product = 1;
		a.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		b.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(int i = 0; i < a.size(); ++i) {
			product += a.get(i) * b.get(i);
		}
		return product;
	}

	/*******************************************************************************************/
	public int maxSpan(int...ints) {
		 int maxSpan = 0;
		 int currSpan = 0;

	        for(int i = 0;i < ints.length; ++i){   
	            for(int j = ints.length-1;j > i;--j){ 
	                if(ints[i] == ints[j]){
	                    currSpan = j-i;
	                    break;
	                } 
	            } 
	            if(currSpan > maxSpan){
	                maxSpan = currSpan;
	            } 
	        } 
	        return maxSpan+1;
	    }

	/*******************************************************************************************/
	@Override
	public boolean equalSumSides(int... ints) {
		int leftSum = 0;
		int rightSum = 0;
		
		for(int i = 0; i < ints.length - 1;++i) {
			for(int j = i+1, k = 0; j < ints.length || k < i;++j) {
				if(k < i) {
					leftSum += ints[k];
					++k;
				}
				if(j < ints.length) {
					rightSum += ints[j];
				}	
			}
			if(leftSum == rightSum) {
				return true;
			}
			leftSum = rightSum = 0;
		}
		return false;
	}


	@Override
	public String reverse(String argument) {
		char[] reversed = argument.toCharArray();
		
		for(int i = 0, j = reversed.length; i < reversed.length/2; ++i) {
			char temp = reversed[i];
			reversed[i] = reversed[j-i-1];
			reversed[j-i-1] = temp; 
		}
		return new String(reversed, 0, reversed.length);
	}


	@Override
	public boolean isPalindrome(String argument) {
		for(int i = 0; i < argument.length()/2;++i) {
			if(argument.charAt(i) != argument.charAt(argument.length() - i -1)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String reverseEveryWord(String arg) {
		
		return null;
	}


	@Override
	public boolean isPalindrome(int[] ints) {
		
		for(int i = 0; i < ints.length/2 ;++i) {
			if(ints[i] != ints[ints.length-i-1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] n = new int[] {8,7,7,8};
		System.out.println(new Main().isPalindrome(n));
	}
	
	
}

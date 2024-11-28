// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	// Returns the absolute value
	public static int absolute(int x1) {
		int positive = 0;
		if (x1 >= 0) {
			return x1; 
		}
			else {
				for (int i = x1; i < 0; i++){
				positive++;
			}
			return positive;
		}
		 
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for (int i = 0; i < absolute(x2); i++) {
			if (x2 < 0) {
				x1-- ;
			}
			else {
				x1++ ;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for (int i = 0; i < absolute(x2); i++) {
			if (x2 < 0) {
				x1++ ;
			}
			else {
				x1-- ;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multiplication = 0;
		if (x1 == 0 || x2 ==0) {
			return 0; 
		}
		if (x2 == 1) {
			return x1;
		}
			if (x1 > 0 && x2 > 0 || x1 < 0 && x2 < 0) {
				for (int i = 0; i < absolute(x2); i++){
				multiplication = plus(multiplication, absolute(x1));
				}
				return multiplication;
			}
					else {
						for (int i = 0; i < absolute(x2); i++){
						multiplication = minus(multiplication, absolute(x1));
						}
							return multiplication;
						}

		}
		

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int variable = x ;

		if (x == 0 && n == 0) {
			return (int)Double.NaN;
		}
		if (x == 0) {
			return 0;
		}
		if (n == 1) {
			return x;
		}
		if (n == 0) {
			return 1;
		}
		if (x == 1) {
			return 1;
		}
		if (x < 0){
			if (mod(n, 2) == 0){
			x = absolute(x);
			for (int i = 1; i < n; i++) {
			variable = times(variable, x);
			}
			return variable;	
			}

			else {
				for (int i = 1; i < n; i++) {
				x = absolute(x);
				variable = minus(variable, x);
				}
				return variable;	
	
				}
			}

			else {
				for (int i = 1; i < n; i++) {
				variable = times(variable, x);
				}
				return variable;	
				}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int variable1 = absolute(x1);
		int variable2 = absolute(x2);
		int counter = 0;

		if (x2 == 0) {
			return (int)Double.NaN;
			
		}

		if (x1 == 0) {
			return 0; 
		} 
		if (x2 == 1) {
			return x1;
		}

		if ((x1 > 0 && x2 > 0) || (x1 <0 && x2 <0)) {
			while (variable1 > 0){
				variable1 = minus(variable1, variable2);
				if (variable1 >= 0){
				counter ++; 
				}
					}
			return counter;
		}

		else {
			while (variable1 > 0){
				variable1 = minus(variable1, variable2);
				if (variable1 >= 0){
				counter --; 
				}
					}
			return counter;

		}

			}
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int div = div(x1, x2);
		int modular = minus(x1, times(x2, div));
		return modular;

		}
		

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) {
			return (int)Double.NaN; 
		}
		int result = 0;
		while (times(result, result) <= x) {
			result ++;
		}
		return minus(result, 1);
	}	  	  
}
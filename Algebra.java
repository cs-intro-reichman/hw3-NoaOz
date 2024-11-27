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

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int variable1 = x1; 
		int variable2 = x2; 
		if (variable2 >= 0){
			for (int i = 0; i < variable2; i++ ){
			variable1 ++;
		}
	}
				else {
				variable1 = minus(variable1, variable2);	
				}

		return variable1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int variable1 = x1; 
		int variable2 = x2; 
		if (variable2 >= 0){
			for (int i = 0; i < variable2; i++){
			variable1 --;
		}
	}
				else {
					variable1 = plus(variable1, variable2);
				}
		return variable1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int variable1 = x1; 
		int variable2 = x2;
		int multiplication = x1;
		if (variable1 == 1){
			return variable2;
		}
			if (variable1 == 0){
				return 0; 
			}
				if (variable2 == 0) {
					return 0; 
				}
					else {
						for (int i = 1; i < variable2; i++) {
							multiplication = plus(multiplication, variable1); 
						} 	
							return multiplication;
					}

	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int variable = x ;
		int num = n ;
		int result = x; 
		if (num == 1){
			return variable;
		}
			if (num == 0){
				return 1;
			}
				else{
					for (int i = 1; i < num; i++){
						result = times(result, variable);
					}
					return result;

				}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int variable1 = x1;
		int variable2 = x2;
		int counter = 0; 
		if (variable1 == variable2){
			return 1;
		} 
			if (variable1 < variable2){
				return 0; 
			}
				if (variable2 == 1){
					return variable1;
				}
					else {

						while (variable1 > 0){
							variable1 = minus(variable1, variable2);
							if (variable1 >= 0){
								counter ++; 
							}
						}
						return counter;
				}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int variable1 = x1;
		int variable2 = x2; 
		if (variable1 == variable2){
			return 0;
		}
			if ( variable2 > variable1){
				return variable1;
			}
				else { 
					int modular = div(variable1, variable2);
					modular = times(modular, variable2);
					modular = minus(variable1, modular);
					return modular;

				}
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int variable = x; 
		if (x > 0){
			int i = 1; 
			while (i <= variable){
				if (variable == pow(i,2)) {
					return i;
				}
				i++ ;
					if ()
			}
		}
	}	  	  
}
package fizzbuzz;

public class FizzBuzz {

	public static void main(String[] args) {
				
		for (int number=1;number<=100;number++) {
			System.out.println(Result(number));	
		}
	}
	
	public static String Result (int number) {
		
		String n = "";
		if (number % 3 == 0) {
			n += "Fizz";
		}
		if (number % 5 == 0) {
			n += "Buzz";
		}
		if (n.equals("")) {
			n = String.valueOf(number);
		}
		
		return n;
		
	}
}

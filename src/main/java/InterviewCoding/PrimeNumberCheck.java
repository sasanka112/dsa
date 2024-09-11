package InterviewCoding;
public class PrimeNumberCheck {

	public static void main(String[] args) {
		System.out.println("isPrime 19: " + isPrime(19)); // true
		System.out.println("isPrime 49: " + isPrime(49)); // false
		System.out.println("isPrime 47: " + isPrime(47)); // false
		System.out.println("isPrime 5: " + isPrime(5)); // false
	}

	public static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		System.out.println("n / 2 = " + n/2);
		for (int i = 2; i <= n / 2; i++) {
			System.out.println("i = " + i + ",n = " + n + ",n%i = " + n%i);
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

}
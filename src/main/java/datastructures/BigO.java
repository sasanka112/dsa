package datastructures;

public class BigO {
	public static void main(String[] args) {
		int n = 10;
		printItems_O_n(n);
		printItems_O_n2(n);
		printItems_O_1(n);
	}

	// example of O(n)
	private static void printItems_O_n(int n) {
		// TODO Auto-generated method stub
		System.out.println("printItems_O_n");
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}
	}

	// example of O(n2)
	private static void printItems_O_n2(int n) {
		// TODO Auto-generated method stub
		System.out.println("printItems_O_n2");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(i + " " + j);
			}
		}
	}

	// example of O(1)
	private static void printItems_O_1(int n) {
		// TODO Auto-generated method stub
		System.out.println("printItems_O_1");
		System.out.println(n + n);
	}
}

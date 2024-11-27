import java.util.Scanner;
import javax.swing.JOptionPane;

public class Q2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[4];
		Rational rational1 = null;
		Rational rational2 = null;
		String text;
		boolean flag = true;

		// Input loop to get numerator and denominator for both numbers
		while (flag) {
			flag = false;
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 0) {
					text = "numerator";
				} else {
					text = "denominator";
				}
				System.out.println("Please enter the " + text + " of the #" + (i / 2 + 1) + " number");
				arr[i] = scan.nextInt();
			}
			try {
				rational1 = new Rational(arr[0], arr[1]);
				rational2 = new Rational(arr[2], arr[3]);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid denominator was entered, remember denominator must be > 0.\nPlease try again.");
				flag = true; // Repeat input if invalid denominator
			}
		}

		// Compare and perform operations
		System.out.println("Is " + rational1 + " greater than " + rational2 + "?");
		if (rational1.greaterThan(rational2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		System.out.println("Is " + rational1 + " equal to " + rational2 + "?");
		if (rational1.equals(rational2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		// Perform arithmetic operations
		System.out.println(rational1 + " + " + rational2 + " = " + rational1.plus(rational2).reduce());
		System.out.println(rational1 + " - " + rational2 + " = " + rational1.minus(rational2).reduce());
		System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2).reduce());

		try {
			System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2).reduce());
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Error: Division by zero is not allowed.\nPlease make sure the numerator of the second number is not zero.");
		}
	}
}

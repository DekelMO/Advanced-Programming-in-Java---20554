
public class Rational {
	int numerator;
	int denominator;
	
	public Rational(int numerator, int denominator) {
		if (denominator <= 0) {
			throw new IllegalArgumentException("Denominator must be > 0");
		}
		this.denominator = denominator;
		this.numerator = numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public int getNumerator() {
		return numerator;
	}

	public boolean greaterThan(Rational num) {
		int numDenominator = num.getDenominator();
		int numNumerator = num.getNumerator();
		if(numerator*numDenominator>denominator*numNumerator) {
			return true;
		}
		else
			return false;

	}
	public boolean equals(Rational num) {
		int numDenominator = num.getDenominator();
		int numNumerator = num.getNumerator();
		if((numerator*numDenominator==denominator*numNumerator) ) {
			return true;
		}
		return false;
	}
	public Rational plus(Rational num) {
		int numDenominator = num.getDenominator();
		int numNumerator = num.getNumerator();
		return new Rational(numerator*numDenominator+denominator*numNumerator,denominator*numDenominator); 
			
	}
	public Rational minus(Rational num) {
		int numDenominator = num.getDenominator();
		int numNumerator = num.getNumerator();
		return new Rational(numerator*numDenominator-denominator*numNumerator,denominator*numDenominator); 
			
	}
	public Rational multiply(Rational num) {
		int numDenominator = num.getDenominator();
		int numNumerator = num.getNumerator();
		return new Rational(numerator*numNumerator,denominator*numDenominator); 
			
	}
	public Rational divide(Rational num) {
		int numDenominator = num.getDenominator();
		int numNumerator = num.getNumerator();
		if(numNumerator == 0) {
			throw new ArithmeticException("Numerator must be =! 0 for division");
		}
		Rational inverseNum = new Rational(numDenominator,numNumerator);
		return multiply(inverseNum); 
			
	}
	private int gcd() {
		int x =numerator;
		int y = denominator;
		int temp;
		while(y!=0) {
			temp = x%y;
			x=y;
			y =temp;
			
		}
		return x;
	}
	public Rational reduce() {
		int greatestCommonFactor = gcd();
		return new Rational(numerator/greatestCommonFactor,denominator/greatestCommonFactor);
	}
	
	public String toString() {
		 return String.format("%d/%d",numerator,denominator);
	}


}

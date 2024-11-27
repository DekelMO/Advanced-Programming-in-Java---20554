
public class PieceWorker extends Employee{
	private int piecesCreated; 
	private double pricePerPiece;

	// Constructor
	// Constructor
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double pricePerPiece, int piecesCreated ,int day, int month, int year) {
		super(firstName, lastName, socialSecurityNumber, day, month, year);

		if (pricePerPiece < 0.0) {
			throw new IllegalArgumentException("Price per piece must be >= 0.0");
		}
		if (piecesCreated < 0) {
			throw new IllegalArgumentException("Pieces created must be >= 0");
		}
		this.pricePerPiece = pricePerPiece;
		this.piecesCreated = piecesCreated;
	}

	// Set price per piece
	public void pricePerPiece(double pricePerPiece) {
		if (pricePerPiece < 0.0) {
			throw new IllegalArgumentException("price per piece must be >= 0.0");
		}
		this.pricePerPiece = pricePerPiece;
	}
	// Set pieces created
	public void piecesCreated(int piecesCreated) {
		if (piecesCreated < 0) {
			throw new IllegalArgumentException("pieces created must be >= 0");
		}
		this.piecesCreated = piecesCreated;
	}

	// Return pieces created
	public int getPiecesCreated() {
		return piecesCreated;
	}
	// Return price per piece
	public double getPricePerPiece() {
		return pricePerPiece;
	}

	// Calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		return getPricePerPiece()*getPiecesCreated();
	}

	// Return String representation of CommissionEmployee object
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %d", "Piece worker employee", super.toString(), "price per piece", getPricePerPiece(), "pieces created", getPiecesCreated());
    }
}// end class SalariedEmployee
package persistence;

public class LoanNotFoundException extends LoanPersistenceException {

    public LoanNotFoundException(long id) {
        super("Loan with id " + id + " is not found");
    }
}

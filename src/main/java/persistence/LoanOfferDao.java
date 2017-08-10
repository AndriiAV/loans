package persistence;

import model.LoanOffer;

public interface LoanOfferDao { // DAO = Data Access Object

    /**
     * @throws LoanPersistenceException
     * @throws LoanNotFoundException
     */
    LoanOffer findById(long id);

    /**
     * @throws LoanPersistenceException
     */
    LoanOffer save(LoanOffer loan);

    /**
     * @throws LoanPersistenceException
     * @throws LoanNotFoundException
     */
    LoanOffer delete(long id);
}

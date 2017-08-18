package com.andrii.loan.persistence;

import com.andrii.loan.model.LoanOffer;

import java.math.BigDecimal;
import java.util.List;

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

    /**
     * @throws LoanPersistenceException
     */
    List<LoanOffer> findByMaxAmount(BigDecimal from, BigDecimal to);
}

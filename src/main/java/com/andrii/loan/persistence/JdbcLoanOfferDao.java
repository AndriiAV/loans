package com.andrii.loan.persistence;

import com.andrii.loan.model.Currency;
import com.andrii.loan.model.LoanOffer;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcLoanOfferDao implements LoanOfferDao {

    private static final String SQL_FIND_BY_ID = "SELECT * FROM loan_offer WHERE id = ?";
    private static final String SQL_SAVE = "INSERT INTO loan_offer(bank_name,offer_name,max_amount,max_duration,interest_rate,currency) " +
            "VALUES(?,?,?,?,?,?)";
    private static final String SQL_DELETE_BY_ID = "delete from loan_my_db.loan_offer where id=?;";
    private static final String SQL_FIND_BY_MAX_AMOUNT = "SELECT * FROM loan_offer WHERE max_amount >= ? AND max_amount <= ?;";

    private final DataSource dataSource;

    public JdbcLoanOfferDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public LoanOffer findById(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new LoanNotFoundException(id);
            }
            return createLoanOffer(resultSet);
        } catch (SQLException e) {
            throw new LoanPersistenceException("Can't find loan offer by id " + id, e);
        }
    }

    private LoanOffer createLoanOffer(ResultSet resultSet) throws SQLException {
        return new LoanOffer() // TODO
                .setId(resultSet.getLong("id"))
                .setBankName(resultSet.getString("bank_name"))
                .setOfferName(resultSet.getString("offer_name"))
                .setMaxAmount(resultSet.getBigDecimal("max_amount"))
                .setMaxDuration(resultSet.getInt("max_duration"))
                .setInterestRate(resultSet.getInt("interest_rate"))
                .setCurrency(Currency.valueOf(resultSet.getString("currency")));
    }

    @Override
    public LoanOffer save(LoanOffer loan) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, loan.getBankName());
            preparedStatement.setString(2, loan.getOfferName());
            preparedStatement.setBigDecimal(3, loan.getMaxAmount());
            preparedStatement.setInt(4, loan.getMaxDuration());
            preparedStatement.setInt(5, loan.getInterestRate());
            preparedStatement.setString(6, loan.getCurrency().name());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                loan.setId(generatedKeys.getLong(1));
                return loan;
            } else {
                throw new LoanPersistenceException("Can't create loan, id is not generated");
            }
        } catch (SQLException e) {
            throw new LoanPersistenceException("Can't create loan", e);
        }
    }

    @Override
    public LoanOffer delete(long id) {
        LoanOffer loanOffer = findById(id);

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new LoanPersistenceException("Can't delete loan", e);
        }

        return loanOffer;
    }

    @Override
    public List<LoanOffer> findByMaxAmount(BigDecimal from, BigDecimal to) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_MAX_AMOUNT);
            preparedStatement.setBigDecimal(1, from);
            preparedStatement.setBigDecimal(2, to);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<LoanOffer> loanOffers = new ArrayList<LoanOffer>();
            while (resultSet.next()) {
                loanOffers.add(createLoanOffer(resultSet));
            }
            return loanOffers;

        } catch (SQLException e) {
            throw new LoanPersistenceException("Can't find loan by max amount from " + from + " to " + to , e);
        }
    }

}

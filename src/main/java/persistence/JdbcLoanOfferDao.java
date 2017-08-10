package persistence;

import model.Currency;
import model.LoanOffer;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcLoanOfferDao implements LoanOfferDao {

    private final DataSource dataSource;

    public JdbcLoanOfferDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public LoanOffer findById(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM loan_offer WHERE id = ?");
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
                .setCurrency(Currency.valueOf(resultSet.getString("currency")));
    }

    @Override
    public LoanOffer save(LoanOffer loan) {
        return null; // TODO
    }

    @Override
    public LoanOffer delete(long id) {
        return null; // TODO
    }
}

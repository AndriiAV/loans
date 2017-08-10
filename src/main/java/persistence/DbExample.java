package persistence;

import model.LoanOffer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://db4free.net:3306/loan_db";
        String user = "andrii12345";
        String password = "andrii12345";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM loan");

            createLoanOffers(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createLoanOffers(ResultSet resultSet) throws SQLException {
        List<LoanOffer> loanOffers = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String bankName = resultSet.getString("bank_name");

            LoanOffer loanOffer = new LoanOffer()
                    .setId(id)
                    .setBankName(bankName);

            loanOffers.add(loanOffer);
        }
    }
}

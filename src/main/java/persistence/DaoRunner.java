package persistence;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import model.LoanOffer;

import javax.sql.DataSource;

public class DaoRunner {

    public static void main(String[] args) {
        LoanOfferDao loanOfferDao = new JdbcLoanOfferDao(createDataSource());
        LoanOffer loanOffer = loanOfferDao.findById(1L);
        System.out.println(loanOffer);
    }

    private static DataSource createDataSource() {
        String url = "jdbc:mysql://db4free.net:3306/loan_db";
        String user = "andrii12345";
        String password = "andrii12345";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}

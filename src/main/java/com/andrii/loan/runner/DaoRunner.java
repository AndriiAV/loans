package com.andrii.loan.runner;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.andrii.loan.model.Currency;
import com.andrii.loan.model.LoanOffer;
import com.andrii.loan.persistence.JdbcLoanOfferDao;
import com.andrii.loan.persistence.LoanOfferDao;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

public class DaoRunner {

    public static void main(String[] args) {
        LoanOfferDao loanOfferDao = new JdbcLoanOfferDao(createDataSource());

        testFindByMaxAmount(loanOfferDao);
    }

    private static void testFindByMaxAmount(LoanOfferDao loanOfferDao){
        List<LoanOffer> loanOffers = loanOfferDao.findByMaxAmount(BigDecimal.valueOf(1000), BigDecimal.valueOf(90000));
        for (LoanOffer loanOffer : loanOffers) {
            System.out.println(loanOffer);
        }
    }

    private static void testDelete(LoanOfferDao loanOfferDao){
        LoanOffer offer = loanOfferDao.delete(24L);
        System.out.println(offer);
    }

    private static void testSave(LoanOfferDao loanOfferDao) {
        LoanOffer loanOffer1 = new LoanOffer();
        loanOffer1.setBankName("qwe");
        loanOffer1.setOfferName("qwe");
        loanOffer1.setMaxAmount(BigDecimal.valueOf(100000));
        loanOffer1.setMaxDuration(60);
        loanOffer1.setInterestRate(8);
        loanOffer1.setCurrency(Currency.EUR);

        LoanOffer offer = loanOfferDao.save(loanOffer1);

        System.out.println(offer);
    }

    private static void testFindById(LoanOfferDao loanOfferDao) {
        LoanOffer loanOffer = loanOfferDao.findById(1L);
        System.out.println(loanOffer);
    }

    private static DataSource createDataSource() {
        Properties properties = getDbProperties();

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setUser(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));

        return dataSource;
    }

    public static Properties getDbProperties() {
        String dbPropertiesFile = "db.properties";
        try (InputStream inputStream = DaoRunner.class.getClassLoader().getResourceAsStream(dbPropertiesFile)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Can't find " + dbPropertiesFile + " in resources", e);
        }
    }
}

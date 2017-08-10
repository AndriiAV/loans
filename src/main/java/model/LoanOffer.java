package model;

import java.math.BigDecimal;

public class LoanOffer {
    private long id;
    private String bankName;
    private String offerName;
    private BigDecimal maxAmount;
    private int maxDuration;
    private int interestRate;
    private Currency currency;

    public long getId() {
        return id;
    }

    public LoanOffer setId(long id) {
        this.id = id;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public LoanOffer setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getOfferName() {
        return offerName;
    }

    public LoanOffer setOfferName(String offerName) {
        this.offerName = offerName;
        return this;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public LoanOffer setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public LoanOffer setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
        return this;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public LoanOffer setInterestRate(int interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LoanOffer setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public String toString() {
        return "LoanOffer{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", offerName='" + offerName + '\'' +
                ", maxAmount=" + maxAmount +
                ", maxDuration=" + maxDuration +
                ", interestRate=" + interestRate +
                ", currency=" + currency +
                '}';
    }
}

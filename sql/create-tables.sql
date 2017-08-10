CREATE TABLE loan_offer(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  bank_name VARCHAR(256),
  offer_name VARCHAR(256),
  max_amount BIGINT,
  max_duration INT,
  interest_rate INT,
  currency VARCHAR(3)
)

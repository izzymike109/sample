
-----------------------------------------------------------------------------------------------------------------------------------------
-- CURRENCY
-----------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(10) NOT NULL,
  name VARCHAR(100) NOT NULL
);


INSERT INTO currencies (code, name) VALUES ('EUR', 'Euro');
INSERT INTO currencies (code, name) VALUES ('GBP', 'British Pound');
INSERT INTO currencies (code, name) VALUES ('USD', 'US Dollar');
INSERT INTO currencies (code, name) VALUES ('CAD', 'Canadian Dollar');
INSERT INTO currencies (code, name) VALUES ('HKD', 'Hong Kong Dollar');
INSERT INTO currencies (code, name) VALUES ('AUD', 'Australian Dollar');
INSERT INTO currencies (code, name) VALUES ('NZD', 'New Zealand Dollar');
INSERT INTO currencies (code, name) VALUES ('CHF', 'Swiss Franc');


-----------------------------------------------------------------------------------------------------------------------------------------
-- RATES
-----------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS rates;

CREATE TABLE rates (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  currency VARCHAR(100) NOT NULL,
  provider VARCHAR(250) NOT NULL,
  value DECIMAL(10, 4) NOT NULL NOT NULL,
  fee DECIMAL(10, 4) NOT NULL NOT NULL,
  date TIMESTAMP DEFAULT NULL
);

INSERT INTO rates (currency, provider, value, fee, date) VALUES ('GBP', 'Bank Of Ireland', 0.91123, 0, {ts '2020-09-17 16:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('HKD', 'Bank Of Ireland', 8.9676, 0, {ts '2020-09-17 18:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('NZD', 'Bank Of Ireland', 1.75486, 0, {ts '2020-09-17 14:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('CHF', 'Bank Of Ireland', 7.4429, 0, {ts '2020-09-17 16:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('CAD', 'Bank Of Ireland', 1.5486, 0, {ts '2020-09-17 17:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('AUD', 'Bank Of Spain', 1.6246, 0, {ts '2020-09-17 18:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('NZD', 'Bank Of France', 1.7384, 0, {ts '2020-09-17 19:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('USD', 'Bank Of England', 0.91123, 0, {ts '2020-09-17 18:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('EUR', 'Bank Of Scotland', 0.91120, 0, {ts '2020-09-17 18:47:52.69'});
INSERT INTO rates (currency, provider, value, fee, date) VALUES ('EUR', 'Bank Of Spain', 0.91128, 0, {ts '2020-09-16 18:48:52.69'});

CREATE TABLE IF NOT EXISTS `INVOICE_MASTER`
(
    `INVOICE_ID`   int,
    `INVOICE_DATE` date,
    CUSTOMER_ID    int,
    PRIMARY KEY (`INVOICE_ID`)
    );

CREATE TABLE IF NOT EXISTS `INVOICE_TRANSACTION`
(
    `INVOICE_ID` int,
    `ITEM_ID`    int,
    `QTY`        int,
    PRIMARY KEY (`INVOICE_ID`)
    );

CREATE TABLE IF NOT EXISTS `ITEM_MASTER`
(
    `ITEM_ID`     int,
    `DESCRIPTION` varchar(64),
    `PRICE`       float,
    PRIMARY KEY (`ITEM_ID`)
    );

CREATE TABLE IF NOT EXISTS `CUSTOMER`
(
    `CUSTOMER_ID`      int,
    `CUSTOMER_NAME`    varchar(32),
    `CUSTOMER_ADDRESS` varchar(64),
    `CUSTOMER_PHONE`   varchar(12),
    `CUSTOMER_EMAIL`   varchar(24),
    `CUSTOMER_GST_NNO` varchar(24),
    PRIMARY KEY (`CUSTOMER_ID`)
    );

CREATE TABLE IF NOT EXISTS `USER`
(
    `USER_ID`       int,
    `USER_NAME`     varchar(24),
    `USER_PASSWORD` varchar(24),
    `FLAG`          int,
    PRIMARY KEY (`USER_ID`)
    );

DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS opinion CASCADE;
DROP TABLE IF EXISTS producer CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS purchase CASCADE;

CREATE TABLE customer
(
    customer_id      SERIAL      NOT NULL,
    user_name        VARCHAR(32) NOT NULL,
    email            VARCHAR(32) NOT NULL,
    name             VARCHAR(32) NOT NULL,
    surname          VARCHAR(32) NOT NULL,
    date_of_birth    DATE,
    telephone_number VARCHAR(64),
    PRIMARY KEY (customer_id),
    UNIQUE (user_name),
    UNIQUE (email)
);

CREATE TABLE producer
(
    producer_id   SERIAL      NOT NULL,
    producer_name VARCHAR(32) NOT NULL,
    address       VARCHAR(128),
    PRIMARY KEY (producer_id),
    UNIQUE (producer_name)
);

CREATE TABLE product
(
    product_id    SERIAL        NOT NULL,
    product_code  VARCHAR(32)   NOT NULL,
    product_name  VARCHAR(64)   NOT NULL,
    product_price NUMERIC(19, 2) NOT NULL,
    adults_only   BOOLEAN       NOT NULL,
    description   TEXT          NOT NULL,
    producer_id   INT           NOT NULL,
    PRIMARY KEY (product_id),
    UNIQUE (product_code),
    CONSTRAINT fk_product_producer
        FOREIGN KEY (producer_id)
            REFERENCES producer (producer_id)
);

CREATE TABLE purchase
(
    purchase_id SERIAL                   NOT NULL,
    customer_id INT                      NOT NULL,
    product_id  INT                      NOT NULL,
    quantity    INT                      NOT NULL,
    date_time   TIMESTAMP WITH TIME ZONE NOT NULL,
    PRIMARY KEY (purchase_id),
    CONSTRAINT fk_purchase_customer
        FOREIGN KEY (customer_id)
            REFERENCES customer (customer_id),
    CONSTRAINT fk_purchase_product
        FOREIGN KEY (product_id)
            REFERENCES product (product_id)
);

CREATE TABLE opinion
(
    opinion_id  SERIAL                               NOT NULL,
    purchase_id INT                                  NOT NULL,
    stars       INT CHECK (stars IN (0, 1, 2, 3, 4)) NOT NULL,
    comment     TEXT                                 NOT NULL,
    date_time   TIMESTAMP WITH TIME ZONE             NOT NULL,
    PRIMARY KEY (opinion_id),
    UNIQUE (purchase_id),
    CONSTRAINT fk_opinion_purchase
        FOREIGN KEY (purchase_id)
            REFERENCES purchase (purchase_id)
);
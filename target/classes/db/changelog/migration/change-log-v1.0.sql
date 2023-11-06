-- liquibase formatted sql
-- changeset santhosh:1677359372272-1
CREATE TABLE person (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

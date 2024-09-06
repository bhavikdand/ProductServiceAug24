CREATE TABLE batch_3
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_batch_3 PRIMARY KEY (id)
);

CREATE TABLE learner_3
(
    id   INT NOT NULL,
    name VARCHAR(255) NULL,
    b_id BIGINT NULL,
    CONSTRAINT pk_learner_3 PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NULL,
    category      VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE learner_3
    ADD CONSTRAINT FK_LEARNER_3_ON_B FOREIGN KEY (b_id) REFERENCES batch_3 (id);
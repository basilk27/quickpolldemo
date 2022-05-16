CREATE TABLE "user"
(
    id        BIGINT       NOT NULL,
    username  VARCHAR(30)  NOT NULL,
    password  VARCHAR(30)  NOT NULL,
    firstname VARCHAR(40)  NOT NULL,
    lastname  VARCHAR(50)  NOT NULL,
    admin     VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);
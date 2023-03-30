CREATE TABLE IF NOT EXISTS users (
    id bigint NOT NULL,
    password character varying(50),
    token character varying(120),
    username character varying(20)
);

INSERT INTO users (password, token, username) VALUES ('PASSWORD', '2176d2c3-89c8-4c3e-acab-253f9b32FFFF', 'TEST_USER');
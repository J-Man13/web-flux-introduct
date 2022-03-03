CREATE TABLE TEST_MESSAGE
(
    id SERIAL PRIMARY KEY,
    message varchar2 (255) not null,
    created  datetime
);
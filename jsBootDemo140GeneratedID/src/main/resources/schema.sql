DROP TABLE IF EXISTS animal_table;
DROP TABLE IF EXISTS drink_table;
DROP TABLE IF EXISTS faculty_table;
DROP TABLE IF EXISTS feedback_table;
DROP TABLE IF EXISTS fruit_table;
DROP TABLE IF EXISTS planet_table;
DROP TABLE IF EXISTS plant_table;

CREATE TABLE IF NOT EXISTS feedback_table
(
    id_feedback   BIGINT AUTO_INCREMENT PRIMARY KEY,
    feedback_text VARCHAR(255),
    nickname  VARCHAR(255)
);

CREATE SEQUENCE my_sequence
    START WITH 990
    INCREMENT BY 2
    MINVALUE 10
    MAXVALUE 1000
    CYCLE;

CREATE TABLE IF NOT EXISTS Message(
    message_id integer AUTO_INCREMENT PRIMARY KEY,
    text varchar(150) not null,
    created_At timestamp default current_timestamp
);

INSERT INTO Message (text) values ('Nahuel');
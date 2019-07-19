DROP DATABASE IF EXISTS RPS;
CREATE DATABASE RPS;

USE RPS;

CREATE TABLE GameRounds(
	`Id` INT PRIMARY KEY AUTO_INCREMENT,
    `PlayerChoice` VARCHAR(25),
    `ComputerChoice` VARCHAR(25),
    `TimeStamp` DATETIME
);

-- Sandbox CRUD
INSERT INTO GameRounds(`PlayerChoice`, `ComputerChoice`, `TimeStamp`) VALUES("ROCK", "PAPER", "2019-06-06");

SELECT * FROM GameRounds;
SELECT * FROM GameRounds WHERE Id = 1;

UPDATE GameRounds SET PlayerChoice = "PAPER", ComputerChoice = "ROCK", `TimeStamp` = "2019-06-07" WHERE Id = 1;

DELETE FROM GameRounds WHERE Id = 1;
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
CREATE SCHEMA IF NOT EXISTS `test_concertPlanner` DEFAULT CHARACTER SET latin1 ;
USE `test_concertPlanner`;
DROP TABLE IF EXISTS `test_concertPlanner`.`Nationality`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Nationality` (`id` INT(11) NOT NULL AUTO_INCREMENT,`nationality` VARCHAR(100) NOT NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`))ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`Composer`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Composer` (`id` INT(11) NOT NULL AUTO_INCREMENT,`first_name` VARCHAR(100) NOT NULL, `last_name` VARCHAR(100) NOT NULL, `birth_year` INT(11) NULL DEFAULT NULL, `death_year` INT(11) NULL DEFAULT NULL, `Nationality_id` INT(11) NOT NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`), INDEX `Composer_Nationality` (`Nationality_id` ASC), CONSTRAINT `Composer_Nationality` FOREIGN KEY (`Nationality_id`) REFERENCES `test_concertPlanner`.`Nationality` (`id`) ON UPDATE CASCADE) ENGINE = InnoDB AUTO_INCREMENT = 7 DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`Composition`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Composition` (`id` INT(11) NOT NULL AUTO_INCREMENT, `title` VARCHAR(100) NOT NULL, `arranger` VARCHAR(100) NULL DEFAULT NULL, `duration` INT(11) NOT NULL, `year` INT(11) NOT NULL, `number_of_players` INT(11) NOT NULL, `notes` VARCHAR(300) NULL, `Composer_id` INT(11) NOT NULL, `clocks_commission` TINYINT NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`), INDEX `Composition_Composer` (`Composer_id` ASC), CONSTRAINT `Composition_Composer` FOREIGN KEY (`Composer_id`) REFERENCES `test_concertPlanner`.`Composer` (`id`)) ENGINE = InnoDB DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.Instrument_Category;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Instrument_Category` (`id` INT(11) NOT NULL AUTO_INCREMENT, `category` VARCHAR(100) NOT NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB AUTO_INCREMENT = 21 DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`Instrument`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Instrument` (`id` INT(11) NOT NULL AUTO_INCREMENT, `name` VARCHAR(100) NOT NULL, `Instrument_Category_id` INT(11) NOT NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`), INDEX `Instrument_Instrument_Category` (`Instrument_Category_id` ASC), CONSTRAINT `Instrument_Instrument_Category` FOREIGN KEY (`Instrument_Category_id`) REFERENCES `test_concertPlanner`.Instrument_Category (`id`)) ENGINE = InnoDB AUTO_INCREMENT = 21 DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`Composition_Instrument`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Composition_Instrument` (`id` INT(11) NOT NULL AUTO_INCREMENT, `qty` INT(11) NOT NULL, `player` INT(11) NOT NULL, `Instrument_id` INT(11) NOT NULL, `Composition_id` INT(11) NOT NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`), INDEX `Composition_Instrument_Composition` (`Composition_id` ASC), INDEX `Composition_Instrument_Instrument` (`Instrument_id` ASC), CONSTRAINT `Composition_Instrument_Composition` FOREIGN KEY (`Composition_id`) REFERENCES `test_concertPlanner`.`Composition` (`id`), CONSTRAINT `Composition_Instrument_Instrument` FOREIGN KEY (`Instrument_id`) REFERENCES `test_concertPlanner`.`Instrument` (`id`)) ENGINE = InnoDB DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`Musician`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Musician` (`id` INT(11) NOT NULL AUTO_INCREMENT, `first_name` VARCHAR(50) NOT NULL, `last_name` VARCHAR(50) NOT NULL, `phone_number` VARCHAR(20) NULL, `email` VARCHAR(50) NULL, `status` VARCHAR(50) NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB AUTO_INCREMENT = 7 DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`Program`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Program` (`id` INT(11) NOT NULL AUTO_INCREMENT, `date` DATE NOT NULL, `title` VARCHAR(100) NOT NULL, `location` VARCHAR(100) NOT NULL, `address` VARCHAR(100) NOT NULL, `city` VARCHAR(100) NOT NULL, `state` VARCHAR(2) NOT NULL, `zipcode` INT(11) NOT NULL, status VARCHAR(20) NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`Composition_Program`;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Composition_Program` (`id` INT(11) NOT NULL AUTO_INCREMENT, `player` INT(11) NOT NULL, `Composition_id` INT(11) NOT NULL, `Musician_id` INT(11) NOT NULL, `Program_id` INT(11) NOT NULL, user_Id int(11) NOT NULL, PRIMARY KEY (`id`), INDEX `Composition_Program_Composition` (`Composition_id` ASC), INDEX `Composition_Program_Musician` (`Musician_id` ASC), INDEX `Composition_Program_Program` (`Program_id` ASC), CONSTRAINT `Composition_Program_Composition` FOREIGN KEY (`Composition_id`) REFERENCES `test_concertPlanner`.`Composition` (`id`), CONSTRAINT `Composition_Program_Musician` FOREIGN KEY (`Musician_id`) REFERENCES `test_concertPlanner`.`Musician` (`id`), CONSTRAINT `Composition_Program_Program` FOREIGN KEY (`Program_id`) REFERENCES `test_concertPlanner`.`Program` (`id`)) ENGINE = InnoDB DEFAULT CHARACTER SET = latin1;
DROP TABLE IF EXISTS `test_concertPlanner`.`users`;
CREATE TABLE `test_concertPlanner`.`users`(id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(40) NOT NULL, user_password VARCHAR(200) NOT NULL, ensemble_name VARCHAR(100) NULL) ENGINE = InnoDB;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.`Nationality` (`id`, `nationality`, `user_Id`) VALUES (1, 'American', 1);
INSERT INTO `test_concertPlanner`.`Nationality` (`id`, `nationality`, `user_Id`) VALUES (2, 'Muldovian', 1);
INSERT INTO `test_concertPlanner`.`Nationality` (`id`, `nationality`, `user_Id`) VALUES (3, 'French', 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.`Composer` (`id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_id`, `user_Id`) VALUES (1, 'Mark', 'Mellits', 1966, NULL, 1, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_id`, `user_Id`) VALUES (2, 'John', 'Jeffery-Gibbens', 1959, NULL, 1, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_id`, `user_Id`) VALUES (3, 'John', 'Cage', 1912, 1992, 1, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_id`, `user_Id`) VALUES (4, 'Valeria', 'Luta', NULL, NULL, 2, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_id`, `user_Id`) VALUES (5, 'John', 'Luther Adams', NULL, NULL, 1, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_id`, `user_Id`) VALUES (6, 'Steve', 'Reich', 1936, NULL, 1, 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.Instrument_Category (`id`, `category`, `user_Id`) VALUES (1, 'Keyboards', 1);
INSERT INTO `test_concertPlanner`.Instrument_Category (`id`, `category`, `user_Id`) VALUES (2, 'Skins', 1);
INSERT INTO `test_concertPlanner`.Instrument_Category (`id`, `category`, `user_Id`) VALUES (3, 'Woods', 1);
INSERT INTO `test_concertPlanner`.Instrument_Category (`id`, `category`, `user_Id`) VALUES (4, 'Metals', 1);
INSERT INTO `test_concertPlanner`.Instrument_Category (`id`, `category`, `user_Id`) VALUES (5, 'Accessories', 1);
INSERT INTO `test_concertPlanner`.Instrument_Category (`id`, `category`, `user_Id`) VALUES (6, 'Other', 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (1, 'Marimba', 1, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (2, 'Vibraphone', 1, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (3, 'Marimba - Quarter Tone', 1, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (4, 'Tuned Gong', 4, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (5, 'Galvatone - Naturals', 1, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (6, 'Galvatone - Quarter Tone', 1, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (7, 'Tin Cans', 4, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (8, 'Piano', 6, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (9, 'Drum', 2, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (10, 'Clave', 3, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (11, 'Miraccas', 5, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (12, 'Log Drum', 3, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (13, 'China Symbol', 4, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (14, 'Indo Chinese Rattle', 5, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (15, 'Lion\'s Roar', 2, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (16, 'Cow Bell', 5, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (17, 'Cricket Caller', 5, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (18, 'Vibraslap', 5, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (19, 'Conch Shell', 5, 1);
INSERT INTO `test_concertPlanner`.`Instrument` (`id`, `name`, Instrument_Category_id, `user_Id`) VALUES (20, 'Hammer Dulcimer', 6, 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.`Musician` (`id`, `first_name`, `last_name`, `phone_number`, `email`, `status`, `user_Id`) VALUES (1, 'Sean', 'Kleve', '123', 'sean@clocksinmotionpercussion.com', 'Active', 1);
INSERT INTO `test_concertPlanner`.`Musician` (`id`, `first_name`, `last_name`, `phone_number`, `email`, `status`, `user_Id`) VALUES (2, 'Matthew', 'Coley', '123', 'matthew@clocksinmotionpercussion.com', 'Active', 1);
INSERT INTO `test_concertPlanner`.`Musician` (`id`, `first_name`, `last_name`, `phone_number`, `email`, `status`, `user_Id`) VALUES (3, 'Andrew', 'Viet', '123', 'matthew@clocksinmotionpercussion.com', 'Active', 1);
INSERT INTO `test_concertPlanner`.`Musician` (`id`, `first_name`, `last_name`, `phone_number`, `email`, `status`, `user_Id`) VALUES (4, 'Kyle', 'Flens', '123', 'matthew@clocksinmotionpercussion.com', 'Substitute', 1);
INSERT INTO `test_concertPlanner`.`Musician` (`id`, `first_name`, `last_name`, `phone_number`, `email`, `status`, `user_Id`) VALUES (5, 'Garrett', 'Mendelow', '123', 'matthew@clocksinmotionpercussion.com', 'Inactive', 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.`Composition` (`Id`, `title`, `arranger`, `duration`, `year`, `clocks_commission`, `number_of_players`, `notes`, `Composer_Id`, `user_Id`) VALUES (1, 'Gravity', NULL, 1, 2010, 1, 4, NULL, 1, 1);
INSERT INTO `test_concertPlanner`.`Composition` (`Id`, `title`, `arranger`, `duration`, `year`, `clocks_commission`, `number_of_players`, `notes`, `Composer_Id`, `user_Id`) VALUES (2, 'Red', NULL, 1, 2008, 1, 2, NULL, 1, 1);
INSERT INTO `test_concertPlanner`.`Composition` (`Id`, `title`, `arranger`, `duration`, `year`, `clocks_commission`, `number_of_players`, `notes`, `Composer_Id`, `user_Id`) VALUES (3, 'Third Construction', NULL, 1, 2019, 1, 4, 'notes', 3, 1);
INSERT INTO `test_concertPlanner`.`Composition` (`Id`, `title`, `arranger`, `duration`, `year`, `clocks_commission`, `number_of_players`, `notes`, `Composer_Id`, `user_Id`) VALUES (4, 'title', 'arranger', 1, 2019, 1, 4, 'notes', 2, 1);
INSERT INTO `test_concertPlanner`.`Composition` (`Id`, `title`, `arranger`, `duration`, `year`, `clocks_commission`, `number_of_players`, `notes`, `Composer_Id`, `user_Id`) VALUES (5, 'title', 'arranger', 1, 2019, 0, 4, 'notes', 3, 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.`Composition_Instrument` (`Id`, `qty`, `player`, `Instrument_id`, `Composition_id`, `user_Id` ) VALUES (1, 1, 1, 1, 1, 1);
INSERT INTO `test_concertPlanner`.`Composition_Instrument` (`Id`, `qty`, `player`, `Instrument_id`, `Composition_id`, `user_Id` ) VALUES (2, 1, 2, 1, 1, 1);
INSERT INTO `test_concertPlanner`.`Composition_Instrument` (`Id`, `qty`, `player`, `Instrument_id`, `Composition_id`, `user_Id` ) VALUES (3, 1, 3, 2, 1, 1);
INSERT INTO `test_concertPlanner`.`Composition_Instrument` (`Id`, `qty`, `player`, `Instrument_id`, `Composition_id`, `user_Id` ) VALUES (4, 1, 4, 2, 1, 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO `test_concertPlanner`.`Program` (Id, date, title, location, address, city, state, zipcode, status, `user_Id`) VALUES (1, '2018-04-15', 'House Show', 'Living Room', '123 Sessame St', 'Rainbow', 'AZ', 53716, 'Complete', 1);
INSERT INTO `test_concertPlanner`.`Program` (Id, date, title, location, address, city, state, zipcode, status, `user_Id`) VALUES (2, '2019-01-03', 'Winter Tour', 'UW Madison', '123 Sessame St', 'Rainbow', 'WI', 53716, 'In Progress', 1);
INSERT INTO `test_concertPlanner`.`Program` (Id, date, title, location, address, city, state, zipcode, status, `user_Id`) VALUES (3, '2019-04-20', 'Spring Tour', 'CSU', '123 Sessame St', 'Rainbow', 'OH', 53716, 'TBD', 1);
INSERT INTO `test_concertPlanner`.`Program` (Id, date, title, location, address, city, state, zipcode, status, `user_Id`) VALUES (4, '2019-09-10', 'Fall Tour', 'Western MI', '123 Sessame St', 'Rainbow', 'MI', 53716, 'TBD', 1);
COMMIT;
START TRANSACTION;
USE `test_concertPlanner`;
INSERT INTO test_concertPlanner.Composition_Program (id, player, Composition_id, Musician_id, Program_id, `user_Id`) VALUES (1, 1, 1, 1, 1, 1);
INSERT INTO test_concertPlanner.Composition_Program (id, player, Composition_id, Musician_id, Program_id, `user_Id`) VALUES (2, 2, 1, 2, 1, 1);
INSERT INTO test_concertPlanner.Composition_Program (id, player, Composition_id, Musician_id, Program_id, `user_Id`) VALUES (3, 3, 1, 3, 1, 1);
INSERT INTO test_concertPlanner.Composition_Program (id, player, Composition_id, Musician_id, Program_id, `user_Id`) VALUES (4, 4, 1, 4, 1, 1);
COMMIT;
START TRANSACTION ;
USE `test_concertPlanner`;
INSERT INTO test_concertPlanner.users (id, user_name, user_password, ensemble_name) VALUES (1, 'clocks', 'clocks', 'Clocks In Motion Percussion');
INSERT INTO test_concertPlanner.users (id, user_name, user_password, ensemble_name) VALUES (2, 'admin', 'admin', 'Admin');
INSERT INTO test_concertPlanner.users (id, user_name, user_password, ensemble_name) VALUES (3, 'other', 'other', 'Some Other Ensemble');
COMMIT;
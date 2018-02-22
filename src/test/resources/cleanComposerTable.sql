ALTER TABLE `test_concertPlanner.Composer` DROP FOREIGN KEY Composer_Nationality_fk;
DROP TABLE IF EXISTS `test_concertPlanner`.`Nationality` ;
DROP TABLE Composer;
CREATE TABLE IF NOT EXISTS `test_concertPlanner`.`Nationality` (`Id` INT(11) NOT NULL AUTO_INCREMENT,`nationality` VARCHAR(100) NOT NULL,PRIMARY KEY (`Id`))ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARACTER SET = latin1;
INSERT INTO `Nationality` VALUES (1, 'American'),(2, 'Spanish'),(3, 'French');
create table Composer(id int auto_increment primary key, first_name varchar(50) null, last_name varchar(50) null, birth_year int null, death_year int null, Nationality_id int not null, constraint Composer_Nationality_fk foreign key (Nationality_id) references Nationality (id) on update cascade) engine=InnoDB;
INSERT INTO `Composer` VALUES (1, 'John', 'Cage', 1945,1873, 1);
INSERT INTO `Composer` VALUES (2, 'Marc', 'Mellits', 1111, 123, 1);
INSERT INTO `Composer` VALUES (3, 'Some', 'Guy', 233, 233, 2);
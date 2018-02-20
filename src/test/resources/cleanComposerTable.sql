ALTER TABLE Composer DROP FOREIGN KEY Composer_Nationality_fk;
DROP TABLE Nationality;
DROP TABLE Composer;
CREATE TABLE Nationality(id INT AUTO_INCREMENT PRIMARY KEY, nationality VARCHAR(50) NOT NULL) ENGINE = InnoDB;
INSERT INTO `Nationality` VALUES (1, 'American'),(2, 'Spanish'),(3, 'French');
create table Composer(id int auto_increment primary key, first_name varchar(50) null, last_name varchar(50) null, birth_year int null, death_year int null, Nationality_id int not null, constraint Composer_Nationality_fk foreign key (Nationality_id) references test_concertplanner.Nationality (id) on update cascade on delete cascade) engine=InnoDB;
INSERT INTO `Composer` VALUES (1, 'John', 'Cage', 1945,1873, 1);
INSERT INTO `Composer` VALUES (2, 'Marc', 'Mellits', 1111, 123, 1);
INSERT INTO `Composer` VALUES (3, 'Some', 'Guy', 233, 233, 2);
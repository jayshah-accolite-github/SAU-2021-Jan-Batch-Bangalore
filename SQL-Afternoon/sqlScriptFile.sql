CREATE DATABASE `crickDbNew` ;
Use `crickDbNew`;
CREATE TABLE   `teamtable` (
  `teamId` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`teamId`));


INSERT INTO   `teamtable` (`teamId`, `country`) VALUES ('1', 'India');
INSERT INTO   `teamtable` (`teamId`, `country`) VALUES ('2', 'Aus');
INSERT INTO   `teamtable` (`teamId`, `country`) VALUES ('3', 'Pak');
INSERT INTO   `teamtable` (`teamId`, `country`) VALUES ('4', 'England');

CREATE TABLE `playertypetable` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`typeId`)
) ;


INSERT INTO   `playertypetable` (`typeId`, `type`) VALUES ('1', 'Batsmen');
INSERT INTO   `playertypetable` (`typeId`, `type`) VALUES ('2', 'Bowler');
INSERT INTO   `playertypetable` (`typeId`, `type`) VALUES ('3', 'All Rounder');



CREATE TABLE   `playertable` (
  `playerId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `teamId` INT NOT NULL,
  `typeId` INT NOT NULL,
  PRIMARY KEY (`playerId`),
  CONSTRAINT `teamId`
    FOREIGN KEY (`teamId`)
    REFERENCES   `teamtable` (`teamId`),
  CONSTRAINT `typeId`
    FOREIGN KEY (`typeId`)
    REFERENCES   `playertypetable` (`typeId`)
  );

ALTER TABLE   `playertable` 
ADD COLUMN `totalRuns` INT NOT NULL DEFAULT 0 AFTER `typeId`,
ADD COLUMN `totalWickets` INT NOT NULL DEFAULT 0 AFTER `totalRuns`;


INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('1', 'IAa', '1', '1');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('2', 'IBb', '1', '2');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('3', 'ICc', '1', '3');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('4', 'IDd', '1', '1');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('5', 'AAa', '2', '1');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('6', 'ABb', '2', '1');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('7', 'ACc', '2', '2');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('8', 'ADd', '2', '2');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('9', 'PAa', '3', '1');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('10', 'PBb', '3', '2');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('11', 'PCc', '3', '3');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('12', 'PDd', '3', '3');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('13', 'EAa', '4', '1');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('14', 'EBb', '4', '2');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('15', 'ECc', '4', '2');
INSERT INTO   `playertable` (`playerId`, `name`, `teamId`, `typeId`) VALUES ('16', 'EDd', '4', '1');

CREATE TABLE   `matchcombination` (
  `matchupId` INT NOT NULL,
  `teamA` INT NOT NULL,
  `teamB` INT NOT NULL,
  PRIMARY KEY (`matchupId`));


INSERT INTO   `matchcombination` (`matchupId`, `teamA`, `teamB`) VALUES ('1', '1', '2');
INSERT INTO   `matchcombination` (`matchupId`, `teamA`, `teamB`) VALUES ('2', '1', '3');
INSERT INTO   `matchcombination` (`matchupId`, `teamA`, `teamB`) VALUES ('3', '1', '4');
INSERT INTO   `matchcombination` (`matchupId`, `teamA`, `teamB`) VALUES ('4', '2', '3');
INSERT INTO   `matchcombination` (`matchupId`, `teamA`, `teamB`) VALUES ('5', '2', '4');
INSERT INTO   `matchcombination` (`matchupId`, `teamA`, `teamB`) VALUES ('6', '3', '4');


CREATE TABLE   `matcheslog` (
  `matchId` INT NOT NULL AUTO_INCREMENT,
  `matchUpId` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`matchId`),
 
  CONSTRAINT `matchUpId`
    FOREIGN KEY (`matchUpId`)
    REFERENCES   `matchcombination` (`matchupId`)
   );


INSERT INTO   `matcheslog` (`matchId`, `matchUpId`, `date`) VALUES ('1', '1', '2021/01/01');
INSERT INTO   `matcheslog` (`matchId`, `matchUpId`, `date`) VALUES ('2', '2', '2021/02/02');
INSERT INTO   `matcheslog` (`matchId`, `matchUpId`, `date`) VALUES ('3', '5', '2021/03/03');


CREATE TABLE   `matchdetails` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `matchId` INT NOT NULL,
  `teamId` INT NOT NULL,
  `runsScored` INT NOT NULL,
  `wicketTaken` INT NOT NULL,
  PRIMARY KEY (`id`),

  CONSTRAINT `matchId`
    FOREIGN KEY (`matchId`)
    REFERENCES   `matcheslog` (`matchId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


ALTER TABLE   `matchdetails` 
ADD COLUMN `winStatus` VARCHAR(3) NOT NULL AFTER `wicketTaken`;

INSERT INTO   `matchdetails` (`id`, `matchId`, `teamId`, `runsScored`, `wicketTaken`, `winStatus`) VALUES ('1', '1', '1', '130', '2', 'Yes');
INSERT INTO   `matchdetails` (`id`, `matchId`, `teamId`, `runsScored`, `wicketTaken`, `winStatus`) VALUES ('2', '1', '2', '89', '1', 'No');
INSERT INTO   `matchdetails` (`id`, `matchId`, `teamId`, `runsScored`, `wicketTaken`, `winStatus`) VALUES ('3', '2', '1', '120', '1', 'No');
INSERT INTO   `matchdetails` (`id`, `matchId`, `teamId`, `runsScored`, `wicketTaken`, `winStatus`) VALUES ('4', '2', '3', '121', '1', 'Yes');
INSERT INTO   `matchdetails` (`id`, `matchId`, `teamId`, `runsScored`, `wicketTaken`, `winStatus`) VALUES ('5', '3', '2', '150', '2', 'Yes');
INSERT INTO   `matchdetails` (`id`, `matchId`, `teamId`, `runsScored`, `wicketTaken`, `winStatus`) VALUES ('6', '3', '4', '111', '1', 'No');



CREATE TABLE   `runswickettable` (
  `id` INT NOT NULL,
  `playerId` INT NOT NULL,
  `matchId` INT NOT NULL,
  `runsScored` INT NOT NULL,
  `wicketTaken` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `playerId`
    FOREIGN KEY (`playerId`)
    REFERENCES   `playertable` (`playerId`)
);
DROP TRIGGER IF EXISTS   `runswickettable_AFTER_INSERT`;

DELIMITER $$

CREATE TRIGGER `runswickettable_AFTER_INSERT` AFTER INSERT ON `runswickettable` FOR EACH ROW
BEGIN
 UPDATE playertable
     SET totalRuns = totalRuns+NEW.runsScored,
     totalWickets = totalWickets+NEW.wicketTaken
     
   WHERE playerId = NEW.playerId;
END$$
DELIMITER ;


INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('1', '1', '1', '75', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('2', '2', '1', '35', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('3', '3', '1', '10', '2');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('4', '4', '1', '0', '2');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('5', '5', '1', '34', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('6', '6', '1', '25', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('7', '7', '1', '15', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('8', '8', '1', '15', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('9', '1', '1', '60', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('10', '2', '2', '60', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('11', '3', '2', '0', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('12', '4', '2', '0', '2');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('13', '9', '2', '50', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('14', '10', '2', '50', '2');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('15', '11', '2', '10', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('16', '12', '2', '11', '2');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('17', '5', '2', '60', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('18', '6', '3', '45', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('19', '7', '3', '15', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('20', '8', '3', '30', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('21', '13', '3', '55', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('22', '14', '3', '35', '0');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('23', '15', '3', '20', '1');
INSERT INTO   `runswickettable` (`id`, `playerId`, `matchId`, `runsScored`, `wicketTaken`) VALUES ('24', '16', '3', '1', '2');


DROP procedure IF EXISTS `highestCountryScore`;

DELIMITER $$

CREATE PROCEDURE `highestCountryScore`(
IN  countryName VARCHAR(25)
)
BEGIN
select runsScored AS MAX_RUNS_TILL_DATE  from matchdetails where 
teamId=(Select teamId from teamtable where country =countryName) 
order by runsScored DESC limit 1;
END$$

DELIMITER ;







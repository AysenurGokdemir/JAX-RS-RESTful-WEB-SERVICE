CREATE SCHEMA `firmaveritabani` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `firmaveritabani`.`musteri` (
  `musteriId` INT NOT NULL AUTO_INCREMENT,
  `musterino` INT NULL,
  `musteriadi` VARCHAR(45) NULL,
  `musterisoyadi` VARCHAR(45) NULL,
  PRIMARY KEY (`musteriId`));
 

  
INSERT INTO `firmaveritabani`.`musteri` (`musterino`, `musteriadi`, `musterisoyadi`) VALUES ('152', 'Ayşenur', 'Gökdemir');
INSERT INTO `firmaveritabani`.`musteri` (`musterino`, `musteriadi`, `musterisoyadi`) VALUES ('155', 'Elif', 'Aslan');
INSERT INTO `firmaveritabani`.`musteri` (`musterino`, `musteriadi`, `musterisoyadi`) VALUES ('157', 'Aybike ', 'Aslan');
INSERT INTO `firmaveritabani`.`musteri` (`musterino`, `musteriadi`, `musterisoyadi`) VALUES ('165', 'Ali', 'Gökdemir');

SELECT * FROM firmaveritabani.mustmusterieri;
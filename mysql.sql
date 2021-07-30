CREATE USER 'hibernate'@'localhost' IDENTIFIED BY 'hibernate';

GRANT ALL PRIVILEGES ON * . * TO 'hibernate'@'localhost';


CREATE DATABASE IF NOT EXISTS `customer_tracker`  DEFAULT CHARACTER SET utf8mb4;

USE `customer_tracker`;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(45) DEFAULT NULL,
                            `last_name` varchar(45) DEFAULT NULL,
                            `email` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6;

INSERT INTO `customer` VALUES
                           (1,'Alojz','PlytaOSBcki','kaloryfer@mosir.ro'),
                           (2,'Genowefsław','Obetnijpaznokcieski','zwyciezkiskladkaiserslautern@tomus.hajto'),
                           (3,'Świętopełk','NullPointerExceptionwicz','ocetspirytusowyzamiastsmietany@babish.com'),
                           (4,'Okrężnicjusz','Get2forPriceOf3wski','zapaleniedziasel@belzebub.cz'),
                           (5,'Ferdynand','MitochondriumIsAPowerhouseOfTheCellcki','d4isCheese@sub800.elo');

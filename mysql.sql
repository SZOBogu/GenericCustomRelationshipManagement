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


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`         int         NOT NULL AUTO_INCREMENT,
    `username`   varchar(50) NOT NULL,
    `password`   varchar(69) NOT NULL,
    `first_name` varchar(50) NOT NULL,
    `last_name`  varchar(50) NOT NULL,
    `email`      varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `users`(username, password, first_name, last_name, email)
VALUES ('maciek', '$2a$12$bHx0EVzZowlb82v0GEyWheJzisQicb6ntf5hK3OwMlMC2YCZ3T8Vy', 'Maciek',
        'Majtyprecz', 'swedzacygolen@kurkuma.as'),
       ('domino', '$2a$12$bHx0EVzZowlb82v0GEyWheJzisQicb6ntf5hK3OwMlMC2YCZ3T8Vy', 'Domino', 'Jachas',
        'hotdogisadlaciot@galak.pizza'),
       ('panandrzej', '$2a$12$bHx0EVzZowlb82v0GEyWheJzisQicb6ntf5hK3OwMlMC2YCZ3T8Vy', 'Pan', 'Andrzej',
        'agdybymzgolilwas@roman.ru');

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`
(
    `id`   int         NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `roles` (name)
VALUES ('ROLE_EMPLOYEE'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles`
(
    `user_id` int NOT NULL,
    `role_id` int NOT NULL,

    PRIMARY KEY (`user_id`, `role_id`),

    KEY `FK_ROLE_idx` (`role_id`),

    CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`)
        REFERENCES `roles` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `users_roles` (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 3);
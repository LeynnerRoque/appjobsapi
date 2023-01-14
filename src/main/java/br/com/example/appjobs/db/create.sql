-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema appjobs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema appjobs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `appjobs` DEFAULT CHARACTER SET utf8 ;
USE `appjobs` ;

-- -----------------------------------------------------
-- Table `appjobs`.`enterprise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`enterprise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `foundation_name` VARCHAR(200) NULL DEFAULT NULL,
  `email` VARCHAR(200) NULL DEFAULT NULL,
  `phone_number` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 175715
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `appjobs`.`job`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`job` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  `salary` DOUBLE NULL DEFAULT NULL,
  `enterprise` INT NOT NULL,
  `enterprise_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_job_enterprise_idx` (`enterprise_id` ASC) VISIBLE,
  CONSTRAINT `fk_job_enterprise`
    FOREIGN KEY (`enterprise_id`)
    REFERENCES `appjobs`.`enterprise` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `appjobs`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street_address` VARCHAR(100) NULL DEFAULT NULL,
  `postal_code` VARCHAR(11) NULL DEFAULT NULL,
  `city` VARCHAR(200) NULL DEFAULT NULL,
  `state_province` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 53
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `appjobs`.`peoples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`peoples` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `gender` VARCHAR(2) NULL DEFAULT NULL,
  `age` INT NULL DEFAULT NULL,
  `region_name` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `phone` VARCHAR(11) NULL DEFAULT NULL,
  `job` INT NOT NULL,
  `location` INT NOT NULL,
  `location_id` INT NOT NULL,
  `job_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_peoples_location1_idx` (`location_id` ASC) VISIBLE,
  INDEX `fk_peoples_job1_idx` (`job_id` ASC) VISIBLE,
  CONSTRAINT `fk_peoples_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `appjobs`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_peoples_job1`
    FOREIGN KEY (`job_id`)
    REFERENCES `appjobs`.`job` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

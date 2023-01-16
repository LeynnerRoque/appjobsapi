-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema appjobs
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `appjobs` ;

-- -----------------------------------------------------
-- Schema appjobs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `appjobs` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `appjobs` ;

-- -----------------------------------------------------
-- Table `appjobs`.`enterprise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`enterprise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `foundation_name` VARCHAR(200) NULL,
  `email` VARCHAR(200) NULL,
  `phone_number` VARCHAR(11) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `appjobs`.`job`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`job` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL,
  `description` VARCHAR(100) NULL,
  `salary` DOUBLE NULL,
  `enterprise_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `appjobs`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street_address` VARCHAR(100) NULL,
  `postal_code` VARCHAR(11) NULL,
  `city` VARCHAR(200) NULL,
  `state_province` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `appjobs`.`peoples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appjobs`.`peoples` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `gender` VARCHAR(2) NULL,
  `age` INT NULL,
  `region_name` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(11) NULL,
  `job_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



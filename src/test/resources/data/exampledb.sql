-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2015 at 03:03 PM
-- Server version: 5.6.24
-- PHP Version: 5.5.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `exampledb`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--
-- CREATE DATABASE 'exampledb' IF NOT EXISTS;
-- USE 'exampledb';

-- CREATE TABLE IF NOT EXISTS `employee` (
--   `id` bigint(20) NOT NULL,
--   `emp_name` varchar(50) NOT NULL,
--   `emp_designation` varchar(50) NOT NULL,
--   `emp_salary` float NOT NULL
-- ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `emp_name`, `emp_designation`, `emp_salary`) VALUES
(111, 'Uzumaki Naruto', 'Hokage', 125000),
(222, 'Uchiha Sasuke', 'Rogeu Shinobi', 105000),
(333, 'Monkey D. Luffy', 'Mugiwara Captain', 500000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
-- ALTER TABLE `employee`
--   ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
-- ALTER TABLE `employee`
--   MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

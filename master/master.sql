-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 14, 2019 at 04:42 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `master`
--

-- --------------------------------------------------------

--
-- Table structure for table `tanda_jadis`
--

CREATE TABLE `tanda_jadis` (
  `id` int(11) NOT NULL,
  `tanda_jadi` varchar(50) NOT NULL,
  `created` date NOT NULL,
  `create_by` varchar(50) NOT NULL,
  `modified` varchar(50) NOT NULL,
  `mod_by` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tanda_jadis`
--

INSERT INTO `tanda_jadis` (`id`, `tanda_jadi`, `created`, `create_by`, `modified`, `mod_by`) VALUES
(0, '', '2019-02-14', '', '', ''),
(825, '', '2019-02-14', '', '', ''),
(933, '', '2019-02-14', '', '', ''),
(5, '', '2019-02-14', '', '', ''),
(0, '', '2019-02-14', '', '', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 30, 2014 at 07:18 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `myorganiser`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity-tracker`
--

CREATE TABLE IF NOT EXISTS `activity-tracker` (
  `createdBy` int(11) NOT NULL,
  `creates` int(11) NOT NULL,
  `createdOn` timestamp NOT NULL,
  `modifiedOn` timestamp NOT NULL,
  PRIMARY KEY (`createdBy`,`creates`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `dateofbirth` date NOT NULL,
  `secretquestion` varchar(255) NOT NULL,
  `secretanswer` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user-activity`
--

CREATE TABLE IF NOT EXISTS `user-activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user-appointments`
--

CREATE TABLE IF NOT EXISTS `user-appointments` (
  `id` int(11) NOT NULL,
  `date-of-appointment` date NOT NULL,
  `purpose` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `duration` int(11) NOT NULL,
  `priority` enum('low','medium','high') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user-events`
--

CREATE TABLE IF NOT EXISTS `user-events` (
  `id` int(11) NOT NULL,
  `venue` varchar(255) NOT NULL,
  `start-date` date NOT NULL,
  `end-date` date NOT NULL,
  `occurrence` enum('daily','weekly','monthly','annually') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user-notes`
--

CREATE TABLE IF NOT EXISTS `user-notes` (
  `id` int(11) NOT NULL,
  `text` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user-notes-images`
--

CREATE TABLE IF NOT EXISTS `user-notes-images` (
  `id` int(11) NOT NULL,
  `image` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userphone`
--

CREATE TABLE IF NOT EXISTS `userphone` (
  `id` int(11) NOT NULL,
  `phone` double NOT NULL,
  PRIMARY KEY (`id`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `activity-tracker`
--
ALTER TABLE `activity-tracker`
  ADD CONSTRAINT `activity-tracker_ibfk_1` FOREIGN KEY (`createdBy`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user-appointments`
--
ALTER TABLE `user-appointments`
  ADD CONSTRAINT `user-appointments_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user-activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user-events`
--
ALTER TABLE `user-events`
  ADD CONSTRAINT `user-events_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user-activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user-notes`
--
ALTER TABLE `user-notes`
  ADD CONSTRAINT `user-notes_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user-activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user-notes-images`
--
ALTER TABLE `user-notes-images`
  ADD CONSTRAINT `user-notes-images_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user-notes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `userphone`
--
ALTER TABLE `userphone`
  ADD CONSTRAINT `userphone_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

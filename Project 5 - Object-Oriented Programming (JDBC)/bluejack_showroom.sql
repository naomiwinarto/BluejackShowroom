-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2022 at 09:59 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bluejack_showroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `VehicleId` char(5) NOT NULL,
  `VehicleName` varchar(255) NOT NULL,
  `VehiclePrice` int(11) NOT NULL,
  `VehicleGas` varchar(255) NOT NULL,
  `SeatbeltColor` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`VehicleId`, `VehicleName`, `VehiclePrice`, `VehicleGas`, `SeatbeltColor`) VALUES
('VE001', 'Honda Brio', 15000, 'Pertamax', 'Black'),
('VE002', 'Toyota Kijang Innova', 30000, 'Solar', 'Red'),
('VE003', 'Honda HRV', 32000, 'Premium', 'Gray'),
('VE004', 'Mitsubishi Xpander', 23000, 'Pertamax', 'Black'),
('VE005', 'Daihatsu Xenia', 20020, 'Pertamax', 'Gray');

-- --------------------------------------------------------

--
-- Table structure for table `motorcycle`
--

CREATE TABLE `motorcycle` (
  `VehicleId` char(5) NOT NULL,
  `VehicleName` varchar(255) NOT NULL,
  `VehiclePrice` int(11) NOT NULL,
  `VehicleGas` varchar(255) NOT NULL,
  `HelmCount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `motorcycle`
--

INSERT INTO `motorcycle` (`VehicleId`, `VehicleName`, `VehiclePrice`, `VehicleGas`, `HelmCount`) VALUES
('VE006', 'Honda Vario 125', 2100, 'Pertalite', 2),
('VE007', 'Kawasaki Ninja ZX-25R', 9000, 'Pertamax', 1),
('VE008', 'Honda CRF150L', 3400, 'Premium', 2),
('VE009', 'Honda Beat Street', 1700, 'Pertamax', 2),
('VE010', 'Yamaha MX King', 2500, 'Pertamax', 1);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `TransactionId` char(5) NOT NULL,
  `VehicleId` char(5) NOT NULL,
  `CustomerName` varchar(255) NOT NULL,
  `CustomerEmail` varchar(255) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`VehicleId`);

--
-- Indexes for table `motorcycle`
--
ALTER TABLE `motorcycle`
  ADD PRIMARY KEY (`VehicleId`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`TransactionId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

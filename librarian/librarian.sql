-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2020 at 01:24 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarian`
--

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `id` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `no_hp` varchar(12) NOT NULL,
  `tanggal_kunjungan` date NOT NULL,
  `alamat` text NOT NULL,
  `asal_sekolah` varchar(200) NOT NULL,
  `tujuan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`id`, `nama`, `no_hp`, `tanggal_kunjungan`, `alamat`, `asal_sekolah`, `tujuan`) VALUES
(2, 'Aldiansyah Fahmi', '085248565678', '2020-11-15', 'Jl. Gunung Batu No 12', 'STMIK Akba Makassar', 'Membaca buku tentang Java Programming language'),
(3, 'Muh Nur Ichsan', '085290869876', '2020-11-14', 'Bumi Sudiang Raya No 1', 'STMIK Dipanegara Makassar', 'Mencari Buku Algoritma dan Data Structure'),
(6, 'M. Taufiq Hidayat', '082347616550', '2020-11-16', 'Jl. P. Kemerdekaan KM 17', 'STMIK Handayani Makassar', 'Mencari referensi mengenai ilmu teknologi dalam penerapannya di dunia kesehatan\n'),
(24, 'Kamelia Taufiq', '082321345671', '2020-11-17', 'BPS Sudiang', 'UIN Alaudin Makassar', 'Belajar dan membiasakan diri dengan buku.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

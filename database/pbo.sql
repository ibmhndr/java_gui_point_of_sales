-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 29 Mei 2019 pada 17.07
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jenis`, `harga`, `stok`) VALUES
(1, 'Coca-cola 1500ml', 'minuman', 11000, 148),
(2, 'Chitato Snack Potato Chips Ayam Bumbu 68G', 'snack', 10500, 286),
(3, 'Lux Sabun Kecantikan Lux Camellia White Pump [560 mL]', 'sabun', 35000, 199),
(4, 'Head & Shoulders Shampoo Cool Menthol 330ml', 'sampo', 40000, 296),
(5, 'Piattos Keripik Rasa Sapi Panggang 50gr', 'snack', 5000, 295),
(6, 'Snack FUGU 8G', 'snack', 1000, 490),
(7, 'Big Cola Pet 1.8', 'minuman', 10000, 196),
(8, 'Pantene Shampoo Total Damage Care 900ml', 'sampo', 60000, 100),
(9, 'Nuvo Active Clean Bar Soa', 'sabun', 3000, 494),
(10, 'Dettol Barsoap Original 105 gr', 'sabun', 5000, 500),
(11, 'Pepsodent White[225 g]', 'odol', 11000, 100);

-- --------------------------------------------------------

--
-- Struktur dari tabel `beli`
--

CREATE TABLE `beli` (
  `id_beli` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `beli`
--

INSERT INTO `beli` (`id_beli`, `id_barang`, `kuantitas`, `total_harga`, `id_transaksi`) VALUES
(1, 7, 2, 20000, 1),
(2, 3, 1, 35000, 1),
(3, 2, 2, 21000, 1),
(4, 2, 4, 42000, 2),
(5, 2, 8, 84000, 2),
(14, 1, 2, 22000, 3),
(22, 7, 2, 20000, 4),
(23, 9, 4, 12000, 4),
(24, 4, 4, 160000, 5),
(25, 9, 2, 6000, 5);

--
-- Trigger `beli`
--
DELIMITER $$
CREATE TRIGGER `kembali` AFTER DELETE ON `beli` FOR EACH ROW BEGIN
UPDATE barang SET barang.stok = barang.stok + old.kuantitas WHERE old.id_barang = barang.id_barang;
DELETE FROM transaksi WHERE id_transaksi=old.id_transaksi;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `kurang` AFTER INSERT ON `beli` FOR EACH ROW UPDATE barang SET barang.stok = barang.stok - new.kuantitas WHERE new.id_barang = barang.id_barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `history_barang`
--

CREATE TABLE `history_barang` (
  `id_history` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `deskripsi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `no_login` int(11) NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `waktu` time DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `logout` datetime DEFAULT NULL,
  `kondisi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`no_login`, `username`, `tanggal`, `waktu`, `level`, `logout`, `kondisi`) VALUES
(1, 'wayan', '2019-05-29', '21:11:39', 2, '2019-05-29 21:28:34', 2),
(2, 'wayan', '2019-05-29', '21:11:50', 2, '2019-05-29 21:28:34', 2),
(3, 'wayan', '2019-05-29', '21:25:23', 2, '2019-05-29 21:28:34', 2),
(4, 'wayan', '2019-05-29', '21:26:36', 2, '2019-05-29 21:28:34', 2),
(5, 'wayan', '2019-05-29', '21:28:17', 2, '2019-05-29 21:28:34', 2),
(6, 'wayan', '2019-05-29', '21:30:52', 2, '2019-05-29 21:31:00', 2),
(7, 'wayan', '2019-05-29', '21:31:13', 2, '2019-05-29 21:47:40', 2),
(8, 'made', '2019-05-29', '21:49:04', 2, '2019-05-29 21:49:12', 2),
(9, 'wayan', '2019-05-29', '21:53:27', 2, '2019-05-29 21:53:37', 2),
(10, 'made', '2019-05-29', '23:06:22', 2, '2019-05-29 23:06:27', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tambah_stok`
--

CREATE TABLE `tambah_stok` (
  `id_ts` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `kuantitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tambah_stok`
--

INSERT INTO `tambah_stok` (`id_ts`, `id_barang`, `username`, `date`, `time`, `kuantitas`) VALUES
(1, 1, 'agus', '2019-05-27', '01:08:14', 50),
(2, 7, 'agus', '2019-05-27', '02:58:18', 24),
(3, 6, 'gevin', '2019-05-27', '14:03:55', 15),
(4, 9, 'gevin', '2019-05-27', '16:04:28', 4),
(5, 10, 'gevin', '2019-05-27', '16:04:32', 1);

--
-- Trigger `tambah_stok`
--
DELIMITER $$
CREATE TRIGGER `tambah_stok` AFTER INSERT ON `tambah_stok` FOR EACH ROW UPDATE barang SET barang.stok = new.kuantitas + barang.stok WHERE new.id_barang = barang.id_barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `total_semua` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `username` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `total_semua`, `date`, `time`, `username`) VALUES
(1, 76000, '2019-05-27', '16:27:44', 'wayan'),
(2, 126000, '2019-05-27', '16:28:03', 'wayan'),
(3, 22000, '2019-05-29', '13:25:42', 'satya'),
(4, 32000, '2019-05-29', '14:01:49', 'wayan'),
(5, 166000, '2019-05-29', '21:31:32', 'wayan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  `level` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `nama`, `password`, `level`) VALUES
('agus', 'Agus W', '123', 1),
('gevin', 'Gevin Jani', '123', 1),
('ketut', 'Ketut Sumardana', 'asd', 2),
('made', 'Made Muli', 'asd', 2),
('mahendra', 'Gus Mahendra', '123', 1),
('nengah', 'Nengah Suprapta', 'asd', 2),
('nyoman', 'Nyoman Triguna', 'asd', 2),
('pasek', 'Pasek Wahyu', '123', 1),
('putu', 'Putu Badil', 'asd', 2),
('satya', 'Satya Vyasa', '123', 1),
('teguh', 'Teguh M', '123', 1),
('wayan', 'Wayan Koder', 'asd', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `beli`
--
ALTER TABLE `beli`
  ADD PRIMARY KEY (`id_beli`);

--
-- Indexes for table `history_barang`
--
ALTER TABLE `history_barang`
  ADD PRIMARY KEY (`id_history`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`no_login`);

--
-- Indexes for table `tambah_stok`
--
ALTER TABLE `tambah_stok`
  ADD PRIMARY KEY (`id_ts`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `beli`
--
ALTER TABLE `beli`
  MODIFY `id_beli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `history_barang`
--
ALTER TABLE `history_barang`
  MODIFY `id_history` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `no_login` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tambah_stok`
--
ALTER TABLE `tambah_stok`
  MODIFY `id_ts` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

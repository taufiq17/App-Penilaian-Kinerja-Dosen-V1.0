-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2018 at 12:46 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dv_aknkajen_pdosen`
--

-- --------------------------------------------------------

--
-- Table structure for table `akn_gedung`
--

CREATE TABLE `akn_gedung` (
  `kd_gedung` char(3) NOT NULL,
  `nama_gedung` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `akn_jurusan`
--

CREATE TABLE `akn_jurusan` (
  `kd_jur` char(3) NOT NULL,
  `jurusan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akn_jurusan`
--

INSERT INTO `akn_jurusan` (`kd_jur`, `jurusan`) VALUES
('J01', 'Teknik Komputer dan Informatika'),
('J02', 'Teknik Kimia Tekstil'),
('J03', 'Teknik Mesin');

-- --------------------------------------------------------

--
-- Table structure for table `akn_kelas`
--

CREATE TABLE `akn_kelas` (
  `id_kelas` tinyint(4) NOT NULL,
  `kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akn_kelas`
--

INSERT INTO `akn_kelas` (`id_kelas`, `kelas`) VALUES
(111, 'RPLA');

-- --------------------------------------------------------

--
-- Table structure for table `akn_prodi`
--

CREATE TABLE `akn_prodi` (
  `kd_prodi` char(3) NOT NULL,
  `kd_jur` char(3) NOT NULL,
  `prodi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akn_prodi`
--

INSERT INTO `akn_prodi` (`kd_prodi`, `kd_jur`, `prodi`) VALUES
('125', 'J03', 'D2 Teknik Mesin'),
('144', 'J02', 'D2 Teknik Kimia'),
('153', 'J01', 'D2 Teknik Informatika');

-- --------------------------------------------------------

--
-- Table structure for table `akn_ruang`
--

CREATE TABLE `akn_ruang` (
  `kd_ruang` char(6) NOT NULL,
  `kd_gedung` char(3) NOT NULL,
  `nama_ruang` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `akn_thajaran`
--

CREATE TABLE `akn_thajaran` (
  `id_th` int(4) NOT NULL,
  `tahun_ajaran` varchar(9) NOT NULL,
  `semester` enum('Gasal','Genap','','') NOT NULL,
  `sta_aktif` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akn_thajaran`
--

INSERT INTO `akn_thajaran` (`id_th`, `tahun_ajaran`, `semester`, `sta_aktif`) VALUES
(1, '2014-2015', 'Gasal', 0),
(2, '2014-2015', 'Genap', 0),
(3, '2015-2016', 'Gasal', 0),
(4, '2015-2016', 'Genap', 0),
(5, '2016-2017', 'Gasal', 0),
(6, '2016-2017', 'Genap', 0),
(7, '2017-2018', 'Gasal', 0),
(8, '2017-2018', 'Genap', 0);

-- --------------------------------------------------------

--
-- Table structure for table `akn_thangkatan`
--

CREATE TABLE `akn_thangkatan` (
  `id_ta` int(4) NOT NULL,
  `th_angkatan` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akn_thangkatan`
--

INSERT INTO `akn_thangkatan` (`id_ta`, `th_angkatan`) VALUES
(1, '2018'),
(2, '2016'),
(3, '2017'),
(4, '2015');

-- --------------------------------------------------------

--
-- Table structure for table `akn_user`
--

CREATE TABLE `akn_user` (
  `id_user` char(5) NOT NULL,
  `nama_user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `lev_user` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akn_user`
--

INSERT INTO `akn_user` (`id_user`, `nama_user`, `pass`, `lev_user`) VALUES
('ID001', 'TU AKN Kajen 1', '21232f297a57a5a743894a0e4a801fc3', 'Tata Usaha'),
('ID002', 'Atik', 'e10adc3949ba59abbe56e057f20f883e', 'Tata Usaha'),
('KP001', 'Fitri Diani', '21232f297a57a5a743894a0e4a801fc3', 'Kaprodi');

-- --------------------------------------------------------

--
-- Table structure for table `mhs_mahasiswa`
--

CREATE TABLE `mhs_mahasiswa` (
  `nim` char(9) NOT NULL,
  `kd_prodi` char(3) NOT NULL,
  `id_ta` int(4) NOT NULL,
  `nama_mhs` varchar(50) NOT NULL,
  `tmp_lahir` varchar(25) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `jns_kel` enum('L','P') NOT NULL,
  `agama` varchar(10) NOT NULL,
  `no_telp` varchar(25) DEFAULT NULL,
  `nama_ayah` varchar(35) DEFAULT NULL,
  `nama_ibu` varchar(35) DEFAULT NULL,
  `pkj_ayah` varchar(25) DEFAULT NULL,
  `pkj_ibu` varchar(25) DEFAULT NULL,
  `peng_ayah` double DEFAULT NULL,
  `peng_ibu` double DEFAULT NULL,
  `sta_mhs` tinyint(4) DEFAULT NULL,
  `pass` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mhs_mahasiswa`
--

INSERT INTO `mhs_mahasiswa` (`nim`, `kd_prodi`, `id_ta`, `nama_mhs`, `tmp_lahir`, `tgl_lahir`, `alamat`, `jns_kel`, `agama`, `no_telp`, `nama_ayah`, `nama_ibu`, `pkj_ayah`, `pkj_ibu`, `peng_ayah`, `peng_ibu`, `sta_mhs`, `pass`) VALUES
('151530006', '153', 4, 'Gilang Ramadhani Susilo', 'Pekalongan', '2018-01-06', 'Kedungwuni', 'L', 'Islam', '085878183999', 'Susila', 'Wartun', 'PNS', 'PNS', 3000000, 2000000, 1, '5787be38ee03a9ae5360f54d9026465f'),
('151530028', '153', 4, 'Laelul Enjelita', 'Pekalongan', '1997-07-31', 'Tengeng Wetan', 'P', 'Islam', '085842111448', 'Sudi R', 'Wartumi', 'PNS', 'Ibu Rumah Tangga', 4000000, 1000000, 1, '5787be38ee03a9ae5360f54d9026465f'),
('161530004', '153', 3, 'Asifah Ulul Azmi', 'Pekalongan', '2018-01-12', 'Kajen', 'P', 'Islam', '085764567873', 'Maman', 'Sri', 'Karyawan', 'Ibu Rumah Tangga', 1000000, 1000000, 1, '5787be38ee03a9ae5360f54d9026465f'),
('161530011', '153', 3, 'Khaerul Umar', 'Pekalongan', '2018-01-05', 'Karangjati,Wiradesa', 'L', 'Islam', '085764567649', 'Surono', 'Maryam', 'Karyawan', 'Buruh', 1000000, 1000000, 1, '5787be38ee03a9ae5360f54d9026465f'),
('161530012', '153', 3, 'M. Saputra Adytama', 'Pekalongan', '2018-01-06', 'Kedungwuni', 'L', 'Islam', '089767875674', 'Ismail', 'Sakinah', 'Pedagang', 'Ibu Rumah Tangga', 1000000, 1000000, 1, '5787be38ee03a9ae5360f54d9026465f'),
('161530013', '153', 3, 'Mochammad Taufiq Hidayat', 'Pekalongan', '1998-12-12', 'Kedungwuni', 'L', 'Islam', '085727740114', 'Sujak', 'Munifah', 'Karyawan', 'Penjahit', 1000000, 1000000, 1, '5787be38ee03a9ae5360f54d9026465f'),
('171530027', '153', 4, 'Widya Pangestuti Adiningsih', 'Pekalongan', '2018-01-12', 'Ds.Kalijambe Rt/RW 1/11 Kec.Sragi Kab.Pekalongan', 'P', 'Islam', '082322703109', 'Nurhasan ', 'Titik Unarsih', 'Karyawan Swasta', 'Ibu Rumah Tangga', 1500000, 1000000, 1, '5787be38ee03a9ae5360f54d9026465f');

-- --------------------------------------------------------

--
-- Table structure for table `mk_jadwalmk`
--

CREATE TABLE `mk_jadwalmk` (
  `id_tk` int(11) NOT NULL,
  `semester` int(2) NOT NULL,
  `kd_prodi` char(3) NOT NULL,
  `id_kelas` tinyint(4) NOT NULL,
  `kat_kelas` varchar(10) NOT NULL,
  `hari` varchar(10) NOT NULL,
  `id_sj` int(11) NOT NULL,
  `kd_mk` char(8) NOT NULL,
  `kd_dosen` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mk_jadwalmk`
--

INSERT INTO `mk_jadwalmk` (`id_tk`, `semester`, `kd_prodi`, `id_kelas`, `kat_kelas`, `hari`, `id_sj`, `kd_mk`, `kd_dosen`) VALUES
(1234567891, 2, '153', 111, 'a', 'senin', 1111111111, 'KDMK1111', '150602'),
(1234567892, 2, '153', 111, 'a', 'senin', 222222222, 'KDMK2222', '160602'),
(1234567893, 3, '153', 111, 'a', 'senin', 333333333, 'KDMK3333', '160601');

-- --------------------------------------------------------

--
-- Table structure for table `mk_matakuliah`
--

CREATE TABLE `mk_matakuliah` (
  `kd_mk` char(8) NOT NULL,
  `kd_kmk` char(4) NOT NULL,
  `tahun_kur` int(4) NOT NULL,
  `kd_prodi` char(3) NOT NULL,
  `nama_mk` varchar(50) NOT NULL,
  `kategori_mk` varchar(15) NOT NULL,
  `sks_t` int(1) NOT NULL,
  `sks_p` int(1) NOT NULL,
  `jam_t` int(3) NOT NULL,
  `jam_p` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mk_matakuliah`
--

INSERT INTO `mk_matakuliah` (`kd_mk`, `kd_kmk`, `tahun_kur`, `kd_prodi`, `nama_mk`, `kategori_mk`, `sks_t`, `sks_p`, `jam_t`, `jam_p`) VALUES
('KDMK1111', 'MBB', 3, '153', 'Pemrograman 2', 'aaaaa', 2, 2, 11, 21),
('KDMK2222', 'MBB', 3, '153', 'Rekayasa Perangkat Lunak 1', 'b', 2, 2, 10, 20),
('KDMK3333', 'MBB', 3, '153', 'Proyek 3', 'aaaaa', 1, 1, 10, 30);

-- --------------------------------------------------------

--
-- Table structure for table `mk_setjam`
--

CREATE TABLE `mk_setjam` (
  `id_sj` int(11) NOT NULL,
  `jam_ke` tinyint(1) NOT NULL,
  `jns_kelas` varchar(10) NOT NULL,
  `jam_mulai` time NOT NULL,
  `jam_selesai` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mk_setjam`
--

INSERT INTO `mk_setjam` (`id_sj`, `jam_ke`, `jns_kelas`, `jam_mulai`, `jam_selesai`) VALUES
(222222222, 2, 'vip', '07:07:08', '08:06:02'),
(333333333, 3, 'vip', '10:33:39', '11:25:24'),
(1111111111, 1, 'vip', '04:12:18', '05:01:06');

-- --------------------------------------------------------

--
-- Table structure for table `pg_dosen`
--

CREATE TABLE `pg_dosen` (
  `nik` char(9) NOT NULL,
  `kd_dosen` char(6) NOT NULL,
  `nip` char(9) NOT NULL,
  `nama_pegawai` varchar(45) NOT NULL,
  `jk` enum('L','P','','') NOT NULL,
  `tmp_lahir` varchar(25) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `agama` varchar(15) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `no_telepon1` varchar(12) NOT NULL,
  `no_telepon2` varchar(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `tmt` date NOT NULL,
  `nama_ibu` varchar(45) NOT NULL,
  `sta_menikah` enum('Belum Menikah','Menikah','Pernah Menikah','') NOT NULL,
  `jml_tanggungan` tinyint(2) NOT NULL,
  `sta_pegawai` enum('PNS','Kontrak','','') NOT NULL,
  `sta_aktif` enum('Aktif','Cuti','MD','Pensiun','Meninggal') NOT NULL,
  `pass` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pg_dosen`
--

INSERT INTO `pg_dosen` (`nik`, `kd_dosen`, `nip`, `nama_pegawai`, `jk`, `tmp_lahir`, `tgl_lahir`, `agama`, `alamat`, `no_telepon1`, `no_telepon2`, `email`, `tmt`, `nama_ibu`, `sta_menikah`, `jml_tanggungan`, `sta_pegawai`, `sta_aktif`, `pass`) VALUES
('150000000', '150602', '201506002', 'Anom Sejogati', 'L', 'Pekalongan', '2018-01-12', 'Islam', 'Sapugarut, Buaran', '08976727171', '085767656784', 'anomogt@gmail.com', '2018-01-12', 'Sumar', 'Menikah', 1, 'PNS', 'Aktif', '21232f297a57a5a743894a0e4a801fc3'),
('156734893', '160601', '201606001', 'Imam Prayogo Pujiono', 'L', 'Pekalongan', '2018-01-11', 'Islam', 'Bojong', '08576537879', '08576456786', 'imamprayogo@gmail.com', '2018-01-11', 'Manah', 'Belum Menikah', 1, 'Kontrak', 'Aktif', '21232f297a57a5a743894a0e4a801fc3'),
('167867897', '160602', '201606002', 'Tri Astuti', 'P', 'Banjarnegara', '1990-09-05', 'Islam', 'Banjarnegara', '08587656789', '08576567652', 'triastuti@gmail.com', '2016-06-02', 'Sumarlinah', 'Menikah', 1, 'Kontrak', 'Aktif', '21232f297a57a5a743894a0e4a801fc3');

-- --------------------------------------------------------

--
-- Table structure for table `pg_kategorikriterianilai`
--

CREATE TABLE `pg_kategorikriterianilai` (
  `kd_katn` char(8) NOT NULL,
  `id_th` int(4) NOT NULL,
  `kd_prodi` char(3) NOT NULL,
  `kategori_penilaian` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pg_kategorikriterianilai`
--

INSERT INTO `pg_kategorikriterianilai` (`kd_katn`, `id_th`, `kd_prodi`, `kategori_penilaian`) VALUES
('17115301', 7, '153', 'Kesiapan Mengajar (KM)'),
('17115302', 7, '153', 'Materi Pengajaran (MP)'),
('17115303', 7, '153', 'Disiplin Mengajar (DM)'),
('17115304', 7, '153', 'Evaluasi Mengajar (EM)'),
('17115305', 7, '153', 'Kepribadian Dosen (KD)');

-- --------------------------------------------------------

--
-- Table structure for table `pg_kriterianilaidosen`
--

CREATE TABLE `pg_kriterianilaidosen` (
  `kd_knd` char(10) NOT NULL,
  `kd_katn` char(8) NOT NULL,
  `kriteria_penilaian` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pg_kriterianilaidosen`
--

INSERT INTO `pg_kriterianilaidosen` (`kd_knd`, `kd_katn`, `kriteria_penilaian`) VALUES
('1711530101', '17115301', 'Dosen menyediakan silabus mata kuliah'),
('1711530102', '17115301', 'Dosen mendiskusikan silabus dengan mahasiswa'),
('1711530103', '17115301', 'Dosen menyediakan bahan bacaan yang sesuai dengan materi silabus'),
('1711530104', '17115301', 'Dosen memperlihatkan penguasaan materi matakuliah'),
('1711530105', '17115301', 'Dosen mengajarkan materi dengan metode yang efektif'),
('1711530106', '17115301', 'Dosen selalu memberi contoh konkrit setiap menjelaskan suatu hal'),
('1711530107', '17115301', 'Dosen sangat komunikatif'),
('1711530108', '17115301', 'Dosen menciptakan suasana kelas yang kondusif/membuat mahasiswa termotivasi'),
('1711530109', '17115301', 'Dosen mengajarkan tidak terlalu cepat/lambat, sehingga mudah dimengerti mahasiswa'),
('1711530110', '17115301', 'Dosen selalu memberi kesempatan mahasiswa untuk bertanya'),
('1711530201', '17115302', 'Dosen menyelesaikan seluruh materi sesuai isi silabus mata kuliah'),
('1711530202', '17115302', 'Dosen tidak banyak bercerita tentang hal di luar materi matakuliah yang bersangkutan'),
('1711530203', '17115302', 'Buku teks untuk matakuliah tersebut mudah didapat'),
('1711530204', '17115302', 'Materi matakuliah selalu diperbaharui dengan contoh atau perkembangan karir'),
('1711530205', '17115302', 'isi buku teks/bahan kuliah mudah dipahami'),
('1711530301', '17115303', 'Dosen selalu hadir memberi kuliah setiap pertemuan'),
('1711530302', '17115303', 'Dosen hadir di kelas tepat waktu'),
('1711530303', '17115303', 'Dosen tidak pernah meniadakan kuliah tanpa alasan'),
('1711530304', '17115303', 'Dosen meninggalkan kelas tepat waktu'),
('1711530401', '17115304', 'Dosen memberi penilaian yang obyektif'),
('1711530402', '17115304', 'Dosen selalu memberi penjelasan tentang cara menilai'),
('1711530403', '17115304', 'Dosen selalu memberikan evaluasi atas tugas/tes yang diberikan'),
('1711530404', '17115304', 'Materi tugas, tes, dan ujian sesuai dengan materi matakuliah dan selaras dengan isi silabus'),
('1711530501', '17115305', 'Dosen mudah ditemui di luar kelas'),
('1711530502', '17115305', 'Dosen berwibawa di mata mahasiswa'),
('1711530503', '17115305', 'Dosen memberi pendidikan tentang nilai (values), moral, etika selain tentang materi kuliah');

-- --------------------------------------------------------

--
-- Table structure for table `pg_masukandosen`
--

CREATE TABLE `pg_masukandosen` (
  `kd_nilai` char(11) NOT NULL,
  `masukan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pg_nilaidosen`
--

CREATE TABLE `pg_nilaidosen` (
  `kd_nilai` char(11) NOT NULL,
  `kd_knd` char(10) NOT NULL,
  `kd_dosen` char(6) NOT NULL,
  `nilai` int(1) NOT NULL,
  `nim` char(8) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pg_staff`
--

CREATE TABLE `pg_staff` (
  `nip` char(17) NOT NULL,
  `nama_staff` varchar(45) NOT NULL,
  `jk` enum('L','P','','') NOT NULL,
  `tmp_lahir` varchar(25) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `no_telp` int(12) NOT NULL,
  `pass` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbmstkelompokmk`
--

CREATE TABLE `tbmstkelompokmk` (
  `kd_kmk` char(4) NOT NULL,
  `kelompok_mk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmstkelompokmk`
--

INSERT INTO `tbmstkelompokmk` (`kd_kmk`, `kelompok_mk`) VALUES
('MBB', 'MATAKULIAH BERKEHIDUPAN BERMASYARAKAT (MBB)'),
('MKB', 'MATAKULIAH KEAHLIAN BERKARYA (MKB)'),
('MKK', 'MATAKULIAH KEILMUAN DAN KETRAMPILAN (MKK)'),
('MPB', 'MATAKULIAH SIKAP PERILAKU BERKARYA (MPB)'),
('MPK', 'MATAKULIAH PENGEMBANGAN KEPRIBADIAN (MPK)');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akn_gedung`
--
ALTER TABLE `akn_gedung`
  ADD PRIMARY KEY (`kd_gedung`);

--
-- Indexes for table `akn_jurusan`
--
ALTER TABLE `akn_jurusan`
  ADD PRIMARY KEY (`kd_jur`);

--
-- Indexes for table `akn_kelas`
--
ALTER TABLE `akn_kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `akn_prodi`
--
ALTER TABLE `akn_prodi`
  ADD PRIMARY KEY (`kd_prodi`),
  ADD KEY `kd_jur` (`kd_jur`);

--
-- Indexes for table `akn_ruang`
--
ALTER TABLE `akn_ruang`
  ADD PRIMARY KEY (`kd_ruang`,`kd_gedung`),
  ADD KEY `kd_gedung` (`kd_gedung`);

--
-- Indexes for table `akn_thajaran`
--
ALTER TABLE `akn_thajaran`
  ADD PRIMARY KEY (`id_th`);

--
-- Indexes for table `akn_thangkatan`
--
ALTER TABLE `akn_thangkatan`
  ADD PRIMARY KEY (`id_ta`);

--
-- Indexes for table `akn_user`
--
ALTER TABLE `akn_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `mhs_mahasiswa`
--
ALTER TABLE `mhs_mahasiswa`
  ADD PRIMARY KEY (`nim`),
  ADD KEY `kd_prodi` (`kd_prodi`),
  ADD KEY `id_ta` (`id_ta`);

--
-- Indexes for table `mk_jadwalmk`
--
ALTER TABLE `mk_jadwalmk`
  ADD PRIMARY KEY (`id_tk`,`kd_prodi`,`kd_mk`,`id_sj`,`id_kelas`),
  ADD KEY `kd_prodi` (`kd_prodi`),
  ADD KEY `id_kelas` (`id_kelas`),
  ADD KEY `id_sj` (`id_sj`),
  ADD KEY `kd_mk` (`kd_mk`);

--
-- Indexes for table `mk_matakuliah`
--
ALTER TABLE `mk_matakuliah`
  ADD PRIMARY KEY (`kd_mk`,`kd_kmk`,`kd_prodi`),
  ADD KEY `kd_prodi` (`kd_prodi`),
  ADD KEY `kd_kmk` (`kd_kmk`);

--
-- Indexes for table `mk_setjam`
--
ALTER TABLE `mk_setjam`
  ADD PRIMARY KEY (`id_sj`);

--
-- Indexes for table `pg_dosen`
--
ALTER TABLE `pg_dosen`
  ADD PRIMARY KEY (`nik`,`kd_dosen`,`nip`),
  ADD UNIQUE KEY `kd_dosen` (`kd_dosen`),
  ADD UNIQUE KEY `nip` (`nip`);

--
-- Indexes for table `pg_kategorikriterianilai`
--
ALTER TABLE `pg_kategorikriterianilai`
  ADD PRIMARY KEY (`kd_katn`,`id_th`,`kd_prodi`),
  ADD KEY `kd_prodi` (`kd_prodi`),
  ADD KEY `id_th` (`id_th`);

--
-- Indexes for table `pg_kriterianilaidosen`
--
ALTER TABLE `pg_kriterianilaidosen`
  ADD PRIMARY KEY (`kd_knd`,`kd_katn`),
  ADD KEY `kd_katn` (`kd_katn`);

--
-- Indexes for table `pg_masukandosen`
--
ALTER TABLE `pg_masukandosen`
  ADD PRIMARY KEY (`kd_nilai`);

--
-- Indexes for table `pg_nilaidosen`
--
ALTER TABLE `pg_nilaidosen`
  ADD PRIMARY KEY (`kd_nilai`,`kd_knd`,`kd_dosen`,`nim`),
  ADD KEY `kd_knd` (`kd_knd`),
  ADD KEY `kd_dosen` (`kd_dosen`),
  ADD KEY `nim` (`nim`);

--
-- Indexes for table `pg_staff`
--
ALTER TABLE `pg_staff`
  ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `tbmstkelompokmk`
--
ALTER TABLE `tbmstkelompokmk`
  ADD PRIMARY KEY (`kd_kmk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akn_kelas`
--
ALTER TABLE `akn_kelas`
  MODIFY `id_kelas` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;
--
-- AUTO_INCREMENT for table `mk_setjam`
--
ALTER TABLE `mk_setjam`
  MODIFY `id_sj` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1111111112;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `akn_prodi`
--
ALTER TABLE `akn_prodi`
  ADD CONSTRAINT `akn_prodi_ibfk_1` FOREIGN KEY (`kd_jur`) REFERENCES `akn_jurusan` (`kd_jur`);

--
-- Constraints for table `akn_ruang`
--
ALTER TABLE `akn_ruang`
  ADD CONSTRAINT `akn_ruang_ibfk_1` FOREIGN KEY (`kd_gedung`) REFERENCES `akn_gedung` (`kd_gedung`);

--
-- Constraints for table `mhs_mahasiswa`
--
ALTER TABLE `mhs_mahasiswa`
  ADD CONSTRAINT `mhs_mahasiswa_ibfk_1` FOREIGN KEY (`kd_prodi`) REFERENCES `akn_prodi` (`kd_prodi`),
  ADD CONSTRAINT `mhs_mahasiswa_ibfk_2` FOREIGN KEY (`id_ta`) REFERENCES `akn_thangkatan` (`id_ta`);

--
-- Constraints for table `mk_jadwalmk`
--
ALTER TABLE `mk_jadwalmk`
  ADD CONSTRAINT `mk_jadwalmk_ibfk_1` FOREIGN KEY (`kd_prodi`) REFERENCES `akn_prodi` (`kd_prodi`),
  ADD CONSTRAINT `mk_jadwalmk_ibfk_2` FOREIGN KEY (`id_kelas`) REFERENCES `akn_kelas` (`id_kelas`),
  ADD CONSTRAINT `mk_jadwalmk_ibfk_3` FOREIGN KEY (`id_sj`) REFERENCES `mk_setjam` (`id_sj`),
  ADD CONSTRAINT `mk_jadwalmk_ibfk_4` FOREIGN KEY (`kd_mk`) REFERENCES `mk_matakuliah` (`kd_mk`);

--
-- Constraints for table `mk_matakuliah`
--
ALTER TABLE `mk_matakuliah`
  ADD CONSTRAINT `mk_matakuliah_ibfk_1` FOREIGN KEY (`kd_prodi`) REFERENCES `akn_prodi` (`kd_prodi`),
  ADD CONSTRAINT `mk_matakuliah_ibfk_2` FOREIGN KEY (`kd_kmk`) REFERENCES `tbmstkelompokmk` (`kd_kmk`);

--
-- Constraints for table `pg_kategorikriterianilai`
--
ALTER TABLE `pg_kategorikriterianilai`
  ADD CONSTRAINT `pg_kategorikriterianilai_ibfk_1` FOREIGN KEY (`kd_prodi`) REFERENCES `akn_prodi` (`kd_prodi`),
  ADD CONSTRAINT `pg_kategorikriterianilai_ibfk_2` FOREIGN KEY (`id_th`) REFERENCES `akn_thajaran` (`id_th`);

--
-- Constraints for table `pg_masukandosen`
--
ALTER TABLE `pg_masukandosen`
  ADD CONSTRAINT `pg_masukandosen_ibfk_1` FOREIGN KEY (`kd_nilai`) REFERENCES `pg_nilaidosen` (`kd_nilai`);

--
-- Constraints for table `pg_nilaidosen`
--
ALTER TABLE `pg_nilaidosen`
  ADD CONSTRAINT `pg_nilaidosen_ibfk_1` FOREIGN KEY (`kd_knd`) REFERENCES `pg_kriterianilaidosen` (`kd_knd`),
  ADD CONSTRAINT `pg_nilaidosen_ibfk_2` FOREIGN KEY (`kd_dosen`) REFERENCES `pg_dosen` (`kd_dosen`),
  ADD CONSTRAINT `pg_nilaidosen_ibfk_3` FOREIGN KEY (`nim`) REFERENCES `mhs_mahasiswa` (`nim`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

DROP SCHEMA `gardenia`;
CREATE SCHEMA `gardenia`;
USE `gardenia`;

CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE Suppliers (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    name_supplier VARCHAR(255) NOT NULL,
    supplier_phone VARCHAR(15)
);


CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    category_id INT,
    supplier_id INT,
    product_name VARCHAR(255) NOT NULL,
    product_stock VARCHAR(255) NOT NULL,
    product_last_update VARCHAR(255),
    product_price VARCHAR(255) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id),
    FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id)
);


CREATE TABLE Members (
    member_id INT PRIMARY KEY,
    member_name VARCHAR(255) NOT NULL,
    member_gender VARCHAR(255) NOT NULL,
    member_registration_date VARCHAR(255),
    member_phone_number VARCHAR(255)
);


CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY,
    member_id INT,
    transaction_total VARCHAR(255) NOT NULL,
    date_transaction VARCHAR(255)
);


CREATE TABLE DetailTransactions (
    transaction_id INT,
    product_id INT,
    quantity VARCHAR(255) NOT NULL,
    total_detail VARCHAR(255) NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES Transactions(transaction_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);



CREATE TABLE administrators (
    username VARCHAR(50),
    password VARCHAR(50),
    role VARCHAR(50)
);

INSERT INTO administrators (username, password, role) 
VALUES ('Ricky', 'no', 'admin');

INSERT INTO administrators (username, password, role) 
VALUES ('Rafly', 'bakso123','admin');

INSERT INTO administrators (username, password, role) 
VALUES ('Christian', '4321','staff');

INSERT INTO administrators (username, password, role) 
VALUES ('Grace', '1234','admin');

INSERT INTO administrators (username, password, role) 
VALUES (' username', ' password', 'admin');

INSERT INTO members (member_id, member_name, member_gender, member_registration_date, member_phone_number) VALUES
(0, 'Guest', 'None', '0000-00-00', '000000000'),
(1, 'Marcus Budiawan', 'M', '2019-12-01', '843678912'),
(2, 'Xavrus', 'M', '2021-111-30', '8567891323'),
(3, 'Yuli Himawan', 'F', '2023-12-23', '83634374404'),
(4, 'Alexander Budiawan', 'M', '2019-11-01', '845678912'),
(5, 'Grace Birgitta', 'F', '2021-12-10', '856789123'),
(6, 'Yani Haryanti', 'F', '2023-12-17', '83644374404'),
(7, 'Prasetyo Hasanah', 'M', '2021-12-06', '88247116512'),
(8, 'Gada Aryani', 'F', '2021-11-27', '82405039944'),
(9, 'Novi Uwais', 'M', '2022-08-26', '88822215722'),
(10, 'Novi Handayani', 'F', '2023-03-14', '84688209910'),
(11, 'Zulaikha Dongoran', 'M', '2021-05-27', '82412929901'),
(12, 'Bahuwirya Sitompul', 'M', '2022-03-15', '87758415621'),
(13, 'Yunita Manullang', 'M', '2022-09-03', '87797501738'),
(14, 'T. Karman Winarno', 'F', '2022-11-27', '82300638019'),
(15, 'Atma Winarsih', 'F', '2021-03-24', '85766666890'),
(16, 'Harja Anggraini', 'F', '2023-08-07', '84382210777'),
(17, 'Cut Putri Sihombing', 'F', '2021-11-12', '81314061835'),
(18, 'Sakura Setiawan', 'M', '2023-07-16', '86495828374'),
(19, 'Saadat Pranowo', 'M', '2021-01-08', '89288097991'),
(20, 'Samiah Lestari', 'F', '2021-05-08', '85508781890'),
(21, 'Prayitna Mandala', 'F', '2022-09-06', '86641957644'),
(22, 'Hartaka Januar', 'M', '2023-09-25', '83663472232'),
(23, 'Dian Adriansyah', 'F', '2021-09-25', '82572012119'),
(24, 'Fathonah Usada', 'M', '2022-01-13', '86873062923'),
(25, 'Ajiono Usada', 'M', '2023-11-16', '85372915940'),
(26, 'Umi Hardiansyah', 'F', '2022-11-12', '81633902492'),
(27, 'Wulan Wibisono', 'M', '2021-09-03', '81175900180'),
(28, 'Tgk. Reza Nugroho', 'M', '2023-11-19', '85761001232'),
(29, 'Sakti Wulandari', 'M', '2023-01-12', '83966812168'),
(30, 'Darijan Lestari', 'F', '2022-01-23', '88596979242'),
(31, 'Titi Prastuti', 'F', '2022-10-08', '83243539557'),
(32, 'Endah Prabowo', 'F', '2023-01-31', '84908889584'),
(33, 'Hilda Wulandari', 'F', '2022-01-24', '83451756982'),
(34, 'Humaira Uyainah', 'F', '2022-05-04', '88817375368'),
(35, 'Vanesa Zulkarnain', 'F', '2022-06-20', '84379130291'),
(36, 'Genta Tampubolon', 'M', '2021-11-29', '83324960229'),
(37, 'Estiono Zulkarnain', 'M', '2023-05-05', '85489059179'),
(38, 'Tgk. Yono Hutagalung', 'F', '2023-08-11', '81637032431'),
(39, 'Edward Kusmawati', 'F', '2023-12-05', '83212737153'),
(40, 'Dewi Saputra', 'M', '2023-07-20', '89283282955'),
(41, 'Olivia Farida', 'F', '2023-01-31', '83949401699'),
(42, 'Rahmi Kusumo', 'F', '2023-04-28', '86269142682'),
(43, 'Diah Mandasari', 'F', '2021-02-06', '81506904786'),
(44, 'Rika Ramadan', 'F', '2022-07-11', '81501045200'),
(45, 'Legawa Hassanah', 'M', '2023-11-25', '87182843749'),
(46, 'Keisha Purnawati', 'F', '2023-03-09', '82983052691'),
(47, 'Nyoman Manullang', 'F', '2022-10-25', '83992130620'),
(48, 'Naradi Nashiruddin', 'M', '2021-11-29', '81355875170'),
(49, 'Ghani Wibowo', 'M', '2023-08-17', '89792032689'),
(50, 'Ami Padmasari', 'F', '2022-07-10', '88733318307'),
(51, 'Cengkal Irawan', 'M', '2022-01-02', '82258186880'),
(52, 'Dinda Situmorang', 'F', '2022-01-07', '81555213046'),
(53, 'Titin Wijaya', 'M', '2021-08-19', '88733000583'),
(54, 'Wasis Nuraini', 'F', '2021-01-11', '84436913646'),
(55, 'Sutan Yahya', 'M', '2022-01-08', '84960937658'),
(56, 'Tgk. Rahayu Pudjiastuti', 'F', '2021-09-25', '87771215646'),
(57, 'Yuliana Mahendra', 'F', '2022-02-19', '82361479257'),
(58, 'Irnanto Nasyidah', 'F', '2022-04-06', '86494455312'),
(59, 'Rahmat Widodo', 'F', '2021-05-12', '88245175687'),
(60, 'Salsabila Saefullah', 'M', '2023-12-14', '82168598007'),
(61, 'Rudi Mansur', 'F', '2022-07-30', '89797405335'),
(62, 'KH. Raihan Riyanti', 'M', '2022-10-27', '84932437950'),
(63, 'Endah Habibi', 'M', '2022-03-26', '83457301628'),
(64, 'Genta Wastuti', 'F', '2023-08-25', '86407849115'),
(65, 'Vivi Saputra', 'F', '2023-07-06', '86531197875'),
(66, 'Suci Yolanda', 'F', '2023-06-12', '84496242746'),
(67, 'Keisha Mansur', 'F', '2022-03-28', '81980384582'),
(68, 'Puti Tami Kusmawati', 'M', '2022-12-24', '86801601223'),
(69, 'Jati Padmasari', 'F', '2021-10-21', '88673761943'),
(70, 'Kamaria Wastuti', 'M', '2021-10-23', '88110075015'),
(71, 'Indra Wijayanti', 'F', '2022-04-17', '86509364014'),
(72, 'Wakiman Tampubolon', 'M', '2023-01-01', '89196914760'),
(73, 'Mursinin Wacana', 'M', '2023-08-30', '83143391724'),
(74, 'Murti Natsir', 'F', '2022-06-05', '87948822643'),
(75, 'Cut Bella Waluyo', 'M', '2023-03-14', '85394032675'),
(76, 'Tania Mangunsong', 'M', '2023-10-02', '89749456833'),
(77, 'Kani Rajata', 'F', '2021-10-01', '88429038712'),
(78, 'Elvina Uyainah', 'M', '2021-04-08', '84696385831'),
(79, 'Bala Rahayu', 'M', '2023-12-04', '89779205354'),
(80, 'Laras Lazuardi', 'F', '2023-02-07', '83714142529'),
(81, 'Kayla Nasyiah', 'M', '2022-10-28', '81708159342'),
(82, 'Jarwa Situmorang', 'M', '2021-08-12', '89786734706'),
(83, 'Vera Lailasari', 'M', '2021-06-16', '89751871727'),
(84, 'Kawaca Agustina', 'F', '2022-02-18', '81778105630'),
(85, 'Hari Gunarto', 'F', '2022-12-18', '85782776793'),
(86, 'Aurora Wijayanti', 'M', '2021-12-09', '89342809356'),
(87, 'Waluyo Sinaga', 'F', '2023-07-15', '82395959445'),
(88, 'Galuh Andriani', 'M', '2022-10-21', '84506135609'),
(89, 'Usman Habibi', 'F', '2021-01-10', '83856295182'),
(90, 'Elma Hardiansyah', 'F', '2022-06-11', '82275018304'),
(91, 'Hilda Pradana', 'M', '2021-06-22', '87876616320'),
(92, 'Samsul Prasetyo', 'M', '2023-04-27', '84893854706'),
(93, 'Chandra Wibisono', 'F', '2023-01-25', '86292576762'),
(94, 'Gamblang Sihombing', 'M', '2021-10-06', '82884861556'),
(95, 'Daniswara Nuraini', 'F', '2021-11-26', '88171637679'),
(96, 'Puti Kani Susanti', 'M', '2022-11-21', '83424159302'),
(97, 'Cici Simbolon', 'M', '2023-12-09', '87437412630'),
(98, 'Daliman Uyainah', 'M', '2022-05-04', '86298823511'),
(99, 'Rahman Haryanti', 'F', '2021-11-23', '85392677559'),
(100, 'Kala Sitompul', 'M', '2022-02-04', '87269575519');

INSERT INTO categories (category_id, category_name) VALUES
(1, 'bahan pokok'),
(2, 'minuman'),
(3, 'alat'),
(4, 'pewarna makanan'),
(5, 'kue'),
(6, 'kue kering'),
(7, 'dekorasi'),
(8, 'kemasan'),
(9, 'bahan tambahan'),
(10, 'kue basah'),
(11, 'Roti');

INSERT INTO suppliers (supplier_id, name_supplier, supplier_phone)
VALUES
(1, 'Alpha Supplies', '1234567890'),
(2, 'Beta Traders', '0987654321'),
(3, 'Gamma Distributors', '1122334455'),
(4, 'Delta Imports', '2233445566'),
(5, 'Epsilon Exports', '3344556677'),
(6, 'Zeta Logistics', '4455667788'),
(7, 'Eta Enterprises', '5566778899'),
(8, 'Theta Suppliers', '6677889900'),
(9, 'Iota Goods', '7788990011'),
(10, 'Kappa Wholesalers', '8899001122'),
(11, 'Lambda Products', '9900112233'),
(12, 'Mu Services', '0011223344'),
(13, 'Nu Materials', '1122334466'),
(14, 'Xi Components', '2233445577'),
(15, 'Omicron Essentials', '3344556688'),
(16, 'Pi Distributors', '4455667799'),
(17, 'Rho Partners', '5566778800'),
(18, 'Sigma Ventures', '6677889901'),
(19, 'Tau Industries', '7788990022'),
(20, 'Upsilon Supplies', '8899001133');




INSERT INTO Products (product_id, category_id, supplier_id, product_name, product_stock, product_last_update, product_price)
VALUES 
('1', '1', '1', 'Tepung Terigu Segitiga Biru 1kg', '749', '11-11-2024', '17000'),
('2', '1', '1', 'Tepung Terigu Kunci Biru 1kg', '372', '18-10-2024', '17000'),
('3', '1', '1', 'Tepung Terigu Cakra Kembar 1kg', '469', '04-12-2023', '15000'),
('4', '1', '1', 'Tepung Terigu Tulip 1kg', '102', '04-11-2024', '10000'),
('5', '1', '1', 'Tepung Terigu Lencana Merah 1kg', '295', '12-05-2024', '14000'),
('7', '1', '2', 'Margarin Blue Band 200gr', '578', '19-09-2024', '13000'),
('9', '1', '2', 'Margarin Palmia Serbaguna 1kg', '495', '20-09-2024', '23000'),
('10', '2', '3', 'Susu UHT Greenfield Coklat 1000 ml', '761', '24-07-2024', '26000'),
('11', '2', '3', 'Susu UHT Greenfield Full Cream 1000 ml', '950', '18-02-2024', '26000'),
('12', '2', '3', 'Susu UHT Greenfield Stroberi 1000 ml', '31', '07-03-2024', '26000'),
('13', '2', '3', 'Susu UHT Ultra Milk Coklat 1000 ml', '486', '21-05-2024', '26000'),
('14', '2', '3', 'Susu UHT Ultra Milk Full Cream 1000 ml', '787', '25-04-2024', '26000'),
('15', '2', '3', 'Susu UHT Ultra Milk Low Fat 1000 ml', '983', '17-03-2024', '26000'),
('16', '2', '3', 'Susu UHT Diamond Full Cream 1000 ml', '752', '01-01-2024', '23000'),
('17', '2', '4', 'Air Mineral AQUA 1500 ml', '419', '08-04-2024', '7000'),
('18', '2', '4', 'Air Mineral AQUA 750 ml', '569', '18-10-2024', '6000'),
('19', '3', '5', 'Rinnai Grand Series Oven Gas 20L', '572', '11-09-2024', '1600000'),
('20', '3', '6', 'Vicenza Spatula Profesional 1 pcs', '197', '27-04-2024', '25000'),
('21', '3', '7', 'Kirin Cetakan Cupcake Premium 6 pcs', '103', '03-09-2024', '70000'),
('22', '3', '8', 'Oxone Professional Pengocok Telur 1 pcs', '592', '25-04-2024', '15000'),
('24', '3', '9', 'Philips Mixer HR1159 Professional', '99', '19-04-2024', '800000'),
('25', '3', '9', 'Miyako Digital Timbangan Dapur 500g', '802', '23-01-2024', '75000'),
('26', '3', '9', 'Homemate Rolling Pin Kayu 1 pcs', '149', '20-06-2024', '45000'),
('27', '3', '9', 'Kenmaster Digital Timbangan 1kg', '103', '28-05-2024', '90000'),
('28', '3', '9', 'Modena Forza Series Oven Listrik 20L', '812', '25-01-2024', '1500000'),
('29', '4', '10', 'Koepoe-Koepoe Pewarna Coklat', '882', '03-12-2023', '6000'),
('30', '4', '10', 'Koepoe-Koepoe Pewarna Hijau', '645', '30-01-2024', '6000'),
('31', '4', '10', 'Koepoe-Koepoe Pewarna Biru', '440', '30-09-2024', '6000'),
('32', '4', '10', 'Koepoe-Koepoe Pewarna Merah', '983', '17-03-2024', '6000'),
('33', '4', '10', 'Koepoe-Koepoe Pewarna Kuning', '752', '01-01-2024', '6000'),
('34', '4', '10', 'Koepoe-Koepoe Pewarna Ungu', '961', '18-12-2023', '6000'),
('35', '4', '10', 'Koepoe-Koepoe Pewarna Pink', '149', '20-06-2024', '6000'),
('36', '4', '10', 'Koepoe-Koepoe Pewarna Hitam', '158', '30-11-2023', '6000'),
('37', '5', '11', 'Lapis Kukus Choco cookies', '500', '10-09-2024', '35000'),
('38', '5', '11', 'Lapis Kukus Red Velvet', '600', '12-12-2024', '35000'),
('39', '5', '11', 'Lapis Kukus Cheese Cake', '350', '14-06-2024', '35000'),
('40', '5', '11', 'Lapis Kukus Choco Pandan', '450', '15-07-2024', '35000'),
('41', '5', '11', 'Lapis Kukus Brownies', '300', '30-07-2024', '35000'),
('42', '5', '11', 'Lapis Kukus Original', '400', '01-08-2024', '35000'),
('43', '5', '11', 'Lapis Mini Original', '500', '04-06-2024', '20000'),
('44', '5', '11', 'Lapis Mini Red Velvet', '450', '10-08-2024', '20000'),
('45', '5', '12', 'Brownies Original', '600', '20-07-2024', '32000'),
('46', '5', '12', 'Bolu Kukus Original', '550', '05-09-2024', '3500'),
('47', '6', '13', 'Kue Bangkit Susu', '400', '15-07-2024', '40000'),
('48', '6', '13', 'Kue Biji Ketapang Gurih', '200', '25-09-2024', '30000'),
('49', '6', '13', 'Kue Kering Kacang Tanah Tradisional', '450', '28-06-2024', '35000'),
('50', '6', '13', 'Kue Kering Semprit Coklat', '600', '18-10-2024', '65000'),
('51', '6', '13', 'Kue Kering Wijen Hitam', '300', '10-10-2024', '40000'),
('52', '6', '13', 'Kue Sagu Keju Spesial', '500', '05-11-2024', '35000'),
('53', '6', '13', 'Lidah Kucing Renyah', '250', '01-08-2024', '35000'),
('54', '6', '13', 'Nastar Nanas Tradisional', '300', '11-12-2024', '45000'),
('55', '6', '13', 'Putri Salju Lembut', '200', '15-09-2024', '35000'),
('56', '6', '13', 'Kastengel Keju Premium', '450', '20-08-2024', '60000'),
('57', '7', '14', 'Meses Coklat Rainbow 250gr' , '100', '01-11-2024', '14000'),
('58', '7', '14', 'Meses Coklat Putih 250gr', '150', '15-12-2024', '14000'),
('59', '7', '14', 'Meses Coklat Hitam 250gr', '200', '05-10-2024', '14000'),
('60', '7', '14', 'Meses Coklat Classic 250gr', '250', '20-08-2024', '14000'),
('61', '7', '14', 'Meses Coklat Gold 250gr', '300', '01-06-2024', '14000'),
('62', '7', '14', 'Meses Coklat Classic Spesial 250gr', '350', '12-09-2024', '19000'),
('63', '7', '15', 'Sugar Pearl Putih', '100', '05-07-2024', '32000'),
('64', '7', '15', 'Sugar Pearl Pink', '200', '15-08-2024', '35000'),
('65', '7', '16', 'Sprinkles Bintang Emas', '150', '22-11-2024', '30000'),
('66', '7', '16', 'Sprinkles Hati Merah', '250', '20-07-2024', '30000'),
('67', '8', '16', 'Paper Box Kue Premium 30x30cm', '500', '10-06-2024', '25000'),
('68', '8', '16', 'Plastik Kemasan Kue Food Grade 500 pcs', '700', '28-07-2024', '15000'),
('69', '8', '16', 'Container Kue 5L', '300', '05-05-2024', '27000'),
('70', '8', '16', 'Kemasan Eco Friendly Premium 25 pcs', '400', '15-10-2024', '22000'),
('71', '8', '16', 'Paper Bag Kue Cantik 20 pcs', '600', '01-09-2024', '20000'),
('72', '8', '16', 'Plastik Mica Premium 500 pcs', '500', '01-08-2024', '32000'),
('73', '8', '16', 'Food Grade Packaging Pro 100 pcs', '700', '20-06-2024', '45000'),
('74', '8', '17', 'Aluminum Foil Kemasan Kue 50 pcs', '300', '12-07-2024', '25000'),
('75', '8', '17', 'Tray Kue Multifungsi 50 pcs', '250', '25-10-2024', '23000'),
('76', '8', '17', 'Paper Cup Kue Premium 100 pcs', '400', '28-08-2024', '27000'),
('77', '9', '17', 'Keju Anchor Cheddar 150g', '645', '30-01-2024', '25000'),
('78', '9', '17', 'Keju Kraft Cheddar 150g', '983', '17-03-2024', '25000'),
('79', '9', '17', 'Keju Prochiz Mozarella 160g', '440', '30-09-2024', '24000'),
('80', '9', '17', 'Keju Prochiz Gold Cheddar 170g', '752', '01-01-2024', '15000'),
('81', '9', '17', 'Susu Kental Manis Indomilk 370g', '882', '03-12-2023', '12000'),
('86', '9', '17', 'Susu Kental Manis Indomilk Coklat 370g', '200', '09-07-2024', '12000'),
('87', '10', '18', 'Klepon Gula Merah', '500', '10-09-2024', '15000'),
('88', '10', '18', 'Onde-Onde Wijen', '600', '12-12-2024', '15000'),
('89', '10', '18', 'Lapis Legit Tradisional', '350', '14-06-2024', '45000'),
('90', '10', '18', 'Bolu Kukus Mekar', '450', '15-07-2024', '6000'),
('91', '10', '18', 'Kue Lumpur Kentang', '300', '30-07-2024', '17000'),
('92', '10', '18', 'Dadar Gulung Isi Kelapa', '400', '01-08-2024', '17000'),
('93', '10', '18', 'Getuk Lindri', '500', '04-06-2024', '22000'),
('94', '10', '18', 'Nagasari Pisang', '450', '10-08-2024', '12000'),
('95', '10', '18', 'Putu Ayu Pandan', '600', '20-07-2024', '10000'),
('96', '10', '18', 'Wajik Ketan Gula Jawa', '550', '05-09-2024', '20000'),
('97', '11', '19', 'Sari Roti Tawar Kupas', '300', '10-11-2024', '18000'),
('98', '11', '19', 'Sari Roti Tawar Kupas Jumbo', '500', '12-12-2024', '20000'),
('99', '11', '19', 'Sari Roti Tawar Spesial', '450', '15-10-2024', '15000'),
('100', '11', '19', 'Sari Roti Tawar Spesial Jumbo', '200', '20-09-2024', '18000'),
('105', '11', '19', 'Sari Roti Tawar Double Soft Milky', '350', '25-08-2024', '20000'),
('106', '11', '19', 'Sari Roti Tawar Double Soft Premium', '400', '17-10-2024', '24000'),
('107', '11', '19', 'Sari Roti Milky Soft', '250', '01-09-2024', '13000'),
('108', '11', '19', 'Sari Roti Milky Soft Jumbo', '100', '03-11-2024', '21000'),
('109', '11', '19', 'Sari Roti Gandum', '300', '10-08-2024', '23000'),
('110', '11', '19', 'Sari Roti Choco Chips', '450', '12-07-2024', '19000');

INSERT INTO transactions (transaction_id, member_id, transaction_total, date_transaction) VALUES
(1, 1, 319000, '2024-12-20'),
(2, 2, 635000, '2024-12-20'),
(3, 3, 816000, '2024-12-20'),
(4, 4, 1004000, '2024-12-20'),
(5, 5, 11922000, '2024-12-20'),
(6, 95, 180000, '2024-12-21'),
(9, 82, 336000, '2024-12-21'),
(10, 15, 463500, '2024-12-21'),
(12, 63, 120000, '2024-12-21'),
(13, 85, 227000, '2024-12-21'),
(16, 76, 36000, '2024-12-21'),
(17, 1, 156000, '2024-12-22'),
(18, 33, 192000, '2024-12-22'),
(19, 26, 407000, '2024-12-22'),
(20, 96, 302000, '2024-12-22'),
(22, 73, 280000, '2024-12-22'),
(23, 74, 376000, '2024-12-22'),
(26, 10, 164000, '2024-12-23'),
(27, 72, 9000000, '2024-12-23'),
(29, 10, 540000, '2024-12-23'),
(32, 94, 60000, '2024-12-24'),
(33, 58, 200000, '2024-12-24'),
(35, 85, 457000, '2024-12-24'),
(36, 24, 89000, '2024-12-24'),
(41, 11, 52000, '2024-12-25'),
(43, 74, 42000, '2024-12-25'),
(46, 3, 123000, '2024-12-25'),
(49, 31, 369000, '2024-12-25'),
(50, 48, 220000, '2024-12-25'),
(51, 87, 115000, '2024-12-25'),
(52, 79, 4907000, '2024-12-25'),
(56, 7, 450000, '2024-12-25'),
(60, 12, 405000, '2024-12-25'),
(62, 80, 330000, '2024-12-25'),
(65, 40, 18000, '2024-12-26'),
(66, 28, 128000, '2024-12-26'),
(68, 46, 115000, '2024-12-27'),
(69, 77, 814000, '2024-12-27'),
(76, 55, 154000, '2024-12-28'),
(79, 80, 574000, '2024-12-28'),
(80, 97, 70000, '2024-12-28'),
(84, 37, 450000, '2024-12-28'),
(86, 13, 265000, '2024-12-29'),
(88, 68, 34000, '2024-12-29'),
(96, 38, 136000, '2024-12-29'),
(97, 7, 68000, '2024-12-29'),
(98, 68, 34000, '2024-11-20'),
(99, 38, 136000, '2024-11-21'),
(100, 7, 68000, '2024-11-18');


INSERT INTO detailtransactions (transaction_id, product_id, quantity, total_detail) VALUES
(1, 1, 3, 51000),
(1, 2, 7, 119000),
(1, 3, 1, 15000),
(1, 5, 3, 42000),
(1, 9, 4, 92000),
(2, 2, 7, 119000),
(2, 7, 5, 65000),
(2, 30, 2, 12000),
(2, 10, 6, 156000),
(2, 1, 3, 51000),
(2, 2, 3, 51000),
(2, 15, 4, 104000),
(2, 1, 3, 51000),
(2, 10, 1, 26000),
(3, 9, 3, 69000),
(3, 10, 3, 78000),
(3, 74, 2, 50000),
(3, 11, 9, 234000),
(3, 110, 7, 133000),
(3, 5, 5, 70000),
(3, 11, 7, 182000),
(4, 12, 2, 52000),
(4, 16, 9, 207000),
(4, 78, 10, 250000),
(4, 14, 10, 260000),
(4, 20, 3, 75000),
(4, 51, 4, 160000),
(5, 17, 11, 77000),
(5, 19, 7, 11200000),
(5, 57, 3, 42000),
(5, 45, 9, 288000),
(5, 89, 7, 315000),
(6, 54, 2, 90000),
(6, 36, 8, 48000),
(6, 90, 7, 42000),
(9, 97, 2, 36000),
(9, 105, 3, 60000),
(9, 106, 10, 240000),
(10, 26, 7, 315000),
(10, 107, 9, 117000),
(10, 46, 5, 17500),
(10, 46, 4, 14000),
(12, 96, 6, 120000),
(13, 78, 7, 175000),
(13, 13, 2, 52000),
(16, 90, 6, 36000),
(17, 11, 6, 156000),
(18, 79, 8, 192000),
(19, 13, 7, 182000),
(19, 67, 9, 225000),
(20, 62, 5, 95000),
(20, 75, 9, 207000),
(22, 53, 8, 280000),
(23, 45, 11, 352000),
(23, 86, 2, 24000),
(26, 86, 5, 60000),
(26, 13, 4, 104000),
(27, 28, 6, 9000000),
(29, 56, 9, 540000),
(32, 105, 3, 60000),
(33, 20, 8, 200000),
(35, 89, 9, 405000),
(35, 7, 4, 52000),
(36, 90, 9, 54000),
(36, 52, 1, 35000),
(41, 15, 2, 52000),
(43, 18, 7, 42000),
(46, 35, 3, 18000),
(46, 36, 8, 48000),
(46, 62, 3, 57000),
(49, 78, 9, 225000),
(49, 79, 6, 144000),
(50, 89, 2, 90000),
(50, 7, 10, 130000),
(51, 9, 5, 115000),
(52, 16, 1, 23000),
(52, 58, 6, 84000),
(52, 24, 6, 4800000),
(56, 89, 10, 450000),
(60, 89, 9, 405000),
(62, 66, 11, 330000),
(65, 90, 3, 18000),
(66, 45, 4, 128000),
(68, 16, 5, 115000),
(69, 17, 7, 49000),
(69, 47, 6, 240000),
(69, 89, 9, 405000),
(69, 86, 10, 120000),
(76, 59, 11, 154000),
(79, 39, 6, 210000),
(79, 57, 4, 56000),
(79, 71, 10, 200000),
(79, 100, 6, 108000),
(80, 60, 5, 70000),
(84, 54, 10, 450000),
(86, 105, 9, 180000),
(86, 1, 5, 85000),
(88, 2, 2, 34000),
(96, 1, 8, 136000),
(97, 1, 4, 68000);




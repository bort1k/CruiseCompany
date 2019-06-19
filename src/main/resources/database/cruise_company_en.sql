CREATE DATABASE cruise_company_en;
use cruise_company_en;
-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Час створення: Чрв 19 2019 р., 10:12
-- Версія сервера: 10.3.15-MariaDB
-- Версія PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `cruise_company_en`
--

-- --------------------------------------------------------

--
-- Структура таблиці `bonus`
--

CREATE TABLE `bonus` (
  `bonus_name` varchar(45) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп даних таблиці `bonus`
--

INSERT INTO `bonus` (`bonus_name`, `id`) VALUES
('swimming pool', 1),
('cinema', 2),
('gym', 3),
('spa', 4),
('bar', 5),
('restaurant', 6);

-- --------------------------------------------------------

--
-- Структура таблиці `bonus_in_user`
--

CREATE TABLE `bonus_in_user` (
  `id` int(11) NOT NULL,
  `bonus_id` int(11) NOT NULL,
  `user_order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Структура таблиці `cruise`
--

CREATE TABLE `cruise` (
  `id` int(11) NOT NULL,
  `duration` int(3) NOT NULL,
  `number_of_ports` int(2) NOT NULL,
  `price` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `ship_id` int(11) NOT NULL,
  `cruise_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `cruise`
--

INSERT INTO `cruise` (`id`, `duration`, `number_of_ports`, `price`, `start_date`, `ship_id`, `cruise_name`) VALUES
(1, 7, 4, 750, '2019-06-24', 1, 'Northern Europe-1'),
(2, 5, 4, 600, '2019-07-03', 1, 'Northern Europe - 2'),
(3, 8, 5, 600, '2019-06-24', 2, 'Canada-Alaska-1'),
(4, 7, 8, 550, '2019-07-04', 2, 'Canada-Alaska-2'),
(5, 7, 4, 550, '2019-06-23', 3, 'Japan -1'),
(6, 7, 5, 600, '2019-07-03', 3, 'Japan-2'),
(7, 9, 4, 960, '2019-07-11', 4, 'Asia- 1'),
(8, 5, 3, 380, '2019-08-01', 4, 'Asia-2'),
(9, 24, 15, 12000, '2019-07-24', 7, 'Transatlantic cruise'),
(10, 7, 5, 1200, '2019-07-05', 7, 'Greece-Israel-1'),
(11, 8, 5, 1450, '2019-07-15', 7, 'Greece'),
(12, 5, 4, 800, '2019-06-24', 5, 'Greece-Israel-2'),
(13, 13, 8, 2400, '2019-07-02', 5, 'Cruise on the Ionian and Adriatic seas'),
(14, 7, 5, 1000, '2019-06-30', 10, 'Italy-Greece'),
(15, 8, 5, 1200, '2019-07-11', 10, 'Italy-Greece-Croatia'),
(16, 7, 5, 1700, '2019-07-11', 8, 'Italy-1'),
(17, 7, 4, 1450, '2019-07-21', 8, 'Italy-2'),
(18, 7, 5, 3000, '2019-08-01', 6, 'United Arab Emirates-1'),
(19, 8, 5, 3600, '2019-08-11', 6, 'United Arab Emirates-2'),
(20, 34, 17, 11560, '2019-07-04', 9, 'Round-the-world cruise');

-- --------------------------------------------------------

--
-- Структура таблиці `cruise_in_harbor`
--

CREATE TABLE `cruise_in_harbor` (
  `id` int(11) NOT NULL,
  `cruise_id` int(11) NOT NULL,
  `harbor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `cruise_in_harbor`
--

INSERT INTO `cruise_in_harbor` (`id`, `cruise_id`, `harbor_id`) VALUES
(1, 1, 4),
(2, 1, 1),
(3, 1, 2),
(4, 1, 3),
(5, 2, 2),
(6, 2, 1),
(7, 2, 5),
(8, 2, 3),
(9, 3, 6),
(10, 3, 7),
(11, 3, 8),
(12, 3, 9),
(13, 3, 10),
(14, 4, 11),
(15, 4, 10),
(16, 4, 9),
(17, 4, 8),
(18, 4, 7),
(19, 5, 16),
(20, 5, 17),
(21, 5, 18),
(22, 5, 19),
(23, 6, 17),
(24, 6, 20),
(25, 6, 21),
(26, 6, 19),
(27, 6, 22),
(28, 7, 12),
(29, 7, 13),
(30, 7, 14),
(31, 7, 15),
(32, 8, 12),
(33, 8, 13),
(34, 8, 15),
(35, 9, 4),
(36, 9, 23),
(37, 9, 24),
(38, 9, 25),
(39, 9, 1),
(40, 9, 2),
(41, 9, 3),
(42, 9, 5),
(43, 9, 26),
(44, 9, 27),
(45, 9, 28),
(46, 9, 29),
(47, 9, 30),
(48, 9, 31),
(49, 9, 32),
(50, 9, 33),
(51, 10, 34),
(52, 10, 35),
(53, 10, 36),
(54, 10, 37),
(55, 10, 38),
(56, 11, 34),
(57, 11, 35),
(58, 11, 39),
(59, 11, 40),
(60, 11, 36),
(61, 12, 34),
(62, 12, 37),
(63, 12, 41),
(64, 12, 38),
(65, 13, 34),
(69, 13, 35),
(70, 13, 40),
(71, 13, 48),
(72, 13, 42),
(73, 13, 43),
(74, 13, 44),
(75, 13, 45),
(76, 13, 46),
(77, 14, 47),
(78, 14, 46),
(79, 14, 45),
(80, 14, 35),
(81, 14, 48),
(82, 15, 47),
(83, 15, 48),
(84, 15, 42),
(85, 15, 49),
(86, 15, 50),
(87, 16, 51),
(88, 16, 52),
(89, 16, 53),
(90, 16, 54),
(91, 16, 55),
(92, 17, 54),
(93, 17, 56),
(94, 17, 57),
(95, 17, 51),
(96, 18, 58),
(97, 18, 59),
(98, 18, 63),
(99, 18, 62),
(100, 19, 58),
(101, 19, 59),
(102, 19, 60),
(103, 19, 61),
(104, 19, 62),
(105, 20, 64),
(106, 20, 65),
(107, 20, 66),
(108, 20, 51),
(109, 20, 67),
(110, 20, 68),
(111, 20, 69),
(112, 20, 70),
(113, 20, 71),
(114, 20, 72),
(115, 20, 73),
(116, 20, 74),
(117, 20, 75),
(118, 20, 76),
(119, 20, 77),
(120, 20, 78);

-- --------------------------------------------------------

--
-- Структура таблиці `harbor`
--

CREATE TABLE `harbor` (
  `id` int(11) NOT NULL,
  `harbor_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `harbor`
--

INSERT INTO `harbor` (`id`, `harbor_name`) VALUES
(1, 'Tallinn'),
(2, 'St. Petersburg'),
(3, 'Helsinki'),
(4, 'Copenhagen'),
(5, 'Stockholm'),
(6, 'Anchorage'),
(7, 'Gleysher Bay'),
(8, 'Skagway'),
(9, 'Juno'),
(10, 'Ketchikan'),
(11, 'Vancouver'),
(12, 'Singapore'),
(13, 'Penguin Malaysia'),
(14, 'Olivia'),
(15, 'Phuket'),
(16, 'Tokyo'),
(17, 'Kobe'),
(18, 'Jeju'),
(19, 'Kagoshima'),
(20, 'Cochin'),
(21, 'Matsuyama'),
(22, 'Busan'),
(23, 'Roseau'),
(24, 'Gdynia'),
(25, 'Riga'),
(26, 'Visby'),
(27, 'Oslo'),
(28, 'Flom'),
(29, 'Alesund'),
(30, 'The Curia Bay'),
(31, 'Bodo'),
(32, 'Bergen'),
(33, 'Southampton'),
(34, 'Athens'),
(35, 'Mykonos'),
(36, 'Rhodes'),
(37, 'Limassol'),
(38, 'Ashdod'),
(39, 'Ephessen'),
(40, 'Patmos'),
(41, 'Haifa'),
(42, 'Chania'),
(43, 'Zakynthos'),
(44, 'Corfu'),
(45, 'Kotor'),
(46, 'Venice'),
(47, 'Bari'),
(48, 'Santorini'),
(49, 'Capelonia'),
(50, 'Split'),
(51, 'Barcelona'),
(52, 'Nice'),
(53, 'Florence'),
(54, 'Rome'),
(55, 'Amalfi Coast'),
(56, 'Naples'),
(57, 'Palm'),
(58, 'Abu Dhabi'),
(59, 'Sir Bani Yas Island'),
(60, 'Manama'),
(61, 'Doha'),
(62, 'Dubai'),
(63, 'El Khasab'),
(64, 'Chivayevka'),
(65, 'Genoa'),
(66, 'Marseille'),
(67, 'Lisbon'),
(68, 'Funchal'),
(69, 'Mindel'),
(70, 'Salvador'),
(71, 'Rio de Janeiro'),
(72, 'Buenos Aires'),
(73, 'Montevideo'),
(74, 'Puerto Madride'),
(75, 'Ushuaia'),
(76, 'Punta Arenas'),
(77, 'Puerto Montt'),
(78, 'Valparaiso');

-- --------------------------------------------------------

--
-- Структура таблиці `personal`
--

CREATE TABLE `personal` (
  `id` int(11) NOT NULL,
  `captain_firstname` varchar(200) NOT NULL,
  `captain_lastname` varchar(200) NOT NULL,
  `technical_workers` int(11) NOT NULL,
  `hotel_workers` int(11) NOT NULL,
  `shop_workers` int(11) NOT NULL,
  `ship_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `personal`
--

INSERT INTO `personal` (`id`, `captain_firstname`, `captain_lastname`, `technical_workers`, `hotel_workers`, `shop_workers`, `ship_id`) VALUES
(1, 'Yara', 'Greyjoy', 50, 35, 15, 1),
(2, 'Antonio', 'French', 35, 15, 3, 2),
(3, 'Steve\r\n', 'Romb', 290, 200, 28, 3),
(4, 'Edward', 'Smith', 350, 180, 55, 4),
(5, 'Franchesko', 'Scettino', 680, 345, 69, 5),
(6, 'Joseph', 'Barnet', 5, 3, 1, 6),
(7, 'Arthur Henry', 'Rostron', 790, 402, 39, 7),
(8, 'Hans', 'Freiherr', 290, 175, 25, 8),
(9, 'Kate ', 'McKay', 805, 421, 59, 9),
(10, 'Robert', 'Scott', 180, 110, 15, 10);

-- --------------------------------------------------------

--
-- Структура таблиці `ship`
--

CREATE TABLE `ship` (
  `id` int(11) NOT NULL,
  `passenger_capacity` int(4) NOT NULL,
  `ship_name` varchar(200) NOT NULL,
  `release_year` int(4) NOT NULL,
  `image_url` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `ship`
--

INSERT INTO `ship` (`id`, `passenger_capacity`, `ship_name`, `release_year`, `image_url`) VALUES
(1, 300, 'Sea Angel', 2016, 'sea-angel'),
(2, 52, ' American Spirit', 2019, 'american-spirit'),
(3, 1188, 'Artania', 2014, 'artania'),
(4, 1874, 'Aurora', 2018, 'aurora'),
(5, 2139, 'Brilliance of the seas', 2018, 'brilliance-of-the-seas'),
(6, 18, 'Camila', 2017, 'camila'),
(7, 3700, 'Costa Diadema', 2019, 'costa-diadema'),
(8, 1400, 'Main schiff herz', 2015, 'main-schiff-herz'),
(9, 4200, 'Enchantiant Princess', 2016, 'enchantiant-princess'),
(10, 450, 'Aegean Odyssey', 2019, 'aegean-odyssey');

-- --------------------------------------------------------

--
-- Структура таблиці `tour`
--

CREATE TABLE `tour` (
  `id` int(11) NOT NULL,
  `tour_name` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  `harbor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `tour`
--

INSERT INTO `tour` (`id`, `tour_name`, `price`, `description`, `harbor_id`) VALUES
(1, 'Tour to the Catherine Palace and the Amber Room', 45, '-  Review of the Catherine Palace and the park.\r\n- Review of the restored Amber Room.\r\n- Excursion to Tsarskoe Selo.\r\n    ', 2),
(2, 'Welcome to Tallinn: private walking tour', 30, ' What to do in the city according to your interests. You will feel more confident after the tour in Tallinn with  private guide.', 1),
(3, 'Stockholm: walking tour of the Old Town', 20, '- Walk around the old city.\r\n- Review of the church Riddarholmen.\r\n- Review of the Birger Jarl Monument.\r\n- Review of the royal palaces built in the 1600s.\r\n- Lake Malaren`s Panorama.\r\n   ', 5),
(4, 'Anchorage Tour', 180, ' - A trip to the picturesque Seward Highway.\r\n - Cruise on the glacier Portage\r\n - Visit Alaska Wildlife Refuge Center\r\n - A trip to the mountains of Chugach.\r\n - Lunch in the local cottage (not free)\r\n', 6),
(5, 'Ketchikan: a private park Potlach, the city and the wildlife tour', 100, ' - A trip on the new Ford Transit.\r\n - Walks in a private park Potlach.\r\n - A review of the collection of historical exhibits and totem pillars  \r\n - History and legends about the tote of the your guide.\r\n - Тrip to Herring Bay.\r\n - Observing wildlife(black bears, bald eagles, chickpeas and salmon)\r\n - Shopping on Crick Street\r\n   ', 10),
(6, 'Vancouver: A 7-hour city tour', 70, ' - Stanley Park\r\n - Granville Island\r\n - Vancouver Lookout\r\n - Harbor Center  Gastown\r\n - Chinatown\r\n - Robson Street\r\n - English Gulf \r\n - Vancouver Harbor\r\n - Lion Gates \r\n - Tropical forest of the northern coast of Vancouver \r\n - Park Capilano Suspension Bridge\r\n - Capilano Salmon.\r\n\r\n', 11),
(7, 'Private walking photo-tour of Kobe', 50, ' - Higashi Yuenchi Park\r\n - Museum of the city\r\n - Walk around the city\r\n - historic district of Motomati\r\n - Shopping street of the city\r\n - Chinatown\r\n - Harbor Kobe \r\n - Tower of port of kobe\r\nYou can buy your photo after tour.', 17),
(8, 'Pusan tour of the night city', 40, '   Walk around the night city with professional guide.', 22),
(9, 'Tokyo Disneyland: a 1-day ticket without a queue', 60, '    Amazing atmosphere and attractions in a magical place. Allow yourself to enjoy like child.\r\n     You can meet classic Disney characters, try the famous rides and slideshows of the Disneyland Park.', 16),
(10, 'Jeju Island: tour of UNESCO\'s heritage sites', 90, ' - Riding horseback.\r\n - Visit the folk village of Sonip\r\n - Lunch with locals\r\n - An amazing show of plunger (Women dive into the sea without equipment to catch octopus or sea ears and show you.)  \r\n -Rise to Seongsan Ilchulbong\r\n - A review of the lava tunnel with an interesting structure and lighting.\r\n', 18),
(11, 'Excursion to Universal Studios Singapore ™', 60, '    You go behind the scenes of the movie industry and ride on attractions(Ride The Movies ™) in Universal Studios Singapore ™. \r\n  There are 24 attractions/\r\n  The park occupies about 200 square kilometers  and has 7 thematic zones: Hollywood, New York, City of Science Fiction, Ancient Egypt, Lost World, Far and Far Kingdom and Madagascar.', 12),
(12, 'Phuket: 15-Taster Food Tour', 55, ' - Spicy Rice Appetizer\r\n - Burmese curry\r\n - Crispy Samosі \r\n - Exotic fresh fruits and vegetables\r\n - Fried coconut balls\r\n - Shrimp cooked in banana leaves\r\n - Pork pancakes with sweet sauce\r\n - Barbecues made of coconut pork\r\n - peanut satany with acute ayate with cucumbers\r\nand other delicacies.\r\n\r\n   ', 15),
(13, 'Tour of Kings and Castles', 90, ' - A walk along the coast from lively Copenhagen to the historic city of Helsingor. \r\n - Kronborg\r\n - Castle of Hamlet, built by King Frederic II.\r\n - Maritime Museum in Helsinge \r\n - Taste the Danish sandwich  \r\n - Fredensborg, which translates \"Palace of the World\". ', 4),
(14, 'Riga: A 2-hour private tour of the Old Town', 60, '    Find out why Riga is considered the capital of Christmas trees, where the key is kept from Riga and more.\r\n    You will be able to see the oldest stone house in Riga and a new building of the National Library.', 25),
(15, 'Oslo: an overview hop-on hop-off tour of the city', 45, ' Oslo is the oldest Scandinavian capital.\r\nYou can see Henrik Ibsen Museum dedicated to the life and work of the Norwegian playwright and poet of the XIX century, The Royal Palace, the former residence of King of Norway and Sweden Charles III and the official residence of the current Norwegian monarch, Viking Ship Museum, Fram Museum, Norwegian Maritime Museum, Wigeland Sculpture Park and Oslo Opera House.', 27),
(16, 'Southampton: Individual private tour with a local resident', 20, '   The guide will tell you about the best places to eat and talk.\r\n   You will see some of the best attractions and learn more about what you can visit yourself after the tour.', 33),
(17, 'Archaeological Museum and Panoramic Private Tour in Athens', 50, '  - Visit the National Archaeological Museum\r\n  - Numerous galleries with historical artifacts \r\nand more.', 34),
(18, 'Rhodes: Adventure jump and scuba diving', 65, ' - Adventure jump \r\n - Trip along the rocky coast \r\n - Secret cave full of fish \r\n - High rock jump', 36),
(19, 'Excursion to Nazareth to Haifa, Acre and Rosh Hanikra', 70, ' - Mount Okata, where was Jesus.\r\n - Haifa\r\n - Acre (explore the old city walls, the fortresses of crusaders, mosques, lighthouses)\r\n -Rosh Hanikra', 41),
(20, 'The greatness of Venice: the tour through the Palace of the Dozhiv and St. Mark\'s Cathedral', 70, '    The Doge\'s Palace and St. Mark\'s Cathedral are the most significant symbols of Venice. You will get acquainted with the history of the city.\r\n    You will go to the prison cameras and walk through the famous Zithhan Bridge.\r\n   Then, visit St. Mark\'s Cathedral.', 46),
(21, 'Excursion with original parties', 50, '    Boat trip from Mykonos to Delos. \r\n    Visit to the house of Dionysus with mosaics, marble columns and wall paintings.\r\n    Delos Theater.\r\n    Temple of Apollo.\r\n    Archaeological Museum', 35),
(22, 'Santorini: Instagram tour of the picturesque places', 70, '   Discover volcanic views and beautiful sights of Santorini Island. \r\n    Stay at the famous blue domes located on the north side of the island. \r\n    Walk around the streets of the traditional settlement of Iya.', 48),
(23, 'Barcelona Stadium \"Camp Nou\"', 35, 'The Camp Nou tour will allow you to go  through the players footsteps of history. Immerse yourself in the powerful Barselona atmosphere by visiting the most famous places of the \"Camp Nou\": starting with the guest locker room and ending with a tunnel on the field, where the panorama of the entire stadium opens.', 51),
(24, 'Florentine Cathedral: entrance without queues and express tour', 25, '   Visit one of the main attractions of Florence without long queues and encourage your travel time during your express tour of the Cathedral of Santa Maria del Fiore.', 53),
(25, 'Colosseum and Ancient Rome: walking tour without queues', 30, '    Check out the most popular monuments of Ancient Rome - the Colosseum, the Roman Forum and the Palatine - without a queue.\r\n    The tour will be conducted by a professional guide, who will tell about the history of Ancient Rome and the most famous emperors.\r\n    ', 54),
(26, 'Sightseeing tour of Naples on E-Bike', 45, '    Start your trip to Spaccanapolis in the historic city center to reach the Piazza del Mounísos, where Castel Nuovo is located.\r\n    Travel along the coast of Neapolitan Bay with spectacular views of Vesuvius and Capri Island.', 56),
(27, 'Abu Dhabi: barbecue desert safari, camels and sandboarding', 75, 'Awake your inner child, having risen on a sandboard and having rolled along the sandy slopes, trying to maintain balance. After these adventures, go to the desert camp where you ride on camels.', 58),
(28, 'Dubai Aquarium and Burj Khalifa', 30, '   First you will have an excursion to the summit of Burj Khalifa\r\n    Далі вас чекає найбільший у світі підвісний акваріум. ', 62),
(29, 'Statue of Christ, Sugar Head, Selarona: tour with dinner', 120, '    You will reach the 38-meter statue of Christ the Savior at an altitude of 710 meters.\r\n    Then head to the Maracan football stadium.\r\n    Then head for a lunch to a typical Brazilian steak house.\r\n     After dinner, visit the Sugar Head.\r\n    ', 71),
(30, 'Buenos Aires: Piazzolla tango show with dinner', 25, '   Enjoy live tango evenings in the historic Galería Güemes, in the heart of Buenos Aires.\r\n    Before the show, join the free tango class from 20:00 to 20:30. ', 72),
(31, 'Hike to the volcano Osorno, the waterfall of Petrokh and the Emerald Lake', 320, '   Walk through the Villa Ensenada and explore the skirts of Osorno Volcano.\r\n   Next are the famous waterfalls Petruhe or Los-Saltos and Lake Todos Los Santos, also known as the Emerald Lake.', 77);

-- --------------------------------------------------------

--
-- Структура таблиці `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(200) NOT NULL,
  `lastname` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `role` enum('USER','ADMIN') NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `email`, `role`, `password`) VALUES
(1, 'Nikita', 'Bortnichuk', 'nikita.bortnichuk41@gmail.com', 'ADMIN', '1qaz'),
(2, 'Anna', 'Tarasenko', 'anna.tarasenko@gmail.com', 'USER', '2wsx');

-- --------------------------------------------------------

--
-- Структура таблиці `user_order`
--

CREATE TABLE `user_order` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `cruise_id` int(11) NOT NULL,
  `status` enum('CONFIRMED','WAITING','DENIED','PAID') NOT NULL,
  `sum_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп даних таблиці `user_order`
--

INSERT INTO `user_order` (`id`, `user_id`, `cruise_id`, `status`, `sum_price`) VALUES
(9, 2, 1, 'WAITING', 750),
(10, 2, 1, 'WAITING', 840),
(11, 1, 1, 'WAITING', 840),
(12, 1, 2, 'WAITING', 600),
(13, 2, 6, 'WAITING', 650),
(14, 2, 7, 'WAITING', 1020),
(15, 2, 20, 'WAITING', 11880);

--
-- Індекси збережених таблиць
--

--
-- Індекси таблиці `bonus`
--
ALTER TABLE `bonus`
  ADD PRIMARY KEY (`id`);

--
-- Індекси таблиці `bonus_in_user`
--
ALTER TABLE `bonus_in_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bonus_id_idx` (`bonus_id`),
  ADD KEY `user_order_id_idx` (`user_order_id`);

--
-- Індекси таблиці `cruise`
--
ALTER TABLE `cruise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ship_id_idx` (`ship_id`);

--
-- Індекси таблиці `cruise_in_harbor`
--
ALTER TABLE `cruise_in_harbor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cruise_id` (`cruise_id`),
  ADD KEY `harbor_id` (`harbor_id`);

--
-- Індекси таблиці `harbor`
--
ALTER TABLE `harbor`
  ADD PRIMARY KEY (`id`);

--
-- Індекси таблиці `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ship_id_idx` (`ship_id`);

--
-- Індекси таблиці `ship`
--
ALTER TABLE `ship`
  ADD PRIMARY KEY (`id`);

--
-- Індекси таблиці `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `harbor_id` (`harbor_id`);

--
-- Індекси таблиці `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Індекси таблиці `user_order`
--
ALTER TABLE `user_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cruise_id_IDX` (`cruise_id`),
  ADD KEY `user_id_idx` (`user_id`);

--
-- AUTO_INCREMENT для збережених таблиць
--

--
-- AUTO_INCREMENT для таблиці `bonus`
--
ALTER TABLE `bonus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT для таблиці `bonus_in_user`
--
ALTER TABLE `bonus_in_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблиці `cruise`
--
ALTER TABLE `cruise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT для таблиці `harbor`
--
ALTER TABLE `harbor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT для таблиці `personal`
--
ALTER TABLE `personal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблиці `ship`
--
ALTER TABLE `ship`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблиці `tour`
--
ALTER TABLE `tour`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT для таблиці `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблиці `user_order`
--
ALTER TABLE `user_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Обмеження зовнішнього ключа збережених таблиць
--

--
-- Обмеження зовнішнього ключа таблиці `bonus_in_user`
--
ALTER TABLE `bonus_in_user`
  ADD CONSTRAINT `bonus_in_user_ibfk_1` FOREIGN KEY (`user_order_id`) REFERENCES `user_order` (`id`),
  ADD CONSTRAINT `bonus_in_user_ibfk_2` FOREIGN KEY (`bonus_id`) REFERENCES `bonus` (`id`);

--
-- Обмеження зовнішнього ключа таблиці `cruise`
--
ALTER TABLE `cruise`
  ADD CONSTRAINT `ship_id` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Обмеження зовнішнього ключа таблиці `cruise_in_harbor`
--
ALTER TABLE `cruise_in_harbor`
  ADD CONSTRAINT `cruise_in_harbor_ibfk_1` FOREIGN KEY (`cruise_id`) REFERENCES `cruise` (`id`),
  ADD CONSTRAINT `cruise_in_harbor_ibfk_2` FOREIGN KEY (`harbor_id`) REFERENCES `harbor` (`id`);

--
-- Обмеження зовнішнього ключа таблиці `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`);

--
-- Обмеження зовнішнього ключа таблиці `tour`
--
ALTER TABLE `tour`
  ADD CONSTRAINT `tour_ibfk_1` FOREIGN KEY (`harbor_id`) REFERENCES `harbor` (`id`);

--
-- Обмеження зовнішнього ключа таблиці `user_order`
--
ALTER TABLE `user_order`
  ADD CONSTRAINT `user_order_ibfk_1` FOREIGN KEY (`cruise_id`) REFERENCES `cruise` (`id`),
  ADD CONSTRAINT `user_order_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

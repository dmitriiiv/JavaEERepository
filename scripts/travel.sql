-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.25-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных tours_app
CREATE DATABASE IF NOT EXISTS `tours_app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tours_app`;


-- Дамп структуры для таблица tours_app.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы tours_app.roles: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'administrator'),
	(2, 'user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Дамп структуры для таблица tours_app.tours
CREATE TABLE IF NOT EXISTS `tours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `heading` varchar(100) NOT NULL,
  `text` text NOT NULL,
  `duration` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы tours_app.tours: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `tours` DISABLE KEYS */;
INSERT INTO `tours` (`id`, `heading`, `text`, `duration`, `price`) VALUES
	(1, 'Турция. Кушадасы. Предложение от отеля DOGAN PARADISE 3*', 'Отель имеет отличный песчаный пляж, подходит для спокойного, экономичного отдыха. Туристы отеля могут пользоваться услугами SPA-центра находящегося в отеле Dogan Beach Resort, в определенные часы предоставляется транспорт.Все включено.', 11, 17770000),
	(2, 'Испания, Барселона. Отдых в отелях цепочки BEST', 'Отель Best Mediterráneo расположен в центре Салоу, в 5 минутах ходьбы от пляжа Капельянс. В отеле есть открытый бассейн, круглосуточная стойка регистрации, а также предоставляются номера с кондиционерами, телевизором и отдельным балконом. Отель расположен в 10 минутах езды от тематического парка Порт Авентура. Отель может похвастаться центральным расположением, в окружении ресторанов, баров и магазинов. Отель Best Mediterráneo предлагает разнообразную развлекательную программу для взрослых и детей. Кроме того, в отеле есть детская игровая площадка и интернет-уголок с бесплатным доступом в Интернет.', 7, 13000000),
	(3, 'Отдых в Испании по системе фортуна! Лучшие курорты по самым низким ценам', 'Отдых по системе фортуна - уникальная возможность соотнести незабываемые впечатления от отдыха на лучших курортах Испании с весьма демократичными ценами.', 7, 11500000),
	(4, 'Болгария. Спецпредложение на вылет из Минска 23 августа', 'Гостиничный комплекс Majestic Hotel and residence (отель и апарт-отель) стоит у подножия покрытых лесом холмов в северной части курорта Солнечный берег. В общей сложности он занимает площадь в 56 тысяч кв. м. Комплекс состоит из 5 корпусов: А, В, С, D, E. В последних двух располагаются апартаменты. Собственный пляж доступен как гостям отеля, так и хозяевам апартаментов. ', 11, 13900000),
	(5, 'Греция. Крит. Горящее предложение!', 'Небольшой уютный отель утопает в зелени. Состоит из небольших зданий. Ухоженная территория, просторные номера и апартаменты. Прибрежная курортная зона Картерос плавно соединяется с соседним курортом Амниссос, где пляжи с золотистым песком и бесконечное, сливающееся с горизонтом голубое море производят незабываемое впечатление. Помимо активного пляжного отдыха и экскурсий вы получите удовольствие от обеда в традиционной греческой таверне на берегу моря или от чашечки ароматного греческого кофе в одном из многочисленных кафе на фоне великолепного заката.', 10, 23200000),
	(6, 'Греция, Закинф. Горящие предложения', 'Небольшой отель в центре Циливи. Простота стиля, номера со всеми удобствами, бары, бассейн, джакузи, интернет, качественное обслуживание. Рядом с отелем расположено множество магазинов, бар, таверн, клубов. Подойдет для активного семейного и молодежного отдыха.', 14, 23300000),
	(7, 'Франция, Париж - регулярные экскурсионные авиатуры', 'Вылет из Минска каждый вторник, пятницу и воскресенье. Продолжительность тура: 8 дней/7 ночей. Автобусная обзорная экскурсия по Парижу: осмотр основных достопримечательностей Парижа с остановками в Люксембургском саду, у Дома Инвалидов и на площади Трокадеро /3 часа/\r\nПешеходная экскурсия в музей парфюмерии «Фрагонар», посещение международного центра бриллиантов, посещение магазина беспошлинной торговли «Paris Look» /2 часа/\r\nПешеходная экскурсия по кварталу Монтмартр /2 часа/\r\nЭкскурсия по Латинскому кварталу /2 часа/', 8, 13270000);
/*!40000 ALTER TABLE `tours` ENABLE KEYS */;


-- Дамп структуры для таблица tours_app.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы tours_app.users: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `pass`) VALUES
	(1, 'login@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99'),
	(2, 'admin@gmail.com', '21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Дамп структуры для таблица tours_app.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы tours_app.user_role: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 2),
	(2, 2, 1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

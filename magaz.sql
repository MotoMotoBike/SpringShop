-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Ноя 09 2021 г., 17:02
-- Версия сервера: 5.7.33
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `magaz`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cart`
--

CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL,
  `count` int(11) NOT NULL,
  `tovar_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `cart`
--

INSERT INTO `cart` (`id`, `count`, `tovar_id`, `user_id`) VALUES
(18, 0, 17, 1),
(23, 0, 17, 1),
(26, 0, 25, 1),
(31, 0, 30, 1),
(32, 0, 25, 1),
(45, 0, 25, 1),
(48, 0, 30, 1),
(49, 1, 17, 1),
(50, 0, 28, 3),
(51, 0, 28, 3),
(52, 0, 25, 3),
(55, 1, 54, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(56);

-- --------------------------------------------------------

--
-- Структура таблицы `images`
--

CREATE TABLE `images` (
  `id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `images`
--

INSERT INTO `images` (`id`, `url`) VALUES
(1, 'https://index-uliz.ru/wp-content/uploads/skolko-zhivut-koshki-v-domashnih-usloviyah-3-12.jpg'),
(3, 'https://fb.ru/misc/i/gallery/118286/3210088.jpg'),
(5, 'https://img.novosti-n.org/upload/ukraine/674676.jpg&name=small'),
(7, 'https://cdn.fishki.net/upload/post/2016/11/25/2146208/456d93c54eb7e0c1ee6bf5773f435fe3.jpg'),
(9, 'https://cdn.fishki.net/upload/post/2016/11/25/2146208/5baf088c4e7f7826d18b599dd0b8d371.jpg'),
(11, 'https://cdn.fishki.net/upload/post/2016/11/25/2146208/b9ec4f8db423e4b783f282ee9777b8f7.jpg'),
(16, 'https://4lapy.ru/resize/800x800/upload/iblock/8b3/8b3a4ecc4c641be387aed1d76a76a618.jpg'),
(24, 'https://avatars.mds.yandex.net/get-mpic/1925870/img_id6552173349127999972.png/orig'),
(27, 'https://avatars.mds.yandex.net/get-mpic/5278457/img_id2013128401051842779.jpeg/orig'),
(29, 'https://avatars.mds.yandex.net/get-mpic/4497593/img_id8843614319756233046.jpeg/orig'),
(33, 'https://avatars.mds.yandex.net/get-mpic/5207084/img_id3830131484677930628.jpeg/orig'),
(35, 'https://avatars.mds.yandex.net/get-mpic/5207084/img_id3830131484677930628.jpeg/orig'),
(37, 'https://avatars.mds.yandex.net/get-mpic/5207084/img_id3830131484677930628.jpeg/orig'),
(39, 'https://avatars.mds.yandex.net/get-mpic/5207084/img_id3830131484677930628.jpeg/orig'),
(41, 'https://avatars.mds.yandex.net/get-mpic/5207084/img_id3830131484677930628.jpeg/orig'),
(43, 'https://avatars.mds.yandex.net/get-mpic/5256693/img_id2916219329881861780.jpeg/orig'),
(46, 'https://i.baraholka.com.ru/files/2/4/2477646_6.jpg'),
(53, 'https://sbermarket.ru/spree/products/477322/preview/600279_1.jpg?1606144911');

-- --------------------------------------------------------

--
-- Структура таблицы `kategorys`
--

CREATE TABLE `kategorys` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `kategorys`
--

INSERT INTO `kategorys` (`id`, `name`) VALUES
(1, 'Происшествия'),
(2, 'Собаки спаспатели'),
(3, 'Котята'),
(4, 'Милота');

-- --------------------------------------------------------

--
-- Структура таблицы `news`
--

CREATE TABLE `news` (
  `id` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  `text` varchar(2550) DEFAULT NULL,
  `image_news_id` bigint(20) DEFAULT NULL,
  `kategory_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `news`
--

INSERT INTO `news` (`id`, `date`, `header`, `text`, `image_news_id`, `kategory_id`) VALUES
(6, '2021-11-03 20:37:33.926000', 'Собака спасла от завала', 'Во время землетрясения, которое произошло в Мексике 19 сентября, лабрадор по кличке Фрида спасла 52 человек. Собака, служащая в ВМС Мексики, искала людей в разрушенных зданиях и вытаскивала их из-под завалов.\r\n', 5, 2),
(8, '2021-11-04 17:12:21.346000', 'Берег дохлых селедок', 'Эта история выглядит как чья-то глупая и злая шутка. Однако, несмотря на тщательное расследование, следов человеческого вмешательства в ней найти так и не удалось. 31 декабря 2011 годна одно из норвежских побережий оказалось сплошь покрыто выброшенной на берег снулой сельдью. К счастью для местных жителей, стояла холодная зима, так что гниющая рыба не отравляла своими миазмами окрестности. Как и почему такое количество сельди попало на берег, выяснить так и не удалось. Единственным объяснением стала гулявшая среди местных шутка: мол, селедки чересчур рьяно отмечали новый год и, в итоге, решили выйти подышать, забыв, что могут делать это лишь под водой. Но на этом странная история не кончилась. Буквально на следующий день вся рыба исчезла. И вновь никто не понял, как это случилось. То ли прибой смыл ее обратно в море, то ли какая-то неведомая тварь выползла полакомиться из глубин? Словом, вариантов много, но какой из них истинный, неизвестно.', 7, 1),
(10, '2021-11-04 17:15:38.982000', 'Дождь из лягушек в Сербии', 'Как лягушки могут начать падать с неба? Для самых суеверных это означает конец света. Знатоки Библии помнят, что дождь из лягушек был одной из казней египетских, которую Моисей наслал на египтян за их жестокость и вероломство. Так что можно себе представить панику, охватившую жителей нескольких сербских деревень, когда в 2007 на их головы внезапно обрушился лягушачий дождь. Ученые пытались успокоить местное население вполне научным объяснением: мол, небольшой смерч всосал в себя воду из небольшого пруда вместе с лягушками, а потом эта вода пролилась из тучи вместе с дождем, ну, и лягушками соответственно. Но эти объяснения так никого и не успокоили, потому что звучат куда менее логично, нежели легенда о чудесах, сотворенных Моисеем.', 9, 1),
(12, '2021-11-04 17:36:26.454000', 'Нашествие детенышей морского льва в Калифорнии', 'А эта загадка уже серьезнее, и она уже давно не дает покоя биологам. В последние несколько лет на берега Калифорнии прибой выбрасывает беспрецедентное число отощавших и голодных детенышей морских львов. Местные власти изо всех сил стараются организовать для них помощь, но из-за масштабов явления не могут справиться с задачей: уж слишком много голодающих морских малышей нуждаются в помощи на калифорнийском побережье. Национальная администрация по океану и атмосфере США даже выпустила специальный циркуляр для жителей прибрежных районов, призывающий их сообщать властям о найденных на берегу маленьких котиках и терпеливо ждать помощи, не удивляясь тому, что она едет слишком долго. Ученые выдвинули несколько теорий, призванных объяснить загадочное явление. Большинство из них считают причиной изменения в окружающей среде. Возможно, из-за роста температуры воды в Мировом океане прервалась пищевая цепь, и из-за этого самки морских львов все чаще отказываются от детенышей, которых не могут прокормить. Сосунки еще не в состоянии позаботиться о себе, и поэтому их, обессилевших, в конце концов выносит на берег. Эта теория пока еще не доказана, но, скорее всего, многочисленные умирающие детеныши морского льва действительно являют собой одно из доказательств того, что климат Земли претерпевает глобальные изменения - и не в лучшую сторону.', 11, 1),
(47, '2021-11-06 19:06:56.762000', 'Паразиты, которые нами управляют. ', 'Токсоплазма в мозгу человека притупляет страх и заставляет любить кошек. Муравей ползёт в центр колонии, где контролирующий его гриб распространит свои споры. Червь в мозгу рыбы блокирует инстинкт самосохранения, чтобы та плавала на виду у хищных птиц. Как простейшие организмы управляют настроением и поведением насекомых, зверей и даже людей?\r\n', 46, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `poroda`
--

CREATE TABLE `poroda` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `vid_animal_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `poroda`
--

INSERT INTO `poroda` (`id`, `name`, `vid_animal_id`) VALUES
(1, 'Британская вислоухая', 1),
(2, 'Абессинская', 1),
(3, 'Африканская черепаха', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `sovet`
--

CREATE TABLE `sovet` (
  `id` bigint(20) NOT NULL,
  `header` varchar(255) DEFAULT NULL,
  `text` varchar(2550) DEFAULT NULL,
  `image_sovet_id` bigint(20) DEFAULT NULL,
  `poroda_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `sovet`
--

INSERT INTO `sovet` (`id`, `header`, `text`, `image_sovet_id`, `poroda_id`) VALUES
(2, 'Общая характеристика', 'Абиссинские кошки отличаются средними размерами тела, гибкостью и силой. Мускулатура развитая, конечности длинные. Это позволяет котам прыгать на расстояние, которое в 6 раз превышает их собственную длину. Самцы крупнее самок, однако половой диморфизм слабо выражен. Средний вес колеблется в пределах 3-4,5 кг. Кошки абиссинцы имеют гармоничное телосложение, их движения грациозные и четкие.\r\n\r\nАбиссинцы — величественные и грациозные создания, добрые и ласковые питомцы. Они отлично ладят с детьми и другими домашними животными.\r\n', 1, 2),
(4, 'Мытье', 'Абиссинского котенка не нужно часто купать. Водные процедуры необходимы, если питомец испачкался во время прогулки или его шерсть стала выглядеть неопрятно. Рекомендуемая частота купания – 1 раз за 2–3 месяца. Для ухода за шерстью нужно купить шампунь для короткошерстных кошек и кондиционер для гладкости и блеска.\r\n', 3, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `tovar`
--

CREATE TABLE `tovar` (
  `id` bigint(20) NOT NULL,
  `cost` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `discription` varchar(2550) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `image_tovar_id` bigint(20) DEFAULT NULL,
  `vid_animal_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tovar`
--

INSERT INTO `tovar` (`id`, `cost`, `count`, `discription`, `name`, `image_tovar_id`, `vid_animal_id`) VALUES
(17, 7999, 6, 'Дом-когтеточка с гамаком и лежанкой от PETMAX — многофункциональный комплекс, который станет местом, где ваш питомец будет спать, играть и проводить время в ваше отсутствие. Когтеточка позволит вашей кошке точить когти и защитит вашу мебель и ремонт.', 'Дом-когтеточка с гамаком и лежанкой 50х40х110 см', 16, 1),
(25, 658, 9, 'Поводок обычный, для средних собак', 'Поводок для собак Gripalle прорезиненный', 24, 4),
(28, 1446, 2, 'Террариум для черепах ФН 25 л, без крышки, с полкой и лесенкой, 40*29*22 см отлично подойдет для ваших любимцев\r\n', 'Террариум для черепах ФН 25 л', 27, 3),
(30, 450, 20, 'Керамические миски для домашних животных изготовлены из высококачественного фарфора, покрыты пищевой глазурью пастельных тонов. Миски тяжёлые и устойчивые, подойдут кошкам, собакам и крупным грызунам.\r\n', 'Миска', 29, 1),
(42, 590, 5, '58 зубцов из нержавеющей стали решат ваши проблемы в период линьки домашних питомцев и справятся с огромным количеством шерсти, оседающей на всех поверхностях.', 'Расчёска для собак', 41, 4),
(44, 1149, 12, 'Поводок Hunter Convenience Comfort для собак средних и крупных пород. Выполнен из инновационного материала биотан. Материал поводка не впитывает влагу, легко моется и не трескается на морозе. Практичный поводок для межсезонья. Ширина: 15 мм. Длина: 120 см.', 'Поводок для собак', 43, 4),
(54, 2499, 20, 'Когтечесалка для котов но не кошек', 'Когтечесалка', 53, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `tovar_in_news`
--

CREATE TABLE `tovar_in_news` (
  `university_id` bigint(20) NOT NULL,
  `news_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tovar_in_news`
--

INSERT INTO `tovar_in_news` (`university_id`, `news_id`) VALUES
(25, 6),
(44, 6),
(17, 47),
(54, 47);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `active`, `password`, `username`) VALUES
(1, b'1', '$2a$08$NiriNHXKjVT3rAHvvoHcbeeRc8fHyL8EeCm2v5vfdRizxFk/uJs6W', 'admin'),
(2, b'1', '$2a$08$w0f5hWzkfV4f5AoPGKSSO.ThdW0Gltunw3Z7Muc6c7AuFbOOymM/m', 'user'),
(3, b'1', '$2a$08$iT9RWrMwgXXPDSnA8h3pVenPSZJp/ZFvdKOXHIQMSHezKi//wTcK.', '1');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'USER');

-- --------------------------------------------------------

--
-- Структура таблицы `vid`
--

CREATE TABLE `vid` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `vid`
--

INSERT INTO `vid` (`id`, `name`) VALUES
(1, 'Кошки'),
(3, 'Черепахи'),
(4, 'Собаки'),
(5, '');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhfnkb9k6ppqhaovycwnu5u131` (`tovar_id`),
  ADD KEY `FKg5uhi8vpsuy0lgloxk2h4w5o6` (`user_id`);

--
-- Индексы таблицы `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `kategorys`
--
ALTER TABLE `kategorys`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4neshmf5houl6e26puvb2qa0d` (`image_news_id`),
  ADD KEY `FKrl4fpq6g08f1pndgh2pwgt71j` (`kategory_id`);

--
-- Индексы таблицы `poroda`
--
ALTER TABLE `poroda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdia1brtjh3a2ajtgoqj6v8r7n` (`vid_animal_id`);

--
-- Индексы таблицы `sovet`
--
ALTER TABLE `sovet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr8ef8ssn9r4x48qc5k62vnkcw` (`image_sovet_id`),
  ADD KEY `FK2e11w5cwgckkmvvcbpr98t9ue` (`poroda_id`);

--
-- Индексы таблицы `tovar`
--
ALTER TABLE `tovar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnnhfp86sma71nwjcb5yxgv586` (`image_tovar_id`),
  ADD KEY `FKbv2u41bjsm4b5xsnyaam3fucl` (`vid_animal_id`);

--
-- Индексы таблицы `tovar_in_news`
--
ALTER TABLE `tovar_in_news`
  ADD KEY `FKgfbowwb8uyb1q77w4r6j8b748` (`news_id`),
  ADD KEY `FK69rk5c4phtdoo3su01ky96133` (`university_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`);

--
-- Индексы таблицы `vid`
--
ALTER TABLE `vid`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `kategorys`
--
ALTER TABLE `kategorys`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `poroda`
--
ALTER TABLE `poroda`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `vid`
--
ALTER TABLE `vid`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FKg5uhi8vpsuy0lgloxk2h4w5o6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKhfnkb9k6ppqhaovycwnu5u131` FOREIGN KEY (`tovar_id`) REFERENCES `tovar` (`id`);

--
-- Ограничения внешнего ключа таблицы `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `FK4neshmf5houl6e26puvb2qa0d` FOREIGN KEY (`image_news_id`) REFERENCES `images` (`id`),
  ADD CONSTRAINT `FKrl4fpq6g08f1pndgh2pwgt71j` FOREIGN KEY (`kategory_id`) REFERENCES `kategorys` (`id`);

--
-- Ограничения внешнего ключа таблицы `poroda`
--
ALTER TABLE `poroda`
  ADD CONSTRAINT `FKdia1brtjh3a2ajtgoqj6v8r7n` FOREIGN KEY (`vid_animal_id`) REFERENCES `vid` (`id`);

--
-- Ограничения внешнего ключа таблицы `sovet`
--
ALTER TABLE `sovet`
  ADD CONSTRAINT `FK2e11w5cwgckkmvvcbpr98t9ue` FOREIGN KEY (`poroda_id`) REFERENCES `poroda` (`id`),
  ADD CONSTRAINT `FKr8ef8ssn9r4x48qc5k62vnkcw` FOREIGN KEY (`image_sovet_id`) REFERENCES `images` (`id`);

--
-- Ограничения внешнего ключа таблицы `tovar`
--
ALTER TABLE `tovar`
  ADD CONSTRAINT `FKbv2u41bjsm4b5xsnyaam3fucl` FOREIGN KEY (`vid_animal_id`) REFERENCES `vid` (`id`),
  ADD CONSTRAINT `FKnnhfp86sma71nwjcb5yxgv586` FOREIGN KEY (`image_tovar_id`) REFERENCES `images` (`id`);

--
-- Ограничения внешнего ключа таблицы `tovar_in_news`
--
ALTER TABLE `tovar_in_news`
  ADD CONSTRAINT `FK69rk5c4phtdoo3su01ky96133` FOREIGN KEY (`university_id`) REFERENCES `tovar` (`id`),
  ADD CONSTRAINT `FKgfbowwb8uyb1q77w4r6j8b748` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

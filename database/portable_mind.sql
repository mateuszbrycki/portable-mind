
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


--
-- Baza danych: `portable_mind`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `card`
--
CREATE TABLE IF NOT EXISTS `card` (
`id` int(255) NOT NULL,
  `fk_user_id` int(255) NOT NULL,
  `fk_category_id` int(255) NOT NULL,
  `fk_project_id` int(255) NOT NULL,
  `audit_cd` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `audit_md` timestamp NULL DEFAULT NULL,
  `card_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `card_category`
--
CREATE TABLE IF NOT EXISTS `card_category` (
`id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `fk_user_id` int(255) NOT NULL,
  `audit_cd` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `audit_md` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

--
-- Struktura tabeli dla tabeli `language`
--
CREATE TABLE IF NOT EXISTS `language` (
`id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

--
-- Struktura tabeli dla tabeli `project`
--
CREATE TABLE IF NOT EXISTS `project` (
`id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  `fk_user_id` int(255) NOT NULL,
  `audit_cd` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `audit_md` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

--
-- Struktura tabeli dla tabeli `translation`
--
CREATE TABLE IF NOT EXISTS `translation` (
`id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `fk_language_id` int(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

--
-- Struktura tabeli dla tabeli `user`
--
CREATE TABLE IF NOT EXISTS `user` (
`id` int(255) NOT NULL,
  `fk_user_role` int(11) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `password` text NOT NULL,
  `audit_cd` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `audit_md` timestamp NULL DEFAULT NULL,
  `is_public` tinyint(1) NOT NULL,
  `is_enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

--
-- Struktura tabeli dla tabeli `user_role`
--
CREATE TABLE IF NOT EXISTS `user_role` (
`id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;
--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `card`
--
ALTER TABLE `card`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_category_id` (`fk_category_id`), ADD KEY `fk_project_id` (`fk_project_id`), ADD KEY `fk_user_id_card` (`fk_user_id`);

--
-- Indexes for table `card_category`
--
ALTER TABLE `card_category`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_user_id_card_category` (`fk_user_id`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_user_id` (`fk_user_id`);

--
-- Indexes for table `translation`
--
ALTER TABLE `translation`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_language_id` (`fk_language_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_user_role` (`fk_user_role`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `card`
--
ALTER TABLE `card`
MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=0;
--
-- AUTO_INCREMENT dla tabeli `card_category`
--
ALTER TABLE `card_category`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=0;
--
-- AUTO_INCREMENT dla tabeli `language`
--
ALTER TABLE `language`
MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=0;
--
-- AUTO_INCREMENT dla tabeli `project`
--
ALTER TABLE `project`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=0;
--
-- AUTO_INCREMENT dla tabeli `translation`
--
ALTER TABLE `translation`
MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=0;
--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=0;
--
-- AUTO_INCREMENT dla tabeli `user_role`
--
ALTER TABLE `user_role`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=0;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `card`
--
ALTER TABLE `card`
ADD CONSTRAINT `fk_category_id` FOREIGN KEY (`fk_category_id`) REFERENCES `card_category` (`id`),
ADD CONSTRAINT `fk_project_id` FOREIGN KEY (`fk_project_id`) REFERENCES `project` (`id`),
ADD CONSTRAINT `fk_user_id_card` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`id`);

--
-- Ograniczenia dla tabeli `card_category`
--
ALTER TABLE `card_category`
ADD CONSTRAINT `fk_user_id_card_category` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`id`);

--
-- Ograniczenia dla tabeli `project`
--
ALTER TABLE `project`
ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`id`);

--
-- Ograniczenia dla tabeli `translation`
--
ALTER TABLE `translation`
ADD CONSTRAINT `fk_language_id` FOREIGN KEY (`fk_language_id`) REFERENCES `language` (`id`);

--
-- Ograniczenia dla tabeli `user`
--
ALTER TABLE `user`
ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`fk_user_role`) REFERENCES `user_role` (`id`);

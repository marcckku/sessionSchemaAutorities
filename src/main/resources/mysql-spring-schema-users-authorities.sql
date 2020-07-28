-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 21, 2020 alle 20:03
-- Versione del server: 10.4.13-MariaDB
-- Versione PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `flutterwebappdb`
--
CREATE DATABASE IF NOT EXISTS `flutterwebappdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `flutterwebappdb`;--inserisci il nome del tuo db

-- --------------------------------------------------------

--
-- Struttura della tabella `authorities`
--
-- Creazione: Lug 21, 2020 alle 18:00
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELAZIONI PER TABELLA `authorities`:
--   `username`
--       `users` -> `username`
--

-- --------------------------------------------------------
--
-- Struttura della tabella `users`
--
-- Creazione: Lug 21, 2020 alle 18:00
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELAZIONI PER TABELLA `users`:
--

-- --------------------------------------------------------

--
-- Indici per le tabelle `authorities`
--
ALTER TABLE `authorities`
  ADD UNIQUE KEY `ix_auth_username` (`username`,`authority`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Limiti per la tabella `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

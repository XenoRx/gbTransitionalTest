-- Задание 1
CREATE DATABASE Друзья_человека;

-- Задание 2
CREATE TABLE Домашние_животные (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Вьючные_животные (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Задание 3
INSERT INTO Домашние_животные (name, type) VALUES
  ("Собака", "Собака"),
  ("Кошка", "Кошка"),
  ("Хомяк", "Хомяк");

INSERT INTO Вьючные_животные (name, type) VALUES
  ("Лошадь", "Лошадь"),
  ("Верблюд", "Верблюд"),
  ("Осёл", "Осёл");

-- Задание 4
DELETE FROM Вьючные_животные WHERE name = "Верблюд";
ALTER TABLE Лошади RENAME TO Вьючные_животные;
ALTER TABLE Ослы RENAME TO Вьючные_животные;

-- Задание 5
CREATE TABLE Молодые_животные (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  age INT NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Молодые_животные (name, type, birth_date, age)
  SELECT name, type, birth_date,
    YEAR(CURRENT_DATE) - YEAR(birth_date) -
    (MONTH(CURRENT_DATE) - MONTH(birth_date)) / 12
  FROM Домашние_животные
  WHERE YEAR(birth_date) > 2022 AND YEAR(birth_date) < 2025;

-- Задание 6
CREATE TABLE Все_животные (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Все_животные (name, type, birth_date)
  SELECT name, type, birth_date
  FROM Домашние_животные
  UNION ALL
  SELECT name, type, birth_date
  FROM Вьючные_животные;
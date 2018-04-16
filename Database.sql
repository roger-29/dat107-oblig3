-- Nullstiller database

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

DROP TABLE IF EXISTS Ansatt;
DROP TABLE IF EXISTS Avdeling;
DROP TABLE IF EXISTS Prosjekt;
DROP TABLE IF EXISTS AnsattProsjekt;


-- Oppretter tabeller og relasjoner

CREATE TABLE Ansatt ( 
	AnsId SERIAL, 
	Brukernavn VARCHAR(16),
	Fornavn VARCHAR(32) NOT NULL, 
	Etternavn VARCHAR(32) NOT NULL, 
	Ansettelsesdato DATE,
	Stilling VARCHAR(32),
	Maanedslonn INTEGER,

	UNIQUE (AnsId, Brukernavn),

	CONSTRAINT AnsattPK PRIMARY KEY (AnsId)
);

CREATE TABLE Avdeling (
	AvdId SERIAL,
	Navn VARCHAR(32),

	UNIQUE (AvdId),

	CONSTRAINT Avdeling_PK PRIMARY KEY (AvdId)
);

CREATE TABLE Prosjekt (
	PrId SERIAL,
	Navn VARCHAR(32),
	Beskrivelse VARCHAR(255),
	Ansatte INTEGER,

	UNIQUE (PrId),

	CONSTRAINT Prosjekt_PK PRIMARY KEY (PrId)
);

CREATE TABLE AnsattProsjekt (
	AnsId INTEGER REFERENCES Ansatt(AnsId),
	PrId INTEGER REFERENCES Prosjekt(PrId),
	Timer INTEGER,
	Rolle VARCHAR(32),

	CONSTRAINT AnsattProsjektPK PRIMARY KEY (AnsId, PrId)
);

-- Legger til fremmednøkler

ALTER TABLE Ansatt 
	ADD COLUMN AvdId INTEGER REFERENCES Avdeling (AvdId);

ALTER TABLE Avdeling 
	ADD COLUMN Sjef INTEGER REFERENCES Ansatt (AnsId);


-- Legger inn data

INSERT INTO
	Ansatt (Brukernavn, Fornavn, Etternavn, Ansettelsesdato, Stilling, Maanedslonn)
VALUES
	('sondregj', 'Sondre', 'Gjellestad', '2018-01-01', 'CEO', 250000),
	('abc123', 'Ole', 'Nilsen', '2017-01-01', 'Vaskehjelp', 30000);

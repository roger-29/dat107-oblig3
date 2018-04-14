CREATE TABLE Ansatt ( 
	id int 
	brukernavn varchar(10) 
	fornavn varchar(32) 
	etternavn varchar(32) 
	ansettelsesdato date 
	maanedslonn int 
	avdeling varchar(32) 
);

CREATE TABLE Avdeling (
	id int
	navn varchar(32)
	sjef int
);

CREATE TABLE Prosjekt (
	id int
	navn varchar(32)
	beskrivelse varchar(255)
	ansatte int
);

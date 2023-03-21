DROP TABLE IF EXISTS circuits;
CREATE TABLE circuits (
    circuitId serial,
    circuitRef VARCHAR,
    name VARCHAR,
    location VARCHAR,
    country VARCHAR,
    lat float,
    lng float,
    alt float,
    url VARCHAR
);
COPY circuits
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\circuits.csv'
DELIMITER ','
CSV HEADER;

DROP TABLE IF EXISTS constructors;
CREATE TABLE constructors (
    constructorId serial,
	constructorRef VARCHAR,
	name VARCHAR,
	nationality VARCHAR,
	url VARCHAR
);
COPY constructors
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\constructors.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS drivers;
CREATE TABLE drivers (
    driverId serial,
	driverRef VARCHAR,
	number integer,
	code VARCHAR,
	forename VARCHAR,
	surname VARCHAR,
	dob DATE,
	nationality VARCHAR,
	url VARCHAR
);
COPY drivers
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\drivers.csv'
DELIMITER ','
CSV HEADER;

DROP TABLE IF EXISTS races;
CREATE TABLE races (
    raceId serial,
	year integer,
	round integer,
	circuitId integer,
	name VARCHAR,
	date DATE,
	time TIME,
	url VARCHAR
);
COPY races
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\races.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS seasons;
CREATE TABLE seasons (
    year integer,
	url VARCHAR
);
COPY seasons
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\seasons.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS status;
CREATE TABLE status (
    statusId serial,
	status VARCHAR
);
COPY status
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\status.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS results;
CREATE TABLE results (
    resultId serial,
	raceId integer,
	driverId integer,
	constructorId integer,
	number integer,
	grid integer,
	position integer,
	positionText VARCHAR,
	positionOrder integer,
	points float,
	laps integer,
	time VARCHAR,
	milliseconds integer,
	fastestLap float,
	rank integer,
	fastestLapTime VARCHAR,
	fastestLapSpeed VARCHAR,
	statusId integer
);
COPY results
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\results.csv'
DELIMITER ','
CSV HEADER;

UPDATE results
SET position = 0
WHERE position IS NULL;


DROP TABLE IF EXISTS constructor_results;
CREATE TABLE constructor_results (
    constructorResultsId serial,
	raceId integer,
	constructorId integer,
	points float,
	status VARCHAR
);
COPY constructor_results
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\constructor_results.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS constructor_standings;
CREATE TABLE constructor_standings (
    constructorStandingsId serial,
	raceId integer,
	constructorId integer,
	points float,
	position integer,
	positionText VARCHAR,
	wins integer
);
COPY constructor_standings
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\constructor_standings.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS driver_standings;
CREATE TABLE driver_standings (
    driverStandingsId serial,
	raceId integer,
	driverId integer,
	points float,
	position integer,
	positionText VARCHAR,
	wins integer
);
COPY driver_standings
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\driver_standings.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS lap_times;
CREATE TABLE lap_times (
    raceId serial,
	driverId integer,
	lap integer,
	position integer,
	time VARCHAR,
	milliseconds integer
);
COPY lap_times
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\lap_times.csv'
DELIMITER ','
CSV HEADER;


DROP TABLE IF EXISTS pit_stops;
CREATE TABLE pit_stops (
    raceId integer,
	driverId integer,
	stop integer,
	lap integer,
	time VARCHAR,
	duration VARCHAR,
	milliseconds integer
);
COPY pit_stops
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\pit_stops.csv'
DELIMITER ','
CSV HEADER;

DROP TABLE IF EXISTS qualifying;
CREATE TABLE qualifying (
    qualifyId serial,
	raceId integer,
	driverId integer,
	constructorId integer,
	number integer,
	position integer,
	q1 VARCHAR,
	q2 VARCHAR,
	q3 VARCHAR
);
COPY qualifying
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\qualifying.csv'
DELIMITER ','
CSV HEADER;


DROP VIEW IF EXISTS resultsview;

CREATE OR REPLACE VIEW resultsview
 AS
 SELECT row_number() OVER () AS id,
 	res."position",
    race.date,
    race.name AS race,
    circ.name AS circuit,
    circ.country,
    cons.name AS constructor,
    res.points,
    driv.forename,
    driv.surname
   FROM results res,
    drivers driv,
    circuits circ,
    races race,
    constructors cons
  WHERE res.raceid = race.raceid AND res.driverid = driv.driverid AND res.constructorid = cons.constructorid AND race.circuitid = circ.circuitid
  ORDER BY race.date DESC, res."position";

ALTER TABLE resultsview
    OWNER TO postgres;

GRANT ALL ON TABLE public.resultsview TO f1_user;
GRANT ALL ON TABLE public.resultsview TO postgres;

DROP TABLE IF EXISTS sprint_results;
CREATE TABLE sprint_results (
    resultId serial,
	raceId integer,
	driverId integer,
	constructorId integer,
	number integer,
	grid integer,
	position integer,
	positionText VARCHAR,
	positionOrder integer,
	points integer,
	laps integer,
	time VARCHAR,
	milliseconds integer,
	fastestLap integer,
	fastestLapTime VARCHAR,
	statusId integer
);
COPY sprint_results
FROM 'C:\Users\angel\Desktop\ApexSpringMockito\ApexSpringMockito\datasets\sprint_results.csv'
DELIMITER ','
CSV HEADER;
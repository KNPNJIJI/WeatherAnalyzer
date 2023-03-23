CREATE SCHEMA if not exists weather;

create table if not exists weather.weather_inf (
	id bigint not null primary key,
	condition_text varchar(255),
	humidity int,
	location_name varchar(255),
	pressure_mb double,
	temp_c double,
	text_error varchar(255),
	wind_mph double,
	lastupdated datetime(6)
);
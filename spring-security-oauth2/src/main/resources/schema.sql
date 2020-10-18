create table users(
	ID bigint not null primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	enabled boolean not null,
	roles varchar(50) not null,
);

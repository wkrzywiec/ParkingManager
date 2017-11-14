
create table users (
    USER_ID int not null auto_increment,
    USER_LOGIN varchar(100) not null UNIQUE,
    USER_PASSWORD varchar(100) not null,
    USER_TYPE int default 3,
    primary key (USER_ID)
);

create table drivers (
	DRIVER_ID int not null auto_increment,
	USER_ID int,
	DRIVER_NAME varchar(100),
	DRIVER_TYPE int default 1,
    VEHICLE_BRAND varchar(100),
    VEHICLE_MODEL varchar(100),
    VEHICLE_REG varchar(15),
    primary key (DRIVER_ID),
    foreign key (USER_ID) references users(USER_ID)
);


insert into users
	(user_login, user_password, user_type)
values
	('owner', 'Owner123', 1),
	('operator', 'Operator123', 2),
	('adam', 'Adam123', 3),
	('bartek', 'Bartek123', 3),
	('cezary', 'Cezary123', 3)
;

insert into drivers
	(user_id, driver_name, driver_type, vehicle_brand, vehicle_model, vehicle_reg)
values
	(3, 'Adam', 1, 'Toyota', 'Yaris', 'LRY6781'),
	(4, 'Bartek', 2, 'BMW', '330e', 'PJA9567'),
	(5, 'Cezary', 1, 'Fiat', '126', 'WI3458R')
;

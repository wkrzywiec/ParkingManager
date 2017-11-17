
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

CREATE TABLE car_logs (
	VISIT_ID int not null auto_increment,
	DRIVER_ID int not null,
	DATE_START datetime,
	DATE_STOP datetime,
	primary key (VISIT_ID)

);

CREATE TABLE payments (
	PAYMENT_ID int not null auto_increment,
	DRIVER_ID INT NOT NULL,
	VISIT_ID int not null,
	PAYMENT_AMOUNT INT NOT NULL,
	PAYMENT_CURRENCY VARCHAR(3),
	primary key(PAYMENT_ID)
);

SET SQL_SAFE_UPDATES = 0;

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

INSERT INTO 
	CAR_LOGS(DRIVER_ID, DATE_START, DATE_STOP)  
VALUES 
	(1, timestamp('2017-11-01 09:20:13'), timestamp('2017-11-02 07:23:13')),
	(2, timestamp('2017-11-10 19:20:13'), timestamp('2017-11-10 21:45:43')),
	(2, timestamp('2017-11-11 04:20:13'), timestamp('2017-11-11 07:55:00')),
	(3, timestamp('2017-11-08 13:26:33'), timestamp('2017-11-09 07:23:13')),
	(1, timestamp('2017-11-05 12:12:13'), timestamp('2017-11-06 17:23:13')),
	(2, timestamp('2017-11-14 09:20:13'), timestamp('2017-11-14 22:23:13')),
	(3, timestamp('2017-11-09 09:20:13'), timestamp('2017-11-13 07:23:13')),
	(3, timestamp('2017-11-14 10:25:13'), null),
	(1, timestamp('2017-11-14 09:20:13'), null)
;

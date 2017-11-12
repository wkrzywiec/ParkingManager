
create table users (
    ID int not null auto_increment,
    USER_LOGIN varchar(100) not null,
    USER_PASSWORD varchar(100) not null,
    USER_TYPE int default 3,
    primary key (ID)
);

insert into users
	(user_login, user_password, user_type)
values
	('owner', 'Owner123', 1),
	('operator', 'Operator123', 2),
	('adam', 'Adam123', 3)
;
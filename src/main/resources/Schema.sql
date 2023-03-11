create table IF NOT EXISTS item (
  id IDENTITY,
  name varchar(50) not null,
  brand varchar(50) not null,
  prucdedDate int  not null,
  price double not null
);
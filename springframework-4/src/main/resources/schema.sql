CREATE TABLE IF NOT EXISTS USER (
  id varchar2(10) primary key,
  password varchar2(200) not null,
  name varchar2(10) not null,
  phone varchar2(14),
  email varchar2(30)
)
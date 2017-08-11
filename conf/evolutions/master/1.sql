# --- !Ups

CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  first_name varchar(255),
  full_name varchar(255),
  state BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME,
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE users;
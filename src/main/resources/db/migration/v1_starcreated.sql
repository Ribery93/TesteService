
CREATE TABLE client (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(150) NOT NULL,
  email varchar(150) NOT NULL,
  birthday TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE product (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(150) NOT NULL,
  description varchar(250) NOT NULL,
  price DECIMAL(10,10) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE sale (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  id_client varchar(100) NOT NULL,
  id_product varchar(50) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_client) REFERENCES client (id),
  FOREIGN KEY (id_product) REFERENCES client (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
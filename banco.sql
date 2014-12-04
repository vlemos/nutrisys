-- Table: grupo

-- DROP TABLE grupo;

CREATE TABLE grupo
(
  idgrupo serial NOT NULL,
  nome character varying(15) NOT NULL,
  CONSTRAINT pk_idgrupo PRIMARY KEY (idgrupo)
)
WITH (
  OIDS=TRUE
);
ALTER TABLE grupo
  OWNER TO postgres;


-- Table: usuario

-- DROP TABLE usuario;

CREATE TABLE usuario
(
  idusuario serial NOT NULL,
  login character varying(15) NOT NULL,
  senha bytea NOT NULL,
  situacao character varying(10) NOT NULL,
  idgrupo integer,
  CONSTRAINT pk_usuario PRIMARY KEY (idusuario),
  CONSTRAINT fk_idgrupo FOREIGN KEY (idgrupo)
      REFERENCES grupo (idgrupo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_login UNIQUE (login)
)
WITH (
  OIDS=TRUE
);
ALTER TABLE usuario
  OWNER TO postgres;




INSERT INTO grupo(
             nome)
    VALUES ('admin');


INSERT INTO usuario(
            login, senha, situacao, idgrupo)
    VALUES ('admin','admin','ATIVO', 1);

-- Table: grupo

-- DROP TABLE grupo;

CREATE TABLE grupo
(
  idgrupo serial NOT NULL,
  nome character varying(15) NOT NULL,
  CONSTRAINT pk_idgrupo PRIMARY KEY (idgrupo),
  CONSTRAINT uk_nome UNIQUE (nome)
)
WITH (
  OIDS=TRUE
);
ALTER TABLE grupo
  OWNER TO postgres;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: usuario

-- DROP TABLE usuario;

CREATE TABLE usuario
(
  idusuario serial NOT NULL,
  login character varying(15) NOT NULL,
  senha bytea NOT NULL,
  situacao character varying(10) NOT NULL,
  idgrupo integer,
  trocasenha character varying(1) NOT NULL,
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
  
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: rota

-- DROP TABLE rota;

CREATE TABLE rota
(
  idrota serial NOT NULL,
  descricao character varying(20) NOT NULL,
  CONSTRAINT pk_idrota PRIMARY KEY (idrota),
  CONSTRAINT uk_descricao UNIQUE (descricao)
)
WITH (
  OIDS=TRUE
);
ALTER TABLE rota
  OWNER TO postgres;


-----------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: cliente

-- DROP TABLE cliente;

CREATE TABLE cliente
(
  idcliente serial NOT NULL,
  nome character varying(50) NOT NULL,
  nomefantasia character varying(25) NOT NULL,
  tipocliente character varying(1) NOT NULL,
  cnpjcpf character varying(14) NOT NULL,
  cep character varying(8) NOT NULL,
  endereco character varying(40) NOT NULL,
  numeroendereco character varying(5) NOT NULL,
  complemento character varying(20),
  bairro character varying(30) NOT NULL,
  estado character(2) NOT NULL,
  telefone1 character varying(15),
  telefone2 character varying(15),
  email character varying(50),
  situacao character varying(10) NOT NULL,
  idrota integer,
  CONSTRAINT pk_cliente PRIMARY KEY (idcliente),
  CONSTRAINT fk_idrota FOREIGN KEY (idrota)
      REFERENCES rota (idrota) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_cnpjcpf UNIQUE (cnpjcpf)
)
WITH (
  OIDS=TRUE
);
ALTER TABLE cliente
  OWNER TO postgres;


-----------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: localentrega

-- DROP TABLE localentrega;

CREATE TABLE localentrega
(
  idlocalentrega serial NOT NULL,
  nome character varying(50) NOT NULL,
  cnpjcpf character varying(14) NOT NULL,
  cep character varying(8) NOT NULL,
  endereco character varying(40) NOT NULL,
  numeroendereco character varying(5) NOT NULL,
  complemento character varying(20),
  bairro character varying(30) NOT NULL,
  estado character(2) NOT NULL,
  telefone1 character varying(15),
  telefone2 character varying(15),
  email character varying(50),
  situacao character varying(10) NOT NULL,
  idcliente integer,
  CONSTRAINT pk_idlocalentrega PRIMARY KEY (idlocalentrega),
  CONSTRAINT fk_idcliente FOREIGN KEY (idcliente)
      REFERENCES cliente (idcliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=TRUE
);
ALTER TABLE localentrega
  OWNER TO postgres;


-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO grupo(
             nome)
    VALUES ('admin');


INSERT INTO usuario(
            login, senha, situacao, idgrupo,trocasenha)
    VALUES ('admin','admin','ATIVO', 1,'N');


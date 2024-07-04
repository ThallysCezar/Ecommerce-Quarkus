CREATE TABLE IF NOT EXISTS produto (
	id bigint NOT NULL,
	available bool NOT NULL,
	estoque int4 NOT NULL,
	preco float8 NOT NULL,
	autor varchar(255) NULL,
	categoria varchar(255) NULL,
	descricao varchar(255) NULL,
	editora varchar(255) NULL,
	tipoproduto varchar(255) NULL,
	titulo varchar(255) NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (id)
);
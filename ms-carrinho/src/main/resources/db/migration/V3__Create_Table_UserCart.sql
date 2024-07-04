CREATE TABLE IF NOT EXISTS public.usercart (
	id bigserial NOT NULL,
	isactive bool NULL,
	email varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT usercart_pkey PRIMARY KEY (id)
);
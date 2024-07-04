CREATE TABLE IF NOT EXISTS public.checkout (
	id bigserial NOT NULL,
	total float8 NULL,
	userid int8 NULL,
	formapagamento varchar(255) NULL,
	status varchar(255) NULL,
	CONSTRAINT checkout_pkey PRIMARY KEY (id)
);
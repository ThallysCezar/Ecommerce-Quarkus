CREATE TABLE IF NOT EXISTS public.cartitem (
	id bigserial NOT NULL,
	quantity int4 NOT NULL,
	usercart_id int8 NOT NULL,
	CONSTRAINT cartitem_pkey PRIMARY KEY (id)
);

-- public.cartitem foreign keys
ALTER TABLE public.cartitem ADD CONSTRAINT fkfghs696f51di8xowctt8qdou0 FOREIGN KEY (usercart_id) REFERENCES public.usercart(id);
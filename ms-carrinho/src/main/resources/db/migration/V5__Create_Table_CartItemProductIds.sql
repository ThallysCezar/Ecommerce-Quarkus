CREATE TABLE public.cart_item_product_ids (
	cartitem_id int8 NOT NULL,
	product_id int8 NULL
);

-- public.cart_item_product_ids foreign keys
ALTER TABLE public.cart_item_product_ids ADD CONSTRAINT fk4tmr6qtaeib8dcouhoysgk7li FOREIGN KEY (cartitem_id) REFERENCES public.cartitem(id);
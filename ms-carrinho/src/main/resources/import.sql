-- Cria a sequência para IDs de itens do carrinho
CREATE SEQUENCE IF NOT EXISTS cart_item_sequence START 1;

-- Insere itens no carrinho
INSERT INTO cartitem (id, productid, quantity) VALUES (nextval('cart_item_sequence'), 1, 2);
INSERT INTO cartitem (id, productid, quantity) VALUES (nextval('cart_item_sequence'), 2, 1);
INSERT INTO cartitem (id, productid, quantity) VALUES (nextval('cart_item_sequence'), 3, 3);
INSERT INTO cartitem (id, productid, quantity) VALUES (nextval('cart_item_sequence'), 4, 1);
INSERT INTO cartitem (id, productid, quantity) VALUES (nextval('cart_item_sequence'), 5, 2);
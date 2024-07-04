-- Cria a sequência para IDs de itens do carrinho
CREATE SEQUENCE IF NOT EXISTS cart_item_sequence START 1;

-- Tabela cartitem
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 1, 5);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 2, 3);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 3, 6);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 4, 5);
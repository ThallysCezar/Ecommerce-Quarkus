-- Cria a sequência para IDs de itens do carrinho
CREATE SEQUENCE IF NOT EXISTS cart_item_sequence START 1;

-- Cria a sequência para IDs de usuários
CREATE SEQUENCE IF NOT EXISTS user_cart_sequence START 1;

-- Usuários
INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario1', 'usuario1@email.com', true);
INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario2', 'usuario2@email.com', true);
INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario3', 'usuario3@email.com', true);
INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario4', 'usuario4@email.com', true);

-- Tabela cartitem
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 45, 5);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 46, 3);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 47, 6);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 48, 5);

-- Tabela cart_item_product_ids
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (66, 30);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (66, 31);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (66, 32);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (67, 32);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (67, 33);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (68, 34);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (68, 35);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (68, 36);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (69, 32);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (69, 37);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (69, 42);
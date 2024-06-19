-- Cria a sequência para IDs de itens do carrinho
CREATE SEQUENCE IF NOT EXISTS cart_item_sequence START 1;

-- Cria a sequência para IDs de usuários
CREATE SEQUENCE IF NOT EXISTS user_cart_sequence START 1;

-- Usuários
INSERT INTO usercart (id, username, email) VALUES (nextval('user_cart_sequence'), 'usuario1', 'usuario1@email.com');
INSERT INTO usercart (id, username, email) VALUES (nextval('user_cart_sequence'), 'usuario2', 'usuario2@email.com');
INSERT INTO usercart (id, username, email) VALUES (nextval('user_cart_sequence'), 'usuario3', 'usuario3@email.com');
INSERT INTO usercart (id, username, email) VALUES (nextval('user_cart_sequence'), 'usuario4', 'usuario4@email.com');

-- Tabela cartitem
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 29, 5);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 30, 3);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 31, 6);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 32, 5);

-- Tabela cart_item_product_ids
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (50, 30);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (50, 31);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (50, 32);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (51, 32);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (51, 33);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (52, 34);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (52, 35);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (52, 36);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (53, 32);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (53, 37);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (53, 42);
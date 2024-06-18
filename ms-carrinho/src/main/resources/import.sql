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
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 25, 5);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 26, 3);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 27, 6);
INSERT INTO cartitem (id, usercart_id, quantity) VALUES (nextval('cart_item_sequence'), 28, 5);

-- Tabela cart_item_product_ids
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (46, 15);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (46, 16);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (46, 17);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (47, 17);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (47, 18);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (48, 19);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (48, 20);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (48, 21);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (49, 17);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (49, 22);
INSERT INTO cart_item_product_ids (cartitem_id, product_id) VALUES (49, 27);
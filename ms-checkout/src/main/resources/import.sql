-- Cria a sequência para IDs de pedidos
CREATE SEQUENCE IF NOT EXISTS order_sequence START 1;

-- Insere dados de pedidos
INSERT INTO checkout (id, userid, total, status) VALUES (nextval('order_sequence'), 29, 109.70, '');
INSERT INTO checkout (id, userid, total, status) VALUES (nextval('order_sequence'), 30, 69.80, '');
INSERT INTO checkout (id, userid, total, status) VALUES (nextval('order_sequence'), 31, 114.70, '');
INSERT INTO checkout (id, userid, total, status) VALUES (nextval('order_sequence'), 32, 114.70, '');

--46	15(preco: 39,9), 16(preco: 19,9), 17(preco: 49,9)
--47	17(preco: 49,9), 18(preco: 19,9)
--48	19(preco: 29,9), 20(preco: 24,9), 21(preco: 59,9)
--49	17(preco: 49,9), 22(preco: 19,9), 27(preco: 44,9)
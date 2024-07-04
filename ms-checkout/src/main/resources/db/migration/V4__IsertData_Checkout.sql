-- Cria a sequência para IDs de pedidos
CREATE SEQUENCE IF NOT EXISTS order_sequence START 1;

-- Insere dados de pedidos
INSERT INTO checkout (id, userid, total, status, formapagamento) VALUES (nextval('order_sequence'), 1, 109.70, '', '');
INSERT INTO checkout (id, userid, total, status, formapagamento) VALUES (nextval('order_sequence'), 2, 69.80, '', 'CREDITO');
INSERT INTO checkout (id, userid, total, status, formapagamento) VALUES (nextval('order_sequence'), 3, 114.70, '', '');
INSERT INTO checkout (id, userid, total, status, formapagamento) VALUES (nextval('order_sequence'), 4, 114.70, '', '');
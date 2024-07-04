-- Cria a sequência para IDs de usuários
CREATE SEQUENCE IF NOT EXISTS user_cart_sequence START 1;

INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario1', 'usuario1@email.com', true);
INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario2', 'usuario2@email.com', true);
INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario3', 'usuario3@email.com', true);
INSERT INTO usercart (id, username, email, isactive) VALUES (nextval('user_cart_sequence'), 'usuario4', 'usuario4@email.com', true);
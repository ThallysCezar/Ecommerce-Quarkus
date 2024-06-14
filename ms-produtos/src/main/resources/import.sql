CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1;

-- Insere dados na tabela 'produtos'
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Harry Potter e o Cálice de Fogo', 'Livro', 'J.K. Rowling', 'Descrição do livro Harry Potter e o Cálice de Fogo', 39.90, 100, 'Editora Rocco', 'Fantasia');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Naruto Vol. 1', 'Manga', 'Masashi Kishimoto', 'Descrição do mangá Naruto Vol. 1', 19.90, 200, 'Editora Panini', 'Ação');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'O Senhor dos Anéis: A Sociedade do Anel', 'Livro', 'J.R.R. Tolkien', 'Descrição do livro O Senhor dos Anéis: A Sociedade do Anel', 49.90, 150, 'Editora Martins Fontes', 'Fantasia');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'One Piece Vol. 1', 'Manga', 'Eiichiro Oda', 'Descrição do mangá One Piece Vol. 1', 19.90, 180, 'Editora Panini', 'Aventura');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'O Hobbit', 'Livro', 'J.R.R. Tolkien', 'Descrição do livro O Hobbit', 29.90, 120, 'Editora Martins Fontes', 'Fantasia');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Attack on Titan Vol. 1', 'Manga', 'Hajime Isayama', 'Descrição do mangá Attack on Titan Vol. 1', 24.90, 210, 'Editora Panini', 'Ação');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Game of Thrones', 'Livro', 'George R. R. Martin', 'Descrição do livro A Guerra dos Tronos', 59.90, 130, 'Editora Leya', 'Fantasia');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Bleach Vol. 1', 'Manga', 'Tite Kubo', 'Descrição do mangá Bleach Vol. 1', 19.90, 220, 'Editora Panini', 'Ação');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Percy Jackson e o Ladrão de Raios', 'Livro', 'Rick Riordan', 'Descrição do livro Percy Jackson e o Ladrão de Raios', 34.90, 140, 'Editora Intrínseca', 'Aventura');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Dragon Ball Vol. 1', 'Manga', 'Akira Toriyama', 'Descrição do mangá Dragon Ball Vol. 1', 19.90, 190, 'Editora Panini', 'Ação');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'O Nome do Vento', 'Livro', 'Patrick Rothfuss', 'Descrição do livro O Nome do Vento', 49.90, 160, 'Editora Arqueiro', 'Fantasia');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Death Note Vol. 1', 'Manga', 'Tsugumi Ohba', 'Descrição do mangá Death Note Vol. 1', 19.90, 200, 'Editora JBC', 'Suspense');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'A Batalha do Apocalipse', 'Livro', 'Eduardo Spohr', 'Descrição do livro A Batalha do Apocalipse', 44.90, 110, 'Editora Verus', 'Fantasia');
INSERT INTO produto(id, titulo, tipoProduto, autor, descricao, preco, estoque, editora, categoria) VALUES (nextval('hibernate_sequence'), 'Fairy Tail Vol. 1', 'Manga', 'Hiro Mashima', 'Descrição do mangá Fairy Tail Vol. 1', 19.90, 230, 'Editora JBC', 'Aventura');
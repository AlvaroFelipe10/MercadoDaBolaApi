#Clubes
insert into clube (id, nome, caixa) values (1, 'Flamengo', 9000000);
insert into clube (id, nome, caixa) values (2, 'São Paulo', 7000000);
insert into clube (id, nome, caixa) values (3, 'Palmeiras', 8000000);
insert into clube (id, nome, caixa) values (4, 'Corinthians', 5000000);
insert into clube (id, nome, caixa) values (5, 'Fluminense', 4000000);

#Flamengo
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (1, '1996.06.30', 'Gabriel Barbosa', 'ATA', 1); 
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (2, '1994.06.01', 'Giorgian Arrascaeta', 'MEI', 1); 
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (3, '1987.04.22', 'David Luiz', 'ZAG', 1);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (4, '1990.03.17', 'Adebar Santos', 'GK', 1);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (5, '1985.08.09', 'Filipe Luís', 'LE', 1);

#São Paulo
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (6, '1993.09.23', 'Jonathan Calleri', 'ATA', 2);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (7, '1992.06.18', 'Wellington Rato', 'MEI', 2);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (8, '1998.05.11', 'Caio Paulista', 'LE', 2);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (9, '1991.08.22', 'Robert Arboleda', 'ZAG', 2);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (10, '1988.05.21', 'Felipe Alves', 'GK', 2);

#Palmeiras
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (11, '2006.07.21', 'Endrick Felipe', 'ATA', 3);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (12, '1995.06.19', 'Raphael Veiga', 'MEI', 3);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (13, '1998.08.24', 'Joaquim Piquerez', 'LE', 3);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (14, '1993.05.06', 'Gustavo Gómez', 'ZAG', 3);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (15, '1987.12.13', 'Weverton Pereira', 'GK', 3);


#Corinthians
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (16, '2001.03.18', 'Yuri Alberto', 'ATA', 4);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (17, '1996.08.02', 'Roger Guedes', 'ATA', 4);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (18, '1989.06.11', 'Fagner Conserva', 'LD', 4);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (19, '1993.05.06', 'Carlos Gilberto', 'ZAG', 4);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (20, '1987.06.06', 'Cássio Ramos', 'GK', 4);
#Fluminense 
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (21, '1989.09.10', 'Matheus KENO',  'ATA', 5);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (22, '1989.08.12', 'Paulo Henrique GANSO', 'MEI', 5);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (23, '1988.05.12', 'Marcelo Vieira', 'LE', 5);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (24, '1997.04.10', 'Marcilio NINO', 'ZAG', 5);
insert into jogador (id, data_nascimento, nome, posicao, clube_id) values (25, '2000.06.29', 'Pedro Rangel', 'GK', 5);
#Contrato
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (1, '21.01.2022', '21.01.2024', 15000, 30000, 1, 1);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (2, '24.02.2022', '21.05.2025', 9000, 25000, 3, 2);

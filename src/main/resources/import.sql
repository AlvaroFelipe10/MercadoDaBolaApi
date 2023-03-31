#Clubes
insert into clube (id, nome, caixa) values (1, 'Flamengo', 9000000);
insert into clube (id, nome, caixa) values (2, 'São Paulo', 7000000);
insert into clube (id, nome, caixa) values (3, 'Palmeiras', 8000000);
insert into clube (id, nome, caixa) values (4, 'Corinthians', 5000000);
insert into clube (id, nome, caixa) values (5, 'Fluminense', 4000000);

#Flamengo
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (1, '30.08.1996', 'Gabriel Barbosa', 20, 'ATA', 1); 
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (2, '01.06.1994', 'Giorgian Arrascaeta', 25, 'MEI', 1); 
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (3, '22.04.1987', 'David Luiz', 27, 'ZAG', 1);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (4, '17.03.1990', 'Adebar Santos', 29, 'GK', 1);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (5, '09.08.1985', 'Filipe Luís', 30, 'LE', 1);

#São Paulo
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (6, '23.09.1993', 'Jonathan Calleri', 20, 'ATA', 2);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (7, '18.06.1992', 'Wellington Rato', 25, 'MEI', 2);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (8, '11.05.1998', 'Caio Paulista', 28, 'LE', 2);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (9, '22.08.1991', 'Robert Arboleda', 26, 'ZAG', 2);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (10, '21.05.1988', 'Felipe Alves', 18,'GK', 2);

#Palmeiras
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (11, '21.07.2006', 'Endrick Felipe', 20, 'ATA', 3);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (12, '19.06.1995', 'Raphael Veiga', 26, 'MEI', 3);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (13, '24.08.1998', 'Joaquim Piquerez', 24, 'LE', 3);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (14, '06.05.1993', 'Gustavo Gómez', 22, 'ZAG', 3);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (15, '13.12.1987', 'Weverton Pereira', 29, 'GK', 3);

#Corinthians
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (16, '18.03.2001', 'Yuri Alberto', 20, 'ATA', 4);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (17, '02.08.1996', 'Roger Guedes', 26, 'ATA', 4);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (18, '11.06.1989', 'Fagner Conserva', 28, 'LD', 4);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (19, '06.05.1993', 'Carlos Gilberto', 20, 'ZAG', 4);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (20, '06.06.1987', 'Cássio Ramos', 30, 'GK', 4);

#Fluminense 
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (21, '10.09.1989', 'Matheus KENO', 20, 'ATA', 5);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (22, '12.08.1989', 'Paulo Henrique GANSO', 28, 'MEI', 5);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (23, '12.05.1988', 'Marcelo Vieira', 29, 'LE', 5);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (24, '10.04.1997', 'Marcilio NINO', 21, 'ZAG', 5);
insert into jogador (id, data_nascimento, nome, idade, posicao, clube_id) values (25, '29.06.2000', 'Pedro Rangel', 20, 'GK', 5);

#Contrato
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (1, '21.01.2022', '21.01.2024', 15000, 30000, 1, 1);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (2, '24.02.2022', '21.05.2025', 9000, 25000, 3, 2);
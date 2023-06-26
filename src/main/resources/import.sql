#CLUBES
insert into clube (id, nome, caixa) values (1, 'Flamengo', 9000000);
insert into clube (id, nome, caixa) values (2, 'São Paulo', 7000000);
insert into clube (id, nome, caixa) values (3, 'Palmeiras', 8000000);
insert into clube (id, nome, caixa) values (4, 'Corinthians', 5000000);


#JOGADOR FLAMENGO
insert into jogador (id, data_nascimento, nome, posicao) values (1, '1996.06.30', 'Gabriel Barbosa', 'ATA'); 
insert into jogador (id, data_nascimento, nome, posicao) values (2, '1994.06.01', 'Giorgian Arrascaeta', 'MEI'); 
insert into jogador (id, data_nascimento, nome, posicao) values (3, '1987.04.22', 'David Luiz', 'ZAG');
insert into jogador (id, data_nascimento, nome, posicao) values (4, '1990.03.17', 'Adebar Santos', 'GK');
insert into jogador (id, data_nascimento, nome, posicao) values (5, '1985.08.09', 'Filipe Luís', 'LE');

#JOGADOR SÃO PAULO
insert into jogador (id, data_nascimento, nome, posicao) values (6, '1993.09.23', 'Jonathan Calleri', 'ATA');
insert into jogador (id, data_nascimento, nome, posicao) values (7, '1992.06.18', 'Wellington Rato', 'MEI');
insert into jogador (id, data_nascimento, nome, posicao) values (8, '1998.05.11', 'Caio Paulista', 'LE');
insert into jogador (id, data_nascimento, nome, posicao) values (9, '1991.08.22', 'Robert Arboleda', 'ZAG');
insert into jogador (id, data_nascimento, nome, posicao) values (10, '1988.05.21', 'Felipe Alves', 'GK');


#JOGADOR PALMEIRAS
insert into jogador (id, data_nascimento, nome, posicao) values (11, '2006.07.21', 'Endrick Felipe', 'ATA');
insert into jogador (id, data_nascimento, nome, posicao) values (12, '1995.06.19', 'Raphael Veiga', 'MEI');
insert into jogador (id, data_nascimento, nome, posicao) values (13, '1998.08.24', 'Joaquim Piquerez', 'LE');
insert into jogador (id, data_nascimento, nome, posicao) values (14, '1993.05.06', 'Gustavo Gómez', 'ZAG');
insert into jogador (id, data_nascimento, nome, posicao) values (15, '1987.12.13', 'Weverton Pereira', 'GK');

#JOGADOR CORINTHIANS
insert into jogador (id, data_nascimento, nome, posicao) values (16, '2001.03.18', 'Yuri Alberto', 'ATA');
insert into jogador (id, data_nascimento, nome, posicao) values (17, '1996.08.02', 'Roger Guedes', 'ATA');
insert into jogador (id, data_nascimento, nome, posicao) values (18, '1989.06.11', 'Fagner Conserva', 'LD');
insert into jogador (id, data_nascimento, nome, posicao) values (19, '1993.05.06', 'Carlos Gilberto', 'ZAG');
insert into jogador (id, data_nascimento, nome, posicao) values (20, '1987.06.06', 'Cássio Ramos', 'GK');

#CONTRATO FLAMENGO
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (1, '2022.01.21', '2023.02.21', 15000, 30000, 1, 1);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (2, '2022.01.22', '2024.01.22', 17000, 35000, 1, 2);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (3, '2022.01.23', '2024.01.23', 10000, 25000, 1, 3);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (4, '2022.01.24', '2024.01.24', 11000, 22000, 1, 4);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (5, '2022.01.25', '2024.01.25', 14000, 29000, 1, 5);

#CONTRATO SÃO PAULO 
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (6, '2022.01.21', '2024.01.21', 15000, 30000, 2, 6);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (7, '2022.01.22', '2024.01.22', 17000, 35000, 2, 7);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (8, '2022.01.23', '2024.01.23', 10000, 25000, 2, 8);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (9, '2022.01.24', '2024.01.24', 11000, 22000, 2, 9);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (10, '2022.01.25', '2024.01.25', 14000, 29000, 2, 10);

#CONTRATO PALMEIRAS
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (11, '2022.01.21', '2024.01.21', 15000, 30000, 3, 11);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (12, '2022.01.22', '2024.01.22', 17000, 35000, 3, 12);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (13, '2022.01.23', '2024.01.23', 10000, 25000, 3, 13);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (14, '2022.01.24', '2024.01.24', 11000, 22000, 3, 14);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (15, '2022.01.25', '2024.01.25', 14000, 29000, 3, 15);

#CONTRATO CORINTHIANS
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (16, '2022.01.21', '2024.01.21', 15000, 30000, 4, 16);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (17, '2022.01.22', '2024.01.22', 17000, 35000, 4, 17);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (18, '2022.01.23', '2024.01.23', 10000, 25000, 4, 18);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (19, '2022.01.24', '2024.01.24', 11000, 22000, 4, 19);
insert into contrato (id, data_inicio, data_termino, salario, valor_multa, clube_id, jogador_id) values (20, '2022.01.25', '2024.01.25', 14000, 29000, 4, 20);

#ESTADIOS

insert into estadio (estadio_id, capacidade_maxima, nome, clube_id) values (1, 78838, 'Maracanã', 1)
insert into estadio (estadio_id, capacidade_maxima, nome, clube_id) values (2, 66795, 'Morumbi', 2)
insert into estadio (estadio_id, capacidade_maxima, nome, clube_id) values (3, 43713, 'Allianz Parque', 3)
insert into estadio (estadio_id, capacidade_maxima, nome, clube_id) values (4, 49205, 'Neo Quimica Arena', 4)

#CAMPEONATO
insert into campeonato (id, nome_campeonato, quantidade_clubes, tipo_de_campeonato) values (1, "Brasileirao", 4, "PONTOS_CORRIDOS_IDA_VOLTA");
insert into campeonato (id, nome_campeonato, quantidade_clubes, tipo_de_campeonato) values (2, "Paulistao", 4, "MATA_MATA_IDA_VOLTA");

#ClubeCampeonato
insert into clube_campeonato(pontos, rodadas_restantes, campeonato_id, clube_id) values (0, 6, 1, 1);
insert into clube_campeonato(pontos, rodadas_restantes, campeonato_id, clube_id) values (0, 6, 1, 2);
insert into clube_campeonato(pontos, rodadas_restantes, campeonato_id, clube_id) values (0, 6, 1, 3);
insert into clube_campeonato(pontos, rodadas_restantes, campeonato_id, clube_id) values (0, 6, 1, 4);


#ATUALIZAÇÃO PARA INSERIR ID
update jogador set contrato_id = 1 where id = 1;
update jogador set contrato_id = 2 where id = 2;
update jogador set contrato_id = 3 where id = 3;
update jogador set contrato_id = 4 where id = 4;
update jogador set contrato_id = 5 where id = 5;
update jogador set contrato_id = 6 where id = 6;
update jogador set contrato_id = 7 where id = 7;
update jogador set contrato_id = 8 where id = 8;
update jogador set contrato_id = 9 where id = 9;
update jogador set contrato_id = 10 where id = 10;
update jogador set contrato_id = 11 where id = 11;
update jogador set contrato_id = 12 where id = 12;
update jogador set contrato_id = 13 where id = 13;
update jogador set contrato_id = 14 where id = 14;
update jogador set contrato_id = 15 where id = 15;
update jogador set contrato_id = 16 where id = 16;
update jogador set contrato_id = 17 where id = 17;
update jogador set contrato_id = 18 where id = 18;
update jogador set contrato_id = 19 where id = 19;
update jogador set contrato_id = 20 where id = 20;




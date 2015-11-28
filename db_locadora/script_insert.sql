INSERT INTO `db_locadora`.`estado`
(`siglaCod`,
`sigla`,
`nome`)
VALUES
('MG', 'MG', 'Minas Gerais');

INSERT INTO `db_locadora`.`categoria`
(`descricao`)
VALUES
('veiculo automotor');

INSERT INTO `db_locadora`.`cidade`
(`nome`,
`sigla`)
VALUES
('Pouso Alegre', 'MG');

INSERT INTO `db_locadora`.`cliente`
(`nome`,
`cpf`,
`dataNasc`,
`endereco`,
`bairro`,
`fone`,
`email`,
`codCidade`)
VALUES
('Josué Nascimento',
'9999999999',
'02/07/1982',
'Rua Paris, 23',
'Jardim Europa',
'2222-3333',
'josue@xyz.com',
2);

INSERT INTO `db_locadora`.`marca`
(`descricao`) VALUES ('Fiat');

INSERT INTO `db_locadora`.`modelo`
(`descricao`) VALUES ('Uno Fire');

INSERT INTO `db_locadora`.`veiculo`
(`placa`,
`descricao`,
`codModelo`,
`codCategoria`,
`codMarca`)
VALUES
('HFW9877',
'Automóvel popular 1.0',
1, 1,1);

INSERT INTO `db_locadora`.`veiculocliente`
(`codCliente`,`placa`)
VALUES (2, 'HFW9877');

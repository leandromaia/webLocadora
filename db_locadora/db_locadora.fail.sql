CREATE TABLE VeiculoCliente
(
	codVeiculoCliente INTEGER NOT NULL AUTO_INCREMENT,
	codCliente INTEGER NOT NULL,
	placa NVARCHAR(50) NOT NULL,
	PRIMARY KEY (codVeiculoCliente),
	KEY (codCliente),
	KEY (placa)
) 
;


CREATE TABLE Cliente
(
	codCliente INTEGER NOT NULL AUTO_INCREMENT,
	nome NVARCHAR(50) NOT NULL,
	cpf NVARCHAR(50) NOT NULL,
	dataNasc NVARCHAR(50),
	endereco NVARCHAR(50),
	bairro NVARCHAR(50),
	fone NVARCHAR(50),
	email NVARCHAR(50),
	codCidade INTEGER NOT NULL,
	PRIMARY KEY (codCliente),
	KEY (codCidade)
) 
;


CREATE TABLE Veiculo
(
	placa NVARCHAR(50) NOT NULL,
	descricao NVARCHAR(50) NOT NULL,
	codModelo INTEGER NOT NULL,
	codCategoria INTEGER NOT NULL,
	codMarca INTEGER NOT NULL,
	PRIMARY KEY (placa),
	KEY (codCategoria),
	KEY (codMarca),
	KEY (codModelo)
) 
;


CREATE TABLE Cidade
(
	codCidade INTEGER NOT NULL AUTO_INCREMENT,
	nome NVARCHAR(50) NOT NULL,
	sigla NVARCHAR(50) NOT NULL,
	PRIMARY KEY (codCidade),
	KEY (sigla)
) 
;

CREATE TABLE Modelo
(
	codModelo INTEGER NOT NULL AUTO_INCREMENT,
	descricao NVARCHAR(50) NOT NULL,
	PRIMARY KEY (codModelo)
) 
;


CREATE TABLE Marca
(
	codMarca INTEGER NOT NULL AUTO_INCREMENT,
	descricao NVARCHAR(50) NOT NULL,
	PRIMARY KEY (codMarca)
) 
;


CREATE TABLE Estado
(
	siglaCod NVARCHAR(50) NOT NULL,
	sigla NVARCHAR(50) NOT NULL,
	nome NVARCHAR(50) NOT NULL,
	PRIMARY KEY (siglaCod)
) 
;


CREATE TABLE Categoria
(
	codCategoria INTEGER NOT NULL AUTO_INCREMENT,
	descricao NVARCHAR(50) NOT NULL,
	PRIMARY KEY (codCategoria)
) 
;





ALTER TABLE VeiculoCliente ADD CONSTRAINT FK_VeiculoCliente_Cliente 
	FOREIGN KEY (codCliente) REFERENCES Cliente (codCliente)
;

ALTER TABLE VeiculoCliente ADD CONSTRAINT FK_VeiculoCliente_Veiculo 
	FOREIGN KEY (placa) REFERENCES Veiculo (placa)
;

ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_Cidade 
	FOREIGN KEY (codCidade) REFERENCES Cidade (codCidade)
;

ALTER TABLE Veiculo ADD CONSTRAINT FK_Veiculo_Categoria 
	FOREIGN KEY (codCategoria) REFERENCES Categoria (codCategoria)
;

ALTER TABLE Veiculo ADD CONSTRAINT FK_Veiculo_Marca 
	FOREIGN KEY (codMarca) REFERENCES Marca (codMarca)
;

ALTER TABLE Veiculo ADD CONSTRAINT FK_Veiculo_Modelo 
	FOREIGN KEY (codModelo) REFERENCES Modelo (codModelo)
;

ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_Estado 
	FOREIGN KEY (sigla) REFERENCES Estado (siglaCod)
;

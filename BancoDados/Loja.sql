DROP DATABASE IF EXISTS POO;
CREATE DATABASE POO;
USE POO;

/* Lógico_1: */

CREATE TABLE Usuario (
    Id_Usuario INT PRIMARY KEY auto_increment,
    Nome VARCHAR(100),
    Email VARCHAR(100),
    Sexo VARCHAR(10),
    Senha VARCHAR(100)
);

CREATE TABLE Produto (
    Id_Produto INT PRIMARY KEY auto_increment,
    Nome VARCHAR(20),
    Descricao VARCHAR(200),
	Validade VARCHAR(30),
    Valor FLOAT
);

CREATE TABLE Carrinho_Compras (
    Id_Carrinho INT PRIMARY KEY auto_increment,
    fk_Usuario_Id_Usuario INT
);

CREATE TABLE Item_Pedido (
    Id_Pedido INT PRIMARY KEY auto_increment,
    Quantidade INT,
    fk_Carrinho_Compras_Id_Carrinho INT,
    fk_Produto_Id_Produto INT
);
 
ALTER TABLE Carrinho_Compras ADD CONSTRAINT FK_Carrinho_Compras_2
    FOREIGN KEY (fk_Usuario_Id_Usuario)
    REFERENCES Usuario (Id_Usuario)
    ON DELETE SET NULL;
 
ALTER TABLE Item_Pedido ADD CONSTRAINT FK_Item_Pedido_2
    FOREIGN KEY (fk_Carrinho_Compras_Id_Carrinho)
    REFERENCES Carrinho_Compras (Id_Carrinho)
    ON DELETE SET NULL;
 
ALTER TABLE Item_Pedido ADD CONSTRAINT FK_Item_Pedido_3
    FOREIGN KEY (fk_Produto_Id_Produto)
    REFERENCES Produto (Id_Produto)
    ON DELETE SET NULL;
DROP DATABASE IF EXISTS POO;
CREATE DATABASE POO;
USE POO;

/* Lógico_1: */

CREATE TABLE Usuario (
    Id_Usuario INT PRIMARY KEY,
    Nome VARCHAR(100),
    Senha VARCHAR(100)
);

CREATE TABLE Produto (
    Id_Produto INT PRIMARY KEY,
    Nome VARCHAR(20),
    Valor FLOAT
);

CREATE TABLE Carrinho_Compras (
    Id_Carrinho INT PRIMARY KEY,
    fk_Usuario_Id_Usuario INT
);

CREATE TABLE Item_Pedido (
    Id_Pedido INT PRIMARY KEY,
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

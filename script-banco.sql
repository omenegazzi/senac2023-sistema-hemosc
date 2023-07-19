<<<<<<< Upstream, based on origin/Develop
CREATE DATABASE db_hemosc;
use db_hemosc;

CREATE TABLE login(
id_usuario INT NOT NULL AUTO_INCREMENT,
email varchar(30) not null,
usuario VARCHAR(30) NOT NULL,
senha VARCHAR(30) NOT NULL,
PRIMARY KEY (id_usuario)
);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< OURS

CREATE TABLE cidades(
id_cidade INT NOT NULL AUTO_INCREMENT,
codigo_ibge INT,
descricao VARCHAR(100),
uf CHAR(2),
PRIMARY KEY(id_cidade)
);

CREATE TABLE colaboradores(
id_colaborador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
funcao VARCHAR(100),
PRIMARY KEY(id_colaborador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE entidades(
id_entidade INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
PRIMARY KEY(id_entidade),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE tipos_sanguineos(
id_tipo_sanguineo INT NOT NULL AUTO_INCREMENT,
descricao VARCHAR(45),
fator_rh VARCHAR(45),
estoque INT,
PRIMARY KEY (id_tipo_sanguineo)
);

CREATE TABLE saida_sangue(
id_saida_sangue INT NOT NULL AUTO_INCREMENT,
fk_entidades_id_entidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATETIME,
quantidade VARCHAR(45),
PRIMARY KEY (id_saida_sangue),
FOREIGN KEY (fk_entidades_id_entidade) REFERENCES entidades(id_entidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);

CREATE TABLE doadores(
id_doador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
nome VARCHAR(45),
endereco VARCHAR(100),
data_nascimento DATE,
telefone VARCHAR(45),
email VARCHAR(45),
cpf VARCHAR(45),
PRIMARY KEY (id_doador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);


CREATE TABLE agendamentos(
id_agendamento INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
data DATE,
hora TIME,
PRIMARY KEY (id_agendamento),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador)
);


CREATE TABLE doacoes(
id_doacao INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATE,
PRIMARY KEY (id_doacao),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);
=======
>>>>>>> THEIRS
=======
=======
CREATE DATABASE db_hemosc;
use db_hemosc;

CREATE TABLE login(
id_usuario INT NOT NULL AUTO_INCREMENT,
usuario VARCHAR(30) NOT NULL,
senha VARCHAR(30) NOT NULL,
PRIMARY KEY (id_usuario)
);

CREATE TABLE cidades(
id_cidade INT NOT NULL AUTO_INCREMENT,
codigo_ibge INT,
descricao VARCHAR(100),
uf CHAR(2),
PRIMARY KEY(id_cidade)
);

CREATE TABLE colaboradores(
id_colaborador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
funcao VARCHAR(100),
PRIMARY KEY(id_colaborador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE entidades(
id_entidade INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
PRIMARY KEY(id_entidade),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE tipos_sanguineos(
id_tipo_sanguineo INT NOT NULL AUTO_INCREMENT,
descricao VARCHAR(45),
fator_rh VARCHAR(45),
estoque INT,
PRIMARY KEY (id_tipo_sanguineo)
);

CREATE TABLE saida_sangue(
id_saida_sangue INT NOT NULL AUTO_INCREMENT,
fk_entidades_id_entidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATETIME,
quantidade VARCHAR(45),
PRIMARY KEY (id_saida_sangue),
FOREIGN KEY (fk_entidades_id_entidade) REFERENCES entidades(id_entidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);

CREATE TABLE doadores(
id_doador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
nome VARCHAR(45),
endereco VARCHAR(100),
data_nascimento DATE,
telefone VARCHAR(45),
email VARCHAR(45),
cpf VARCHAR(45),
PRIMARY KEY (id_doador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);


CREATE TABLE agendamentos(
id_agendamento INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
data DATE,
hora TIME,
PRIMARY KEY (id_agendamento),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador)
);


CREATE TABLE doacoes(
id_doacao INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATE,
PRIMARY KEY (id_doacao),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);

CREATE TABLE cidades(
id_cidade INT NOT NULL AUTO_INCREMENT,
codigo_ibge INT,
descricao VARCHAR(100),
uf CHAR(2),
PRIMARY KEY(id_cidade)
);

CREATE TABLE colaboradores(
id_colaborador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
funcao VARCHAR(100),
PRIMARY KEY(id_colaborador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE entidades(
id_entidade INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
PRIMARY KEY(id_entidade),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE tipos_sanguineos(
id_tipo_sanguineo INT NOT NULL AUTO_INCREMENT,
descricao VARCHAR(45),
fator_rh VARCHAR(45),
estoque INT,
PRIMARY KEY (id_tipo_sanguineo)
);

CREATE TABLE saida_sangue(
id_saida_sangue INT NOT NULL AUTO_INCREMENT,
fk_entidades_id_entidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATETIME,
quantidade VARCHAR(45),
PRIMARY KEY (id_saida_sangue),
FOREIGN KEY (fk_entidades_id_entidade) REFERENCES entidades(id_entidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);

CREATE TABLE doadores(
id_doador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
nome VARCHAR(45),
endereco VARCHAR(100),
data_nascimento DATE,
telefone VARCHAR(45),
email VARCHAR(45),
cpf VARCHAR(45),
PRIMARY KEY (id_doador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);


CREATE TABLE agendamentos(
id_agendamento INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
data DATE,
hora TIME,
PRIMARY KEY (id_agendamento),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador)
);


CREATE TABLE doacoes(
id_doacao INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATE,
PRIMARY KEY (id_doacao),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);
>>>>>>> e8f2a1c Update script-banco.sql
>>>>>>> origin/#36AlterarTiposSanguineos
=======
<<<<<<< OURS

CREATE TABLE cidades(
id_cidade INT NOT NULL AUTO_INCREMENT,
codigo_ibge INT,
descricao VARCHAR(100),
uf CHAR(2),
PRIMARY KEY(id_cidade)
);

CREATE TABLE colaboradores(
id_colaborador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
funcao VARCHAR(100),
PRIMARY KEY(id_colaborador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE entidades(
id_entidade INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
nome VARCHAR(100),
endereco VARCHAR(100),
PRIMARY KEY(id_entidade),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade)
);

CREATE TABLE tipos_sanguineos(
id_tipo_sanguineo INT NOT NULL AUTO_INCREMENT,
descricao VARCHAR(45),
fator_rh VARCHAR(45),
estoque INT,
PRIMARY KEY (id_tipo_sanguineo)
);

CREATE TABLE saida_sangue(
id_saida_sangue INT NOT NULL AUTO_INCREMENT,
fk_entidades_id_entidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATETIME,
quantidade VARCHAR(45),
PRIMARY KEY (id_saida_sangue),
FOREIGN KEY (fk_entidades_id_entidade) REFERENCES entidades(id_entidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);

CREATE TABLE doadores(
id_doador INT NOT NULL AUTO_INCREMENT,
fk_cidades_id_cidade INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
nome VARCHAR(45),
endereco VARCHAR(100),
data_nascimento DATE,
telefone VARCHAR(45),
email VARCHAR(45),
cpf VARCHAR(45),
PRIMARY KEY (id_doador),
FOREIGN KEY (fk_cidades_id_cidade) REFERENCES cidades(id_cidade),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);


CREATE TABLE agendamentos(
id_agendamento INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
data DATE,
hora TIME,
PRIMARY KEY (id_agendamento),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador)
);


CREATE TABLE doacoes(
id_doacao INT NOT NULL AUTO_INCREMENT,
fk_doadores_id_doador INT,
fk_tipos_sanguineos_id_tipo_sanguineo INT,
data DATE,
PRIMARY KEY (id_doacao),
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador),
FOREIGN KEY (fk_tipos_sanguineos_id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);
=======
>>>>>>> THEIRS
>>>>>>> origin/#63-Função_excluir_Agendamentos

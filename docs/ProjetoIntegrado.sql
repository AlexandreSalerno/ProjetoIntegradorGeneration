CREATE TABLE `tb_postagens` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`data` DATETIME NOT NULL,
	`titulo` VARCHAR(255) NOT NULL,
	`conteudo` TEXT(1000) NOT NULL,
	`links` varchar(250),
	`tema_id` INT NOT NULL,
	`usuario_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nomeCompleto` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`senha` varchar(16) NOT NULL,
	`instrutor` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	`serie` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_comentario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`data` DATETIME NOT NULL,
	`comentario` varchar(1000) NOT NULL,
	`data` DATETIME(250),
	`postagens_id` INT NOT NULL,
	`usuario_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_postagens` ADD CONSTRAINT `tb_postagens_fk0` FOREIGN KEY (`tema_id`) REFERENCES `tb_tema`(`id`);

ALTER TABLE `tb_postagens` ADD CONSTRAINT `tb_postagens_fk1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario`(`id`);

ALTER TABLE `tb_comentario` ADD CONSTRAINT `tb_comentario_fk0` FOREIGN KEY (`postagens_id`) REFERENCES `tb_postagens`(`id`);

ALTER TABLE `tb_comentario` ADD CONSTRAINT `tb_comentario_fk1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario`(`id`);






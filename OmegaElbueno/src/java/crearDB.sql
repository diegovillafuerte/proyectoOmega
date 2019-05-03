/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  diego
 * Created: May 3, 2019
 */

CREATE TABLE USUARIOS
(
id int
nombre varchar(100),
password varchar(100),
base varchar(100),
PRIMARY KEY (id)
);

CREATE TABLE TABLAS
(
idtabla int,
idusuario int,
nombre varchar(100),
PRIMARY KEY (idtabla)
);

INSERT INTO ROOT.USUARIOS (ID, NOMBRE, PASSWORD, BASE) 
	VALUES (1, 'MIGUELON', 'MIGUELON', 'MIGUELON')
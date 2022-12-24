create database larockola_DB;
use larockola_db;	
CREATE TABLE album (
  id_album int NOT NULL,
  nombre_album varchar(45) NOT NULL,
  año_publicacion varchar(20) NOT NULL,
  constraint album_pk PRIMARY KEY (id_album));
  
  CREATE TABLE genero (
  id_genero int NOT NULL AUTO_INCREMENT,
  nombre_genero varchar(50) NOT NULL,
  constraint genero_pk PRIMARY KEY (id_genero));
  
 CREATE TABLE nacionalidad (
  id_nacionalidad int NOT NULL AUTO_INCREMENT,
  nombre_nacionalidad varchar(50) NOT NULL,
  constraint nacionalidad_pk PRIMARY KEY (id_nacionalidad)); 
  
  CREATE TABLE usuario (
  id_usuario varchar(15) NOT NULL,
  nombre_usu varchar(50) NOT NULL,
  email_usu varchar(50) NOT NULL,
  contraseña_usu varchar(10) NOT NULL,
  constraint usuario_pk PRIMARY KEY (id_usuario));
  
  CREATE TABLE artista (
  id_artista int NOT NULL AUTO_INCREMENT,
  nombre_artista varchar(50) NOT NULL,
  año_artista varchar(15) NOT NULL,
  id_nacionalidad int NOT NULL,
  constraint artista_pk PRIMARY KEY (id_artista),
  CONSTRAINT artista_id_nacionalidad_fk FOREIGN KEY (id_nacionalidad) REFERENCES nacionalidad (id_nacionalidad));
  
  CREATE TABLE cancion (
  id_cancion int NOT NULL AUTO_INCREMENT,
  nombre_cancion varchar(50) NOT NULL,
  id_genero int NOT NULL,
  id_album int NOT NULL,
  constraint cancion_pk PRIMARY KEY (id_cancion),
  CONSTRAINT cancion_id_album_fk FOREIGN KEY (id_album) REFERENCES album (id_album),
  CONSTRAINT cancion_id_genero_fk FOREIGN KEY (id_genero) REFERENCES genero (id_genero));
  
  CREATE TABLE cancion_artista (
  id_cancion int NOT NULL,
  id_artista int NOT NULL,
  CONSTRAINT cancion_artista_pk PRIMARY KEY (id_cancion,id_artista),
  CONSTRAINT cancion_artista_id_artista_fk FOREIGN KEY (id_artista) REFERENCES artista (id_artista),
  CONSTRAINT cancion_artista_id_cancion_fk FOREIGN KEY (id_cancion) REFERENCES cancion (id_cancion));
  
  
  
  
  
  
  
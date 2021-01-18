 create database _Tree_
use _Tree_  

CREATE TABLE `referentiel` (`id_ref` int(11) NOT NULL, `nom_ref` varchar(255) NOT NULL,
    primary key (`id_ref`)
) ;


CREATE TABLE `utilisateur` ( `id_user` int(11) NOT NULL, `nom_user` varchar(20) NOT NULL, `prenom_user` varchar(20) NOT NULL,  `age_user` int(11) NOT NULL,
  `email_user` varchar(40) NOT NULL,
  `mdps_user` varchar(40) NOT NULL,
  `type_user` varchar(11) NOT NULL,
   primary key (`id_user`)
);

	
CREATE TABLE `competence` ( `id_cmptnce` int(11) NOT NULL, `id_ref` int(11) NOT NULL, `nom_cmptnce` varchar(255) NOT NULL,
    primary key (`id_cmptnce`),
	CONSTRAINT `id_ref` FOREIGN KEY (`id_ref`) REFERENCES `referentiel` (`id_ref`) ON DELETE CASCADE on update CASCADE
);

CREATE TABLE `niveaau`(
   `id_user` int NOT NULL,
   `id_cmptnce` int NOT NULL,
   niveau int,
	PRIMARY KEY (id_user, id_cmptnce),
    UNIQUE INDEX (id_user, id_cmptnce),
	CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id_user`) ON DELETE CASCADE on update CASCADE,
	CONSTRAINT `id_cmptnce` FOREIGN KEY (`id_cmptnce`) REFERENCES `competence` (`id_cmptnce`)ON DELETE CASCADE on update CASCADE
);


SELECT utilisateur.nom_user,utilisateur.prenom_user,competence.id_cmptnce,competence.nom_cmptnce,referentiel.nom_ref,niveaau.niveau 
from utilisateur,competence,niveaau,referentiel
where utilisateur.id_user=niveaau.id_user 
and niveaau.id_cmptnce=competence.id_cmptnce 
and competence.id_ref=referentiel.id_ref 
and utilisateur.id_user=1;


SELECT referentiel.id_ref,referentiel.nom_ref,competence.id_cmptnce,competence.nom_cmptnce,niveaau.niveau from utilisateur,competence,niveaau,referentiel
where utilisateur.id_user=niveaau.id_user 
and niveaau.id_cmptnce=competence.id_cmptnce 
and competence.id_ref=referentiel.id_ref and utilisateur.id_user=1;

update niveaau set niveau=3 where niveaau.id_user=1 and niveaau.id_cmptnce=1;
	
select utilisateur;
select nom_user,prenom_user,age_user ,competence.nom_écmptnce, niveaau.*  from utilisateur,competence,niveaau  where utilisateur.id_user=niveaau.id_user and niveaau.id_cmptnce=competence.id_cmptnce and utilisateur.id_user=1;
SELECT utilisateur.nom_user,utilisateur.prenom_user,competence.id_cmptnce,competence.nom_cmptnce,referentiel.nom_ref,niveaau.n1,niveaau.n2,niveaau.n3 from utilisateur,competence,niveaau,referentiel where utilisateur.id_user=niveaau.id_user and niveaau.id_cmptnce=competence.id_cmptnce and competence.id_ref=referentiel.id_ref and utilisateur.id_user=1;
/*Insert Referetiel */
insert into referentiel(id_ref, nom_ref) values
(1,'Développeur web et web mobile'),
(2,'Concepteur développeur d`applications');

/*Insert Competences*/
insert into competence(id_cmptnce, id_ref, nom_cmptnce) values
(1,1,'Maquetter une application'),
(2,1,'Réaliser une interface utilisateur web statique et adaptable'),
(3,1,'Développer une interface utilisateur web dynamique'),
(4,1,'Réaliser une interface utilisateur avec une solution de gestion de contenu ou e-commerce'),
(5,1,'Créer une base de données'),
(6,1,'Développer des composants d`accès aux données'),
(7,1,'Développer la partie back-end d’une application web ou web mobile'),
(8,1,'Élaborer et mettre en œuvre des composants dans une application de gestion de contenu ou e-commerce'),
(9,2,'Développer une interface utilisateur de type desktop'),
(10,2,'Développer des composants d’accès aux données'),
(11,2,'Développer la partie front-end d’une interface utilisateur web'),
(12,2,'Développer la partie back-end d’une interface utilisateur web'),
(13,2,'Concevoir une base de données'),
(14,2,'Mettre en place une base de données'),
(15,2,'Développer des composants dans le langage d’une base de données'),
(16,2,'ollaborer à la gestion d’un projet informatique et à l’organisation de l’environnement de développement'),
(17,2,'Concevoir une application'),
(18,2,'Développer des composants métier'),
(19,2,'Construire une application organisée en couches'),
(20,2,'Développer une application mobile'),
(21,2,'Préparer et exécuter les plans de tests d’une application'),
(22,2,'Préparer et exécuter le déploiement d’une application');



/* insert Utilisateurs*/
insert into utilisateur(id_user, nom_user, prenom_user, age_user, email_user, mdps_user,type_user) values
(1,'Daher','Alaeeddine','22','AlaeeddineDaher@gmail.com','123456','Apprenant'),
(2,'Bitar','Samira','23','SamiraBitar@gmail.com','123456','Apprenant'),
(3,'Nazari','Hamza','22','HamzaNazari@gmail.com','123456','Apprenant'),
(4,'Gaber','Wahibah','19','GaberWahibah@gmail.com','123456','Apprenant'),
(5,'Asfour','Halima','25','HalimaAsfour@gmail.com','123456','Apprenant'),
(6,'Naser','Taoufiq','25','TaoufiqNaser@gmail.com','123456','Apprenant'),
(7,'Dagher','Houssam','24','HoussamDagher@gmail.com','123456','Apprenant'),
(8,'Rahal','Mohamed','22','MohamedRahal@gmail.com','123456','Apprenant'),
(9,'Qureshi','Imane','21','ImaneQureshi@gmail.com','123456','Apprenant'),
(10,'Gaber','Ayoub','24','AyoubGaber@gmail.com','123456','Apprenant'),
(11,'Kouri','Wiam','22','WiamKouri@gmail.com','123456','Apprenant'),
(12,'Attia','Chaima','26','ChaimaAttia@gmail.com','123456','Apprenant'),
(13,'Hakimi','Mohamed','20','MohamedHakimi@gmail.com','123456','Apprenant'),
(14,'Sabbagh','Saad','21','SaadSabbagh@gmail.com','123456','Apprenant'),
(15,'Aswad','Zineb','25','ZinebAswad@gmail.com','123456','Apprenant'),
(16,'Kanaan','Ahmed','23','AhmedKanaan@gmail.com','123456','Apprenant'),
(17,'Haik','Youssef','24','YoussefHaik@gmail.com','123456','Apprenant'),
(18,'Kattan','Ismail','20','IsmailKattan@gmail.com','123456','Apprenant'),
(19,'Sayegh','Meryam','30','MeryamSayegh@gmail.com','123456','Staff'),
(20,'Nassar','Youness','33','YounessNassar@gmail.com','123456','Staff'),
(21,'Sleiman','Youssef','28','YoussefSleiman@gmail.com','123456','Staff'),
(22,'Ganim','FatimaEzzahra','34','FatimaEzzahraGanim@gmail.com','123456','Staff'),
(23,'Ghannam','Hanae','32','HanaeGhannam@gmail.com','123456','Staff'),
(24,'Bazzi','Mohamed','36','MohamedBazzi@gmail.com','123456','Staff');


insert into niveaau(id_user, id_cmptnce, niveau) values
(1,9,0),(1,10,0),(1,11,0),(1,12,0),(1,13,0),(1,14,0),(1,15,0),(1,16,0),(1,17,0),(1,18,0),(1,19,0),(1,20,0),(1,21,0),(1,22,0),
(2,9,0),(2,10,0),(2,11,0),(2,12,0),(2,13,0),(2,14,0),(2,15,0),(2,16,0),(2,17,0),(2,18,0),(2,19,0),(2,20,0),(2,21,0),(2,22,0),
(3,9,0),(3,10,0),(3,11,0),(3,12,0),(3,13,0),(3,14,0),(3,15,0),(3,16,0),(3,17,0),(3,18,0),(3,19,0),(3,20,0),(3,21,0),(3,22,0),
(4,9,0),(4,10,0),(4,11,0),(4,12,0),(4,13,0),(4,14,0),(4,15,0),(4,16,0),(4,17,0),(4,18,0),(4,19,0),(4,20,0),(4,21,0),(4,22,0),
(5,9,0),(5,10,0),(5,11,0),(5,12,0),(5,13,0),(5,14,0),(5,15,0),(5,16,0),(5,17,0),(5,18,0),(5,19,0),(5,20,0),(5,21,0),(5,22,0),
(6,9,0),(6,10,0),(6,11,0),(6,12,0),(6,13,0),(6,14,0),(6,15,0),(6,16,0),(6,17,0),(6,18,0),(6,19,0),(6,20,0),(6,21,0),(6,22,0),
(7,9,0),(7,10,0),(7,11,0),(7,12,0),(7,13,0),(7,14,0),(7,15,0),(7,16,0),(7,17,0),(7,18,0),(7,19,0),(7,20,0),(7,21,0),(7,22,0),
(8,9,0),(8,10,0),(8,11,0),(8,12,0),(8,13,0),(8,14,0),(8,15,0),(8,16,0),(8,17,0),(8,18,0),(8,19,0),(8,20,0),(8,21,0),(8,22,0),
(9,9,0),(9,10,0),(9,11,0),(9,12,0),(9,13,0),(9,14,0),(9,15,0),(9,16,0),(9,17,0),(9,18,0),(9,19,0),(9,20,0),(9,21,0),(9,22,0),
(10,9,0),(10,10,0),(10,11,0),(10,12,0),(10,13,0),(10,14,0),(10,15,0),(10,16,0),(10,17,0),(10,18,0),(10,19,0),(10,20,0),(10,21,0),(10,22,0),
(11,9,0),(11,10,0),(11,11,0),(11,12,0),(11,13,0),(11,14,0),(11,15,0),(11,16,0),(11,17,0),(11,18,0),(11,19,0),(11,20,0),(11,21,0),(11,22,0),
(12,9,0),(12,10,0),(12,11,0),(12,12,0),(12,13,0),(12,14,0),(12,15,0),(12,16,0),(12,17,0),(12,18,0),(12,19,0),(12,20,0),(12,21,0),(12,22,0),
(13,9,0),(13,10,0),(13,11,0),(13,12,0),(13,13,0),(13,14,0),(13,15,0),(13,16,0),(13,17,0),(13,18,0),(13,19,0),(13,20,0),(13,21,0),(13,22,0),
(14,9,0),(14,10,0),(14,11,0),(14,12,0),(14,13,0),(14,14,0),(14,15,0),(14,16,0),(14,17,0),(14,18,0),(14,19,0),(14,20,0),(14,21,0),(14,22,0),
(15,9,0),(15,10,0),(15,11,0),(15,12,0),(15,13,0),(15,14,0),(15,15,0),(15,16,0),(15,17,0),(15,18,0),(15,19,0),(15,20,0),(15,21,0),(15,22,0),
(16,9,0),(16,10,0),(16,11,0),(16,12,0),(16,13,0),(16,14,0),(16,15,0),(16,16,0),(16,17,0),(16,18,0),(16,19,0),(16,20,0),(16,21,0),(16,22,0),
(17,9,0),(17,10,0),(17,11,0),(17,12,0),(17,13,0),(17,14,0),(17,15,0),(17,16,0),(17,17,0),(17,18,0),(17,19,0),(17,20,0),(17,21,0),(17,22,0),
(18,9,0),(18,10,0),(18,11,0),(18,12,0),(18,13,0),(18,14,0),(18,15,0),(18,16,0),(18,17,0),(18,18,0),(18,19,0),(18,20,0),(18,21,0),(18,22,0);


select * from staff,utilisateur where staff.id_user=utilisateur.id_user and staff.id_user=19;


/* modification*/
update apprenant,competence SET n2=true 
where competence.id_cmptnce=apprenant.id_cmptnce
and apprenant.id_cmptnce=1 and apprenant.id_user=1;

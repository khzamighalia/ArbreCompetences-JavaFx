
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
   `n1` boolean default false,
   `n2` boolean default false,
   `n3` boolean default false,
	PRIMARY KEY (id_user, id_cmptnce),
	CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id_user`) ON DELETE CASCADE on update CASCADE,
	CONSTRAINT `id_cmptnce` FOREIGN KEY (`id_cmptnce`) REFERENCES `competence` (`id_cmptnce`)ON DELETE CASCADE on update CASCADE
);



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



select * from staff,utilisateur where staff.id_user=utilisateur.id_user and staff.id_user=19;


/*Selection */
select  utilisateur.nom_user,competence.nom_cmptnce,competence.n1,competence.n2,competence.n3 from utilisateur,apprenant,competence where utilisateur.id_user=apprenant.id_user and competence.id_cmptnce=apprenant.id_cmptnce and apprenant.id_cmptnce=1 and apprenant.id_user=1;

/* modification*/
update apprenant,competence SET n2=true 
where competence.id_cmptnce=apprenant.id_cmptnce
and apprenant.id_cmptnce=1 and apprenant.id_user=1;

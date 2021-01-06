
create database _Tree_
use _Tree_

CREATE TABLE `referentiel` (`id_ref` int(11) NOT NULL, `nom_ref` varchar(255) NOT NULL,
    primary key (`id_ref`)
) ;

CREATE TABLE `competence` ( `id_cmptnce` int(11) NOT NULL, `id_ref` int(11) NOT NULL, `nom_cmptnce` varchar(255) NOT NULL,
  `n1` boolean default false,
  `n2` boolean default false,
  `n3` boolean default false,
    primary key (`id_cmptnce`),
      CONSTRAINT `id_ref` FOREIGN KEY (`id_ref`) REFERENCES `referentiel` (`id_ref`) ON DELETE CASCADE on update CASCADE
);
CREATE TABLE `utilisateur` ( `id_user` int(11) NOT NULL, `nom_user` varchar(20) NOT NULL, `prenom_user` varchar(20) NOT NULL,  `age_user` int(11) NOT NULL,
  `email_user` varchar(40) NOT NULL,
  `mdps_user` varchar(40) NOT NULL,
    primary key (`id_user`)
);

CREATE TABLE `apprenant` ( `id_user` int(10) NOT NULL,  PRIMARY KEY (`id_user`),
		CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id_user`) ON DELETE CASCADE on update CASCADE
        );

CREATE TABLE `staff` (`id_user` int(10) NOT NULL,  PRIMARY KEY (`id_user`),
		CONSTRAINT `id_user2` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id_user`) ON DELETE CASCADE on update CASCADE
        );




/*Insert Referetiel */
insert into referentiel(id_ref, nom_ref) values
(1,'Développeur web et web mobile'),
(2,'Concepteur développeur d`applications');


/*Insert Competences*/
insert into competence(id_cmptnce, id_ref, nom_cmptnce, n1, n2, n3) values
(1,1,'Maquetter une application', false, false, false),
(2,1,'Réaliser une interface utilisateur web statique et adaptable', false, false, false),
(3,1,'Développer une interface utilisateur web dynamique', false, false, false),
(4,1,'Réaliser une interface utilisateur avec une solution de gestion de contenu ou e-commerce', false, false, false),
(5,1,'Créer une base de données', false, false, false),
(6,1,'Développer des composants d`accès aux données', false, false, false),
(7,1,'Développer la partie back-end d’une application web ou web mobile', false, false, false),
(8,1,'Élaborer et mettre en œuvre des composants dans une application de gestion de contenu ou e-commerce', false, false, false),
(9,2,'Développer une interface utilisateur de type desktop', false, false, false),
(10,2,'Développer des composants d’accès aux données', false, false, false),
(11,2,'Développer la partie front-end d’une interface utilisateur web', false, false, false),
(12,2,'Développer la partie back-end d’une interface utilisateur web', false, false, false),
(13,2,'Concevoir une base de données', false, false, false),
(14,2,'Mettre en place une base de données', false, false, false),
(15,2,'Développer des composants dans le langage d’une base de données', false, false, false),
(16,2,'ollaborer à la gestion d’un projet informatique et à l’organisation de l’environnement de développement', false, false, false),
(17,2,'Concevoir une application', false, false, false),
(18,2,'Développer des composants métier',false, false, false),
(19,2,'Construire une application organisée en couches',false, false, false),
(20,2,'Développer une application mobile',false, false, false),
(21,2,'Préparer et exécuter les plans de tests d’une application',false, false, false),
(22,2,'Préparer et exécuter le déploiement d’une application',false, false, false);



/* insert Utilisateurs*/
insert into utilisateur(id_user, nom_user, prenom_user, age_user, email_user, mdps_user) values
(1,'Daher','Alaeeddine','22','AlaeeddineDaher@gmail.com','123456'),
(2,'Bitar','Samira','23','SamiraBitar@gmail.com','123456'),
(3,'Nazari','Hamza','22','HamzaNazari@gmail.com','123456'),
(4,'Gaber','Wahibah','19','GaberWahibah@gmail.com','123456'),
(5,'Asfour','Halima','25','HalimaAsfour@gmail.com','123456'),
(6,'Naser','Taoufiq','25','TaoufiqNaser@gmail.com','123456'),
(7,'Dagher','Houssam','24','HoussamDagher@gmail.com','123456'),
(8,'Rahal','Mohamed','22','MohamedRahal@gmail.com','123456'),
(9,'Qureshi','Imane','21','ImaneQureshi@gmail.com','123456'),
(10,'Gaber','Ayoub','24','AyoubGaber@gmail.com','123456'),
(11,'Kouri','Wiam','22','WiamKouri@gmail.com','123456'),
(12,'Attia','Chaima','26','ChaimaAttia@gmail.com','123456'),
(13,'Hakimi','Mohamed','20','MohamedHakimi@gmail.com','123456'),
(14,'Sabbagh','Saad','21','SaadSabbagh@gmail.com','123456'),
(15,'Aswad','Zineb','25','ZinebAswad@gmail.com','123456'),
(16,'Kanaan','Ahmed','23','AhmedKanaan@gmail.com','123456'),
(17,'Haik','Youssef','24','YoussefHaik@gmail.com','123456'),
(18,'Kattan','Ismail','20','IsmailKattan@gmail.com','123456'),
(19,'Sayegh','Meryam','30','MeryamSayegh@gmail.com','123456'),
(20,'Nassar','Youness','33','YounessNassar@gmail.com','123456'),
(21,'Sleiman','Youssef','28','YoussefSleiman@gmail.com','123456'),
(22,'Ganim','FatimaEzzahra','34','FatimaEzzahraGanim@gmail.com','123456'),
(23,'Ghannam','Hanae','32','HanaeGhannam@gmail.com','123456'),
(24,'Bazzi','Mohamed','36','MohamedBazzi@gmail.com','123456');


insert into staff values (19),(20),(21),(22),(23),(24);

select * from staff,utilisateur where staff.id_user=utilisateur.id_user and staff.id_user=19;

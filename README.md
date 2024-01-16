# Créez un site communautaire autour de l'escalade

## Contexte
Vous êtes freelance et vous menez différents projets informatiques de développement d’applications web en Java EE. Vous êtes contacté via Malt par “Les Amis de l’escalade” :

Bonjour, nous sommes une association qui réunit les passionnés d’escalade dans toute la France. Nous recherchons un développeur Java EE pour créer un site communautaire autour de cette discipline. Votre profil et vos expériences ont retenu notre attention. Seriez-vous intéressé par une mission de ce type (contrat en auto-entrepreneur) ?

Vous convenez d’un premier rendez-vous en visioconférence. Ce point vous permet de mieux comprendre leurs attentes et de vous entendre sur la partie contractuelle.

Vous décidez d’accepter la mission et une fois les détails administratifs réglés, vous vous penchez sur la conception de l’application web.

Par souci du détail, vous réalisez quelques recherches sur l’escalade pour vous familiariser avec le vocabulaire de la discipline.

[Projet 6 - OC](https://openclassrooms.com/fr/paths/88/projects/128/assignment)

## Requirements

* Java
* Apache Maven
* MySQL workbench


## How to start
### Installation

* Clone the repository

`git clone https://github.com/Archytekt77/Projet_VI.git`

* Open MySQL workbench, click on `Server` and `Data import`
    * Click on `Server`
    * Click on `Data import`
    * Import from Dump Project Folder : C:...\P6-LOIC-MARIA\dumps\Dump20210122.sql
  
* Open Projet_VI with git and use the command line `mvn spring-boot:run`


### Use the application

* Open your browser and type `localhost:8080`

* You can use 3 profiles :

User | Password | Role
-----|----------|-----
admin@gmail.com| admin | admin
utilisateur1@gmail.com | utilisateur1 | user
utilisateur2@gmail.com | utilisateur2 | user

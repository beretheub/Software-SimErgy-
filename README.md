# Software-SimErgy-
CARNET DE BORD (je propose qu'on garde ce doc pour le compte-rendu ensuite)
Rq : 
- l'id d'une ressource devrait être générée automatiquement (de façon à être unique)
- il faudrait faire un test Gunit de toutes les classes créées
- je crée une class id generator qui permet de créer un id unique pour chacune des ressources d'un ED. C'est un singleton partern (mais un peu modifié parce que les deux premiers chiffres de l'id permettent de connaitre le type de ressource)


- Jamais de to string ? 
- HR : il faut generer des ID automatiques aussi non ? 
Pas de Test pour les abstract class (HR, ...) -> je vais bouger mon test HR, mais je dois y aller là
- pourquoi NHR est une interface, et HR une abstract class ? 
- pourquoi des numéros pour les états, ça complique tout non ?


Je termine le idgenerator ce soir, j'ai presque fini mais j'ai pas eu le temps de tout achever ! Et j'essaie de terminer la création de toutes les classes !

- j'enlève le setId pour tout le monde, ça n'a pas de sens de la garder à mon avis, si on veut vraiment un id unique il ne faut pas qu'on donne la possibilité de le changer. 
 

 - je mets les tests en public sinon ne fonctionnent pas 
 + création du dossier test demandé dans l'énoncé
 - Il faut réfléchir à un ordonnement
 		- Un dossier event
 		- Un dossier Hopital
 		- ...
 		et un index pour tout ça 
 		je vais courir, et après je me mets au dossier event ! :D

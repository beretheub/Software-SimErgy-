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

- j'enlève le setId pour tout le monde, ça n'a pas de sens de la garder à mon avis, si on veut vraiment un id unique il ne faut pas qu'on donne la possibilité de le changer.

11/11/2017. 




 - je mets les tests en public sinon ne fonctionnent pas 
 + création du dossier test demandé dans l'énoncé
 - Il faut réfléchir à un ordonnement
 		- Un dossier event
 		- Un dossier Hopital
 		- ...
 		et un xommaire dans la doc 
 		
 		(J'ai pas trop compris ton dernier point... C'est quoi l'index ?)  
- J'ai changé le fonctionnement de l'id generator, il marche normalement maintenant. A noter : j'ai changé la manière dont sont notés les id pour des raisons pratiques ils commencent tous par un chiffre strictement supérieur à 0. Je pense que c'était pas forcément nécessaire de faire tout ça mais bon maintenant que c'est fait autant s'y tenir !
 

- j'enlève le setId pour tout le monde, ça n'a pas de sens de la garder à mon avis, si on veut vraiment un id unique il ne faut pas qu'on donne la possibilité de le changer.


- Je ne sais pas si les consultation ont leur place en tant que health service etant donné que l'on a déjà la class consultation room dans laquelle est la liste d'attente des patients... (voir les commentaire de la class consultation. 
 
 - J'ai commencé le factory pattern, je le fini demain et après je pourrais m'attaquer aux fonctionnalités un peu plus avancées des classes ressources !

- Finalement, pour les consultations et examens, on a des services, mais pas de room ? 

- Il faut que je complète , Ce sera ensuite la class de création d'ED, qui sera capable de voir par exemple si une nurse est libre, un docteur, ou une pièce je pense 
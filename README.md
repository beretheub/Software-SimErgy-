# Software-SimErgy-
CARNET DE BORD (je propose qu'on garde ce doc pour le compte-rendu ensuite)
Rq : 
- l'id d'une ressource devrait �tre g�n�r�e automatiquement (de fa�on � �tre unique)
- il faudrait faire un test Gunit de toutes les classes cr��es
- je cr�e une class id generator qui permet de cr�er un id unique pour chacune des ressources d'un ED. C'est un singleton partern (mais un peu modifi� parce que les deux premiers chiffres de l'id permettent de connaitre le type de ressource)


- Jamais de to string ? 
- HR : il faut generer des ID automatiques aussi non ? 
Pas de Test pour les abstract class (HR, ...) -> je vais bouger mon test HR, mais je dois y aller l�
- pourquoi NHR est une interface, et HR une abstract class ? 
- pourquoi des num�ros pour les �tats, �a complique tout non ?

- j'enl�ve le setId pour tout le monde, �a n'a pas de sens de la garder � mon avis, si on veut vraiment un id unique il ne faut pas qu'on donne la possibilit� de le changer.

11/11/2017. 




 - je mets les tests en public sinon ne fonctionnent pas 
 + cr�ation du dossier test demand� dans l'�nonc�
 - Il faut r�fl�chir � un ordonnement
 		- Un dossier event
 		- Un dossier Hopital
 		- ...
 		et un xommaire dans la doc 
 		
 		(J'ai pas trop compris ton dernier point... C'est quoi l'index ?)  
- J'ai chang� le fonctionnement de l'id generator, il marche normalement maintenant. A noter : j'ai chang� la mani�re dont sont not�s les id pour des raisons pratiques ils commencent tous par un chiffre strictement sup�rieur � 0. Je pense que c'�tait pas forc�ment n�cessaire de faire tout �a mais bon maintenant que c'est fait autant s'y tenir !
 

- j'enl�ve le setId pour tout le monde, �a n'a pas de sens de la garder � mon avis, si on veut vraiment un id unique il ne faut pas qu'on donne la possibilit� de le changer.


- Je ne sais pas si les consultation ont leur place en tant que health service etant donn� que l'on a d�j� la class consultation room dans laquelle est la liste d'attente des patients... (voir les commentaire de la class consultation. 
 
 - J'ai commenc� le factory pattern, je le fini demain et apr�s je pourrais m'attaquer aux fonctionnalit�s un peu plus avanc�es des classes ressources !

- Finalement, pour les consultations et examens, on a des services, mais pas de room ? 

- Il faut que je compl�te , Ce sera ensuite la class de cr�ation d'ED, qui sera capable de voir par exemple si une nurse est libre, un docteur, ou une pi�ce je pense 
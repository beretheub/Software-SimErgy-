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


Je termine le idgenerator ce soir, j'ai presque fini mais j'ai pas eu le temps de tout achever ! Et j'essaie de terminer la cr�ation de toutes les classes !

- j'enl�ve le setId pour tout le monde, �a n'a pas de sens de la garder � mon avis, si on veut vraiment un id unique il ne faut pas qu'on donne la possibilit� de le changer. 
 

 - je mets les tests en public sinon ne fonctionnent pas 
 + cr�ation du dossier test demand� dans l'�nonc�
 - Il faut r�fl�chir � un ordonnement
 		- Un dossier event
 		- Un dossier Hopital
 		- ...
 		et un index pour tout �a 
 		je vais courir, et apr�s je me mets au dossier event ! :D

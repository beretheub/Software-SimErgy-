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

- feuille de soin : du coup je supprime la m�thide de cr�ation de feuille de soin. Je laisse la mise � jour des informations + l'�mission du r�sultat � la sortie

Questions : 
- distribution inverse de det ? 
- abstract class probabilitydistribution -> je ne choisis pas param, ne sert � rien en l'�tat, je vais peut-�tre la supprimer

13/11
- remplacement d'une de tes erreurs par une exception (classe ED). Enfin je l'ai fait pour le premier, mais en fait je vois que tu en as d'autres tu veux qu'on le fasse aussi ? 

18/11
- pourquoi 2 event urgent et non-urgent, et pas 1 seul, avec une boucle if ?
- sort : en fonction de la priorit�, puis par temps d'attente pour une priorit� �gale
		=> fonction getIntPriority pour ce tri
- il faut g�rer le cas o� le patient s'en va/ meurt / il faut aussi pouvoir chager la s�v�rit� au cours du processus si on veut que ce soit plus r�aliste ? 
- les cas urgens ne sont pour l'instant pas pris en compte dans la consultation 
- pourquoi patient state et pas roomstate dans ce cas ? 
- pourquoi pas execute() dans Arr ? 
- il faudra peut-�tre voir si ce n'est pas plus simple d'int�grer freenurse, physician et freepatient � la classe endevent ? Et faire de m�me pour les pi�ces et �quipements ? 
- J'ai chang� les �tats du patient par ceux qui sont d�crits dans l'�nonc� (en vist/test/consultations, ...), mais �a me parait moins simple, � voir comment on fait 
- Le syst�me de prix n'est pas encore fait -> attribut pricetopay dans patient ? 
- Je vois 2 solutions pour le r�sultat d'un examen, qu dans tous les cas, est envoy� au m�decin (observer pattern)
	- On pr�pare des �num�rations comme pour la consultation (c'est ce qu'il avait eu l'air de dire quand je lui ai pos� la question en cours ...)
	- On n'a pas besoin de savoir quel est le r�sultat, il est renvoy� au m�decin ??? Je tente �a pour l'instant. 

- Je ne me rappelle plus ce qu'on avait dit � propos des pi�ces pour les healthservices ... pour l'instant je fais appel au service, l� o� c'�tait la pi�ce pour la consultation/installation
- J'ai commenc� ma fonction de trie, elle fonctionne � partir du moment o� on r�cup�re le patient dans l'�v�nement
- Je suppose pour l'instant que suite � la consultation, le patient est transport� (5minutes): 
	soit vers la sortie
	soit vers les salles d'attentes d'exam
- pour que ce soit plus simple, je rajoute un attribut nexstep � un patient
- il faut remettre des exceptions un peu partout dans l'ED, mais je ne comprends pas du tout ce que tu as fait pour l'instant avec les exceptions donc je ne touche aps tout de suite 
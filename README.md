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
- les cas urgens ne sont pour l'instant pas pris en compte dans la consultation (shockroom, mais apr�s ?)
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
- je fais le syst�me de couts => Il faut peut-�tre revoir ceux fix�s pour l'instant : 100� l'examen, 30� la consultation, 5� le transport en strecher ? On doit rajouter le prix d'une �ventuelle �rriv�e en ambulance ? ATTENTION, je m'arr�te au mileiu de ce que j'ai fait, 



-------------


Je met la fonction calculoutput plutot dans la class physician en l'appelant prescribeExam pour coller mieux � l'�nonc�.

J'ajoute les services manquant � la liste des output possible
Je dois changer les proba de output (je fais �a vite il faudra re-r�fl�chir � la pertinence de  celles ci)

pour une premi�re version un patient n'est pas oblig� de voir le m�me m�decin � chaque fois, j'enl�ve donc la liste PatientBeeingOverseen de la classe physician

Je mets consultation comme nextstep initial des patient comme ils doivent de toute mani�re commencer par une consultation

La condition pour enable un event transportation doit �tre de trouver un patient dans une boxroom ou shock avec un nextstep != consultation

Je rajoute � ton event exam, la fonction qui dirige le patient vers la file d'attente suivante en fonction de l'output de l'exam


Je pense que l'on a toutes les fonctionnalit�s de base du  core system (m�me s'il en manque pleins ! Genre utiliser les loi de probas, le calcul du cout, le syst�me observer etc...)
Je commence � coder la partie deux simulation, et on fera tous les ajouts de fonctionnalit� demand�s dans l'�nonc� ou non par la suite pour rendre la simulation plus r�aliste


Je cr�e une nouvelle class EnabledEvents dans la partie simulation pour rassembler toutes les m�thodes li�es � cette liste

Dants la m�thode timeManager.startSimulation :   On cr�e une copie de l'ed initial, et on retourne son �tat final, �a permet de pouvoir faire plusieurs simulation sur le m�me ED en changeant quelques param�tres (on ne fait pas de changement directement sur l'ed) 


_______________________________


Il ne faut pas que la cr�ation d'un �v�nement renvoit une exception sinon �a fait une erreur de compilation lorsque que l'on veut faire d'autre choses avec cette �v�nement (comme le programme n'est pas sur que l'�v�nement a bien �t� cr�� � cause du try/catch) il faut donc aboslument g�rer tes exceptions de lois normale au sein de l'�v�nement.



Je fais fonctionner les strechers comme les nurses physician... (cad avec un ev�nement freeStrecher) c'est plus commode.


=======
-> est ce qu'il faut changer dans l'ED aussi du coup par exemple ? 
--------
B�r� 27/11
- je mets des prix plus logiques : 
	- 50� pour un examen
	- 30� pour une consultation
Je remplace l'erreur de g�n�ration d'ID par une exception 
Je compl�te les exceptions que tu avais laiss�es vides
POurquoi une date prochainedate � laquelle elle est libre dans la classe nurse et pas physician ? 

-------
B�r� 28/11
J'ai commenc� � ajouter les key performance indicators. Tous n'est pas correct car : 
- ne prend pour l'instant pas en compte les temps d'attente*
- en y r�fl�chissant, il vaut peut-etre mieux ne calculer LOS que � la fin plutot que au fur et � mesure ? 
	Pour moi il faut faire une class "computeKPI" qui prend en argument un ED apr�s qu'il soit 	pass� dans le simulateur et calcul tout d'un coup � la fin oui 




Commentaires : 
- peut-�te revoir un peu l'ed qui est lourd 
	
- peut-�tre revoir pour l'ID generator

---- A FAIRE -----
* Fonction Sort ? 
	(Je le fais en m'occupant du simulateur)
* Syst�me d'observer dans healthservice, physician ? Revoir la messagerie du m�decin car non utils�e pour l'instant ? 
* choisir entre la queue du health serice ou de l'ed pour les exams ?
	On a dit la queue de l'ed je crois la derni�re fois ! 
* remplacer nos tests par des JUNITS ? 
	Ouais il fait le faire ! Mais il faut qu'on ai aussi deux tests qui correspondent au 	sc�nario d�crit dans le sujet 
* Je comprends pas le dernier commentaire de HumanRessources
	Ouais je me suis un peu emport�, mais je voulais dire par l� qu'il fallait bien que lorsque l'on initialise une ressource on lui attribue un ed sp�cifique, et il faut donc bien qu'on ajoute aussi syst�matiquement cette ressource � la liste des ressources qu'il y a dans l'ED correspondant ;) 
	
* Il faut faire la command line user interface aussi ! En plus on peut la faire en parall�le du simulateur : y'a pas trop d'influence de l'un sur l'autre !



--------

Il faut �viter de throws des exception sur des constructor, sinon �a fait le probl�me dont je t'ai parl� � propos des events. Et plus g�n�ralement essayer de catch les exception le plus t�t possible et ne pas seulement les throw plus loin


Pour le rapport : dans la mod�lisation que l'on fait, le patient apr�s avoir �t� visit� par un m�decin dans une box/shockRoom est replac� instantan�ment dans une salle ou il attend d'�tre transport� � son service : il n'occupe plus la room de la visite, celle ci peut �tre utilis�e pour un autre patient !




ATTENTION : je viens de me rendre compte d'un probl�me, si un m�decin d�clare qu'un patient n'a pas besoin d'un test, la patient est tout de m�me plac� dans la  file d'attente pour les exam... Il n'en sortira donc jamais. 

Pour le calcul des KPI je pense que c'est plus pratique de cr�er 3 variables dans la class patient (arriv�ehopital, premierM�decin et sortie d'hopital) de les mettre � jour une seule fois avec le timeStamp et d'en d�duire les KPI


Il y aurait moyen de respecter mieux l'encaplusaltion en cr�ant une factory d'events (� voir si on a le temps) ou seulement l'indiquer dans le rapport


Pour la transportation aussi, les patients pris en priorit� sont les patients graves

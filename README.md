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

- feuille de soin : du coup je supprime la méthide de création de feuille de soin. Je laisse la mise à jour des informations + l'émission du résultat à la sortie

Questions : 
- distribution inverse de det ? 
- abstract class probabilitydistribution -> je ne choisis pas param, ne sert à rien en l'état, je vais peut-être la supprimer

13/11
- remplacement d'une de tes erreurs par une exception (classe ED). Enfin je l'ai fait pour le premier, mais en fait je vois que tu en as d'autres tu veux qu'on le fasse aussi ? 

18/11
- pourquoi 2 event urgent et non-urgent, et pas 1 seul, avec une boucle if ?
- sort : en fonction de la priorité, puis par temps d'attente pour une priorité égale
		=> fonction getIntPriority pour ce tri
- il faut gérer le cas où le patient s'en va/ meurt / il faut aussi pouvoir chager la sévérité au cours du processus si on veut que ce soit plus réaliste ? 
- les cas urgens ne sont pour l'instant pas pris en compte dans la consultation (shockroom, mais après ?)
- pourquoi patient state et pas roomstate dans ce cas ? 
- pourquoi pas execute() dans Arr ? 
- il faudra peut-être voir si ce n'est pas plus simple d'intégrer freenurse, physician et freepatient à la classe endevent ? Et faire de même pour les pièces et équipements ? 
- J'ai changé les états du patient par ceux qui sont décrits dans l'énoncé (en vist/test/consultations, ...), mais ça me parait moins simple, à voir comment on fait 
- Le système de prix n'est pas encore fait -> attribut pricetopay dans patient ? 
- Je vois 2 solutions pour le résultat d'un examen, qu dans tous les cas, est envoyé au médecin (observer pattern)
	- On prépare des énumérations comme pour la consultation (c'est ce qu'il avait eu l'air de dire quand je lui ai posé la question en cours ...)
	- On n'a pas besoin de savoir quel est le résultat, il est renvoyé au médecin ??? Je tente ça pour l'instant. 

- Je ne me rappelle plus ce qu'on avait dit à propos des pièces pour les healthservices ... pour l'instant je fais appel au service, là où c'était la pièce pour la consultation/installation
- J'ai commencé ma fonction de trie, elle fonctionne à partir du moment où on récupère le patient dans l'événement
- Je suppose pour l'instant que suite à la consultation, le patient est transporté (5minutes): 
	soit vers la sortie
	soit vers les salles d'attentes d'exam
- pour que ce soit plus simple, je rajoute un attribut nexstep à un patient
- il faut remettre des exceptions un peu partout dans l'ED, mais je ne comprends pas du tout ce que tu as fait pour l'instant avec les exceptions donc je ne touche aps tout de suite 
- je fais le système de couts => Il faut peut-être revoir ceux fixés pour l'instant : 100€ l'examen, 30€ la consultation, 5€ le transport en strecher ? On doit rajouter le prix d'une éventuelle érrivée en ambulance ? ATTENTION, je m'arrête au mileiu de ce que j'ai fait, 



-------------


Je met la fonction calculoutput plutot dans la class physician en l'appelant prescribeExam pour coller mieux à l'énoncé.

J'ajoute les services manquant à la liste des output possible
Je dois changer les proba de output (je fais ça vite il faudra re-réfléchir à la pertinence de  celles ci)

pour une première version un patient n'est pas obligé de voir le même médecin à chaque fois, j'enlève donc la liste PatientBeeingOverseen de la classe physician

Je mets consultation comme nextstep initial des patient comme ils doivent de toute manière commencer par une consultation

La condition pour enable un event transportation doit être de trouver un patient dans une boxroom ou shock avec un nextstep != consultation

Je rajoute à ton event exam, la fonction qui dirige le patient vers la file d'attente suivante en fonction de l'output de l'exam


Je pense que l'on a toutes les fonctionnalités de base du  core system (même s'il en manque pleins ! Genre utiliser les loi de probas, le calcul du cout, le système observer etc...)
Je commence à coder la partie deux simulation, et on fera tous les ajouts de fonctionnalité demandés dans l'énoncé ou non par la suite pour rendre la simulation plus réaliste


Je crée une nouvelle class EnabledEvents dans la partie simulation pour rassembler toutes les méthodes liées à cette liste

Dants la méthode timeManager.startSimulation :   On crée une copie de l'ed initial, et on retourne son état final, ça permet de pouvoir faire plusieurs simulation sur le même ED en changeant quelques paramètres (on ne fait pas de changement directement sur l'ed) 


_______________________________


Il ne faut pas que la création d'un évènement renvoit une exception sinon ça fait une erreur de compilation lorsque que l'on veut faire d'autre choses avec cette évènement (comme le programme n'est pas sur que l'évènement a bien été créé à cause du try/catch) il faut donc aboslument gérer tes exceptions de lois normale au sein de l'évènement.



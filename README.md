# Software-SimErgy-
CARNET DE BORD (je propose qu'on garde ce doc pour le compte-rendu ensuite)
Rq : 
- l'id d'une ressource devrait �tre g�n�r�e automatiquement (de fa�on � �tre unique)
- il faudrait faire un test Gunit de toutes les classes cr��es
- je cr�e une class id generator qui permet de cr�er un id unique pour chacune des ressources d'un ED. C'est un singleton partern (mais un peu modifi� parce que les deux premiers chiffres de l'id permettent de connaitre le type de ressource)


- Jamais de to string ? 
- HR : il faut generer des ID automatiques aussi non ? les mettre en 20, puis diff�rencier nurse, physician, transporter ? 
Pas de Test pour les abstract class (HR, ...) -> je vais bouger mon test HR, mais je dois y aller l�
- pourquoi NHR est une interface, et HR une abstract class ? 
- pourquoi des num�ros pour les �tats, �a complique tout non ?

- j'enl�ve le setId pour tout le monde, �a n'a pas de sens de la garder � mon avis, si on veut vraiment un id unique il ne faut pas qu'on donne la possibilit� de le changer.

11/11/2017. 
Benoit

- J'ai chang� le fonctionnement de l'id generator, il marche normalement maintenant. A noter : j'ai chang� la mani�re dont sont not�s les id pour des raisons pratiques ils commencent tous par un chiffre strictement sup�rieur � 0. Je pense que c'�tait pas forc�ment n�cessaire de faire tout �a mais bon maintenant que c'est fait autant s'y tenir !
 
 
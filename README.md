# Software-SimErgy-
CARNET DE BORD (je propose qu'on garde ce doc pour le compte-rendu ensuite)
Rq : 
- l'id d'une ressource devrait �tre g�n�r�e automatiquement (de fa�on � �tre unique)
- il faudrait faire un test Gunit de toutes les classes cr��es
- je cr�e une class id generator qui permet de cr�er un id unique pour chacune des ressources d'un ED. C'est un singleton partern (mais un peu modifi� parce que les deux premiers chiffres de l'id permettent de connaitre le type de ressource)


- Jamais de to string ? 
- Je rajoute un pr�fixe pour l'ID des patients, tu ne l'avais pas fait je crois ?
- J'ai du mal � voir l'int�ret d'un JUNite dans le cas de la cr�ation d'une room ou d'un patient ? Du coup je fais un test classique pour l'instant. Ah si, je crois que j'ai trouv� pour la BoxRoom et le patient 
- HR : il faut generer des ID automatiques aussi non ? les mettre en 20, puis diff�rencier nurse, physician, transporter ? 
Pas de Test pour les abstract class (HR, ...) -> je vais bouger mon test HR, mais je dois y aller l�
- pourquoi NHR est une interface, et HR une abstract class ? 
- pourquoi des um�ros pour les �tats, �a complique tout non ? 
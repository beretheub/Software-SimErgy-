# Software-SimErgy-
CARNET DE BORD (je propose qu'on garde ce doc pour le compte-rendu ensuite)
Rq : 
- l'id d'une ressource devrait être générée automatiquement (de façon à être unique)
- il faudrait faire un test Gunit de toutes les classes créées
- je crée une class id generator qui permet de créer un id unique pour chacune des ressources d'un ED. C'est un singleton partern (mais un peu modifié parce que les deux premiers chiffres de l'id permettent de connaitre le type de ressource)


- Jamais de to string ? 
- Je rajoute un préfixe pour l'ID des patients, tu ne l'avais pas fait je crois ?
- J'ai du mal à voir l'intéret d'un JUNite dans le cas de la création d'une room ou d'un patient ? Du coup je fais un test classique pour l'instant. Ah si, je crois que j'ai trouvé pour la BoxRoom et le patient 
- HR : il faut generer des ID automatiques aussi non ? les mettre en 20, puis différencier nurse, physician, transporter ? 
Pas de Test pour les abstract class (HR, ...) -> je vais bouger mon test HR, mais je dois y aller là
- pourquoi NHR est une interface, et HR une abstract class ? 
- pourquoi des uméros pour les états, ça complique tout non ? 
To Do List :
	-Faire des tests unitaire
	-Faire la javadoc
	
	
	

	
Joueur string nom, (List<Personnage>)

choix : - mettre dans la base de données les différents personnages en fonction de leur type (personnagecac, personnageDistant, personnageHeal)
BDD -> tous les personnages, un attribut type (personnagecac, personnageDistant, personnageHeal). la classe personnagecac va chercher dans la bdd les personnages ayant pour attribut personnagecac.

Base de données : niveau , (stuff)

CaseEffectStrategy peut avoir les strategy fire et ice par exemple et lorsque le personnage passe dessus où est dessus au moment de l'effet, celui-ci va s'appliquer
CharacterEffectStrategy va avoir les strategy fire et ice egalement mais ici l'effet va s'appliquer durant un laps de temps sur le personnage


Pourrait etre mieux de faire une boucle qui gère une action de tout les personnages pendant cette boucle et un sleep à la fin

Comment marche le modèle MVC?
    Soit : model -> interaction BDD et la map (case[][]) observable
           vue -> uniquement les éléments d'affichable observer
           controleur -> gestion entre les deux



Comment gérer l'alternance attaque et déplacement?
    Créer un ActStrategy qui détermine par exemple si le personnage décide d'abord d'attaquer et apres de bouger ou inversement et dont attaquer et bouger dépend de sa stratégie


act strategy different pour defense et character

calculé la distance en fonction du centre de l'entité


Laisser les attributs important et mettre les secondaires dans une liste d'attributs.


Stratégie des monstres qui attaquent tout de suite le nexus :
Au début de la partie et à chaque fois q'une défense est posé, le calcul de chemin est effectué
Les flèches sont mises pour chaque cases et le monstre vérifie toutes les cases sur lesquels il passe pendant sa moveStrategy pour s'avoir dans quelle direction aller.

Stratégie des monstres qui attaquent l'ennemi le plus proche :
On met des chiffres autour de la première défense sur chaque case, ce chiffre augmentant en foncion de la distance par rapport à la défense.
Lorsqu'une nouvelle défense est posé, les chiffres sont recalculés à partir de cette nouvelle défense et remplacer sur les cases si le chiffre pour la nouvelle défense est inférieur.
Le monstre suivra les chiffres les plus petits.

S'il n'y a pas de numéro il suit les flèches et des qu'il y a des numéros on les suit
Numéroter toutes les cases avec un numéro indiquant la distance jusqu'au nexus
Indiquer le distance avec un int la séparant du héros
Une liste contenant toutes les défenses à moins de 10 cases de rayons par exemple trier par ordre croissant.

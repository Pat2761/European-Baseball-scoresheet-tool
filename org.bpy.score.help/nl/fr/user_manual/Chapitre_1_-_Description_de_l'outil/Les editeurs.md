### les éditeurs

Les éditeurs de la plateforme « Eclipse » sont dédiés à l’édition et peuvent se représenter sous différentes formes, les deux principales étant les éditeurs graphiques ou des éditeurs de texte qui respecte la structure d’un langage, c’est-à-dire une association d’une grammaire et d’un vocabulaire. Dans le cas de cette application, il existe deux éditeurs basés sur un langage permettant de décrire un club ou un match. La description de ces deux langages va être faite dans le troisième chapitre. 
Les éditeurs Eclipse basés sur du texte disposent de fonctionnalités permettant d’aider la saisie. Parmi ces mécanisme, on retrouve :

•    **La coloration syntaxique** :  Les mots clefs dans l’éditeur sont colorés. Ainsi une chaine de caractère ou un nombre sera différente. 

![Example of coloration syntaxique](E:\Perso\Dev\Download\perso\projet\Statcrew3\org.bpy.score.help.parent\org.bpy.score.help\nl\fr\Manuel_utilisateur\Chapitre_1_-_Description_de_l'outil\images\Editor_1.jpg)

Dans l’éditeur de match, une avance ou un retrait n’aura pas la même couleur, on peut donc compter facilement le nombre retrait en comptant les codes rouges comme dans l’exemple suivant

![Exemple de coloration syntaxique](E:\Perso\Dev\Download\perso\projet\Statcrew3\org.bpy.score.help.parent\org.bpy.score.help\nl\fr\Manuel_utilisateur\Chapitre_1_-_Description_de_l'outil\images\Editor_2.jpg)

L’utilisateur s’apprête à saisir le troisième batteur dans l’ordre du lineup. Il utilise alors la combinaison de touche <CTRL><ESPACE> et va obtenir la fenêtre suivante qui va lui permettre  de choisir un joueur dans une liste

![Aide à la saisie](E:\Perso\Dev\Download\perso\projet\Statcrew3\org.bpy.score.help.parent\org.bpy.score.help\nl\fr\Manuel_utilisateur\Chapitre_1_-_Description_de_l'outil\images\ContentAsists.jpg)

Il lui suffit alors de sélectionner le joueur dans la liste pour que la ligne s’écrive automatiquement dans la description du lineup

![Résultat du content assist](E:\Perso\Dev\Download\perso\projet\Statcrew3\org.bpy.score.help.parent\org.bpy.score.help\nl\fr\Manuel_utilisateur\Chapitre_1_-_Description_de_l'outil\images\ContentAsistsResult.jpg)

Le curseur est positionné sur la première information manquante, celle de la position défensive qui doit être renseignée.

•    L’affichage des erreurs ou avertissements : Eclipse permet de contrôler la cohérence de la saisie, les erreurs dans la grammaire ou le vocabulaire. La signalisation d’une erreur est faite par une croix rouge et l’avertissement est déclaré par un triangle jaune. Les erreurs sont des erreurs qui bloque l’analyse du fichier concerné, elles doivent être impérativement corrigées, par contre, les avertissements sont erreurs potentielles, mais le fichier est valide. 

L’erreur suivante dit que deux joueurs de la même équipe sont en position d’arrêt en même temps. L’éditeur affiche une croix rouge dans la marge et souligne l’endroit où se situe l’erreur. En cliquant sur la croix rouge, l’éditeur donne une explication sur la cause de l’erreur.

![repérage des erreurs](E:\Perso\Dev\Download\perso\projet\Statcrew3\org.bpy.score.help.parent\org.bpy.score.help\nl\fr\Manuel_utilisateur\Chapitre_1_-_Description_de_l'outil\images\ErrorMarkers.jpg)

•    Le Undo-Redo (défaire ou refaire) : Ce mécanisme permet de mémoriser les saisies que vous avez effectué pour revenir en arrière ou refaire ce vous avez défait. 

•    Les raccourcis clavier : Les raccourcis clavier vont vous aider pour la saisie des matches ou des clubs. Le <CTRL><ESPACE> est un exemple de raccourci, mais il en existe d’autres comme le <CTRL><Z> pour la fonction ‘Undo’ et <CTRL><Y> pour la fonction ‘Redo’. On peut aussi sauvegarder la saisie d’un fichier en faisant un <CTRL><S>.

•    Les ‘Quick-Fix’ : les quick-fix sont liés aux erreurs et aux avertissements. Ils permettent de proposer des solutions pour corriger des erreurs ou des avertissements. Pour le moment, les quick-fix ne sont pas implémentés dans l’application

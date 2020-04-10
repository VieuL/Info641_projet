# Info641_projet

Objectifs d’apprentissage: 
Maîtriser le mécanisme de communication par événements, et s’initier aux interfaces graphiques.


Problème proposé.Un grand laboratoire de physique comporte plusieurs risques liés aux :
• incendies qui peuvent surgir dans chacun des bâtiments qui le composent,
• émission des radiations,
• émission des gaz toxiques.Le service de sécurité du laboratoire veutmettre un system de capteurs lui permettant de détecter des incendies, réfrigération défectueuse, radiation ou émission des gaz au dessus desseuils de sécurité.La décision est prise d’utiliser un système à évènements.Les capteurs sont spécifiques à chaque risque mentionné et génèrent des alarmes concernant les anomalies. Pour toutes les anomalies, on indique la date de l’apparition, la localisation etle niveau d’importance (variant de 1 à 3).En plus de ces informations: 
• Pour l’émission de gaz il faut indiquer le type émis (hydrogène, hélium, CO2, etc.).
• Pour les radiations il faut indiquer le niveau de radiation (variant entre 1 et 100).Le système de sécurité veut mettre en place différents types de moniteurs dans ses salles de contrôle.
• Les moniteurs de type A sont capables de gérer des alarmes de type gaz et feu (destinésaux pompiers).• Les moniteurs de type B sont capables de gérer des alarmes de type gaz et radiation(service environnement).

# CS108-Final-Exam
Kevin Uy
822725716
05/14/20
This program does a very simple simulation of a battle between two teams, and as one team starts to win, they gradually
become more likely to win the following battles.
It emulates the style of League of Legends, an online MOBA game.
Champion is used to create Champion objects with a name, role, and damage type. Each of these objects is created with a level of one.
TeamBuilder handles the methods to create each team, and contains the bodies of the methods for deciding which team wins.
GameSimulator handles the simulation of the game, and prompts the user for input to start a game, or search for a specific champion within the database.
Teamfight has the method handles for the fight calculations, and passes them to TeamBuilder.
UnitTests was supposed to hold the unit tests for the methods, but I had a lot of trouble coming up with unit tests for my methods, and I ran out of time.

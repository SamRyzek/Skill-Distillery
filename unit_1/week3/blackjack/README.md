### Blackjack

#### Application Overview

Use classes to create a functional command line blackjack game. Leave the game's functionality until the end, first get the class structure figured out. From here you can implement methods and fields to store data you think you would need during a blackjack game. If you are unfamiliar with the rules take a look [here][wiki]!

Included is a [basic UML document](BlackjackUML.png). The UML provided is a starting point. You will need to expand upon it to not only get a working game, but also to meet our expectations in the rubric. We have also provided you with a [getting started](gettingStarted.md) document for a little additional guidance on the classes and methods you will need to create in this project. Give it a try just using the user stories below and if you hit a wall use this document as a resource to help your progression. Trying this on your own regardless of if it blows up will be beneficial to you!

#### Learning Objectives
Below are a list of objectives that we see the blackjack programing reinforcing.

* Getting comfortable building classes in an Object Oriented manner.  
* Building classes whose fields are Objects.  
* Practice writing methods.  
* Use collection types to organize and manage data.  
* Use conditionals to create game logic.  

#### Project Requirement #0
You'll push your project to a Github repo named BlackJackProject.  Be sure to include a `README.md`.

#### User Story #1
Create a class structure that mimics a deck of cards. Remember decks as well as a hand of cards are made up of cards. Feel free to create the structure in any way you see fit. *hint We did a lab in Chapter 6 of this week that dealt with a deck of cards.*

Your card and deck implementations should NOT be coupled to Blackjack; you should be able to reuse them to implement a poker or bridge game application.

#### User Story #2
Add methods and fields to your classes that mimic the functionality of shuffling and dealing a deck of cards. Remember that when a card is dealt you have to remove it from the current deck! You should be able to print out a shuffled deck to the terminal.

#### User Story #3
Deal two hands of cards - one to a Dealer and another to a Player. Allow the players to Hit (add cards to their hand) or Stay (not add cards to their hand) in accordance to the rules of blackjack shown in the [wiki][wiki]. Do not worry about the multiple values for Ace until your basic game logic is working. Assume they are either 1 or 11 to start.

#### User Story #4
Implement the remaining rules of blackjack so you can determine a winner of each round.

#### Stretch Goals
Try as many of these as you like, but ONLY after you've completed, tested, and COMMITTED your working game that meets the requirements.

* Allow multiple players in the game.

* Implement a monetary system so players can place bets on their hands.  

* Allow players to split hands.

* Allow players to double down.

* Deal from a multi-deck shoe.

* Keep going!  How about implementing in-game suggestions based on the player's current hand?  Maybe a card-counting player?  

### Grading
This is a graded project. You are expected to have your project completed by the start of class on Monday morning.

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

* Your program must **NOT** be contained in one procedural main(). You **MUST** design a OO class structure.  

* When the game begins both the player and dealer are dealt two cards.  

* If a player or dealer is dealt 21 the game is over. Otherwise the player can choose to hit or stay.  

* Once the player has completed their turn the dealer will begin their turn.  

* The game is immediately over if either player gets above 21.  

If the project does work with all of the above test conditions, you will be given a 1 for this week's project.

If the project does not work with the above test conditions, you will be given a 0 for this week's project.

If you get a zero on the project, you can upgrade to a score of .5 if you turn in a working project by the start of class on the following Monday morning AND notify an instructor that you wish to get partial credit.

To turn in a project, you must push it to GitHub. You must include a README.md that describes how to run your program. Include an overview of the class structure you chose to use.

[wiki]: https://en.wikipedia.org/wiki/Blackjack
[shuffle]:https://docs.oracle.com/javase/6/docs/api/java/util/Collections.html#shuffle(java.util.List)

## Ball Sort Puzzle Solver
A Kotlin application to automatically solve the [Ball Sort Puzzle](https://play.google.com/store/apps/details?id=com.GMA.Ball.Sort.Puzzle&hl=it) game for Android.

### Project Status
This project is still under active development, but it has already reached a stable stage. I have been able to verify and successfully resolve all the original 300 levels of the game, and it should be easy enough to extend it for more levels and colors. 

### Screenshot
![Ball Sort Puzzle Solver running in the terminal](https://i.imgur.com/OwJST9X.gif "Ball Sort Puzzle Solver running in the terminal")

### Installation and Setup Instructions

You will need [Maven](https://maven.apache.org/install.html) installed and configured onto your machine.

Cloning the repository:
1. Run `git clone https://github.com/CianciuStyles/ball-sort-puzzle-solver.git` in the terminal  

Installation:
1. Run `mvn clean install` in the terminal  

To run the test suite:  
1. Run `mvn test` in the terminal  

To run Ball Sort Puzzle Solver:
1. Change the board declaration in `main.kt` to reflect the initial configuration of the level you are trying to solve. A valid declaration is made of:
    - One line per stack, plus one or two empty lines for the empty stacks
    - Each line made of one letter per color (take the `Color` enum as reference) 
1. Run `mvn clean compile` in the terminal to re-compile the project.
1. Run `mvn exec:java` in the terminal to run the solver.

### Motivation
I have started playing Ball Sort Puzzle and after the first levels had gone quite smoothly, I quickly ran into some harder levels which I was not able to solve by myself.
Rather than simply looking for a walkthrough on the Internet, I decided to implement a program that could (hopefully) solve any level, present or future, of the game.
  
The main algorithm used in the implementation of this solver is the [A* search algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm), which is widely used in graph traversal and search problems. The heuristic function I have come up with to estimate how far away a state is from the final configuration should be able to provide the optimal solution, i.e. the one requiring the least amount possible of steps to complete the level. 

### Future work and improvements
- [ ] Provide a GUI to input the level configuration
- [ ] Provide a GUI to show the required steps to complete the level
- [ ] Add more search algorithms to solve the levels
- [ ] Expose Ball Sort Puzzle Solver as-a-Service over REST or GraphQL
- [ ] Make it control an Android phone directly to:
    - [ ] take a screenshot of the initial level configuration
    - [ ] perform the steps to complete the level automatically
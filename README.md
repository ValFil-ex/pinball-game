# Pinball-game - console simulation 

## Study project - Pinball game simulation as a design patterns exercise

**_See UML_Class_Diagram file for code structure reference._**

### LANGUAGE: Java

### PATTERNS:

- Singlton - to initialise GameController & Playfield
- State pattern - to toggle states in CurrentGame (Gamestates package)
- Command pattern - to assign commands  when a ball hits some element; invoker: ball -> concrete command: action object (e.g.
   HitBumper) -> receiver: playfield element (e.g. bumper)
- Composite patters - to build more complex command (together with command pattern). E.g. HitBumper launched OpenRamp and ScoreBumperPoints
- Visitor pattern: ElResetVisitor - to reset elements when new round is started(e.g. close ramp); CountResetVisitor - to reset a count of how many 
  times each element was hit when new game begins (new level); ScoreVisitor - to calculate total score based on hit count and points of each 
  element.  


### SAMPLE ACTIONS:

- hit bumper: 200 points
- hit target 1st time: 400 points and open ramp
- hit ramp: if closed - 0 points; if open (by hitting the target) - 150 points. Once open, remains open until game over (4 balls)

### GAME RULES:
- a game (3 balls + 1 super game) costs 1 credit
- 3 balls can be lost in the initial round;
- after 3 balls lost - super game with just one ball begins;
- if total points after super game > 10 000 -> super game is won - 1 extra credit is added and player goes to next level (score reset, playfield 
  reset)
- if total points after super game <10 000 -> game over (elements reset, score persists)
- player can buy a credit (or use existing credit) to continue the game and try to win it (reach 10 000 points)
 

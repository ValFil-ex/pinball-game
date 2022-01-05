# pinball-game
SAD exercise

Pinball game simulation as design patterns exercise

PATTERNS:

- Singlton - to initialise GameController & Playfield
- State pattern - to toggle states in CurrentGame (Gamestates package)
- Command pattern - to assign commands  when a ball hits some element; invoker: ball -> concrete command: action object (e.g.
   HitBumper) -> receiver: playfield element (e.g. bumper)
- Composite patters - to build more complex command (together with command pattern). E.g. HitBumper launched OpenRamp and ScoreBumperPoints


SAMPLE ACTIONS:

- hit bumper: points
- hit target 1st time: 400 points and open ramp
- hit ramp: if closed - 0 points; if open (by hitting the target) - 150 points. Once open, remains open until game over (4 balls)
 

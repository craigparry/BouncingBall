
Hey this is a readme for BouncingBallGame.java

How to use the file: 
The entry point to the game is teh BouncingBallGame.java 
file. It is packaged in a jar that can be run without any 
arguments. When the ball is played it cannot bounce against
the walls three times in a row without traveling over a covered 
tile. The score increments by 10 every time the ball touches a 
covered tile. The game must be reset to continue playing 
after the ball touches three consecutive walls and the score 
is cumulitive throught the resets. 

Description: 
The gameboard is made of a 2d array that holds covered 
and uncovered tile objects. 

The ball object has the current position of the ball 
and the size as properties(should be updated by the GUI animation timer)

The GUI layout is a BorderPane with the game canvas inside the middle
and another BorderPane located at the bottom with the button and label 
containing reset, play, and the score at the center, left and right of that pane 
and my slider will go at the bototm of the canvas.   

The canvas draws the game board, the tiles and the 
ball on the GUI
-Add and action event to the reset button and play button
-Add the logic for keeping score of the game. 
- need a game state on the board
  when the game state is new game. reset button is disabled and play button enabled
  when the play button is clicked start the animation, change state
  when the ball hits three walls without a yellow block hit
  then game over
  must not be able to click the ball and move it after it has been clicked 
- ball must stay within the bounds of the board, if it hits the edge then 
  the ball must reverse direction on that plane 


  
Bugs: 
The ball sometimes does not register when it moves over 
the edges of the tile. 
The ball is a little bit faster the more the angel is increased at this point. 
May not have time tonight to fix the math with that. 

Craig Parry.
Hey this is a readme for BouncingBallGame.java

The gameboard is made of a 2d array that holds covered 
and uncovered tile objects. 

The ball object will have the current position of the ball 
and the size as properites(should be updated by the GUI timer)

The GUI layout is a BorderPane with the game canvas inside the middle
and another BorderPane located at the bottom with the button and label 
containing reset and the score at the center left and right of that pane 
and my slider will go at the top of that pane.  


TODO- I need to make a slider to add to my GUI
-figure out how to draw and move the ball along
 a random trajectory using the timer and repainting 
 the canvas every time the timer updates. 
- 
-Add and action event to the reset button
-Add the logic for keeping score of the game. 
- need a game state on the board
  when the game state is new game. reset button is disabled 
  when the ball is clicked start the animation, change state
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

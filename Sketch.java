//importing things to make this work (processing and images )


import processing.core.PApplet;
import processing.core.PImage;



//class for game 
public class Sketch extends PApplet {

//initialising some variables for mouse,snow, snow piles and a rudementery timer 
PImage img;
boolean running = true;
int num1 = 50;
int num2 = 50;
int num3 = 50;
int num4 = 50;
int num5 = 50;
int num7 = 50;
int []  Rectangle1 = new int [num1];
int []  Rectangle2 = new int [num2];
int []  Rectangle3 = new int [num3];
int []  Rectangle4 = new int [num4];
int []  Rectangle5 = new int [num5];
int timer = 0;
int[] x = new int[num7];
int[] y = new int[num7];
float[] circleY = new float[25];
int speed = 1;


//screen size 
public void settings(){
  size (400,400);
  }
	
	
//getting imafe and for loop for the snow fall
public void setup() {
img = loadImage("doug2.png");

  noStroke();
  fill(255, 102);

  for (int i = 0; i < circleY.length; i++) {
    circleY[i] = random(height);
  }
}


//draw method where the whole game takes place 

public void draw() {



  background(0);
  // Shift the values to the right
  for (int i = num7-1; i > 0; i--) {
    x[i] = x[i-1];
    y[i] = y[i-1];
  }
  // Add the new values to the beginning of the array
  x[0] = mouseX;
  y[0] = mouseY;
  
  // Draw ford
  for (int i = 0; i < num7; i++) {
    image(img, mouseX, mouseY);
  }


  //change colours and also to generate the visual snow and piles, this is the main for loop where the whole game takes place
    for (int i = 0; i < circleY.length; i++) {
    float circleX = width * i / circleY.length;
    if (keyPressed){

      //red snow 
     if (key == 'r') {
    fill(255,0,0);
      }
    //pink snow 
     else if (key == 'p') {
    fill(226, 182, 242);
      }

    //yellow snow 
     else if (key == 'y') {
    fill(255,200,0);
      }

    //changeing the snow colour to white 
     else if (key == 'w') {
    fill(255,255,255);
      }
    }
    ellipse(circleX, circleY[i], 5, 5);

    circleY[i] = circleY[i] + speed;

//first bracket for the snow to pile up
    if (circleY[i] > 390 && circleX <= 80) {
      circleY[i] = 0;
          Rectangle1[i]++;


      }

    //second bracket
    else if (circleY[i] > 390 && circleX >= 80 && circleX <= 160) {
      circleY[i] = 0;
          Rectangle2[i]++;

      }

    //third brakcet 
      else if (circleY[i] > 390 && circleX >= 160 && circleX <= 240) {
      circleY[i] = 0;
          Rectangle3[i]++;

      }

    //fourth brakcet for snow 
      else if (circleY[i] > 390 && circleX >= 240 && circleX <= 320) {
      circleY[i] = 0;
          Rectangle4[i]++;

      }
    //final bracket 

      else if (circleY[i] > 390 && circleX >= 320 && circleX <= 400) {
      circleY[i] = 0;
          Rectangle5[i]++;

      }


 

// all these if and else if statemets remove the snow from those brackets 
  if (mouseX <= 80 && mousePressed){
        Rectangle1[i]--;


    }
  else if (mouseX > 80 && mouseX <= 160 && mousePressed){
        Rectangle2[i]--;


    }
  else if (mouseX > 160 && mouseX <= 240 && mousePressed){
        Rectangle3[i]--;


    }
  else if (mouseX > 240 && mouseX <= 320 && mousePressed){
        Rectangle4[i]--;


    }
 else  if (mouseX > 320 && mouseX <= 400 && mousePressed){
        Rectangle5[i]--;


    }


  




//generating the piles of snow 

rect( 0, 400, 80, Rectangle1[i] * -1 );
rect( 80 , 400, 80, Rectangle2[i] * -1 );
rect( 160, 400, 80, Rectangle3[i] * -1 );
rect(240, 400, 80, Rectangle4[i] * -1 );
rect( 320, 400, 80, Rectangle5[i] * -1 );



//rudementery timer that has been afformentioned earlier as well as a loss threshold which will close the game 
  timer = i;


  if (Rectangle1[i] >= 400 || Rectangle2[i] >= 400 || Rectangle3[i] >= 400 || Rectangle4[i] >= 400 || Rectangle5[i] >= 400){
    running = false;
    if (running == false ){
      System.out.println("you lose ");
      break;
    }
  }

  //difficulty increases , a win and it automaticlly closes the game upon win/ loss 

    if  (timer >= 10){
    speed = 2;
    }
    else if (timer >= 20){
    speed = 4;
    }
    else if (timer >= 30){
    speed = 12;
    }
    else if (timer >= 40){
    speed = 22;
    }
    else if (timer >= 60){
    System.out.println("your did it");
    break;   
      }

    if (timer >= 60){
      break;
    }
    }
  }
}

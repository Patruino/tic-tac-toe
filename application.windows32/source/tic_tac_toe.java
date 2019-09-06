import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tic_tac_toe extends PApplet {

int[] grid =  {0, 0, 0, 
  0, 0, 0, 
  0, 0, 0};
int[] licznik = new int[2];
int runda = PApplet.parseInt(random(0, 2));
boolean gra = true;


public void setup() {
  
  background(100);
  siatka();
}

public void draw() {
    punkty();
  win();

}
public void siatka() {
  strokeWeight(5);
  stroke(0);
  for (int i = 0; i<4; i++) {
    line(0 + i * width/3, 0, 0 + i * width/3, 600);
    line(0, 0 + i * width/3, width, 0 + i * width/3);
    //textSize(200);
    //fill(0);
    //text("RESET", 0, height);
  }
}
public void mousePressed() {
  if (gra) {
    for (int x = 0; x<3; x++) {
      for (int y = 0; y<3; y++) {
        int index = x + y * 3;
        if (mouseX > x * 200 && mouseY > y *200 && mouseX < x * 200 + 200 && mouseY < y * 200 + 200) {
          if (grid[index] == 0) {
            println(x + "   " + y);
            strokeWeight(10);
            if (runda == 0) {
              noFill();
              stroke(255, 0, 0);
              circle(x * 200 + 100, y * 200 + 100, 180);
              grid[index] = 1;
              runda = 1;
            } else {
              stroke(0, 0, 255);
              line(x * 200 + 10, y * 200 + 10, x * 200 + 200-10, y * 200 + 200-10);
              line(x * 200 + 200 - 10, y * 200 + 10, x * 200 + 10, y * 200 + 200-10);
              grid[index] = 2;
              runda = 0;
            }
          }
        }
      }
    }
  }

  if (mouseY>600) {
    background(100);
    siatka();
    for (int i = 0; i<9; i++) {
      grid[i] = 0;
    }
    gra = true;
  }
}
public void win() {
  //kolo
  if(gra){
  if (grid[0] == 1 && grid[1] == 1 && grid[2] == 1 ) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(50, 100, 550, 100);
    gra = false;
  }
  if ( grid[0] == 1 && grid[3] == 1 && grid[6] == 1) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(100, 100, 100, 550);
    gra = false;
  } 
  if ( grid[0] == 1 && grid[4] == 1 && grid[8] == 1 ) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(50, 50, 550, 550);
    gra = false;
  } 
  if ( grid[2] == 1 && grid[5] == 1 && grid[8] == 1 ) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(500, 50, 500, 550);
    gra = false;
  } 
  if ( grid[6] == 1 && grid[7] == 1 && grid[8] == 1 ) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(50, 500, 550, 500);
    gra = false;
  } 
  if ( grid[2] == 1 && grid[4] == 1 && grid[6] == 1 ) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(50, 550, 550, 50);
    gra = false;
  } 
  if ( grid[1] == 1 && grid[4] == 1 && grid[7] == 1 ) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(300, 50, 300, 550);
    gra = false;
  } 
  if ( grid[3] == 1 && grid[4] == 1 && grid[5] == 1) {
    licznik[0]++;
    strokeWeight(40);
    stroke(0);
    line(50, 300, 550, 300);
    gra = false;
  }

  //krzyzyk

  if (grid[0] == 2 && grid[1] == 2 && grid[2] == 2 ) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(50, 100, 550, 100);
    gra = false;
  }
  if ( grid[0] == 2 && grid[3] == 2 && grid[6] == 2) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(100, 100, 100, 550);
    gra = false;
  } 
  if ( grid[0] == 2 && grid[4] == 2 && grid[8] == 2 ) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(50, 50, 550, 550);
    gra = false;
  } 
  if ( grid[2] == 2 && grid[5] == 2 && grid[8] == 2 ) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(500, 50, 500, 550);
    gra = false;
  } 
  if ( grid[6] == 2 && grid[7] == 2 && grid[8] == 2 ) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(50, 500, 550, 500);
    gra = false;
  } 
  if ( grid[2] == 2 && grid[4] == 2 && grid[6] == 2 ) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(50, 550, 550, 50);
    gra = false;
  } 
  if ( grid[1] == 2 && grid[4] == 2 && grid[7] == 2 ) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(300, 50, 300, 550);
    gra = false;
  } 
  if ( grid[3] == 2 && grid[4] == 2 && grid[5] == 2) {
    licznik[1]++;
    strokeWeight(40);
    stroke(0);
    line(50, 300, 550, 300);
    gra = false;
  }
  }
}
public void punkty() {
  fill(170);
  strokeWeight(5);
  stroke(200,0,200);
  rect(0,605,width,height);
  textSize(100);
  fill(0, 0, 200);
  text(licznik[1], 50, 700);
  fill(200, 0, 0);
  text(licznik[0], 480, 700);
}
  public void settings() {  size(600, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tic_tac_toe" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

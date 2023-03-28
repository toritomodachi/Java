package 포트폴리오;
// important import statements  
import java.awt.image.BufferedImage;  
import java.awt.Graphics;  
  
  
public class Shape   
{  
  
// various fields of the class Shape  
private int color;  
  
private int x;  
private int y;   
  
private long time;  
private long lastTime;  
  
private int nrml = 600;  
private int fst = 50;  
  
private int del;  
  
private BufferedImage blk;  
  
private int[][] coordinates;  
  
private int[][] ref;  
  
private int delX;  
  
private Board brd;  
  
// if the tetromino is collided, then the flag is true, otherwise false  
private boolean isCollided = false;  
private boolean movX = false;  
  
public Shape(int[][] coordinates, BufferedImage blk, Board brd, int color)  
{  
// constructor for initializing the fields  
this.coordinates = coordinates;  
this.blk = blk;  
this.brd = brd;  
this.color = color;  
delX = 0;  
x = 4;  
y = 0;  
del = nrml;  
time = 0;  
lastTime = System.currentTimeMillis();  
ref = new int[coordinates.length][coordinates[0].length];  
  
System.arraycopy(coordinates, 0, ref, 0, coordinates.length);  
  
}  
  
public void update()  
{  
// statements for moving the Tetrominoes from top to bottom  
movX = true;  
time = time + System.currentTimeMillis() - lastTime;  
lastTime = System.currentTimeMillis();  
  
// if the collision is true, then the position of the tetromino that  
// has fallen down recently, should be fixed on the playing area of the board  
if(isCollided)  
{  
for(int r = 0; r < coordinates.length; r++)  
{  
for(int c = 0; c < coordinates[0].length; c++)  
{  
if(coordinates[r][c] != 0)  
{  
brd.getBoard()[y + r][x + c] = color;  
}  
}  
}  
  
// after the position of the recently fell tetromino is fixed  
// we will determine the current shape that is going to fall down  
// also we will check for the completed lines (or rows).   
checkLine();  
brd.setCurrShape();  
  
}  
  
  
  
// if we press the left arrow key or the right arrow key the  
// tetrominoes should move in the left or the right direction  
// In the if condition there are two sub conditions that are joined with &&  
// The first sub-condition is to check whether the tetrominoes is not going beyond the   
// right side boundary and the second sub condition is for the left side boundary  
// The following code snippet will not work if the flag isCollided is true  
if(!(x + delX + coordinates[0].length > 10) && !(x + delX < 0))  
{  
  
// if the falling tetromino has reached the bottom or has  
// collided with the other tetromino then the tetromino should not move  
// hence movX is false  
for(int r = 0; r < coordinates.length; r++)  
{  
for(int c = 0; c < coordinates[r].length; c++)  
{  
if(coordinates[r][c] != 0)  
{  
if(brd.getBoard()[y + r][x + delX + c] != 0)  
{  
movX = false;  
}  
  
}  
}  
}  
  
if(movX)  
{  
// if move x is true, then we can move the tetromino   
// in the left and the right direction  
x = x + delX;  
}  
  
}  
  
if(!(y + 1 + coordinates.length > 20))  
{  
  
for(int r = 0; r < coordinates.length; r++)  
{  
for(int c = 0; c < coordinates[r].length; c++)  
{  
if(coordinates[r][c] != 0)  
{     
if(brd.getBoard()[y + 1 + r][x +  c] != 0)  
{  
// if the control reaches here, then it means  
// the the falling tetromino has collided with the other   
// tetromino  
isCollided = true;  
}  
}  
}  
}  
  
if(time > del)  
{  
y = y + 1;  
time = 0;  
}  
}  
else  
{  
// if the control reaches here it means  
// the tetromino has collided with the bottom   
// area of the board  
isCollided = true;  
}  
  
delX = 0;  
}  
  
public void render(Graphics gr)  
{  
  
for(int r = 0; r < coordinates.length; r++)  
{  
for(int col = 0; col < coordinates[0].length; col ++)  
{  
if(coordinates[r][col] != 0)  
{  
// for drawing the image of the falling tetromino on the playing area  
gr.drawImage(blk, col * 30 + x * 30, r * 30 + y * 30, null);      
}  
}         
}  
  
for(int r = 0; r < ref.length; r++)  
{  
for(int c = 0; c < ref[0].length; c++)  
{  
if(ref[r][r] != 0)  
{  
gr.drawImage(blk, c * 30 + 320, r * 30 + 160, null);      
}     
  
}  
  
}  
  
}  
  
// a method that checks for the completed (rows or lines)  
// if it finds the completed rows / lines it deletes those lines.  
private void checkLine()  
{  
int size = brd.getBoard().length - 1;  
  
for(int i = brd.getBoard().length - 1; i > 0; i--)  
{  
int count = 0;  
for(int j = 0; j < brd.getBoard()[0].length; j++)  
{  
if(brd.getBoard()[i][j] != 0)  
{  
// computing the block count that  
// are filled with the tetromino  
count = count + 1;  
}  
  
brd.getBoard()[size][j] = brd.getBoard()[i][j];  
}  
if(count < brd.getBoard()[0].length)  
{  
// deleting the completed row or line  
size  = size - 1;  
  
}  
  
// if all the blocks of a row is filled with the   
// parts of tetrominoes, then we increment the score by 1  
if(count == brd.getBoard()[0].length)  
{  
brd.addScore();  
}  
}  
}  
  
// a method that handles the scenario, when we press the upward  
// key  
public void rotateShape()  
{  
  
int[][] rotatedShape = null;  
  
rotatedShape = transposeMatrix(coordinates);  
  
rotatedShape = reverseRows(rotatedShape);  
  
if((x + rotatedShape[0].length > 10) || (y + rotatedShape.length > 20))  
{  
return;  
}  
  
for(int row = 0; row < rotatedShape.length; row++)  
{  
for(int col = 0; col < rotatedShape[row].length; col ++)  
{  
if(rotatedShape[row][col] != 0)  
{  
if(brd.getBoard()[y + row][x + col] != 0)  
{  
return;  
}  
}  
}  
}  
coordinates = rotatedShape;  
}  
  
  
// The method comes into picture, when the up arrow is pressed  
// The method does transpose of the matrix  
private int[][] transposeMatrix(int[][] mtrx)  
{  
int[][] tmp = new int[mtrx[0].length][mtrx.length];  
for (int i = 0; i < mtrx.length; i++)  
{  
for (int j = 0; j < mtrx[0].length; j++)  
{  
tmp[j][i] = mtrx[i][j];  
}  
}  
return tmp;  
}  
  
  
// a method for reversing the rows of the matrix mtrx  
private int[][] reverseRows(int[][] mtrx)  
{  
  
int mdle = mtrx.length / 2;  
  
  
for(int i = 0; i < mdle; i++)  
{  
int[] tmp = mtrx[i];  
  
mtrx[i] = mtrx[mtrx.length - i - 1];  
mtrx[mtrx.length - i - 1] = tmp;  
}  
  
return mtrx;  
  
}  
  
  
// a method for retrieving the color  
public int getColor()  
{  
return color;  
}  
  
public void setDeltaX(int delX)  
{  
this.delX = delX;  
}  
  
// for speeding up the   
// falling speed of the tetrominoes  
public void speedUp()  
{  
del = fst;  
}  
  
// for normal falling speed of the tetrominoes   
public void speedDown()  
{  
del = nrml;  
}  
  
public BufferedImage getBlock()  
{  
return blk;  
}  
  
public int[][] getCoords()  
{  
return coordinates;  
}  
  
public int getX()  
{  
return x;  
}  
  
public int getY()  
{  
return y;  
}  
}  

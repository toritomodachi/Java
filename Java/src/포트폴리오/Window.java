package 포트폴리오;
// important import statement  
import javax.swing.JFrame;  
  
public class Window  
{  
  
// fields for width and height of the frame  
// these fields should never be changed knowingly or   
// unknowingly across the whole program. Hence, they   
// are declared as final  
public static final int WIDTH = 445;   
public static final int HEIGHT = 629;  
  
private Board boardObj;  
private Title titleObj;  
private JFrame windowFrame;  
  
public Window()  
{  
  
// creating an object of the class JFrame  
windowFrame = new JFrame("Tetris");  
// setting the width and height  
windowFrame.setSize(WIDTH, HEIGHT);  
  
// after pressing the x button the frame should close  
windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
windowFrame.setLocationRelativeTo(null);  
windowFrame.setResizable(false);      
  
// creating a new object of the class Board  
boardObj = new Board();  
// creating a new Title Object  
titleObj = new Title(this);  
  
// addinng the key listener  
windowFrame.addKeyListener(boardObj);  
  
// adding the mousemotion listener  
windowFrame.addMouseMotionListener(titleObj);  
  
// adding the mouse listener  
windowFrame.addMouseListener(titleObj);  
  
windowFrame.add(titleObj);  
  
// setting the visibility to true  
windowFrame.setVisible(true);  
}  
  
public void startTetris()  
{  
windowFrame.remove(titleObj);  
windowFrame.addMouseMotionListener(boardObj);  
windowFrame.addMouseListener(boardObj);  
windowFrame.add(boardObj);  
boardObj.sttGame();  
windowFrame.revalidate();  
}  
  
// main method  
public static void main(String[] argvs)   
{  
  
  
// creating an anonymous object of the class Window  
new Window();  
}  
  
}  

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;
import javax.swing.JFrame;
import java.util.*;


class point{
	
	double x,y;
	public point(double x ,double y) {
		this.x=x;
		this.y=y;
	}
}

class ThirdGLEventListener implements GLEventListener, KeyListener {
/**
 * Interface to the GLU library.
 */
private GLU glu;

/**
 * Take care of initialization here.
 */

	double x1=0;
	double y1=0;
	double x2=50;
	double y2=0;
	double x3=50;
	double y3=50;
	double x4=0;
	double y4=50;
	

public void init(GLAutoDrawable gld) {
    GL2 gl = gld.getGL().getGL2();
    glu = new GLU();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    
    
}

/**
 * Take care of drawing here.
 */
public void display(GLAutoDrawable drawable) {
	
	
	GL2 gl = drawable.getGL().getGL2();

    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
	
	//drawStar(drawable);
	//drawFloral(drawable);
	//drawNazzi(drawable);
    //drawBeforeClip(drawable);
    drawRec(drawable);   
    //clippingassignment(drawable);
       
    gl.glFlush();
    
}


public void drawBeforeClip(GLAutoDrawable drawable){
	GL2 gl = drawable.getGL().getGL2(); 
    
    int startx=0;
    int starty=100;
    
    drawLineDDA(gl,startx,starty,startx+1,starty);
    for(int i=1;i<50*2;i++) {
    	starty--;
    	drawLineDDA(gl,startx-i,starty,startx+1,starty);
    	drawLineDDA(gl,startx,starty,startx+1+i,starty);
    }
    for(int i=49*2;i>=1;i--) {
    	starty--;
    	drawLineDDA(gl,startx-i,starty,startx+1,starty);
    	drawLineDDA(gl,startx,starty,startx+1+i,starty);
    }
    
}

public void drawRec(GLAutoDrawable drawable){
	GL2 gl = drawable.getGL().getGL2(); 
    drawLineDDA(gl,x1,y1,x2,y2);
    drawLineDDA(gl,x2,y2,x3,y3);
    drawLineDDA(gl,x3,y3,x4,y4);
    drawLineDDA(gl,x4,y4,x1,y1);
}

public void drawStar(GLAutoDrawable drawable) {
	 	GL2 gl = drawable.getGL().getGL2();
	 
	    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
	    int x[] = new int[5];
	    int y[] = new int[5];
	    for(int i=0;i<5;i++) {
	    	x[i] = (int)(100*Math.cos((90+72*i)*Math.PI/180));
	    	y[i] = (int)(100*Math.sin((90+72*i)*Math.PI/180));
	    }
	    
	    
	    drawLineM(gl,x[0],y[0],x[2],y[2]);
	    drawLineM(gl,x[0],y[0],x[3],y[3]);
	    drawLineM(gl,x[1],y[1],x[4],y[4]);
	    drawLineM(gl,x[1],y[1],x[3],y[3]);
	    drawLineM(gl,x[4],y[4],x[2],y[2]);
}



public void drawFloral(GLAutoDrawable drawable) {
	
	GL2 gl = drawable.getGL().getGL2();	 
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
	midPointCircle(gl,0,0, 140);
 
    int cx[] = new int[8];
    int cy[] = new int[8];
    for(int i=0;i<8;i++) {
    	cx[i] = (int)(70*Math.cos((45*i)*Math.PI/180));
    	cy[i] = (int)(70*Math.sin((45*i)*Math.PI/180));
    	midPointCircle(gl,cx[i],cy[i], 70);
    }
}


public void drawNazzi(GLAutoDrawable drawable) {
	GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    drawLineDDA(gl, -100, 100, 100, -100);
    drawLineDDA(gl, -100, 100, 0, 200);
    drawLineDDA(gl, 0, -200, 100, -100);
    drawLineDDA(gl, 100, 100, 200, 0);
    drawLineDDA(gl, -200, 0, -100, -100);
    drawLineDDA(gl, 0, 0, -100, -100);
	
}


int computeOutCode(int x,int y) {
	int left=1,right=2,below=4,above=8;
	int xmin=-150,ymax=30,ymin=-120,xmax=200;
	
	int outcode = 0;
	
	if(x<xmin)outcode=outcode|left;
	else if(x>xmax)outcode=outcode|right;
	if(y<ymin)outcode=outcode|below;
	else if(y>ymax)outcode=outcode|above;
	return outcode;
}


private void clippingassignment(GLAutoDrawable drawable) {
	GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    
    int startx=0;
    int starty=100;
    clipping(drawable,startx,starty,startx+1,starty);
    
    for(int i=1;i<50*2;i++) {
    	starty--;
    	clipping(drawable,startx-i,starty,startx+1,starty);
    	clipping(drawable,startx,starty,startx+1+i,starty);

    }
    for(int i=49*2;i>=1;i--) {
    	starty--;
    	clipping(drawable,startx-i,starty,startx+1,starty);
    	clipping(drawable,startx,starty,startx+1+i,starty);
    }
}

private void clipping(GLAutoDrawable drawable,int x0, int y0, int x1, int y1) {
	
	GL2 gl = drawable.getGL().getGL2();

    //gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    drawRec(drawable);
    
	int LEFT=1,RIGHT=2,BOTTOM=4,TOP=8;
	int xmin=-150,ymax=30,ymin=-120,xmax=200;
	int outcode0 = computeOutCode(x0,y0);
	int outcode1 = computeOutCode(x1,y1);
	boolean accept=false;
	
	
	while(true) {
		if((outcode0|outcode1)==0) {
			accept=true;
			break;
		}
		else if ((outcode0 & outcode1)!=0) {
			accept=false; //can avoid as accept is already false
			break;
		}
		else {

			int x = 0;
			int y = 0;
			int outcodeOut = outcode0!=0 ? outcode0 : outcode1;
			
			if ((outcodeOut & TOP)!=0) {
				x = x0 + (x1 - x0) * (ymax - y0) / (y1 - y0);
				y = ymax ;
				}
			else if ((outcodeOut&BOTTOM)!=0) {
				x = x0 + (x1 - x0) * (ymin - y0) / (y1 - y0);
				y = ymin ;
				}
			else if ((outcodeOut & RIGHT)!=0) {
				y = y0 + (y1 - y0) * (xmax - x0) / (x1 - x0);
				x = xmax ;
			}
			else if ((outcodeOut & LEFT)!=0) {
				y = y0 + (y1 - y0) * (xmin - x0) / (x1 - x0);
				x = xmin ;
				}
			if (outcodeOut == outcode0) {
				x0 = x;
				y0 = y;
				outcode0 = computeOutCode(x0, y0);
				} else {
				x1 = x;
				y1 = y;
				outcode1 = computeOutCode(x1, y1);
			}
		}
	}
	
	if (accept==true) {
		drawLineDDA(gl,x0,y0,x1,y1);
		}
	  
	}

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}


private void midPointCircle(GL2 gl, int x1, int y1, int r) {
	gl.glPointSize(08.0f);
	gl.glBegin(GL2.GL_POINTS);
	
	double x=0;
	double y=r;
	double d=1-r;
	
	gl.glVertex2d(x+x1,y+y1);
	gl.glVertex2d(y+x1,x+y1);
	gl.glVertex2d(y+x1,-x+y1);
	gl.glVertex2d(x+x1,-y+y1);
	gl.glVertex2d(-x+x1,-y+y1);
	gl.glVertex2d(-y+x1,-x+y1);
	gl.glVertex2d(-y+x1,x+y1);
	gl.glVertex2d(-x+x1,y+y1);

	while((int)y>(int)x) {
		if((int)d<0)d+=2*x+3;
		else {
			d+=2*(x-y)+5;
			y--;
		}
		x++;
		gl.glVertex2d(x+x1,y+y1);
		gl.glVertex2d(y+x1,x+y1);
		gl.glVertex2d(y+x1,-x+y1);
		gl.glVertex2d(x+x1,-y+y1);
		gl.glVertex2d(-x+x1,-y+y1);
		gl.glVertex2d(-y+x1,-x+y1);
		gl.glVertex2d(-y+x1,x+y1);
		gl.glVertex2d(-x+x1,y+y1);
	}

	gl.glEnd();
 
}



private void drawLineDDA(GL2 gl, double x1, double y1, double x2, double y2) {
	gl.glPointSize(05.0f);
	gl.glColor3d(2.5, 0, 0);
	gl.glBegin(GL2.GL_POINTS);
 
	int dx=(int)(x2-x1);
	int dy=(int)(y2-y1);
	//double m = dx/dy;
 
	double steps=0;
 
	if(Math.abs(dx)>Math.abs(dy)){
		steps=Math.abs(dx);
	}
	else{
		steps=Math.abs(dy);
	}
	double incx=dx/steps;
	double incy=dy/steps;
 	double x=x1,y=y1;
 	for(int i=0;i<(int)steps;i++){
 		gl.glVertex2d(Math.round(x),Math.round(y));
 		x+=incx;
 		y+=incy;
 	}

 	gl.glEnd();
  
}


private void drawLineM(GL2 gl, int x1, int y1, int x2, int y2) {

	gl.glPointSize(08.0f);
	gl.glBegin(GL2.GL_POINTS);
	

	int zone = findZone(x1,y1,x2,y2);
	if(zone==1) {
		int tempx1=x1;
		int tempx2=x2;
		x1=y1;
		x2=y2;
		y1=tempx1;
		y2=tempx2;
	}
	else if(zone==2) {
		int tempx1=x1;
		int tempx2=x2;
		x1=y1;
		x2=y2;
		y1=-tempx1;
		y2=-tempx2;
	}
	else if(zone==3) {
		x1=-x1;
		x2=-x2;
	}
	else if(zone==4) {
		x1=-x1;
		x2=-x2;
		y1=-y1;
		y2=-y2;
	}
	else if(zone==5) {
		int tempx1=x1;
		int tempx2=x2;
		x1=-y1;
		x2=-y2;
		y1=-tempx1;
		y2=-tempx2;
	}
	else if(zone==6) {
		int tempx1=x1;
		int tempx2=x2;
		x1=-y1;
		x2=-y2;
		y1=tempx1;
		y2=tempx2;
	}
	else if(zone==7){
		y1=-y1;
		y2=-y2;
	}
	
	int dx=x2-x1;
	int dy=y2-y1;
	
	int d = 2*dy-dx;
	int incE=2*dy;
	int incNE=2*(dy-dx);
	double y = y1;
	double x=x1;
	
	for(x=x1;x<=x2;x++) {
		if(zone==1) {
		gl.glVertex2d(y,x);
		}
		else if(zone==2) {
		gl.glVertex2d(-y,x);
		}
		else if(zone==3) {
			gl.glVertex2d(-x,y);
		}
		else if(zone==4) {
			gl.glVertex2d(-x,-y);
		}
		else if(zone==5) {
			gl.glVertex2d(-y,-x);
			}
		else if(zone==6) {
			gl.glVertex2d(y,-x);
			}
		else if(zone==7) {
			gl.glVertex2d(x,-y);
		}
		else
		{
			gl.glVertex2d(x,y);
		}
		
		if(d>0) {
			d+=incNE;
			y++;
		}
		else d+=incE;
		
	}
	 gl.glEnd();
	  
}


int findZone(int x1,int y1,int x2,int y2) {
	int dx = x2-x1;
	int dy = y2-y1;
	System.out.println(dx+" "+dy);
	int zone=0;
	if(Math.abs(dx)>=Math.abs(dy)) {
		if(dx>=0&&dy>=0)return 0;
		else if(dx<=0&&dy>=0)return 3;
		else if(dx<=0&&dy<=0)return 4;
		else return 7;
	}
	else {
		if(dx>=0&&dy>=0)return 1;
		else if(dx<=0&&dy>=0)return 2;
		else if(dx<=0&&dy<=0)return 5;
		else return 6;
	}
}




public void dispose(GLAutoDrawable arg0)
{
 
}

public point move(double x,double y,double a,double b) {
	double arr1[][] = new double[3][1];
	arr1[0][0]=x;
	arr1[1][0]=y;
	arr1[2][0]=1;
	arr1 = translate(a,b,arr1);
	
	point p = new point(arr1[0][0],arr1[1][0]);
	
	return p;
	
}


public void move_dir(double dx,double dy) {
	point p = move(x1,y1,dx,dy);
	x1=p.x;
	y1=p.y;
	
	p = move(x2,y2,dx,dy);
	x2=p.x;
	y2=p.y;
	
	p = move(x3,y3,dx,dy);
	x3=p.x;
	y3=p.y;
	
	p = move(x4,y4,dx,dy);
	x4=p.x;
	y4=p.y;
}

public point resize(double x,double y,double a,double b) {
	double arr1[][] = new double[3][1];
	arr1[0][0]=x;
	arr1[1][0]=y;
	arr1[2][0]=1;
	arr1 = transform(a,b,arr1);
	
	point p = new point(arr1[0][0],arr1[1][0]);
	
	return p;
	
}


public void resize_p(double dx,double dy) {
	point p = resize(x1,y1,dx,dy);
	x1=p.x;
	y1=p.y;
	
	p = resize(x2,y2,dx,dy);
	x2=p.x;
	y2=p.y;
	
	p = resize(x3,y3,dx,dy);
	x3=p.x;
	y3=p.y;
	
	p = resize(x4,y4,dx,dy);
	x4=p.x;
	y4=p.y;
}


public point rotater(double x,double y,double theta) {
	double arr1[][] = new double[3][1];
	arr1[0][0]=x;
	arr1[1][0]=y;
	arr1[2][0]=1;
	arr1 = rotate(x,y,theta,arr1);
	
	point p = new point(arr1[0][0],arr1[1][0]);
	
	return p;
	
}


public void rotate_p(double theta) {
	point p = rotater(x1,y1,theta);
	x1=Math.round(p.x);
	y1=Math.round(p.y);
	
	p = rotater(x2,y2,theta);
	x2=Math.round(p.x);
	y2=Math.round(p.y);
	
	p = rotater(x3,y3,theta);
	x3=Math.round(p.x);
	y3=Math.round(p.y);
	
	p = rotater(x4,y4,theta);
	x4=Math.round(p.x);
	y4=Math.round(p.y);
}


public point shearer(double x,double y,double x1,double y1) {
	double arr1[][] = new double [3][1];
	arr1[0][0]=x;
	arr1[1][0]=y;
	arr1[2][0]=1;
	arr1=shearing(x1,y1,arr1);
	
	point p = new point(arr1[0][0],arr1[1][0]);
	return p;
}

public void shear(double dx,double dy) {
	point p = shearer(x1,y1,dx,dy);
	x1=p.x;
	y1=p.y;
	
	p = shearer(x2,y2,dx,dy);
	x2=p.x;
	y2=p.y;
	
	p = shearer(x3,y3,dx,dy);
	x3=p.x;
	y3=p.y;
	
	p = shearer(x4,y4,dx,dy);
	x4=p.x;
	y4=p.y;
}







@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_UP) {
		move_dir(0,10);
	}
	else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		move_dir(0,-10);
	}
	else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		move_dir(-10,0);
	}
	else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		move_dir(10,0);
	}
	else if(e.getKeyCode()==KeyEvent.VK_1) {
		move_dir(-10,10);
	}
	else if(e.getKeyCode()==KeyEvent.VK_2) {
		move_dir(-10,-10);
	}
	else if(e.getKeyCode()==KeyEvent.VK_3) {
		move_dir(10,10);
	}
	else if(e.getKeyCode()==KeyEvent.VK_4) {
		move_dir(10,-10);
	}
	else if(e.getKeyChar()=='B'||e.getKeyChar()=='b') {
		resize_p(2,2);
	}
	else if(e.getKeyChar()=='S'|| e.getKeyChar()=='s' ){
		resize_p(.5,.5);
	}
	else if(e.getKeyChar()=='T'|| e.getKeyChar()=='t' ){
		resize_p(1,2);
	}
	else if(e.getKeyChar()=='p'|| e.getKeyChar()=='P' ){
		resize_p(1,.5);
	}
	else if(e.getKeyChar()=='M'|| e.getKeyChar()=='m' ){
		resize_p(2,1);
	}
	else if(e.getKeyChar()=='C'|| e.getKeyChar()=='c' ){
		resize_p(.5,1);
	}
	else if(e.getKeyChar()=='l'|| e.getKeyChar()=='L' ){
		rotate_p(Math.toRadians(10));
	}
	else if(e.getKeyChar()=='r'|| e.getKeyChar()=='R' ){
		rotate_p(Math.toRadians(-10));
	}
	else if(e.getKeyChar()=='x'|| e.getKeyChar()=='X' ){
		shear(.5,0);
	}
	else if(e.getKeyChar()=='y'|| e.getKeyChar()=='Y' ){
		shear(0,.5);
	}
	else if(e.getKeyChar()=='z'|| e.getKeyChar()=='Z' ){
		shear(.5,.5);
	}
	
	
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

public static double[][] mul(double arr1[][],double arr2[][]){
	
	
	double arr[][] = new double[3][1];
	
	
	for(int i=0;i<arr1.length;i++) {
		double temp = 0;
		
		for(int j=0;j<arr1[i].length;j++) {
			temp+= arr1[i][j]*arr2[j][0];
		}
		
		arr[i][0] = temp; 
	}
	
	return arr;
}


public static double[][] translate(double x ,double y,double arr[][]){
	double arr1[][]=new double[3][3];
	
	for(int i=0;i<3;i++) {
		arr1[i][i]=1;
	}
	
	arr1[0][2]=x;
	arr1[1][2]=y;
	
	arr = mul(arr1,arr);
	
	return arr;
}


public static double[][] transform(double x ,double y,double arr[][]){
	double arr1[][]=new double[3][3];
	
	arr1[2][2]=1;
	
	arr1[0][0]=x;
	arr1[1][1]=y;
	
	arr = mul(arr1,arr);
	
	return arr;
}


public static double[][] shearing(double a ,double b,double arr[][]){
	double arr1[][]=new double[3][3];
	
	for(int i=0;i<3;i++) {
		arr1[i][i]=1;
	}
	
	arr1[0][1]=a;
	arr1[1][0]=b;
	
	arr = mul(arr1,arr);
	
	return arr;
}



public static double[][] rotate(double x1 ,double y1,double theta,double arr[][]){
	double arr1[][]=new double[3][3];
	arr1[0][0]=Math.cos(theta);
	arr1[0][1]=-1*(Math.sin(theta));
	arr1[0][2]=x1*(1-Math.round(Math.cos(theta)))+y1*Math.round(Math.sin(theta));
	arr1[1][0]=Math.sin(theta);
	arr1[1][1]=Math.cos(theta);
	arr1[1][2]=y1*(1-Math.round(Math.cos(theta)))-x1*Math.round(Math.sin(theta));
	arr1[2][2]=1;
	arr = mul(arr1,arr);
	
	return arr;
}



}


public class DDA{
	public static void main(String args[]){
		//getting the capabilities object of GL2 profile
		    
		final GLProfile profile=GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities=new GLCapabilities(profile);
		// The canvas
		final GLCanvas glcanvas=new GLCanvas(capabilities);
		ThirdGLEventListener b=new ThirdGLEventListener();
		glcanvas.addGLEventListener(b);
		glcanvas.setSize(400, 400);
		//creating frame
		final JFrame frame = new JFrame("Basic frame");
        // adding canvas to frame
        frame.addKeyListener((java.awt.event.KeyListener) b);
        frame.add(glcanvas);
        frame.setSize(640, 480);
        frame.setVisible(true);
        FPSAnimator animator = new FPSAnimator(glcanvas, 60);
        animator.start();

	}
}
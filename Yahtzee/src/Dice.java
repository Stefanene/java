import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Dice {
	int x;
	int y;
	int i;
	
	Image myimage;
	//set all the getters
	
	public Dice(int newx, int newy) {
		x = newx;
		y = newy;
		
		
	}
	
	public int getNum() {
		return i;
	}
	
	public void setImage(int d) {
		i = d;
		String di = Integer.toString(d);
		try {
			myimage = ImageIO.read(new File(di + ".png"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void paintMe (Graphics g) {
		g.drawImage(myimage, x, y, null);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int newx) {
		x = newx;
	}
	
	
	public int getY() {
		return y;
	}
	
	public void setY(int newy) {
		y = newy;
	}
	

}

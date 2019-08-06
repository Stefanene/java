import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class D6 extends Dice{
	
	Image myimage;
	
	public D6(int newx, int newy) {
		super(newx, newy);
		//get image for specific dice
		try {
			myimage = ImageIO.read(new File("6.png"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void paintMe(Graphics g) {
		g.drawImage(myimage, x, y, null);
	}
}

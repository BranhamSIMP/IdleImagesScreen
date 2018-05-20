import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class testpanel extends JLabel{
	BufferedImage image;
    public static void main(String[] args) throws IOException {
    	
    	JFrame jf = new JFrame();
    	
    	
    	BufferedImage b = ImageIO.read(new File("161209-duggan-democratic-tyrant-tease_fp5jst.jpg"));
    	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage hello= resize(b,(int)screenSize.getHeight(), (int)screenSize.getWidth());
		
		ImageIcon i = new ImageIcon(hello);
		JLabel testing= new JLabel(i);
		
    	jf.add(testing);
		jf.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
    	testing.setSize((int)screenSize.getWidth(),(int)screenSize.getHeight());
    	ZoomButtons z =new ZoomButtons();
    	z.addZoomButtons(jf, testing);
    	jf.setVisible(true);
    }
	private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
}

}

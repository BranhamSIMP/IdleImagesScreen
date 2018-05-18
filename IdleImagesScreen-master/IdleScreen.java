
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


    public class FadeImage extends JPanel implements MouseListener{

        public static final long RUNNING_TIME = 2000;
        
        private BufferedImage inImage;
        private BufferedImage outImage;

        private float alpha = 0f;
       

        public FadeImage(BufferedImage first) {
            	alpha=0f;
                inImage = first;
                outImage = first;
        }
        public void startfade(double transtime, BufferedImage next){
               BufferedImage tmp = inImage;
                outImage=tmp;
                inImage=next;
                
                FastGameTimer g=new FastGameTimer(transtime);
              
                while(true) {
                	
                    	alpha=(float) (1f-g.getTimeRemaining()/g.getStartingTime());
                       
                        repaint();
                    
                	if(g.getTimeRemaining()<=0) {
                		alpha=1f;
                		break;
                	}
                	if(IdleScreen.getRunning()==false) {
                		return;
                	}
        
                }
          
            
        
        }
       @Override
        public Dimension getPreferredSize() {
            return new Dimension(
                            Math.max(inImage.getWidth(), outImage.getWidth()), 
                            Math.max(inImage.getHeight(), outImage.getHeight()));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
            int x = (getWidth() - inImage.getWidth()) / 2;
            int y = (getHeight() - inImage.getHeight()) / 2;
            g2d.drawImage(inImage, x, y, this);

            g2d.setComposite(AlphaComposite.SrcOver.derive(1f - alpha));
            x = (getWidth() - outImage.getWidth()) / 2;
            y = (getHeight() - outImage.getHeight()) / 2;
            g2d.drawImage(outImage, x, y, this);
            g2d.dispose();
        }

    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    	IdleScreen.setRunning();
    	
    	}

    	@Override
    	public void mouseEntered(MouseEvent e) {
    		// TODO Auto-generated method stub
    		
    		
    	}

    	@Override
    	public void mouseExited(MouseEvent e) {
    		// TODO Auto-generated method stub
    		
    	}

    	@Override
    	public void mousePressed(MouseEvent e) {
    		// TODO Auto-generated method stub
    		IdleScreen.setRunning();
    	}

    	@Override
    	public void mouseReleased(MouseEvent e) {
    		// TODO Auto-generated method stub
    		
    	}
    
}

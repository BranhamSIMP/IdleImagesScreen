import java.io.File;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class IdleImageScreen extends JFrame implements MouseListener{
	private boolean isRunning = true;
	
	public void startidlescreen() throws IOException{
		isRunning =true;
        //Initialize storage and access of images to be used in screensaver
		String folderpath = "images";
	 File dir = new File(folderpath);
	    File[] directoryListing = dir.listFiles();
	    ArrayList<BufferedImage> pics = new ArrayList<BufferedImage>(0);
	    
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   
	    	
	    	
	  //Preparation of the Imaging
	    JFrame f = new JFrame();
	    f.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
	    JLabel label = new JLabel(new ImageIcon(ImageIO.read(directoryListing[0])));
	    f.getContentPane().add(label);
	    f.getContentPane().addMouseListener(this);
	    
	  //Endless iteration through the images
	    	for(int i=0;i<directoryListing.length;i=(i+1)%directoryListing.length) {
	    		
	    	
	    	if(pics.size()==0) {
	    		pics.add(ImageIO.read(directoryListing[0]));
	    	}
	    	
	    	 
	    	label.setIcon(new ImageIcon(pics.get(i)));
	    	
	    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	f.setVisible(true);
	    	
	    	
	    	
	    	
	    	
	    	GameTimer g = new GameTimer(3);
	    	boolean donedownloading= false;
	    	while(true) {
	    		System.out.print("");
	    		
	    		//Concurrent image loading
	    		if(pics.size() < directoryListing.length && !donedownloading) {
		    		pics.add(ImageIO.read(directoryListing[(i+1)%directoryListing.length]));
		    		donedownloading=true;
	    		}
	    		if(!isRunning) {
	    			
	    			
	    			
		    		return;
	    		}
		    	else if(g.getTimeRemaining()<=0) {
	    			break;
	    		}
	    		
	    	}
	    
	    	
	    	}
	    
}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		isRunning=false;
		System.out.print("m");
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
		isRunning=false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

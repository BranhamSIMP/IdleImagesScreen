import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RunIdleScreen implements MouseListener{
	private static boolean isRunning = true;
	
	public static void startidlescreen() throws IOException{
		isRunning =true;
        //Initialize storage and access of images to be used in screensaver
		String folderpath = "Images";
	 File dir = new File(folderpath);
	    File[] directoryListing = dir.listFiles();
	    ArrayList<BufferedImage> pics = new ArrayList<BufferedImage>(0);
	    
	    //Move jpg files into BufferedImages
	    for(File fi: directoryListing) {
	    	
	    	pics.add(ImageIO.read(fi));
	    	
	    	
	    }
	  //Endless iteration through the images until screen is clicked
	   
	    	for(int i=0;i<pics.size();i=(i+1)%pics.size()) {
	    		
	    	System.out.println("start");
	    	JLabel label = new JLabel(new ImageIcon(pics.get(i)));
	    	JFrame f = new JFrame();
	    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	f.getContentPane().add(label);
	    	f.getContentPane().addMouseListener(null);
	    	f.pack();
	    	f.setLocation(0,0);
	    	f.setVisible(true);
	    	
	    	//Part that breaks out of method when click
	    	if(!isRunning) {
	    		break;
	    	}
		
		//Pause before changing photos
	    	GameTimer g = new GameTimer(2);
	    	while(true) {
	    		System.out.print("");
	    		if(g.getTimeRemaining()<=0) {
	    			break;
	    		}
	    	}
		
		//clears the original jframe to avoid stacking
	    	f.dispose();
	    	}
	    
}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		isRunning=false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		isRunning=false;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isRunning=false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		isRunning=false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		isRunning=false;
	}
}

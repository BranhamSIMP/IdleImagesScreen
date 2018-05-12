import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class runner extends JFrame implements MouseListener{
	private boolean isRunning = true;
	
	public void startidlescreen() throws IOException{
		isRunning =true;
        //Initialize storage and access of images to be used in screensaver
		String folderpath = "images";
	 File dir = new File(folderpath);
	    File[] directoryListing = dir.listFiles();
	    ArrayList<BufferedImage> pics = new ArrayList<BufferedImage>(0);
	    	
	  //Endless iteration through the images
	   
	    	for(int i=0;i<directoryListing.length;i=(i+1)%directoryListing.length) {
	    		
	    	System.out.println(pics.size());
	    	if(pics.size()==0) {
	    		pics.add(ImageIO.read(directoryListing[0]));
	    	}
	    	
	    	 JLabel label = new JLabel(new ImageIcon(pics.get(i)));
	    	
	    	JFrame f = new JFrame();
	    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	f.getContentPane().add(label);
	    	f.getContentPane().addMouseListener(this);
	    	f.pack();
	    	f.setLocation(0,0);
	    	f.setVisible(true);
	    	
		//Can change time in here to change transition times
	    	GameTimer g = new GameTimer(5);
	    	boolean donedownloading= false;
	    	while(true) {
	    		System.out.print("");
	    		
	    		//Concurrent image loading
	    		if(pics.size() < directoryListing.length && !donedownloading) {
		    		pics.add(ImageIO.read(directoryListing[(i+1)%directoryListing.length]));
		    		donedownloading=true;
	    		}
			//Terminate condition after user taps screen
	    		if(!isRunning) {
	    			f.dispose();
		    		return;
	    		}
			//Exit condition for loop based on timer time fulfilled
		    	else if(g.getTimeRemaining()<=0) {
	    			break;
	    		}
	    		
	    	}
	    	//Gets rid of old jframe
	    	f.dispose();
	    	
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
	public static void main(String[] args) {
		runner r = new runner();
		try {
			r.startidlescreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

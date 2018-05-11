

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
   Displays the current time once every second.
 */
public class GameTimer
{
	private Timer t;
	private int timeRemaining;
	private final int DELAY = 1000; // milliseconds between timer ticks
	
	public GameTimer() {
		timeRemaining = 180;

		class CurrentTime implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				timeRemaining--;
				if(timeRemaining <= 0) {
					t.stop();
				}
			}
		}
		CurrentTime listener = new CurrentTime();
		t = new Timer(DELAY, listener);
		t.start();
	}
	
	public int getTimeRemaining() {
		return timeRemaining;
	}
}
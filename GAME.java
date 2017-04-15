import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description of class GAME here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GAME
{
    public static final int BLOCK_SIZE = 20;
    private LEVEL level;
    
    public GAME()
    {
        level = new LEVEL("Level 1");
        
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        timer.start();
    }

}

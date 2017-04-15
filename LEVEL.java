import java.awt.Graphics;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class LEVEL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LEVEL extends JFrame
{
   
    private GAMECANVAS theCanvas;
    private BLOCK[][] theField;
    private BLOCK[] theBlocks;
    private int blockCount;
    private Rectangle[] theRectangles;
    
    /**
     * Creates a new instance of LEVEL and sets everything up:
     *  - frame dimensions
     *  - key listeners
     *  - initialize block array
     *  - initialize hero
     *  - fill in surrounding walls (remove later)
     * @param frameTitle
     */
    public LEVEL(String frameTitle)
    {  
        super(frameTitle);

        int frameWidth = 440;
        int frameHeight = 520;
        theCanvas = new GAMECANVAS(frameWidth, frameHeight, Color.LIGHT_GRAY);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(theCanvas);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);

        // initialize the blocks array
        this.theBlocks = new BLOCK[22*26];

        // initialize the two-dimensional blocks array
        theField = new BLOCK[22][26];
        blockCount = 0;
    }

    
    
    
    
    /** #################### DO NOT CHANGE ANYTHING BELOW! #################### */
    
    /**
     * Adds all the wall blocks.
     */
    public void UpdateView() {
        for (int i = 0; i < blockCount; i++) {
            theCanvas.addRectangle(theRectangles[i], theBlocks[i].getColor());
        }
        //theCanvas.addRectangle(new Rectangle(theGoal.getPosX(), theGoal.getPosY(), GAME.BLOCK_SIZE, GAME.BLOCK_SIZE), theGoal.getColor());
    }

    /**
     * Calls moveHeroTo(direction), if the hero should be moving.
     */
    /*
    public void UpdateHero() {
        if (theHero.isMoving()) {
            moveHeroTo(theHero.getMovingDirection());
        }
        theCanvas.addRectangle(new Rectangle(theHero.getPosX(), theHero.getPosY(), GAME.BLOCK_SIZE, GAME.BLOCK_SIZE), theHero.getColor());
    }
    */
    
    /**
     * Clears the Canvas by calling its clear() method.
     */
    public void Clear() {
        theCanvas.clear();
    }
    
    /**
     * The canvas where everything gets painted on.
     * Also, this class determines the size of the window.
     */
    private static class GAMECANVAS extends JPanel {  

        private BufferedImage image;

        /**
         * Creates a new instance of MyCanvas with the given color as backgorund color.
         * Sets the dimensions to the given width and height.
         */
        public GAMECANVAS(int width, int height, Color color) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            setBackground(color);
            setPreferredSize(new Dimension(width, height));
        }

        /**
         * The method that is invoked when repaint() is called.
         */
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if (image != null)
            {
                g.drawImage(image, 0, 0, null);
            }
        }

        /**
         * Creates an empty BufferedImage.
         */
        private void createEmptyImage()
        {
            image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = (Graphics2D)image.getGraphics();
            g2d.setColor(Color.BLACK);
        }

        /**
         * Adds a single rectangle and repaints the component.
         */
        public void addRectangle(Rectangle rect, Color color)
        {
            //  Draw the Rectangle onto the BufferedImage
            Graphics2D g2d = (Graphics2D)image.getGraphics();
            g2d.setColor(color);
            g2d.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
            //revalidate();
            repaint();
        }

        /**
         * Clears the component by painting an empty image.
         */
        public void clear()
        {
            createEmptyImage();
            repaint();
        }

    }
}

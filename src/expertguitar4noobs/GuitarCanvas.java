/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expertguitar4noobs;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author MiKe
 */
public class GuitarCanvas extends Canvas{

    private static int WIDTH = 764;
    private static int HEIGHT = 300*2;
    private static String GUITAR_IMAGE_FILE = "classical-guitar.jpg";
    private static String GH3_IMAGE_FILE = "guitar-hero.jpg";
    private BufferedImage guitar_image;
    private BufferedImage gh3_image;

    public GuitarCanvas() {
        this.setSize(WIDTH, HEIGHT);

        try{
            guitar_image = ImageIO.read(new File(GUITAR_IMAGE_FILE));
            gh3_image = ImageIO.read(new File(GH3_IMAGE_FILE));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Couldn't load the image!");
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(guitar_image, 0, 0, this);
        g.drawImage(gh3_image, 0, this.HEIGHT/2, this);
    }



}

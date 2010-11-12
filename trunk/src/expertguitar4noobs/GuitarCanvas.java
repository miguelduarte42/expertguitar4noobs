/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expertguitar4noobs;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author MiKe
 */
public class GuitarCanvas extends Canvas {

    private static int WIDTH = 764;
    private static int HEIGHT = 300 * 2;
    private static int RADIUS = 11;
    private static String GUITAR_IMAGE_FILE = "classical-guitar.jpg";
    private static String GH3_IMAGE_FILE = "guitar-hero.jpg";
    private BufferedImage guitar_image;
    private BufferedImage gh3_image;
    private Coord[][] notas;
    private Coord[] botoes;

    public GuitarCanvas() {
        this.setSize(WIDTH, HEIGHT);

        try {
            guitar_image = ImageIO.read(new File(GUITAR_IMAGE_FILE));
            gh3_image = ImageIO.read(new File(GH3_IMAGE_FILE));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load the image!");
        }

        initializeCoords();

        addMouseListener(new CanvasMouseListener(notas, botoes, this));

        repaint();
    }

    private void initializeCoords() {
        notas = new Coord[6][13];
        botoes = new Coord[5];

        int y = 102;
        int x = 45;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {

                int ij = notas[i].length - j;

                int cx = x + (int) (ij * (24 + ij));
                int cy = y + i * 12;

                if (j == 0) {
                    cx -= 17;
                }

                notas[i][j] = new Coord(cx, cy);
            }
        }

        x = 310;
        y = 430;
        for (int i = 0; i < botoes.length; i++) {
            int ij = botoes.length - i;
            int bx = x + ij * 40;
            botoes[i] = new Coord(bx, y);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(guitar_image, 0, 0, this);
        g.drawImage(gh3_image, 0, this.HEIGHT / 2, this);

        g.setColor(Color.WHITE);

        for (int j = notas[1].length - 1; j >= 0; j--) {
            for (int i = 0; i < notas.length; i++) {
                Coord c = notas[i][j];
                if (c.visible) {
                    g.fillOval(c.x, c.y, RADIUS, RADIUS);
                } else {
                    g.drawOval(c.x, c.y, RADIUS, RADIUS);
                    g.setColor(Color.BLACK);
                    g.fillOval(c.x, c.y, RADIUS, RADIUS);
                    g.setColor(Color.WHITE);
                }
            }
        }

        g.setColor(Color.RED);

        for (Coord c : botoes) {
            if(c.visible)
                g.fillRect(c.x, c.y, 20, 30);
        }
    }

    public void setInvisible() {
        for (int i = 0; i < notas.length; i++) {
            for (int j = notas[i].length - 1; j >= 0; j--) {
                notas[i][j].setVisible(false);
            }
        }

        for (Coord c : botoes)
            c.setVisible(false);
    }

    public int[] getActiveNotes() {

        int[] strings = {-1, -1, -1, -1, -1, -1};

        for (int i = 0; i < notas.length; i++) {
            for (int j = notas[i].length - 1; j >= 0; j--) {
                if (notas[i][j].visible) {
                    strings[i] = j;
                    break;
                }
            }
        }
        return strings;
    }

    private class CanvasMouseListener implements MouseListener {

        private Coord[][] notas;
        private Coord[] botoes;
        private GuitarCanvas canvas;

        public CanvasMouseListener(Coord[][] notas, Coord[] botoes, GuitarCanvas canvas) {
            this.notas = notas;
            this.botoes = botoes;
            this.canvas = canvas;
        }

        public void mouseClicked(MouseEvent e) {

            int mx = e.getX();
            int my = e.getY();

            boolean found = false;

            for (int i = 0; i < notas.length && !found; i++) {
                for (int j = notas[i].length - 1; j >= 0 && !found; j--) {
                    Coord c = notas[i][j];
                    Rectangle rect = new Rectangle(c.x, c.y, RADIUS, RADIUS);

                    if (rect.intersects(mx, my, 3, 3)) {
                        c.visible = !c.visible;
                        found = true;

                        //Set everything else on the string invisible
                        for (int x = 0; x < notas[i].length; x++) {
                            if (j != x) {
                                notas[i][x].visible = false;
                            }
                        }

                    }
                }
            }

            for(Coord c : botoes){
                 Rectangle rect = new Rectangle(c.x, c.y, 20, 30);
                 if (rect.intersects(mx, my, 3, 3))
                    c.visible = !c.visible;
            }
            canvas.repaint();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    private class Coord {

        public int x;
        public int y;
        public boolean visible;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
            this.visible = false;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }
    }
}

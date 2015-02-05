/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetask;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Win7
 */
public class GrayPanel extends JPanel {

    BufferedImage picture;

    public GrayPanel() {
        try {
            picture = ImageIO.read(new File("Jellyfish.jpg"));
            makeGray(picture);
        } catch (IOException e) {
            System.out.println("Problem reading image.");
        }

        try {
            File outputfile = new File("Grayfish.png");
            ImageIO.write(picture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("Problem occured while  writing image to file.");
        }

    }

    private static void makeGray(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                int grayLevel = (r + g + b) / 3;
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                img.setRGB(x, y, gray);

            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(picture, 0, 0, this);
        //g.setColor(Color.red);
       // g.drawRect(10, 10, 10, 10);
    }

}

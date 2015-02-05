/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetask;

import javax.swing.JFrame;

/**
 *
 * @author Win7
 */
public class ImageTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Gray Image");
        GrayPanel panel = new GrayPanel();
        frame.setSize(1200, 1200);
        frame.add(panel);
        frame.setVisible(true);
    }

}

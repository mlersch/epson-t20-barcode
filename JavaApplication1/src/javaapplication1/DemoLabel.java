/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author root
 */
public class DemoLabel {
    
    
    BufferedImage img;

    
    public DemoLabel(){
        LoadImageApp();
    }

    public BufferedImage getBufferedImage(){
        return img;
    }
    
    
    
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);





    }

    public void LoadImageApp() {
        img = new BufferedImage(600, 400, BufferedImage.TYPE_BYTE_GRAY);

        Graphics2D g2d = img.createGraphics();

        g2d.setPaint ( Color.WHITE );
        g2d.fillRect ( 0, 0, img.getWidth(), img.getHeight() );

        String text = "The quick brown fox jumped over the lazy dog";

        Font font = new Font("DejaVu Sans Bold", Font.PLAIN, 24);
        g2d.setFont(font);

//        Font font = null;
//        try {
//            font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/gudrun-Book.ttf"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        g2d.setFont(font.deriveFont(20f));
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.drawString(text, 20, 30);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawString(text, 20, 50);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2d.drawString(text, 20, 70);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.drawString(text, 20, 90);



        //Place the barcode symbol
//        int padding = 2;
//        AffineTransform symbolPlacement = new AffineTransform();
//        symbolPlacement.translate(padding, padding);
//        g2d.drawRenderedImage(makeBarcode(),symbolPlacement);



        for(int i=10; i <= 600; i += 10) {
            GeneralPath theShape = new GeneralPath();
            theShape.moveTo(i, 100);
            theShape.lineTo(i, 350);
            theShape.closePath();
            g2d.setStroke(new BasicStroke(1f));
            g2d.draw(theShape);
        }
        GeneralPath theShape = new GeneralPath();
        theShape.moveTo(0, 0);
        theShape.lineTo(575, 0);
        theShape.lineTo(575, 399);
        theShape.lineTo(0, 399);
        theShape.lineTo(0, 0);
        theShape.closePath();
        g2d.setStroke(new BasicStroke(1f));
        g2d.draw(theShape);
        
        


    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
    
    
    
    
/*
    public static void main(String[] args) {


        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();

        for (Font font : fonts) {
            System.out.print(font.getFontName() + " : ");
            System.out.println(font.getFamily());
        }

        JFrame f = new JFrame("Load Image Sample");

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(new LoadImageApp());
        f.pack();
        f.setVisible(true);
    }

*/
    
}

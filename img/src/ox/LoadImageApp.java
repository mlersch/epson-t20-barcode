package ox;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;




/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {

    BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);





    }

    public LoadImageApp() {
        img = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);

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



    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }

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


}

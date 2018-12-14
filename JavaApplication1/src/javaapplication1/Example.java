package javaapplication1;

import javax.swing.*;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Example {

    public BufferedImage printer() throws BarcodeException {
        // get a Barcode from the BarcodeFactory

        
                Barcode barcode = BarcodeFactory.createCode128B("K-12345678");
                barcode.setBarHeight(100);
                barcode.setBarWidth(3);
        
                
                
                
                
            try {
                    return BarcodeImageHandler.getImage(barcode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }    
    
}


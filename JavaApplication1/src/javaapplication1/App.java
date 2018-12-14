package javaapplication1;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.usb.UsbException;
import net.sourceforge.barbecue.BarcodeException;


public class App {


    private static EpsonESCPOSPrinter printer;
    public static short printerProductID = 0x0e15; // EPSON TM-T20II

    
    public static boolean normalyseHistogram = true;
    public static double gamma = 1.0;
    public static boolean DEBUG = false; 
    public static int printerSpeed = 2;
    public static int printDensity = 65533;
    public static int printerdots = 600;
    
    
    public static void main(String[] args) throws SecurityException, UsbException {




        EpsonESCPOSPrinter p = new EpsonESCPOSPrinter(printerProductID);


        /*
        Example be = new Example();
        try {
            p.print(be.printer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        DemoLabel image = new DemoLabel();
        
        try {
            p.print(image.getBufferedImage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        p.cut();
        p.close();
        
    }
}

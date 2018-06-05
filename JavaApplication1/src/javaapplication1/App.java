package javaapplication1;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.usb.UsbException;
import net.sourceforge.barbecue.BarcodeException;


public class App {


    private static EpsonESCPOSPrinter printer;
    public static short printerProductID = 0x0e15; // EPSON TM-T20II

    public static void main(String[] args) throws SecurityException, UsbException {


        //printer = new EpsonESCPOSPrinter(printerProductID);
        File imgFile = new File("/home/pi/Download.png");
        EpsonESCPOSPrinter p = new EpsonESCPOSPrinter((short) 0x0e15);
        //p.print(imgFile);

        Example be = new Example();
        try {
            p.print(be.printer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        p.cut();
        p.close();
        
    }
}

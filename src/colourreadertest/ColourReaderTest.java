/* Aisik Piltoe
 * outputs colours based on given image
 * uses a bufferedimage to read the rgb values of points on an image and print them
 * 2019-04-08
 */

package colourreadertest;

import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


/**
 *
 * @author aipil3692
 */
public class ColourReaderTest {


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException{       
        //init final var
        String Final = " ";
        
        
        int y = 1;
        for (int x = 80; x < 565; x+=100) {
            //create output
            String output= " ";
            
            //read image file
            File file= new File("picture.jpg");
            BufferedImage image = ImageIO.read(file);
            // Getting pixel color by position x and y 
            int clr =  image.getRGB(x,y); 
            int  red   = (clr & 0x00ff0000) >> 16;
            int  green = (clr & 0x0000ff00) >> 8;
            int  blue  =  clr & 0x000000ff;
            
            //create string and collect data
            System.out.println("Color value = "+ red +","+ green +","+ blue);
            //String temp = concat = "Color value = "+ red +","+ green +","+ blue + "\n";
            output = "Color value = "+ red +","+ green +","+ blue + "\n";
            Final = Final+" "+output;
            System.out.println(" test: "+Final);
        }

        //create file and writes final variables to it as an output
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("output.txt"), "utf-8"))) {
            writer.write("file created, colours:" + "\n");
            writer.write(Final);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in writing file");
        }       
        
  }
}

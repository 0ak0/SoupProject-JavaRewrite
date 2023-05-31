import java.awt.Color;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class canbody {
    public static BufferedImage creator(BufferedImage base, Color bColor){
        int rgbConversion = bColor.getRGB(); // Because its needy and wants an int
        // For each pixel of the base image
        for (int w = 0; w < base.getWidth(); w++) {
            for (int h = 0; h < base.getHeight(); h++) {
                Color currentPixel = new Color(base.getRGB(w, h), true);
                if (currentPixel.equals(Color.WHITE)) { // Base image is pure white
                    base.setRGB(w, h, rgbConversion);
                }
            }
        }
        return base;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("please use arg for color (hex)"); // Allow for hex codes in testing with args
        }

        BufferedImage bodyTemplate = ImageIO.read(new File(".." + File.separator + ".." + File.separator + "images" + File.separator + "body.png")); // See builder.java:37 comment

        String colorHex = args[0];
        if(colorHex.startsWith("#") == false) {
            colorHex = "#" + colorHex; // Because some people (aka me) will just type the hexcode itself
        }

        Color mainArgConvert = (Color.decode(colorHex));

        BufferedImage newBody = creator(bodyTemplate, mainArgConvert);
        ImageIO.write(newBody, "png", new File("imageout" + File.separator + "c_body.png"));     
    }
}

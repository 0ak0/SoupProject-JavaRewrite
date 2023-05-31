import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;


public class decals {
    final static String imagesPath =  ".." + File.separator + "images" + File.separator;
    final static String decalsPath =  imagesPath + File.separator + "decals" + File.separator;
    // final static String outputPath =  ".." + File.separator + "output" + File.separator;

    public static BufferedImage allStickers(int n) throws IOException {

        // Each index corresponds to the named decal (usage[0] will be true if 0.png used)
        Boolean[] usage = new Boolean[8];
        for (int x = 0; x < 8; x++) {
            usage[x] = false;
        }

        BufferedImage outputBase = new BufferedImage(1080, 1080, BufferedImage.TYPE_INT_ARGB);
        Graphics2D decalImage = outputBase.createGraphics();

        for (int x = 0; x < n; x++) {
            int red = (int) Math.floor(Math.random() * 256);
            int green = (int) Math.floor(Math.random() * 256);
            int blue = (int) Math.floor(Math.random() * 256);

            Color currColor = new Color(red, green, blue, 255);
            int rgbConversion = currColor.getRGB();



            int currDecal = (int) Math.floor(Math.random() * 8);
            while (usage[currDecal] == true) {
                currDecal = (int) Math.floor(Math.random() * 8); // Reroll currDecal if already used
            }


            BufferedImage base = ImageIO.read(new File(decalsPath + currDecal + ".png"));
            for (int w = 0; w < base.getWidth(); w++) {
                for (int h = 0; h < base.getHeight(); h++) {
                    Color currentPixel = new Color(base.getRGB(w, h), true);
                    if (currentPixel.getAlpha() == 255) { // Base image is pure white
                        base.setRGB(w, h, rgbConversion);
                    }
                }
            }

            decalImage.drawImage(base, 0, 0, null);
            usage[currDecal] = true;

        }

        decalImage.dispose();

        return outputBase;
    }

    public static void main(String[] args) throws IOException {
        int num;
        if (args.length == 1) {
            num = Integer.parseInt(args[0]);
        } else {
            num = (int) Math.floor(Math.random() * 8);
        }

        ImageIO.write(allStickers(num), "png", new File("imageout" + File.separator + "decals.png"));
    }
}

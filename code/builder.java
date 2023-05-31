import java.awt.Color;
import java.awt.image.*;
import java.awt.Graphics2D;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class builder {
    public static void main(String[] args) throws IOException {
        int iterations = 1;
        // Allow for multiple cans to be made at once if desired
        if(args.length == 1) {
            iterations = Integer.parseInt(args[0]);
            System.out.println("Performing " + iterations + " iterations.");
        } else {
            iterations = 1;
            System.out.println("Invalid args, performing a single iteration.");
        }
        int times = 1;
        for(int x = iterations; x != 0; x--) {
            String fileName = "can" + x;
            File finalFile = new File(".." + File.separator + ".." + File.separator + "output" + File.separator + "" + fileName + ".png");
            ImageIO.write(imageBuilder(), "png", finalFile);
            System.out.println("Finished iteration no. " + times);
            times++;
        }  
    }

    public static BufferedImage imageBuilder() throws IOException {
        BufferedImage outputBase = new BufferedImage(1080, 1080, BufferedImage.TYPE_INT_ARGB);

        int red = (int) Math.floor(Math.random() * 256);
        int green = (int) Math.floor(Math.random() * 256);
        int blue = (int) Math.floor(Math.random() * 256);

        Color bodyColor = new Color(red, green, blue, 255);

        BufferedImage bodyBase = ImageIO.read(new File(".." + File.separator + ".." + File.separator + "images" + File.separator + "body.png"));
        BufferedImage body = canbody.creator(bodyBase, bodyColor);
        BufferedImage lid = ImageIO.read(new File(".." + File.separator + ".." + File.separator + "images" + File.separator + "lid.png")); // Terrible way to do this but this path and filename probably won't change
        BufferedImage blip = ImageIO.read(new File(".." + File.separator + ".." + File.separator + "images" + File.separator + "botlip.png"));
        BufferedImage shade = ImageIO.read(new File(".." + File.separator + ".." + File.separator + "images" + File.separator + "shade.png"));
        BufferedImage bg = background.generateBackground();
        BufferedImage decal = decals.allStickers((int) Math.floor(Math.random() * 8));

        Graphics2D finalCan = outputBase.createGraphics();
        finalCan.drawImage(bg, 0, 0, null);
        finalCan.drawImage(blip, 0, 0, null);
        finalCan.drawImage(body, 0, 0, null);
        finalCan.drawImage(decal, 0, 0, null);
        finalCan.drawImage(shade, 0, 0, null);
        finalCan.drawImage(lid, 0, 0, null);
        

        finalCan.dispose();

        return outputBase;
    }
}
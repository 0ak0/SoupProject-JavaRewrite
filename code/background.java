import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class background {
    public static BufferedImage generateBackground() {

        Color[] colors = new Color[2];

        for(int x = 0; x < 2; x++) {
            int red = (int) Math.floor(Math.random() * 256);
            int green = (int) Math.floor(Math.random() * 256);
            int blue = (int) Math.floor(Math.random() * 256);

            colors[x] = new Color(red, green, blue, 255);
        }

        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(0, 1080);
        float[] distance = {0.0f, 1.0f};

        LinearGradientPaint gradient = new LinearGradientPaint(start, end, distance, colors);

        BufferedImage outputBase = new BufferedImage(1080, 1080, BufferedImage.TYPE_INT_ARGB);

        
        Graphics2D gradientImage = outputBase.createGraphics();
        gradientImage.setPaint(gradient);
        gradientImage.fillRect(0, 0, 1080, 1080);

        return outputBase;
    }

    public static void main(String[] args) throws IOException {
        ImageIO.write(generateBackground(), "png", new File("imageout" + File.separator + "bg.png"));
    }
}

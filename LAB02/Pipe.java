import java.awt.*;

public class Pipe {
    Integer x, y, width = 60, height;
    Image pipeImage;
    boolean passed = false;

    Pipe(Integer x, Integer y,  Integer height, Image image) {
        this.x = x;
        this.y = y;
        this.height = height;
        pipeImage = image;
    }

    public void move() {
        x -= 3;
    }

    public void draw(Graphics g) {
        g.drawImage(pipeImage, x, y, width, height, null);
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }
}

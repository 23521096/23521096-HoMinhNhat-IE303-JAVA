import java.awt.*;

import javax.swing.ImageIcon;

public class Bird {
    Integer x, y;
    Integer width = 40, height = 40;
    Integer velocity = 0;
    Integer gravity = 1;
    Image birdImage;

    Bird(Integer x, Integer y) {
        this.x = x;
        this.y = y;

        birdImage = new ImageIcon("images/flappybird.png").getImage();
    }

    public void move() {
        velocity += gravity;
        y += velocity;
    }

    public void jump() {
        velocity = -8;
    }

    public void draw(Graphics g) {
        g.drawImage(birdImage, x, y, width, height, null);
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }
}

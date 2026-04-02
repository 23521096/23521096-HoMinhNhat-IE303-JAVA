import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Background extends JPanel implements ActionListener, KeyListener {
    Image backgroundImage;
    Integer width = 0, height = 0;

    Bird bird;
    ArrayList<Pipe> pipes = new ArrayList<>();

    Image topPipeImage;
    Image bottomPipeImage;

    Timer timer;

    Integer frame = 0;
    Integer score = 0;

    boolean gameOver = false;

    Background(Integer width, Integer height) {
        this.setPreferredSize(new Dimension(width, height));
    
        this.width = width;
        this.height = height;

        setFocusable(true);
        addKeyListener(this);

        backgroundImage = new ImageIcon("images/flappybirdbg.png").getImage();
        bird = new Bird(50, 300);

        topPipeImage = new ImageIcon("images/toppipe.png").getImage();
        bottomPipeImage = new ImageIcon("images/bottompipe.png").getImage();

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if(!gameOver) {
            bird.move();
            frame++;

            if(bird.y > height || bird.y < 0) {
                gameOver = true;
            }

            if(frame % 60 == 0){
                spawnPipe();
            }

            for(Pipe pipe : pipes) {
                pipe.move();

                if(bird.getRect().intersects(pipe.getRect())) {
                    gameOver = true;
                }

                if(!pipe.passed && pipe.x + pipe.width < bird.x && pipe.y > 0) {
                    pipe.passed = true;
                    score++;
                }
            }

            pipes.removeIf(pipe -> pipe.x + pipe.width < 0);

        }
        repaint();
    }

    public void spawnPipe() {
        Integer gap = 150;
        Integer topHeight = (int)(Math.random() * 300) + 50;
        Integer bottomHeight = height - topHeight - gap;

        Pipe topPipe = new Pipe(width, 0, topHeight, topPipeImage);
        Pipe bottomPipe = new Pipe(width, topHeight + gap, bottomHeight, bottomPipeImage);

        pipes.add(topPipe);
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, width, height, this);
        bird.draw(g);
        for(Pipe pipe : pipes) {
            pipe.draw(g);
        }

        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Score: " + score, 10, 30);

        if(gameOver) {
            g.drawString("Game Over", 80, 300);
            g.drawString("Press ENTER to Restart", 70, 350);
        }
    }

    public void keyPressed(KeyEvent e) {
        if(!gameOver) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                bird.jump();
            }
        } else {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                restartGame();
            }
        }
    }

    public void restartGame() {
        bird.x = 50;
        bird.y = 300;
        bird.velocity = 0;

        pipes.clear();
        score = 0;
        frame = 0;
        gameOver = false;
    }
    
    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;


public class gamepanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH=600;
    static final int SCREEN_HEIGHT=600;
    static final int UNIT_SIZE=25;
    static final int GAME_UNITS=((SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE);
    static final int DELAY= 75;
    final int x[]=new int[GAME_UNITS];
    final int y[]=new int[GAME_UNITS];
    int bodyparts=6;
    int coinseaten;
    int coinsX;
    int coinsY;
    char direction='R';
    boolean running=false;
    Timer timer;
    Random random;



    gamepanel(){
         random=new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        start_game();


    }
    public void start_game(){
        new_coin();
        running=true;
        timer=new Timer(DELAY,this);
        timer.start();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);


    }
    public void draw(Graphics g){
        if(running) {
//            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
//                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//            }
//            for (int j = 0; j < SCREEN_WIDTH / UNIT_SIZE; j++) {
//                g.drawLine(0, j * UNIT_SIZE, SCREEN_WIDTH, j * UNIT_SIZE);
//            }
            g.setColor(Color.YELLOW);
            g.fillOval(coinsX, coinsY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyparts; i++) {
                if (i == 0) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }

            }
            g.setColor(Color.red);
            g.setFont(new Font("Algerian", Font.CENTER_BASELINE,20));
            FontMetrics metrics=getFontMetrics(g.getFont());
            g.drawString("Score: "+coinseaten,(SCREEN_WIDTH-metrics.stringWidth("Score: "+coinseaten))/2,g.getFont().getSize());
        }

        else{
            game_over(g);
        }


    }
    public void new_coin(){
        coinsX= random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        coinsY= random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move(){
        for(int i= bodyparts;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];

        }
        switch(direction){
            case 'U':
                y[0]=y[0]- UNIT_SIZE;
                break;
            case 'D':
                y[0]=y[0]+UNIT_SIZE;
                break;
            case 'L':
                x[0]=x[0]-UNIT_SIZE;
                break;
            case 'R':
                x[0]=x[0]+UNIT_SIZE;
                break;
        }

    }
    public void checkcoins(){
        if((x[0]==coinsX)&&(y[0]==coinsY)){
            bodyparts++;
            coinseaten++;
            new_coin();
        }

    }
    public void check_collisions(){
        //check collision of heaD WITH BODY
        for(int i=bodyparts;i>0;i--){
            if (x[0] == x[i] && y[0] == y[i]) {
                running=false;
            }
            //check if head collides with right and left boundaries
            if(x[0]<0){
                running=false;

            }
            if(x[0]>SCREEN_WIDTH){
                running=false;

            }
            //check if head collides with top and bottom boundaries
            if(y[0]<0){
                running=false;

            }
            if(y[0]>SCREEN_HEIGHT){
                running=false;

            }
            if(!running){
                timer.stop();
            }
        }

    }
    public void game_over(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Algerian", Font.BOLD,75));
        FontMetrics metrics=getFontMetrics(g.getFont());
        g.drawString("GAME OVER",(SCREEN_WIDTH-metrics.stringWidth("GAME OVER"))/2,SCREEN_HEIGHT/2);

        g.setColor(Color.red);
        g.setFont(new Font("Algerian", Font.BOLD,20));
        FontMetrics metrics2=getFontMetrics(g.getFont());
        g.drawString("Score: "+coinseaten,(SCREEN_WIDTH-metrics.stringWidth("Score: "+coinseaten))/2,g.getFont().getSize());

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkcoins();
            check_collisions();

        }
        repaint();

    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction!='R'){
                        direction='L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction!='L'){
                        direction='R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction!='D'){
                        direction='U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction!='U'){
                        direction='D';
                    }
                    break;
            }

        }
    }
}

import java.awt.*;
import javax.swing.*;

public abstract class SortPanel extends JPanel implements Runnable {
    protected int[] list;
    protected int size;
    protected int sleepTime;


    public SortPanel(int size, int width, int height){
        this.size = size;
        this.sleepTime = 50;
        this.list = new int[size];
        setPreferredSize(new Dimension(width,height));
        generateRandomList();
    }

    public void generateRandomList(){
        for (int i = 0; i < size; i++){
            list[i] = (int)(Math.random() * size);
        }
        repaint();
    }


    public abstract void sort() throws InterruptedException;
    public abstract void reset();

    @Override
    public void run(){
        try {
            sort();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        reset();
        repaint();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / size;

        for (int i = 0; i < list.length; i++){
            int barHeight = (int) (((double)list[i] / size) * height);
            g.setColor(Color.WHITE);
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
    }

}



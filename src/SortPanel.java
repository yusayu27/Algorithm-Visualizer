import java.awt.*;
import java.awt.color.*;
import java.awt.FontMetrics;
import java.util.Arrays;
import javax.swing.JPanel;

public abstract class SortPanel extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    protected static final int BORDER_WIDTH = 10;
    private Dimension preferredDimension;
    protected int size;
    protected int[] list;
    protected int[] SleepTime;
    private String name;

    public SortPanel(String name, int SleepTime,int width, int height){
        preferredDimension = new Dimension(width, height);
        this.name = name;
        this.sleepTime = sleepTime;
        setBackground(Color.BLACK);
    }

    public void setList(int[] list){
        reset();
        this.size = list.length;
        this.list = java.util.Arrays.copyOf(list, size);
        setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawRect(BORDER_WIDTH, BORDER_WIDTH, getWidth() - 2 * BORDER_WIDTH, getHeight() - 2 * BORDER_WIDTH);

        Font nameFont = new Font(Font.MONOSPACED, Font.BOLD, 18);
        FontMetrics nameFontMetrics = getFontMetrics(nameFont);
        g.setColor(Color.BLACK);
        g.fillRect((getWidth() - nameFontMetrics.stringWidth(name)) / 2,0, nameFontMetrics.stringWidth(name), BORDER_WIDTH + nameFontMetrics.getAscent() / 3);
        g.setColor(Color.ORANGE);
        g.setFont(nameFont);
        g.drawString(name, (getWidth() - nameFontMetrics.stringWidth(name)) / 2, BORDER_WIDTH + nameFontMetrics.getAscent() / 3);
    }


    @Override
    public abstract void run();
    public abstract void reset();

}



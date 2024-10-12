import java.awt.*;

public class BubbleSortPanel extends SortPanel {
    private int currentIndex = -1;

    public BubbleSortPanel(int size, int width, int height){
        super(size,width,height);
    }

    @Override
    public void reset(){
        currentIndex = -1;
    }

    @Override
    public void sort() throws InterruptedException {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                currentIndex = j;
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
                repaint();
                Thread.sleep((int) (sleepTime * 0.5));
            }
            if (!swapped) {
                break;
            }
        }
    }



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (currentIndex != -1){
            g.setColor(Color.RED);
            int barWidth = getWidth() / size;
            int barHeight = (int) (((double) list[currentIndex] /size) * getHeight());
            g.fillRect(currentIndex * barWidth, getHeight() - barHeight, barWidth, barHeight);
        }
    }
}


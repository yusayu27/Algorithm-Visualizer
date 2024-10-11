
import java.awt.*;


public class SelectionSortPanel extends SortPanel {
    private int currentIndex = -1;

    public SelectionSortPanel(int size, int width, int height) {
        super(size, width, height);
    }

    @Override
    public void reset() {
        currentIndex = -1;
    }

    @Override
    public void sort() throws InterruptedException {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;

            currentIndex = i;
            repaint();
            Thread.sleep(sleepTime);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentIndex != -1) {
            g.setColor(Color.RED);
            int barWidth = getWidth() / size;
            int barHeight = (int) (((double) list[currentIndex] / size) * getHeight());
            g.fillRect(currentIndex * barWidth, getHeight() - barHeight, barWidth, barHeight);
        }
    }
}

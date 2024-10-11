import java.awt.*;

public class InsertionSortPanel extends SortPanel {
    private int currentIndex = -1;

    public InsertionSortPanel(int size, int width, int height) {
        super(size, width, height);
    }

    @Override
    public void reset() {
        currentIndex = -1;
    }

    @Override
    public void sort() throws InterruptedException {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
                currentIndex = j + 1;
                repaint();
                Thread.sleep(sleepTime);
            }
            list[j + 1] = key;
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

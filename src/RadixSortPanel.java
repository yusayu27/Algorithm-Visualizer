import java.awt.*;
import java.util.Arrays;

public class RadixSortPanel extends SortPanel {
    private int currentIndex = -1;

    public RadixSortPanel(int size, int width, int height) {
        super(size, width, height);
    }

    @Override
    public void reset() {
        currentIndex = -1;
    }

    @Override
    public void sort() throws InterruptedException {
        int max = Arrays.stream(list).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp);
        }
    }

    private void countSort(int exp) throws InterruptedException {
        int[] output = new int[list.length];
        int[] count = new int[10];

        for (int value : list) {
            count[(value / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = list.length - 1; i >= 0; i--) {
            output[count[(list[i] / exp) % 10] - 1] = list[i];
            count[(list[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, list, 0, list.length);
        repaint();
        Thread.sleep(sleepTime);
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

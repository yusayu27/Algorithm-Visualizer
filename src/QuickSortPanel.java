import java.awt.*;


public class QuickSortPanel extends SortPanel {
    private int pivotIndex = -1;

    public QuickSortPanel(int size, int width, int height) {
        super(size, width, height);
    }

    @Override
    public void reset() {
        pivotIndex = -1;
    }

    @Override
    public void sort() throws InterruptedException {
        quicksort(0, list.length - 1);
    }

    private void quicksort(int low, int high) throws InterruptedException {
        if (low < high) {
            int pivot = partition(low, high);
            quicksort(low, pivot - 1);
            quicksort(pivot + 1, high);
        }
    }

    private int partition(int low, int high) throws InterruptedException {
        int pivotValue = list[high];
        pivotIndex = high;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list[j] < pivotValue) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
            repaint();
            Thread.sleep(sleepTime);
        }

        int temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;

        return i + 1;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (pivotIndex != -1) {
            g.setColor(Color.RED);
            int barWidth = getWidth() / size;
            int barHeight = (int) (((double) list[pivotIndex] / size) * getHeight());
            g.fillRect(pivotIndex * barWidth, getHeight() - barHeight, barWidth, barHeight);
        }
    }
}

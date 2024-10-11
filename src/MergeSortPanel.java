import java.awt.*;


public class MergeSortPanel extends SortPanel {
    private int currentIndex = -1;

    public MergeSortPanel(int size, int width, int height) {
        super(size, width, height);
    }

    @Override
    public void reset() {
        currentIndex = -1;
    }

    @Override
    public void sort() throws InterruptedException {
        mergeSort(0, list.length - 1);
    }

    private void mergeSort(int low, int high) throws InterruptedException {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) throws InterruptedException {
        int[] temp = new int[high - low + 1];

        int left = low, right = mid + 1, index = 0;

        while (left <= mid && right <= high) {
            if (list[left] <= list[right]) {
                temp[index++] = list[left++];
            } else {
                temp[index++] = list[right++];
            }
            repaint();
            Thread.sleep(sleepTime);
        }

        while (left <= mid) {
            temp[index++] = list[left++];
            repaint();
            Thread.sleep(sleepTime);
        }

        while (right <= high) {
            temp[index++] = list[right++];
            repaint();
            Thread.sleep(sleepTime);
        }

        System.arraycopy(temp, 0, list, low, temp.length);
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

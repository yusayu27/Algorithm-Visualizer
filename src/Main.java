
import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.awt.*;
import java.util.concurrent.Executor;

public class Main extends JApplet {
    public static final long SerialVersionUID = 1L;
    private SortPanel [] sortPanels = new SortPanel[9];
    private static int size = 100;
    private int SleepTime = 2;
    private String animationName = "";

    public Main() {
        setLayout(new GridLayout(1,1,0,0));
        SortPanelsHolder sortPanelsHolder = new SortPanelsHolder();
        sortPanelsHolder.setLayout(new GridLayout(0,3,0,0));
        sortPanelsHolder.setBackground(Color.BLACK);
        sortPanelsHolder.setForeground(Color.BLACK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 3;
        int height = screenSize.height / 3;
        sortPanels[0] = new SelectionSortPanel("Selection Sort", sleepTime, width, height);
        sortPanels[1] = new ShellSortPanel("Shell Sort", sleepTime, width, height);
        sortPanels[2] = new BubbleSortPanel("Bubble Sort", sleepTime, width, height);
        sortPanels[3] = new MergeSortPanel("Merge Sort", sleepTime, width, height);
        sortPanels[4] = new InsertionSortPanel("Insertion Sort", sleepTime, width, height);
        sortPanels[5] = new QuickSortPanel("Quick Sort", sleepTime, width, height);
        sortPanels[6] = new RadixSortPanel("Radix Sort", sleepTime, width, height);


    }

}
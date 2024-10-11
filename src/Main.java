
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton startBubbleSortButton = new JButton("Bubble Sort");
        JButton startQuickSortButton = new JButton("Quick Sort");
        JButton startInsertionSortButton = new JButton("Insertion Sort");
        JButton startMergeSortButton = new JButton("Merge Sort");
        JButton startRadixSortButton = new JButton("Radix Sort");
        JButton startSelectionSortButton = new JButton("Selection Sort");

        SortPanel bubbleSortPanel = new BubbleSortPanel(50, 600, 400);
        SortPanel quickSortPanel = new QuickSortPanel(50, 600, 400);
        SortPanel insertionSortPanel = new InsertionSortPanel(50, 600, 400);
        SortPanel mergeSortPanel = new MergeSortPanel(50, 600, 400);
        SortPanel radixSortPanel = new RadixSortPanel(50, 600, 400);
        SortPanel selectionSortPanel = new SelectionSortPanel(50, 600, 400);

        startBubbleSortButton.addActionListener(e -> startSorting(frame, bubbleSortPanel));
        startQuickSortButton.addActionListener(e -> startSorting(frame, quickSortPanel));
        startInsertionSortButton.addActionListener(e -> startSorting(frame, insertionSortPanel));
        startMergeSortButton.addActionListener(e -> startSorting(frame, mergeSortPanel));
        startRadixSortButton.addActionListener(e -> startSorting(frame, radixSortPanel));
        startSelectionSortButton.addActionListener(e -> startSorting(frame, selectionSortPanel));

        controlPanel.add(startBubbleSortButton);
        controlPanel.add(startQuickSortButton);
        controlPanel.add(startInsertionSortButton);
        controlPanel.add(startMergeSortButton);
        controlPanel.add(startRadixSortButton);
        controlPanel.add(startSelectionSortButton);

        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(bubbleSortPanel, BorderLayout.CENTER);  // Start with bubble sort panel

        frame.setVisible(true);



    }

    // Utility method to start the selected sorting algorithm
    private static void startSorting(JFrame frame, SortPanel sortPanel) {
        frame.getContentPane().removeAll();  // Remove previous panel
        frame.add(sortPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(sortPanel);
    }
}
























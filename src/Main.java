import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel mainMenu;

    public Main() {
        setTitle("Algorithm Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());

        // Create the main menu panel
        mainMenu = new JPanel(new GridLayout(6, 1));
        mainMenu.add(createButton("Bubble Sort", new BubbleSortPanel("Bubble Sort", 20, 800, 600)));
        mainMenu.add(createButton("Insertion Sort", new InsertionSortPanel("Insertion Sort", 20, 800, 600)));
        mainMenu.add(createButton("Merge Sort", new MergeSortPanel("Merge Sort", 20, 800, 600)));
        mainMenu.add(createButton("Quick Sort", new QuickSortPanel("Quick Sort", 20, 800, 600)));
        mainMenu.add(createButton("Radix Sort", new RadixSortPanel("Radix Sort", 20, 800, 600)));
        mainMenu.add(createButton("Selection Sort", new SelectionSortPanel("Selection Sort", 20, 800, 600)));

        add(mainMenu);

        setVisible(true);
    }

    private JButton createButton(String name, SortPanel panel) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(mainMenu);
                panel.add(createBackButton(panel));
                add(panel);
                panel.startSorting(); // Starts the sorting process
                revalidate();
                repaint();
            }
        });
        return button;
    }

    private JButton createBackButton(SortPanel panel) {
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panel);
                remove(backButton); // edited
                add(mainMenu);
                revalidate();
                repaint();
            }
        });
        return backButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

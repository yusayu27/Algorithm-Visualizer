
import javax.swing.*;
import java.util.Arrays;
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
        setLayout(new GridLayout(1, 1, 0, 0));
        SortPanelsHolder sortPanelsHolder = new SortPanelsHolder();
        sortPanelsHolder.setLayout(new GridLayout(0, 3, 0, 0));
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

        for (int i = 0; i < sortPanels.length; i++) {
            sortPanels[i].setVisible(false);
            sortPanelsHolder.add(sortPanels[i]);

        }

        add(sortPanelsHolder);


    }

    class SortPanelsHolder extends JPanel{
        private static final long serialVersionUID = 1L;
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            Font animationNameFont = new Font(Font.MONOSPACED, Font.BOLD, 150);
            FontMetrics animationNameFontMetrics = getFontMetrics(animationNameFont);
            g.setFont(animationNameFont);
            int x = (getWidth() - animationNameFontMetrics.stringWidth(animationName)) / 2;
            int y  = (getHeight() - animationNameFontMetrics.getLeading()) / 2;
            g.drawString(animationName, x, y);
        }
    }


    public void beginAnimation(String animationName, int[] list){
        try{
            this.animationName = animationName;
            repaint();
            Thread.sleep(200);
            this.animationName = "";
            repaint();
            for (int i = 0; i <sortPanels.length; i++){
                sortPanels[i].setList(list);
                sortPanels[i].setVisible(true);
            }
            Thread.sleep(1000);
            ExecutorService executor = Executor.newFixedThreadPool(sortPanels.length);
            for (int i= 0; i< sortPanels.length; i++){
                executor.execute(sortPanels[i]);
            }
            executor.shutdown();
            while (!executor.isTerminated()){
                Thread.sleep(100);
            }
            Thread.sleep(1000);
            for (int i = 0 ; i< sortPanels.length; i++){
                sortPanels[i].setVisible(false);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Sorting algorithms");
        Main main = new Main();
        frame.add(main);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        int[] list = new int[size];

        for (int i = 0; i< list.length; i++){
            list[i] = i+1;
        }

        for (int i = 0; i< list.length; i++){
            int index = (int)(Math.random() * list.length);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }

        main.beginAnimation("Random", list);

        for (int i = 0; i< list.length; i++){
            list[i] = (1+ i / (size /4) * (size / 4));
        }

        for (int i = 0; i < list.length; i++){
            int index = (int)(Math.random() * list.length);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }

        main.beginAnimation("few unique", list);

        for (int i = 0; i<list.length; i++){
            list[i] = size - i;
        }

        main.beginAnimation("Reversed", list);

        for (int i = 0; i < list.length / 2; i++){
            list[i] = i + 1;
        }
        for (int i  = list.length / 2; i<list.length; i++){
            list[i] = i + 2;
        }
        list[list.length - 1]= list.length / 2 + 1;
        main.beginAnimation("Almost Sorted", list);

    }


}























import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Djupp on 28.02.2017.
 */
public class FrameOff extends JFrame {
    private JLabel countLabel;
    private JButton cancelBatton;
    private JButton offButton;
    String message = "";

    public static void main(String[] args) {
        FrameOff app = new FrameOff();
        app.setVisible(true);
        // app.pack();
    }

    public FrameOff() {
        super("Window");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        countLabel = new JLabel("Итого: " + message);
        cancelBatton = new JButton("Cancel");
        offButton = new JButton("Off");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        add(countLabel, BorderLayout.NORTH);
        buttonsPanel.add(cancelBatton);
        buttonsPanel.add(offButton);
        add(buttonsPanel, BorderLayout.SOUTH);
        initListeners();
    }

    private void initListeners() {
        cancelBatton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //отмена выключения
                message = "Отмена!";
                updateWindow();
            }
        });
        offButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sudo shatdown -h now;
                message = "Вырубай!";
                updateWindow();
            }
        });
    }

    private void updateWindow() {
        countLabel.setText("Итог: " + message);
    }
}


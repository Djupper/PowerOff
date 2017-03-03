import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Prog on 03.03.2017.
 */
public class WindowOffPanel extends JFrame {
    private JLabel countLabel;
    private JButton cancelBatton;
    private JButton offButton;
    String message = "";

    //Рсположение окна по центру
    private static void frameDisplayCenter(int sizeWidth, int sizeHeight, JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
    }

    public static void main(String[] args) {

        WindowOffPanel app = new WindowOffPanel();
        app.setVisible(true);
        frameDisplayCenter(700, 600, app);

    }

    public WindowOffPanel() {
        super("Пробное окно");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //расположение кнопо

        JLabel countLabel = new JLabel("Итого: " + message);
        JButton cancelBatton = new JButton("Cancel");
        JButton offButton = new JButton("Off");

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setLayout(null);

        countLabel.setSize(50,50);
        countLabel.setLocation(350,50);
        buttonsPanel.add(countLabel);

        cancelBatton.setSize(100, 100);
        cancelBatton.setLocation(200, 250);
        buttonsPanel.add(cancelBatton);

        offButton.setSize(100, 100);
        offButton.setLocation(400, 250);
        buttonsPanel.add(offButton);

        add(buttonsPanel);
        setSize(700, 500);
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

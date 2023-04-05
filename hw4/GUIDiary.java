import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class GUIDiary extends JFrame {
    private JButton buttonBack = new JButton("Назад");
    private JButton buttonForward = new JButton("Вперед");
    private JButton buttonUnload = new JButton("Выгрузить ежедневник");
    private JButton buttonDelete = new JButton("Удалить");
    private JLabel text = new JLabel("");
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private int count;

    public GUIDiary(Diary diary) {
        super("Ежедневник");
        this.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 100, 400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        text.setText((diary.getTask(count)).toString());
        checkCount(diary);

        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridwidth = 1;
        constraints.gridy = 0;
        constraints.gridx = 0;
        container.add(buttonBack, constraints);
        buttonBack.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                changeTask(diary, "back");
            }
        });

        constraints.gridwidth = 1;
        constraints.gridy = 0;
        constraints.gridx = 1;
        container.add(buttonUnload, constraints);
        buttonUnload.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                File file = new File("Ежедневник.txt");
                diary.writeDiary(file);
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        constraints.gridwidth = 1;
        constraints.gridy = 0;
        constraints.gridx = 2;
        container.add(buttonForward, constraints);
        buttonForward.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                changeTask(diary, "forward");
            }

        });

        constraints.weighty = 1.0;
        constraints.gridwidth = 3;
        constraints.gridy = 1;
        constraints.gridx = 0;
        container.add(text, constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 2;
        constraints.gridx = 2;
        container.add(buttonDelete, constraints);
        buttonDelete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deletTask(diary);
            }
        });
    }

    private void checkCount(Diary diary) {
        if (count == 0) {
            if (diary.getSize() <= 1) {
                buttonForward.setEnabled(false);
            } else {
                buttonForward.setEnabled(true);
            }
            buttonBack.setEnabled(false);
        } else if (count == diary.getSize() - 1 && count != 0) {
            buttonForward.setEnabled(false);
            buttonBack.setEnabled(true);
        } else {
            buttonForward.setEnabled(true);
            buttonBack.setEnabled(true);
        }
    }

    private void changeTask(Diary diary, String action) {
        switch (action) {
            case "back":
                count--;
                break;
            case "forward":
                count++;
                break;
        }
        checkCount(diary);
        text.setText((diary.getTask(count)).toString());
    }

    private void deletTask(Diary diary) {
        if (count == diary.getSize() - 1) {
            if (diary.getSize() == 1) {
                diary.deletTask(count);
                text.setText("");
                buttonDelete.setEnabled(false);
            } else {
                diary.deletTask(count);
                count--;
                text.setText((diary.getTask(count)).toString());
            }
        } else {
            diary.deletTask(count);
            text.setText((diary.getTask(count)).toString());
        }
        checkCount(diary);
    }
}

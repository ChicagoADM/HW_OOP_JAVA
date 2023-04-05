import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIAddTasks extends JFrame {
    private JButton buttonTransition = new JButton("Ежедневник");
    private JLabel label = new JLabel(
            "<html>Введите задачу и выберите срок выполнения.<br>Для добавление в ежедневник нажмите на кнопку</html>");

    private JTextField input = new JTextField("", 20);
    private JRadioButton radio1 = new JRadioButton("1-3 дня");
    private JRadioButton radio2 = new JRadioButton("3-7 дней");
    private JRadioButton radio3 = new JRadioButton("2-3 недели");
    private JButton buttonAddTask = new JButton("Добавить");
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public GUIAddTasks(Diary diary) {
        super("Добавление задач");
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 150, 300,
                300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0;
        constraints.gridy = 0;

        constraints.weighty = 1.0;
        constraints.gridwidth = 1;
        constraints.gridy = 0;
        constraints.gridx = 2;
        container.add(buttonTransition, constraints);
        buttonTransition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                diary.sortByFinishDate();
                diary.printDiary();
                GUIDiary guiDiary = new GUIDiary(diary);
            }
        });

        constraints.weighty = 1.0;
        constraints.gridwidth = 3;
        constraints.gridy = 1;
        constraints.gridx = 0;
        container.add(label, constraints);

        constraints.gridwidth = 3;
        constraints.gridy = 2;
        constraints.gridx = 0;
        container.add(input, constraints);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        constraints.gridwidth = 1;
        constraints.gridy = 3;
        constraints.gridx = 0;
        container.add(radio1, constraints);
        radio1.setSelected(true);

        group.add(radio2);
        constraints.gridwidth = 1;
        constraints.gridy = 3;
        constraints.gridx = 1;
        container.add(radio2, constraints);

        group.add(radio3);
        constraints.gridwidth = 1;
        constraints.gridy = 3;
        constraints.gridx = 2;
        container.add(radio3, constraints);

        constraints.weighty = 1.0;
        constraints.gridy = 4;
        constraints.gridx = 1;
        container.add(buttonAddTask, constraints);
        buttonAddTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String string = input.getText();

                if (radio1.isSelected()) {
                    diary.addTask(new Task(string, Priority.URGENTLY));
                } else if (radio2.isSelected()) {
                    diary.addTask(new Task(string, Priority.STANDART));
                } else {
                    diary.addTask(new Task(string, Priority.LONG));
                }

                JOptionPane.showMessageDialog(null, "Задача добавлена",
                        "Уведомление",
                        JOptionPane.PLAIN_MESSAGE);
                input.setText("");
                radio1.setSelected(true);

            }
        });

    }

}

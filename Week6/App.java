import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JFrame frame;
    JPanel containPanel, buttoPanel;
    JLabel item;
    JLabel text;
    JButton backButton, nextButton;
    ImageIcon[] images = new ImageIcon[3];
    int imageIndex;

    public App() {
        imageIndex = 0;
        frame = new JFrame("Image");
        text = new JLabel("圖片1", JLabel.CENTER);
        backButton = new JButton("上一張");
        nextButton = new JButton("下一張");
        backButton.addActionListener(this);
        nextButton.addActionListener(this);
        item = new JLabel();
        ImageIcon img1 = new ImageIcon("Image1.jpg");
        ImageIcon img2 = new ImageIcon("Image2.jpg");
        ImageIcon img3 = new ImageIcon("Image3.jpg");
        images[0] = new ImageIcon(img1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        images[1] = new ImageIcon(img2.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        images[2] = new ImageIcon(img3.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        item.setIcon(images[imageIndex]);
        containPanel = new JPanel();
        buttoPanel = new JPanel();
        containPanel.setLayout(new GridBagLayout());

        buttoPanel.setLayout(new GridBagLayout());
        GridBagConstraints innerGbc = new GridBagConstraints();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        containPanel.add(text, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        containPanel.add(item, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        // backButton.setMinimumSize(new Dimension(600, 600));
        // backButton.setPreferredSize(new Dimension(600, 600));
        innerGbc.gridx = 0;
        innerGbc.gridy = 0;
        buttoPanel.add(backButton, innerGbc);
        innerGbc.gridx = 1;
        buttoPanel.add(nextButton, innerGbc);

        containPanel.add(buttoPanel, gbc);
        add(containPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {

            if (imageIndex == 2) {
                JOptionPane.showMessageDialog(null, "沒有圖了", "圖片",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            ++imageIndex;
            text.setText("圖片" + (imageIndex + 1));
            item.setIcon(images[imageIndex]);
        }
        if (e.getSource() == backButton) {

            if (imageIndex == 0) {
                JOptionPane.showMessageDialog(null, "沒有圖了", "圖片",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            imageIndex--;
            text.setText("圖片" + (imageIndex + 1));
            item.setIcon(images[imageIndex]);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
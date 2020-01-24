package CalcHeart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class mainGUI extends JFrame{
    private JPanel panel1;
    private JButton calcbtn;
    private JButton dbLIstbtn;
    private JButton infobtn;
    private JLabel ImageLabel;
    private JButton exitbtn;
    private JButton deleteElement;
    private JButton infoBtn;

    public mainGUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ΠΑΡΑΔΕΙΓΜΑ ΛΙΣΤΑΣ");
        this.setContentPane(panel1);
        this.pack();
        setLocationRelativeTo(null);

        calcbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new calc();
                frame.setSize(750,500);
                frame.setVisible(true);
            }
        });
        dbLIstbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new listDBGUI();
                frame.setSize(1200,700);
                setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        deleteElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new deleteGUI();
                frame.setSize(750,500);
                //setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        infoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel1, "Προγραμματιστές : Δέσποινα Αλεξιάδου και Ψαλτάκης Νικόλαος"
                                + "(c)2019 - 2020",
                        "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new mainGUI();
        frame.setSize(550,500);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void createUIComponents() {
        ImageLabel = new JLabel(new ImageIcon("image.jpg"));
    }
}

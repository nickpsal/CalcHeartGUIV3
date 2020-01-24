package CalcHeart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class calc extends JFrame{
    private JPanel calcPanel;
    private JTextField nameTextfield;
    private JTextField eponTextfield;
    private JTextField dateofBirthTextfield;
    private JButton calcBtn;
    private JButton clear;

    public calc() {
        int etos = Calendar.getInstance().get(Calendar.YEAR);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("ΠΑΡΑΔΕΙΓΜΑ ΛΙΣΤΑΣ");
        this.setContentPane(calcPanel);
        setLocationRelativeTo(null);
        this.pack();
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextfield.setText("");
                eponTextfield.setText("");
                dateofBirthTextfield.setText("");
            }
        });
        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dateofBirthTextfield.getText().length() !=4) {
                    JOptionPane.showMessageDialog(calcPanel, "ΔΕΝ ΕΔΩΣΕΣ ΣΩΣΤΗ ΧΡΟΝΟΛΟΓΙΑ",
                            "ΠΡΟΣΟΧΗ", JOptionPane.INFORMATION_MESSAGE);
                }else if ((nameTextfield.getText().equals("")) || (eponTextfield.getText().equals(""))) {
                    JOptionPane.showMessageDialog(calcPanel, "ΔΕΝ ΣΥΜΠΛΗΡΩΣΑΤΕ ΟΛΑ ΤΑ ΠΕΔΙΑ",
                            "ΠΡΟΣΟΧΗ", JOptionPane.INFORMATION_MESSAGE);
                }
                String name = nameTextfield.getText();
                String epon = eponTextfield.getText();
                int year = Integer.parseInt(dateofBirthTextfield.getText());
                int age = etos - year;
                int MaxHeartRate = 220 - age;
                double maxHeartRate05 = MaxHeartRate * 0.5d;
                double maxHeartRate085 = MaxHeartRate * 0.85d;
                JOptionPane.showMessageDialog(calcPanel, "Ο " + name + " " + epon + " γεννήθηκε το " + year +" και είναι " + age + ". Το εύρος καρδιακού ρυθμού είναι από " + maxHeartRate05 + "% εως " + maxHeartRate085 + "%" ,
                        "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);

                String min = Double.toString(maxHeartRate05);
                String max = Double.toString(maxHeartRate085);
                //Εισαγωγή στην βάση Δεδομένων
                //URL ΣΥΝΔΕΣΗΣ
                String url = "jdbc:mysql://localhost:3306/calcHeart?serverTimezone=UTC&characterEncoding=UTF-8";
                //ΟΝΟΜΑ ΧΡΗΣΤΗ ΚΑΙ ΚΩΔΙΚΟΣ ΠΡΟΣΑΒΑΣΗΣ
                String user = "root";
                String pass = "";
                //ΕΡΩΤΗΜΑ
                String query = "INSERT IGNORE INTO calcHeart (id,onoma,eponimo,etos,ilikia,min,max) VALUES (default,?, ?, ?, ?, ?, ?)";

                try {
                    // 1. Σύνδεση με την βάση δεδομένων
                    Connection con= DriverManager.getConnection(url,user,pass);

                    PreparedStatement stmt=con.prepareStatement(query);
                    // 2. Στείχεια που θα αποθηκευτουν
                    stmt.setString(1, name);
                    stmt.setString(2, epon);
                    stmt.setInt(3, year);
                    stmt.setInt(4, age);
                    stmt.setString(5, min);
                    stmt.setString(6, max);

                    int i = stmt.executeUpdate();
                    //Ελεγχος αν περάστηκε ή οχι η εγγραφή στην Βάση Δεδομένων
                    if (i == 0) {
                        JOptionPane.showMessageDialog(calcPanel, "Υπαρχεί ήδη εγγραφή με αυτό το Επώνυμο.",
                                "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(calcPanel, "Επιτυχής Αποθήκευση στην Βάση Δεδομένων!!!",
                                "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (Exception exc) {
                    exc.printStackTrace();
                }

                //Τελος Εισαγωγής στην βάση δεσομένων
            }
        });
    }
}

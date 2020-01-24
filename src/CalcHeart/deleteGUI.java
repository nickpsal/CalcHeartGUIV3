package CalcHeart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class deleteGUI extends JFrame{
    private JPanel panel;
    private JTextField deleteTextField;
    private JButton DeleteBtn;
    private JButton clearBtn;

    public deleteGUI() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("ΠΑΡΑΔΕΙΓΜΑ ΛΙΣΤΑΣ");
        this.setContentPane(panel);
        setLocationRelativeTo(null);
        this.pack();
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTextField.setText("");
            }
        });
        DeleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url =  "jdbc:mysql://localhost:3306/calcHeart?serverTimezone=UTC&characterEncoding=UTF-8";
                String user = "root";
                String pass = "";
                Statement st;
                ResultSet rs;

                try {
                    Connection myConn = DriverManager.getConnection(url, user, pass);
                    String del = deleteTextField.getText();
                    String query = "DELETE FROM calcHeart WHERE EPONIMO = ?";
                    PreparedStatement stmt=myConn.prepareStatement(query);
                    stmt.setString(1,del);
                    int choice = JOptionPane.showConfirmDialog(new JFrame(),
                            "ΔΙΑΓΡΑΦΗ ΑΠΟ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ????",
                            "ΕΠΙΒΕΒΑΙΩΣΗ ΔΙΑΓΡΑΦΗΣ",
                            JOptionPane.YES_NO_OPTION);
                    if (choice == 0) {
                        int i = stmt.executeUpdate();
                        if (i != 0) {
                            JOptionPane.showMessageDialog(panel, "Η ΕΓΓΡΑΦΗ ΔΙΑΓΡΑΦΤΗΚΕ ΜΕ ΕΠΙΤΥΧΙΑ ΑΠΟ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ",
                                    "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(panel, "Η ΕΓΓΡΑΦΗ ΔΕΝ ΒΡΕΘΗΚΕ ΣΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ",
                                    "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

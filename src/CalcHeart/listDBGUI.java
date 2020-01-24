package CalcHeart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class listDBGUI extends JFrame{
    private DefaultListModel<Object> listModel;
    //private ArrayList<List> mysqlList;
    private JPanel panel;
    private JList list1;


    public listDBGUI() {
        //mysqlList = new ArrayList<List>();
        listModel = new DefaultListModel();
        list1.setModel(listModel);

        String url =  "jdbc:mysql://localhost:3306/calcHeart?serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String pass = "";
        Statement st;
        ResultSet rs;

        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            st = myConn.createStatement();
            rs = st.executeQuery("SELECT * FROM calcHeart");
            while(rs.next()) {
                List l = new List(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7));
                //mysqlList.add(l);
                listModel.addElement(l.toString());
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("ΑΝΑΚΤΗΣΗ ΣΤΟΙΧΕΙΩΝ ΑΠΟ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ");
        this.setContentPane(panel);
        this.setResizable(false);
        this.pack();

    }
}

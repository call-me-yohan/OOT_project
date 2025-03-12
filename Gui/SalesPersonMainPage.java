package Gui;
import Classes.User;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class SalesPersonMainPageForm extends JFrame{

    private JLabel WelcomeMsg, FilterText;
    private JLabel[] Orders;
    private JButton PlaceOrd, ViewReport,Logout;
    private JComboBox OrderFilter;
    private JCheckBox completed,pending;
    private ButtonGroup CheckBoxes;
    private JPanel main,buttons,Filtering,orderPanel;

    class orderListener extends Frame implements MouseListener {

        public orderListener(){

        }

    public void mousePressed(MouseEvent e)
    {
        
        
    }

    public void mouseReleased(MouseEvent e)
    {

    }

    // this function is invoked when the mouse exits the component
    public void mouseExited(MouseEvent e)
    {

        
    }

    // this function is invoked when the mouse enters the component
    public void mouseEntered(MouseEvent e)
    {
        
    
    }

    // this function is invoked when the mouse is pressed or released
    public void mouseClicked(MouseEvent e)
    {

    }
}




public class StatusFilter implements ActionListener{

    public void actionPerformed(ActionEvent ae){
        String url = "jdbc:mysql://localhost:3306/CTextile";
        String user = "Yohan";
        String password = "Cocovovo39";
        String SqlQuery = "";

        if (pending.isSelected()){
            SqlQuery = "SELECT * FROM Orders WHERE NOT Status = 'Delivered'";
        }else if(completed.isSelected()){
            SqlQuery = "SELECT * FROM Orders WHERE Status = 'Delivered'";
        }else{
            SqlQuery = "SELECT * FROM Orders";
        }

        int TempOrderId = 0;
        float TempOrderCost = 0;
        String TempOrderDDate = "";
        String TempOrderODate = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            ResultSet rs = conn.createStatement().executeQuery(SqlQuery);
            orderPanel.removeAll();
                orderPanel.revalidate();
                orderPanel.repaint();
            for (int i=0;i<5;i++) { // note this only shows five orders
                
                if (rs.next()) { 
                    TempOrderId = rs.getInt("OrderId");
                    TempOrderCost = rs.getFloat("SubTotal");
                    TempOrderDDate = rs.getString("DeliveryDate");
                    TempOrderODate = rs.getString("OrderDate");
                
                Orders[i] = new JLabel(" * Order no: " + TempOrderId + "| Rs: " + TempOrderCost + "| Due: " + TempOrderDDate + "| Ordered on: " + TempOrderODate);
                Orders[i].setFont(new Font("Serif", Font.PLAIN, 16)); 
                final JLabel Temp =  Orders[i];
                Temp.addMouseListener(new orderListener(){
                   
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        Temp.setFont(new Font("Serif", Font.BOLD, 16)); // to give hover effect 
                    }
        
                    @Override
                    public void mouseExited(MouseEvent e) {
                        Temp.setFont(new Font("Serif", Font.PLAIN, 16)); // to restore 
                    }
                });
                orderPanel.add(Temp);
            } else {
                System.out.println("No data found.");
            }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
 
public class ComboBoxFilter implements ItemListener{


    public void itemStateChanged(ItemEvent ie){
         String url = "jdbc:mysql://localhost:3306/CTextile";
        String user = "Yohan";
        String password = "Cocovovo39";
        String SqlQuery = "";
        int sel = OrderFilter.getSelectedIndex();

        switch (sel) {
            case 1:
                 SqlQuery = "SELECT * FROM Orders ORDER BY DeliveryDate";
                break;

            case 2:
                SqlQuery =  "SELECT * FROM Orders ORDER BY OrderDate";
                break;

            default:
            SqlQuery = "SELECT * FROM Orders ";
               
        }

        int TempOrderId = 0;
        float TempOrderCost = 0;
        String TempOrderDDate = "";
        String TempOrderODate = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            ResultSet rs = conn.createStatement().executeQuery(SqlQuery);
            orderPanel.removeAll();
                orderPanel.revalidate();
                orderPanel.repaint();
            for (int i=0;i<5;i++) { // note this only shows five orders
                
                if (rs.next()) { 
                    TempOrderId = rs.getInt("OrderId");
                    TempOrderCost = rs.getFloat("SubTotal");
                    TempOrderDDate = rs.getString("DeliveryDate");
                    TempOrderODate = rs.getString("OrderDate");
                
                Orders[i] = new JLabel(" * Order no: " + TempOrderId + "| Rs: " + TempOrderCost + "| Due: " + TempOrderDDate + "| Ordered on: " + TempOrderODate);
                Orders[i].setFont(new Font("Serif", Font.PLAIN, 16)); 
                final JLabel Temp =  Orders[i];
    
                Temp.addMouseListener(new orderListener(){
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        Temp.setFont(new Font("Serif", Font.BOLD, 16)); // to give hover effect 
                    }
        
                    @Override
                    public void mouseExited(MouseEvent e) {
                        Temp.setFont(new Font("Serif", Font.PLAIN, 16)); // to restore 
                    }
                });
                orderPanel.add(Temp);
            } else {
                System.out.println("No data found.");
            }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        


    }




}

private class handler implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        SignUpForm b = new SignUpForm();
        dispose();
    }
}
       

    public SalesPersonMainPageForm(User A){

        //javac -cp ".;mysql-connector-java-9.2.0.jar" Gui\SalesPersonMainPage.java (because of that damn driver, to compile)

        String url = "jdbc:mysql://localhost:3306/CTextile";
        String user = "Yohan";
        String password = "Cocovovo39";
        String Username = "NULL";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
            ResultSet rs = conn.createStatement().executeQuery("SELECT Name FROM SalesPerson WHERE UserId = 1");
            if (rs.next()) {
                Username = rs.getString("Name");
            } else {
                System.out.println("No data found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       

        setTitle("Main Page");
        setSize(1000, 1000); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on close
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        

        main = new JPanel(new GridLayout(4,1));

        WelcomeMsg = new JLabel("Welcome " + Username);
        WelcomeMsg.setFont(new Font("Verdana", Font.PLAIN, 30));    
        main.add(WelcomeMsg);

        buttons = new JPanel(new GridLayout(3,1,10,10));
        Logout = new JButton("Log out");
        Logout.addActionListener(new handler());
        PlaceOrd = new JButton("Place new Order");
        ViewReport = new JButton("View Reports");
        buttons.add(PlaceOrd);
        buttons.add(ViewReport);
        buttons.add(Logout);
        

        Filtering = new JPanel(new GridLayout(4,1,10,10));
        String[] options = {"-none-","Delivery date","Order date"};
        OrderFilter = new JComboBox<>(options);
        OrderFilter.addItemListener(new ComboBoxFilter());
        FilterText = new JLabel("Filter By: ");
        completed = new JCheckBox("Find completed orders");
        completed.addActionListener(new StatusFilter());
        pending = new JCheckBox("Find pending orders");
        pending.addActionListener(new StatusFilter());
        CheckBoxes = new ButtonGroup();
        CheckBoxes.add(completed);
        CheckBoxes.add(pending);

        Filtering.add(FilterText);
        Filtering.add(pending);
        Filtering.add(completed);
        Filtering.add(OrderFilter);

        main.add(Filtering);
        
        Orders = new JLabel[5];
        orderPanel = new JPanel(new GridLayout(5,1,5,5));
        JLabel temp = new JLabel();

        int TempOrderId = 0;
        float TempOrderCost = 0;
        String TempOrderDDate = "";
        String TempOrderODate = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Orders ");
            
      
        for (int i=0;i<5;i++) {
            if (rs.next()) { 
                TempOrderId = rs.getInt("OrderId");
                TempOrderCost = rs.getFloat("SubTotal");
                TempOrderDDate = rs.getString("DeliveryDate");
                TempOrderODate = rs.getString("OrderDate");
            
            Orders[i] = new JLabel(" * Order no: " + TempOrderId + "| Rs: " + TempOrderCost + "| Due: " + TempOrderDDate + "| Ordered on: " + TempOrderODate);
            Orders[i].setFont(new Font("Serif", Font.PLAIN, 16)); 
            final JLabel Temp =  Orders[i];

            Temp.addMouseListener(new orderListener(){
                @Override
                public void mouseEntered(MouseEvent e) {
                    Temp.setFont(new Font("Serif", Font.BOLD, 16)); // to give hover effect 
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
                    Temp.setFont(new Font("Serif", Font.PLAIN, 16)); // to restore 
                }
            });
            orderPanel.add(Temp);
        } else {
            System.out.println("No data found.");
        }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

        orderPanel.setBorder(BorderFactory.createTitledBorder("List of orders"));
        main.add(orderPanel);


        add(main);
        add(new JLabel("          "));
        add(buttons);
        setVisible(true);

    }
    

}

class SalesPersonMainPage{
    public static void main(String[] args) {
        SalesPersonMainPageForm a = new SalesPersonMainPageForm(null);
    }
}

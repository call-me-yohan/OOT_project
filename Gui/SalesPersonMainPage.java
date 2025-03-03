package Gui;
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
        System.out.println("wtf");
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
       

    public SalesPersonMainPageForm(){

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

        buttons = new JPanel(new GridLayout(1,3,10,100));
        Logout = new JButton("Log out");
        PlaceOrd = new JButton("Place new Order");
        ViewReport = new JButton("View Reports");
        buttons.add(PlaceOrd);
        buttons.add(ViewReport);
        buttons.add(Logout);
        main.add(buttons);

        Filtering = new JPanel(new GridLayout(4,1,10,10));
        String[] options = {"Item","Delivery date","Order date"};
        OrderFilter = new JComboBox<>(options);
        FilterText = new JLabel("Filter By: ");
        completed = new JCheckBox("Find completed orders");
        pending = new JCheckBox("Find pending orders");
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

        String SqlAddOn = ""; //to change when filtering
        int TempOrderId = 0;
        float TempOrderCost = 0;
        String TempOrderDDate = "";
        String TempOrderODate = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Orders "+ SqlAddOn);
            
      
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
                    Temp.setFont(new Font("Serif", Font.ITALIC, 16)); // to give hover effect 
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
        setVisible(true);

    }
    

}

class SalesPersonMainPage{
    public static void main(String[] args) {
        SalesPersonMainPageForm a = new SalesPersonMainPageForm();
    }
}

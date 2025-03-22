package Gui;
import Classes.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class PlaceOrderForm extends JFrame{
    private SalesPersonMainPageForm SalePersonPage; // reference to previous page

    private ArrayList<JLabel> jl_items;
    private ArrayList<JTextField> jt_Qtys;
    private ArrayList<JButton> jb_removeItems;

    private JScrollPane jsp_item;
    private JLabel jl_selectItem,jl_selectCustomer,jl_selectPayment;
    private JTextField jt_custName,jt_dob,jt_PhoneNo,jt_CustAddress; // for customers
    private JLabel jl_custName,jl_dob,jl_PhoneNo,jl_CustAddress;
    private JButton jb_placeOrder,jb_Return,jb_addItem;
    private JComboBox jc_payment;
    private JPanel Main,jp_Customer,jp_item;
    


    //Event listeners

    public class ReturnToMainPage implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            SalePersonPage.setVisible(true);
            dispose();
        }
    }

    public class AddItemHandler implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            Mixed TempMixed;
            NaturalFiber TempNat;
            ManMadeFiber TempMan;
            // use search page 

            int index = jl_items.size(); // Get current index based on size

            JLabel jl_item = new JLabel("Item " + (index + 1));
            JTextField jt_Qty = new JTextField("1", 5);
            JButton jb_removeItem = new JButton("Remove");

            jl_items.add(jl_item);
            jt_Qtys.add(jt_Qty);
            jb_removeItems.add(jb_removeItem);

            jp_item.add(jl_item);
            jp_item.add(jt_Qty);
            jp_item.add(jb_removeItem);

            jb_removeItem.addActionListener(new RemoveItemHandler(jl_item, jt_Qty, jb_removeItem));
            
            jp_item.revalidate();
            jp_item.repaint();
            

        }


    }

    private class RemoveItemHandler implements ActionListener {
        private JLabel jl_item;
        private JTextField jt_Qty;
        private JButton jb_removeItem;

        RemoveItemHandler(JLabel jl_item, JTextField jt_Qty, JButton jb_removeItem) {
            this.jl_item = jl_item;
            this.jt_Qty = jt_Qty;
            this.jb_removeItem = jb_removeItem;
        }

        public void actionPerformed(ActionEvent e) {
            // Remove components from ArrayLists and Panel
            jl_items.remove(jl_item);
            jt_Qtys.remove(jt_Qty);
            jb_removeItems.remove(jb_removeItem);

            jp_item.remove(jl_item);
            jp_item.remove(jt_Qty);
            jp_item.remove(jb_removeItem);

            jp_item.revalidate();
            jp_item.repaint();
        }
    }




    PlaceOrderForm(SalesPersonMainPageForm SalePersonPage,User U){
        
        super("Place a New Order");
        
        this.SalePersonPage = SalePersonPage; //storing reference of previous page

        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        

        Main = new JPanel(new GridLayout(5,1,1,10));
        

        //items setup
        jl_selectItem = new JLabel("Item(s):");
        jl_selectItem.setFont(new Font("Verdana", Font.PLAIN, 30));
        Main.add(jl_selectItem);
        
        jp_item = new JPanel(new GridLayout(0,3,10,10));
        // remove the below code upon completion [Ping] & change the ammount of cols for the panel
        jl_items = new ArrayList<>();
        jt_Qtys = new ArrayList<>();
        jb_removeItems = new ArrayList<>();


        jsp_item = new JScrollPane(jp_item);
        jsp_item.setPreferredSize(new Dimension(500, 150));
        Main.add(jsp_item);

        JPanel resizebutton = new JPanel(new GridLayout(3,1,10,10));
        jb_addItem = new JButton("Add Item to list");
        jb_addItem.addActionListener(new AddItemHandler());
        resizebutton.add(jb_addItem);
        jb_Return = new JButton("Return");
        jb_Return.addActionListener(new ReturnToMainPage());
        resizebutton.add(jb_Return);
        jb_placeOrder = new JButton("Confirm Order");
        resizebutton.add(jb_placeOrder);

        jl_selectCustomer = new JLabel("Enter Customer's details:");
        jl_selectCustomer.setFont(new Font("Verdana", Font.PLAIN, 30));
        Main.add(jl_selectCustomer);

        jp_Customer = new JPanel(new GridLayout(5,1,10,10));

        jt_custName = new JTextField();
        jl_custName = new JLabel("Enter customer's Name: ");
        jt_dob = new JTextField();
        jl_dob = new JLabel("Enter customer's Date Of Birth: ");
        jt_CustAddress = new JTextField();
        jl_CustAddress = new JLabel("Enter customer's Address: ");
        jt_PhoneNo = new JTextField();
        jl_PhoneNo = new JLabel("Enter customer's Phone Number: ");

        jp_Customer.add(jl_custName);
        jp_Customer.add(jt_custName);
        jp_Customer.add(jl_dob);
        jp_Customer.add(jt_dob);
        jp_Customer.add(jl_CustAddress);
        jp_Customer.add(jt_CustAddress);
        jp_Customer.add(jl_PhoneNo);
        jp_Customer.add(jt_PhoneNo);
        Main.add(jp_Customer);

        add(Main);
        add(resizebutton);
        setVisible(true);
    }

    }


public class PlaceOrder {
    public static void main(String[] args) {
        PlaceOrderForm PlaceOrderPage = new PlaceOrderForm(null,null);
    }
}

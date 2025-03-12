package Gui;
import Classes.*;
import java.awt.*;
import javax.swing.*;

class PlaceOrderForm extends JFrame{
    private JLabel[] jl_item;
    private JTextField[] jt_Qty;
    private JButton[] jb_removeItem;
    private JScrollPane jsp_item;
    private JLabel jl_selectItem,jl_selectCustomer,jl_selectPayment;
    private JTextField jt_custName,jt_dob,jt_PhoneNo,jt_CustAddress; // for customers
    private JLabel jl_custName,jl_dob,jl_PhoneNo,jl_CustAddress;
    private JButton jb_placeOrder,jb_reset,jb_addItem;
    private JComboBox jc_payment;
    private JPanel Main,jp_Customer,jp_item;

    PlaceOrderForm(User U){
        super("Place a New Order");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        Main = new JPanel(new GridLayout(5,1,1,10));
        

        //items setup
        jl_selectItem = new JLabel("Item(s):");
        jl_selectItem.setFont(new Font("Verdana", Font.PLAIN, 30));
        Main.add(jl_selectItem);
        
        jp_item = new JPanel(new GridLayout(7,3,10,10));
        jl_item = new JLabel[7];
        jt_Qty = new JTextField[7];
        jb_removeItem = new JButton[7];

        for (int i=0;i<7;i++) {
            jl_item[i]= new JLabel("item "+ (i+1));
            jt_Qty[i] = new JTextField("1");
            jb_removeItem[i] = new JButton("Remove");
            jp_item.add(jl_item[i]);
            jp_item.add(jt_Qty[i]);
            jp_item.add(jb_removeItem[i]);
        }  

        jsp_item = new JScrollPane(jp_item);
        jsp_item.setPreferredSize(new Dimension(500, 150));
        Main.add(jsp_item);

        JPanel resizebutton = new JPanel(new GridLayout(3,1,10,10));
        jb_addItem = new JButton("Add Item to list");
        resizebutton.add(jb_addItem);
        jb_reset = new JButton("Reset");
        resizebutton.add(jb_reset);
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
        PlaceOrderForm a = new PlaceOrderForm(null);
    }
}

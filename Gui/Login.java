package Gui;
import Classes.User;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class LoginPage extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    
    class LoginHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String UserType = "";
            int UserID = -100;

            String url = "jdbc:mysql://localhost:3306/CTextile";
            String user = "Yohan";
            String DBpassword = "Cocovovo39";
            String SqlQuery = "SELECT * FROM Login WHERE Email = '" +email +"'";

            try (Connection conn = DriverManager.getConnection(url, user, DBpassword)) {
                ResultSet rs = conn.createStatement().executeQuery(SqlQuery);
                if(rs.next()){
                    if(password.equals(rs.getString("Password"))){
                        UserType = rs.getString("UserType");
                        UserID = rs.getInt("UserId");
                        SqlQuery = "SELECT * FROM " + UserType + " WHERE UserId = " + Integer.toString(UserID);
                        rs = conn.createStatement().executeQuery(SqlQuery);
                       
                        if(rs.next()){
                            User CurrUser = new User(rs.getString("Name"), password, UserType);
                            SalesPersonMainPageForm CurrMainPage = new SalesPersonMainPageForm(CurrUser);
                            dispose();
                        }
    
                    }
                }else{
                        emailField.setText("invalid credentials");
                        passwordField.setText("");
                    }
                

            }catch(Exception Err){

                System.out.println("Error in connecting to database");
            }       
            
        }
    
    
    }

    public LoginPage() {
        setTitle("Login System");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel emailLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        emailField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(loginButton);

        loginButton.addActionListener(new LoginHandler());
        
        add(panel, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}



class Login{

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            LoginPage login = new LoginPage();
            login.setVisible(true);
        });
    }

}
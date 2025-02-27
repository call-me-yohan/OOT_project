
import java.awt.*;
import javax.swing.*;

class SignUpForm extends JFrame {
    private JTextField FirstName, LastName, OtherNames,Email,DOBDate,DOBMonth,DOBYear;
    private JLabel FirstNameLabel,LastNameLabel, OtherNamesLabel,EmailLabel,GenderText, PassWrdLabel, ConfirmWrdLabel , DOBLabel,DD,DM,DY, UserLabel;
    private JButton register,reset,login;
    private JPasswordField Passwrd, ConfirmPasswrd;
    private JComboBox UserType; 
    private ButtonGroup Gradio;
    private JRadioButton  GenderM,GenderF,GenderP;
    private JPanel main, Names,PWD,GenderSelection,UserSelection, date,DOBPrompt ,ButtonP;

    public SignUpForm(){
        setTitle("Sign up Form");
        setSize(1000, 1000); // Set frame size
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on close
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        main = new JPanel(new GridLayout(6,1));

        Names = new JPanel(new GridLayout(4,2,2,10));
        FirstNameLabel = new JLabel("First name : ");
        FirstName = new JTextField();
        LastNameLabel = new JLabel("Last name : ");
        LastName = new JTextField();
        OtherNamesLabel = new JLabel("Other names : ");
        OtherNames = new JTextField();
        EmailLabel = new JLabel("Email : ");
        Email = new JTextField();
        Names.add(FirstNameLabel);
        Names.add(FirstName);
        Names.add(LastNameLabel);
        Names.add(LastName);
        Names.add(OtherNamesLabel);
        Names.add(OtherNames);
        Names.add(EmailLabel);
        Names.add(Email);

        DOBPrompt = new JPanel(new GridLayout(2,1));
        DOBLabel = new JLabel("Enter your date of birth : ");

        date = new JPanel(new GridLayout(1,6,5,5));
        DD = new JLabel("Date: ");
        DOBDate = new JTextField();
        DM = new JLabel("Month: ");
        DOBMonth = new JTextField() ;
        DY = new JLabel("Year: ");
        DOBYear = new JTextField();    
        date.add(DD);
        date.add(DOBDate);
        date.add(DM);
        date.add(DOBMonth);
        date.add(DY);
        date.add(DOBYear);

        DOBPrompt.add(DOBLabel);
        DOBPrompt.add(date);



        GenderSelection = new JPanel(new GridLayout(1,4,5,5));
        GenderText = new JLabel("Enter your gender : ");
        GenderM = new JRadioButton("Male");
        GenderF = new JRadioButton("Female");
        GenderP = new JRadioButton("Prefer not to say");
        Gradio = new ButtonGroup();
        Gradio.add(GenderM);
        Gradio.add(GenderF);
        Gradio.add(GenderP);
        GenderSelection.add(GenderText);
        GenderSelection.add(GenderM);
        GenderSelection.add(GenderF);
        GenderSelection.add(GenderP);

        
        PWD = new JPanel(new GridLayout(3,2,2,20));
        PassWrdLabel = new JLabel("Enter your password : ");
        Passwrd = new JPasswordField();
        ConfirmWrdLabel = new JLabel("Confirm your password : ");
        ConfirmPasswrd = new JPasswordField();
        PWD.add(PassWrdLabel);
        PWD.add(Passwrd);
        PWD.add(ConfirmWrdLabel);
        PWD.add(ConfirmPasswrd);


        ButtonP = new JPanel(new GridLayout(2,3,30,5));

        UserSelection = new JPanel(new BorderLayout());
        String[] Users = {"ISA Manager","Sales Persons","Inventory Officer"};
        UserLabel = new JLabel("Registrating as a : ");
        UserType = new JComboBox<>(Users);
        UserSelection.add(UserLabel,BorderLayout.WEST);
        UserSelection.add(UserType,BorderLayout.EAST);
        ButtonP.add(UserSelection);


        login = new JButton("Already Registered ?");
        register = new JButton("Register");
        reset = new JButton("Reset");
        ButtonP.add(login);
        ButtonP.add(register);
        ButtonP.add(reset);



        main.add(Names);
        main.add(DOBPrompt);
        main.add(GenderSelection);
        main.add(PWD);
        main.add(ButtonP);
        
        add(main);
        setVisible(true);


    }

    
    
    






    
}

class SignUp{
    public static void main(String[] args) {
        SignUpForm a = new SignUpForm();
    
    }

}

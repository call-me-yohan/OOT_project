import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PaymentPage extends JFrame {
    private JComboBox<String> paymentMethodComboBox;
    private JPanel paymentDetailsPanel;
    private JButton submitButton, clearButton;

    // Cash components
    private JTextField customerNameCashField, totalPriceCashField, cashAmountField;
    
    // Check components
    private JTextField customerNameCheckField, totalPriceCheckField, checkNumberField, bankNameField;
    
    // Card components
    private JTextField customerNameCardField, totalPriceCardField, cardNumberField, expiryDateField;

    public PaymentPage() {
        setTitle("Payment Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // Title Panel
        JLabel titleLabel = new JLabel("Payment System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Payment Method Selection
        JPanel methodPanel = createMethodPanel();
        add(methodPanel, BorderLayout.NORTH);

        // Payment Details Panel
        paymentDetailsPanel = new JPanel(new CardLayout());
        setupPaymentPanels();
        add(paymentDetailsPanel, BorderLayout.CENTER);

        // Submit Button
        submitButton = new JButton("Process Payment");
        submitButton.addActionListener(new SubmitListener());
        submitButton.setPreferredSize(new Dimension(150, 40));

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(150, 40));
        clearButton.addActionListener(new ClearListener());

        // Button panel with both buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel createMethodPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel.add(new JLabel("Payment Method:"));
        paymentMethodComboBox = new JComboBox<>(new String[]{"Cash", "Check", "Card"});
        paymentMethodComboBox.addActionListener(new MethodListener());
        panel.add(paymentMethodComboBox);
        return panel;
    }

    private void setupPaymentPanels() {
        // Cash Panel
        JPanel cashPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        customerNameCashField = createTextField(15);
        totalPriceCashField = createTextField(15);
        cashAmountField = createTextField(15);
        cashPanel.add(createFieldRow("Customer Name:", customerNameCashField));
        cashPanel.add(createFieldRow("Total Price (Rs):", totalPriceCashField));
        cashPanel.add(createFieldRow("Amount Tendered:", cashAmountField));

        // Check Panel
        JPanel checkPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        customerNameCheckField = createTextField(15);
        totalPriceCheckField = createTextField(15);
        checkNumberField = createTextField(15);
        bankNameField = createTextField(15);
        checkPanel.add(createFieldRow("Customer Name:", customerNameCheckField));
        checkPanel.add(createFieldRow("Total Price (Rs):", totalPriceCheckField));
        checkPanel.add(createFieldRow("Check Number:", checkNumberField));
        checkPanel.add(createFieldRow("Bank Name:", bankNameField));

        // Card Panel
        JPanel cardPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        customerNameCardField = createTextField(15);
        totalPriceCardField = createTextField(15);
        cardNumberField = createTextField(15);
        expiryDateField = createTextField(15);
        cardPanel.add(createFieldRow("Customer Name:", customerNameCardField));
        cardPanel.add(createFieldRow("Total Price (Rs):", totalPriceCardField));
        cardPanel.add(createFieldRow("Card Number:", cardNumberField));
        cardPanel.add(createFieldRow("Expiry (MM/YY):", expiryDateField));

        paymentDetailsPanel.add(cashPanel, "Cash");
        paymentDetailsPanel.add(checkPanel, "Check");
        paymentDetailsPanel.add(cardPanel, "Card");
    }

    private JTextField createTextField(int columns) {
        return new JTextField(columns);
    }

    private JPanel createFieldRow(String label, JComponent field) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
        panel.add(new JLabel(label));
        panel.add(field);
        return panel;
    }

    private class MethodListener implements ActionListener { //to handle interface of payment method selection changes
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) paymentDetailsPanel.getLayout();
            cl.show(paymentDetailsPanel, (String) paymentMethodComboBox.getSelectedItem());
        }
    }

    private class SubmitListener implements ActionListener {  
        public void actionPerformed(ActionEvent e) {
            //action listener for submit bbutton
        }
    }

    private class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String method = (String) paymentMethodComboBox.getSelectedItem();
            switch(method) {
                case "Cash":
                    customerNameCashField.setText("");
                    totalPriceCashField.setText("");
                    cashAmountField.setText("");
                    break;
                case "Check":
                    customerNameCheckField.setText("");
                    totalPriceCheckField.setText("");
                    checkNumberField.setText("");
                    bankNameField.setText("");
                    break;
                case "Card":
                    customerNameCardField.setText("");
                    totalPriceCardField.setText("");
                    cardNumberField.setText("");
                    expiryDateField.setText("");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaymentPage());
    }
}
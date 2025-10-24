import java.awt.*;
import java.io.FileWriter;
import javax.swing.*;

public class AddExpensePanel extends JPanel {
    JTextField amountField, noteField;
    JComboBox<String> categoryBox;
    JButton saveBtn;

    public AddExpensePanel() {
        setLayout(null);
        setBackground(new Color(245, 247, 250));

        JLabel title = new JLabel("➕ Add New Expense");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBounds(330, 40, 300, 40);
        add(title);

        JLabel lblAmt = new JLabel("Amount (₹):");
        JLabel lblCat = new JLabel("Category:");
        JLabel lblNote = new JLabel("Note:");

        lblAmt.setBounds(250, 120, 100, 30);
        lblCat.setBounds(250, 180, 100, 30);
        lblNote.setBounds(250, 240, 100, 30);

        amountField = new JTextField();
        amountField.setBounds(350, 120, 250, 30);
        categoryBox = new JComboBox<>(new String[]{"Food", "Transport", "Shopping", "Bills", "Other"});
        categoryBox.setBounds(350, 180, 250, 30);
        noteField = new JTextField();
        noteField.setBounds(350, 240, 250, 30);

        saveBtn = new JButton("💾 Save Expense");
        saveBtn.setBounds(370, 320, 200, 40);
        saveBtn.setBackground(new Color(33, 69, 107));
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        saveBtn.setFocusPainted(false);
        saveBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        add(lblAmt); add(lblCat); add(lblNote);
        add(amountField); add(categoryBox); add(noteField); add(saveBtn);

        saveBtn.addActionListener(e -> saveExpense());
    }

    void saveExpense() {
        try (FileWriter fw = new FileWriter("src/expenses.txt", true)) {
            fw.write(amountField.getText() + "," + categoryBox.getSelectedItem() + "," + noteField.getText() + "\n");
            JOptionPane.showMessageDialog(this, "✅ Expense saved successfully!");
            amountField.setText("");
            noteField.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

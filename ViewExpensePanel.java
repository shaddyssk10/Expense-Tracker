import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class ViewExpensePanel extends JPanel {
    JTable table;
    DefaultTableModel model;
    JButton loadBtn;

    public ViewExpensePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));

        JLabel title = new JLabel("📋 View Expenses", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        model = new DefaultTableModel(new String[]{"Amount (₹)", "Category", "Note"}, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        loadBtn = new JButton("🔄 Refresh Data");
        loadBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loadBtn.setBackground(new Color(33, 69, 107));
        loadBtn.setForeground(Color.WHITE);
        loadBtn.setFocusPainted(false);
        loadBtn.addActionListener(e -> loadData());

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(loadBtn, BorderLayout.SOUTH);
    }

    void loadData() {
        model.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("src/expenses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "⚠️ No data found yet!");
        }
    }
}

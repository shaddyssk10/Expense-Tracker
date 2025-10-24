import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class SummaryPanel extends JPanel {
    JLabel totalLabel;
    JTextArea summaryArea;

    public SummaryPanel() {
        setLayout(null);
        setBackground(new Color(245, 247, 250));

        JLabel title = new JLabel("📊 Expense Summary");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBounds(330, 40, 300, 40);
        add(title);

        totalLabel = new JLabel("Total: ₹0");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        totalLabel.setBounds(380, 100, 300, 30);
        add(totalLabel);

        summaryArea = new JTextArea();
        summaryArea.setBounds(250, 160, 400, 250);
        summaryArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        summaryArea.setEditable(false);
        summaryArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(summaryArea);

        JButton refresh = new JButton("🔁 Refresh Summary");
        refresh.setBounds(370, 430, 180, 40);
        refresh.setBackground(new Color(33, 69, 107));
        refresh.setForeground(Color.WHITE);
        refresh.setFont(new Font("Segoe UI", Font.BOLD, 14));
        refresh.setFocusPainted(false);
        refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(refresh);

        refresh.addActionListener(e -> calculateSummary());
    }

    void calculateSummary() {
        double total = 0;
        HashMap<String, Double> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/expenses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                double amt = Double.parseDouble(d[0]);
                total += amt;
                map.put(d[1], map.getOrDefault(d[1], 0.0) + amt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "⚠️ No data found!");
        }

        totalLabel.setText("Total: ₹" + total);
        summaryArea.setText("");
        for (String cat : map.keySet()) {
            summaryArea.append(cat + " → ₹" + map.get(cat) + "\n");
        }
    }
}

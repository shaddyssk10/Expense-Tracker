import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    CardLayout layout = new CardLayout();
    JPanel mainPanel = new JPanel(layout);

    public MainFrame() {
        // Window setup
        setTitle("💰 ExpenseWise – Personal Finance Tracker");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panels (pages)
        AddExpensePanel addPanel = new AddExpensePanel();
        ViewExpensePanel viewPanel = new ViewExpensePanel();
        SummaryPanel summaryPanel = new SummaryPanel();

        mainPanel.add(addPanel, "Add");
        mainPanel.add(viewPanel, "View");
        mainPanel.add(summaryPanel, "Summary");

        // Navigation Bar (top)
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        navBar.setBackground(new Color(33, 69, 107));

        JLabel logo = new JLabel("ExpenseWise 💰");
        logo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        logo.setForeground(Color.WHITE);

        JButton addBtn = createNavButton("➕ Add Expense");
        JButton viewBtn = createNavButton("📋 View Expenses");
        JButton summaryBtn = createNavButton("📊 Summary");

        addBtn.addActionListener(e -> layout.show(mainPanel, "Add"));
        viewBtn.addActionListener(e -> layout.show(mainPanel, "View"));
        summaryBtn.addActionListener(e -> layout.show(mainPanel, "Summary"));

        navBar.add(logo);
        navBar.add(addBtn);
        navBar.add(viewBtn);
        navBar.add(summaryBtn);

        add(navBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        getContentPane().setBackground(new Color(245, 247, 250));
        setVisible(true);
    }

    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        btn.setForeground(new Color(33, 69, 107));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(230, 230, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(Color.WHITE);
            }
        });
        return btn;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

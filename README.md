# 💰 ExpenseWise: Personal Finance Tracker (Java Swing)

ExpenseWise is a robust, modular desktop application built using **Java Swing** designed to help users efficiently track, categorize, and summarize their personal spending. This project demonstrates strong skills in Java GUI development, event-driven programming, and local data persistence.

## ✨ Features

* **Clean, Intuitive GUI:** Built with **Java Swing** using a **`CardLayout`** for smooth, modern navigation between core modules.
* **Add Expenses:** Quickly log new transactions with Amount, Category, and a Note.
* **Data Persistence:** Expenses are immediately saved to a local CSV file (`expenses.txt`) using **Java File I/O**.
* **View Expenses:** Displays all saved records in an interactive, refreshing **`JTable`**.
* **Summary & Analysis:** Provides essential financial insights, including **Total Spending** and a granular **category-wise breakdown** using **`HashMap`** for data aggregation.

## 🚀 How to Run the Project

### Prerequisites
* Java Development Kit (JDK) 8 or newer installed.
* An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or VS Code.

### Steps

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/YourUsername/ExpenseWise.git](https://github.com/laksh0777/ExpenseWise.git)
    cd ExpenseWise
    ```

2.  **Open in IDE:**
    * Open the project folder in your preferred Java IDE.

3.  **Compile and Run:**
    * Locate the main class, **`MainFrame.java`**.
    * Run the application directly from the IDE.

## 💻 Tech Stack

| Technology | Purpose |
| :--- | :--- |
| **Java** | Core programming language |
| **Swing** & **AWT** | Graphical User Interface (GUI) and Styling |
| **File I/O** | Data persistence (reading/writing to `expenses.txt`) |
| **Collections** | Data processing and analysis (`HashMap` for summary) |

## 📁 Project Structure

The application is modular, with distinct responsibilities assigned to separate classes:

* `MainFrame.java`: Sets up the main window and manages the **`CardLayout`** navigation.
* `AddExpensePanel.java`: Handles the form input and saving new expense data.
* `ViewExpensePanel.java`: Manages the display of expenses in a **`JTable`**.
* `SummaryPanel.java`: Contains the logic for calculating and displaying aggregated spending data.

## 📸 Screenshots

## ✍️ Author

**[Manthan Gohil]** – https://www.linkedin.com/in/manthan-gohil-16283231a/

import java.awt.*;
import javax.swing.*;

public class TextEditor extends JFrame {

    JTextArea textArea;

    public TextEditor() {

        setTitle("Simple Text Editor");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Text area
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Put text area inside JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");

        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        // New option
        newItem.addActionListener(e -> {
            textArea.setText("");
        });

        // Clear option
        clearItem.addActionListener(e -> {
            textArea.setText("");
        });

        // Exit option
        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        // Edit options
        cutItem.addActionListener(e -> {
            textArea.cut();
        });

        copyItem.addActionListener(e -> {
            textArea.copy();
        });

        pasteItem.addActionListener(e -> {
            textArea.paste();
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TextEditor editor = new TextEditor();
            editor.setVisible(true);
        });
    }
}
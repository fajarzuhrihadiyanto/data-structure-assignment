package assignment_08.views;

import assignment_08.models.LogModel;
import assignment_08.views.components.LogListCellRenderer;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents view of the log window of the application
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class LogView {

    /** main Frame that contain all components */
    private JFrame mainFrame;

    /** scroll area that contain list of logs */
    private JScrollPane jScrollPane;

    /** list component of all logs */
    private JList<LogModel> logs;

    /** data model for the list */
    DefaultListModel<LogModel> list;

    /**
     * This constructor will initialize the window for the main app and render the UI
     * */
    public LogView() {
        initializeWindow();
        displayUI();
    }

    /**
     * This method is used to create and show new window with a certain configuration
     * */
    private void initializeWindow() {
        this.mainFrame = new JFrame("Log");
        this.mainFrame.setLayout(new GridLayout(1, 1, 0, 0));
        this.mainFrame.setSize(300, 300);
        this.mainFrame.setResizable(false);
    }

    /**
     * This method is used to render all UI components
     * */
    private void displayUI() {
        this.list = new DefaultListModel<>();

        this.logs = new JList<>(list);
        this.logs.setCellRenderer(new LogListCellRenderer());

        this.jScrollPane = new JScrollPane(logs);
        this.jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.mainFrame.add(this.jScrollPane);
    }

    /* ALL GETTER METHOD BELOW HERE */

    public void displayFrame() {
        this.mainFrame.setVisible(true);
    }

    public DefaultListModel<LogModel> getList() {
        return list;
    }
}

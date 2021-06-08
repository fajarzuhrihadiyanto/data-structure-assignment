package assignment_08.views.components;

import assignment_08.models.LogModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class represents renderer tools for cell in a list of {@link LogModel}
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class LogListCellRenderer extends JPanel implements ListCellRenderer<LogModel>{

    /** the border */
    private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    /** basic component to represent disk of the game by the color */
    private final JPanel disk;

    /** label component to contain the information of the movement */
    private final JLabel label;

    /** colors constant for disk component */
    private final Color[] COLORS = {
            new Color(244, 67, 54),
            new Color(255, 152, 0),
            new Color(255, 235, 59),
            new Color(139, 195, 74),
            new Color(0, 150, 136),
            new Color(3, 169, 244),
            new Color(63, 81, 181),
            new Color(233, 30, 99),
    };

    /**
     * This method is used to configure and render UI of each data in the list
     * */
    public LogListCellRenderer() {
        // CONFIGURATION
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(DEFAULT_NO_FOCUS_BORDER);

        // COMPONENT INITIALIZATION
        this.disk = new JPanel();
        this.label = new JLabel();

        // COMPONENT RENDER
        add(this.disk);
        add(this.label);
    }

    /**
     * This method is override behavior of {@link ListCellRenderer} interface.
     *
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     *
     * @return component to be rendered
     * */
    @Override
    public Component getListCellRendererComponent(JList<? extends LogModel> list, LogModel value, int index, boolean isSelected, boolean cellHasFocus) {
        this.label.setText("From " + rod(value.getFromRod()) + " to " + rod(value.getToRod()));
        this.disk.setBackground(COLORS[value.getDiskVal() - 1]);
        return this;
    }

    /**
     * This method is used to convert rod index to rod position (left, middle, right)
     *
     * @param index index of the rod
     * @return corresponding string representation of rod position based on the index
     * */
    private String rod(int index) {
        switch (index) {
            case 0:
                return "left";
            case 1:
                return "middle";
            case 2:
                return "right";
            default:
                return "";
        }
    }
}

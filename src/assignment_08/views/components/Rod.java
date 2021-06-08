package assignment_08.views.components;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 * This class represents Rod components derive from general swing component
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class Rod extends JComponent {

    /** constant that define maximum disk for one rod */
    private final int MAXIMUM_DISK = 8;

    /** constant that define thickness of every single disk */
    private final int DISK_THICKNESS = 20;

    /** constant that define width of the smallest possible disk */
    private final int DISK_MINIMUM_WIDTH = 40;

    /** constant that define Thickness of the rod */
    private final int ROD_THICKNESS = 20;

    /** colors constant for disk component */
    private final Color[] colors = {
            new Color(244, 67, 54),
            new Color(255, 152, 0),
            new Color(255, 235, 59),
            new Color(139, 195, 74),
            new Color(0, 150, 136),
            new Color(3, 169, 244),
            new Color(63, 81, 181),
            new Color(233, 30, 99),
    };

    /** list of disk data */
    private Stack<Integer> disks;

    /** field to contain width of the largest possible disk */
    private int disk_max_width;

    /** field to contain width gap for every adjacent disk */
    private int disk_gap_width;

    /**
     * This constructor will create new rod with the given list of disk data
     *
     * @param initialDisk initial list of the disk
     * */
    public Rod(Stack<Integer> initialDisk) {
        this.disks = initialDisk;
    }

    /**
     * This constructor will create new rod with the given maximum disk value
     *
     * @param max maximum disk value
     * */
    public Rod(int max) {

        this.disks = new Stack<>();

        for (int i = max; i > 0; i--) {
            this.disks.push(i);
        }
    }

    /**
     * This constructor will create new empty rod
     * */
    public Rod() {
        this(0);
    }

    /**
     * This method overrides behavior of {@link JComponent} class
     *
     * @param g
     * */
    @Override
    public void paintComponent(Graphics g) {
        // GET MAX WIDTH AND GAP WIDTH
        this.disk_max_width = g.getClipBounds().width;
        this.disk_gap_width = (this.disk_max_width - this.DISK_MINIMUM_WIDTH) / (this.MAXIMUM_DISK - 1);

        // RENDER THE ROD
        g.fillRect(0, g.getClipBounds().height - this.ROD_THICKNESS, g.getClipBounds().width, 20);
        g.fillRect((g.getClipBounds().width - this.ROD_THICKNESS) / 2, 20, this.ROD_THICKNESS, g.getClipBounds().height);

        // RENDER ALL THE DISKS
        for (int i = 0; i < disks.size(); i++) {
            g.setColor(this.colors[this.disks.get(i) - 1]);
            int diskWidth =  this.DISK_MINIMUM_WIDTH + ((this.disks.get(i) - 1) * this.disk_gap_width);
            g.fillRect((g.getClipBounds().width - diskWidth) / 2,
                    g.getClipBounds().height - ((i+2) * this.DISK_THICKNESS),
                    diskWidth,
                    this.DISK_THICKNESS);
        }
    }

    /**
     * This method is used to get the top disk without removing it.
     * If the rod is empty, return 0 instead
     *
     * @return peak value of the rod, or 0 if the rod is empty
     * */
    public int getTopDisk() {
        return this.disks.empty() ? 0 : this.disks.peek();
    }

    /**
     * This method is used to add new disk to the rod and rerender the UI
     *
     * @param value value of the disk
     * @throws Exception if the disk is not empty and the input value is not valid (under 1 or greater than or equal to current peak)
     * */
    public void addDisk(Integer value) throws Exception {
        if (!this.disks.empty() && (value >= this.disks.peek() || value < 1)) {
            throw new Exception("Invalid");
        }

        this.disks.push(value);
        repaint();
    }

    /**
     * This method is used to pick the peak value of the rod and rerender the UI
     *
     * @throws Exception when the rod is empty
     * */
    public void removeDisk() throws Exception {
        if (this.disks.empty()) {
            throw new Exception("Invalid");
        }

        this.disks.pop();
        repaint();
    }

    /**
     * This method is used to replace current rod with new list of disk and rerender the UI
     *
     * @param disks stack of the disk
     * */
    public void updateDisk(Stack<Integer> disks) {
        this.disks = disks;
        repaint();
    }

}

package assignment_08.views;

import assignment_08.views.components.Rod;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents main view of the desktop app
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class MainView {

    /** main Frame that contain all components */
    private JFrame mainFrame;

    /** top container pane that contain top bar menu */
    private JPanel top;

    /** menu container that contains disk form menu */
    private JPanel diskFormMenu;

    /** label component for disk form */
    private JLabel diskLabel;

    /** spinner component for disk form */
    private JSpinner diskSpinner;

    /** menu container that contains move state menu */
    private JPanel stateMenu;

    /** label component for move state menu */
    private JLabel stateLabel;

    /** label component for total move */
    private JLabel moveState;

    /** menu container that contains all option for application */
    private JPanel optionFormMenu;

    /** button component to do restart game */
    private JButton restartButton;

    /** button component to check movement log */
    private JButton logButton;

    /** button component to solve the game automatically */
    private JButton solveButton;

    /** button component to solve the game step by step */
    private JButton stepButton;

    /** button component to go to the previous step of the solution */
    private JButton prevButton;

    /** button component to go to the next step of the solution */
    private JButton nextButton;

    /** main container that contain all three rods */
    private JPanel towersContainer;

    /** array of {@link Rod} component as representation of each rod in the tower of hanoi */
    private Rod[] towers;

    /**
     * This constructor will initialize the window for the main app and render the UI
     * */
    public MainView() {
        this.initializeWindow();
        this.displayUI();
    }

    /**
     * This method is used to create and show new window with a certain configuration
     * */
    private void initializeWindow() {
        this.mainFrame = new JFrame("Tower of Hanoi");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.getContentPane().setLayout(new BoxLayout(this.mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        this.mainFrame.setSize(600, 450);
        this.mainFrame.setResizable(false);
        this.mainFrame.setVisible(true);
    }

    /**
     * This method is used to render all UI components
     * */
    private void displayUI() {
        displayTop();
        displayTowerContainer();
    }

    /**
     * This method is used to render all top menu components
     * */
    private void displayTop() {
        this.top = new JPanel();
        this.top.setLayout(new GridLayout(1, 3, 10, 10));
        this.top.setPreferredSize(new Dimension(600, 150));

        displayDiskFormMenu();
        displayStateMenu();
        displayOptionFormMenu();

        this.mainFrame.add(this.top);
    }


    /**
     * This method is used to render UI for disk form menu
     * */
    private void displayDiskFormMenu() {
        this.diskFormMenu = new JPanel();
        this.diskFormMenu.setLayout(new FlowLayout());

        this.diskLabel = new JLabel("disk");
        this.diskSpinner = new JSpinner();

        this.diskFormMenu.add(this.diskLabel);
        this.diskFormMenu.add(this.diskSpinner);

        this.top.add(this.diskFormMenu);
    }

    /**
     * This method is used to render UI for movement status top menu
     * */
    private void displayStateMenu() {
        stateMenu = new JPanel();

        this.stateLabel = new JLabel("Total Move");
        this.moveState = new JLabel();

        stateMenu.add(this.stateLabel);
        stateMenu.add(this.moveState);

        this.top.add(this.stateMenu);
    }

    /**
     * This method is used to render UI for option button top menu
     * */
    private void displayOptionFormMenu() {
        this.optionFormMenu = new JPanel();
        this.optionFormMenu.setLayout(new GridLayout(2, 3, 5, 5));

        this.restartButton = new JButton("Restart");
        this.restartButton.setMargin(new Insets(0, 0, 0, 0));
        this.logButton = new JButton("Log");
        this.logButton.setMargin(new Insets(0, 0, 0, 0));
        this.solveButton = new JButton("Solve");
        this.solveButton.setMargin(new Insets(0, 0, 0, 0));
        this.prevButton = new JButton("<");
        this.prevButton.setEnabled(false);
        this.stepButton = new JButton("Step by Step");
        this.stepButton.setMargin(new Insets(0, 0, 0, 0));
        this.nextButton = new JButton(">");
        this.nextButton.setEnabled(false);

        this.optionFormMenu.add(this.restartButton);
        this.optionFormMenu.add(this.logButton);
        this.optionFormMenu.add(this.solveButton);
        this.optionFormMenu.add(this.prevButton);
        this.optionFormMenu.add(this.stepButton);
        this.optionFormMenu.add(this.nextButton);

        this.top.add(this.optionFormMenu);
    }

    /**
     * This method is used to render all game UI
     * */
    private void displayTowerContainer() {
        this.towersContainer = new JPanel();
        this.towersContainer.setLayout(new GridLayout(1, 3, 10, 10));
        this.towersContainer.setPreferredSize(new Dimension(600, 300));

        this.towers = new Rod[3];
        displayTower(0, new Rod(3));
        displayTower(1, new Rod(0));
        displayTower(2, new Rod(0));

        this.mainFrame.add(towersContainer);
    }

    /**
     * This method is used to render a single Rod UI
     * */
    private void displayTower(int index, Rod rod) {
        this.towers[index] = rod;

        this.towersContainer.add(this.towers[index]);
    }

    /* ALL GETTER METHOD BELOW HERE */

    public JSpinner getDiskSpinner() {
        return diskSpinner;
    }

    public JLabel getMoveState() {
        return moveState;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public JButton getLogButton() {
        return logButton;
    }

    public JButton getSolveButton() {
        return solveButton;
    }

    public JButton getStepButton() {
        return stepButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public Rod[] getTowers() {
        return towers;
    }
}

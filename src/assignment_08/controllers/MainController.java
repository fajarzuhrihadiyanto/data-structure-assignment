package assignment_08.controllers;

import assignment_08.models.Model;
import assignment_08.views.View;

import javax.swing.*;
import java.util.Stack;

/**
 * This class represents controller of model and view related to the main application
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class MainController {

    /** Model used by this controller */
    private final Model model;

    /** View used by this controller */
    private final View view;

    /**
     * This constructor will create new controller with a given model and view
     *
     * @param model model used by this controller
     * @param view view used by this controller
     * */
    public MainController(Model model, View view) {
        this.model = model;
        this.view = view;

        this.initView();
        this.initController();
    }

    /**
     * This method is used to initialize the view that need data from the model
     * */
    public void initView() {
        this.view.getMainView().getDiskSpinner().setModel(new SpinnerNumberModel(this.model.getStateModel().getnDisk(), 3, 8, 1));
        this.view.getMainView().getMoveState().setText(String.valueOf(this.model.getStateModel().getTotalMoves()));
    }

    /**
     * This method is used to initialize the controller by setting event listener for every control
     * related to the main app
     * */
    public void initController() {
        // EVENT LISTENER OF THE SPINNER
        this.view.getMainView().getDiskSpinner().addChangeListener(e -> {
            int num = (int) ((JSpinner)e.getSource()).getValue();
            this.model.getStateModel().setnDisk(num);
            this.initGame();
        });

        // EVENT LISTENER OF THE RESTART BUTTON
        this.view.getMainView().getRestartButton().addActionListener(e -> {
            this.initGame();
        });

        // EVENT LISTENER OF THE LOG BUTTON
        this.view.getMainView().getLogButton().addActionListener(e -> {
            this.view.getLogView().displayFrame();
        });
    }

    /**
     * This method is used to initialize the game
     * */
    private void initGame() {
        try {
            // REINITIALIZE THE ROD MODEL
            this.model.getRodsModel().reinitiate(this.model.getStateModel().getnDisk());

            this.view.getMainView().getTowers()[0].updateDisk(new Stack<>());
            for (int i = this.model.getStateModel().getnDisk(); i > 0; i--) {
                this.view.getMainView().getTowers()[0].addDisk(i);
            }
            this.view.getMainView().getTowers()[1].updateDisk(new Stack<>());
            this.view.getMainView().getTowers()[2].updateDisk(new Stack<>());

            // RESET THE MOVE STATE
            this.model.getStateModel().setTotalMoves(0);
            this.view.getMainView().getMoveState().setText(String.valueOf(0));

            // CLEAR THE LOGS
            this.model.getLogsModel().getLogs().clear();
            this.view.getLogView().getList().clear();

            // ENABLE THE START GAME BUTTON
            this.view.getMainView().getSolveButton().setEnabled(true);
            this.view.getMainView().getStepButton().setEnabled(true);

            // DISABLE THE NEXT AND PREVIOUS BUTTON
            this.view.getMainView().getPrevButton().setEnabled(false);
            this.view.getMainView().getNextButton().setEnabled(false);

            // STOP THE RUNNING THREAD WITH NAME "toh" IF ITS EXIST
            for (Thread t : Thread.getAllStackTraces().keySet()) {
                if (t.getName().equals("toh")) {
                    t.stop();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

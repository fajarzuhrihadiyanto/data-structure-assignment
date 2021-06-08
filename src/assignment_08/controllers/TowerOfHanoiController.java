package assignment_08.controllers;

import assignment_08.models.LogModel;
import assignment_08.models.Model;
import assignment_08.views.View;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * This class represents controller of model and view related to the main game
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class TowerOfHanoiController implements Runnable {

    /** Model used by this controller */
    private final Model model;

    /** View used by this controller */
    private final View view;

    /** field to contain integer iterator to do step by step solution */
    private ListIterator<Integer> moveIt;

    /**
     * This method override from {@link Runnable} interface
     * */
    @Override
    public void run() {
        try {
            this.solve(this.model.getStateModel().getnDisk(), 0, 2, 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This constructor will create new controller with a given model and view
     *
     * @param model model used by this controller
     * @param view view used by this controller
     * */
    public TowerOfHanoiController(Model model, View view) {
        this.model = model;
        this.view = view;

        initController();
    }

    /**
     * This method is used to initialize the controller by setting event listener for every control
     * related to the main game
     * */
    public void initController() {
        // EVENT LISTENER OF THE SOLVE BUTTON
        this.view.getMainView().getSolveButton().addActionListener(e -> {
            this.view.getMainView().getSolveButton().setEnabled(false);
            this.view.getMainView().getStepButton().setEnabled(false);
            this.getT().start();
        });

        // EVENT LISTENER OF THE STEP BY STEP BUTTON
        this.view.getMainView().getStepButton().addActionListener(e -> {
            this.view.getMainView().getSolveButton().setEnabled(false);
            this.view.getMainView().getStepButton().setEnabled(false);

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i < Math.pow(2, this.model.getStateModel().getnDisk()); i++) {
                list.add(i);
            }

            this.moveIt = list.listIterator();

            if (this.moveIt.hasNext()) this.view.getMainView().getNextButton().setEnabled(true);
        });

        // EVENT LISTENER OF THE PREVIOUS BUTTON
        this.view.getMainView().getPrevButton().addActionListener(e -> {
            try {
                this.stepSolution(false);
                this.view.getMainView().getNextButton().setEnabled(true);
                if (!this.moveIt.hasPrevious()) this.view.getMainView().getPrevButton().setEnabled(false);
            } catch (Exception ignored) {

            }
        });

        // EVENT LISTENER OF THE NEXT BUTTON
        this.view.getMainView().getNextButton().addActionListener(e -> {
            try {
                this.stepSolution(true);
                this.view.getMainView().getPrevButton().setEnabled(true);
                if (!this.moveIt.hasNext()) this.view.getMainView().getNextButton().setEnabled(false);
            } catch (Exception ignored) {

            }
        });
    }

    /**
     * This method is used to do one step solution, either forward or backward
     *
     * @param forward flag parameter used to indicated if its forward or backward
     * */
    private void stepSolution(boolean forward) throws Exception {
        // GET CURRENT ITERATOR
        int num = forward ? this.moveIt.next() % 3 : this.moveIt.previous() % 3;

        // GET THE LEFT, MIDDLE, AND THE RIGHT INDEX AND ROD DATA
        int leftDisk = this.view.getMainView().getTowers()[0].getTopDisk(), middleDisk, rightDisk, middleIndex, rightIndex;
        if (this.model.getStateModel().getnDisk() % 2 == 1) {
            middleIndex = 1;
            rightIndex = 2;
        } else {
            middleIndex = 2;
            rightIndex = 1;
        }
        middleDisk = this.view.getMainView().getTowers()[middleIndex].getTopDisk();
        rightDisk = this.view.getMainView().getTowers()[rightIndex].getTopDisk();

        // MOVEMENT CONSIDERATION
        switch (num) {
            case 1:
                if (leftDisk == 0) this.moveDisk(rightIndex, 0, forward);
                else if (rightDisk == 0) this.moveDisk(0, rightIndex, forward);
                else if (leftDisk > rightDisk) this.moveDisk(rightIndex, 0, forward);
                else this.moveDisk(0, rightIndex, forward);
                break;
            case 2:
                if (leftDisk == 0) this.moveDisk(middleIndex,0, forward);
                else if (middleDisk == 0) this.moveDisk(0, middleIndex, forward);
                else if (leftDisk > middleDisk) this.moveDisk(middleIndex, 0, forward);
                else this.moveDisk(0, middleIndex, forward);
                break;
            case 0:
                if (rightDisk == 0) this.moveDisk(middleIndex,rightIndex, forward);
                else if (middleDisk == 0) this.moveDisk(rightIndex, middleIndex, forward);
                else if (rightDisk > middleDisk) this.moveDisk(middleIndex, rightIndex, forward);
                else this.moveDisk(rightIndex, middleIndex, forward);
                break;
            default:
                break;
        }
    }

    /**
     * This method is used to solve the game automatically
     *
     * @param num number of the disk
     * @param from index of the from rod
     * @param to index of the to rod
     * @param aux index of the auc rod
     * */
    private void solve(int num, int from, int to, int aux) throws Exception {
        // BASE CASE, WHEN THE NUM IS 1
        if (num == 1) {
            moveDisk(from, to, true);
            Thread.sleep(500);
            return;
        }

        solve(num - 1, from, aux, to);

        moveDisk(from, to, true);
        Thread.sleep(500);

        solve(num - 1, aux, to, from);
    }

    /**
     * This method is used to move a disk from one rod to another rod
     *
     * @param from index of the from rod
     * @param to index of the to rod
     * @param forward flag that indicate if the movement is forward or backward
     * */
    private void moveDisk(int from, int to, boolean forward) throws Exception {
        this.model.getRodsModel().moveDisk(from, to);
        if (forward) {
            this.model.getStateModel().incrementTotalMoves();
            this.model.getLogsModel().getLogs().add(new LogModel(from, to, this.view.getMainView().getTowers()[from].getTopDisk()));
            this.view.getLogView().getList().addElement(new LogModel(from, to, this.view.getMainView().getTowers()[from].getTopDisk()));
        } else {
            this.model.getStateModel().decrementTotalMoves();
            this.model.getLogsModel().getLogs().pop();
            this.view.getLogView().getList().remove(this.view.getLogView().getList().getSize() - 1);
        }
        this.view.getMainView().getTowers()[to].addDisk(this.view.getMainView().getTowers()[from].getTopDisk());
        this.view.getMainView().getTowers()[from].removeDisk();
        this.view.getMainView().getMoveState().setText(String.valueOf(this.model.getStateModel().getTotalMoves()));
    }

    /**
     * This method is used to create new Thread for game solving
     *
     * @return new Thread with name "toh"
     * */
    public Thread getT() {
        return new Thread(this, "toh");
    }
}

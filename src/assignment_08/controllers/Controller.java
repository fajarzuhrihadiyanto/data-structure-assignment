package assignment_08.controllers;

import assignment_08.models.Model;
import assignment_08.views.View;

/**
 * This class represents set of all necessary controllers in the application
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class Controller {

    /** instance of main controller */
    private final MainController mainController;

    /** instance of tower of hanoi controller */
    private final TowerOfHanoiController towerOfHanoiController;

    /**
     * This constructor will create new main controller and tower of hanoi controller with a given model and view
     *
     * @param model model used by this controller
     * @param view view used by this controller
     * */
    public Controller(Model model, View view) {
        this.mainController = new MainController(model, view);
        this.towerOfHanoiController = new TowerOfHanoiController(model, view);
    }
}

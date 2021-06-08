package assignment_08;

import assignment_08.models.Model;
import assignment_08.controllers.Controller;
import assignment_08.models.LogsModel;
import assignment_08.models.RodsModel;
import assignment_08.models.StateModel;
import assignment_08.views.View;

/**
 * This class represents main application
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class MainApplication {

    /**
     * This method is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {
        Model model = new Model(
                new LogsModel(),
                new RodsModel(3),
                new StateModel(3, 0)
        );
        View view = new View();
        Controller controller =  new Controller(model, view);
    }

}

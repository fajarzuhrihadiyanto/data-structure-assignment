package assignment_08.views;

/**
 * This class represents set of all necessary views in the application
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class View {

    /** instance of log view */
    private final LogView logView;

    /** instance of main view */
    private final MainView mainView;

    /**
     * This constructor is used to create all corresponding views
     * */
    public View() {
        this.logView = new LogView();
        this.mainView = new MainView();
    }

    /* ALL GETTER METHOD BELOW HERE */

    public LogView getLogView() {
        return this.logView;
    }

    public MainView getMainView() {
        return this.mainView;
    }
}

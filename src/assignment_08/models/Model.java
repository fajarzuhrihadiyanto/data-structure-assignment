package assignment_08.models;

/**
 * This class represents set of all necessary models in the application
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class Model {

    /** Logs Model */
    private final LogsModel logsModel;

    /** Rods Model */
    private final RodsModel rodsModel;

    /** State Model */
    private final StateModel stateModel;

    /**
     * This constructor will set all necessary model
     * */
    public Model(LogsModel logsModel, RodsModel rodsModel, StateModel stateModel) {
        this.logsModel = logsModel;
        this.rodsModel = rodsModel;
        this.stateModel = stateModel;
    }

    /* ALL GETTER METHOD BELOW HERE */

    public LogsModel getLogsModel() {
        return this.logsModel;
    }

    public RodsModel getRodsModel() {
        return this.rodsModel;
    }

    public StateModel getStateModel() {
        return this.stateModel;
    }
}

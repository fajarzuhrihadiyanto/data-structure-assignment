package assignment_11;

/**
 * This class represents Phone number
 * that contains phone code and the actual number
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 20th 2021
 * */
public class PhoneNumber {

    /** Field that represents phone code for the number */
    int phoneCode;

    /** Field that represents actual phone number of the number*/
    String phoneNumber;

    /**
     * This constructor will create new PhoneNumber with a given parameter
     *
     * @param phoneCode phone code
     * @param phoneNumber phone actual number
     * */
    public PhoneNumber(int phoneCode, String phoneNumber) {
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method will return string representation of this phone number
     * by concatenating plus sign, phone code, additional space, and the actual number
     *
     * @return string representation of this phone number
     * */
    @Override
    public String toString() {
        return "+" + this.phoneCode + " " + this.phoneNumber;
    }
}

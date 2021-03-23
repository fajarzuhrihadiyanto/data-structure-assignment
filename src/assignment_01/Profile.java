/**
 * Task 1 Profile Program
 * Program that show my profile
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 17th 2021
 */

package assignment_01;


public class Profile {

    // MAIN METHOD
    public static void main(String[] args){

        // DECLARE AND INITIALIZE VARIABLE
        String name = "Fajar Zuhri Hadiyanto";
        int age = 20;
        String city = "Jakarta";

        // DISPLAY MY GENERAL PROFILE
        System.out.println("====================| PROFILE |====================");
        System.out.println("Hello guys, my name is " + name);
        System.out.println("I am " + age + " years old");
        System.out.println("I lived in " + city + "\n");

        // DISPLAY MY EDUCATION HISTORY
        System.out.println("====================| EDUCATION |====================");
        System.out.println("I was graduated from 26 Vocational High School.");
        System.out.println("For more precise, i was from Computer and Network Engineering Department.");
        System.out.println(
                "I have learn many things about programming technology," +
                        "such as Web Development with HTML, CSS, and Javascript.");
        System.out.println("I once participated in \"Lomba Keterampilan Siswa\", one of the most prestigious event for VHS.");
        System.out.println("I participated in Web Design division, and took 4th place in regional.\n");

        // DISPLAY MY EXPERIENCES
        System.out.println("====================| EXPERIENCES |====================");
        System.out.println("Before graduate from 26 VHS, i had to take a compulsory internship program for about 10 months.");
        System.out.println("I learned how to develop and maintain Java Web Application using Struts 2.");
        System.out.println("I also learned database such as SQLServer, PostgreSQL, and Oracle.");
        System.out.println("I also learned how to collaborate in coding using git.");
        System.out.println(
                "Besides technical skills, i also have learned many things that industry needs nowadays," +
                        "such as critical thinking, team work, and being creative person.\n");

        // DISPLAY MY COMPETENCE
        System.out.println("====================| COMPETENCES |====================");
        System.out.println("Here are my competences and interest right now :");
        System.out.println("- Website frontend development using HTML and CSS");
        System.out.println("- Website backend development using Node JS and Express JS");
        System.out.println("- No SQL database using MongoDB");
        System.out.println("- Image processing using python\n");

        // DISPLAY MY CONTACT
        System.out.println("====================| CONTACT |====================");
        System.out.println("Whatsapp : 081312775859");
        System.out.println("Email : fajarzuhri76@gmail.com");
        System.out.println("Instagram : fajarzuhri95");
        System.out.println("LinkedIn : Fajar Zuhri Hadiyanto");
        System.out.println("Github : fajarzuhrihadiyanto");
        System.out.println("Twitter : ZuhriFajar");
        System.out.println("Youtube : Fajar Zuhri Hadiyanto");

    }

}

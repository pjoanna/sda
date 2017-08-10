package applications;

import java.util.Scanner;

/**
 * Created by RENT on 2017-08-09.
 */
public abstract class ApplicationFactory {

    public static ConditionalStayApplication createConditionalStayApplication(Scanner scanner){
        return ApplicationsCreator.createConditionalStayApplication(scanner);
    }

    public static Application createSchoolarshipApplication(Scanner scanner){
        return ApplicationsCreator.createSchoolarshipApplication(scanner);
    }

    public static Application createSocialSchoolarshipApplication(Scanner scanner){
        return ApplicationsCreator.createSocialSchoolarshipApplication(scanner);
    }

    public static Application createSemesterExtendApplication(Scanner scanner){
        return ApplicationsCreator.createSemesterExtendApplication(scanner);
    }
}

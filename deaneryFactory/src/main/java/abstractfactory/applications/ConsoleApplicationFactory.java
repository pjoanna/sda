package abstractfactory.applications;

import java.util.Scanner;

/**
 * Created by pjoanna on 2017-08-10.
 */
public class ConsoleApplicationFactory extends AbsApplicationFactory {

    private final Scanner scanner;

    public ConsoleApplicationFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public ConditionalStayApplication createConditionalStayApplication() {
        return ApplicationsCreator.createConditionalStayApplication(scanner);
    }

    @Override
    public Application createSchoolarshipApplication() {
        return ApplicationsCreator.createSchoolarshipApplication(scanner);
    }

    @Override
    public Application createSocialSchoolarshipApplication() {
        return ApplicationsCreator.createSchoolarshipApplication(scanner);
    }

    @Override
    public Application createSemesterExtendApplication() {
        return ApplicationsCreator.createSemesterExtendApplication(scanner);
    }
}

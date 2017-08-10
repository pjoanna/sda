package abstractfactory.applications;

import java.util.Scanner;

/**
 * Created by RENT on 2017-08-09.
 */
public abstract class AbsApplicationFactory {

    public abstract Application createConditionalStayApplication();

    public abstract Application createSchoolarshipApplication();

    public abstract Application createSocialSchoolarshipApplication();

    public abstract Application createSemesterExtendApplication();
}

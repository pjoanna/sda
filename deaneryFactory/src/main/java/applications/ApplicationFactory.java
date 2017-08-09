package applications;

/**
 * Created by RENT on 2017-08-09.
 */
public abstract class ApplicationFactory {

    public static ConditionalStayApplication createConditionalStayApplication(){
        return ApplicationsCreator.createConditionalStayApplication();
    }

    public static Application createSchoolarshipApplication(){
        return ApplicationsCreator.createSchoolarshipApplication();
    }

    public static Application createSocialSchoolarshipApplication(){
        return ApplicationsCreator.createSocialSchoolarshipApplication();
    }

    public static Application createSemesterExtendApplication(){
        return ApplicationsCreator.createSemesterExtendApplication();
    }
}

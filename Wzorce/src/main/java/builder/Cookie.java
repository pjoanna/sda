package builder;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Cookie {
    private String name;
    private String seria;
    private String company;

    public Cookie(String name, String seria, String company) {
        this.name = name;
        this.seria = seria;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getSeria() {
        return seria;
    }

    public String getCompany() {
        return company;
    }

    static class Builder{

        private String name;
        private String seria;
        private String company;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSeria(String seria) {
            this.seria = seria;
            return this;
        }

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Cookie createCookie() {
            return new Cookie(name, seria, company);
        }
    }
}

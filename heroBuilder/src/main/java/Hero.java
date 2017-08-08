/**
 * Created by RENT on 2017-08-08.
 */
public class Hero {
    private String m_name, m_surname, m_legacy;
    private double m_height, m_width, m_strength;
    private int m_level, m_hp, m_handCount=4 ;
    private boolean m_isAlive;

    public Hero(Builder builder) {
        m_name = builder.m_name;
        m_surname = builder.m_surname;
        m_legacy = builder.m_legacy;

        m_height = builder.m_height;
        m_width = builder.m_width;
        m_strength = builder.m_strength;

        m_level = builder.m_level;
        m_hp = builder.m_hp;
        m_handCount = builder.m_handCount;

        m_isAlive = builder.m_isAlive;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_surname() {
        return m_surname;
    }

    public void setM_surname(String m_surname) {
        this.m_surname = m_surname;
    }

    public String getM_legacy() {
        return m_legacy;
    }

    public void setM_legacy(String m_legacy) {
        this.m_legacy = m_legacy;
    }

    public double getM_height() {
        return m_height;
    }

    public void setM_height(double m_height) {
        this.m_height = m_height;
    }

    public double getM_width() {
        return m_width;
    }

    public void setM_width(double m_width) {
        this.m_width = m_width;
    }

    public double getM_strength() {
        return m_strength;
    }

    public void setM_strength(double m_strength) {
        this.m_strength = m_strength;
    }

    public int getM_level() {
        return m_level;
    }

    public void setM_level(int m_level) {
        this.m_level = m_level;
    }

    public int getM_hp() {
        return m_hp;
    }

    public void setM_hp(int m_hp) {
        this.m_hp = m_hp;
    }

    public int getM_handCount() {
        return m_handCount;
    }

    public void setM_handCount(int m_handCount) {
        this.m_handCount = m_handCount;
    }

    public boolean isM_isAlive() {
        return m_isAlive;
    }

    public void setM_isAlive(boolean m_isAlive) {
        this.m_isAlive = m_isAlive;
    }

    public static class Builder{
        private String m_name, m_surname, m_legacy;
        private double m_height, m_width, m_strength;
        private int m_level, m_hp, m_handCount=4 ;
        private boolean m_isAlive;

        public Builder() {
        }

        public Builder setM_name(String m_name) {
            this.m_name = m_name;
            return this;
        }

        public Builder setM_surname(String m_surname) {
            this.m_surname = m_surname;
            return this;
        }

        public Builder setM_legacy(String m_legacy) {
            this.m_legacy = m_legacy;
            return this;
        }

        public Builder setM_height(double m_height) {
            this.m_height = m_height;
            return this;
        }

        public Builder setM_width(double m_width) {
            this.m_width = m_width;
            return this;
        }

        public Builder setM_strength(double m_strength) {
            this.m_strength = m_strength;
            return this;
        }

        public Builder setM_level(int m_level) {
            this.m_level = m_level;
            return this;
        }

        public Builder setM_hp(int m_hp) {
            this.m_hp = m_hp;
            return this;
        }

        public Builder setM_handCount(int m_handCount) {
            this.m_handCount = m_handCount;
            return this;
        }

        public Builder setM_isAlive(boolean m_isAlive) {
            this.m_isAlive = m_isAlive;
            return this;
        }

        public Hero create(){
            return new Hero(this);
        }
    }
}

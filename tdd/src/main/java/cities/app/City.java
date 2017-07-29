package cities.app;

/**
 * Created by RENT on 2017-07-29.
 */
public class City {
    private long id;
    private String name;
    private int citizens;
    private double area;

    public City(long id, String name, int citizens, double area) {
        this.id = id;
        this.name = name;
        this.citizens = citizens;
        this.area = area;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (citizens != city.citizens) return false;
        if (Double.compare(city.area, area) != 0) return false;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + citizens;
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

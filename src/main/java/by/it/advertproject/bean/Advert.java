package by.it.advertproject.bean;

import by.it.advertproject.service.AccountService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Objects;

public class Advert extends Bean {
    private static final Logger logger = LogManager.getLogger(Advert.class);

    static final long serialVersionUID = 42L;
    private String title;
    private String description;
    private String brand;
    private String model;
    private String color;
    private String body;
    private int year;
    private double engine;
    private String at;
    private String driveunit;
    private String equipment;
    private int milage;
    private String crashed;
    private BigDecimal price;
    private long accountIdFk;

    public Advert() {
    }

    public Advert(String title, String description, String brand, String model, String color, String body, int year, double engine, String at, String driveunit, String equipment, int milage, String crashed, BigDecimal price, long accountIdFk) {
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.body = body;
        this.year = year;
        this.engine = engine;
        this.at = at;
        this.driveunit = driveunit;
        this.equipment = equipment;
        this.milage = milage;
        this.crashed = crashed;
        this.price = price;
        this.accountIdFk = accountIdFk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getDriveunit() {
        return driveunit;
    }

    public void setDriveunit(String driveunit) {
        this.driveunit = driveunit;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String getCrashed() {
        return crashed;
    }

    public void setCrashed(String crashed) {
        this.crashed = crashed;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(long accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    @Override
    public String toString() {
        return "<br>Advert{" +
                ", title='" + title + '\'' + "\n<br>" +
                ", description='" + description + '\'' + "\n<br>" +
                ", brand='" + brand + '\'' + "\n<br>" +
                ", model='" + model + '\'' + "\n<br>" +
                ", color='" + color + '\'' + "\n<br>" +
                ", body='" + body + '\'' + "\n<br>" +
                ", year=" + year + "\n<br>" +
                ", engine=" + engine + "\n<br>" +
                ", at=" + at + "\n<br>" +
                ", driveunit='" + driveunit + '\'' + "\n<br>" +
                ", equipment='" + equipment + '\'' + "\n<br>" +
                ", milage=" + milage + "\n<br>" +
                ", crashed=" + crashed + "\n<br>" +
                ", price=" + price + "\n<br>" +
                ", accountIdFk=" + accountIdFk +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advert)) return false;
        if (!super.equals(o)) return false;
        Advert advert = (Advert) o;
        return getYear() == advert.getYear() &&
                Double.compare(advert.getEngine(), getEngine()) == 0 &&
                getMilage() == advert.getMilage() &&
                getAccountIdFk() == advert.getAccountIdFk() &&
                getTitle().equals(advert.getTitle()) &&
                getDescription().equals(advert.getDescription()) &&
                getBrand().equals(advert.getBrand()) &&
                getModel().equals(advert.getModel()) &&
                getColor().equals(advert.getColor()) &&
                getBody().equals(advert.getBody()) &&
                getAt().equals(advert.getAt()) &&
                getDriveunit().equals(advert.getDriveunit()) &&
                getEquipment().equals(advert.getEquipment()) &&
                getCrashed().equals(advert.getCrashed()) &&
                getPrice().equals(advert.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTitle(), getDescription(), getBrand(), getModel(), getColor(), getBody(), getYear(), getEngine(), getAt(), getDriveunit(), getEquipment(), getMilage(), getCrashed(), getPrice(), getAccountIdFk());
    }

    public static class Builder {

        private Advert advert;

        public Builder() {
            this.advert = new Advert();
        }

        public Builder withIdAdvert(long id) {
            advert.setId(id);
            return this;
        }

        public Builder withTitle(String title) {
            advert.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            advert.description = description;
            return this;
        }

        public Builder withBrand(String brand) {
            advert.brand = brand;
            return this;
        }

        public Builder withModel(String model) {
            advert.model = model;
            return this;
        }

        public Builder withColor(String color) {
            advert.color = color;
            return this;
        }

        public Builder withBody(String body) {
            advert.body = body;
            return this;
        }

        public Builder withYear(int year) {
            advert.year = year;
            return this;
        }

        public Builder withEngine(double engine) {
            advert.engine = engine;
            return this;
        }

        public Builder withAt(String at) {
            advert.at = at;
            return this;
        }

        public Builder withDriveunit(String driveunit) {
            advert.driveunit = driveunit;
            return this;
        }

        public Builder withEquipment(String equipment) {
            advert.equipment = equipment;
            return this;
        }

        public Builder withMileage(int mileage) {
            advert.milage = mileage;
            return this;
        }

        public Builder withCrashed(String crashed) {
            advert.crashed = crashed;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            advert.price = price;
            return this;
        }

        public Builder withAccountIdFk(long accountIdFk) {
            advert.accountIdFk = accountIdFk;
            return this;
        }

        public Advert build() {
            return advert;
        }
    }
}

package edu.neu.csye7374.Adapter;

public class Manufacturer implements Cloneable {


    private String ManufacturerName;
    private int yearsOfManufacturing;
    private int productsManufactured;
    private static Manufacturer instance;

    public Manufacturer(){super();}
    public static synchronized Manufacturer getInstance() {
        if(instance==null){
            instance = new Manufacturer();
        }
        return instance;
    }
    private Manufacturer(String manufacturerName, int yearsOfManufacturing, int productsManufactured) {
        super();
        ManufacturerName = manufacturerName;
        this.yearsOfManufacturing = yearsOfManufacturing;
        this.productsManufactured = productsManufactured;
    }

    public String getManufacturerName() {
        return ManufacturerName;
    }

    public Manufacturer setManufacturerName(String manufacturerName) {
        ManufacturerName = manufacturerName;
        return this;
    }

    public int getYearsOfManufacturing() {
        return yearsOfManufacturing;
    }

    public Manufacturer setYearsOfManufacturing(int yearsOfManufacturing) {
        this.yearsOfManufacturing = yearsOfManufacturing;
        return this;
    }

    public int getProductsManufactured() {
        return productsManufactured;
    }

    public Manufacturer setProductsManufactured(int productsManufactured) {
        this.productsManufactured = productsManufactured;
        return this;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "ManufacturerName='" + ManufacturerName + '\'' +
                ", yearsOfManufacturing=" + yearsOfManufacturing +
                ", productsManufactured=" + productsManufactured +
                '}';
    }
    @Override
    public Manufacturer clone() {
        Manufacturer clone = null;

        try {
            clone = (Manufacturer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

package prac2.prac2_4;

public class Comp {
    private String brand;
    private String model;
    private String processor;
    private String GPU;
    private int ram;
    private double price;
    private int storage;

    public Comp(String brand, String model, String processor, String GPU, int ram, int storage, double price){
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.GPU = GPU;
        this.ram = ram;
        this.price = price;
        this.storage = storage;
    }

    public String getBrand() {return brand;}
    public String getModel() {return model;}
    public String getProcessor() {return processor;}
    public String getGPU() {return GPU;}
    public int getRam() {return ram;}
    public double getPrice() {return price;}
    public int getStorage() {return storage;}

    public void setBrand(String brand) {this.brand = brand;}
    public void setModel(String model) {this.model = model;}
    public void setProcessor(String processor) {this.processor = processor;}
    public void setGPU(String GPU) {this.GPU = GPU;}
    public void setRam(int ram) {this.ram = ram;}
    public void setStorage(int storage) {this.storage = storage;}
    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {
        return "Брэнд " + brand + "\n" +
                "Модель " + model + "\n" +
                "Процессор " + processor + "\n" +
                "Видеокарта " + GPU + "\n" +
                "ОЗУ " + ram + "GB" + "\n" +
                "Память " + storage + "GB" + "\n" +
                "Цена " + price + "RUB" + "\n";
    }
}
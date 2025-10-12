package prac1_to_9.prac4.prac4_4;

enum ComputerBrand {
    LENOVO, ASUS, ACER, MSI
}

enum ProcessorBrand {
    INTEL, AMD
}

enum ProcessorType {
    CORE_I3, CORE_I5, CORE_I7, CORE_I9,
    RYZEN_3, RYZEN_5, RYZEN_7, RYZEN_9,
}

enum MemoryType {
    DDR3, DDR4, DDR5
}

enum MonitorType {
    IPS, TN, VA, OLED
}

class Processor {
    private ProcessorBrand brand;
    private ProcessorType model;
    private double clockSpeed;
    private int cores;
    private int threads;

    public Processor(ProcessorBrand brand, ProcessorType model,
                     double clockSpeed, int cores, int threads) {
        this.brand = brand;
        this.model = model;
        this.clockSpeed = clockSpeed;
        this.cores = cores;
        this.threads = threads;
    }

    public ProcessorBrand getBrand() { return brand; }
    public ProcessorType getModel() { return model; }
    public double getClockSpeed() { return clockSpeed; }
    public int getCores() { return cores; }
    public int getThreads() { return threads; }

    public String getInfo() {
        return brand + " " + model + ", " + cores + " cores, " + clockSpeed + "GHz";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}

class Memory {
    private MemoryType type;
    private int size;
    private int speed;

    public Memory(MemoryType type, int size, int speed) {
        this.type = type;
        this.size = size;
        this.speed = speed;
    }

    public MemoryType getType() { return type; }
    public int getSize() { return size; }
    public int getSpeed() { return speed; }

    public String getInfo() {
        return size + "GB " + type + " " + speed + "MHz";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}

class Monitor {
    private double size; // в дюймах
    private String resolution;
    private MonitorType type;
    private int refreshRate;

    public Monitor(double size, String resolution, MonitorType type) {
        this(size, resolution, type, 60);
    }

    public Monitor(double size, String resolution, MonitorType type, int refreshRate) {
        this.size = size;
        this.resolution = resolution;
        this.type = type;
        this.refreshRate = refreshRate;
    }

    public double getSize() { return size; }
    public String getResolution() { return resolution; }
    public MonitorType getType() { return type; }
    public int getRefreshRate() { return refreshRate; }

    public String getInfo() {
        return size + "\" " + resolution + " " + type + " " + refreshRate + "Hz";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}

class Computer {
    private ComputerBrand brand;
    private String model;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;
    private double price;

    public Computer(ComputerBrand brand, String model, Processor processor,
                    Memory memory, Monitor monitor, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
        this.price = price;
    }

    public ComputerBrand getBrand() { return brand; }
    public String getModel() { return model; }
    public Processor getProcessor() { return processor; }
    public Memory getMemory() { return memory; }
    public Monitor getMonitor() { return monitor; }
    public double getPrice() { return price; }

    public String getFullSpecifications() {
        return "Computer: " + brand + " " + model + "\n" +
                "Processor: " + processor.getInfo() + "\n" +
                "Memory: " + memory.getInfo() + "\n" +
                "Monitor: " + monitor.getInfo() + "\n" +
                "Price: $" + price;
    }

    public void upgradeMemory(Memory newMemory) {
        this.memory = newMemory;
        System.out.println("Memory upgraded to: " + newMemory.getInfo());
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + processor.getModel() + ", " +
                memory.getSize() + "GB RAM, " + monitor.getSize() + "\" display)";
    }
}

public class PC {
    public static void main(String[] args) {
        Processor processor = new Processor(ProcessorBrand.INTEL, ProcessorType.CORE_I7,
                3.8, 8, 16);
        Memory memory = new Memory(MemoryType.DDR4, 16, 3200);
        Monitor monitor = new Monitor(27.0, "2560x1440", MonitorType.IPS, 144);

        Computer computer = new Computer(ComputerBrand.ASUS, "ROG Strix",
                processor, memory, monitor, 1500.0);

        System.out.println(computer.getFullSpecifications());
        System.out.println();

        System.out.println();

        Memory newMemory = new Memory(MemoryType.DDR5, 32, 5600);
        computer.upgradeMemory(newMemory);
        System.out.println("Updated: " + "\n" + computer.getFullSpecifications());
    }
}
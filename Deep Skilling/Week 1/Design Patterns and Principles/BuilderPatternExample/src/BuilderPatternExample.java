public class BuilderPatternExample {
    public static void main(String[] args) {
        
       
        Computer myComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4060")
                .setBluetoothEnabled(true)
                .build();

        
        System.out.println("=== Computer Configured Successfully ===");
        System.out.println("CPU: " + myComputer.getCPU());
        System.out.println("RAM: " + myComputer.getRAM());
        System.out.println("Storage: " + myComputer.getStorage());
        System.out.println("Graphics Card: " + myComputer.getGraphicsCard());
        System.out.println("Bluetooth Enabled: " + myComputer.isBluetoothEnabled());
    }
}
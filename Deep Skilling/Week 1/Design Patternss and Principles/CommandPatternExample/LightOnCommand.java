public class LightOnCommand implements Command {

    private final Light light;   // ✅ add final

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
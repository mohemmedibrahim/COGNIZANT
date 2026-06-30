public class LightOffCommand implements Command {

    private final Light light;   // ✅ add final

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
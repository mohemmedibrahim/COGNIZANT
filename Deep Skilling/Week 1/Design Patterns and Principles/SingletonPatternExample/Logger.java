public class Logger {

    
    private Logger() {
  
        if (InstanceHolder.INSTANCE != null) {
            throw new IllegalStateException("Cannot create another instance. Use getInstance().");
        }
    }

    private static class InstanceHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return InstanceHolder.INSTANCE;
    }

   
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
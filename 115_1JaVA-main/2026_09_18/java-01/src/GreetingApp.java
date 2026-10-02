public class GreetingApp {
     public static String buildGreeting(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        String result = buildGreeting("Grace");
        System.out.println(result);
    }
}


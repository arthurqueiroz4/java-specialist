package sandbox;

import model.Plugin;

public class HelloPlugin implements Plugin {

    @Override
    public void execute() {
        IO.println("Hello World!");
    }

}

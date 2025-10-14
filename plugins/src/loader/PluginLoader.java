package loader;

import model.Plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;

public class PluginLoader {
    public void load() {
        File pluginsDir = new File("plugins/plugins");

        if (!pluginsDir.exists() || !pluginsDir.isDirectory()) {
            throw new RuntimeException("Plugins directory does not exist or is not a directory");
        }

        for (File jar : pluginsDir.listFiles((_, name) -> name.endsWith(".jar"))) {
            IO.println("Loading " + jar.getName());
            try (JarFile jarFile = new JarFile(jar)) {
                var loader = new URLClassLoader(
                        new URL[]{jar.toURI().toURL()},
                        this.getClass().getClassLoader()
                );

                jarFile.stream()
                        .filter(entry -> entry.getName().endsWith(".class"))
                        .forEach(entry -> {
                            try {
                                var className = entry.getName()
                                        .replace('/', '.')
                                        .replace(".class", "");

                                Class<?> clazz = Class.forName(className, true, loader);

                                if (Plugin.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
                                    Object instance = clazz.getConstructor().newInstance();
                                    var method = clazz.getMethod("execute");
                                    method.invoke(instance);
                                }
                            } catch (Exception e) {
                                IO.println("Failed to load class: " + e.getMessage());
                            }
                        });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

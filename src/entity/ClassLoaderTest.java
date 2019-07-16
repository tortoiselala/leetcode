package entity;

/**
 * @author tortoiselala
 */
public class ClassLoaderTest {
}

class CustomizedClassLoader extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        ClassLoader.getSystemClassLoader();
        return super.loadClass(name);
    }
}

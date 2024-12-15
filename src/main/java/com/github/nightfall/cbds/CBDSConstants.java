package com.github.nightfall.cbds;

import com.github.nightfall.cbds.io.custom.INamedCustomSerializable;
import com.github.nightfall.cbds.io.custom.IUnNamedCustomSerializable;
import com.github.nightfall.cbds.io.serial.api.INamedDeserializer;
import com.github.nightfall.cbds.io.serial.api.INamedSerializer;
import com.github.nightfall.cbds.io.serial.api.IKeylessDeserializer;
import com.github.nightfall.cbds.io.serial.api.IKeylessSerializer;
import com.github.nightfall.cbds.util.ILogWrapper;
import com.github.nightfall.cbds.util.VanillaLogWrapper;

import java.lang.management.ManagementFactory;
import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * A settings class that allows *some* customization and initialization of CBDS.
 *
 * @author Mr Zombii
 * @since 1.0.0
 */
public class CBDSConstants {

    public static ILogWrapper LOGGER = new VanillaLogWrapper();
    public static final boolean isDebug = ManagementFactory.getRuntimeMXBean()
            .getInputArguments()
            .toString()
            .contains("-agentlib:jdwp");

    public static boolean allowSerializerOverwriting = true;
    public static boolean allowDeserializerOverwriting = true;

    /**
     * The initialization method that must be called at the start of the program that,
     * allows the registration of custom serializers & deserializers of UnNamed and Named variants.
     */
    public static void init() {
        register(INamedCustomSerializable.class, INamedSerializer::registerSerializer);
        register(INamedCustomSerializable.class, INamedDeserializer::registerDeserializer);

        register(IUnNamedCustomSerializable.class, IKeylessSerializer::registerSerializer);
        register(IUnNamedCustomSerializable.class, IKeylessDeserializer::registerDeserializer);
    }

    /**
     * A utility method for loading Service Classes using one class reference and one consuming method.
     */
    public static <T> void register(Class<T> clazz, Consumer<T> method) {
        // Init from other jars
        ServiceLoader<T> objs = ServiceLoader.load(clazz);
        for (T obj : objs)  method.accept(obj);

        // Init from this jar
        objs = ServiceLoader.loadInstalled(clazz);
        for (T obj : objs) method.accept(obj);
    }

}

package com.github.nightfall.cbds.io.libgdx.vectors;

import com.badlogic.gdx.math.Vector4;
import com.github.nightfall.cbds.io.custom.INamedCustomSerializable;
import com.github.nightfall.cbds.io.custom.IUnNamedCustomSerializable;
import com.github.nightfall.cbds.io.serial.api.INamedDeserializer;
import com.github.nightfall.cbds.io.serial.api.INamedSerializer;
import com.github.nightfall.cbds.io.serial.api.IUnNamedDeserializer;
import com.github.nightfall.cbds.io.serial.api.IUnNamedSerializer;

import java.io.IOException;

public class Vector4WriterAndReader implements INamedCustomSerializable<Vector4>, IUnNamedCustomSerializable<Vector4> {

    @Override
    public void write(INamedSerializer serializer, Vector4 obj) throws IOException {
        serializer.writeFloat("x", obj.x);
        serializer.writeFloat("y", obj.y);
        serializer.writeFloat("z", obj.z);
        serializer.writeFloat("w", obj.w);
    }

    @Override
    public Vector4 read(INamedDeserializer deserializer) {
        return new Vector4(
                deserializer.readFloat("x"),
                deserializer.readFloat("y"),
                deserializer.readFloat("z"),
                deserializer.readFloat("w")
        );
    }

    @Override
    public Vector4 read(IUnNamedDeserializer in) throws IOException{
        return new Vector4(
                in.readFloat(),
                in.readFloat(),
                in.readFloat(),
                in.readFloat()
        );
    }

    @Override
    public void write(IUnNamedSerializer out, Vector4 obj) throws IOException {
        out.writeFloat(obj.x);
        out.writeFloat(obj.y);
        out.writeFloat(obj.z);
        out.writeFloat(obj.w);
    }

    @Override
    public Class<Vector4> getSerializableType() {
        return Vector4.class;
    }

}

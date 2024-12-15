package com.github.nightfall.cbds.io.libgdx.vectors;

import com.badlogic.gdx.math.Vector2;
import com.github.nightfall.cbds.io.custom.INamedCustomSerializable;
import com.github.nightfall.cbds.io.custom.IUnNamedCustomSerializable;
import com.github.nightfall.cbds.io.serial.api.INamedDeserializer;
import com.github.nightfall.cbds.io.serial.api.INamedSerializer;
import com.github.nightfall.cbds.io.serial.api.IKeylessDeserializer;
import com.github.nightfall.cbds.io.serial.api.IKeylessSerializer;

import java.io.IOException;

public class Vector2WriterAndReader implements INamedCustomSerializable<Vector2>, IUnNamedCustomSerializable<Vector2> {

    @Override
    public void write(INamedSerializer serializer, Vector2 obj) throws IOException {
        serializer.writeFloat("x", obj.x);
        serializer.writeFloat("y", obj.y);
    }

    @Override
    public Vector2 read(INamedDeserializer deserializer) {
        return new Vector2(
                deserializer.readFloat("x"),
                deserializer.readFloat("y")
        );
    }

    @Override
    public Vector2 read(IKeylessDeserializer in) throws IOException{
        return new Vector2(
                in.readFloat(),
                in.readFloat()
        );
    }

    @Override
    public void write(IKeylessSerializer out, Vector2 obj) throws IOException {
        out.writeFloat(obj.x);
        out.writeFloat(obj.y);
    }

    @Override
    public Class<Vector2> getSerializableType() {
        return Vector2.class;
    }

}

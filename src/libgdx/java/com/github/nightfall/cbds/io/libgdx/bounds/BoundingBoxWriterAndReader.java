package com.github.nightfall.cbds.io.libgdx.bounds;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.github.nightfall.cbds.io.custom.INamedCustomSerializable;
import com.github.nightfall.cbds.io.custom.IUnNamedCustomSerializable;
import com.github.nightfall.cbds.io.serial.api.INamedDeserializer;
import com.github.nightfall.cbds.io.serial.api.INamedSerializer;
import com.github.nightfall.cbds.io.serial.api.IKeylessDeserializer;
import com.github.nightfall.cbds.io.serial.api.IKeylessSerializer;

import java.io.IOException;

public class BoundingBoxWriterAndReader implements INamedCustomSerializable<BoundingBox>, IUnNamedCustomSerializable<BoundingBox> {

    @Override
    public void write(INamedSerializer serializer, BoundingBox obj) throws IOException {
        serializer.writeCustomObject("min", obj.min);
        serializer.writeCustomObject("max", obj.max);
    }

    @Override
    public BoundingBox read(INamedDeserializer deserializer) {
        return new BoundingBox(
                deserializer.readCustomObject("min", Vector3.class),
                deserializer.readCustomObject("max", Vector3.class)
        );
    }

    @Override
    public BoundingBox read(IKeylessDeserializer in) throws IOException{
        return new BoundingBox(
                in.readCustomObject(Vector3.class),
                in.readCustomObject(Vector3.class)
        );
    }

    @Override
    public void write(IKeylessSerializer out, BoundingBox obj) throws IOException {
        out.writeCustomObject(obj.min);
        out.writeCustomObject(obj.max);
    }

    @Override
    public Class<BoundingBox> getSerializableType() {
        return BoundingBox.class;
    }

}

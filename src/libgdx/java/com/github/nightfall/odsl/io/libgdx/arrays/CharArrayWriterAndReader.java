package com.github.nightfall.odsl.io.libgdx.arrays;

import com.badlogic.gdx.utils.CharArray;
import com.github.nightfall.odsl.io.custom.INamedCustomSerializable;
import com.github.nightfall.odsl.io.custom.IKeylessCustomSerializable;
import com.github.nightfall.odsl.io.serial.api.IKeylessDeserializer;
import com.github.nightfall.odsl.io.serial.api.IKeylessSerializer;
import com.github.nightfall.odsl.io.serial.api.INamedDeserializer;
import com.github.nightfall.odsl.io.serial.api.INamedSerializer;

import java.io.IOException;

public class CharArrayWriterAndReader implements INamedCustomSerializable<CharArray>, IKeylessCustomSerializable<CharArray> {

    @Override
    public void write(INamedSerializer serializer, CharArray obj) throws IOException {
        serializer.writeCharArray("items", obj.items);
    }

    @Override
    public CharArray read(INamedDeserializer deserializer) {
        return new CharArray(deserializer.readCharArrayAsNative("items"));
    }

    @Override
    public CharArray read(IKeylessDeserializer in) throws IOException{
        return new CharArray(in.readCharArrayAsNative());
    }

    @Override
    public void write(IKeylessSerializer out, CharArray obj) throws IOException {
        out.writeCharArray(obj.items);
    }

    @Override
    public Class<CharArray> getSerializableType() {
        return CharArray.class;
    }

}

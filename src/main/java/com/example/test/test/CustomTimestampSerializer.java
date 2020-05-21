package com.example.test.test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CustomTimestampSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String timestamp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String s = timestamp.replaceAll("s", "");
        jsonGenerator.writeString(s);
    }
}

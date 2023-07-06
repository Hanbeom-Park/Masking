package com.masking.masking;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaskingSerializer extends StdSerializer<String> implements ContextualSerializer {

    private List<Masker> maskers;
    private MaskingType type;


    protected MaskingSerializer() {
        super(String.class);
    }

    public MaskingSerializer(MaskingType type) {
        super(String.class);
        this.type = type;
        maskers = new ArrayList<>();
        maskers.add(new NameMasker());
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        for (Masker masker : maskers) {
            if(masker.typeCheck(type)){
                if(masker.isValid(value)){
                    gen.writeString(masker.doMasking(value));
                }else{
                    gen.writeString("******");
                }
            }
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        if(property!=null){
            Masking annotation = property.getAnnotation(Masking.class);
            MaskingType type = annotation.type();
        }
        return new MaskingSerializer(type);
    }
}

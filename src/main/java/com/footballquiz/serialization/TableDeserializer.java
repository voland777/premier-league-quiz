package com.footballquiz.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.footballquiz.model.TableDto;

import java.io.IOException;

public class TableDeserializer extends JsonDeserializer<TableDto> {

    @Override
    public TableDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ArrayNode arrayNode = p.getCodec().readTree(p);

        if (arrayNode.size() == 1) {
            return p.getCodec().treeToValue(arrayNode.get(0), TableDto.class);
        }

        throw new IOException("Expected a single table object.");
    }
}


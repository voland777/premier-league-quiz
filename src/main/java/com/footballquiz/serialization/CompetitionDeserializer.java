package com.footballquiz.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class CompetitionDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        ObjectNode objectNodeNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode competition = objectNodeNode.get("description");

        return competition.toString();
    }
}

package com.footballquiz.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.footballquiz.model.PositionDto;

import java.io.IOException;
import java.util.List;

public class PositionsArrayDeserializer extends JsonDeserializer<List<PositionDto>> {

    private static final String Entries = "entries";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType collectionType =
            TypeFactory
                    .defaultInstance()
                    .constructCollectionType(List.class, PositionDto.class);

    @Override
    public List<PositionDto> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        ArrayNode arrayNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode entries = arrayNode.get(0).get(Entries);

        return mapper.reader(collectionType).readValue(entries);
    }

}

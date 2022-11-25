package com.xcode.test.currency;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

public class RatesArrayDeserialization extends JsonDeserializer<List<Rates>> {
    private static final String RATES = "rates";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType collectionType =
            TypeFactory
                    .defaultInstance()
                    .constructCollectionType(List.class, Rates.class);

    @Override
    public List<Rates> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        ObjectNode objectNode = mapper.readTree(jsonParser);
        JsonNode nodeRates = objectNode.get(RATES);

        if (null == nodeRates                     // if no author node could be found
                || !nodeRates.isArray()           // or author node is not an array
                || !nodeRates.elements().hasNext())   // or author node doesn't contain any authors
            return null;

        return mapper.reader(collectionType).readValue(nodeRates);
    }
}

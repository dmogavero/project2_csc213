package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;


import java.io.IOException;

public class PolygonJsonReplyTranslator {

    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        JsonNode results = jsonNode.get("results").get(0);
        StockQuote stockQuote = new StockQuote(jsonNode.get("ticker").asText(),
                                               results.get("c").asDouble(),
                                               results.get("h").asDouble(),
                                               results.get("l").asDouble(),
                                               results.get("n").asInt(),
                                               results.get("o").asDouble(),
                                               results.get("t").asLong(),
                                               results.get("v").asDouble()
                                               );
        return stockQuote;
    }
}

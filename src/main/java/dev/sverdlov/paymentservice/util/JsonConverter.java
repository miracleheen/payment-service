package dev.sverdlov.paymentservice.util;

import dev.sverdlov.paymentservice.model.dto.CreatePaymentTransactionRequest;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@UtilityClass
@Component
public class JsonConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T toObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("Json deserialization error: ", e.getCause());
            throw new RuntimeException(e); // обязательно реализовать кастомное исключение
        }
    }
}



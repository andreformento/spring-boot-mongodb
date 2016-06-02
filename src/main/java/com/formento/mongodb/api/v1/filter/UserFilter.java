package com.formento.mongodb.api.v1.filter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.formento.mongodb.util.serializer.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserFilter implements Serializable {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

}

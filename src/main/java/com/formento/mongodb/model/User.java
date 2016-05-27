package com.formento.mongodb.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.formento.mongodb.util.serializer.LocalDateDeserializer;
import com.formento.mongodb.util.serializer.LocalDateSerializer;
import com.formento.mongodb.util.serializer.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements Serializable {

    @Id
    private ObjectId id;

    private String name;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthdate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    public static class Builder {
        private User instance;

        public Builder(String name, LocalDate birthdate) {
            this.instance = new User();
            withName(name);
            withBirthdate(birthdate);
        }

        public Builder(User user) {
            this(user.name, user.birthdate);
            this.instance.id = user.id;
            this.instance.createdAt = user.createdAt;
        }

        public Builder withName(String name) {
            instance.name = name;
            return this;
        }

        public Builder withBirthdate(LocalDate birthdate) {
            instance.birthdate = birthdate;
            return this;
        }

        public Builder withCreatedAt(LocalDateTime createdAt) {
            instance.createdAt = createdAt;
            return this;
        }

        public User build() {
            return this.instance;
        }
    }

}

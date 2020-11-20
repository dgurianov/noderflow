package com.gud.noderflow.model.attributes.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BulkCreateUsersAttributes {

    @JsonProperty("quantity")
    private Long quantity;

}

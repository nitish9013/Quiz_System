package com.Nitish.Quizapp.questionsApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("response")
    private String response;
    public String getResponse() {
        return response;
    }
}

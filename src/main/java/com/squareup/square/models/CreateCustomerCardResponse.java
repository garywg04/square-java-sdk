package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateCustomerCardResponse {

    @JsonCreator
    public CreateCustomerCardResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("card") Card card) {
        this.errors = errors;
        this.card = card;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Card card;

    @Override
    public int hashCode() {
        return Objects.hash(errors, card);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateCustomerCardResponse)) {
            return false;
        }
        CreateCustomerCardResponse createCustomerCardResponse = (CreateCustomerCardResponse) o;
        return Objects.equals(errors, createCustomerCardResponse.errors) &&
            Objects.equals(card, createCustomerCardResponse.card);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for Card.
     * Represents the payment details of a card to be used for payments. These
     * details are determined by the `card_nonce` generated by `SqPaymentForm`.
     */
    @JsonGetter("card")
    public Card getCard() { 
        return this.card;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .card(getCard());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Card card;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder card(Card value) {
            card = value;
            return this;
        }

        public CreateCustomerCardResponse build() {
            CreateCustomerCardResponse model = new CreateCustomerCardResponse(errors,
                card);
            model.httpContext = httpContext;
            return model;
        }
    }
}

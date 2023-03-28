package com.example.demo.DTO;

public class NewTicketDTO {
    private Integer flightId;
    private Integer numberOfPeople;
    private String email;

    public NewTicketDTO() {
    }

    public NewTicketDTO(Integer flightId, Integer numberOfPeople, String email) {
        this.flightId = flightId;
        this.numberOfPeople = numberOfPeople;
        this.email = email;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

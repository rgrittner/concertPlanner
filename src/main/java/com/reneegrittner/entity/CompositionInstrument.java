package com.reneegrittner.entity;

public class CompositionInstrument {

    private int id;
    private int playerNumber;
    private int instumentQuantity;
    private int instrumentId;
    private int compositionId;

    public CompositionInstrument() {
    }

    public CompositionInstrument(int playerNumber, int instumentQuantity, int instrumentId, int compositionId) {
        this.playerNumber = playerNumber;
        this.instumentQuantity = instumentQuantity;
        this.instrumentId = instrumentId;
        this.compositionId = compositionId;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getPlayerNumber() { return playerNumber; }

    public void setPlayerNumber(int playerNumber) { this.playerNumber = playerNumber; }

    public int getInstumentQuantity() { return instumentQuantity; }

    public void setInstumentQuantity(int instumentQuantity) { this.instumentQuantity = instumentQuantity; }

    public int getInstrumentId() { return instrumentId; }

    public void setInstrumentId(int instrumentId) { this.instrumentId = instrumentId; }

    public int getCompositionId() { return compositionId; }

    public void setCompositionId(int compositionId) { this.compositionId = compositionId; }
}

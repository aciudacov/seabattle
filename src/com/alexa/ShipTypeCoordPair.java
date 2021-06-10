package com.alexa;

public class ShipTypeCoordPair
{
    public int ShipType;
    public int x;
    public int y;

    public int getShipType()
    {
        return this.ShipType;
    }
    public ShipTypeCoordPair(int ShipType, int x, int y){
        this.ShipType = ShipType;
        this.x = x;
        this.y = y;
    }
}

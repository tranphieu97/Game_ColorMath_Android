package com.itute.tranphieu.colormath;

import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by TranPhieu on 4/29/2018.
 */

public class Cell {
    private String textInCell;
    private String textColor;
    private ArrayColor arrayColor = new ArrayColor();
    private AColor colorSring, colorMean;

    public Cell() {
    }
    public void ChangeCell()
    {
        setRandomColor();
        setTextInCell();
        setTextColor();
    }
    private void setRandomColor()
    {
        colorSring = arrayColor.getRandomColor();
        colorMean = arrayColor.getRandomColor();
    }

    public String getTextInCell() {
        return textInCell;
    }

    public void setTextInCell() {
        this.textInCell = colorMean.getColorName();
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor() {
        this.textColor = colorSring.getColorString();
    }

    public AColor getColorSring() {
        return colorSring;
    }

    public AColor getColorMean() {
        return colorMean;
    }
    public void setView(TextView view)
    {
        view.setText(getTextInCell());
        view.setTextColor(Color.parseColor(getTextColor()));
    }
}

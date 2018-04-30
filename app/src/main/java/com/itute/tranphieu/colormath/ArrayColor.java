package com.itute.tranphieu.colormath;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by TranPhieu on 4/29/2018.
 */

public class ArrayColor {
    private int countColor;
    private ArrayList<AColor> iColorArrayList = new ArrayList<AColor>();
    private Random random = new Random();

    public void addColor(AColor color)
    {
        iColorArrayList.add(color);
    }

    public int getCountColor() {
        return iColorArrayList.size();
    }

    private void setCountColor() {
        this.countColor = iColorArrayList.size();
    }
    public String getRandomColorName()
    {
        setCountColor();
        return iColorArrayList.get(random.nextInt(getCountColor())).getColorName();
    }
    public String getRandomColorString()
    {
        setCountColor();
        return iColorArrayList.get(random.nextInt(getCountColor())).getColorString();
    }
    public AColor getRandomColor()
    {
        setCountColor();
        return  iColorArrayList.get(random.nextInt(getCountColor()));
    }
    public void CreateArrayColor()
    {
        try {
            this.addColor(new CBlack());
            this.addColor(new CBlue());
            this.addColor(new CGreen());
            this.addColor(new CRed());
        }
        catch (Exception e)
        {
            System.out.print("Không thể thêm màu");
        }
    }

    public ArrayColor() {
        CreateArrayColor();
    }


}

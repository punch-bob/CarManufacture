package com.common.uniq_id;

import java.util.concurrent.ThreadLocalRandom;

public class VINgiver implements IVINgiver
{
    private char availablealetters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                                        'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @Override
    public String getVIN() 
    {
        return createVIN();
    }
    
    private String createVIN()
    {
        String vin = new String();
        for (int i = 0; i < 3; ++i)
        {
            int letterID = ThreadLocalRandom.current().nextInt(availablealetters.length);
            vin += availablealetters[letterID];
        }
        for (int i = 0; i < 4; ++i)
        {
            int number = ThreadLocalRandom.current().nextInt(10);
            vin += Integer.toString(number);
        }
        return vin;
    }
}

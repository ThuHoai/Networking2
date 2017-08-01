package com.example.hoaiktt.bai3_4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hoaiktt on 8/1/2017.
 */

public class LoanInput {
    private Map<String, String> mInputMap;

    public LoanInput(String amount, String rate, String months) {
        mInputMap = new HashMap<String, String>();
        mInputMap.put("amount", amount);
        mInputMap.put("rate", rate);
        mInputMap.put("months", months);
    }

    public Map<String, String> getInputMap() {
        return (mInputMap);
    }

}

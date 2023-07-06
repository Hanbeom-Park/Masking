package com.masking.masking;

public class NameMasker implements Masker{
    @Override
    public boolean isValid(String target) {
        return false;
    }

    @Override
    public boolean typeCheck(MaskingType type) {
        if(type == MaskingType.NAME){
            return true;
        }
        return false;
    }

    @Override
    public String doMasking(String target) {
        return null;
    }
}

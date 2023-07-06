package com.masking.masking;

public interface Masker {
    boolean isValid(String target);
    boolean typeCheck(MaskingType type);
    String doMasking(String target);
}

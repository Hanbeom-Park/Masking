package com.masking.masking;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize(using = MaskingSerializer.class)
public class TestVo {
    @Masking(type = MaskingType.NAME)
    private String name;
//    @Masking(type = MaskingType.PHONE_NUMBER)
    private String phoneNumber;
//    @Masking(type = MaskingType.ADDRESS)
    private String address;
//    @Masking(type = MaskingType.CREDIT_CARD)
    private String creditCard;
}

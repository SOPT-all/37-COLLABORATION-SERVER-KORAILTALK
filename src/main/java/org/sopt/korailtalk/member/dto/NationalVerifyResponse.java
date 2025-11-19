package org.sopt.korailtalk.member.dto;

public record NationalVerifyResponse(
    Boolean verified
) {
    public static NationalVerifyResponse of(Boolean verified) {
      return new NationalVerifyResponse(verified);
    }
}

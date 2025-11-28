package org.sopt.korailtalk.global.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TrainType {
  KTX("KTX"),
  KTX_S("KTX-S"),
  KTX_C("KTX-C"),
  ITX_N("ITX-N"),
  ITX_M("ITX-M"),
  ITX_Y("ITX-Y"),
  FLOWER("FLOWER"),
  SRT("SRT");

  private String value;
  TrainType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static TrainType of(String value) {
    if(value == null) return null;
    switch (value) {
      case "KTX":
        return TrainType.KTX;
      case "KTX-S":
        return TrainType.KTX_S;
      case "KTX-C":
        return TrainType.KTX_C;
      case "ITX-N":
        return TrainType.ITX_N;
      case "ITX-M":
        return TrainType.ITX_M;
      case "ITX-Y":
        return TrainType.ITX_Y;
      case "FLOWER":
        return TrainType.FLOWER;
      case "SRT":
        return TrainType.SRT;
    }
    return null;
  }
}

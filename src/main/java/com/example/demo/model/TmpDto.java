package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TmpDto {
   private int[] ids;

   public TmpDto(int[] ids) {
      this.ids = ids;
   }
}

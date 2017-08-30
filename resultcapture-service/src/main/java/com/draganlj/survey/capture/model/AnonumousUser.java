package com.draganlj.survey.capture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnonumousUser implements User {

    private String uniqueId;

}

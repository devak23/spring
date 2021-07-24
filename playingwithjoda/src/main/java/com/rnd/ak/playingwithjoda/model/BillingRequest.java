package com.rnd.ak.playingwithjoda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BillingRequest implements Serializable {
    @NotBlank
    private String clientCorrelationId;
    @NotBlank
    private String emailRecordId;
    @NotBlank
    private String applicationId;
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deliveryDate;
    @NotBlank
    private Map<String, String> metadata;
}

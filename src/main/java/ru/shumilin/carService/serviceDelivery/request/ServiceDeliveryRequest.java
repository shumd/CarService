package ru.shumilin.carService.serviceDelivery.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceDeliveryRequest {
    private long carId;
    private int serviceId;
    private int clientId;
    private long mechanicId;
    private long managerId;
    private int serviceDeliveryStatusId;
}

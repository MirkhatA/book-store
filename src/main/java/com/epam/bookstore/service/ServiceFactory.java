package com.epam.bookstore.service;

import java.util.HashMap;
import java.util.Map;

import static com.epam.bookstore.service.ServiceUrl.errorService;

public class ServiceFactory {

    private static final ServiceFactory serviceFactory = new ServiceFactory();
    private static final Map<String, Service> serviceMap = new HashMap<>();

    static {
        serviceMap.put(errorService, new ErrorService());
    }

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    public Service getService(String request) {
        Service service = serviceMap.get(errorService);

        for (Map.Entry<String, Service> pair : serviceMap.entrySet()) {
            if (request.equalsIgnoreCase(pair.getKey())) {
                service = serviceMap.get(pair.getKey());
            }
        }

        return service;
    }
}

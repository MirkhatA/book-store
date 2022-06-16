package com.epam.bookstore.service;

import java.util.HashMap;
import java.util.Map;


import static com.epam.bookstore.service.ServiceUrl.*;

public class ServiceFactory {

    private static final ServiceFactory serviceFactory = new ServiceFactory();
    private static final Map<String, Service> serviceMap = new HashMap<>();

    static {
        serviceMap.put(errorService, new ErrorService());
        serviceMap.put(registerService, new RegisterService());
        serviceMap.put(loginService, new LoginService());
        serviceMap.put(logoutService, new LogoutService());
        serviceMap.put(showProfileService, new ShowProfileService());
        serviceMap.put(showAllGenresService, new ShowAllGenresService());
        serviceMap.put(showAllAuthorsService, new ShowAllAuthorsService());
        serviceMap.put(showAllBooksService, new ShowAllBooksService());
        serviceMap.put(changeToEnglishService, new ChangeToEnglishService());
        serviceMap.put(changeToRussianService, new ChangeToRussianService());
        serviceMap.put(updateUserDataService, new UpdateUserDataService());
        serviceMap.put(showCartService, new ShowCartService());
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

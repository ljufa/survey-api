package com.draganlj.survey.capture.model;

import com.draganlj.survey.capture.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class MockedUserService implements UserService {

    @Override
    public User resolveUser(HttpServletRequest request) {
        return new AnonumousUser("Dragan Anonymous" ,request.getRemoteAddr());
    }

}

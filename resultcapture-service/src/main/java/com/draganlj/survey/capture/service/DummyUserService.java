package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.model.AnonumousUser;
import com.draganlj.survey.capture.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class DummyUserService implements UserService {

    @Override
    public User resolveUser(HttpServletRequest request) {
        return new AnonumousUser(request.getRemoteAddr());
    }

}

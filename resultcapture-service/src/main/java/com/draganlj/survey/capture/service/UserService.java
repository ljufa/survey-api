package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    User resolveUser(HttpServletRequest request);

}

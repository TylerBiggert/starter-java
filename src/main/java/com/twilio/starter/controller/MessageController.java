package com.twilio.starter.controller;

import com.twilio.rest.api.v2010.account.Message;
import spark.Request;
import spark.Response;
import spark.Route;


public class MessageController {

    private static final String TWILIO_PHONE_NUMBER = System.getenv("TWILIO_PHONE_NUMBER");

    public static Route handlePost = (Request request, Response response) -> {
        String to = request.queryParams("to");
        String textToBeSentInMessage = request.queryParams("body");

        Message messageResource = Message.creator(
                new com.twilio.type.PhoneNumber(to),
                new com.twilio.type.PhoneNumber(TWILIO_PHONE_NUMBER),
                textToBeSentInMessage)
                .create();

        return "No error handling yet, so I hope I actually receive a text. Message SID = " + messageResource.getSid();
    };
}

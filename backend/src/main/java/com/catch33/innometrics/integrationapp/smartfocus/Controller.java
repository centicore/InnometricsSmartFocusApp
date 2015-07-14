package com.catch33.innometrics.integrationapp.smartfocus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.innometrics.commons.model.Attribute;
import com.innometrics.commons.model.Profile;
import com.innometrics.util.JacksonUtil;
import com.innometrics.utils.app.commons.settings.exception.NoPropertyAvailableException;
import com.innometrics.utils.app.commons.settings.wrapper.ProfileCloudWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Component
public class Controller {
    @Autowired
    private ProfileCloudWrapper profileCloudDAO;

    @RequestMapping(value = "/", method = RequestMethod.POST, headers = {"Accept=*/*", "Content-Type=*/*"})
    public String root(@RequestBody String body) {
        try {
            JsonNode jsonNode = JacksonUtil.getObjectMapper().readTree(body);
            Profile profile = JacksonUtil.getObjectMapper().readValue(jsonNode.get("profile").toString(), Profile.class);

            //get profile email (see innometrics documentation for Profile API)

            //send api request to smartfocus (To be specified)


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "test";
    }

    @RequestMapping(value = "/view")
    public String view(Model model) {
        model.addAttribute("profileCloudDAO", profileCloudDAO);
        //model.addAttribute("urls", urls);
        return "test";
    }



}

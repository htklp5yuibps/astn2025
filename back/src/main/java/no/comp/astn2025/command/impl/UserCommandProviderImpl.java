package no.comp.astn2025.command.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.comp.astn2025.command.AbstractCommandProvider;
import no.comp.astn2025.command.JSONMapper;
import no.comp.astn2025.dao.DaoFactory;
import no.comp.astn2025.entity.EntityStatus;
import no.comp.astn2025.entity.User;
import no.comp.astn2025.entity.UserInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserCommandProviderImpl extends AbstractCommandProvider {

    private static final String email = "email";
    private static final String password = "password";
    private static final String firstname = "firstname";
    private static final String lastname = "lastname";
    private static final String patronymic = "patronymic";
    private static final String country = "country";
    private static final String city = "city";
    private static final String address = "address";
    private static final String dob = "dob";
    private static final String telephoneNumber = "telephone";

    public UserCommandProviderImpl() {
        this.addCommand(Pattern.compile("/users"), (request, response) -> {
            response.getWriter().write(this.toStringFromObject(DaoFactory.getInstance().getUserDao().readAll()));
        });

        this.addCommand(Pattern.compile("\\/users\\/(?<id>[\\w]+)"), (request, response) -> {
            int id = this.getIntegerAttribute("id", request);
            List<User> users = DaoFactory.getInstance().getUserDao().readAll();
            Optional<User> user =  users.stream().filter(val -> val.getId() == id).findFirst();
            if (user.isPresent()) {
                response.getWriter().write(this.toStringFromObject(user.get()));
            } else {
                response.setStatus(404);
            }
        });

        this.addCommand(HttpMethod.POST, Pattern.compile("/users"), (request, response) -> {
            User user = new User();

            user.setEmail(request.getParameter(email));
            user.setPassword(request.getParameter(password));
            user.setuInfo(new UserInfo().new UserInfoBuilder()
                    .setFirstname(request.getParameter(firstname))
                    .setLastname(request.getParameter(lastname))
                    .setPatronymic(request.getParameter(patronymic))
                    .setCountry(request.getParameter(country))
                    .setCity(request.getParameter(city))
                    .setAddress(request.getParameter(address))
                    .setTelephoneNumber(request.getParameter(telephoneNumber))
                    .setDob(LocalDate.now())
                    .build());

            DaoFactory.getInstance().getUserDao().create(user);

            response.setStatus(201);
        });
    }
}

package com.akbar.onlineshop.user.util;

import com.akbar.onlineshop.commons.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUtil {
    public static List<UserDto> dummys() {
        List<UserDto> dummys = new ArrayList<>();
        UserDto userDto1 = new UserDto();
        userDto1.setId("1");
        userDto1.setLogin("qwe");
        dummys.add(userDto1);

        UserDto userDto2 = new UserDto();
        userDto2.setId("e3220a20-9107-4d61-bb2a-a52790e99554");
        userDto2.setLogin("wwq");
        dummys.add(userDto2);

        return dummys;
    }
}

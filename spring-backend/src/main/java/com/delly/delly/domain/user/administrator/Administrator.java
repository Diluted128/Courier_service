package com.delly.delly.domain.user.administrator;

import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.user.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Administrator extends User {

    public Administrator(String login, String password, Role role) {
        super(login, password, role);
    }
}

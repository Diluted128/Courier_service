package com.delly.delly.domains.application;

import com.delly.delly.domains.company.CompanyType;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull
    private String email;

    @NotNull
    private CompanyType type;

    @Nullable
    private String phoneNumber;

    @NotNull
    private String senderName;

}

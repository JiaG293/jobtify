/*
package com.jobtify.config;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DataLoader {

    PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_USER_NAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "admin";

    @Bean
    @ConditionalOnProperty(
            prefix = "spring",
            value = "datasource.driver-class-name",
            havingValue = "org.postgresql.Driver")
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
        log.info("Initializing application.....");
        return args -> {
            if (userRepository.findByUsername(ADMIN_USER_NAME).isEmpty()) {

                Role userCandidate = roleRepository.save(Role.builder()
                        .name(PredefinedRole.USER_CANDIDATE_ROLE)
                        .description("User candidate role")
                        .build());

                Role adminRole = roleRepository.save(Role.builder()
                        .name(PredefinedRole.ADMIN_ROLE)
                        .description("Admin role")
                        .build());

                Role userCompanyRole = roleRepository.save(Role.builder()
                        .name(PredefinedRole.USER_COMPANY_ROLE)
                        .description("User company role")
                        .build());

                var roles = new HashSet<Role>();
                roles.add(adminRole);
                roles.add(userCandidate);
                roles.add(userCompanyRole);

                User user = User.builder()
                        .email("admin@gmail.com")
                        .phone("1111111111")
                        .address("Ho Chi Minh")
                        .firstName("admin")
                        .lastName("admin1")
                        .dob(LocalDate.now())
                        .username(ADMIN_USER_NAME)
                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
                        .roles(roles)
                        .build();

                userRepository.save(user);
                log.warn("user: admin \n password: admin");
            }
            log.info("Application initialization completed .....");
        };
    }
}*/

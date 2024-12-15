package org.example.kursovabd.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        //UserDetails для предоставления информации про юзера
//        UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN").build();
//        UserDetails user = User.builder().username("user").password(encoder.encode("1111")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new MyUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //возвращает кодировщик

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/","/register", "/login").permitAll() // Разрешить доступ всем к странице /register
                        .anyRequest().authenticated() // Требовать аутентификацию для всех остальных запросов
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout") // Указать URL для выхода
                        .logoutSuccessUrl("/login?logout") // Перенаправление на страницу логина после выхода
                        .permitAll() // Разрешить доступ к выходу всем
                ).build();

//        return http.csrf(AbstractHttpConfigurer::disable) //защита от подмены пользователя
//                .authorizeHttpRequests (authorizeHttpRequests -> authorizeHttpRequests
//                .requestMatchers("/", "/register/", "/login").permitAll() //доступ без регистрации
//                .requestMatchers("/").authenticated() //доступ авторизированным
//
//
//                        .requestMatchers("/blabla/**").permitAll()
////доступ для всех (в данном случае учитываются все пути, которые начинаются с этой строки)
//                        .requestMatchers("/deny-all").denyAll()
////закрыть доступ для всех
//
//                        .requestMatchers("/anonymous").anonymous()
////доступ только не авторизированным
//
//                        .requestMatchers("/remember-me").rememberMe()
////доступ для тех, кто уже был зареган и зашёл опять, восстановленная сессия
//                        .requestMatchers("/fully-authenticated").fullyAuthenticated()
//
//                        .requestMatchers("/has-view-authority").hasAuthority("view")
//                        //хес ауторити, доступ только тем у кого есть такое полномочие
//                        .requestMatchers("/has-update-or-delete-authority").hasAnyAuthority ("update", "delete")
////доступ только тем у кого есть любое из указанных полномочий
//                        .requestMatchers("/has-admin-role").hasRole("admin")
//// доступ у кого есть роль
//                        .requestMatchers("/has-customer-or-manager-role").hasAnyRole("customer", "manager")
////доступ у кого есть роль из списка
//                        .requestMatchers("/has-access").access ((authentication, object) ->
//
//                                new AuthorizationDecision("c.norris".equals(authentication.get().getName())))
//
//        ).build();
    }










//    @Autowired
//    UserService userService;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf().disable().authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/registration").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/news").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                .antMatchers("/", "/resources/**").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
//    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
//    }
//
//
//    @Override
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("jam")
//                .password("pass")
//                .roles("ADMIN")
//                .and()
//                .withUser("alex")
//                .password("pass")
//                .roles("USER");
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//
//                .antMatchers("/admin").hasRole("ADMIN")
//
//                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
//
//                .antMatchers("/hello").permitAll()
//
//                .and().formLogin();
//    }


}
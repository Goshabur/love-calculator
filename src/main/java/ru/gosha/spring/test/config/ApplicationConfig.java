package ru.gosha.spring.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.gosha.spring.test.formatter.PhoneNumberFormatter;

import java.util.Properties;
import java.util.logging.Logger;

@EnableWebMvc
@Configuration
@ComponentScan({"ru.gosha.spring.test.controllers" , "ru.gosha.spring.test.service", "ru.gosha.spring.test.api", "ru.gosha.spring.test.exception"})
@PropertySource("classpath:email.properties")
public class ApplicationConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env; // we use it to access our prop file which we mentioned in @PropertySource
    Logger logger = Logger.getLogger(ApplicationConfig.class.getName());

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost(env.getProperty("mail.host"));
        javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
        javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
        javaMailSenderImpl.setPort(getIntProperty("mail.port"));

        javaMailSenderImpl.setJavaMailProperties(getMailProperty());

        return javaMailSenderImpl;
    }

    private Properties getMailProperty() {
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.starttls.enable", true);
//        mailProperties.put("mail.smtp.auth", true);
//        mailProperties.put("mail.smtp.starttls.required", true);
        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return mailProperties;
    }

    public int getIntProperty(String key){
        return Integer.parseInt(env.getProperty(key));
    }


    @Bean
    public MessageSource messageSource() {//MessageSource - интерфейс предоставляемый спрингом, чтобы подгружать property файлы, т.е. мы говорим спрингу
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();// "Хэй, бро, здесь лежат наши сообщения"
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {// этот бин нам нужен, чтобы сказать спрингу, что мы ему надо использовать именно этот source
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();// т.е. наши сообщения ему надо тянуть именно отсюда
        localValidatorFactoryBean.setValidationMessageSource(messageSource());
        return localValidatorFactoryBean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {//добавляем formatter, но это также можно сделать с помощью метода initBinder
        System.out.println("Inside addFormatter method");
        registry.addFormatter(new PhoneNumberFormatter());
    }

    @Override
    public Validator getValidator() {//Говорит, что нам нужно использовать именно это validator
        return validator();
    }
}

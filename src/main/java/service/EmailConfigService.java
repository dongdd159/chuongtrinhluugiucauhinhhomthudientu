package service;

import model.EmailConfig;

public class EmailConfigService{
    public static EmailConfig config;
    static {
        config = new EmailConfig("English",25,false,"Thor King,Asgard");
    }

    public EmailConfig getConfig() {
        return config;
    }

    public void setConfig(EmailConfig config) {
        this.config = config;
    }
}

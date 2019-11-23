package by.it.advertproject.command;

public enum CommandUrlBuilder {
    TO_CREATE_ADVERT_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_create_advert";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            System.out.println("from CommandUrlBuilder\tTO_CREATE_ADVERT_PAGE enum)" +
                    " setParams. params: " + params);
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            System.out.println("from CommandUrlBuilder\tTO_CREATE_ADVERT_PAGE enum) getUrl. " +
                    "COMMAND_URL + params: " + COMMAND_URL + params);
            return COMMAND_URL + params;
        }
    },
    TO_EDIT_USER_PROFILE_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_edit_profile";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            System.out.println("from CommandUrlBuilder\tTO_EDIT_USER_PROFILE_PAGE enum)" +
                    " setParams. params: " + params);
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            System.out.println("from CommandUrlBuilder\tTO_USER_PROFILE_PAGE enum) getUrl. " +
                    "COMMAND_URL + params: " + COMMAND_URL + params);
            return COMMAND_URL + params;
        }
    },
    TO_USER_PROFILE_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_user_profile";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            System.out.println("from CommandUrlBuilder\tTO_USER_PROFILE_PAGE enum)" +
                    " setParams. params: " + params);
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            System.out.println("from CommandUrlBuilder\tTO_USER_PROFILE_PAGE enum) getUrl. " +
                    "COMMAND_URL + params: " + COMMAND_URL + params);
            return COMMAND_URL + params;
        }
    },
    TO_SIGN_UP_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_sign_up";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;

            System.out.println("from CommandUrlBuilder\tTO_SIGN_UP_PAGE enum)" +
                    " setParams. params: " + params);

            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            System.out.println("from CommandUrlBuilder\tTO_SIGN_UP_PAGE enum) getUrl. " +
                    "COMMAND_URL + params: " + COMMAND_URL + params);
            return COMMAND_URL + params;
        }
    },
    TO_PERSONAL_PAGE {

        private static final String COMMAND_URL = "/controller?command=to_main";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            return COMMAND_URL + params;
        }
    },
    TO_LOGIN {
        private static final String COMMAND_URL = "/controller?command=TO_SIGN_IN";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            System.out.println(" from CommandUrlBuilder. TO_LOGIN. SetParams. params: " + params);
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            System.out.println(" from CommandUrlBuilder. TO_LOGIN. getUrl. url: " + COMMAND_URL + params);
            return COMMAND_URL + params;
        }
    },
    TO_REGISTRATION {

        private static final String COMMAND_URL = "/controller?command=to_registration";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            return COMMAND_URL + params;
        }
    },
    TO_SETTING {
        private static final String COMMAND_URL = "/controller?command=to_setting";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            return COMMAND_URL + params;
        }
    },
    TO_ERROR {
        private static final String COMMAND_URL = "/controller?command=to_error";
        private String params = "";

        public CommandUrlBuilder setParams(String name, String param) {
            params = params + "&" + name + "=" + param;
            return this;
        }

        public String getUrl() {
            String params = this.params;
            this.params = "";
            return COMMAND_URL + params;
        }
    };

    public abstract CommandUrlBuilder setParams(String name, String param);

    public abstract String getUrl();

}

package by.it.advertproject.command;

public enum CommandUrlBuilder {
    TO_USER_PROFILE_PAGE {
        private static final String COMMAND_URL = "/controller?command=forward_to_user_profile";
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
        private static final String COMMAND_URL = "/controller?command=forward_to_sign_up";
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

        private static final String COMMAND_URL = "/controller?command=to_personal_page";
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

//        private static final String COMMAND_URL = "/controller?command=to_login";
        private static final String COMMAND_URL = "/controller?command=FORWARD_TO_SIGN_IN";
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

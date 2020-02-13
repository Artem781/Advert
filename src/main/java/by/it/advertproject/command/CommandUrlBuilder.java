package by.it.advertproject.command;

public enum CommandUrlBuilder {
    TO_CREATE_ADVERT_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_create_advert";
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
    TO_SIGN_IN {
        private static final String COMMAND_URL = "/controller?command=to_sign_in";
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
    TO_EDIT_USER_PROFILE_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_edit_profile";
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
    TO_USER_PROFILE_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_user_profile";
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
    TO_SIGN_UP_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_sign_up";
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
    TO_MAIN_PAGE {
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
    TO_ADMIN_PROFILE_PAGE {
        private static final String COMMAND_URL = "/controller?command=to_admin_profile";
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

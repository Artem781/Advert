package by.it.advertproject.command;

public enum CommandUrlBuilder {
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

        private static final String COMMAND_URL = "/controller?command=to_login";
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
    },
    TO_FIND_POSTS {
        private static final String COMMAND_URL = "/controller?command=TO_FIND_POSTS";
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

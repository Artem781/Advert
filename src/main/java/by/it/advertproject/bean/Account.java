package by.it.advertproject.bean;

import java.util.Arrays;
import java.util.Objects;

public class Account extends Bean {

    static final long serialVersionUID = 42L;
    private String name;
    private String login;
    private String password;
    private String birthday;
    private String email;
    private String tel;
    private Role role;
    private byte[] photo = new byte[0];

    public Account() {
    }

    public Account(String name, String login, String password, String birthday, String email, String tel, Role role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.tel = tel;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", role=" + role +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == null) return false;
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        if (!super.equals(o)) return false;
        Account account = (Account) o;
        return Objects.equals(getName(), account.getName()) &&
                Objects.equals(getLogin(), account.getLogin()) &&
                Objects.equals(getPassword(), account.getPassword()) &&
                Objects.equals(getBirthday(), account.getBirthday()) &&
                Objects.equals(getEmail(), account.getEmail()) &&
                Objects.equals(getTel(), account.getTel()) &&
                getRole() == account.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getLogin(), getPassword(), getBirthday(), getEmail(), getTel(), getRole());
    }

    public static class Builder {
        private Account account;

        public Builder() {
            this.account = new Account();
        }

        public Builder withIdAccount(long id) {
            account.setId(id);
            return this;
        }

        public Builder withName(String name) {
            account.name = name;
            return this;
        }

        public Builder withLogin(String login) {
            account.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            account.password = password;
            return this;
        }

        public Builder withBirthday(String dateOfBirth) {
            account.birthday = dateOfBirth;
            return this;
        }

        public Builder withEmail(String email) {
            account.email = email;
            return this;
        }

        public Builder withTel(String tel) {
            account.tel = tel;
            return this;
        }

        public Builder withRole(Role role) {
            account.role = role;
            return this;
        }

        public Builder withPhoto(byte[] photo) {
            account.photo = photo;
            return this;
        }

        public Account build() {
            return account;
        }
    }
}

package dao;

public class Account {

    private Integer accountId;
    private String username;
    private String password;
    private String fullName;
    private String role;
    private String phone;

    public Account() {
    }

    public Account(String username, String password, String fullName, String role, String phone) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.phone = phone;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        super.toString();
        return "Account{" + "accountId=" + accountId + ", username=" + username + ", password=" + password + ", fullName=" + fullName + ", phone=" + phone + ", role=" + role + '}';
    }
}

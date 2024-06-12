/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author caosy
 */
public class UserLogin {

    private static Integer accountId;
    private static String username;
    
    public static Integer getAccountId() {
        return accountId;
    }

    public static void setAccountId(Integer accountId) {
        UserLogin.accountId = accountId;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserLogin.username = username;
    }

}

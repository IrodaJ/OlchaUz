package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements BaseService{
    static List<User> users=new ArrayList<>();
    public void showList(){
        for (User user:users) {
            if (user!=null){
                System.out.println(user);
            }
        }
    }
    public User login(String phoneNumber, String password){
        for (User user: users) {
            if(user!=null){
                if(user.getPhoneNumber()==phoneNumber && user.getPassword()==password){
                    return user;
                }
            }
        }
        return null;
    }

    public boolean add(User user){
        for (User user1:users) {
            if(user1.getPhoneNumber().equals(user.getPhoneNumber()))
                return false;
        }
        users.add(user);
        return true;
    }

    @Override
    public boolean delete(int id) {
        for (User user:users) {
            if (user!=null){
                if (user.getId()==id){
                    users.remove(user);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getById(int id) {
        for (User user:users) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }
}

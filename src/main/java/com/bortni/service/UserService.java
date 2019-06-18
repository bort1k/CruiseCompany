package com.bortni.service;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.dao.mysql.MySqlUserDao;
import com.bortni.exceptions.EmailAlreadyExistException;
import com.bortni.exceptions.ReadException;
import com.bortni.exceptions.UserDoesNotExist;
import com.bortni.model.User;

public class UserService {
    private GenericDao genericDao;

    public UserService() {
        DaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(User.class);
    }

    public void createUser(User user) throws EmailAlreadyExistException {
        try{
            boolean isEmailExist = ((MySqlUserDao)genericDao).isEmailExist(user.getEmail());
            if (isEmailExist){
                throw new EmailAlreadyExistException("Email is already exist");
            }
            ((MySqlUserDao)genericDao).create(user);
        }
        catch (ReadException e){
            e.printStackTrace();
        }
    }

    public User getUserById(int id){
        try {
            return (User) genericDao.getByPK(id);
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isUserExist(String email, String password) throws UserDoesNotExist {
        boolean exist = false;
        try {
            exist = ((MySqlUserDao)genericDao).isExist(email, password);
            if(!exist){
                throw new UserDoesNotExist("User does not exist");
            }
        }
        catch (ReadException e){
            e.printStackTrace();
        }
        return exist;
    }

    public boolean isEmailExist(String email) throws EmailAlreadyExistException {
        boolean exist = true;
        try{
            exist = ((MySqlUserDao)genericDao).isEmailExist(email);
            if(exist){
                throw new EmailAlreadyExistException("Email already exists");
            }
        } catch (ReadException e) {
            e.printStackTrace();
        }

        return exist;
    }

    public User getUserByEmailAndPassword(String email, String password){
        User user;
        try {
            user = ((MySqlUserDao)genericDao).getUserByEmailAndPassword(email,password);
            return user;
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

}

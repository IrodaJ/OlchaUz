package service;

import model.User;

import java.util.List;

public interface BaseService {

    boolean delete(int id);
    Object getById(int id);
}

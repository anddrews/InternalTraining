package com.epam.by.pojo.IFaces;

import com.epam.by.pojo.model.UserEntity;

public interface IDao {
	UserEntity getUser(String login, String passw);
}

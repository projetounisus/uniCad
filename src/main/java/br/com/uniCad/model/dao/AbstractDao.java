package br.com.uniCad.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.uniCad.constants.Constants;

public abstract class AbstractDao {
	
	public AbstractDao(Class<?> currentBeanClass){
		this.currentClassBean = currentBeanClass;
	}
	
	//TODO: tonalo private,ç fazer um getter para isso
	protected Class<?> currentClassBean;
	
	private static Connection connectionSingleton;
	
	protected Connection getConnection() throws SQLException, ClassNotFoundException {
		if(AbstractDao.connectionSingleton == null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			AbstractDao.connectionSingleton = DriverManager.getConnection(Constants.connectionString, Constants.userNameDataBase, Constants.userPasswordDataBase);
		}
		return AbstractDao.connectionSingleton;
	}
	
	protected abstract String getTableName();
	
}

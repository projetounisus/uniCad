package br.com.uniCad.model.dao.beans;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.Login;
import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.auxiliarData.AbstractDaoAuxiliar;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.UserDeserializer;

public class UserDao extends AbstractDaoBean<User>{

	public UserDao() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "usuario";
	}

	@Override
	protected AbstractDeserializer<User> getDeserializer() {
		// TODO Auto-generated method stub
		return new UserDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("endereco", "address");
		map.put("dt_nascimento", "birthDate");
		map.put("login", "login");
		map.put("telefone", "telephone");
		map.put("nome", "completeName");
		map.put("genero", "genre");
		
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void deleteInheritance(AbstractBean bean) throws DoesntHaveInheritence {
		throw new DoesntHaveInheritence();
	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public User getUserByLogin(Login login) throws ClassNotFoundException, SQLException{
		Connection currentConnection = this.getConnection();
		
		DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);
		
		Field field = field("login");
		Result<Record> result = query.select().from(table(getTableName())).where(field.equal(login.getId())).fetch();
		
		Record record = result.get(0);
		
		UserDeserializer deserializer = (UserDeserializer)this.getDeserializer();
		User deserializedRecord = deserializer.fromDataBaseRecord(record);
		
		return deserializedRecord;
	}

	@Override
	protected void deleRelatedTables(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected AbstractDaoAuxiliar getDaoAuxiliar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updateInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		
	}
}

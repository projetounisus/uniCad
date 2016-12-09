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
import br.com.uniCad.model.dao.auxiliarData.AbstractDaoAuxiliar;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.LoginDeserializer;

public class LoginDao extends AbstractDaoBean<Login> {

	public LoginDao() {
		super(Login.class);
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "login";
	}

	@Override
	protected AbstractDeserializer getDeserializer() {
		// TODO Auto-generated method stub
		return new LoginDeserializer();
	}

	@Override
	public Map getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("nome_usuario", "userName");
		map.put("senha_usuario", "userPassword");
		
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
	
	public Login getByUserName(String userName){
		Connection currentConnection;
		try {
			currentConnection = getConnection();
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);
			
			Field<Object> field = field("nome_usuario");
			Result<Record> result = query.select().from(table(getTableName())).where(field.equal(userName)).fetch();
			
			Record record = result.get(0);
			
			LoginDeserializer deserializer = (LoginDeserializer)this.getDeserializer();
			Login deserializedRecord = deserializer.fromDataBaseRecord(record);
			
			return deserializedRecord;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;	
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

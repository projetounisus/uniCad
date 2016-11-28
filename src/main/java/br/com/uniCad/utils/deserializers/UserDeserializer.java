package br.com.uniCad.utils.deserializers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.Address;
import br.com.uniCad.model.beans.Login;
import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.AddressDao;
import br.com.uniCad.model.dao.LoginDao;

public class UserDeserializer extends AbstractDeserializer<User>{

	@Override
	public List<User> fromDataBaseResult(Result<Record> data) {
		final List<User> deserialized = new ArrayList<User>();
		
		for(Record current : data){
			deserialized.add(this.fromDataBaseRecord(current));
		}
		
		return deserialized;
	}

	@Override
	public User fromDataBaseRecord(Record record) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String id = record.get("id").toString();
		String birthDate = record.get("dt_nascimento").toString();
		String enderecoId = record.get("endereco").toString();
		String loginId = record.get("login").toString();
		String genre = record.get("genero").toString();
		
		AddressDao addressDao = new AddressDao();
		Address address = (Address)addressDao.getById(Integer.parseInt(enderecoId));
		
		LoginDao loginDao = new LoginDao();
		Login login = (Login)loginDao.getById(Integer.parseInt(loginId));
		
		try {
			User deserializedUser =  new User(
				Integer.parseInt(id),
				(String)record.get("nome"),
				(String)record.get("telefone"),
				format.parse(birthDate),
				address, 
				login, 
				genre);
			
			return deserializedUser;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null; //FIXME: levantar exce��es e parar de retornar null
	}
	
}

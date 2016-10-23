package br.com.uniCad.utils.deserializers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.Address;
import br.com.uniCad.beans.Login;
import br.com.uniCad.beans.User;
import br.com.uniCad.dao.AddressDao;
import br.com.uniCad.dao.LoginDao;

public class UserDeserializer extends Deserializer<User>{

	@Override
	public List<User> fromDataBaseResult(Result<Record> data) {
		// TODO: Aplicar dynamic functions do java8 para melhor legibilidade
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
				login);
			
			return deserializedUser;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null; //FIXME: levantar exceções e parar de retornar null
	}
	
}

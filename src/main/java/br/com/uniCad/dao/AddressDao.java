package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.Address;
import br.com.uniCad.utils.deserializers.AddressDeserializer;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;

public class AddressDao extends AbstractDao<Address> {

	public AddressDao() {
		super(Address.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "endereco";
	}

	@Override
	protected AbstractDeserializer getDeserializer() {
		// TODO Auto-generated method stub
		return new AddressDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("pais", "country");
		map.put("uf", "uf");
		map.put("cidade", "city");
		map.put("bairro", "neighborhood");
		map.put("rua", "street");
		map.put("ponto_referencia", "adtionalInfo");
		
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return false;
	}
}

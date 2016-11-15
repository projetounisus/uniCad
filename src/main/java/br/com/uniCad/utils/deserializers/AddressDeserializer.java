package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.Address;

public class AddressDeserializer extends AbstractDeserializer<Address> {

	@Override
	public List<Address> fromDataBaseResult(Result<Record> result) {
		// TODO Auto-generated method stub
		List<Address> deserializedData = new ArrayList<Address>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public Address fromDataBaseRecord(Record record) {
		// TODO Auto-generated method stub
		Object id = record.get("id");
		Object numero = record.get("numero");
		String number = numero == null? "0" : numero.toString();
		Object referenceAddress = record.get("ponto_referencia");
		String referenceAddressStr = referenceAddress != null? referenceAddress.toString() : " ";
		Address address = new Address(Integer.parseInt(id.toString()),
				record.get("pais").toString(),
				record.get("uf").toString(),
				record.get("cidade").toString(), 
				record.get("bairro").toString(),
				record.get("rua").toString(),
				Integer.parseInt(number),
				referenceAddressStr);
		
		return address;
	}

}

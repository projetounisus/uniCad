package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.CurrentMedicStatus;

public class CurrentMedicStatusDeserializer extends AbstractDeserializer<CurrentMedicStatus> {

	@Override
	public List<CurrentMedicStatus> fromDataBaseResult(Result<Record> result) {
		List<CurrentMedicStatus> deserializedData = new ArrayList<CurrentMedicStatus>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public CurrentMedicStatus fromDataBaseRecord(Record record) {
		String idStr = record.get("id").toString();
		String bloodType = record.get("tipo_saguineo").toString();
		String weightStr = record.get("peso").toString();
		String heightStr = record.get("altura").toString();
		String allergies = record.get("alergia").toString();
		String currentTreatment = record.get("tratamentos_atuais").toString();
		
		CurrentMedicStatus currentMedicStatus = new CurrentMedicStatus(
				Integer.parseInt(idStr),
				bloodType,
				allergies, 
				currentTreatment, 
				Float.parseFloat(heightStr),
				Float.parseFloat(weightStr));
		
		return currentMedicStatus;
	}

}
